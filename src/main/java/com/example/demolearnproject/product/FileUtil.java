package com.example.demolearnproject.product;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public final class FileUtil {


    private Integer id;

    private FileUtil() {
        // restrict instantiation
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public static final String folderPath =  "product-images/";
    public static final Path filePath = Paths.get(folderPath);

}
