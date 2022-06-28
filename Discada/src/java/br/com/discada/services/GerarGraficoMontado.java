package br.com.discada.services;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GerarGraficoMontado implements Serializable {
    
    private static final long serialVersionUID = 1L;       
    
    //private String nome;
    private String nome;
    private int valor;
    
    
    
    
    public GerarGraficoMontado(String nome, int valor){
        
        this.nome = nome;
        this.valor = valor;
    
        
        //this.nome = nome;
        
    }
    
    public GerarGraficoMontado(){}

    /*public GerarGraficoMontado(GerarGraficoMontado entra, GerarGraficoMontado entra0, GerarGraficoMontado entra1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/

    // ---------------------------------------------------------------
    
    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

   
    
    
}
