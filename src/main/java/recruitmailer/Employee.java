package recruitmailer;

/*These are the Generic detatils of the employee*/
public class Employee extends Domain{
	private String firstName;
	private String lastName;
	
	@SuppressWarnings("unused")
	private String fullName;
	private double currentSalary;
	private double expectedSalary;
	private int noticePeriod;
	
	
	public Employee(String firstname,String lastname,String email,double currentsalary,double expectedsalary,int noticeperiod)
	{
		super(email);
		this.firstName = firstname;
		this.lastName =lastname;
		this.currentSalary = currentsalary;
		this.expectedSalary =expectedsalary;
		this.noticePeriod = noticeperiod;
	}
	
	
	public String getfullName(){
		return firstName+ " "+ lastName;
	}
	
	public String getFirstname() {
		return firstName;
	}
	public void setFirstname(String firstname) {
		this.firstName = firstname;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFullName() {
		return firstName+lastName;
	}

	public double getCurrentSalary() {
		return currentSalary;
	}

	public void setCurrentSalary(double currentSalary) {
		this.currentSalary = currentSalary;
	}

	public double getExpectedSalary() {
		return expectedSalary;
	}

	public void setExpectedSalary(double expectedSalary) {
		this.expectedSalary = expectedSalary;
	}

	public String getNoticePeriod() {
		return noticePeriod+"month";
	}

	public void setNoticePeriod(int noticePeriod) {
		this.noticePeriod = noticePeriod;
	}

}
