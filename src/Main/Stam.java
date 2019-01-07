package Main;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Game_Components.Box;
import Ratio.Ratio_Point;
import Ratio.Ratio_Segment;

/**
 * written by Yael as an example for.
 */

public class Stam {
	public static void main(String[] args)
	{
		
		
		Ratio_Point p1 = new Ratio_Point(0.3, 0.5);
		Ratio_Point p2 = new Ratio_Point(0.5, 0.6);

		Ratio_Segment rs1 = new Ratio_Segment(p1, p2);
		
		Ratio_Point p3 = new Ratio_Point(0.4, 0.3);
		Ratio_Point p4 = new Ratio_Point(0.4, 0.9);
		
		Ratio_Segment rs2 = new Ratio_Segment(p3, p4);

		Box b = new Box(p3,p4);
		
		System.out.println(b.intersect(rs1));
		
		
		
		
		
		
		
//		String jdbcUrl="jdbc:mysql://ariel-oop.xyz:3306/oop"; //?useUnicode=yes&characterEncoding=UTF-8&useSSL=false";
//		String jdbcUser="student";
//		String jdbcPassword="student";
//		
//		try {
//			Class.forName("com.mysql.jdbc.Driver");
//			Connection connection = 
//					DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPassword);
//
//			Statement statement = connection.createStatement();
//			
//			//select data
//			String allCustomersQuery = "SELECT * FROM logs;";
//			ResultSet resultSet = statement.executeQuery(allCustomersQuery);
//			System.out.println("FirstID\t\tSecondID\tThirdID\t\tLogTime\t\t\t\tPoint\t\tSomeDouble");
//			while(resultSet.next())
//			{
//				System.out.println(resultSet.getInt("FirstID")+"\t\t" +
//						resultSet.getInt("SecondID")+"\t\t" +
//						resultSet.getInt("ThirdID")+"\t\t" +
//						resultSet.getTimestamp("LogTime") +"\t\t\t\t" +
//						resultSet.getDouble("Point") +"\t\t" +
//						resultSet.getDouble("SomeDouble"));
//			}
//			
//			resultSet.close();		
//			statement.close();		
//			connection.close();		
//		}
//		
//		catch (SQLException sqle) {
//			System.out.println("SQLException: " + sqle.getMessage());
//			System.out.println("Vendor Error: " + sqle.getErrorCode());
//		}
//		
//		catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
	}
}
