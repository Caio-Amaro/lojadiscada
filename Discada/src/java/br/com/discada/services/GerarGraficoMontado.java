package br.com.discada.services;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GerarGraficoMontado implements Serializable {
    
    private static final long serialVersionUID = 1L;       
    
    //private String nome;
    private int valor;
    private int valor2;
    private int dias; 
    
    
    public GerarGraficoMontado(int dias, int valor, int valor2){
    
        this.valor = valor;
        this.valor2 = valor2;
        this.dias = dias;
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

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

   /* public String getName() {
        return nome;
    }

    public void setName(String name) {
        this.nome = name;
    }*/

    public int getValor2() {
        return valor2;
    }

    public void setValor2(int valor2) {
        this.valor2 = valor2;
    }
    
    
    
}
