import org.junit.Test;
import static org.junit.Assert.fail;
import static org.junit.Assert.*;

public class ProductTest {

 //Write the code for test methods
 private ProductDAO productDao;
//     @Test
// 	public void addAnddeleteProductTest1() {
// 		productDao = new ProductDAO();
// 		Product product = new Product("name","101",100.00);
// 		productDao.addProduct(product);
// 		assertTrue(productDao.deleteProduct(product));
// 	}
	@Test
	public void addProductTest1() {
		productDao = new ProductDAO();
		Product product = new Product("name","101",100.00);
		
		assertTrue(productDao.addProduct(product));
	}
	@Test
	public void deleteProductTest1() {
		productDao = new ProductDAO();
		Product product = new Product("name","101",100.00);
		
		assertFalse(productDao.deleteProduct(product));
	}
	
	@Test
	public void addProductTest2() {
		productDao = new ProductDAO();
		Product product = null;
		
		assertFalse(productDao.addProduct(product));
	}
	@Test
	public void addAnddeleteProductTest2() {
		productDao = new ProductDAO();
		Product product = null;
		productDao.addProduct(product);
		assertFalse(productDao.deleteProduct(product));
	}
	@Test
	public void deleteProductTest2() {
		productDao = new ProductDAO();
		Product product = null;
		
		assertFalse(productDao.deleteProduct(product));
	}
	
// 	@Test
// 	public void deleteProductTest3() {
// 		productDao = new ProductDAO();
// 		Product product = new Product();
// 		product.setProductName("aaa");
// 		product.setProductId("10");
// 		product.setPrice(100.00);
// 		assertFalse(productDao.deleteProduct(product));
// 	}
	
	@Test
	public void addProductTest3() {
		productDao = new ProductDAO();
		Product product = new Product();
		product.setProductName("aaa");
		product.setProductId("10");
		product.setPrice(100.00);
		assertTrue(productDao.addProduct(product));
	}
// 	@Test
// 	public void addAnddeleteProductTest3() {
// 		productDao = new ProductDAO();
// 		Product product = new Product();
// 		product.setProductName("aaa");
// 		product.setProductId("10");
// 		product.setPrice(100.00);
// 		productDao.addProduct(product);
// 		assertTrue(productDao.deleteProduct(product));
// 	}
}
