package library.dao.impl;

import library.dao.BookDao;
import library.models.Book;
import library.models.Database;
import library.models.Library;

import java.util.List;

public class BookDaoImpl implements BookDao {
    @Override
    public Book saveBook(Long libraryId, Book book) {
        for (Library library : Database.libraries) {
            if (library.getId().equals(libraryId)){
                library.getBooks().add( book);
                break;
            }
        }
        Database.books.add(book);
        return book;
    }

    @Override
    public List<Book> getAllBooks(Long libraryId) {
        return List.of();
    }

    @Override
    public Book getBookById(Long libraryId, Long bookId) {
        return null;
    }

    @Override
    public String deleteBook(Long libraryId, Long bookId) {
        return "";
    }

    @Override
    public void clearBooksByLibraryId(Long libraryId) {

    }
}
