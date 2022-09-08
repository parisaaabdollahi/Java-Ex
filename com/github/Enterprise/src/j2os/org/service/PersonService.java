package j2os.org.service;

import j2os.org.domain.Person;
import j2os.org.repository.PersonDA;

import java.util.List;

public class PersonService {
    private PersonService(){}
    private static PersonService personService=new PersonService();
    public static PersonService getInstance(){
        return personService;
    }

    public void save(Person person) throws Exception {
        try (PersonDA personDA=new PersonDA()){
            personDA.insert(person);
            personDA.commit();

        }
    }

    public void update(Person person) throws Exception {
        try(PersonDA personDA= new PersonDA()){
            personDA.update(person);
            personDA.commit();
        }
    }
    public void remove(long id) throws Exception {
        try (PersonDA personDA=new PersonDA()){
            personDA.delete(id);
            personDA.commit();
        }
    }

    public List<Person> findAll() throws Exception {
        try(PersonDA personDA=new PersonDA()){
            return personDA.selectAll();
        }

    }
    public List<Person> findByName(String name) throws Exception {
        try(PersonDA personDA=new PersonDA()) {
        return personDA.selectByName(name);
        }
        }

    public Person findById(long id) throws Exception {
        try(PersonDA personDA=new PersonDA()){
            return personDA.selectById(id);
        }
    }
}
