package j2os.org.service;

import j2os.org.entity.Person;
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
        PersonDataAccess personDataAccess = new PersonDataAccess();
        try (personDataAccess) {
            return personDataAccess.selectAll();

        }
    }

    public Person findById(Long id) throws Exception {
        PersonDataAccess personDataAccess = new PersonDataAccess();
        try (personDataAccess) {
            return personDataAccess.selectById(id);
        }
    }

    public void save(Person person) throws Exception {
        PersonDataAccess personDataAccess = new PersonDataAccess();

        try (personDataAccess) {
            SINValidation.getInstance().checkId(person.getSin());

            personDataAccess.insert(person);
            personDataAccess.commit();
        }
    }

    public void update(Person person) throws Exception {
        PersonDataAccess personDataAccess = new PersonDataAccess();
        try (personDataAccess) {
            personDataAccess.update(person);
            personDataAccess.commit();
        }
    }

    public void remove(Long id) throws Exception {
        PersonDataAccess personDataAccess = new PersonDataAccess();
        try (personDataAccess) {
            personDataAccess.delete(id);
            personDataAccess.commit();
        }
    }


}
