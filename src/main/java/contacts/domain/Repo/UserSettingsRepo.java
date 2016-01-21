package contacts.domain.Repo;

import contacts.domain.UserSettings;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by alexggg99 on 21.01.16.
 */
public interface UserSettingsRepo extends CrudRepository<UserSettings, Long> {
}
