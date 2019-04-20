package com.smartdude;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.smartdude.entity.User;
import com.smartdude.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository usersRepository;
    
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<User> optionalUser = usersRepository.findByUserName(userName);
        return Optional.ofNullable(optionalUser).orElseThrow(()->new UsernameNotFoundException("Username Not Found"))
               .map(UserDetailsImpl::new).get();
    }
}
