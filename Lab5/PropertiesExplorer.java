import java.io.*;
import java.util.*;

public class PropertiesExplorer {
    private Properties prop = new Properties();
    private Map<String, String> content = new HashMap<>();


    public PropertiesExplorer(String path) throws IOException {
        prop.load(new FileInputStream(path));
        readToMap();
    }

    public Map<String, String> getContent() {
        return content;
    }

    public String getProperty(String key) {
        return content.get(key);
    }

    public String getProperty(String key, String defaultValue) {
        if (content.get(key) == null) {
            return defaultValue;
        }
        return content.get(key);
    }

    public void list(PrintStream out) {
        prop.list(out);
    }

    public void list(PrintWriter out) {
        prop.list(out);
    }

    public void load(InputStream inStream) throws IOException {
        prop.load(inStream);
        readToMap();
    }

    public void load(Reader reader) throws IOException {
        prop.load(reader);
        readToMap();
    }

    public void loadFromXML(InputStream in) throws IOException, InvalidPropertiesFormatException {
        prop.loadFromXML(in);
        readToMap();
    }

    public Set<String> stringPropertyNames() {
        return content.keySet();
    }

    public Object setProperty(String key, String value) {
        content.put(key, value);
        return prop.setProperty(key, value);
    }

    public void store(OutputStream out, String comments) throws IOException {
        prop.store(out, comments);
    }

    public void store(Writer writer, String comments) throws IOException {
        prop.store(writer, comments);
    }

    public void storeToXML(OutputStream os, String comment) throws IOException {
        prop.storeToXML(os, comment);
    }

    public void storeToXML(OutputStream os, String comment, String encoding) throws IOException {
        prop.storeToXML(os, comment, encoding);
    }

    public void clear() {
        prop.clear();
        content.clear();
    }

    private void readToMap() {
        prop.keys().asIterator().forEachRemaining((it) -> content.put(it.toString(), prop.getProperty(it.toString())));
    }
}
