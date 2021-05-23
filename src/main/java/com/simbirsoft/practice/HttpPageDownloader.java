package com.simbirsoft.practice;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class HttpPageDownloader implements HtmlPageDownloader {
    private Path saveDirectory;

    public HttpPageDownloader() throws IOException {
        Path currentPage = Paths.get("").toAbsolutePath();
        if(!Files.exists(currentPage.resolve("files"))) {
            this.saveDirectory = Files.createDirectory(currentPage.resolve("files"));
        } else {
         this.saveDirectory = currentPage.resolve("files");
        }
    }

    @Override
    public File downloadAndSaveHtmlPage(URL page) throws IOException{
        BufferedReader readr =  new BufferedReader(new InputStreamReader(page.openStream()));
        File htmlFile = saveDirectory.resolve(String.format("%s.html", page.toString().replaceAll("^.*/",""))).toFile();
        if(Files.exists(htmlFile.toPath())) {
            Files.delete(htmlFile.toPath());
        }
        BufferedWriter writer = new BufferedWriter(new FileWriter(htmlFile));
        String line;
        while ((line = readr.readLine()) != null) {
            writer.write(line);
        }
        readr.close();
        writer.close();
        System.out.println("Successfully Downloaded.");
        return htmlFile;
    }
}
