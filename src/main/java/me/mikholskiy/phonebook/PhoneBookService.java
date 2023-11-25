package me.mikholskiy.phonebook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class PhoneBookService {
    private PhoneBookRepository repository;

    @Autowired
    public PhoneBookService setRepository(PhoneBookRepository repository) {
        this.repository = repository;
        return this;
    }

    public void save(PhoneBookRecord phoneBookRecord) {
        repository.save(phoneBookRecord);
    }

    public Optional<PhoneBookRecord> getById(Long id) {
        return repository.findById(id);
    }

    public List<PhoneBookRecord> getAll() {
        return repository.findAll();
    }

    public void update(PhoneBookRecord phoneBookRecord) {
        this.repository.save(phoneBookRecord);
    }

    public void deleteById(Long id) {
        this.repository.deleteById(id);
    }

    public void delete(PhoneBookRecord record) {
        deleteById(record.getId());
    }
}
