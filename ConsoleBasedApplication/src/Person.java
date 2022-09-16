
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Scanner;

public class Person {
	private String name;
	private String password;
	private String number;
	private String email;
	private ArrayList<Person> list = new ArrayList<>();

	public Person(String name, String password, String number, String email) {
		this.name = name;
		this.password = password;
		this.number = number;
		this.email = email;

	}

	public Person() {
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	

	@Override
	public String toString() {
		return "Person{" + "name='" + name + '\'' + ", password='" + password + '\'' + ", number=" + number
				+ ", email='" + email + '\'' + '}';
	}

	public void signup() {
		System.out.println("---------Registration---------");
		Scanner sc = new Scanner(System.in);
		System.out.println("enter your name");
		setName(sc.next());
		
		System.out.println("enter your password");
		setPassword(sc.next());
		System.out.println("enter your phone number");
		setNumber(sc.next());
		System.out.println("enter your Email");
		setEmail(sc.next());

		list.add(new Person(getName(), getPassword(), getNumber(), getEmail()));
		
		System.out.println("Registration successful");

	}

	public void login() {
		System.out.println("--------LOGIN---------");
		Scanner sc = new Scanner(System.in);

		System.out.println("enter your name");
		String pname = sc.next();
		System.out.println("enter your password");
		String ppassword = sc.next();
		String gname=getName();
		String gpassword=getPassword();
        if (gname.equals(gpassword) && gpassword.equals(gpassword)) 
        {
				System.out.println("login successful");
	    }
			
        else {
				System.out.println("login unsuccessful");
			
        }

		}

	}

