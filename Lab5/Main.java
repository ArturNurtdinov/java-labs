import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class Main {
    private static final String configFile = "C:\\properties\\config.properties";

    public static void main(String[] args) {
        try (OutputStream output = new FileOutputStream(configFile)) {
            Properties prop = new Properties();
            prop.setProperty("db.url", "localhost");
            prop.setProperty("db.user", "viruskuls");
            prop.setProperty("db.password", "password123");

            prop.store(output, null);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        try {
            PropertiesExplorer explorer = new PropertiesExplorer(configFile);
            System.out.println(explorer.getContent());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}