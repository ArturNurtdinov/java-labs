package explorers;

import java.io.*;
import java.nio.file.InvalidPathException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;

public class FileExplorer {
    private StringBuilder currentPath;
    private Scanner scanner;
    private PrintStream out;
    private final Map<String, Consumer<String>> functions = new HashMap<>() {{
        put("cd", FileExplorer.this::goToDirectory);
        put("create", FileExplorer.this::createFile);
        put("delete", FileExplorer.this::deleteFile);
        put("append", FileExplorer.this::appendToFile);
        put("ls", FileExplorer.this::showAllFiles);
        put("read", FileExplorer.this::printTextFile);
    }};

    public FileExplorer() {
        currentPath = new StringBuilder("C:\\");
        scanner = new Scanner(new InputStreamReader(System.in));
        out = System.out;
    }

    public FileExplorer(InputStream in, PrintStream out) {
        currentPath = new StringBuilder("C:\\");
        scanner = new Scanner(in);
        this.out = out;
    }

    public FileExplorer(String currentPath) {
        if (new File(currentPath).isDirectory()) {
            this.currentPath = new StringBuilder(currentPath);
            scanner = new Scanner(new InputStreamReader(System.in));
            out = System.out;
        } else {
            throw new IllegalArgumentException("Path is not a directory");
        }
    }

    public void execute(String command) {
        Scanner line = new Scanner(command.trim());

        if (line.hasNext()) {
            functions.getOrDefault(line.next(), (c) -> out.println("No such command: " + c)).accept(line.nextLine().trim());
        }

        out.println(currentPath.toString());
    }

    public void start() {
        out.println("1. cd <folder_name> to go to folder");
        out.println("2. create <file_name>.<file_type> to create file. " +
                "After that you can input line to create file with it or leave this line empty");
        out.println("3. delete <file_name>.<file_type> to delete text file.");
        out.println("4. append <file_name>.<file_type> to start append mode to file. After that you can input line");
        out.println("5. ls <folder_name> to get list of files in folder. " +
                "<folder_name> can be empty, so you will get list of files in current directory");
        out.println("6. read <file_name>.<file_type> to print content of file");
        out.println(currentPath.toString());
        while (scanner.hasNext()) {
            try {
                String command = scanner.next();
                functions.get(command).accept(scanner.nextLine().trim());
                out.println(currentPath.toString());
            } catch (NullPointerException ex) {
                out.println("Unknown command");
            } catch (Exception ex) {
                out.println("Error: " + ex.getMessage());
            }
        }
    }

    public String getPath() {
        return currentPath.toString();
    }

    public void close() {
        scanner.close();
    }

    private void goToDirectory(String path) {
        if (path.equals("..")) {
            currentPath.deleteCharAt(currentPath.length() - 1);
            try {
                currentPath.delete(currentPath.lastIndexOf("\\") + 1, currentPath.length());
            } catch (IndexOutOfBoundsException ex) {
                currentPath = new StringBuilder("");
            }
        } else {
            if (new File(currentPath + path).isDirectory()) {
                currentPath.append(path).append("\\");
            } else {
                throw new IllegalArgumentException("Is not a directory: " + currentPath + path);
            }
        }
    }

    private void createFile(String name) {
        Scanner line = new Scanner(name);
        try (PrintWriter writer = new PrintWriter(new FileWriter(currentPath + line.next(), true))) {
            writer.println(line.nextLine().trim());
        } catch (IOException ex) {
            out.println("IO Error: " + ex.getMessage());
        }
    }

    private void deleteFile(String name) {
        File file = new File(currentPath.toString() + name);
        if (!file.delete()) {
            throw new IllegalArgumentException("File was not deleted");
        }
    }

    private void appendToFile(String name) {
        Scanner line = new Scanner(name);
        try (PrintWriter writer = new PrintWriter(new FileWriter(currentPath + line.next(), true))) {
            writer.print(line.nextLine());
        } catch (IOException ex) {
            out.println("IO Error: " + ex.getMessage());
        }
    }

    private void showAllFiles(String path) {
        File dir = new File(currentPath.toString() + path);
        if (!dir.isDirectory()) {
            throw new IllegalArgumentException("Not a directory: " + currentPath.toString() + path);
        }
        for (File file : dir.listFiles()) {
            out.println(file.getName());
        }

    }

    private void printTextFile(String name) {
        try (BufferedReader reader = new BufferedReader(new FileReader(currentPath + name))) {
            String line;
            while ((line = reader.readLine()) != null) {
                out.println(line);
            }
        } catch (IOException ex) {
            out.println("IO Error: " + ex.getMessage());
        }
    }
}
