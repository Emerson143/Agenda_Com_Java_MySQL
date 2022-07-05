package br.com.agenda.dao;

import java.sql.Connection;
import java.sql.Date;

import com.mysql.jdbc.PreparedStatement;

import br.com.agenda.factory.ConnectionFactory;
import br.com.agenda.model.contato;

public class contatoDAO {

	public static void save(contato contato) {
		
		String sql = "INSERT INTO  contatos(nome, idade, datacadastro) VALUES (? , ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			// criando uma conexão com o banco de dados
			conn = ConnectionFactory.createConeConnectionToMySQL();
			
			// adicionando os valores que são esperados pela query
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			pstm.setString(1, contato.getNome());
			pstm.setInt(2, contato.getIdade() );
			pstm.setDate(3, new Date(contato.getDataCadastro().getTime()));
			
			pstm.execute();
			
			System.out.println("Contato salvo com sucesso");
			}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			
			//fechar as conexoes
			
			try {
				
				if(pstm!=null) {
				pstm. close();
				}
				
				if (conn!=null) {
				
				conn.close();
				
					}
				}catch(Exception e) {
				e.printStackTrace();
				}
			}
		}
}

