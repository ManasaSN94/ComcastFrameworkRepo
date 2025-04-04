package practice.testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ActivateSim {
	
	@Test(retryAnalyzer=com.comcast.crm.listenerutility.RetryListenerImp.class)
	public void activatesim() {
		System.out.println("execute activatesim ");
		Assert.assertEquals("", "Login");
		System.out.println("step-1");
		System.out.println("step-2");
		System.out.println("step-3");
		
	}

}
