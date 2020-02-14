package lk.ac.cmb.ucsc.euphoria.service.impl;

import lk.ac.cmb.ucsc.euphoria.model.common.LoginCredentials;
import lk.ac.cmb.ucsc.euphoria.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class SecurityUserDetailsService implements UserDetailsService {


    private final LoginRepository loginRepository;

    @Autowired
    public SecurityUserDetailsService(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LoginCredentials user = loginRepository.getLoginCredentialsByUsername(username);
        return new User(user.getUsername(),user.getPassword(), new ArrayList<>());
    }
}
