package com.example;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.Collection;

@Getter
@Setter
@Entity
public class Post {

    @Id
    private String id;

    @OneToMany
    @Immutable
    @JoinColumn(name = "resource_id", referencedColumnName = "id", insertable = false, updatable = false)
    @Where(clause = "resource_type = 'post'")
    private Collection<Tag> tags;
}
