package com.bonus71.data;

public class DatabaseUploader {
    private String csvSourcePath;
    private String databaseDirectory;

    public DatabaseUploader(String csvSourcePath, String databaseDirectory) {
        this.csvSourcePath = csvSourcePath;
        this.databaseDirectory = databaseDirectory;
    }
}
