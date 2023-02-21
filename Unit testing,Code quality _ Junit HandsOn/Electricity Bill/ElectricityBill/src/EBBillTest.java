import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Test;


public class EBBillTest
{
    
    //Write JUNIT Test Code
    EBBill eBill ; 
    @Test
    public void testCalculateBillAmount1() {
        eBill = new EBBill(3000);
        double amount = eBill.calculateBillAmount();
        assertTrue((double)38018.5==amount);
        
    }
    @Test
    public void testCalculateBillAmount2() {
        eBill = new EBBill(50);
        double amount = eBill.calculateBillAmount();
        assertTrue((double)130.0==amount);
        
    }
    @Test
    public void testCalculateBillAmount3() {
        eBill = new EBBill(100);
        double amount = eBill.calculateBillAmount();
        assertTrue((double)292.5==amount);
        
    }
    @Test
    public void testCalculateBillAmount4() {
        eBill = new EBBill(200);
        double amount = eBill.calculateBillAmount();
        assertTrue((double)818.5==amount);
        
    }
    @Test
    public void testCalculateBillAmount5() {
        eBill = new EBBill(1000);
        double amount = eBill.calculateBillAmount();
        //assertTrue((double)7018.5==amount);
        assertTrue((double)7018.5==amount);
        
    }
    @Test
    public void testCalculateBillAmount6() {
        eBill = new EBBill(0);
        double amount = eBill.calculateBillAmount();
        assertTrue((double)0.0==amount);
        
    }
    @Test
    public void testCalculateBillAmount7() {
        eBill = new EBBill(-100);
        double amount = eBill.calculateBillAmount();
        assertTrue((double)0.0==amount);
        
    }
    @Test
    public void testCalculateBillAmount8() {
        eBill = new EBBill(-50);
        double amount = eBill.calculateBillAmount();
        assertTrue((double)0.0==amount);
    }
    @Test
    public void testCalculateBillAmount9() {
        eBill = new EBBill(-200);
        double amount = eBill.calculateBillAmount();
        assertTrue((double)0.0==amount);
        
    }
    @Test
    public void testCalculateBillAmount10() {
        eBill = new EBBill(-1000);
        double amount = eBill.calculateBillAmount();
        assertTrue((double)0.0==amount);
        
    }
    
}