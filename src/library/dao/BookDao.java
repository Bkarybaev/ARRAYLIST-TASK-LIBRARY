package library.dao;

import library.models.Book;

import java.util.List;

public interface BookDao {
    Book saveBook(Long libraryId, Book book);

    List<Book> getAllBooks(Long libraryId);

    Book getBookById(Long libraryId, Long bookId);

    String deleteBook(Long libraryId,Long bookId);

    void clearBooksByLibraryId(Long libraryId);
}
