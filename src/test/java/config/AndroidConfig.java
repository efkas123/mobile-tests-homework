package config;

import org.aeonbits.owner.*;

@Config.Sources({
        "classpath:mobile.properties",
        "system:properties"
})

public interface AndroidConfig extends Config {



    @Key("browserstack.user")
    String browserstackUser();

    @Key("browserstack.key")
    String browserstackKey();

    @Key("app")
    String app();

    @Key("deviceName")
    @DefaultValue("")
    String deviceName();

    @Key("osVersion")
    String osVersion();

    @Key("project")
    String projectName();

    @Key("build")
    String buildName();

    @Key("name")
    String testName();

    @Key("searchQuery")
    @DefaultValue("Appium")
    String searchQuery();
}
