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
     */
    @Provides
    ThirdPartyClass provideThirdPartyClass() {
//        ThirdPartyClass thirdPartyClass = new ThirdPartyClass();
//        thirdPartyClass.create();
        return ThirdPartyClass.create();
    }

}
