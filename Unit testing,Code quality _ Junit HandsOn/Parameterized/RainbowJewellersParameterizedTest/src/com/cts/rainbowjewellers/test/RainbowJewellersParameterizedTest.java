package com.cts.rainbowjewellers.test;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runner.RunWith;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import static org.junit.Assert.*;
import com.cts.rainbowjewellers.service.RainbowJewellersService;
@RunWith(Parameterized.class)
public class RainbowJewellersParameterizedTest {

    private double gram;
    private double expectedgoldprice;
    RainbowJewellersService rjp = new RainbowJewellersService();

    public RainbowJewellersParameterizedTest(double gram, double expectedgoldprice) {
      this.gram = gram;
      this.expectedgoldprice = expectedgoldprice;
   }
	@Test
	public void testCalculateGoldPrice() {
	
	     //fill code here
	     assertEquals(expectedgoldprice, rjp.calculategoldprice(gram),1e-15);
		
	}
	@Parameterized.Parameters
	public static Collection methodParameterized() {
      return Arrays.asList(new Object[][] {
         { 9.6, 48401.76 },
         { 56, 282343.6 },
         { 24.5, 123525.325 },
         { 0, 0 },
         { -1, -5041.85 }
      });
   }
// 281596.0 123198.25
}
