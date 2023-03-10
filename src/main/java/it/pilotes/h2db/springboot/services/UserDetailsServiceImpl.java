package it.pilotes.h2db.springboot.services;

import it.pilotes.h2db.springboot.dto.security.Role;
import it.pilotes.h2db.springboot.dto.security.User;
import java.util.HashSet;
import java.util.Set;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = new User();
		user.setUserename("username");
		user.setPassword("password");
		Set<Role> roles = new HashSet<>();
		Role role = new Role();
		role.setId("1");
		role.setName("ADMIN");
		roles.add(role);
		user.setRoles(roles);

		return UserDetailsImpl.build(user);
	}

}
