package com.ll.domain.quotaion.quotation.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Quotation {


    private final long id;
    private final String authorName;
    private final String content;


}
