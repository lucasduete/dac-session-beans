package io.github.lucasduete.dac.sessionbeans.web.controllers;

import io.github.lucasduete.dac.sessionbeans.shared.entities.Contato;
import io.github.lucasduete.dac.sessionbeans.shared.services.ContatoServiceInterface;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;

@Named
@RequestScoped
public class ContatoController {

    @EJB
    ContatoServiceInterface contatoService;

    private Contato contato = new Contato();
    private boolean modoEditando = false;

    public String salvar() {
        try {
            this.contatoService.salvar(this.contato);
            limparContato();
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
        
        return null;
    }

    public void excluir(Contato contato) {
        try {
            this.contatoService.excluir(contato);
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
    }

    public Contato pesquisarByNome(String nome) {
        try {
            return this.contatoService.pesquisarByNome(nome);
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            return new Contato();
        }
    }

    public List<Contato> listarOrdemAlfabetica() {
        try {
            return this.contatoService.listarOrdemAlfabetica();
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
            return new ArrayList<Contato>();
        }
    }
    
    public void editar(Contato contato) {
        this.contato = contato;
        modoEditando = true;
    }
    
    public String atualizar() {
        try {
            boolean result = this.contatoService.editar(contato);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ContatoController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ContatoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.modoEditando = false;
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
