/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidade;

/**
 *
 * @author Aluno
 */
public class FaixaEtaria {
    private int id;
    private String descricao;

    public FaixaEtaria(int id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }
    
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "FaixaEtaria{" + "id=" + id + ", descricao=" + descricao + '}';
    }

    
    
    
}
