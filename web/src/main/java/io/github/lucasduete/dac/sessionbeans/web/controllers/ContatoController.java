package io.github.lucasduete.dac.sessionbeans.web.controllers;

import io.github.lucasduete.dac.sessionbeans.shared.entities.Contato;
import io.github.lucasduete.dac.sessionbeans.shared.services.ContatoServiceInterface;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.List;
import javax.ejb.EJB;

@Named
@RequestScoped
public class ContatoController {

    @EJB
    ContatoServiceInterface contatoService;

    Contato contato = new Contato();

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

    private void limparContato() {
        this.contato = new Contato();
    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }
}
