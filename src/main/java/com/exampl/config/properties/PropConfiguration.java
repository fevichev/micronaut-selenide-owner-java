package com.exampl.config.properties;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config.properties"
})
public interface PropConfiguration extends Config {
    @DefaultValue("https://www.google.com.ua/")
    @Key("base.url")
    String baseUrl();

    @Key("selenoid.url")
    String selenoidUrl();

    @DefaultValue("chrome")
    @Key("browser.name")
    String browserName();

    @Key("remote.run")
    Boolean remoteRun();

    @Key("browser.headless")
    Boolean browserHeadless();
}
