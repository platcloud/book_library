package com.platcloud.book_library.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.platcloud.book_library.entity.Book;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BookMapper extends BaseMapper<Book> {
}
