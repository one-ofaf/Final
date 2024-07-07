package com.cq.service.impl;

import com.cq.mapper.BookMapper;
import com.cq.pojo.Book;
import com.cq.pojo.PageBean;
import com.cq.service.BookService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    
    @Autowired
    private BookMapper bookMapper; // 注入BookMapper接口

    @Override
    public void save(Book book) {
        bookMapper.addBook(book);
    }

    @Override
    public void delete(List<Integer> ids) {
        bookMapper.delete(ids);
    }

    @Override
    public void update(Book book) {
        bookMapper.update( book );
    }

    @Override
    public PageBean page(Integer page, Integer pageSize) {
        PageHelper.startPage(page, pageSize);

        // 执行查询，此时查询的结果已经被分页了
        List<Book> bookList = bookMapper.list();

        // 获取分页信息
        PageInfo<Book> pageInfo = new PageInfo<>(bookList);

        // 构造PageBean对象
        PageBean pageBean = new PageBean(pageInfo.getTotal(), pageInfo.getList());
        return pageBean;
    }


    // 添加图书

}
