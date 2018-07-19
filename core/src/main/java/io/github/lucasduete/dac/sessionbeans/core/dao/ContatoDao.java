package io.github.lucasduete.dac.sessionbeans.core.dao;

import io.github.lucasduete.dac.sessionbeans.shared.entities.Contato;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Local;
import javax.ejb.Stateless;

@Stateless
@Local
public class ContatoDao implements ContatoDaoInterface {
    private Connection con = null;
    private PreparedStatement stmt = null;
    
    @Override
    public boolean salvar(Contato contato) throws ClassNotFoundException, SQLException{
        int resultado = 0;
        con = this.getConnection();
        String sql = "INSERT INTO Contato(nome, email, telefone, dataNascimento)"
                + "     VALUES(?, ?, ?, ?)";

        stmt = con.prepareStatement(sql);
        
        stmt.setString(1, contato.getNome());
        stmt.setString(2, contato.getEmail());
        stmt.setString(3, contato.getTelefone());
        stmt.setObject(4, contato.getDataNascimento());

        resultado = stmt.executeUpdate();

        stmt.close();
        con.close();

        return resultado > 0;
    }

    @Override
    public boolean editar(Contato contato) throws ClassNotFoundException, SQLException{
        int resultado = 0;
        con = this.getConnection();
        String sql = "UPDATE FROM Contato SET nome = ?, telefone = ?, dataNascimento = ? WHERE email = ?";
        
        stmt = con.prepareStatement(sql);
        
        stmt.setString(1, contato.getNome());
        stmt.setString(2, contato.getTelefone());
        stmt.setObject(3, contato.getDataNascimento());
        stmt.setString(4, contato.getEmail());
        
        resultado = stmt.executeUpdate();
        
        stmt.close();
        con.close();
        
        return resultado > 0;        
    }

    @Override
    public boolean excluir(Contato contato) throws ClassNotFoundException, SQLException{
        int resultado = 0;
        
        con = this.getConnection();
        
        String sql = "DELETE FROM Contato WHERE email = ?";
        
        stmt = con.prepareStatement(sql);
        stmt.setString(1, contato.getEmail());
        
        resultado = stmt.executeUpdate();
        
        stmt.close();
        con.close();
        
        return resultado > 0;
    }

    @Override
    public Contato recuperar(String nome) throws ClassNotFoundException, SQLException{
        int resultado = 0;
        
        con = this.getConnection();
        
        String sql = "SELECT * FROM Contato WHERE nome = ?";
        
        stmt = con.prepareStatement(sql);
        
        ResultSet rs = stmt.executeQuery();
               
        Contato contato = new Contato();
            
        contato.setDataNascimento(rs.getObject("dataNascimento", LocalDate.class));
        contato.setEmail(rs.getString("email"));
        contato.setNome(rs.getString("nome"));
        contato.setTelefone(rs.getString("telefone"));
        
        return contato;
    }

    @Override
    public List<Contato> listar() throws ClassNotFoundException, SQLException {
        int resultado = 0;
        
        con = this.getConnection();
        
        String sql = "SELECT * FROM Contato ORDER BY Nome";
        
        stmt = con.prepareStatement(sql);
        
        ResultSet rs = stmt.executeQuery();
        
        List<Contato> contatos = new ArrayList<>();
        
        while(rs.next()){
            Contato contato = new Contato();
            
            contato.setDataNascimento(rs.getObject("dataNascimento", LocalDate.class));
            contato.setEmail(rs.getString("email"));
            contato.setNome(rs.getString("nome"));
            contato.setTelefone(rs.getString("telefone"));
            
            contatos.add(contato);            
        }
        
        return contatos;
    }
    
    @Override
    public List<Contato> agruparContatoPorNome() throws ClassNotFoundException, SQLException {
        int resultado = 0;
        
        con = this.getConnection();
        
        String sql = "SELECT * FROM Contato ORDER BY Nome";
        
        stmt = con.prepareStatement(sql);
        
        ResultSet rs = stmt.executeQuery();
        
        List<Contato> contatos = new ArrayList<>();
        
        while(rs.next()){
            Contato contato = new Contato();
            
            contato.setDataNascimento(rs.getObject("dataNascimento", LocalDate.class));
            contato.setEmail(rs.getString("email"));
            contato.setNome(rs.getString("nome"));
            contato.setTelefone(rs.getString("telefone"));
            
            contatos.add(contato);            
        }
        
        return contatos;
    }
    
     private Connection getConnection() throws ClassNotFoundException, SQLException {
        return new ConFactory().getConnection();
    }
}