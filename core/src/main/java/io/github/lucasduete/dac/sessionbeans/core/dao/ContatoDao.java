package io.github.lucasduete.dac.sessionbeans.core.dao;

import io.github.lucasduete.dac.sessionbeans.shared.entities.Contato;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Local;
import javax.ejb.Stateless;

@Stateless
@Local(ContatoDaoInterface.class)
public class ContatoDao implements ContatoDaoInterface {
    private Connection con = null;
    
    public ContatoDao() throws ClassNotFoundException, SQLException {
        con = new ConFactory().getConnection();
        
    }
        
    @Override
    public boolean salvar(Contato contato) {
        String sql = "INSERT INTO Contato(nome, email, telefone, dataNascimento) VALUES(?,?,?,?);";

        try {
            PreparedStatement stmt = con.prepareStatement(sql);
        
            stmt.setString(1, contato.getNome());
            stmt.setString(2, contato.getEmail());
            stmt.setString(3, contato.getTelefone());
            stmt.setObject(4, contato.getDataNascimento());

            if (stmt.executeUpdate() > 0) return true;
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
        
        return false;
    }

    @Override
    public boolean editar(Contato contato) {
        String sql = "UPDATE Contato SET nome = ?, telefone = ?, dataNascimento = ? "
                + "WHERE email = ?";
        
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
        
            stmt.setString(1, contato.getNome());
            stmt.setString(2, contato.getTelefone());
            stmt.setObject(3, contato.getDataNascimento());
            stmt.setString(4, contato.getEmail());

            if (stmt.executeUpdate() > 0) return true;
        } catch(SQLException ex) {
            Logger.getLogger(ContatoDao.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        }
        
        return false;
    }

    @Override
    public boolean excluir(Contato contato) { 
        String sql = "DELETE FROM Contato WHERE email = ?";
        
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, contato.getEmail());
        
            if (stmt.executeUpdate() > 0) return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return false;
    }

    @Override
    public Contato recuperar(String nome) {
        String sql = "SELECT * FROM Contato WHERE nome = ?";
        
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);
        
            ResultSet rs = stmt.executeQuery();

            if(rs.next()) {
                Contato contato = new Contato();

                contato.setDataNascimento(rs.getObject("dataNascimento", LocalDate.class));
                contato.setEmail(rs.getString("email"));
                contato.setNome(rs.getString("nome"));
                contato.setTelefone(rs.getString("telefone"));

                return contato;    
            }
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
        
        return null;
    }

    @Override
    public List<Contato> listar() {
        String sql = "SELECT * FROM Contato ORDER BY Nome";
        List<Contato> contatos = new ArrayList<>();
        
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {
                Contato contato = new Contato();

                contato.setDataNascimento(rs.getObject("dataNascimento", LocalDate.class));
                contato.setEmail(rs.getString("email"));
                contato.setNome(rs.getString("nome"));
                contato.setTelefone(rs.getString("telefone"));

                contatos.add(contato);            
            }
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
        
        return contatos;
    }
    
    @Override
    public List<Contato> listarPorInicial(String inicial) {        
        String sql = "SELECT * FROM Contato WHERE Nome ILIKE ?";
        List<Contato> contatos = new ArrayList<>();

        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, inicial + "%");
            
            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {
                Contato contato = new Contato();

                contato.setDataNascimento(rs.getObject("dataNascimento", LocalDate.class));
                contato.setEmail(rs.getString("email"));
                contato.setNome(rs.getString("nome"));
                contato.setTelefone(rs.getString("telefone"));

                contatos.add(contato);            
            }
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
        
        return contatos;
    }
    
}