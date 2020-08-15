package com.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import java.time.Instant;

import static javax.persistence.InheritanceType.SINGLE_TABLE;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Entity
@Inheritance(strategy = SINGLE_TABLE)
@DiscriminatorColumn(name = "resource_type")
public abstract class Tag {

    @Id
    private Long id;

    private String tag;

    @CreationTimestamp
    private Instant timeCreated;
}
