import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;


public class TestN {
	   @Test
	   public void testIO() {
		   System.out.println("IO Testing");
		   boolean entry;		      
		   entry = UserIO.createAccount("NibiruFan13", "pass123", "myMail@mail.com", "Guest", "123 Fraud Ln");
		   System.out.println("Creation of valid account file credentials: " + eval(entry));		      
		   entry = UserIO.login("NibiruFan13", "pass123");
		   System.out.println("Login of valid account credentials: " + eval(entry));		      
		   entry = UserIO.login("NoAcct", "notReal");
		   System.out.println("Login of invalid account credentials: " + eval(entry) + "\n");	      
	   }
	   
	   @Test
	   public void testEncrypt() {
		   System.out.println("Encryption Testing");
		   String entry = "fakePass";
		   String encrypted = encrypt.EP(entry);
		   String decrypted = encrypt.DP(encrypted);
		   System.out.println("Original item: " + entry);
		   System.out.println("After encryption: " + encrypted);
		   System.out.println("After decryption: " + decrypted + "\n");
	   }
	   
	   @Test
	   public void testObject() {	
		   UserNode testNode = new UserNode("testusername", "testpass", "testemail", "testname", "testaddress");
		   System.out.println("Object Testing");
		   System.out.println("Append null to user info file: " + eval(UserIO.appendToFile(null)));
		   System.out.println("Append node to user info file: " + eval(UserIO.appendToFile(testNode)) + "\n");
	   }
	   
	   public String eval(boolean truth) {
		   if (truth == true) {
			   return "Success";
		   }
		   else {
			   return "Failure";
		   }
	   }
	}
