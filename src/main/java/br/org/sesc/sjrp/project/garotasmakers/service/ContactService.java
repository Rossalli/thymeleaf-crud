package br.org.sesc.sjrp.project.garotasmakers.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.sesc.sjrp.project.garotasmakers.model.Contact;
import br.org.sesc.sjrp.project.garotasmakers.repository.ContactRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    public void createOrUpdate(Contact contact) {
        contactRepository.save(contact);
    }

    public void delete(Long id) {
        Contact contact = getById(id);
        contactRepository.save(contact.deactivate());
    }

    public Contact getById(Long id) {
        return contactRepository.findById(id).orElse(new Contact());
    }

    public List<Contact> getAll() {
        return contactRepository.findAll();
    }
}
