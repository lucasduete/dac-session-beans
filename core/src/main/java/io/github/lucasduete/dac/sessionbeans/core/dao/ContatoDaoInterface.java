package io.github.lucasduete.dac.sessionbeans.core.dao;

import io.github.lucasduete.dac.sessionbeans.shared.entities.Contato;
import java.util.List;

public interface ContatoDaoInterface {
    
    public boolean salvar(Contato contato);
    public boolean editar(Contato contato);
    public boolean excluir(Contato contato);
    public Contato recuperar(String nome);
    public List<Contato> listar();
    public List<Contato> agruparContatoPorNome();
}
