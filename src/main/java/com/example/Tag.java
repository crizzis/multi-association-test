package com.example;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.Instant;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Tag {

    @Id
    private Long id;

    private String tag;

    @CreationTimestamp
    private Instant timeCreated;

    @Column(name = "resource_id")
    private String resourceId;

    private String resourceType;
}
