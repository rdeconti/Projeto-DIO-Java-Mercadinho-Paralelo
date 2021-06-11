package com.rdeconti.mercadinho.specification;

import com.rdeconti.mercadinho.models.AgendaModel;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class AgendaSpecification implements Specification<AgendaModel> {

    private AgendaModel filter;

    public AgendaSpecification(AgendaModel filter) {
        super();
        this.filter = filter;
    }

    @Override
    public Predicate toPredicate(Root<AgendaModel> root, CriteriaQuery<?> cq,
                                 CriteriaBuilder cb) {

        Predicate p = cb.disjunction();

        if (filter.getName() != null) {
            p.getExpressions().add(cb.like(root.get("name"), "%" + filter.getName() + "%"));
        }

        if (filter.getPhone()!= null) {
            p.getExpressions().add(cb.like(root.get("phone"), "%" + filter.getPhone() + "%"));
        }

        return p;
    }
}
