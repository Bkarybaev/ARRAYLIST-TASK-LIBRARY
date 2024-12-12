package library.dao.impl;

import library.dao.LibraryDao;
import library.models.Database;
import library.models.Library;

import java.util.List;

public class LibraryDaoImpl implements LibraryDao {

    @Override
    public List<Library> saveLibrary(List<Library> libraries) {
        Database.libraries.addAll(libraries);
        return libraries;
    }

    @Override
    public List<Library> getAllLibraries() {
        return Database.libraries;
    }

    @Override
    public Library getLibraryById(Long id) {
        for (Library library : Database.libraries) {
            if (id.equals(library.getId())) {
                return library;
            }
        }
        return null;
    }

    @Override
    public Library updateLibrary(Long id, Library library) {
        Library s  = null;
        for (Library l : Database.libraries) {
            if (l.getId().equals(id)){
                l.setName(library.getName());
                l.setAddress(library.getAddress());
                s=l;
            }
        }
        return s;
    }

    @Override
    public String deleteLibrary(Long id) {
        for (int i = 0; i < Database.libraries.size(); i++) {
            if (Database.libraries.get(i).getId().equals(id)){
                Database.libraries.remove(i);
                return "deleted !!";
            }
        }
        return "not fount !!";
    }
}
