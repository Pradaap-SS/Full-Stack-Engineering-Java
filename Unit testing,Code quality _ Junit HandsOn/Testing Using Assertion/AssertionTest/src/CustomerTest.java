import org.junit.Assert;
import org.junit.Test;

public class CustomerTest {
	//Write the code for testing assertion using JUNIT
	Customer customer;
	
	@Test
	public void TestIsValidAadharNo() {
	    customer = new Customer("123123123",
	    "Aaa",
	    "last",
	    "Address",
	    (long)789456,
	    "aaa@gmail.com");
	    
	    Assert.assertEquals(true, customer.isValidAadharNo("634598081319"));
	    
	}
	@Test
	public void TestIsValidName() {
	    customer = new Customer("123123123",
	    "Aaa",
	    "last",
	    "Address",
	    (long)789456,
	    "aaa@gmail.com");
	    
	    Assert.assertEquals(true, customer.getFirstName()!=customer.getLastName());
	    
	}
	@Test
	public void TestIsEmailId() {
	    customer = new Customer("123123123",
	    "Aaa",
	    "last",
	    "Address",
	    (long)789456,
	    "aaa@gmail.com");
	    
	    Assert.assertNotNull(customer.getEmailId());
	    
	}

}
