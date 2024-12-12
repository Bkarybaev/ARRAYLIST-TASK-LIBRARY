package library.service.impl;

import library.dao.impl.LibraryDaoImpl;
import library.models.Database;
import library.models.Library;
import library.service.LibraryService;

import java.util.List;

public class LibraryServiceImpl implements LibraryService {
    LibraryDaoImpl libraryDao = new LibraryDaoImpl();
    @Override
    public List<Library> saveLibrary(List<Library> libraries) {
        if (libraries.isEmpty()){
            try {
                throw new RuntimeException("library null!!");
            }catch (RuntimeException e){
                System.out.println(e.getMessage());
            }
        }

       libraryDao.saveLibrary(libraries);
        return libraries;
    }

    @Override
    public List<Library> getAllLibraries() {
        return libraryDao.getAllLibraries();
    }

    @Override
    public Library getLibraryById(Long id) {
        if (id == null || id <= 0){
            try {
                throw new RuntimeException("Invalid id !!");
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }else {
            for (Library library : Database.libraries) {
                if (id.equals(library.getId())){
                   return libraryDao.getLibraryById(id);
                }
            }
            System.out.println("not fount " + id + " !!");
        }
        return null;
    }

    @Override
    public Library updateLibrary(Long id, Library library) {
        return libraryDao.updateLibrary(id, library);
    }

    @Override
    public String deleteLibrary(Long id) {
        return libraryDao.deleteLibrary(id);
    }
}
