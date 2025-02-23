package com.platcloud.book_library.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.platcloud.book_library.entity.Book;
import com.platcloud.book_library.mapper.BookMapper;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements BookService {
}
