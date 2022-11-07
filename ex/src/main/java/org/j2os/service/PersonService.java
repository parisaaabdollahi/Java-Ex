package org.j2os.service;

import org.j2os.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
@Service
public class PersonService {
@Autowired
private GenericDA<Person,Long> genericDA;

    @Transactional
    public void save(Person person){
        genericDA.save(person);}



}
