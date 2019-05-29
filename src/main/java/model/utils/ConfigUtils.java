package model.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.Properties;

public class ConfigUtils {
    private static final Properties property = new Properties();
    private static final Logger logger = LogManager.getLogger(ConfigUtils.class);

    private ConfigUtils() {}

    public static String getProperty(Class aClass, String key) throws IOException {
        logger.info("loading property " + key);
        load(aClass);
        return property.getProperty(key);
    }

    public static void setProperty(Class aClass, String key, String value) throws IOException {
        logger.info("setting property " + key + "=" + value);
        load(aClass);
        property.setProperty(key, value);
    }

    private static void load(@org.jetbrains.annotations.NotNull Class aClass) throws IOException {
        property.load(aClass.getClassLoader().getResourceAsStream("project.properties"));
    }
}
