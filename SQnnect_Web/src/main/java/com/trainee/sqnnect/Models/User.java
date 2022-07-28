package com.trainee.sqnnect.Models;
import javax.persistence.*;
/**
 * 
 * @author yash
 * @version 1.0
 */
@Entity
@Table(name = "users")
/**create a new Java class named User to map with the corresponding users
 *  table (not yet created) in the database*/
public class User {
	/**the user information consists of ID, email, password, first name and last name. Here I use common annotations
	 *  from JPA. The setters and getters are now shown for brevity, so be sure you generate those methods as well*/
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
     
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(nullable = false, unique = true, length = 30)
    private String email;
     
    @Column(nullable = false, length = 40)
    private String password;
     
    @Column(name = "first_name", nullable = false, length = 20)
    private String firstName;
     
    @Column(name = "last_name", nullable = false, length = 20)
    private String lastName;

}
