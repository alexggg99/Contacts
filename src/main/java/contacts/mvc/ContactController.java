package contacts.mvc;

import contacts.domain.Contact;
import contacts.domain.Repo.ContactRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by alexggg99 on 15.01.16.
 */

@Controller
@RequestMapping("/contact")
public class ContactController {

    @Autowired
    private ContactRepo contactRepo;

    @RequestMapping(method = RequestMethod.GET)
    public String list(){
        List<Contact> contacts = (List<Contact>) contactRepo.findAllContacts();
        return "contacts";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String save(){
        Contact contact = new Contact();
        contact.setId(2);
        contactRepo.merge(contact);
        return "index";
    }

}
