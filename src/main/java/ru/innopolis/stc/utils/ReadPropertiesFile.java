package ru.innopolis.stc.utils;

import org.apache.log4j.Logger;
import ru.innopolis.stc.controller.StartPage;

import java.util.ResourceBundle;

public class ReadPropertiesFile {
    private final static Logger LOGGER = Logger.getLogger(StartPage.class);

    public String getProperty(String fileName, String propertyName) {
        String property = null;
        try {
            ResourceBundle resourceBundle = ResourceBundle.getBundle(fileName);
            property = resourceBundle.getString(propertyName);
        } catch (Exception e) {
            LOGGER.error("Error retrieving properties file: " + e);
        }
        return property;
    }
}
