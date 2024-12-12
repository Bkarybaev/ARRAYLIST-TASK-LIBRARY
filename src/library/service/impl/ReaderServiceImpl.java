package library.service.impl;

import library.models.Reader;
import library.service.ReaderService;

import java.util.List;

public class ReaderServiceImpl implements ReaderService {
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
