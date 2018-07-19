package io.github.lucasduete.dac.sessionbeans.shared.services;

import io.github.lucasduete.dac.sessionbeans.shared.entities.Contato;
import java.sql.SQLException;
import java.util.List;

public interface ContatoServiceInterface {
    
    public boolean salvar(Contato contato) throws ClassNotFoundException, SQLException;
    public boolean editar(Contato contato) throws ClassNotFoundException, SQLException;
    public boolean excluir(Contato contato) throws ClassNotFoundException, SQLException;
    public Contato pesquisarByNome(String nome) throws ClassNotFoundException, SQLException;
    public List<Contato> listarOrdemAlfabetica() throws ClassNotFoundException, SQLException;
    public List<Contato> agruparContatoPorNome() throws ClassNotFoundException, SQLException;
    
}
