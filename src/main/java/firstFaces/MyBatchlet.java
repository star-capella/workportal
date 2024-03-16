/**
 * 
 */
package firstFaces;

import java.util.Properties;
import java.util.concurrent.TimeUnit;
import jakarta.batch.api.AbstractBatchlet;
import jakarta.batch.operations.JobOperator;
import jakarta.batch.runtime.BatchRuntime;
import jakarta.inject.Named;


/**
 * @author trevor.curtis
 *
 */
@Named
public class MyBatchlet extends AbstractBatchlet {

	@Override
	public String process() throws Exception {
		System.out.println("This is my batch job");
		TimeUnit.MINUTES.sleep(1);
		System.out.println("And now it's done");
//		runBatch();
		return null;
	}
	
	public String runBatch() {
                System.out.println("running runBatch()");
		JobOperator jobOp = BatchRuntime.getJobOperator();
		jobOp.start("MyBatchlet", new Properties());
		
		return "success";
	}

}
