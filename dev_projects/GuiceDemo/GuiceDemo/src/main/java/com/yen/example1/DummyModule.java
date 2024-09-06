package com.yen.example1;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;

public class DummyModule extends AbstractModule {

//    @Override
//    protected void configure() {
//       // super.configure();
//    }

    /**
     * Provides demo
     *
     *  via Provides. we can provide complex class init
     *  within the class with @Provides annotation,
     *  when the class is called, all dependent classed
     *  will be init by Guice
     */
    // not directly used, but it's needed to for code in GuiceApp.java
    // e.g. : ThirdPartyClass thirdPartyClass = injector3.getInstance(ThirdPartyClass.class);
    @Provides
    ThirdPartyClass provideThirdPartyClass() {
//        ThirdPartyClass thirdPartyClass = new ThirdPartyClass();
//        thirdPartyClass.create();
        return ThirdPartyClass.create();
    }

}
