import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class encrypt {

	static final int OddAdder = 5;
	static final int EvenAdder = 3;

	static String MD5(String s) {
		try {

			MessageDigest md = MessageDigest.getInstance("MD5");

			byte[] messageDigest = md.digest(s.getBytes());

			BigInteger no = new BigInteger(1, messageDigest);

			String hashtext = no.toString(16);
			while (hashtext.length() < 32) {
				hashtext = "0" + hashtext;
			}
			return hashtext;
		}

		// For specifying wrong message digest algorithms
		catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}

	static String EP(String code) {
		int leng = code.length();
		int Tmp[] = new int[leng];
		for (int i = 0; i < leng; i++) {
			if ((i % 2) == 0) {
				Tmp[i] = (code.charAt(i) + EvenAdder);
			} else {
				Tmp[i] = (code.charAt(i) + OddAdder);
			}
		}
		char nString[] = new char[leng];
		for (int i = 0; i < leng; i++) {
			nString[i] = (char) Tmp[i];
		}
		String ret = String.copyValueOf(nString);
		return ret;
	}

	static String DP(String code) {
		int leng = code.length();
		int Tmp[] = new int[leng];
		for (int i = leng - 1; i >= 0; i--) {
			if ((i % 2) == 0) {
				Tmp[i] = (code.charAt(i) - EvenAdder);
			} else {
				Tmp[i] = (code.charAt(i) - OddAdder);
			}
		}
		char nString[] = new char[leng];
		for (int i = 0; i < leng; i++) {
			nString[i] = (char) Tmp[i];
		}
		String ret = String.copyValueOf(nString);
		return ret;

	}
	static String ProcessString(String UID, String PSWD, String Name, String Email,String Address)
	{
		//The PSWD should be MD5 already
		String N1=EP(UID);
		String N2=EP(PSWD);
		String N3=EP(Name);
		String N4=EP(Email);
		String N5=EP(Address);
		String RET = N1 +"\n"+N2+'\n'+N3+"\n"+N4+"\n"+N5+"\n";
		return RET;
	}
	
	static String ProcessString(UserNode User)
	{
		String N1=EP(User.getUID());
		String N2=EP(User.getPSWD());//The PSWD should be MD5 already
		String N3=EP(User.getName());
		String N4=EP(User.getEmail());
		String N5=EP(User.getAddress());
		String RET = N1 +"\n"+N2+'\n'+N3+"\n"+N4+"\n"+N5+"\n";
		return RET;
	}

}
