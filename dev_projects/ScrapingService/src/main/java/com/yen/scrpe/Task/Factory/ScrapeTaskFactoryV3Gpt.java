package com.yen.scrpe.Task.Factory;

import com.yen.scrpe.Task.BaseScrapeTask;
import com.yen.scrpe.service.BaseScrapeService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ScrapeTaskFactoryV3Gpt {

    private BaseScrapeService scrapeService;
    private BaseScrapeTask scrapeTask;
    private int limit;
    private final ExecutorService executorService;

    // Constructor
    public ScrapeTaskFactoryV3Gpt(BaseScrapeService scrapeService, BaseScrapeTask scrapeTask, Integer limit) {
        this.scrapeService = scrapeService;
        this.scrapeTask = scrapeTask;
        this.limit = limit;
        this.executorService = Executors.newFixedThreadPool(10); // Fixed thread pool with 10 threads
    }

    // Method to run tasks
    public void run() throws IOException, InterruptedException {
        List<Future<?>> futures = new ArrayList<>();
        try {
            // Submit tasks to the executor service
            for (int i = 0; i < limit; i++) {
                Future<?> future = executorService.submit(() -> {
                    try {
                        this.scrapeTask.run(this.limit);
                    } catch (IOException | InterruptedException e) {
                        e.printStackTrace();
                    }
                });
                futures.add(future);
            }

            // Wait for all tasks to complete
            for (Future<?> future : futures) {
                try {
                    if (future.isDone()){
                        Object result = future.get(); // Blocking call to ensure completion
                        System.out.println("---> result = " + result);
                    }
                } catch (ExecutionException e) {
                    System.out.println("exception !!!  " + e.getLocalizedMessage());
                    e.printStackTrace();
                }
            }
        } finally {
            shutdown();
        }
    }

    // Method to shut down the executor service
    private void shutdown() {
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}