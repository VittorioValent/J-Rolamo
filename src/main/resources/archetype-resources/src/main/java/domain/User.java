#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.domain;

import it.jrolamo.generics.domain.AuditModel;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author JRolamo
 *
 * @since 1.0
 */
@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class User extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;

    private String password;

    @Column(columnDefinition = "boolean default true")
    private Boolean accountNonExpired;

    @Column(columnDefinition = "boolean default true")
    private Boolean credentialsNonExpired;

    @Column(columnDefinition = "boolean default true")
    private Boolean accountNonLocked;

    @Column(columnDefinition = "boolean default true")

    private Boolean enabled;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn
    private Role role;

    private String name;

    private String surname;

}
