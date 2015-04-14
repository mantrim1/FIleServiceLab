/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileservicelab;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Mark
 */
public class CsvFileFormat implements TextFileFormatStrategy {
/**
 * Takes the String from the file and separates it into usable data
 * @param incomingData data to be translated
 * @return the usable data as a list of maps
 */
    @Override
    public List<LinkedHashMap<String, String>> decodeFile(String incomingData, boolean useHeader) {
        List<LinkedHashMap<String,String>> outgoingData = new ArrayList<>();
        //split data into each line
        String[] lines = incomingData.split("\\n");
        if(useHeader){
            //create header element
            String[] header = lines[0].split(",");
            for(int i =1; i<lines.length;i++){
                //the records from each line
                LinkedHashMap<String,String> recordLine = new LinkedHashMap<>();
                String[] temp =lines[i].split(",");
                    for(int j=0; j<temp.length;j++){
                        //asscociate record with header as a key
                        recordLine.put(header[j],temp[j]);
                    }
                outgoingData.add(recordLine);
            }
        }else{
            for(int i =0; i<lines.length;i++){
            LinkedHashMap<String,String> recordLine = new LinkedHashMap<>();
                String[] temp =lines[i].split(",");
                for(int j=0; j<temp.length;j++){
                        //asscociate record itself as key
                        recordLine.put(temp[j],temp[j]);
                    }
                outgoingData.add(recordLine);
            }   
        }
        
        return outgoingData;
    }
/**
 * return data file back into string format
 * @param fileContents the list of values to be put into a file
 * @param useHeader whether or not there is a header
 * @return string to be written to file
 */
    @Override
    public String encodeFile(List<LinkedHashMap<String, String>> fileContents) {
        //i took out the add header method from because using it seemed redundant and taking it out significantly shortened code
        StringBuilder outgoingString = new StringBuilder();
        Set<String> iteratorSet = fileContents.get(0).keySet();
        int lastCharPosition;
        for(LinkedHashMap<String,String> row : fileContents){
            for(Iterator i=iteratorSet.iterator(); i.hasNext();){
                //convert row to string flexbily using the item's to string method
                outgoingString.append("\"").append(row.get(i.next().toString())).append("\"");
            }
                    //takes the position of the last charachter in the string
            lastCharPosition=outgoingString.length()-1;
            //replaces the comma at th end of the line with a new line marker
            outgoingString.replace(lastCharPosition, lastCharPosition+1, "\\n");
        }
    return outgoingString.toString();
    }
    
    
}
