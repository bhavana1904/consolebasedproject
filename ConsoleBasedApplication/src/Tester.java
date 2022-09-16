import java.util.*;
import java.sql.*;
public class Tester {
	public static void main(String[] args) throws SQLException {
		try {
			Connection	 connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "bhavana1234");//Establishing connection
			System.out.println("Connected With the database successfully");
			 PreparedStatement preparedStatement=connection.prepareStatement("insert into employeetable values(?,?,?)");
			 PreparedStatement preparedStatement1=connection.prepareStatement("insert into persontable values(?,?,?,?)");
			 Statement stmt = connection.createStatement();  
		Scanner sc = new Scanner(System.in);
		Person p = new Person();
		Employee e = new Employee();
		

		System.out.println("------------welcome-------------");
		System.out.println("Select an option 1.Signup  2.Login");
		String ch = sc.next();
		switch (ch) {
		case "1":
			p.signup();
			preparedStatement1.setString(1,p.getName());
			preparedStatement1.setString(2,p.getPassword());
			preparedStatement1.setString(3,p.getNumber());
			preparedStatement1.setString(4,p.getEmail());
			preparedStatement1.executeUpdate();
			System.out.println("person data inserted successfully");
			System.out.print("Enter the user id : ");  
			  String str1 = sc.next();  
			  System.out.print("Enter the password : ");  
			  String str2 = sc.next();  
			  ResultSet rs = stmt.executeQuery("select name,password from persontable where name='" + str1 + "' and password='" + str2 + "'");  
			  if (rs.next())  {
			   System.out.println("Welcome::: " + str1);
			   e.CreateEmail();
			   String r=e.getEmployeemail();
			   String sub="subject";
			   String msg="Your organisational mail id was created mail id:"+e.getGenaratedemail()+"password:"+e.getGenaratedpassword();
			   System.out.println("data inserted successfully");
			   SendEmail send = new SendEmail(r,sub,msg);
			   preparedStatement.setString(1,"1");
			   preparedStatement.setString(2,e.getGenaratedemail());
			   preparedStatement.setString(3,e.getGenaratedpassword());


			   preparedStatement.executeUpdate();
			   System.out.println("data inserted successfully");}
			  else  
			   System.out.println("Invalid user name and password");  
			
			
			break;
		case "2":
			   
			  System.out.print("Enter the user id : ");  
			  String str12 = sc.next();  
			  System.out.print("Enter the password : ");  
			  String str22 = sc.next();  
			  ResultSet rs1 = stmt.executeQuery("select name,password from persontable where name='" + str12 + "' and password='" + str22 + "'");  
			  if (rs1.next()) { 
			   System.out.println("Welcome::: " + str12); 
			  e.CreateEmail();
			  String r=e.getEmployeemail();
			  String sub="subject";
			  String msg="Your organisational mail id was created mail id:"+e.getGenaratedemail()+"password:"+e.getGenaratedpassword();
			  System.out.println("data inserted successfully");
			  SendEmail send = new SendEmail(r,sub,msg);
			  preparedStatement.setString(1,"1");
			  preparedStatement.setString(2,e.getGenaratedemail());
			  preparedStatement.setString(3,e.getGenaratedpassword());


			  preparedStatement.executeUpdate();
			  System.out.println("data inserted successfully");	}
			  else  
			   System.out.println("Invalid user name and password");  
			break;
		}
		
}
catch (SQLException e) {
System.out.println(e);
		
}
		
}

}


