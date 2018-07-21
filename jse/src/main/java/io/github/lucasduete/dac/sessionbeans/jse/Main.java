/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.lucasduete.dac.sessionbeans.jse;

import io.github.lucasduete.dac.sessionbeans.shared.entities.Contato;
import io.github.lucasduete.dac.sessionbeans.shared.services.ContatoServiceInterface;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.List;

/**
 *
 * @author lucasduete
 */
public class Main {
    
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        ContatoServiceInterface contatoService = new ContatoLocator().lookup();
        
        menu();
        int opcao = scanner.nextInt();
        
        switch(opcao){
            case 1: 
                System.out.println("Digite o nome do contato: ");
                String nome = scanner.next();
                try {
                    Contato contato = contatoService.pesquisarByNome(nome);
                    System.out.println(contato.toString());
                } catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case 2:
        
                try {
                    List<Contato> contatos = contatoService.listarOrdemAlfabetica();
                    for(Contato c : contatos){
                        System.out.println(c.toString());
                    }
                } catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
    }
    
    private static void menu(){
        System.out.println("1 - Buscar contato");
        System.out.println("2 - Listar contatos");
    }
}
