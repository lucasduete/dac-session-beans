package io.github.lucasduete.dac.sessionbeans.core.services;

import io.github.lucasduete.dac.sessionbeans.core.dao.ContatoDao;
import io.github.lucasduete.dac.sessionbeans.shared.entities.Contato;
import io.github.lucasduete.dac.sessionbeans.shared.services.ContatoServiceInterface;
import java.sql.SQLException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

@Stateless
@Remote(ContatoServiceInterface.class)
public class ContatoService implements ContatoServiceInterface {
    
    @EJB
    private ContatoDao contatoDao;

    @Override
    public boolean salvar(Contato contato) throws ClassNotFoundException, SQLException {
        return contatoDao.salvar(contato);
    }

    @Override
    public boolean editar(Contato contato) throws ClassNotFoundException, SQLException {
        return contatoDao.editar(contato);
    }

    @Override
    public boolean excluir(Contato contato) throws ClassNotFoundException, SQLException {
        return contatoDao.excluir(contato);
    }

    @Override
    public Contato pesquisarByNome(String nome) throws ClassNotFoundException, SQLException {
        return contatoDao.recuperar(nome);
    }

    @Override
    public List<Contato> listarOrdemAlfabetica() throws ClassNotFoundException, SQLException{
        return contatoDao.listar();
    }

    @Override
    public List<Contato> agruparContatoPorNome() throws ClassNotFoundException, SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
