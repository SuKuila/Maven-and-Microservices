package com.cgservice;
import java.util.List;

import com.cg.dto.BookDto;
import com.cg.entity.Book;
import com.cg.entity.Genre;
public interface BookService {
Book addBookService(BookDto book);
List<Book> searchByGenre2Service(Genre genre);

List<Book> allBooksService();
List<Book> searchByAuthourService(int authourId);
List<Book> searchByGenreService(Genre genre);
Book updateBookService(Book book,int bookId);
void removeBookService(int bookId);

List<Book> searchByBookNameService(String bookName);

}
