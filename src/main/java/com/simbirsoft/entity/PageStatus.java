package com.simbirsoft.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.net.URL;

@AllArgsConstructor(access = AccessLevel.PUBLIC)
@Data
public class PageStatus {
    private Long id;
    private String pageName;
    private URL urlPage;
    private Boolean downLoad;
}
