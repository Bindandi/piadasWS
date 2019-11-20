/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dal;

import Entidade.Piada;
import Regra.Regras_Categoria;
import Regra.Regras_FaixaEtaria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Aluno
 */
public class PiadaDAL {

    private Regras_Categoria regrasCategoria;
    private Regras_FaixaEtaria regrasFaixaEtaria;

    public PiadaDAL() {
        regrasCategoria = new Regras_Categoria();
        regrasFaixaEtaria = new Regras_FaixaEtaria();
    }

    public Piada buscaRand(Connection conn) {
        String sql = "select * from piada where faixaetaria = 0 order by rand();";
        
        try {
            PreparedStatement pst = conn.prepareStatement(sql);

            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return new Piada(
                        rs.getInt("id"),
                        rs.getString("titulo"),
                        regrasCategoria.buscaCategoria(rs.getInt("categoria")),
                        regrasFaixaEtaria.buscaFaixaEtaria(rs.getInt("faixaetaria")),
                        rs.getString("conteudo"),
                        rs.getString("imagem")
                        
                );
            }

        } catch (SQLException ex) {
            System.out.printf(ex.toString());
        }

        return null;
    }

    public List<Piada> busca(Connection conn, int idCategoria, int idFaixaEtaria, String palavra) {
        List<Piada> list = new ArrayList<>();
        String sql = "select * from piada";
        if(idCategoria != -1)
            sql = sql + " where categoria = "+idCategoria;
        if(idFaixaEtaria != -1){
            if(sql.equals("select * from piada"))
                sql = sql + " where faixaetaria = "+idFaixaEtaria;
            else
                sql = sql + " and faixaetaria = "+idFaixaEtaria;
        }
        if(!palavra.equals("")){
            if(sql.equals("select * from piada"))
                sql = sql + " where titulo like '%"+palavra+"%'";
            else
                sql = sql + " and titulo like '%"+palavra+"%'";  
        }
            
        //String sql = "select * from piada where categoria=? and faixaetaria=? and titulo like '%?%';";
        
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                list.add(new Piada(
                        rs.getInt("id"),
                        rs.getString("titulo"),
                        regrasCategoria.buscaCategoria(rs.getInt("categoria")),
                        regrasFaixaEtaria.buscaFaixaEtaria(rs.getInt("faixaetaria")),
                        rs.getString("conteudo"),
                        rs.getString("imagem")
                        
                ));
            }

        } catch (SQLException ex) {
            System.out.printf(ex.toString());
        }

        return list;
    }

}
