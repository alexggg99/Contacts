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
@RequestMapping("/list")
public class ListController {

    @Autowired
    private ContactRepo contactRepo;

    @RequestMapping(method = RequestMethod.GET)
    public String index(){
        List<Contact> contacts = (List<Contact>) contactRepo.findAllContacts();
        return "index";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String save(){
        Contact contact = new Contact();
        contact.id = 2;
        contactRepo.save(contact);
        return "index";
    }

}
