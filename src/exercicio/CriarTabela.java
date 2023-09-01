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

public class CriarTabela extends JFrame {
	private static final long serialVersionUID = 1L;
	private Connection con;
	private Statement st;
	
	public CriarTabela() {
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
			System.exit(0);
		}catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this,"Falha na conexão com o banco!\n" +"Mensagem: " + e.getMessage(),"Erro", JOptionPane.ERROR_MESSAGE);
			System.exit(1);
		}
		
		String sentencaSQL = "CREATE TABLE Produto (codProduto integer PRIMARY KEY, produto VARCHAR(50));" ;
		
		try{
			st = con.createStatement();
			st.executeUpdate(sentencaSQL);
			JOptionPane.showMessageDialog(this,"Tabela criada com sucesso!","Mensagem", JOptionPane.WARNING_MESSAGE);
		}catch (SQLException eSQL) {
			eSQL.printStackTrace();
			JOptionPane.showMessageDialog(this,"Não foi possível criar a tabela!\n" + "Mensagem: " + eSQL.getMessage(),"Erro", JOptionPane.ERROR_MESSAGE);
			System.exit(2);
		}
		
		try {
			st.close();
			con.close();
		}catch(Exception exception){
			exception.printStackTrace();
			System.exit(3);
		}
		Container P = getContentPane();
		P.setLayout(new FlowLayout());
		JLabel mensagem = new JLabel("Você acabou de testar um exemplo usando CREATE TABLE!");
		P.add(mensagem);
	}

	
	public static void main(String args[]){
		CriarTabela ex = new CriarTabela();
		ex.setDefaultCloseOperation(EXIT_ON_CLOSE);
		ex.setTitle("USANDO CREATE TABLE");
		ex.setVisible(true);
		ex.setSize(400,300);
	}
}
