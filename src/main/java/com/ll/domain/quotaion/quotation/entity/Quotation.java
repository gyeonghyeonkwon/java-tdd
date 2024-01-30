package com.ll.domain.quotaion.quotation.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Quotation {


    private  long id;
    private  String authorName;
    private  String content;


}
