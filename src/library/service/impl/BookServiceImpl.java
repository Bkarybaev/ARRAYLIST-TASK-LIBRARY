package library.service.impl;

import library.dao.impl.BookDaoImpl;
import library.models.Book;
import library.models.Database;
import library.models.Library;
import library.service.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {
    BookDaoImpl bookDao = new BookDaoImpl();

    @Override
    public Book saveBook(Long libraryId, Book book) {
        try {
            if (libraryId == null) {
                throw new RuntimeException("library id null!!");
            } else {
                boolean t = false;
                for (Library library : Database.libraries) {
                    if (libraryId.equals(library.getId())) {
                        t = true;
                    }
                }
                if (!t) throw new RuntimeException("not fount!!");
            }
            if (book.getName() == null) {
                throw new RuntimeException("book name null!!");
            }
        bookDao.saveBook(libraryId, book);
        return book;
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        return new Book();
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
