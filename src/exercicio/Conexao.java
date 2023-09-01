package exercicio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	public static void main(String[] args){
		 String driver = "com.mysql.cj.jdbc.Driver";
		 String user = "root";
		 String senha = "Isa29052003_Belly";
		 String url = "jdbc:mysql://127.0.0.1:3306/loja";

		 try{
			 Class.forName(driver);
			 Connection con = null;

			 con = (Connection) DriverManager.getConnection(url, user, senha);

			 System.out.println("Conexão realizada com sucesso.");

		 }
		 catch (ClassNotFoundException ex){
			 System.err.print(ex.getMessage());
		 }
		 catch (SQLException e){
			 System.err.print(e.getMessage());
		 }
	 }
}
