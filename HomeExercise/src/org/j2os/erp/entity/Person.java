package org.j2os.erp.entity;


import javax.persistence.*;
import java.io.Serializable;

@Table(name = "person")
@Entity(name = "person")
@NamedQueries(
        {
                @NamedQuery(query = "select o from person o where o.name=:n",name = "x1")
        }
)
public class Person implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(columnDefinition = "VARCHAR2(20)")
    private String name;

    public long getId() {
        return id;
    }

    public Person setId(long id) {
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
}
