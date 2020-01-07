package it.pkg.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.pkg.domain.User;
import it.pkg.domain.dto.UserDTO;
import it.pkg.repository.RoleRepository;
import it.pkg.repository.UserRepository;
import it.pkg.security.utils.LoggedUser;
import it.pkg.service.mapper.UserMapper;

/**
 * 
 * Authentication and registration Service. It implements
 * {@link UserDetailsService}. This classs is responsible for encrypting the
 * password.
 * 
 * @author Vittorio Valent
 *
 * @see PasswordEncoder
 */
@Service
public class JWTUserService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new LoggedUser(user.getUsername(), user.getPassword(), user.getRole(), user.getAccountNonExpired(), user.getCredentialsNonExpired(), user.getAccountNonLocked(), user.getEnabled());
	}

	public UserDTO save(UserDTO dto) {
		User user = userMapper.toEntity(dto);
		user.setPassword(bcryptEncoder.encode(dto.getPassword()));
		user.setRole(roleRepository.findByName("ROLE_USER").get(0));
		return userMapper.toDTO(userRepository.save(user));
	}

}
