/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileservicelab;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Mark
 */
public class TextFileReader implements FileReaderStrategy {
    private TextFileFormatStrategy fileFormat;
    private String path;

    public TextFileReader() {
    }

    public TextFileReader(TextFileFormatStrategy fileFormat, String path) {
        this.fileFormat = fileFormat;
        this.path = path;
    }

    @Override
    public TextFileFormatStrategy getFileFormat() {
        return fileFormat;
    }

    @Override
    public String getPath() {
        return path;
    }

    @Override
    public void setFileFormat(TextFileFormatStrategy fileFormat) {
        this.fileFormat = fileFormat;
    }

    @Override
    public void setPath(String path) {
        this.path = path;
    }
    
    @Override
    public List<LinkedHashMap<String,String>> pullRecords(boolean useHeader) throws IOException{
        File textFile = new File(path);
        BufferedReader in = null;
        String record = "";
        try{
            in = new BufferedReader(new FileReader(textFile));
            
            String line = in.readLine();
             while(line != null){
                record+=(line+"\n");
                line=in.readLine();
            }
        } catch(IOException ioe) {
            System.out.println("Error reading file");
        } finally {
            try {
                in.close();
            } catch(Exception e) {
                System.out.println("Error closing file");
            }
        }
         return fileFormat.decodeFile(record,useHeader);
        
    }
}
