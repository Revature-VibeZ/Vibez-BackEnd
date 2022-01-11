package com.revature.vibez;

import com.revature.DAOs.LikeDao;
import com.revature.models.Like;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class LikeDaoJpaUnitTest {

    @Autowired
    private LikeDao likeDao;

    @Test
    public void should_find_likes_if_like_dao_is_not_empty() {
        
        Iterable<Like> likes = likeDao.findAll();

        assertThat(likes).isNotNull();
    }
    // @Test
    // public void should_create_a_like(){
    //     Like like = new Like();


    // }
}
