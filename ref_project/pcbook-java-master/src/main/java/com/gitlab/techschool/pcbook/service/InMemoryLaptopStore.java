package com.gitlab.techschool.pcbook.service;

import com.gitlab.techschool.pcbook.pb.Filter;
import com.gitlab.techschool.pcbook.pb.Laptop;
import com.gitlab.techschool.pcbook.pb.Memory;
import io.grpc.Context;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class InMemoryLaptopStore implements LaptopStore {
    private static final Logger logger = Logger.getLogger(InMemoryLaptopStore.class.getName());

    private ConcurrentMap<String, Laptop> data;

    public InMemoryLaptopStore() {
        data = new ConcurrentHashMap<>(0);
    }

    @Override
    public void Save(Laptop laptop) throws Exception {
        if (data.containsKey(laptop.getId())) {
            throw new AlreadyExistsException("laptop ID already exists");
        }

        // deep copy
        Laptop other = laptop.toBuilder().build();
        data.put(other.getId(), other);
    }

    @Override
    public Laptop Find(String id) {
        if (!data.containsKey(id)) {
            return null;
        }

        // deep copy
        Laptop other = data.get(id).toBuilder().build();
        return other;
    }

    @Override
    public void Search(Context ctx, Filter filter, LaptopStream stream) {
        for (Map.Entry<String, Laptop> entry : data.entrySet()) {
            if (ctx.isCancelled()) {
                logger.info("context is cancelled");
                return;
            }

//            try {
//                TimeUnit.SECONDS.sleep(1);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }

            Laptop laptop = entry.getValue().toBuilder().build();
            if (isQualified(filter, laptop)) {
                stream.Send(laptop);
            }
        }
    }

    private boolean isQualified(Filter filter, Laptop laptop) {
        if (laptop.getPriceUsd() > filter.getMaxPriceUsd()) {
            return false;
        }

        if (laptop.getCpu().getNumberCores() < filter.getMinCpuCores()) {
            return false;
        }

        if (laptop.getCpu().getMinGhz() < filter.getMinCpuGhz()) {
            return false;
        }

        if (toBit(laptop.getRam()) < toBit(filter.getMinRam())) {
            return false;
        }

        return true;
    }

    private long toBit(Memory memory) {
        long value = memory.getValue();

        switch (memory.getUnit()) {
            case BIT:
                return value;
            case BYTE:
                return value << 3;
            case KILOBYTE:
                return value << 13;
            case MEGABYTE:
                return value << 23;
            case GIGABYTE:
                return value << 33;
            case TERABYTE:
                return value << 43;
            default:
                return 0;
        }
    }
}
