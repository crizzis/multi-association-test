package com.example;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@Entity
@DiscriminatorValue("post")
public class PostTag extends Tag {

    @JoinColumn(name = "resource_id")
    @ManyToOne(optional = false, fetch = LAZY)
    private Post post;
}
