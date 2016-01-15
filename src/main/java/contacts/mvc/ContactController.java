package contacts.mvc;

import contacts.domain.Contact;
import contacts.domain.Repo.ContactRepo;
import contacts.services.AuthUtl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @RequestMapping
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
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

}
