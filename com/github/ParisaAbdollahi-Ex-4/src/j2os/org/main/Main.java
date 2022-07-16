package j2os.org.main;

import j2os.org.entity.Person;
import j2os.org.error.WrapperMessage;
import j2os.org.service.PersonService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
          PersonService.getInstance().save(new Person().setId(6L).setName("akbar").setFamily("ghorbani").setSin(458964585L));
            //PersonService.getInstance().update(new Person().setId(3L).setName("ghazale").setFamily("ghorbani").setSin(45446287L));
           // PersonService.getInstance().remove(4L);

            List<Person> personList=PersonService.getInstance().findAll();
            for (Person p: personList){
                System.out.println(p.getId()+"...."+ p.getName()+"....."+p.getFamily()+"..."+p.getSin());
                }
      /* Person person = PersonService.getInstance().findById(1L);
            System.out.println(person.getId()+"...."+ person.getName()+"....."+person.getFamily()+"..."+person.getSin());
*/

        } catch (Exception e) {
            WrapperMessage.getErrorMessage(e);
        }

    }

}
