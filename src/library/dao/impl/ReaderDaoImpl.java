package library.dao.impl;

import library.dao.ReaderDao;
import library.models.Reader;

import java.util.List;

public class ReaderDaoImpl implements ReaderDao {

    @Override
    public void saveReader(Reader reader) {

    }

    @Override
    public List<Reader> getAllReaders() {
        return List.of();
    }

    @Override
    public Reader getReaderById(Long id) {
        return null;
    }

    @Override
    public Reader updateReader(Long id, Reader reader) {
        return null;
    }

    @Override
    public void assignReaderToLibrary(Long readerId, Long libraryId) {

    }
}
