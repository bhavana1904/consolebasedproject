import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Employee {
	private String firstname;
	private String lastname;
	private String department;
	private String employeemail;
	private String genaratedemail;
	private String genaratedpassword;

	private ArrayList<Employee> Elist = new ArrayList<>();

	public Employee(String firstname, String lastname, String department, String employeemail, String genaratedemail,
			String genaratedpassword) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.department = department;
		this.employeemail = employeemail;
		this.genaratedemail = genaratedemail;
		this.genaratedpassword = genaratedpassword;

	}

	@Override
	public String toString() {
		return "Employee{" + "firstname='" + firstname + '\'' + ", lastname='" + lastname + '\'' + ", department='"
				+ department + '\'' + ", employeemail='" + employeemail + '\'' + ", genaratedemail='" + genaratedemail
				+ '\'' + ", genaratedpassword='" + genaratedpassword + '\'' + '}';
	}

	public Employee() {
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getEmployeemail() {
		return employeemail;
	}

	public void setEmployeemail(String employeemail) {
		this.employeemail = employeemail;
	}

	

	public String getLastname() {
		return lastname;
	}
public void setFirstname(String firstname) {
	this.firstname=firstname;
}
public String getFirstname() {
	return firstname;
}
public void setLastname(String lastname) {
	this.lastname=lastname;
}
	public String getGenaratedemail() {
		return genaratedemail;
	}

	public void setGenaratedemail(String genaratedemail) {
		this.genaratedemail = genaratedemail;
	}

	public String getGenaratedpassword() {
		return genaratedpassword;
	}

	public void setGenaratedpassword(String genaratedpassword) {
		this.genaratedpassword = genaratedpassword;
	}

	public String GeneratePassword() {
		String capitalCaseLetters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String lowerCaseLetters = "abcdefghijklmnopqrstuvwxyz";
		String specialCharacters = "!@#$";
		String numbers = "1234567890";
		String combinedChars = capitalCaseLetters + lowerCaseLetters + specialCharacters + numbers;
		Random random = new Random();
		char[] pass = new char[8];

		pass[0] = lowerCaseLetters.charAt(random.nextInt(lowerCaseLetters.length()));
		pass[1] = capitalCaseLetters.charAt(random.nextInt(capitalCaseLetters.length()));
		pass[2] = specialCharacters.charAt(random.nextInt(specialCharacters.length()));
		pass[3] = numbers.charAt(random.nextInt(numbers.length()));

		for (int i = 4; i < 8; i++) {
			pass[i] = combinedChars.charAt(random.nextInt(combinedChars.length()));
		}
		String s = "" + pass;
		return s;
	}

	public void CreateEmail() {
		System.out.println("-------------enter Employee details------------");
		Scanner sc = new Scanner(System.in);
		System.out.println("enter Employee firstname");
		setFirstname(sc.next());
		System.out.println("enter Employee Lastname");
		setLastname(sc.next());
		System.out.println("enter Department");
		setDepartment(sc.next());
		System.out.println("enter Employee Email");
		setEmployeemail(sc.next());
		System.out.println("----------generating a email and password----------");
		setGenaratedemail(getFirstname() + "." + getLastname() + "@" + getDepartment() + ".com");
		setGenaratedpassword(GeneratePassword());
		Elist.add(new Employee(getFirstname(), getLastname(), getDepartment(), getEmployeemail(), getGenaratedemail(), getGenaratedpassword()));
		System.out.println(Elist);

	}

	
}
