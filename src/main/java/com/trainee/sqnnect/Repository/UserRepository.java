package com.trainee.sqnnect.Repository;
/**
 * 
 * @author yash
 * @version 1.0
 */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.trainee.sqnnect.Models.User;

/**create a new interface named UserRepository to act as a Spring Data JPA repository*/
public interface UserRepository extends JpaRepository<User, Long> {
	
	/**This interface is a subtype of JpaRepository which defines common persistence
	 *  operations (including CRUD) and the implementation will be generated at runtime by Spring Data JPA.*/
	
	/**the email column is unique in the users table, so we define the findByEmail() 
	 * method that returns a single User object based on email (no two users having the same email).*/
	
	 @Query("SELECT u FROM User u WHERE u.email = ?1")
	    public User findByEmail(String email);

}
