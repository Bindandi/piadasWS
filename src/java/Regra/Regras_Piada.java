/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Regra;

import Dal.PiadaDAL;
import Entidade.Piada;
import conexao.Conec_MySQL;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Aluno
 */
public class Regras_Piada {

    public Piada randomPiada() {
        Piada p = null;
        Conec_MySQL conexao = new Conec_MySQL();
        Connection conn = conexao.abre();
        if (conn != null) {
            PiadaDAL piadaDAO = new PiadaDAL();
            p = piadaDAO.buscaRand(conn);
        }

        return p;
    }

    public List<Piada> buscaPiada(int idCategoria, int idFaixaEtaria, String palavra) {
        Conec_MySQL conexao = new Conec_MySQL();
        List<Piada> piadas = new ArrayList<>();
        Connection conn = conexao.abre();

        PiadaDAL piadaDAO = new PiadaDAL();
        //if(idCategoria != -1 && idFaixaEtaria!=-1 && !palavra.equals(""))
        if (conn != null) 
            piadas = piadaDAO.busca(conn, idCategoria, idFaixaEtaria, palavra);
        //else{
        //    if()
        //    piadas = null;
        //}

        return piadas;
    }
}
