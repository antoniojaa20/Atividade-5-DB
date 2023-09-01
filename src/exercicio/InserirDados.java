package exercicio;

import java.awt.Container;
import java.awt.FlowLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class InserirDados extends JFrame {
	private static final long serialVersionUID = 1L;
	private Connection con;
	private Statement st;
	
	public InserirDados() throws SQLException {
		String driver = "com.mysql.cj.jdbc.Driver";
		String sUsuario = "root";
		String sSenha = "Isa29052003_Belly";
		String sFonte = "jdbc:mysql://127.0.0.1:3306/loja";
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(sFonte, sUsuario, sSenha);
			JOptionPane.showMessageDialog(this,"Banco conectado com sucesso!","Mensagem", JOptionPane.WARNING_MESSAGE);
		}catch (SQLException eSQL) {
			eSQL.printStackTrace();
			JOptionPane.showMessageDialog(this,"Falha na conexão com o banco!\n" +"Mensagem: " + eSQL.getMessage(),"Erro", JOptionPane.ERROR_MESSAGE);
		}catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this,"Falha na conexão com o banco!\n" +"Mensagem: " + e.getMessage(),"Erro", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		
		try{
			st = con.createStatement();
			st.executeUpdate ("INSERT INTO produto values(1,'Arroz');");
			st.executeUpdate ("INSERT INTO produto values(2,'Feijão');");
			st.executeUpdate ("INSERT INTO produto values(3,'Macarrão');");
		}catch(SQLException eSQL){
			JOptionPane.showMessageDialog(this,"Erro na expressão do INSERT!\n" +"Mensagem: " + eSQL.getMessage(),"Erro", JOptionPane.ERROR_MESSAGE);
			System.exit(1);
		}
		
		try {
			st.close();
			con.close();
		}catch(Exception exception){
			exception.printStackTrace();
			System.exit(2);
		}
		
		Container P = getContentPane();
		P.setLayout(new FlowLayout());
		JLabel mensagem = new JLabel("Você acabou de testar um exemplo usando INSERT!");
		P.add(mensagem);
	}
	
	public static void main(String args[]) throws SQLException{
		InserirDados ex = new InserirDados();
		ex.setDefaultCloseOperation(EXIT_ON_CLOSE);
		ex.setVisible(true);
		ex.setTitle("USANDO INSERT");
		ex.setSize(400,200);
	}
}
