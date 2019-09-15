package br.org.sesc.sjrp.project.garotasmakers.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.org.sesc.sjrp.project.garotasmakers.model.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {

    List<Contact> findAllByActiveIsTrue();
}
