package io.github.lucasduete.dac.sessionbeans.shared.services;

import io.github.lucasduete.dac.sessionbeans.shared.entities.Contato;
import java.util.List;

public interface ContatoServiceInterface {
    
    public boolean salvar(Contato contato);
    public boolean editar(Contato contato);
    public boolean excluir(Contato contato);
    public Contato pesquisarByNome(String nome);
    public List<Contato> listarOrdemAlfabetica();  
    
}
