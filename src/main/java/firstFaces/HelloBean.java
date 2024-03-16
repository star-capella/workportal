/**
 * 
 */
package firstFaces;

import java.io.Serializable;
import java.util.Properties;

import jakarta.batch.operations.JobOperator;
import jakarta.batch.runtime.BatchRuntime;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

/**
 * @author trevor.curtis
 *
 */
@Named
@RequestScoped
public class HelloBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6221631787258561517L;
	transient private String name;

	@Inject
	UserService us;


	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
		runBatch();
	}
	
	public String runBatch() {
		System.out.println("name: " + getName());
		User aUser = new User(getName(), "lastname");
		
		System.out.println(aUser.toString());
		us.save(aUser);
		JobOperator jobOp = BatchRuntime.getJobOperator();
		System.out.println("runBatch");
		jobOp.start("MyBatchlet", new Properties());
		
		return "success";
	}
}
