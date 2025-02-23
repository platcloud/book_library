package com.platcloud.book_library;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.platcloud.book_library.mapper")
public class BookLibraryApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookLibraryApplication.class, args);
    }

}
