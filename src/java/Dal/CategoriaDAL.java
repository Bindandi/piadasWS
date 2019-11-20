/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dal;

import Entidade.Categoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Aluno
 */
public class CategoriaDAL {
    public Categoria buscaById(Connection conn, int id) {
        String sql = "select * from categoria_piada where id = ?";
        
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return new Categoria(
                    rs.getInt("id"),
                    rs.getString("nome")  
                );
            }

        } catch (SQLException ex) {
            System.out.printf(ex.toString());
        }

        return null;
    }
}
