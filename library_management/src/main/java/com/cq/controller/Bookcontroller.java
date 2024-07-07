package com.cq.controller;

import com.cq.pojo.Book;
import com.cq.pojo.PageBean;
import com.cq.pojo.Result;
import com.cq.service.BookService;
import com.cq.service.impl.BookServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("/books")
public class Bookcontroller {
    @Autowired
    BookService bookService;

    //添加书籍
    @PostMapping
    public Result save(@RequestBody Book book){
        log.info("新增书籍, book: {}",book );
        bookService.save(book);
        return Result.success();
    }
    //批量删除书籍
    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable List<Integer> ids){
        log.info("批量删除操作, ids:{}",ids);
        bookService.delete(ids);
        return Result.success();
    }
    //修改书籍
    @PutMapping
    public Result update(@RequestBody Book book){
        log.info("更新书籍信息 : {}", book);
        bookService.update(book);
        return Result.success();
    }
    //分页查询
    @GetMapping
    public  Result page(@RequestParam(defaultValue = "1") Integer page,
                        @RequestParam(defaultValue = "5") Integer pageSize){
        PageBean pageBean = bookService.page(page,pageSize);
        return  Result.success(pageBean);
    }
}
