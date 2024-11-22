package co.edu.cue.ParkSloth.services.impl;

import co.edu.cue.ParkSloth.config.CustomUserDetails;
import co.edu.cue.ParkSloth.domain.entities.User;
import co.edu.cue.ParkSloth.repositories.UserRespository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRespository userRespository;

    public CustomUserDetailsService(UserRespository userRespository) {
        this.userRespository = userRespository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRespository.findByUsername(username);
        return new CustomUserDetails(user);
    }
}
