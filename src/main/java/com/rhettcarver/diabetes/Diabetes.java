package com.rhettcarver.diabetes;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Diabetes implements ModInitializer {
    public static final String MOD_ID = "diabetes";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        ModItems.initialize();
        LOGGER.info("Hello Diabetic world!");
    }
}
