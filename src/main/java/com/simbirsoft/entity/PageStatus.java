package com.simbirsoft.entity;

import lombok.Data;

import java.net.URL;

@Data
public class PageStatus {
    Long id;
    String pageName;
    URL urlPage;
    Boolean downLoad;
}
