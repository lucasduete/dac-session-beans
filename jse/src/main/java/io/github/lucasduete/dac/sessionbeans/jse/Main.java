package io.github.lucasduete.dac.sessionbeans.jse;

import io.github.lucasduete.dac.sessionbeans.shared.entities.Contato;
import io.github.lucasduete.dac.sessionbeans.shared.services.ContatoServiceInterface;
import java.util.Scanner;
import java.util.List;

public class Main {

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        ContatoServiceInterface contatoService = new ContatoLocator().lookup();

        menu();
        int opcao = scanner.nextInt();

        switch (opcao) {
            case 1:
                System.out.println("Digite o nome do contato: ");
                String nome = scanner.next();
                Contato contato = contatoService.pesquisarByNome(nome);
                System.out.println(contato.toString());
                break;
                
            case 2:
                List<Contato> contatos = contatoService.listarOrdemAlfabetica();
                for (Contato c : contatos) System.out.println(c.toString());
        }
    }

    private static void menu() {
        System.out.println("1 - Buscar contato");
        System.out.println("2 - Listar contatos");
    }
}
