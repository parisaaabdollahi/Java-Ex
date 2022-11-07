package org.j2os.erp.service;

import org.j2os.erp.entity.Person;
import org.j2os.erp.repository.GenericDA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service

public class PersonService {
    @Autowired
    private GenericDA<Person, Long> genericDA;

    @Transactional
    public void save(Person person) {
        genericDA.insert(person);
    }

    @Transactional
    public void update(Person person) {
        genericDA.update(person);
    }

    @Transactional
    public void remove(Person person) {
        genericDA.remove(person);
    }

    public List<Person> findAll() {
        return genericDA.selectAll(Person.class);
    }

    public List<Person> findAllByName(String afterWhere, Map<String, Object> map) {
        return genericDA.selectAll(Person.class, afterWhere, map);
    }

    public List<Person> findAllByName2(Map<String, Object> map) {
        return genericDA.selectAllByNamedQuery("x1", map);
    }

    public Person findOne() {
        return genericDA.selectOne(Person.class, 1L);
    }
}
