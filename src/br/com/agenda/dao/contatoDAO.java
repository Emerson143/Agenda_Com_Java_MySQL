package br.com.agenda.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import br.com.agenda.factory.ConnectionFactory;
import br.com.agenda.model.contato;

public class contatoDAO {

	public void save(contato contato) {

		String sql = "INSERT INTO  contatos(nome, idade, datacadastro) VALUES (? , ?, ?)";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			// criando uma conex?o com o banco de dados
			conn = ConnectionFactory.createConeConnectionToMySQL();

			// adicionando os valores que s?o esperados pela query
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			pstm.setString(1, contato.getNome());
			pstm.setInt(2, contato.getIdade());
			pstm.setDate(3, new Date(contato.getDataCadastro().getTime()));

			pstm.execute();

			System.out.println("Contato salvo com sucesso");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			// fechar as conexoes

			try {

				if (pstm != null) {
					pstm.close();
				}

				if (conn != null) {

					conn.close();

				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void DeleteByID(int id) {
		String sql = "DELETE  FROM contatos WHERE id = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConeConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			
			pstm.setInt(1, id);
			
			pstm.execute();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (pstm != null) {
					pstm.close();
					}
				if (conn != null) {
					conn.close();
				}
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	public void update(contato contato) {

		String sql = "UPDATE contatos SET nome = ?, idade = ?, datacadastro = ? " + "WHERE id = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {

			// criar conex?o com o banco
			conn = ConnectionFactory.createConeConnectionToMySQL();

			// Criar a classe para executar a query
			pstm = (PreparedStatement) conn.prepareStatement(sql);

			// adicionando os valores
			pstm.setString(1, contato.getNome());
			pstm.setInt(2, contato.getIdade());
			pstm.setDate(3, new Date(contato.getDataCadastro().getTime()));

			// qual o id do registro que deseja
			pstm.setInt(4, contato.getId());

		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public List<contato> getContatos() {

		String sql = "SELECT * FROM  contatos";

		List<contato> contatos = new ArrayList<contato>();

		Connection conn = null;
		PreparedStatement pstm = null;

		// Clase que vai recuperar os dados do banco ****SELECT****
		ResultSet rset = null;

		try {
			conn = ConnectionFactory.createConeConnectionToMySQL();

			pstm = (PreparedStatement) conn.prepareStatement(sql);

			rset = pstm.executeQuery();

			while (rset.next()) {

				contato contato = new contato();

				// recupera o id
				contato.setId(rset.getInt("id"));

				// recuperar o nome
				contato.setNome(rset.getString("nome"));

				contato.setIdade(rset.getInt("idade"));

				contato.setDataCadastro(rset.getDate("datacadastro"));

				contatos.add(contato);
			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {

			try {
				if (rset != null) {
					rset.close();
				}
				if (pstm != null) {
					pstm.close();
				}

				if (conn != null) {

					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return contatos;
	}
}
