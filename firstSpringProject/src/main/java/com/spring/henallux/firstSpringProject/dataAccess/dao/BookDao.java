package com.spring.henallux.firstSpringProject.dataAccess.dao;

import com.spring.henallux.firstSpringProject.dataAccess.entity.BookEntity;
import com.spring.henallux.firstSpringProject.dataAccess.repository.BookRepository;
import com.spring.henallux.firstSpringProject.dataAccess.utils.ProviderConverter;
import com.spring.henallux.firstSpringProject.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookDao implements BookDataAccess
{
    private final BookRepository bookRepository;
    private final ProviderConverter providerConverter;

    @Autowired
    public BookDao(BookRepository bookRepository,ProviderConverter providerConverter)
    {
        this.bookRepository = bookRepository;
        this.providerConverter = providerConverter;
    }

    public ArrayList<Book> getAllBook()
    {
        List<BookEntity> bookEntities = bookRepository.findAll();
        ArrayList<Book> books = new ArrayList<>();
        for(BookEntity entity : bookEntities)
        {
            Book book = providerConverter.bookEntityToBookModel(entity);
            books.add(book);
        }
        return books;
    }

    public ArrayList<Book> getBookbyCategory(int id)
    {
        ArrayList<BookEntity> bookEntities = bookRepository.findAllByCategory_Id(id);
        ArrayList<Book> books = new ArrayList<>();
        for(BookEntity entity : bookEntities)
        {
            Book book = providerConverter.bookEntityToBookModel(entity);
            books.add(book);
        }
        return books;
    }


    public Book getBookByIsbn(String isbn)
    {
        return providerConverter.bookEntityToBookModel(bookRepository.findByIsbn(isbn));
    }
}
