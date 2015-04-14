/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileservicelab;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Mark
 */
public interface TextFileFormatStrategy {
    //turn file into a list
    List<LinkedHashMap<String,String>> decodeFile(String incomingData,boolean useHeader);
    String encodeFile(List<LinkedHashMap<String, String>> updatedFileContent);
    
}
