package library.dao.impl;

import library.dao.ReaderDao;
import library.models.Database;
import library.models.Library;
import library.models.Reader;

import java.util.List;

public class ReaderDaoImpl implements ReaderDao {

    @Override
    public void saveReader(Reader reader) {
        Database.readers.add(reader);
    }

    @Override
    public List<Reader> getAllReaders() {
        return Database.readers;
    }

    @Override
    public Reader getReaderById(Long id) {
        for (Reader reader : Database.readers) {
            if (reader.getId().equals(id)) {
                return reader;
            }
        }
        return null;
    }

    @Override
    public Reader updateReader(Long id, Reader reader) {
        for (Reader r : Database.readers) {
            if (r.getId().equals(id)) {
                r.setEmail(reader.getEmail());
                r.setGender(reader.getGender());
                r.setFullName(reader.getFullName());
                r.setPhoneNumber(reader.getPhoneNumber());
                return r;
            }
        }
        return null;
    }

    @Override
    public void assignReaderToLibrary(Long readerId, Long libraryId) {
        for (Library library : Database.libraries) {
            if (library.getId().equals(libraryId)) {
                for (Reader reader : Database.readers) {
                    if (reader.getId().equals(readerId)) {
                        library.getReaders().add(reader);
                        System.out.println("Successfully add reader!!");
                    break;
                    }
                }
            }
        }
    }
}
