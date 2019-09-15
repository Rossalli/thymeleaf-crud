package br.org.sesc.sjrp.project.garotasmakers.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.org.sesc.sjrp.project.garotasmakers.model.Contact;
import br.org.sesc.sjrp.project.garotasmakers.service.ContactService;

@Controller
public class ContactController {

    @Autowired
    private ContactService contactService;

    @GetMapping
    public ModelAndView getAll() {
        ModelAndView mv = new ModelAndView("/index");
        return mv.addObject("contacts", contactService.getAll());
    }

    @GetMapping("/contact")
    public ModelAndView contact(Contact contact) {
        ModelAndView mv = new ModelAndView("/contact");
        return mv.addObject("contact", contact);
    }

    @PostMapping("/save")
    public ModelAndView save(@Valid Contact contact, BindingResult result) {

        if (result.hasErrors()) {
            return contact(contact);
        }
        contactService.createOrUpdate(contact);
        return getAll();
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable("id") Long id) {
        return contact(contactService.getById(id));
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Long id) {
        contactService.delete(id);
        return getAll();
    }

}
