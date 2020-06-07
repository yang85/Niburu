import java.io.*;
import java.util.*;

public class UserIO {

	static boolean UserEmpty = false;
	static int userCounter = 0;
	static final String UserFile = "User.u";

	@SuppressWarnings("null")
	public static void main(String ags[]) {
		
		/*if (createAccount("Kazekami", "I_Love_You", "Apple", "asassss@ASAS.COM", "Your_Heart") == false)
			System.out.println("Account Already Exists");
		else
			System.out.println("Account Create Successful");
		if (login("Kazekami", "I_Love_You") == true)
			System.out.println("Login Success");
		else
			System.out.println("Account and Password are not matching");
		System.out.println("Done");*/
		System.out.println(CreditCardCehck("4400648610408217"));
	}

	public static boolean login(String UID, String PSWD) {
		String md5 = encrypt.MD5(PSWD);
		LinkedList<UserNode> tmp = readUserFile();
		if (userCounter == 0)
			return false;
		else {
			int size = tmp.size();
			for (int i = 0; i < size; i++) {
				String RUID = tmp.get(i).getUID();
				if (RUID.compareTo(UID) == 0) {
					String TMd5 = tmp.get(i).getPSWD();
					if (TMd5.compareTo(md5) == 0)
						return true;
					else
						return false;
				}
			}
			return false;
		}

	}

	public static LinkedList<UserNode> readUserFile() {

		File inputFile = new File(UserFile);

		String theInput = "";
		LinkedList<UserNode> Users = new LinkedList<UserNode>();
		try {
			InputStreamReader reader = new InputStreamReader(new FileInputStream(inputFile));
			BufferedReader br = new BufferedReader(reader);
			while ((theInput = br.readLine()) != null) {
				String PSWD = br.readLine();
				String Name = br.readLine();
				String Email = br.readLine();
				String Address = br.readLine();
				if (PSWD == null && Name == null && Email == null && Address == null)
					throw (new Exception("User File curroped"));
				Users.addLast(new UserNode(encrypt.DP(theInput), encrypt.DP(PSWD), encrypt.DP(Name), encrypt.DP(Email),
						encrypt.DP(Address)));
				userCounter++;
			}
			br.close();
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
		return Users;
	}

	public static boolean createAccount(String UID, String PSWD, String Email, String Name, String Address) {
		LinkedList<UserNode> tmp = readUserFile();
		if (userCounter == 0) {
			UserNode nUser = new UserNode(UID, encrypt.MD5(PSWD), Email, Name, Address);
			encrypt.ProcessString(nUser);
			appendToFile(nUser);
			return true;
		} else {
			int size = tmp.size();
			for (int i = 0; i < size; i++) {
				String RUID = tmp.get(i).getUID();
				if (RUID.compareTo(UID) == 0)
					return false;
			}
			UserNode nUser = new UserNode(UID, encrypt.MD5(PSWD), Email, Name, Address);
			appendToFile(nUser);
			return true;
		}
	}

	public static boolean appendToFile(UserNode aUser) {
		try {
			File outputFile = new File(UserFile);
			outputFile.createNewFile();
			BufferedWriter out = new BufferedWriter(new FileWriter(outputFile, true));
			String T = encrypt.ProcessString(aUser);
			out.write(T);
			out.close();
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	public static boolean CreditCardCehck(String card)
	{
		int len=card.length();
		if (len < 12 || len >19)
			return false;
		int counter=1;
		for(int i=0;i<len;i++)
		{
			if (card.charAt(i)<48||card.charAt(i)>57)
				return false;
		}
		int sum=0;
		for(int i=len-counter;i>=0;i--)
		{
			
			int cur=card.charAt(i)-48; 
			if(counter %2 ==1)
				sum += cur;
			else
			{
				sum += (cur*2) >9? (cur*2)-9:(cur*2);
			}counter++;
		}
		
		if(sum%10==0)
			return true;
		else
			return false;
	}
}
