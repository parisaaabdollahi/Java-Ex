package j2os.org.entity;


import javax.persistence.*;


@Entity(name = "personInformation")
@Table(name = "person_information")
public class PersonInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(columnDefinition = "varchar2(20)")
    private String mail;

    @OneToOne(mappedBy = "personInformation")
    private Person person;

    public Person getPerson() {
        return person;
    }

    public PersonInformation setPerson(Person person) {
        this.person = person;
        return this;
    }

    public int getId() {
        return id;
    }

    public PersonInformation setId(int id) {
        this.id = id;
        return this;
    }

    public String getMail() {
        return mail;
    }

    public PersonInformation setMail(String mail) {
        this.mail = mail;
        return this;
    }

    public PersonInformation() {
    }

    public PersonInformation(int id, String mail) {
        this.id = id;
        this.mail = mail;
    }

    public PersonInformation(String mail) {
        this.mail = mail;
    }
}
