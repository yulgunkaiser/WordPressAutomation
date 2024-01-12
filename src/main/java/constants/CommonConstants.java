package constants;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class CommonConstants {

    public static final String WORDPRESS_DEMO_LANDING_URL = readProperties("wordpress.demo.landing.url");
    public static String readProperties(String propertyKey) {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("src/main/resources/application.properties"));
        }catch (IOException e){
            e.printStackTrace();
        }
        return properties.getProperty(propertyKey);
    }
}
