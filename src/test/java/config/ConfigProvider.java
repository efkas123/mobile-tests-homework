package config;

import org.aeonbits.owner.ConfigFactory;

public class ConfigProvider {

    private ConfigProvider() {} //question Что тут происходит?

    public static AndroidConfig getConfig() { //И тут
            return ConfigFactory.create(AndroidConfig.class);
    }
}
