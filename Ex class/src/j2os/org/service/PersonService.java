package j2os.org.service;

import j2os.org.common.JPA;
import j2os.org.domain.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class PersonService {
    public static void main(String[] args) {

    }
    public void save()
    {
        EntityManager entityManager= JPA.getEntityManager();
        EntityTransaction entityTransaction=entityManager.getTransaction();
        entityTransaction.begin();

        Person person=new Person().

        entityTransaction.commit();
        entityManager.close();
    }

}
