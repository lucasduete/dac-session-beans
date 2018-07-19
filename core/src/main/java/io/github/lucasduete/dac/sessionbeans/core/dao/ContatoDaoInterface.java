package io.github.lucasduete.dac.sessionbeans.core.dao;

import io.github.lucasduete.dac.sessionbeans.shared.entities.Contato;
import java.sql.SQLException;
import java.util.List;

public interface ContatoDaoInterface {
    
    public boolean salvar(Contato contato) throws ClassNotFoundException, SQLException;
    public boolean editar(Contato contato) throws ClassNotFoundException, SQLException;
    public boolean excluir(Contato contato) throws ClassNotFoundException, SQLException;
    public Contato recuperar(String nome) throws ClassNotFoundException, SQLException;
    public List<Contato> listar() throws ClassNotFoundException, SQLException;
    public List<Contato> agruparContatoPorNome() throws ClassNotFoundException, SQLException;
}
