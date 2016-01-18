package contacts.mvc;

import contacts.domain.Contact;
import contacts.domain.Repo.ContactRepo;
import contacts.domain.User;
import contacts.services.AuthUtl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by alexggg99 on 15.01.16.
 */

@Controller
@RequestMapping("/contact")
public class ContactController {

    @Autowired
    private ContactRepo contactRepo;
    @Autowired
    private AuthUtl authUtl;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Contact> getContacts(){
        String username = authUtl.getUserName();
        List<Contact> contacts = (List<Contact>) contactRepo.findAllContacts(username);
        return contacts;
    }

    @RequestMapping(value = "/{contactId}", method = RequestMethod.GET)
    @ResponseBody
    public List<Contact> getContact(){
        String username = authUtl.getUserName();
        List<Contact> contacts = (List<Contact>) contactRepo.findAllContacts(username);
        return contacts;
    }

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody Contact createContact(@RequestBody Contact contact){
        User user = authUtl.getUser();
        contact.setUser(user);
        contactRepo.persistContact(contact);
        return contact;
    }

    @RequestMapping(method = RequestMethod.PUT)
    public @ResponseBody Contact updateContact(@RequestBody Contact contact){
        contactRepo.update(contact);
        return contact;
    }

    @RequestMapping(value = "/{contactId}",method = RequestMethod.DELETE)
    public @ResponseBody Contact deleteContact(@PathVariable int contactId){
        Contact contact = contactRepo.deleteContact(contactId);
        return contact;
    }

}
