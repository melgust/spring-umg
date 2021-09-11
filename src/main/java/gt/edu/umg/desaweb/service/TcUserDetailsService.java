package gt.edu.umg.desaweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gt.edu.umg.desaweb.model.TcRole;
import gt.edu.umg.desaweb.model.TcUser;
import gt.edu.umg.desaweb.repository.TcUserRepository;
import gt.edu.umg.desaweb.repository.TcUserRoleRepository;
import gt.edu.umg.desaweb.utils.UserPrinciple;

@Service
public class TcUserDetailsService  implements UserDetailsService {
	
	@Autowired
	TcUserRepository tcUserRepository;
	
	@Autowired
	TcUserRoleRepository tcUserRoleRepository;
	
	@Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        TcUser tcUser = tcUserRepository.findByUsername(username).orElseThrow(
            () -> new UsernameNotFoundException("Usuario no existe: " + username)
        );
        List<TcRole> roles = tcUserRoleRepository.findAllByTcUser(tcUser);
        return UserPrinciple.build(tcUser, roles);
    }

}
