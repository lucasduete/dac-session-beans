package io.github.lucasduete.dac.sessionbeans.core.services;

import io.github.lucasduete.dac.sessionbeans.core.dao.ContatoDaoInterface;
import io.github.lucasduete.dac.sessionbeans.shared.entities.Contato;
import io.github.lucasduete.dac.sessionbeans.shared.services.ContatoServiceInterface;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

@Stateless
@Remote(ContatoServiceInterface.class)
public class ContatoService implements ContatoServiceInterface {
    
    @EJB
    private ContatoDaoInterface contatoDao;

    @Override
    public boolean salvar(Contato contato) {
        
        return contatoDao.salvar(contato);
    }

    @Override
    public boolean editar(Contato contato) {
        
        return contatoDao.editar(contato);
    }

    @Override
    public boolean excluir(Contato contato) {
        
        return contatoDao.excluir(contato);
    }

    @Override
    public Contato pesquisarByNome(String nome) {
        
        return contatoDao.recuperar(nome);
    }

    @Override
    public List<Contato> listarOrdemAlfabetica() {
        
        return contatoDao.listar();
    }

    @Override
    public List<Contato> agruparContatoPorNome(String inicial) {
        
        return contatoDao.listarPorInicial(inicial);
    }
    
}
