package contacts.mvc;

import contacts.domain.Contact;
import contacts.domain.Repo.ContactRepo;
import contacts.domain.User;
import contacts.services.AuthUtl;
import contacts.services.ContactUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.*;
import java.util.ArrayList;
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
    @Autowired
    private ContactUtil contactUtil;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Contact> getContacts(){
        String username = authUtl.getUserName();
        List<Contact> contacts = (List<Contact>) contactRepo.findAllContacts(username);
        return contacts;
    }

    @RequestMapping(value = "/{contactId}", method = RequestMethod.GET)
    @ResponseBody
    public Contact getContact(@PathVariable long contactId){
        String username = authUtl.getUserName();
        Contact contact = contactRepo.findContact(contactId);
        return contact;
    }

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody Contact createContact(@RequestBody Contact contact){
        User user = authUtl.getUser();
        contact.setUser(user);
        contactRepo.persistContact(contact);
        return contact;
    }

    @RequestMapping(value = "/{contactId}",method = RequestMethod.PUT)
    public @ResponseBody Contact updateContact(@PathVariable long contactId ,@RequestBody Contact contact){
        //Contact contact = contactRepo.findContact(contactId);
        contact.setUser(authUtl.getUser());
        contactRepo.update(contact);
        return contact;
    }

    @RequestMapping(value = "/{contactId}",method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteContact(@PathVariable long contactId){
        contactRepo.deleteContact(contactId);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
