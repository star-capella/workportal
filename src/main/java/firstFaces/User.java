/**
 * 
 */
package firstFaces;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * @author trevor.curtis
 *
 */
@Entity
@Table(name = "users")
public class User {
	/**
	 * ID
	 */
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	/**
	 * first name
	 */
	@Column(name="first_name")
	private String firstName;
	/**
	 * last name
	 */
	@Column(name="last_name")
	private String lastName;
	/**
	 * username
	 */
	private String username;
	
	
	/**
	 * Default constructor
	 */
	public User() {
		super();
	}

	/**
	 * @param firstName
	 * @param lastName
	 */
	public User(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.username= "foo";
	}
	
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
	/**
	 * String representation of object
	 */
	public String toString() {
		return "[id=" + id + ",username=" + username + ",firstName=" + firstName + ",lastName=" + lastName + "]";
	}
}
