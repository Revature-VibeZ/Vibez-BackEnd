package com.revature.vibez;

import com.revature.DAOs.PostDao;
import com.revature.models.Post;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class DaoJpaUnitTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private PostDao postDao;

    @Test
    public void should_find_no_posts_if_postdao_is_empty() {
        Iterable<Post> posts = postDao.findAll();

        assertThat(posts).isEmpty();
    }

    @Test
    public void should_store_a_post(){

        Post post = new Post();
        post.setTitle("Simple title");
        post.setContent("Simple content");
        post.setUsername("usernameSimple");
        post.setUuid("uuidSimple");
        postDao.save(post);

        assertThat(post).hasFieldOrPropertyWithValue("title", "Simple title");
        assertThat(post).hasFieldOrPropertyWithValue("content", "Simple content");
        assertThat(post).hasFieldOrPropertyWithValue("uuid", "uuidSimple");
        assertThat(post).hasFieldOrPropertyWithValue("username", "usernameSimple");

    }

    @Test
    public void should_find_all_posts() {
        Post post1 = new Post();
        post1.setTitle("Simple title");
        post1.setContent("Simple content");
        post1.setUsername("usernameSimple");
        post1.setUuid("uuidSimple");
        postDao.save(post1);
        entityManager.persist(post1);
    
        Post post2 = new Post();
        post2.setTitle("Simple title2");
        post2.setContent("Simple content2");
        post2.setUsername("usernameSimple2");
        post2.setUuid("uuidSimple2");
        postDao.save(post2);
        entityManager.persist(post2);
    
        Post post3 = new Post();
        post3.setTitle("Simple title3");
        post3.setContent("Simple content3");
        post3.setUsername("usernameSimple3");
        post3.setUuid("uuidSimple3");
        postDao.save(post3);
        entityManager.persist(post3);
    
        Iterable<Post> posts = postDao.findAll();
    
        assertThat(posts).hasSize(3).contains(post1, post2, post3);
    }

    @Test
    public void should_find_posts_by_id() {
        Post post1 = new Post();
        post1.setTitle("Simple title4");
        post1.setContent("Simple content4");
        post1.setUsername("usernameSimple4");
        post1.setUuid("uuidSimple4");
        postDao.save(post1);
        entityManager.persist(post1);
    
        Post post2 = new Post();
        post2.setTitle("Simple title5");
        post2.setContent("Simple content5");
        post2.setUsername("usernameSimple5");
        post2.setUuid("uuidSimple5");
        postDao.save(post2);
        entityManager.persist(post2);
    
        Post post3 = new Post();
        post3.setTitle("Simple title6");
        post3.setContent("Simple content6");
        post3.setUsername("usernameSimple6");
        post3.setUuid("uuidSimple6");
        postDao.save(post3);
        entityManager.persist(post3);

        Post foundPost = postDao.findById(post2.getId()).get();

        assertThat(foundPost).isEqualTo(post2);
    }

    // @Test
    // public void should_find_liked_posts() {
    //     Post post1 = new Post();
    //     post1.setTitle("Simple title4");
    //     post1.setContent("Simple content4");
    //     post1.setUsername("usernameSimple4");
    //     post1.setUuid("uuidSimple4");
    //     postDao.save(post1);
    //     entityManager.persist(post1);
    
    //     Post post2 = new Post();
    //     post2.setTitle("Simple title5");
    //     post2.setContent("Simple content5");
    //     post2.setUsername("usernameSimple5");
    //     post2.setUuid("uuidSimple5");
    //     postDao.save(post2);
    //     entityManager.persist(post2);
    
    //     Post post3 = new Post();
    //     post3.setTitle("Simple title6");
    //     post3.setContent("Simple content6");
    //     post3.setUsername("usernameSimple6");
    //     post3.setUuid("uuidSimple6");
    //     postDao.save(post3);
    //     entityManager.persist(post3);

    //     Iterable<Post> posts = postDao.findByLiked(true);

    //     assertThat(posts).hasSize(3).contains(post1, post2 post3);
    // }

    @Test
    public void should_find_posts_by_title_containing_string() {
        Post post1 = new Post();
        post1.setTitle("Simple title4");
        post1.setContent("Simple content4");
        post1.setUsername("usernameSimple4");
        post1.setUuid("uuidSimple4");
        postDao.save(post1);
        entityManager.persist(post1);
    
        Post post2 = new Post();
        post2.setTitle("Simple title5");
        post2.setContent("Simple content5");
        post2.setUsername("usernameSimple5");
        post2.setUuid("uuidSimple5");
        postDao.save(post2);
        entityManager.persist(post2);
    
        Post post3 = new Post();
        post3.setTitle("Simple title6");
        post3.setContent("Simple content6");
        post3.setUsername("usernameSimple6");
        post3.setUuid("uuidSimple6");
        postDao.save(post3);
        entityManager.persist(post3);
    }

    // @Test
    // public void should_update_post_by_id() {
    //     Post post2 = new Post();
    //     post2.setTitle("Simple title5");
    //     post2.setContent("Simple content5");
    //     post2.setUsername("usernameSimple5");
    //     post2.setUuid("uuidSimple5");
    //     postDao.save(post2);
    //     entityManager.persist(post2);


    //     Post post = postDao.findById(post2.getId()).get();
    

    
    //     Post post3 = new Post();
    //     post3.setTitle("Simple title6");
    //     post3.setContent("Simple content6");
    //     post3.setUsername("usernameSimple6");
    //     post3.setUuid("uuidSimple6");
    //     postDao.save(post3);
    //     entityManager.persist(post3);

    //     Post updatedPost =
    // }

    @Test
    public void should_delete_post_by_id() {
        Post post1 = new Post();
        post1.setTitle("Simple title4");
        post1.setContent("Simple content4");
        post1.setUsername("usernameSimple4");
        post1.setUuid("uuidSimple4");
        postDao.save(post1);
        entityManager.persist(post1);
    
        Post post2 = new Post();
        post2.setTitle("Simple title5");
        post2.setContent("Simple content5");
        post2.setUsername("usernameSimple5");
        post2.setUuid("uuidSimple5");
        postDao.save(post2);
        entityManager.persist(post2);
    
        Post post3 = new Post();
        post3.setTitle("Simple title6");
        post3.setContent("Simple content6");
        post3.setUsername("usernameSimple6");
        post3.setUuid("uuidSimple6");
        postDao.save(post3);
        entityManager.persist(post3);

        postDao.deleteById(post2.getId());

    Iterable<Post> posts = postDao.findAll();

    assertThat(posts).hasSize(2).contains(post1, post2);
    }

    @Test
    public void should_delete_all_posts() {
        Post post1 = new Post();
        post1.setTitle("Simple title4");
        post1.setContent("Simple content4");
        post1.setUsername("usernameSimple4");
        post1.setUuid("uuidSimple4");
        postDao.save(post1);
        entityManager.persist(post1);
    
        Post post2 = new Post();
        post2.setTitle("Simple title5");
        post2.setContent("Simple content5");
        post2.setUsername("usernameSimple5");
        post2.setUuid("uuidSimple5");
        postDao.save(post2);
        entityManager.persist(post2);
    
        Post post3 = new Post();
        post3.setTitle("Simple title6");
        post3.setContent("Simple content6");
        post3.setUsername("usernameSimple6");
        post3.setUuid("uuidSimple6");
        postDao.save(post3);
        entityManager.persist(post3);

        postDao.deleteAll();

    assertThat(postDao.findAll()).isEmpty();
    }

}
