package org.example.bookstore.model;

import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class Role {

    //@Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY);

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public String getName() {
        return name;
    }
}


//@Entity
//@Table(name = "roles")
//public class Role {
// @Id
// @GeneratedValue(strategy = GenerationType.IDENTITY)
// private Long id;
// private String name;
////...
//}
