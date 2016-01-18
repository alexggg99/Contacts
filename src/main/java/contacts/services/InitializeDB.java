package contacts.services;

import contacts.domain.Contact;
import contacts.domain.Repo.ContactRepo;
import contacts.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by alexggg99 on 18.01.16.
 */
@Service
public class InitializeDB {

    @Autowired
    private ContactRepo contactRepo;

    public void insertContacts(User user){
        Contact contact = new Contact("Ivanov Ivan", "1236556", "911 981 8213", user);
        contactRepo.persistContact(contact);
        contact = new Contact("Sania Vanin", "7890155", "963 112 7700", user);
        contactRepo.persistContact(contact);
    }

}
