package j2os.org.entity;


import javax.persistence.*;

@Entity(name = "person")
@Table(name = "person")
public class  Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "NUMBER")
    private int id;
    @Column(columnDefinition = "VARCHAR2(20)")
    private String name;
    @Column(columnDefinition = "VARCHAR2(20)")
    private String family;
    @OneToOne( cascade = CascadeType.ALL)
    @JoinColumn(name = "PI_FK")
    private PersonInformation personInformation;

    public Person setPersonInformation(PersonInformation personInformation) {
        this.personInformation = personInformation;
        return this;
    }

    public PersonInformation getPersonInformation() {
        return personInformation;
    }

    public Person() {
    }

    public Person(String name, String family) {
        this.name = name;
        this.family = family;
    }

    public Person(int id, String name, String family) {
        this.id = id;
        this.name = name;
        this.family = family;
    }

    public int getId() {
        return id;
    }

    public Person setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Person setName(String name) {
        this.name = name;
        return this;
    }

    public String getFamily() {
        return family;
    }

    public Person setFamily(String family) {
        this.family = family;
        return this;
    }
}
