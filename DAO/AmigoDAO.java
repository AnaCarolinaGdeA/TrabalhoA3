package DAO;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Amigo;

public class AmigoDAO {

    //public static ArrayList<Amigo> listaamigos = new ArrayList<Amigo>();
    public static void cadastrar(Amigo amigo) {
        String sql = "INSERT INTO Amigo(nome, telefone) VALUES (? , ?)";
        PreparedStatement ps = null;
        try {
            Connection conn = Conexao.getConexao();
            ps = conn.prepareStatement(sql);
            ps.setString(1, amigo.nome);
            ps.setString(2, amigo.telefone);
            ps.execute();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }

    public static void editar(Amigo amigo) {
        String sql = "UDTADE Amigo SET nome = ? , telefone = ? , WHERE id = ? ";
        PreparedStatement ps = null;
        try {
            Connection conn = Conexao.getConexao();
            ps = conn.prepareStatement(sql);
            ps.setString(1, amigo.nome);
            ps.setString(2, amigo.telefone);
            ps.setInt(3, amigo.id);
            ps.execute();
            //Conexao.fecharConn( conn );
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }

    public static void excluir(int id) {
        String sql = "DELETE FROM Amigo WHERE id = ? ";
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

    public static List<Amigo> getAmigo(){
        List<Amigo> listaamigos = new ArrayList<Amigo>();
        String sql = " SELECT a.id, a.nome, a.telefone"
                   + " FROM Amigo a "
                   + " ORDER BY a.nome ";
        PreparedStatement ps = null;
        try {
            Connection conn = Conexao.getConexao();
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if( rs != null){
                while (rs.next() ){
                    Amigo am = new Amigo();
                    am.id = rs.getInt(1);
                    am.nome = rs.getString(2);
                    am.telefone = rs.getString(3);
                    listaamigos.add(am);
                }
            }
        } catch (SQLException e){
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return listaamigos;
    }
}
