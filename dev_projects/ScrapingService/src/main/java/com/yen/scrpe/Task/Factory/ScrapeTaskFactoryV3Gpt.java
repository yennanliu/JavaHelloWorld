package com.yen.scrpe.Task.Factory;

import com.yen.scrpe.Task.BaseScrapeTask;
import com.yen.scrpe.service.BaseScrapeService;

import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

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
        try {
            // Submit the task to the executor service
            Future<?> future = executorService.submit(() -> {
                try {
                    this.scrapeTask.run(this.limit);
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
            });

            // Wait for the task to complete
            future.get(); // Blocking call to ensure the task is complete
        } catch (Exception e) {
            e.printStackTrace();
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