package com.simbirsoft.practice;

import org.jsoup.Jsoup;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Main {
    private static final String fileNameUrl = "https://www.simbirsoft.com";
    public static void main(String[] args) throws IOException {

        HtmlPageDownloader htmlPageDownloader = new HttpPageDownloader();
        File file = htmlPageDownloader.downloadAndSaveHtmlPage(new URL(fileNameUrl));
        System.out.println(file.getName());
    }
}
