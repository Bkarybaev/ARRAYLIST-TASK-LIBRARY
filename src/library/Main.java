package library;

import library.enums.Genre;
import library.models.Book;
import library.models.Library;
import library.service.impl.BookServiceImpl;
import library.service.impl.LibraryServiceImpl;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static LibraryServiceImpl libraryService = new LibraryServiceImpl();
    static BookServiceImpl bookService = new BookServiceImpl();

    public static void main(String[] args) {

        while (true) {
            System.out.print("""
                    1.Add library
                    2.Get All library
                    3.Get by id library
                    4.Update library
                    5.Deleted by id library
                    6.Book save
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
                case "0" -> {
                    return;
                }
                default -> {
                    System.out.println("ERROR choice");
                }
            }
        }
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