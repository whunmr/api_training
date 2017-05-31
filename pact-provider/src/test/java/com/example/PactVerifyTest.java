package com.example;

import au.com.dius.pact.provider.junit.PactRunner;
import au.com.dius.pact.provider.junit.Provider;
import au.com.dius.pact.provider.junit.loader.PactFolder;
import au.com.dius.pact.provider.junit.target.HttpTarget;
import au.com.dius.pact.provider.junit.target.Target;
import au.com.dius.pact.provider.junit.target.TestTarget;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import static org.junit.Assert.assertEquals;

@RunWith(PactRunner.class)
@Provider("Foo_Provider")
@PactFolder("pact-from-consumer/")  //@PactBroker(host = "localhost", port = "80")
public class PactVerifyTest {
    private static ConfigurableApplicationContext application;

    @TestTarget
    public final Target target = new HttpTarget(8080);


    @BeforeClass
    public static void startSpring(){
        application = SpringApplication.run(PactProducerApplication.class);
    }

    @AfterClass
    public static void kill(){
        application.stop();
    }
}
