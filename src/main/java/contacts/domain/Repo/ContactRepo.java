package contacts.domain.Repo;

import contacts.domain.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by alexggg99 on 15.01.16.
 */

@Repository
@Transactional
public class ContactRepo{

    @PersistenceContext
    private EntityManager em;

    public List<Contact> findAllContacts() {
        Query query = em.createQuery("Select a from Contact a");
        return query.getResultList();
    }

    public void save(Contact contact){
        em.merge(contact);
    }

}
