package com.yen;

import com.google.inject.AbstractModule;

// https://youtu.be/fe1n8VIXZ-k?si=LrKQXWec3aGJfCA_&t=271

public class CalculatorModule extends AbstractModule {
  @Override
  protected void configure() {
    // super.configure();
    bind(Calculator.class);
  }

}
