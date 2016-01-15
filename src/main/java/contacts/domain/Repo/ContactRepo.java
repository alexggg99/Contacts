package contacts.domain.Repo;

import contacts.domain.Contact;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.io.IOException;
import java.util.List;

/**
 * Created by alexggg99 on 15.01.16.
 */

@Repository
@Transactional
public class ContactRepo {

    @PersistenceContext
    private EntityManager em;

//    @PostConstruct
//    public void setUpDatabase() throws IOException {
//        Contact contact = new Contact();
//        contact.id = 1;
//        em.merge(contact);
//    }

    public List<Contact> findAllContacts(String username) {
        Query query = em.createQuery("Select a from Contact a join fetch a.contacts where a.username = :username");
        query.setParameter("username", username);
        return query.getResultList();
    }

    public Contact findContact(int contactId) {
        Query query = em.createQuery("Select a from Contact a where a.id = :contactId");
        query.setParameter("contactId", contactId);
        return CollectionUtils.isEmpty(query.getResultList())?null: (Contact) query.getResultList().get(0);
    }

    public void merge(Contact contact){
        em.merge(contact);
    }

}
