package com.pretius.pretius;

import com.pretius.pretius.helper.FileHelper;

import java.io.IOException;
import java.nio.file.*;

public class PretiusApplication {

    public static void main(String[] args) throws IOException, InterruptedException {

        FileHelper fileHelper = new FileHelper();
        fileHelper.createDirectories();
        fileHelper.createFiles();

        WatchService watchService
                = FileSystems.getDefault().newWatchService();

        Path directoryForWatching =  FileHelper.getPathHOME();


        directoryForWatching.register(
                watchService,
                StandardWatchEventKinds.ENTRY_CREATE,
                StandardWatchEventKinds.ENTRY_DELETE,
                StandardWatchEventKinds.ENTRY_MODIFY);

        WatchKey key;
        while ((key = watchService.take()) != null) {
            for (WatchEvent<?> event : key.pollEvents()) {
                System.out.println(
                        "Event kind:" + event.kind()
                                + ". File affected: " + event.context() + ".");
                if(event.kind().name() == "ENTRY_CREATE") {
                    FileHelper.moveFileToAnotherDirectory(event.context().toString());
                }
            }
            key.reset();
        }
    }
}
