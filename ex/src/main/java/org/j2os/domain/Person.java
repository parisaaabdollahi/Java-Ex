package org.j2os.domain;

import com.sun.javafx.beans.IDProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


@Table(name = "person")
@Entity(name="person")
public class Person implements Serializable {
@Id
@GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

@Column(columnDefinition = "VARCHAR2(20)")
    private String family;
@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Id_FK")
    private Car car;

    public Long getId() {
        return id;
    }

    public Person setId(Long id) {
        this.id = id;
        return this;
    }

    public String getFamily() {
        return family;
    }

    public Person setFamily(String family) {
        this.family = family;
        return this;
    }

    public Car getCar() {
        return car;
    }

    public Person setCar(Car car) {
        this.car = car;
        return this;
    }
}
