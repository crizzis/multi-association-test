package com.example;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Collection;

@Getter
@Setter
@Entity
public class Post {

    @Id
    private String id;

    @OneToMany(mappedBy = "post")
    private Collection<PostTag> tags;
}
