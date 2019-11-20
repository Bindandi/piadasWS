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
public class Piada {
    private int id;
    private String titulo;
    private Categoria categoria;
    private FaixaEtaria faixaEtaria;
    private String conteudo;
    private String imagem;

    public Piada() {
    }
    
    

    public Piada(int id, String titulo, Categoria categoria, FaixaEtaria faixaEtaria, String conteudo, String imagem) {
        this.id = id;
        this.titulo = titulo;
        this.categoria = categoria;
        this.faixaEtaria = faixaEtaria;
        this.conteudo = conteudo;
        setImagem(imagem);
        
    }
    
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public FaixaEtaria getFaixaEtaria() {
        return faixaEtaria;
    }

    public void setFaixaEtaria(FaixaEtaria faixaEtaria) {
        this.faixaEtaria = faixaEtaria;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        if(imagem == null)
            this.imagem = "";
        else
            this.imagem = imagem;
    }

    @Override
    public String toString() {
        return "Piada{" + "id=" + id + ", titulo=" + titulo + ", categoria=" + categoria + ", faixaEtaria=" + faixaEtaria + ", conteudo=" + conteudo + ", imagem=" + imagem + '}';
    }
    
    
    
    
}
