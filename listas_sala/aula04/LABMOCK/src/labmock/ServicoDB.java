package labmock;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ServicoDB implements IServicoDB{
	
	private Connection conn;
	
	public void getDBConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:8066/busca","admin","senha");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(SQLException e) {
			// TODO Auto-generatedb catck block
			e.printStackTrace();
		}
	}


	public int persisteProcesso(IProcesso processo) {
		try {
			String statement = "INSERT INTO PROCESSO (id, nomeReclamante, telefone, email)" + "VALUES('" + processo.getID()
				+ "','" + processo.getNomeReclamante()+ "','" + processo.getTelefone() + "','" + processo.getEmail()
				+ "');";
			return conn.createStatement().executeUpdate(statement);
		} catch(SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
	}
}