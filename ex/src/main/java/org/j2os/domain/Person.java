package org.j2os.domain;

import com.sun.javafx.beans.IDProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
@Getter
@Setter
@AllArgsConstructor

@Table(name = "person")
@Entity(name="person")
public class Person implements Serializable {
@Id
@GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

@Column(columnDefinition = "VARCHAR2(20)")
    private String family;
}
