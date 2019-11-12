import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;
import java.util.Set;

public class TestPropertiesExplorer {
    private void createProperties() {
        try (OutputStream output = new FileOutputStream("C:\\properties\\test.properties")) {
            Properties prop = new Properties();
            prop.setProperty("db.url", "localhost");
            prop.setProperty("db.user", "viruskuls");
            prop.setProperty("db.password", "password123");

            prop.store(output, null);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void testReading() {
        createProperties();
        try {
            PropertiesExplorer explorer = new PropertiesExplorer("C:\\properties\\test.properties");
            assert explorer.getContent().containsKey("db.url");
            assert explorer.getContent().containsKey("db.user");
            assert explorer.getContent().containsKey("db.password");

            assert explorer.getContent().get("db.url").equals("localhost");
            assert explorer.getContent().get("db.user").equals("viruskuls");
            assert explorer.getContent().get("db.password").equals("password123");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void testMapChangedAndStore() {
        createProperties();
        try {
            PropertiesExplorer explorer = new PropertiesExplorer("C:\\properties\\test.properties");
            explorer.setProperty("db.state", "VALID");
            explorer.setProperty("db.maintainer", "Arthur");
            explorer.setProperty("db.size", "534");

            assert explorer.getContent().get("db.state").equals("VALID");
            assert explorer.getContent().get("db.maintainer").equals("Arthur");
            assert explorer.getContent().get("db.size").equals("534");

            explorer.store(new FileOutputStream("C:\\properties\\stored.properties"), null);
            PropertiesExplorer stored = new PropertiesExplorer("C:\\properties\\stored.properties");

            assert stored.getContent().size() == 6;
            assert stored.getContent().get("db.url").equals("localhost");
            assert stored.getContent().get("db.user").equals("viruskuls");
            assert stored.getContent().get("db.password").equals("password123");
            assert stored.getContent().get("db.state").equals("VALID");
            assert stored.getContent().get("db.maintainer").equals("Arthur");
            assert stored.getContent().get("db.size").equals("534");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Test
    public void testKeys() {
        createProperties();
        try {
            PropertiesExplorer explorer = new PropertiesExplorer("C:\\properties\\test.properties");

            Set<String> correctSet = Set.of("db.url", "db.user", "db.password");

            assert correctSet.equals(explorer.stringPropertyNames());
            assert correctSet.equals(explorer.getContent().keySet());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
