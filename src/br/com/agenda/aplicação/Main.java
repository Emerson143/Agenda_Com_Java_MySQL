package br.com.agenda.aplicação;

import java.util.Date;

import br.com.agenda.dao.contatoDAO;
import br.com.agenda.model.contato;

public class Main {

	public static void main(String[] args) {
		
		contato contato = new contato();
		
		contato.setNome("João Anderson");
		contato.setIdade(77);
		contato.setDataCadastro(new Date());
		
		contatoDAO.save(contato);
	}
}
