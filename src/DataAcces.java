import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;


public class DataAcces {
	
	private String Server;
	private String DataBase;
	private String User;
	private String Password;
	private String UrlConeccion;
	private String bdEngine;
	Statement statament;
	
	Connection conexion;

	public DataAcces(String BDEnding){
		this.bdEngine = BDEnding;
		try {
			if(BDEnding.equalsIgnoreCase("MYSQL")){
				Class.forName("com.mysql.jdbc.Driver").newInstance();
			}
			else{
				if(BDEnding.equalsIgnoreCase("ORACLE")){
					Class.forName("ORACLE.jdbc.OracleDriver").newInstance();
				}
			}
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Connection Conectar(){
		try {
			if(this.bdEngine.equalsIgnoreCase("MYSQL")){
				return this.conexion = DriverManager.getConnection("jdbc:mysql://"+ this.Server+"/"+this.DataBase+"",this.User,this.Password );
			}
			else{
				return this.conexion = DriverManager.getConnection("jdbc:oracle:thin:@MYORACL","User","password");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public ResultSet GetData(String query){
		try {
			statament = (Statement) this.conexion.createStatement();
			ResultSet rs = statament.executeQuery(query);
			return rs;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	public void setServer(String server) {
		Server = server;
	}

	public void setUser(String user) {
		User = user;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public void setConexion(Connection conexion) {
		this.conexion = conexion;
	}

	public void setDataBase(String dataBase) {
		DataBase = dataBase;
	}
	
	
}
