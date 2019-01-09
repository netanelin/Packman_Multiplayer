package GUI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * This class connects us to the Data Base.
 * @author Eitan Lichtman, Netanel Indik
 */
public class DB_connect {
	
	/**
	 * Initiates all our data to 0.
	 */
	public DB_connect() {
		this.game_hash_code=0;
		this.score=0;
		this.Id1=0;
		this.Id2=0;
		this.Id3=0;
	}

	/**
	 * Initiates our data by given numbers.
	 */
	public DB_connect(double gameHash, double score, int id, int id2, int id3) {
		this.game_hash_code=gameHash;
		this.score=score;
		this.Id1=id;
		this.Id2=id2;
		this.Id3=id3;
	}

	/**
	 * Clears all data back to 0.
	 */
	public void clear() {
		this.setGame_hash_code(0);
		this.setId1(0);
		this.setId2(0);
		this.setId3(0);
		this.setScore(0);
	}

	public double getGame_hash_code() {
		return game_hash_code;
	}

	public void setGame_hash_code(double gameHash) {
		this.game_hash_code = gameHash;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public int getId1() {
		return Id1;
	}

	public void setId1(int myId) {
		this.Id1 = myId;
	}

	public int getId2() {
		return Id2;
	}

	public void setId2(int myId2) {
		this.Id2 = myId2;
	}

	public int getId3() {
		return Id3;
	}

	public void setId3(int myId3) {
		this.Id3 = myId3;
	}

	/**
	 * @return string representing the data base info.
	 */
	public String dbInfoToString() {
		String ans= "SELECT * FROM logs WHERE ";
		ans+="SomeDouble=" + this.game_hash_code;	
		return ans;
	}
	
	/**
	 * returns players rank compared to other players in a certain senerio of the game.
	 * @return
	 */
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
	
	
	
	//********************private data and methods********************

	private double game_hash_code;
	private double score;
	private int Id1;
	private int Id2;
	private int Id3;
}
