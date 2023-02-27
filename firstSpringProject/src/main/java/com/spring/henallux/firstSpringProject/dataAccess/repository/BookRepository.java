package com.spring.henallux.firstSpringProject.dataAccess.repository;

import com.spring.henallux.firstSpringProject.dataAccess.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface BookRepository extends JpaRepository<BookEntity,String>
{
    ArrayList<BookEntity> findAllByCategory_Id(int id);
    BookEntity findByIsbn(String isbn);
}
