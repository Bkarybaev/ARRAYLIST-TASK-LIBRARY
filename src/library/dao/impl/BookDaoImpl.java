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
        for (Library library : Database.libraries) {
            if (library.getId().equals(libraryId)){
                return library.getBooks();
            }
        }
        return null;
    }

    @Override
    public Book getBookById(Long libraryId, Long bookId) {
        for (Library library : Database.libraries) {
            if (library.getId().equals(libraryId)){
                for (Book book : library.getBooks()) {
                    if (book.getBookId().equals(bookId)){
                        return book;
                    }
                }
                break;
            }
        }
        return null;
    }

    @Override
    public String deleteBook(Long libraryId, Long bookId) {
        for (Library library : Database.libraries) {
            if (library.getId().equals(libraryId)){
                for (int i = 0; i < library.getBooks().size(); i++) {
                    if (library.getBooks().get(i).getBookId().equals(bookId)){
                        library.getBooks().remove(i);
                        return "Deleted!!";
                    }
                }
                break;
            }
        }
        return "not fount!!";
    }

    @Override
    public void clearBooksByLibraryId(Long libraryId) {
        for (Library l : Database.libraries) {
            if (l.getId().equals(libraryId)){
                l.getBooks().clear();
                break;
            }
        }
    }
}
