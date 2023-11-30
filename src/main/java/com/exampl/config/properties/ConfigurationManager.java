package com.exampl.config.properties;

import org.aeonbits.owner.ConfigCache;

public final class ConfigurationManager {
    private ConfigurationManager() {
    }

    public static PropConfiguration getConfiguration() {
        return ConfigCache.getOrCreate(PropConfiguration.class);
    }
}
