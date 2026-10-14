package com.github.techChallenge.infrastructure.entities.usertype;

import com.github.techChallenge.domain.usertype.UserType;
import jakarta.persistence.*;

@Entity
@Table(name="usuarios_tipo")
public class UserTypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "titulo", length = 50)
    private String title;

    public int getId() {
        return id;
    }

    public void setId(int id) {this.id = id;}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public UserTypeEntity() {
    }

    public UserTypeEntity(UserType userType) {
        this.id = userType.getId();
        this.title = userType.getTitle();
    }
}
