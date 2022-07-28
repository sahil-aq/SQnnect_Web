//package com.trainee.sqnnect.Repository;
////import static org.assertj.core.api.Assertions.assertThat;
//
//import org.springframework.beans.factory.annotation.Autowired;
////import org.junit.jupiter.api.Test;
//
//import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
//import org.springframework.test.annotation.Rollback;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//
//@DataJpaTest
//@AutoConfigureTestDatabase(replace = Replace.NONE)
//@Rollback(false)
//public class UserRepositoryTests {
//	
//	 @Autowired
//    private TestEntityManager entityManager;
//     
//    @Autowired
//    private UserRepository repo;
//    /**
//     * This is a basic test class for testing Spring Data JPA repositories. It is configured to work with the actual database 
//     * (@AutoConfigureTestDatabase(replace = Replace.NONE)) and commit the changes (@Rollback(false)).
//     *  TestEntityManager is a wrapper of JPA’s EntityManager so we can use it in test class like a standard EntityManager.
//     */
//    @Test
//    public void testCreateUser() {
//    User user = new User();
//    user.setEmail("yashsharma@gmail.com");
//    user.setPassword("yash2022");
//    user.setFirstName("Yash");
//    user.setLastName("Sharma");
//     
//    User savedUser = repo.save(user);
//     
//    User existUser = entityManager.find(User.class, savedUser.getId());
//    /**
//     *  I use AssertJ’s method assertThat() as the assertion statement.
//     *   It is more readable and more fluent than using traditional JUnit’s assertion methods.
//     *  
//     */
//     
//    assertThat(user.getEmail()).isEqualTo(existUser.getEmail());
//         
//    }
//
//    @Test
//    public void testFindUserByEmail() {
//    	String email = "nam1@codejava.net";
//    	User user = repo.findByEmail(email);
//    	assertThat(user).isNotNull();
//    }
//}
