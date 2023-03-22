package jdbcApi.DayOne;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class jdbc {

	public static void main(String[] args) throws ClassNotFoundException, SQLException  {
	
		//Step 1 load the Driver jdbc driver classs 
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//Step 2 Connection attribute
		
		String username= "root";
		String password="sqlroot";
		String url="jdbc:mysql://localhost:3306/testdb1";
				
     	// Step 3  Create a connection 
				
Connection connection = DriverManager.getConnection(url, username, password);


// Step 4 Create a statemnet  
 // 1.statement   2. prestatemnet 

//Statement statement = connection.createStatement();

//String sql = "INSERT INTO `testdb1`.`employee` (`EmpID`, `EmpName`, `EmpAge`, `EmpDept`, `EmpPhone`) VALUES (?, ?, ?, ?, ?)";

String sql = "SELECT * FROM testdb1.employee  where EmpId = ?";

PreparedStatement preparedStatement = connection.prepareStatement(sql);

preparedStatement.setInt(1, 3);

//preparedStatement.setString(2, "Izzy");
//preparedStatement.setInt(3,26);
//preparedStatement.setString(4,"DevOps");
//preparedStatement.setInt(5,1245237);

//int row = preparedStatement.executeUpdate();
ResultSet resultSet = preparedStatement.executeQuery();

//System.out.print((row + "Rows affected"));


while (resultSet.next()) {

int EmpId = resultSet.getInt("EmpId");
String EmpName = resultSet.getString("EmpName");
int EmpAge = resultSet.getInt("EmpAge");
String EmpDept  = resultSet.getString("EmpDept");
int EmpPhone = resultSet.getInt("EmpPhone");

System.out.println(EmpId);
System.out.println(EmpName);
System.out.println(EmpAge);
System.out.println(EmpDept);
System.out.println(EmpPhone);
System.out.println("****************************************");
				
 //Step 5 DML- --> select, insert , Update , delete

 //statement Select --> executeQuery 
 //statement Insert, Update, Delete -->excuteUpdate


	}

}
}
