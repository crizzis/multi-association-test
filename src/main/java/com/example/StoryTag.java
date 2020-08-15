package com.example;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import static javax.persistence.FetchType.LAZY;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@Entity
@DiscriminatorValue("story")
public class StoryTag extends Tag {

    @JoinColumn(name = "resource_id")
    @ManyToOne(optional = false, fetch = LAZY)
    private Story story;
}
