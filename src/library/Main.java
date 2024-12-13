package library;

import library.enums.Gender;
import library.enums.Genre;
import library.models.Book;
import library.models.Library;
import library.models.Reader;
import library.service.impl.BookServiceImpl;
import library.service.impl.LibraryServiceImpl;
import library.service.impl.ReaderServiceImpl;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static LibraryServiceImpl libraryService = new LibraryServiceImpl();
    static BookServiceImpl bookService = new BookServiceImpl();
    static ReaderServiceImpl readerService = new ReaderServiceImpl();

    public static void main(String[] args) {

        while (true) {
            System.out.print("""
                    --------- Welcome to Library --------
                    1.Add library                       =
                    2.Get All library                   =
                    3.Get by id library                 =
                    4.Update library                    =
                    5.Deleted by id library             =
                    6.Book save                         =
                    7.Get all books                     =
                    8.Get Book By Id                    =
                    9.Delete book                       =
                    10.Clear Books By Library Id        =
                    11.Save Reader                      =
                    12.Get All Readers                  =
                    13.Get Reader By Id                 =
                    14.Update Reader                    =
                    15.Assign Reader To Library         =
                    0.Logout >                          =
                    -------------------------------------
                    """);
            System.out.print("choice: ");
            String choice = new Scanner(System.in).nextLine();
            switch (choice) {
                case "1" -> libraryService.saveLibrary(addLibrary());
                case "2" -> System.out.println(libraryService.getAllLibraries());
                case "3" -> System.out.println(getByIdLibrary());
                case "4" -> System.out.println(libraryService.updateLibrary(updateIdLibrary(), updateLibrary()));
                case "5" -> System.out.println(libraryService.deleteLibrary(deleteIdLibrary()));
                case "6" -> System.out.println(bookService.saveBook(bookSaveLibraryId(), newBookAdd()));
                case "7" -> System.out.println(bookService.getAllBooks(getAllBooksLibraryID()));
                case "8" -> System.out.println(bookService.getBookById(updateIdLibrary(), getByBookID()));
                case "9" -> System.out.println(bookService.deleteBook(updateIdLibrary(), getByBookID()));
                case "10" -> bookService.clearBooksByLibraryId(updateIdLibrary());
                case "11" -> readerService.saveReader(saveReader());
                case "12" -> System.out.println(readerService.getAllReaders());
                case "13" -> System.out.println(readerService.getReaderById(readerId()));
                case "14" -> System.out.println(readerService.updateReader(readerId(), saveReader()));
                case "15" -> readerService.assignReaderToLibrary(readerId(),updateIdLibrary());
                case "0" -> {
                    System.out.println("\n  Logout...");
                    return;
                }
                default -> {
                    System.out.println("ERROR choice");
                }
            }
        }
    }
    public static Long readerId(){
        System.out.print("write id reader: ");
        return new Scanner(System.in).nextLong();
    }
    public static Reader saveReader(){
        System.out.print("write full name: ");
        String fullName = new Scanner(System.in).nextLine();

        System.out.print("write email: ");
        String email = new Scanner(System.in).nextLine();

        System.out.print("write phone Number: ");
        String phoneNumber = new Scanner(System.in).nextLine();

        System.out.print("write gender (MALE, FEMALE): ");
        String gender = new Scanner(System.in).nextLine().toUpperCase();
        Gender gen = null;

        switch (gender){
            case "MALE" -> gen = Gender.MALE;
            case "FEMALE" -> gen = Gender.FEMALE;
            default -> System.out.println("Error choice!!");
        }
        return new Reader(fullName,email,phoneNumber,gen);

    }
    public static Long getByBookID(){
        System.out.print("write id book: ");
        return new Scanner(System.in).nextLong();
    }


    public static Long getAllBooksLibraryID(){
        System.out.print("write id Library: ");
        return new Scanner(System.in).nextLong();
    }


    public static ArrayList<Library> addLibrary() {
        ArrayList<Library> libraries = new ArrayList<>();

        System.out.print("write name Library: ");
        String nameLibrary = new Scanner(System.in).nextLine();

        System.out.print("write address Library: ");
        String addressLibrary = new Scanner(System.in).nextLine();

        libraries.add(new Library(nameLibrary, addressLibrary));

        return libraries;
    }

    public static Library getByIdLibrary() {
        for (Library allLibrary : libraryService.getAllLibraries()) {
            System.out.println("id library: " + allLibrary.getId());
        }
        System.out.print("write id library:");
        Long id = new Scanner(System.in).nextLong();
        return libraryService.getLibraryById(id);
    }

    public static Long updateIdLibrary() {
        System.out.print("write library id: ");
        return new Scanner(System.in).nextLong();
    }

    public static Library updateLibrary() {
        System.out.print("write update Library name: ");
        String upLibraryName = new Scanner(System.in).nextLine();

        System.out.print("write update Library address: ");
        String upLibraryAddress = new Scanner(System.in).nextLine();

        return new Library(upLibraryName, upLibraryAddress,9);
    }
    public static Long deleteIdLibrary(){
        System.out.print("write id library: ");
        return new Scanner(System.in).nextLong();
    }
    public static Long bookSaveLibraryId(){
        System.out.print("write id add book Library id: ");
        return new Scanner(System.in).nextLong();
    }
    public static Book newBookAdd(){

        System.out.print("write name book: ");
        String nameBook = new Scanner(System.in).nextLine();

        System.out.print("write author name: ");
        String authorBook = new Scanner(System.in).nextLine();

        System.out.print("""
                1.EPIC,
                2.EPOC,
                3.NOVEL,
                4.STORY,
                5.SKETCH
                """);
        Genre genre = null;
        String choice = new Scanner(System.in).nextLine();
        switch (choice){
            case "1" -> genre = Genre.EPIC;
            case "2" -> genre = Genre.EPOC;
            case "3" -> genre = Genre.NOVEL;
            case "4" -> genre = Genre.STORY;
            case "5" -> genre = Genre.SKETCH;
            default -> System.out.println("Error choice!!!");
        }
        return new Book(nameBook,authorBook,genre);
    }
}