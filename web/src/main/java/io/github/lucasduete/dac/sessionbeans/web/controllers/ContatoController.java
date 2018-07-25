package io.github.lucasduete.dac.sessionbeans.web.controllers;

import io.github.lucasduete.dac.sessionbeans.shared.entities.Contato;
import io.github.lucasduete.dac.sessionbeans.shared.services.ContatoLocator;
import io.github.lucasduete.dac.sessionbeans.shared.services.ContatoServiceInterface;
import java.io.Serializable;

import javax.inject.Named;
import java.util.List;
import javax.enterprise.context.SessionScoped;

@Named
@SessionScoped
public class ContatoController implements Serializable {

    ContatoServiceInterface contatoService = new ContatoLocator().lookup();

    private Contato contato = new Contato();
    private boolean modoEditando = false;

    public String salvar() {
            this.contatoService.salvar(this.contato);
            limparContato();
        
        return null;
    }

    public void excluir(Contato contato) {
            this.contatoService.excluir(contato);
    }

    public Contato pesquisarByNome() {
        Contato contato = this.contatoService.pesquisarByNome(this.contato.getNome());
        
        if (contato == null) return new Contato();
        else return contato;
        
    }

    public List<Contato> listarOrdemAlfabetica() {
            return this.contatoService.listarOrdemAlfabetica();
    }
    
    public List<Contato> agruparPorInincial(String inicial) {
        return this.contatoService.agruparContatoPorNome(inicial);
    }
    
    public void editar(Contato contato) {
        this.contato = contato;
        modoEditando = true;
    }
    
    public String atualizar() {
            if (contatoService.editar(contato)) {
                this.contato = new Contato();
                this.modoEditando = false;
            }
        
        return "";
    }

    private void limparContato() {
        this.contato = new Contato();
    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

    public boolean isModoEditando() {
        return modoEditando;
    }
    
}
