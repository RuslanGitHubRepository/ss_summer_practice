package com.simbirsoft.practice;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public interface HtmlPageDownloader {
    File downloadAndSaveHtmlPage(URL page) throws IOException;
}
