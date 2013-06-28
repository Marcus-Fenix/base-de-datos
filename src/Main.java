import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

public class Main {

	/**
	 * @param args
	 * @throws ClassNotFoundException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DataAcces data = new DataAcces("MYSQL");
		data.setServer("localhost");
		data.setDataBase("automotriz");
		data.setUser("root");
		data.setPassword("root");
		data.Conectar();
		ResultSet rs = data.GetData("select * from auto");
		try {
			while(rs.next()){
				System.out.println(rs.getInt("modelo"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
