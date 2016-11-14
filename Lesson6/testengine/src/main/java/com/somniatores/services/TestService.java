package com.somniatores.services;

/**
 * Created by locisvv on 14.11.2016.
 */
public interface TestService<Expected, Actual> {
    boolean checkAnswer(Expected expected, Actual actual);
}
