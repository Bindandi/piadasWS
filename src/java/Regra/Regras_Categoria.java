/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Regra;

import Dal.CategoriaDAL;
import Dal.PiadaDAL;
import Entidade.Categoria;
import Entidade.Piada;
import conexao.Conec_MySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Aluno
 */
public class Regras_Categoria {
    public Categoria buscaCategoria(int id) {
        Conec_MySQL conexao = new Conec_MySQL();
        
        Connection conn = conexao.abre();

        Categoria c;
        CategoriaDAL categoriaDAL = new CategoriaDAL();
        c = categoriaDAL.buscaById(conn, id);

        return c;
    }
}
