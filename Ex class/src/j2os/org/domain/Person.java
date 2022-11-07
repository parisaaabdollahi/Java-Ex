package j2os.org.domain;

import javax.persistence.*;
@Entity(name = "person")
@Table(name ="person")


public class Person {
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

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

@Column(columnDefinition = "VARCHAR2(20)")
    private String name;
    @Column(columnDefinition = "VARCHAR2(20)")
    private String family;
}
