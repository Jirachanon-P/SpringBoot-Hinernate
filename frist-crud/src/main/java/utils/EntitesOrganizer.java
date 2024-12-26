package utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class EntitesOrganizer {
    // Relative path where generated files are stored
    private static final String GENERATED_PATH = "/src/main/java"; 
    private static final String ENTITY_PACKAGE_BASE = "model"; // Base directory for entities

    public void execute() {
        System.out.println("Starting EntityOrganizer...");

        // Determine the base directory relative to the current working directory
        Path baseDirectoryPath = Paths.get(System.getProperty("user.dir"), GENERATED_PATH);
        File baseDirectory = baseDirectoryPath.toFile();

        if (!baseDirectory.exists() || !baseDirectory.isDirectory()) {
            System.err.println("Base directory does not exist: " + baseDirectoryPath);
            return;
        }

        // List all Java files in the directory
        File[] files = baseDirectory.listFiles((dir, name) -> name.endsWith(".java"));
        if (files == null || files.length == 0) {
            System.out.println("No files to organize.");
            return;
        }

        for (File file : files) {
            try {
                organizeFile(file, baseDirectoryPath);
            } catch (IOException e) {
                System.err.println("Error organizing file: " + file.getName());
                e.printStackTrace();
            }
        }

        System.out.println("EntityOrganizer completed!");
    }

    private void organizeFile(File file, Path baseDirectoryPath) throws IOException {
        // Get the table name from the file name (assuming class name matches table name)
        String tableName = file.getName().replace(".java", "");

        // Construct the target directory path as model/{tableName}
        Path targetDirectoryPath = baseDirectoryPath.resolve(ENTITY_PACKAGE_BASE).resolve(tableName.toLowerCase());

        // Create the target directory if it doesn't exist
        File targetDirectory = targetDirectoryPath.toFile();
        if (!targetDirectory.exists()) {
            targetDirectory.mkdirs();
        }

        // Construct the target file path as model/{tableName}/{tableName}.java
        Path targetFilePath = targetDirectoryPath.resolve(tableName + ".java");

        // Move the file to the target location
        Files.move(file.toPath(), targetFilePath, StandardCopyOption.REPLACE_EXISTING);
        System.out.println("Moved " + file.getName() + " to " + targetFilePath);
    }
}
