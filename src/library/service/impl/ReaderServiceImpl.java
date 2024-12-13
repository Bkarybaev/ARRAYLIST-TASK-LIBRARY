package library.service.impl;

import library.dao.ReaderDao;
import library.dao.impl.ReaderDaoImpl;
import library.models.Reader;
import library.service.ReaderService;

import java.util.List;

public class ReaderServiceImpl implements ReaderService {
    ReaderDao readerDao = new ReaderDaoImpl();
    @Override
    public void saveReader(Reader reader) {
        readerDao.saveReader(reader);
    }

    @Override
    public List<Reader> getAllReaders() {
        return readerDao.getAllReaders();
    }

    @Override
    public Reader getReaderById(Long id) {
        return readerDao.getReaderById(id);
    }

    @Override
    public Reader updateReader(Long id, Reader reader) {
        return readerDao.updateReader(id, reader);
    }

    @Override
    public void assignReaderToLibrary(Long readerId, Long libraryId) {
        readerDao.assignReaderToLibrary(readerId, libraryId);
    }
}
