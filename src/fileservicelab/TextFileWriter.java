/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileservicelab;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.List;

/**
 *
 * @author Mark
 */
public class TextFileWriter {
    private TextFileFormatStrategy fileFormat;
    private String path;

    public TextFileFormatStrategy getFileFormat() {
        return fileFormat;
    }

    public void setFileFormat(TextFileFormatStrategy fileFormat) {
        this.fileFormat = fileFormat;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
   public void addToFile(List<LinkedHashMap<String,String>> additions)throws IOException{
        File textFile = new File(path);
        final boolean append = true;
        BufferedReader in = null;
        try{
          in = new BufferedReader(new FileReader(textFile));
	  PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(textFile, append)));
          String record = fileFormat.encodeFile(additions);
          out.print(record);
	  out.close();
          }catch(IOException e){
                System.out.println("Error reading file");
          } finally {
            try {
                in.close();
            } catch(Exception e) {
                System.out.println("Error closing file");
            }
        }
   }
   public void overwrite(List<LinkedHashMap<String,String>> additions)throws IOException{
        File textFile = new File(path);
        final boolean append = false;
        BufferedReader in = null;
        try{
          in = new BufferedReader(new FileReader(textFile));
	  PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(textFile, append)));
          String record = fileFormat.encodeFile(additions);
          out.print(record);
	  out.close();
          }catch(IOException e){
                System.out.println("Error reading file");
          } finally {
            try {
                in.close();
            } catch(Exception e) {
                System.out.println("Error closing file");
            }
        }
   }
   
    
}
