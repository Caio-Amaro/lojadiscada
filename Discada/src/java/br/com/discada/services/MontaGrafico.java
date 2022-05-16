
package br.com.discada.services;

import br.com.discada.controller.ControleServletPainel;
import br.com.discada.model.jpa.Itempedido;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
