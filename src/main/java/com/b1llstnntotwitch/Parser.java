package com.b1llstnntotwitch;

import java.io.IOException;
import java.io.*;
import java.nio.file.*;

public class Parser {    
  
  
  
  public void doSomething() throws Exception {

    WatchService watchService
    = FileSystems.getDefault().newWatchService();
System.out.println(System.getProperty("user.dir"));
Path path = Paths.get("./");
  
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
              System.out.println("Found a text file!");
              System.out.println(fileName);
            } else {
              System.out.println("Not a text file");

            }


          }
    key.reset();
}


} 
      
}



