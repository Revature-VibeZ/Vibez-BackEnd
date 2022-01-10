package com.revature.vibez;

import com.revature.DAOs.UserDao;
import com.revature.models.User;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class UserDaoJpaUnitTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserDao userDao;

    @Test
    public void should_find_users_if_user_dao_is_not_empty() {
        Iterable<User> users = userDao.findAll();

        assertThat(users).isNotNull();
    }
    @Test
    public void should_create_a_user(){
        User u = new User();

		u.setFirstName("Joe");
		u.setLastName("Yooser");
		u.setEmail("testmail@testing.com");
		u.setPassword("joepass");
		u.setUsername("joeusername");
        userDao.save(u);

        assertThat(u).hasFieldOrPropertyWithValue("firstName", "Joe");
        assertThat(u).hasFieldOrPropertyWithValue("lastName", "Yooser");
        assertThat(u).hasFieldOrPropertyWithValue("email", "testmail@testing.com");
        assertThat(u).hasFieldOrPropertyWithValue("password", "joepass");
        assertThat(u).hasFieldOrPropertyWithValue("username", "joeusername");
    }

    @Test
    public void should_find_all_users(){
        User u = new User();

		u.setFirstName("Joe");
		u.setLastName("Yooser");
		u.setEmail("testmail@testing.com");
		u.setPassword("joepass");
		u.setUsername("joeusername");
        userDao.save(u);

        User u2 = new User();

		u2.setFirstName("Joe2");
		u2.setLastName("Yooser2");
		u2.setEmail("testmail@testing.com2");
		u2.setPassword("joepass2");
		u2.setUsername("joeusername2");
        userDao.save(u2);

        User u3 = new User();

		u3.setFirstName("Joe3");
		u3.setLastName("Yooser3");
		u3.setEmail("testmail@testing.com3");
		u3.setPassword("joepass3");
		u3.setUsername("joeusername3");
        userDao.save(u3);

        Iterable<User> users = userDao.findAll();
    
        assertThat(users).contains(u, u2, u3);
    }

    @Test
    public void should_find_a_user_by_id(){

        User u = new User();

		u.setFirstName("Joe");
		u.setLastName("Yooser");
		u.setEmail("testmail@testing.com");
		u.setPassword("joepass");
		u.setUsername("joeusername");
        userDao.save(u);

        User u2 = new User();

		u2.setFirstName("Joe2");
		u2.setLastName("Yooser2");
		u2.setEmail("testmail@testing.com2");
		u2.setPassword("joepass2");
		u2.setUsername("joeusername2");
        userDao.save(u2);

        User u3 = new User();

		u3.setFirstName("Joe3");
		u3.setLastName("Yooser3");
		u3.setEmail("testmail@testing.com3");
		u3.setPassword("joepass3");
		u3.setUsername("joeusername3");
        userDao.save(u3);

        User foundUser = userDao.findById(u2.getId()).get();

        assertThat(foundUser).isEqualTo(u2);
    }

    @Test
    public void should_find_users_by_username(){

        User u = new User();

		u.setFirstName("Joe");
		u.setLastName("Yooser");
		u.setEmail("testmail@testing.com");
		u.setPassword("joepass");
		u.setUsername("joeusername");
        userDao.save(u);

        User u2 = new User();

		u2.setFirstName("Joe2");
		u2.setLastName("Yooser2");
		u2.setEmail("testmail@testing.com2");
		u2.setPassword("joepass2");
		u2.setUsername("joeusername2");
        userDao.save(u2);

        User u3 = new User();

		u3.setFirstName("Joe3");
		u3.setLastName("Yooser3");
		u3.setEmail("testmail@testing.com3");
		u3.setPassword("joepass3");
		u3.setUsername("joeusername3");
        userDao.save(u3);

        User foundUser = userDao.findUserByUsername(u2.getUsername()).get(0);

        assertThat(foundUser).isEqualTo(u2);
    }

    @Test
    public void should_update_user_by_id(){

        User u = new User();

		u.setFirstName("Joe");
		u.setLastName("Yooser");
		u.setEmail("testmail@testing.com");
		u.setPassword("joepass");
		u.setUsername("joeusername");
        userDao.save(u);
        entityManager.persist(u);

        User updatedUser = new User();

		updatedUser.setFirstName("Joe2");
		updatedUser.setLastName("Yooser2");
		updatedUser.setEmail("testmail@testing.com2");
		updatedUser.setPassword("joepass2");
		updatedUser.setUsername("joeusername2");
        userDao.save(updatedUser);
        entityManager.persist(updatedUser);

        User u3 = userDao.findById(u.getId()).get();

		u3.setFirstName(updatedUser.getFirstName());
		u3.setLastName(updatedUser.getLastName());
		u3.setEmail(updatedUser.getEmail());
		u3.setPassword(updatedUser.getPassword());
		u3.setUsername(updatedUser.getUsername());
        userDao.save(u3);

        User checkUser = userDao.findById(u3.getId()).get();

        assertThat(checkUser.getId()).isEqualTo(u3.getId());
        assertThat(checkUser.getFirstName()).isEqualTo(updatedUser.getFirstName());
        assertThat(checkUser.getLastName()).isEqualTo(updatedUser.getLastName());
        assertThat(checkUser.getEmail()).isEqualTo(updatedUser.getEmail());
        assertThat(checkUser.getPassword()).isEqualTo(updatedUser.getPassword());
        assertThat(checkUser.getUsername()).isEqualTo(updatedUser.getUsername());

    }

    // @Test
    // public void should_delete_user_by_id(){

    //     User u = new User();

	// 	u.setFirstName("Joe");
	// 	u.setLastName("Yooser");
	// 	u.setEmail("testmail@testing.com");
	// 	u.setPassword("joepass");
	// 	u.setUsername("joeusername");
    //     userDao.save(u);

    //     User u2 = new User();

	// 	u2.setFirstName("Joe2");
	// 	u2.setLastName("Yooser2");
	// 	u2.setEmail("testmail@testing.com2");
	// 	u2.setPassword("joepass2");
	// 	u2.setUsername("joeusername2");
    //     userDao.save(u2);

    //     User u3 = new User();

	// 	u3.setFirstName("Joe3");
	// 	u3.setLastName("Yooser3");
	// 	u3.setEmail("testmail@testing.com3");
	// 	u3.setPassword("joepass3");
	// 	u3.setUsername("joeusername3");
    //     userDao.save(u3);

    //     userDao.deleteById(u.getId());

    //     Iterable<User> users = userDao.findAll();

    //     assertThat(users).hasSize(2).contains(u, u2);
    // }

}
