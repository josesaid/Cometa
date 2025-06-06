package com.baeldung;

import org.springframework.stereotype.Component;

@Component
public class Service {

    @LogExecutionTime
    @ValidationBehavior
    public void xValidation() throws InterruptedException {
        Thread.sleep(1* 1500);
        System.out.println("xValidation");
    }

    @LogExecutionTime
    @ValidationBehavior
    public void yValidation() throws InterruptedException {
        Thread.sleep(1* 1500);
        System.out.println("yValidation");
    }
}
