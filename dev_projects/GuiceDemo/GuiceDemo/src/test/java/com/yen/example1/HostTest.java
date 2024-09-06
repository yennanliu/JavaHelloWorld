package com.yen.example1;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Inject;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(JUnit4.class)
class HostTest {

    @Inject private Host host;

    @BeforeEach
    //@BeforeAll  // TODO : fix to use @Before
    public void setUp(){
        // NOTE !!! we init to-test class via Guice
        System.out.println("test setup ...");
        Guice.createInjector(new MyTestModule()).injectMembers(this);
    }

    @Test
    public void test_1(){
        System.out.println(123);
    }

    // V1
    @Test
    public void Host_test_1(){

        /** NOTE !!! here */
        Host host = Guice.createInjector(new MyTestModule()).getInstance(Host.class);
        System.out.println(host.getAnimal().eat());

        assertEquals("Dog is eating!", host.getAnimal().eat());
    }


    // V2
    @Test
    public void Host_test_2(){
        assertNotNull(host);
        System.out.println(host);
    }

}

class MyTestModule extends AbstractModule{

    @Override
    protected void configure() {
        //super.configure();
        bind(Animal.class).to(Dog.class);
    }
}