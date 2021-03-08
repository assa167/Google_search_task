package company.util;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public final class PropertiesLoader {

    private PropertiesLoader() {}

    public static Properties loadProperties(String prorertyFile) {
        Properties config = new Properties();
        InputStream input;
        try {
            input = new FileInputStream(prorertyFile);
            config.load(input);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return config;
    }
}
