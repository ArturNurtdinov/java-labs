import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Paths;
import java.util.Properties;

public class Main {

    public static void main(String[] args) {
        final String configFile = Paths.get("config.properties").toAbsolutePath().toString();
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