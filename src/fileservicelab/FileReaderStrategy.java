/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileservicelab;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

/**
 *
 * @author Mark
 */
public interface FileReaderStrategy {

    TextFileFormatStrategy getFileFormat();

    String getPath();

    List<LinkedHashMap<String, String>> pullRecords(boolean useHeader) throws IOException;

    void setFileFormat(TextFileFormatStrategy fileFormat);

    void setPath(String path);
    
}
