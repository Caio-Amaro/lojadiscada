
package br.com.discada.services;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MontaGrafico implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private List somqtd = new ArrayList<>();
    private List somvlr = new ArrayList<>();
    private List nomepr = new ArrayList<>();

    public List getSomqtd() {
        return somqtd;
    }

    public void setSomqtd(List somqtd) {
        this.somqtd = somqtd;
    }

    public List getSomvlr() {
        return somvlr;
    }

    public void setSomvlr(List somvlr) {
        this.somvlr = somvlr;
    }

    public List getNomepr() {
        return nomepr;
    }

    public void setNomepr(List nomepr) {
        this.nomepr = nomepr;
    }
    
    
    
}
