package it.pilotes.h2db.springboot.services;

import com.knf.dev.models.Employee;
import com.knf.dev.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String employeename) throws UsernameNotFoundException {

		Employee employee = employeeRepository.findByEmployeename(employeename)
				.orElseThrow(() -> new UsernameNotFoundException("Employee Not Found with username: " + employeename));

		return UserDetailsImpl.build(employee);
	}

}
