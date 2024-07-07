package com.cq.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    private int bookID;
    private String title;
    private String author;
    private String isbn;
    private int publishYear;
    private Status status;
    private String image;

}
