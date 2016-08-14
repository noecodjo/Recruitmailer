package recruitmailer;

public class Employee {
	private String firstName;
	private String lastName;
	@SuppressWarnings("unused")
	private String fullName;
	private double currentSalary;
	private double expectedSalary;
	private int noticePeriod;
	
	
	public Employee(String firstname,String lastname,double currentsalary,double expectedsalary,int noticeperiod)
	{
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
