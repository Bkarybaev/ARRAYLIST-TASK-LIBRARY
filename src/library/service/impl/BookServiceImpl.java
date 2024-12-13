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
        try {
            if (libraryId == null || 0 > libraryId) {
                throw new RuntimeException("Error exception !!");
            } else {
                boolean l = true;
                for (Library library : Database.libraries) {
                    if (libraryId.equals(library.getId())) {
                        l = false;
                    }
                }
                if (l) throw new RuntimeException("not fount!!");
            }
            return bookDao.getAllBooks(libraryId);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Book getBookById(Long libraryId, Long bookId) {
        try {
            if (libraryId == null || libraryId < 0 || bookId == null || bookId < 0) {
            throw new RuntimeException("id Error!!");
            }
            return bookDao.getBookById(libraryId, bookId);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public String deleteBook(Long libraryId, Long bookId) {
        try {
            if (libraryId == null || libraryId < 0 || bookId == null || bookId < 0) {
                throw new RuntimeException("id Error!!");
            }
             bookDao.deleteBook(libraryId, bookId);
        } catch (RuntimeException e) {
            return e.getMessage();
        }
        return "Successfully!!";
    }

    @Override
    public void clearBooksByLibraryId(Long libraryId) {
        try {
            if (libraryId == null || libraryId < 0){
                throw new RuntimeException("Error library id!!");
            }
            bookDao.clearBooksByLibraryId(libraryId);
            System.out.println("Successfully clear books !");
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
    }
}
