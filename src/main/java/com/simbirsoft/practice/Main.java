package com.simbirsoft.practice;

import com.simbirsoft.entity.PageStatus;
import lombok.Data;
import org.jsoup.Jsoup;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;

public class Main {
    private static final String fileNameUrl = "https://www.simbirsoft.com";
    public static void main(String[] args) throws IOException, SQLException {

        DataBaseRepository dataBaseRepository = new MariaDBRepository();
        PageStatus pageStatus = new PageStatus(1L,
                "www.simbirsoft.com",
                new URL(fileNameUrl),
                true);
        dataBaseRepository.savePageStatus(pageStatus);
        System.out.println("data sent to db");
/*        HtmlPageDownloader htmlPageDownloader = new HttpPageDownloader();
        File file = htmlPageDownloader.downloadAndSaveHtmlPage(new URL(fileNameUrl));
        System.out.println(file.getName());*/
    }
}
