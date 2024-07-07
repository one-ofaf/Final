package com.cq.mapper;

import com.cq.pojo.Book;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BookMapper {
    @Insert("INSERT INTO Book (Title, Author, ISBN, PublishYear, Status, image) " +
            "VALUES (#{title}, #{author}, #{isbn}, #{publishYear}, #{status}, #{image})")
    void addBook(Book book);



    void delete(List<Integer> ids);

    void update(Book book);

    //书籍分页信息查询
    @Select("select * from book")
    List<Book> list();

    // 其他查询方法...
}
