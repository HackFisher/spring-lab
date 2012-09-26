package com.flybyu.web.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class FileStorage {
	public static String storagePath;
	
	static {   
        Properties prop = new Properties();   
        InputStream in = FileStorage.class.getResourceAsStream("/storage.properties");   
        try {   
            prop.load(in);
            storagePath = prop.getProperty("path", "None");
            
            if("None".equals(storagePath)) {
            	throw new RuntimeException("The Storeage Path can not be none.");
            }
        } catch (IOException e) {   
            e.printStackTrace();   
        }   
    }
	
	public static String storageFilePath(String file) {
		return new File(storagePath, file).getAbsolutePath();
	}
}
