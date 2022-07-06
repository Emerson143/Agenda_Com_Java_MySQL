package br.com.agenda.aplicação;

import java.util.Date;

import br.com.agenda.dao.contatoDAO;
import br.com.agenda.model.contato;

public class Main {

	public static void main(String[] args) {
		
		contatoDAO contatoDAO = new contatoDAO();
		contato contato = new contato();
		
		contato.setNome("Anderson");
		contato.setIdade(77);
		contato.setDataCadastro(new Date());
		
		//contatoDAO.save(contato);
		
		//atualizar contato
		
		contato c1 = new contato();
		c1.setNome("maria");
		c1.setIdade(35);
		c1.setDataCadastro(new Date());
		c1.setId(2);
		
		//contatoDAO.update(c1);

		//Deletar contato pelo seu numero de ID
		contatoDAO.DeleteByID(6);
		
		for (contato c : contatoDAO.getContatos()) {
			System.out.println(c.getNome());
			System.out.println(c.getIdade());
		}
	}
}
