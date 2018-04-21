package util;

import java.io.IOException;
import java.util.Properties;

public class PropertyLoader {

    private static final String PROP_FILE = "/test.properties";

    private PropertyLoader() {}

    public static String loadTestProperty(String name) {
        Properties props = new Properties();
        try {
            props.load(util.PropertyLoader.class.getResourceAsStream(PROP_FILE));
        } catch (IOException e) {
                e.printStackTrace();
        }

        String value = "";

        if (name != null) {
            value = props.getProperty(name);
        }
        return value;
    }
}
