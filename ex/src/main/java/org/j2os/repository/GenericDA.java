package org.j2os.repository;

import org.j2os.domain.Person;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class GenericDA {
    @PersistenceContext
    private EntityManager entityManager;
    public void save(Person person , )

}
