/**
 * 
 */
package firstFaces;

import java.io.Serializable;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 * @author trevor.curtis
 *
 */
@Stateless
public class UserService implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5963585672655003244L;
	
	@PersistenceContext
	EntityManager em;
	
	public void save(User _user) {
		System.out.println("in em");
        em.persist(_user);
        System.out.println("persisted");
        em.flush();
        System.out.println("saved");
    }
	
}
