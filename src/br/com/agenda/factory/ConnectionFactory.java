package br.com.agenda.factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	
	//Nome do usuário do mysql
	private static final String USERNAME = "root";
	
	//senha do banco
	private static final String PASSOWORD = "";
	
	//caminho do banco de dado, porta e o nome do banco de dados
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/agenda";
	
	
	public static Connection createConeConnectionToMySQL() throws Exception {
		//faz com que a clase seja carregada pela JVM
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSOWORD);
		
		return connection;
	}
	
	public static void main(String[] args) throws Exception {
		
		//Recuperar uma conexão com o banco de dados
		Connection con = createConeConnectionToMySQL();
		
		// testar se a conexão é nula
		if (con!=null) {
			System.out.println("Conexão obetida com sucesso");
			con.close();
		}
	}
}
