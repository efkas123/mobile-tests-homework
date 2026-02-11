package config;

import org.aeonbits.owner.ConfigFactory;

public class ConfigProvider {
    private static final AndroidConfig config =
            ConfigFactory.create(AndroidConfig.class);

    public static AndroidConfig getConfig() {
        return config;
    }
}

