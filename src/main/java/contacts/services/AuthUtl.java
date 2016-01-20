package contacts.services;

import contacts.domain.Repo.UserRepo;
import contacts.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by alexggg99 on 15.01.16.
 */

@Service
public class AuthUtl {

    @Autowired
    private UserRepo userRepo;

    public String getUserName(){
        Authentication auth = SecurityContextHolder.getContext()
                .getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            UserDetails userDetail = (UserDetails) auth.getPrincipal();
            return userDetail.getUsername();
        }
        return null;
    }

    public User getUser(){
        Authentication auth = SecurityContextHolder.getContext()
                .getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            UserDetails userDetail = (UserDetails) auth.getPrincipal();
            return userRepo.findUserByUsername(userDetail.getUsername());
        }
        return null;
    }

}
