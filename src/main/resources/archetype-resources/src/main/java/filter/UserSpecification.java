#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.filter;

import it.contrader.jrolamo.generics.domain.EntitySpecification;
import ${package}.domain.User;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author JRolamo
 *
 * @since 1.0
 */
public class UserSpecification extends EntitySpecification<User> {

    public UserSpecification(User filter) {
        this.filter = filter;
    }

    @Override
    public Predicate toPredicate(Root<User> r, CriteriaQuery<?> q, CriteriaBuilder cb) {
        List<Predicate> p = new ArrayList<>();

        if (filter.getId() != null) {
            p.add(cb.equal(r.get("id"), filter.getId()));
        }
        if (filter.getName() != null) {
            p.add(cb.like(r.get("nome"), "%" + filter.getName() + "%"));
        }
        if (filter.getSurname() != null) {
            p.add(cb.equal(r.get("cognome"), filter.getSurname()));
        }
        if (filter.getUsername() != null) {
            p.add(cb.equal(r.get("username"), filter.getUsername()));
        }
        return q.where(cb.and(p.toArray(new Predicate[0]))).distinct(true).getRestriction();
    }

}
