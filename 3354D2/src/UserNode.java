public class UserNode {
	private String UID;
	private String PSWD;
	private String Email;
	private String Name;
	private String Address;

	UserNode(String UID, String PSWD) {
		//the PSWD should already MD5 lized 
		this.UID = UID;
		this.PSWD = PSWD;
		Email = "N/A";
		Name = "N/A";
		Address = "N/A";
	}
	UserNode(String UID, String PSWD, String Email, String Name, String Address)
	{
		//the PSWD should already MD5 lized 
		this.UID = UID;
		this.PSWD = PSWD;
		this.Email = Email;
		this.Name = Name;
		this.Address = Address;
	}

	public boolean setEmail(String E) {
		Email = E;
		return true;
	}

	public boolean SetName(String N) {
		Name = N;
		return true;
	}

	public boolean SetAddress(String A) {
		Address = A;
		return true;
	}

	public boolean updatePSWD(String Old, String New) {
		if (Old.compareTo(PSWD) == 0) {
			PSWD = New;
			return true;
		} else
			return false;
	}
	public String getUID()
	{
		return UID;
	}
	public String getPSWD()
	{
		return PSWD;
	}
	public String getName()
	{
		return Name;
	}
	public String getEmail()
	{
		return Email;
	}
	public String getAddress()
	{
		return Address;
	}
	/*public boolean PrintNode()
	{
		
	}*/
}
