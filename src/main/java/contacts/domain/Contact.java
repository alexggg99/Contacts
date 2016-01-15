package contacts.domain;

import javax.persistence.*;

/**
 * Created by alexggg99 on 15.01.16.
 */

@Entity
@Table(name="CONTACT")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    public long id;

}
