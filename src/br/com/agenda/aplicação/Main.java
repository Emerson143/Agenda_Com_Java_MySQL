package br.com.agenda.aplica��o;

import java.util.Date;

import br.com.agenda.dao.contatoDAO;
import br.com.agenda.model.contato;

public class Main {

	public static void main(String[] args) {
		
		contato contato = new contato();
		
		contato.setNome("Jo�o Anderson");
		contato.setIdade(77);
		contato.setDataCadastro(new Date());
		
		contatoDAO.save(contato);
	}
}
