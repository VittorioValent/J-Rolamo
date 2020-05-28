#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.security;

import ${package}.domain.Role;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * Custom Implementation of {@link UserDetails}
 *
 * @author JRolamo
 * @since 1.0
 *
 */
@Data
public class LoggedUser implements UserDetails {

    private static final long serialVersionUID = 1L;

    private final String username;

    private final String password;

    private final boolean accountNonExpired;

    private final boolean credentialsNonExpired;

    private final boolean accountNonLocked;

    private final boolean enabled;

    private final Role role;

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
        List<GrantedAuthority> list = new ArrayList<>();
        list.add(new SimpleGrantedAuthority(role.getName()));
        return list;
    }

}
