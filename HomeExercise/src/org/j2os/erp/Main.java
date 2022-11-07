package org.j2os.erp;

import org.j2os.erp.common.Spring;
import org.j2os.erp.entity.Person;
import org.j2os.erp.service.PersonService;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        PersonService personService = (PersonService) Spring.getBean("personService");
        Person person = new Person().setName("saeed");
        personService.save(person);

        for (Person person1 : personService.findAll())
        {
            System.out.println(person1.getName());
        }

      /*  Map<String,Object> map = new HashMap<>();
        map.put("n","Sami");

        for (Person personDb: personService.findAllByName2(map))
        {
            System.out.println(personDb.getName());
        }

        for (Person personDb: personService.findAllByName("o.name=:n",map))
        {
            System.out.println(personDb.getName());
        }*/
    }
}
