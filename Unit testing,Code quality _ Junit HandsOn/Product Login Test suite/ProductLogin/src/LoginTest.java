import org.junit.Test;
import static org.junit.Assert.fail;
import static org.junit.Assert.*;


public class LoginTest {

      
    	    	 
      //Write the code for adding and deleting Login data
      LoginDAO loginDao = new LoginDAO();
      
      @Test
      public void addLoginTest1() {
          loginDao = new LoginDAO();
          Login login = new Login("user","pass");
          assertTrue(loginDao.addLogin(login));
      }
      @Test
      public void deleteLoginTest1() {
          loginDao = new LoginDAO();
          Login login = new Login("user","pass");
          assertFalse(loginDao.deleteLogin(login));
      }
      @Test
      public void addAndDeleteLoginTest1() {
          loginDao = new LoginDAO();
          Login login = new Login("user","pass");
          boolean result = loginDao.addLogin(login);
          assertEquals(true,loginDao.deleteLogin(login));
      }
      @Test
      public void addLoginTest2() {
          loginDao = new LoginDAO();
          Login login = null;
          assertFalse(loginDao.addLogin(login));
      }
      @Test
      public void deleteLoginTest2() {
          loginDao = new LoginDAO();
          Login login = null;
          assertFalse(loginDao.deleteLogin(login));
      }
      @Test
      public void addAndDeleteLoginTest2() {
          loginDao = new LoginDAO();
          Login login = null;
          boolean result = loginDao.addLogin(login);
          assertFalse(loginDao.deleteLogin(login));
      }
}

