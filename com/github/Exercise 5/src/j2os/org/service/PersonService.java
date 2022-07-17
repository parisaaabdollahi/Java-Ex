package j2os.org.service;

import j2os.org.domain.Person;
import j2os.org.repository.PersonDataAccess;


import java.util.List;

public class PersonService {
    private PersonService() {
    }

    private static final PersonService PERSON_SERVICE = new PersonService();

    public static PersonService getInstance() {
        return PERSON_SERVICE;
    }


    public List<Person> findAll() throws Exception {
        try (PersonDataAccess personDataAccess = new PersonDataAccess()) {
            return personDataAccess.selectAll();

        }
    }
    public Person findById(Long id) throws Exception {

        try (PersonDataAccess personDataAccess = new PersonDataAccess()) {
            return personDataAccess.selectById(id);
        }
    }

    public void save(Person person) throws Exception {


        try (PersonDataAccess personDataAccess = new PersonDataAccess()) {
            SINValidation.getInstance().checkId(person.getSin());

            personDataAccess.insert(person);
            personDataAccess.commit();
        }
    }

    public void update(Person person) throws Exception {

        try (PersonDataAccess personDataAccess=new PersonDataAccess()){
            personDataAccess.update(person);
            personDataAccess.commit();

        }
    }

    public void remove(Long id) throws Exception {

        try (PersonDataAccess personDataAccess = new PersonDataAccess()) {
            personDataAccess.delete(id);
            personDataAccess.commit();
        }
    }


}
