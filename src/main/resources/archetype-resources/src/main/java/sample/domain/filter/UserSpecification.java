#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.sample.domain.filter;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import ${package}.sample.domain.User;
import ${package}.sample.domain.generic.EntitySpecification;

/**
 * 
 * @author Vittorio Valent
 *
 */
public class UserSpecification extends EntitySpecification<User> {

	private static final long serialVersionUID = 7514734460419746896L;

	public UserSpecification(User filter) {
		this.filter = filter;
	}

	@Override
	public Predicate toPredicate(Root<User> r, CriteriaQuery<?> q, CriteriaBuilder cb) {
		List<Predicate> p = new ArrayList<>();

		if (filter.getId() != null) {
			p.add(cb.equal(r.get("id"), filter.getId()));
		}
		if (filter.getNome() != null) {
			p.add(cb.like(r.get("nome"), "%" + filter.getNome() + "%"));
		}
		if (filter.getCognome() != null) {
			p.add(cb.equal(r.get("cognome"), filter.getCognome()));
		}
		if (filter.getUsername() != null) {
			p.add(cb.equal(r.get("username"), filter.getUsername()));
		}
		return q.where(cb.and(p.toArray(new Predicate[0]))).distinct(true).getRestriction();
	}

}
