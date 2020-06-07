package helpers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ParametersProvider {

    private static FileInputStream fileInputStream;
    private static Properties properties = new Properties();

    public static String getProperty(final String property) throws IOException {
        fileInputStream = new FileInputStream("./configuration/private.properties");
        properties.load(fileInputStream);
        return properties.getProperty(property);
    }
}
