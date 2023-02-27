package com.spring.henallux.firstSpringProject.dataAccess.dao;


import com.spring.henallux.firstSpringProject.model.Book;

import java.util.ArrayList;

public interface BookDataAccess
{
    ArrayList<Book> getAllBook();
    ArrayList<Book> getBookbyCategory(int id);
    Book getBookByIsbn(String isbn);
}
