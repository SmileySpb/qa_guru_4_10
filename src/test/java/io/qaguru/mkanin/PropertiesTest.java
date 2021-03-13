package io.qaguru.mkanin;

import config.TestLaunchConfig;
import org.aeonbits.owner.ConfigFactory;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;


public class PropertiesTest {
    private final TestLaunchConfig config = ConfigFactory.create(TestLaunchConfig.class, System.getProperties());

    @Test
    @Tag("local")
    void localPropertiesTest() {
        SoftAssertions assertions = new SoftAssertions();
        assertions.assertThat(config.browserName().equals("Chrome")).isTrue();
        assertions.assertThat(config.browserVersion() == 87).isTrue();
        assertions.assertAll();
    }

    @Test
    @Tag("remote")
    void remotePropertiesTest() {
        SoftAssertions assertions = new SoftAssertions();
        assertions.assertThat(config.browserName().equals("Chrome")).isTrue();
        assertions.assertThat(config.browserVersion() == 85).isTrue();
        assertions.assertThat(config.webDriverUrl().equals("https://user1:1234@selenoid.autotests.cloud:4444/wd/hub/"));
        assertions.assertAll();
    }
}
