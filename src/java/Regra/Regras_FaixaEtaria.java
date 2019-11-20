/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Regra;

import Dal.CategoriaDAL;
import Dal.FaixaEtariaDAL;
import Entidade.Categoria;
import Entidade.FaixaEtaria;
import conexao.Conec_MySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Aluno
 */
public class Regras_FaixaEtaria {
    public FaixaEtaria buscaFaixaEtaria(int id) {
        Conec_MySQL conexao = new Conec_MySQL();
        
        Connection conn = conexao.abre();

        FaixaEtaria fx;
        FaixaEtariaDAL faixaetariaDAL = new FaixaEtariaDAL();
        fx = faixaetariaDAL.buscaById(conn, id);

        return fx;
    }
}
