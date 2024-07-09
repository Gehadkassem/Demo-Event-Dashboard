package configration;

import ch.qos.logback.core.Context;
import io.github.cdimascio.dotenv.Dotenv;
import io.github.cdimascio.dotenv.DotenvEntry;

import java.util.Properties;

public class LoadProperties {
    public static Context env;

//    public static Properties env = loadProperties();

//    private static <Dotenv> Properties loadProperties() {
//        Properties properties = new Properties();
//        Dotenv dotenv = Dotenv.configure()
//                .directory(System.getProperty("user.dir") + "/")
//                .filename(".env").load();
//
//        for (DotenvEntry entry : dotenv.entries()) {
//            properties.put(entry.getKey(), entry.getValue());
//        }
//
//        return properties;
//    }

}
