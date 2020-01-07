package it.pkg.security.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.MappedSuperclass;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import it.pkg.domain.Role;
import lombok.Data;

/**
 * Custom Implementation of {@link UserDetails}
 * 
 * @author Vittorio Valent
 *
 */
@Data
@MappedSuperclass
public class LoggedUser implements UserDetails {

	private static final long serialVersionUID = 1L;

	private String username;

	private String password;

	private final boolean accountNonExpired;

	private final boolean credentialsNonExpired;

	private final boolean accountNonLocked;

	private final boolean enabled;

	private Role role;

	public LoggedUser(String username, String password, Role role, boolean accountNonExpired, boolean credentialNonExpired,
			boolean accountNonLocked, boolean enabled) {
		this.username = username;
		this.password = password;
		this.role = role;
		this.accountNonExpired = accountNonExpired;
		this.credentialsNonExpired = credentialNonExpired;
		this.accountNonLocked = accountNonLocked;
		this.enabled = enabled;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> list = new ArrayList<GrantedAuthority>();
		list.add(new SimpleGrantedAuthority(role.getName().toString()));
		return list;
	}

}
