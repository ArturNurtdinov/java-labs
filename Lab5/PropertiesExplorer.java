import java.io.*;
import java.util.*;

public class PropertiesExplorer {
    private Properties prop = new Properties();


    public PropertiesExplorer(String path) throws IOException {
        prop.load(new FileInputStream(path));
    }

    public Map getContent() {
        return prop;
    }

    public Collection<Object> values() {
        return prop.values();
    }

    public Object getProperty(String key) {
        return prop.get(key);
    }

    public Object getProperty(String key, String defaultValue) {
        if (prop.get(key) == null) {
            return defaultValue;
        }
        return prop.get(key);
    }

    public void list(PrintStream out) {
        prop.list(out);
    }

    public void list(PrintWriter out) {
        prop.list(out);
    }

    public void load(InputStream inStream) throws IOException {
        prop.load(inStream);
    }

    public void load(Reader reader) throws IOException {
        prop.load(reader);
    }

    public void loadFromXML(InputStream in) throws IOException, InvalidPropertiesFormatException {
        prop.loadFromXML(in);
    }

    public Set<String> stringPropertyNames() {
        return prop.stringPropertyNames();
    }

    public Object setProperty(String key, String value) {
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
    }
}
