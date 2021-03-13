package config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:${environment}.properties")
public interface TestLaunchConfig extends Config {
    @Key("webDriver.url")
    String webDriverUrl();

    @Key("browser.name")
    String browserName();

    @Key("browser.version")
    int browserVersion();
}
