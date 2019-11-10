import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileExplorer {
    private StringBuilder currentPath;
    private Scanner scanner = new Scanner(new InputStreamReader(System.in));
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
    }

    public FileExplorer(String currentPath) {
        if (new File(currentPath).isDirectory()) {
            this.currentPath = new StringBuilder(currentPath);
        } else {
            throw new IllegalArgumentException("Path is not a directory");
        }
    }

    public void start() {
        System.out.println("1. cd <folder_name> to go to folder");
        System.out.println("2. create <file_name>.<file_type> to create file. " +
                "After that you can input line to create file with it or leave this line empty");
        System.out.println("3. delete <file_name>.<file_type> to delete text file.");
        System.out.println("4. append <file_name>.<file_type> to start append mode to file. After that you can input line");
        System.out.println("5. ls <folder_name> to get list of files in folder. " +
                "<folder_name> can be empty, so you will get list of files in current directory");
        System.out.println("6. read <file_name>.<file_type> to print content of file");
        System.out.println(currentPath.toString());
        while (scanner.hasNext()) {
            try {
                String command = scanner.next();
                functions.get(command).accept(scanner.nextLine().trim());
            } catch (NullPointerException ex) {
                System.out.println("Unknown command");
            } catch (Exception ex) {
                System.out.println("Error: " + ex.getMessage());
            }
        }
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
            System.out.println(currentPath.toString());
        } else {
            if (new File(currentPath + path).isDirectory()) {
                currentPath.append(path).append("\\");
                System.out.println(currentPath.toString());
            } else {
                throw new IllegalArgumentException("Is not a directory");
            }
        }
    }

    private void createFile(String name) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(currentPath + name, true))) {
            writer.println(scanner.nextLine());
        } catch (IOException ex) {
            System.out.println("IO Error: " + ex.getMessage());
        }
    }

    private void deleteFile(String name) {
        File file = new File(currentPath.toString() + name);
        if (!file.delete()) {
            throw new IllegalArgumentException("File was not deleted");
        }
    }

    private void appendToFile(String name) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(currentPath + name, true))) {
            writer.print(scanner.nextLine());
        } catch (IOException ex) {
            System.out.println("IO Error: " + ex.getMessage());
        }
    }

    private void showAllFiles(String path) {
        try (Stream<Path> walk = Files.walk(Paths.get(currentPath + path))) {

            List<String> result = walk.filter(Files::isRegularFile)
                    .map(Path::toString).collect(Collectors.toList());

            result.forEach(System.out::println);

        } catch (IOException ex) {
            System.out.println("IO Error: " + ex.getMessage());
        }
    }

    private void printTextFile(String name) {
        try (BufferedReader reader = new BufferedReader(new FileReader(currentPath + name))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException ex) {
            System.out.println("IO Error: " + ex.getMessage());
        }
    }
}
