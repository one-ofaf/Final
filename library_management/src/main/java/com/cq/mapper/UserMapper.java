package com.cq.mapper;

import com.cq.pojo.Book;
import com.cq.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

    @Insert("INSERT INTO User (Username, Password)"+
    "VALUES (#{userName}, #{passWord})"
)
    void insert(User user);


    void delete(List<Integer> ids);

 @Select("select * from user")
    List<User> find();

    void update(User user);

    @Select("select * from user where Username = #{userName} and Password = #{passWord}")
    User getByIdandpassword(User user);

    @Select("select COALESCE(count(*), 0) from user where Username = #{username}")
    int findByUname(@Param("username") String username);



    // 其他查询方法...
}
