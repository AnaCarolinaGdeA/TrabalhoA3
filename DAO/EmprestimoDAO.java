package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Amigo;
import model.Emprestimo;
import model.Ferramenta;

public class EmprestimoDAO {

    //public static ArrayList<Emprestimo> listaemprestimos = new ArrayList<Emprestimo>();
    public static void cadastrar(Emprestimo emprestimo) {
        String sql = "INSERT INTO Emprestimo (amigo_id, ferramenta_id, dataEmp) VALUES (?, ?, ?)";
        PreparedStatement ps = null;
        try {
            Connection conn = Conexao.getConexao();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, emprestimo.getAmigo().getId());
            ps.setInt(2, emprestimo.getFerramenta().getId());
            ps.setDate(3, new java.sql.Date(emprestimo.getDataEmp().getTime()));
            ps.execute();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }

    public static void editar(Emprestimo emprestimo) {
        String sql = "UPDATE Emprestimo SET dataDev = ? , WHERE id = ?";
        PreparedStatement ps = null;
        try {
            Connection conn = Conexao.getConexao();
            ps = conn.prepareStatement(sql);
            ps.setDate(1, new java.sql.Date(emprestimo.getDataDev().getTime()));
            ps.setInt(2, emprestimo.id);
            ps.execute();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }

    public static List<Emprestimo> getEmprestimo() {
        List<Emprestimo> listaemprestimos = new ArrayList<Emprestimo>();
        String sql = "SELECT e.id, a.id AS amigo_id, a.nome AS amigo_nome, a.telefone AS amigo_telefone, "
                + "f.id AS ferramenta_id, f.Fnome AS ferramenta_nome, f.marca AS ferramenta_marca, f.custo AS ferramenta_custo, "
                + "e.dataEmp, e.dataDev "
                + "FROM Emprestimo e"
                + "JOIN Amigo a ON e.amigo_id = a.id"
                + "JOIN Ferramenta f ON e.ferramenta_id = f.id";
        PreparedStatement ps = null;
        try {
            Connection conn = Conexao.getConexao();
            ps = conn.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            if (rs != null) {
                while (rs.next()) {
                    Emprestimo e = new Emprestimo();
                    Amigo a = new Amigo();
                    Ferramenta f = new Ferramenta();

                    e.id = rs.getInt(1);
                    a.id = rs.getInt(2);
                    a.nome = rs.getString(3);
                    a.telefone = rs.getString(4);
                    f.id = rs.getInt(5);
                    f.Fnome = rs.getString(6);
                    f.marca = rs.getString(7);
                    f.custo = rs.getDouble(8);
                    e.dataEmp = rs.getDate(9);
                    e.dataDev = rs.getDate(10);
                    listaemprestimos.add(e);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        return listaemprestimos;
    }

}
