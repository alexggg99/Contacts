package contacts.config;

import contacts.domain.Contact;
import contacts.domain.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by alexggg99 on 15.01.16.
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

//    @Autowired
//    private UserRepo userRepo;
//    @Autowired
//    private RoleRepo roleRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        net.bonvio.model.User user = userRepo.findByUsername(username);
        Contact user = null;
        if(username.equals("user")){
            user = new Contact();
            user.authority = new Role("USER");
            user.username = "user";
            user.password = "123";
        }
        if (user == null) {
            throw new UsernameNotFoundException(String.format("User %s does not exist!", username));
        }

        List<GrantedAuthority> authorities = buildUserAuthority(user.authority);

        return buildUserForAuthentication(user, authorities);
    }


    public User buildUserForAuthentication(contacts.domain.Contact user,
                                           List<GrantedAuthority> authorities) {
        return new User(user.username, user.password,
                true, true, true, true, authorities);
    }

    private List<GrantedAuthority> buildUserAuthority(Role role) {

        Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();

        //for (int i = 0; i < roles.size(); i ++){

        //String role = roles.get(i).getAuthority(); //TODO Превратить в строку типа "ROLE_ADMIN"

        setAuths.add(new SimpleGrantedAuthority(role.getAuthority()));


        //}

        List<GrantedAuthority> result = new ArrayList<GrantedAuthority>(
                setAuths);

        return result;
    }

//    public UserDetails getUser(net.bonvio.model.User user ){
//        List<GrantedAuthority> authorities = new ArrayList<>();
//        if(user.authority != null){
//            authorities = buildUserAuthority(user.authority);
//        }
//
//        return buildUserForAuthentication(user, authorities);
//    }

}

