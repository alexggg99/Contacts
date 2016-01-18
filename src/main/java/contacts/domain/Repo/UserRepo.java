package contacts.domain.Repo;

import contacts.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by alexggg99 on 18.01.16.
 */

public interface UserRepo extends CrudRepository<User, Long> {
    public User findUserByUsername(String username);
}
