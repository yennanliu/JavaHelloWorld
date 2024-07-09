package com.yen.scrpe.Task;

import java.io.IOException;

public interface BaseScrapeTask {

  void run(int limit) throws IOException, InterruptedException;
}
