package GUI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB_connect {

	//////private/////
	private double gameHash;
	private double score;
	private int myId;
	private int myId2;
	private int myId3;


	public DB_connect() {
		this.gameHash=0;
		this.score=0;
		this.myId=0;
		this.myId2=0;
		this.myId3=0;
	}

	public DB_connect(double gameHash, double score, int id, int id2, int id3) {
		this.gameHash=gameHash;
		this.score=score;
		this.myId=id;
		this.myId2=id2;
		this.myId3=id3;
	}

	public void clear() {
		this.setGameHash(0);
		this.setMyId(0);
		this.setMyId2(0);
		this.setMyId3(0);
		this.setScore(0);
	}

	public double getGameHash() {
		return gameHash;
	}

	public void setGameHash(double gameHash) {
		this.gameHash = gameHash;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public int getMyId() {
		return myId;
	}

	public void setMyId(int myId) {
		this.myId = myId;
	}

	public int getMyId2() {
		return myId2;
	}

	public void setMyId2(int myId2) {
		this.myId2 = myId2;
	}

	public int getMyId3() {
		return myId3;
	}

	public void setMyId3(int myId3) {
		this.myId3 = myId3;
	}

	public String dbInfoToString() {
		String ans= "SELECT * FROM logs WHERE ";
		ans+="SomeDouble=" + this.gameHash;	
		return ans;
	}

	public int rank() {
		int rank=1;
		String jdbcUrl="jdbc:mysql://ariel-oop.xyz:3306/oop"; //?useUnicode=yes&characterEncoding=UTF-8&useSSL=false";
		String jdbcUser="student";
		String jdbcPassword="student";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = 
					DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPassword);


			Statement statement = connection.createStatement();
			String ans = this.dbInfoToString();


			//select data
			String allCustomersQuery = ans;
			ResultSet resultSet = statement.executeQuery(allCustomersQuery);
			while(resultSet.next())
			{
				double point = resultSet.getDouble("Point");
				if(point>this.getScore()) {
					rank+=1;
				}
			}
			resultSet.close();		
			statement.close();		
			connection.close();		
		}

		catch (SQLException sqle) {
			System.out.println("SQLException: " + sqle.getMessage());
			System.out.println("Vendor Error: " + sqle.getErrorCode());
		}

		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return rank;

	}	
}
