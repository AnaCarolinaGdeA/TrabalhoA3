package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Ferramenta;


public class FerramentaDAO {
    
    //public static ArrayList<Ferramenta> listaferramentas = new ArrayList<Ferramenta>();
    
    public static void cadastrar(Ferramenta ferramenta) {
        String sql = "INSERT INTO Ferramenta(Fnome, marca, custo) VALUES (? , ? , ?)";
        PreparedStatement ps = null;
        try {
            Connection conn = Conexao.getConexao();
            ps = conn.prepareStatement(sql);
            ps.setString(1, ferramenta.Fnome);
            ps.setString(2, ferramenta.marca);
            ps.setDouble(3, ferramenta.custo);
            ps.execute();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }
    
    public static void editar(Ferramenta ferramenta) {
        String sql = "UPDATE Ferramenta Fnome = ? , marca = ? , custo = ? WHERE id = ?";
        PreparedStatement ps = null;
        try{
            Connection conn = Conexao.getConexao();
            ps = conn.prepareStatement(sql);
            ps.setString(1, ferramenta.Fnome);
            ps.setString(2, ferramenta.marca);
            ps.setDouble(3, ferramenta.custo);
            ps.setInt(4, ferramenta.id);
            ps.execute();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }
    
    public static void excluir(int id) {
        String sql = "DELETE FROM Ferramenta WHERE id = ?";
        PreparedStatement ps = null;
        try {
            Connection conn = Conexao.getConexao();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }
    
    public static List<Ferramenta> getFerramenta() {
        List<Ferramenta> listaferramentas = new ArrayList<Ferramenta>();
        String sql = " SELECT f.id, f.Fnome, f.marca, f.custo" +
                     " FROM Ferramenta f" +
                     " ORDER BY f.Fnome";
        PreparedStatement ps = null;
        try {
            Connection conn = Conexao.getConexao();
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if ( rs != null ) {
                while (rs.next()) {
                    Ferramenta fe = new Ferramenta();
                    fe.id = rs.getInt(1);
                    fe.Fnome = rs.getString(2);
                    fe.marca = rs.getString(3);
                    fe.custo = rs.getDouble(4);
                    listaferramentas.add(fe);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return listaferramentas;
    }
}
