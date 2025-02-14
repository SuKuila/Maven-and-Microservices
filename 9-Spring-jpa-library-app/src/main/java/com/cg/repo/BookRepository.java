package com.cg.repo;

import java.util.List;

import com.cg.dto.BookDto;
import com.cg.entity.Book;
import com.cg.entity.Genre;

public interface BookRepository {

Book addBook(BookDto book);
List<Book> searchByGenre2(Genre genre);

List<Book> allBooks();
List<Book> searchByAuthour(int authourId);
List<Book> searchByGenre(Genre genre);
Book updateBook(Book book,int bookId);
void removeBook(int bookId);

List<Book> searchByBookName(String bookName);

}
