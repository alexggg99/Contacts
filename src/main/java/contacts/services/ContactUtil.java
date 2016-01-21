package contacts.services;

import contacts.domain.Contact;
import org.springframework.stereotype.Service;

import java.lang.reflect.*;

/**
 * Created by alexggg99 on 20.01.16.
 */

@Service
public class ContactUtil {

    public Field[] getContactFields() throws ClassNotFoundException {
        Field[] fields = Contact.class.getDeclaredFields();
        System.out.println(fields);
        return  fields;
    }

}
