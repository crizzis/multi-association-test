package com.example;

import lombok.*;
import org.hibernate.annotations.Any;
import org.hibernate.annotations.AnyMetaDef;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.MetaValue;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import java.time.Instant;

import static javax.persistence.FetchType.LAZY;

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

    @JoinColumn(name = "resource_id")
    @Any(metaColumn = @Column(name = "resource_type"), optional = false, fetch = LAZY)
    @AnyMetaDef(idType = "string", metaType = "string",
            metaValues = {
                    @MetaValue(value = "post", targetEntity = Post.class),
                    @MetaValue(value = "story", targetEntity = Story.class),
            })
    private Object resource;
}
