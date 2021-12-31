package com.b1llstnntotwitch;

import java.io.IOException;
import java.io.*;
import java.nio.file.*;


public class Parser {    
  
  private Path filePath;
  private String fileContents;
  private String baseUrl = "/media/b1llstar/B1llstar/Programming_Projects/b1llstBrowserTextProcessor/src/main/java/com/b1llstnntotwitch/Text_Inputs/";
  private String baseUrlPlusFileName;
  
  
  public void openTextInputStream() throws Exception {

    WatchService watchService
    = FileSystems.getDefault().newWatchService();
// System.out.println(System.getProperty("user.dir"));
Path path = Paths.get(baseUrl);
  
path.register(
      watchService, 
        StandardWatchEventKinds.ENTRY_CREATE, 
          StandardWatchEventKinds.ENTRY_DELETE, 
            StandardWatchEventKinds.ENTRY_MODIFY);
  System.out.println(path);

WatchKey key;

while ((key = watchService.take()) != null) {
    for (WatchEvent<?> event : key.pollEvents()) {

            int length = event.context().toString().length();
            String fileName = event.context().toString();
            String typeOfEvent = event.kind().toString();

            // to check if the file is a .txt
            String lastThreeChars = fileName.substring(length - 3, length);
        
            if (lastThreeChars.equals("txt") && typeOfEvent.equals("ENTRY_MODIFY")) {
             // System.out.println("Found a text file!");
              baseUrlPlusFileName = baseUrl + fileName;
           //   System.out.println("Full Path: \n" + baseUrlPlusFileName);
              Path filePath = Paths.get(baseUrlPlusFileName);
              fileContents = Files.readString(filePath);
        
              // System.out.println("File Contents: \n" + fileContents);
              App.handleInputText(fileContents);
              
              // System.out.println("Deleting file...");
              File file = new File(baseUrlPlusFileName);
              file.delete();

              // System.out.println(fileName);
            } else {
             // System.out.println("Not a text file");

            }


          }
    key.reset();
}


} 
      
}



