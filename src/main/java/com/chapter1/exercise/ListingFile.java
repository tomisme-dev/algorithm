package com.chapter1.exercise;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListingFile {
    public static List<File> listAll(File root) {
        List<File> files = new LinkedList<>();
        if(root.isFile()) {
            files.add(root);
            return files;
        }

        for(File f: root.listFiles()) {
            List<File> subFiles = listAll(f);
            files.addAll(subFiles);
        }

        return files;
    }

    public static void main(String[] args) {
        List<File> files = listAll(new File("."));
        for(File f: files) {
            System.out.println(f.getAbsolutePath());
        }
    }
}
