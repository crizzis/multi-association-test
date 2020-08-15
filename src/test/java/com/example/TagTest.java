package com.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import javax.persistence.EntityManager;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;

@DataJpaTest
@Sql("classpath:data-init.sql")
class TagTest {

    @Autowired
    private EntityManager entityManager;

    @Test
    void shouldReadCorrectTagsForExistingPost() {
        //when
        Post existingPost = entityManager.find(Post.class, "post-1");
        Tag existingPostTag = entityManager.find(Tag.class, 1L);

        //then
        assertThat(existingPost.getTags(), containsInAnyOrder(existingPostTag));
    }

    @Test
    void addingNewTagShouldBeReflectedInPost() {
        //given
        Post existingPost = entityManager.find(Post.class, "post-1");
        Tag existingTag = entityManager.find(Tag.class, 1L);
        Tag newTag = Tag.builder()
                .id(3L)
                .resourceId(existingPost.getId())
                .resourceType("post")
                .tag("some other tag")
                .build();

        //when
        entityManager.persist(newTag);
        entityManager.flush();
        entityManager.refresh(existingPost);

        //then
        assertThat(existingPost.getTags(), containsInAnyOrder(existingTag, newTag));
    }

    @Test
    void shouldReadCorrectTagsForExistingStory() {
        //when
        Story existingStory = entityManager.find(Story.class, "story-1");
        Tag existingStoryTag = entityManager.find(Tag.class, 2L);

        //then
        assertThat(existingStory.getTags(), containsInAnyOrder(existingStoryTag));
    }
}