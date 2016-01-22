package contacts.domain.Repo;

import contacts.domain.User;
import contacts.domain.UserSettings;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by alexggg99 on 21.01.16.
 */
public interface UserSettingsRepo extends CrudRepository<UserSettings, Long> {

    @Query("Select s from UserSettings s left join s.user u where u.username = ?1")
    public List<UserSettings> findUserSettingsByUser(String username);

}
