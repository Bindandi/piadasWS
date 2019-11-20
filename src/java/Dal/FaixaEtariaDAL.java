/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dal;

import Entidade.FaixaEtaria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Aluno
 */
public class FaixaEtariaDAL {

    public FaixaEtaria buscaById(Connection conn, int id) {
        String sql = "select * from faixa_etaria where id = ?";

        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return new FaixaEtaria(
                        rs.getInt("id"),
                        rs.getString("descricao")
                );
            }

        } catch (SQLException ex) {
            System.out.printf(ex.toString());
        }

        return null;
    }
}
