package j2os.org.service;



import j2os.org.common.JPA;
import j2os.org.entity.Person;
import j2os.org.entity.PersonInformation;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class PersonService {
    public static void findAll()
    {
        EntityManager entityManager = JPA.getEntityManager();
       Query query =entityManager.createQuery("select o from person o");
        List<Person> personList = query.getResultList();
        for (Person person : personList) {
            System.out.println(person.getId());
            System.out.println(person.getName());
            System.out.println(person.getFamily());
            System.out.println("    "+person.getPersonInformation().getId());
            System.out.println("    "+person.getPersonInformation().getMail());
            System.out.println("*******************");
        }
    }
    public static void save() {
        EntityManager entityManager = JPA.getEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        Person person = new Person("parisa","abdollahi");
        PersonInformation personInformation = new PersonInformation("parisa@dpi.ir");
        person.setPersonInformation(personInformation);

        entityManager.persist(person);

        entityTransaction.commit();
        entityManager.close();
    }

    public static void main(String[] args) {
findAll();
    }
}
