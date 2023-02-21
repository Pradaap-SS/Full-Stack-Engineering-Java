import static org.junit.Assert.assertEquals;
import java.util.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class EMICalculatorTest {

//Write JUNIT Test Code
private EMICalculator calculator;
private double durationInYears;
private String loanType;
private double principal;
private double expected;

@Before
public void initialize() {
    calculator = new EMICalculator();
}
public EMICalculatorTest(double principal, String loanType, double durationInYears, double expected) {
	
	this.principal = principal;
	this.loanType = loanType;
	this.durationInYears = durationInYears;
	this.expected = expected;
}
	

	@Test
	public void calculateEMITest() {
		
		double emi = calculator.calculateEMI(principal, loanType, durationInYears);
		//double actual = Double.parseDouble(String.format("%.2f", emi));
		assertEquals(expected, emi, 1e-15);
	}
	
	@Parameterized.Parameters
	public static Collection testCases() {
	    Object expectedOutput [][] = {
	        { 10000.0, "Personal Loan", 20.0, 42.08645824204558 },
	        { -1.0, "Personal Loan", 20.0, 0.0 },
	        { 10000.0, "Personal Loan", 0.0, 0.0 },
	        { 10000.0, "Personal Loan", -1.0, 0.0 },
	        { 10000.0, "Personal Loan", 21.0, 0.0 },
	        { 10000.0, "Housing Loan", 20.0, 42.17074984609382 },
	        { 10000.0, "Housing Loan", 0.0, 0.0 },
	        { -1.0, "Housing Loan", 20.0, 0.0 },
	        { 10000.0, "Housing Loan", -1.0, 0.0 },
	        { 10000.0, "Housing Loan", 21.0, 0.0 },
	        { 10000.0, "Vehicle Loan", 20.0, 42.128590158057385 },
	        { 10000.0, "Vehicle Loan", 0.0, 0.0 },
	        { -1.0, "Vehicle Loan", 20.0, 0.0 },
	        { 10000.0, "Vehicle Loan", -1.0, 0.0 },
	        { 20000.0, "Housing Loan", 15.0, 112.11966640790395},
	        { 20000.0, "Vehicle Loan", 15.0, 112.03539099901577},
	        { 20000.0, "Personal Loan", 15.0, 111.95115724836167}
	    };
	   return Arrays.asList(expectedOutput);
   }

}
