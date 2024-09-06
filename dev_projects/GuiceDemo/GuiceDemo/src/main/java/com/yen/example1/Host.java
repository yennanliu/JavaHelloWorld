package com.yen.example1;

import com.google.inject.Inject;

public class Host {

    private Animal animal;

    /**
     *  NOTE !!!
     *
     *   instead of using regular constructor
     *   below we use @Inject tells Guice
     *   that Host class is NOT meant to be
     *   instantiated explicitly,
     *   instead, it should be injected and called by Guice
     *
     *  (also note that constructor is NOT set as public means it's not for instantiated directly)
     */
//    public Host(Animal animal){
//        this.animal = animal;
//    }

    @Inject
    Host(Animal animal){
        this.animal = animal;
    }

    public Animal getAnimal() {
        return animal;
    }
}
