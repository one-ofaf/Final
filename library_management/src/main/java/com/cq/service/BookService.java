package com.cq.service;

import com.cq.pojo.Book;
import com.cq.pojo.PageBean;

import java.time.LocalDate;
import java.util.List;

public interface BookService {


    void save(Book book);

    void delete(List<Integer> ids);

    void update(Book book);
    PageBean page(Integer page, Integer pageSize);
}
