
package br.com.discada.services;

import br.com.discada.model.DAO.CupomDao;
import br.com.discada.model.jpa.Cupom;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;

public class controleCupom {
    
    public double somaCupomTroca;    
    public String mensagemCupom;
    double calculoTotalCupom;
    private double valorApenasCupom;
    @EJB
    private CupomDao cupDao;
    private int enderecoNum;
    
    public double somaCupomTroca (String[] cupons){
        
        
        if(cupons != null) {
            for (String cup : cupons)
            {
               double aux = Double.parseDouble(cup);
               somaCupomTroca = aux + somaCupomTroca;                
            }
            this.mensagemCupom = "Aplicado R$ " + somaCupomTroca + "em cupom de troca";
        }   else {
                this.mensagemCupom = "Nenhum cupom de troca utilizado";
            };
            
        return this.somaCupomTroca;
    
   }
    
   public void excluiCupom (Cupom cupomid) {}
   
   public double valorTotalCupom (double somaTroca, double desconto, double somaCompra) {
   
    double aux = somaCompra * (desconto/100);    
    this.calculoTotalCupom = somaCompra - aux;
    this.valorApenasCupom = this.calculoTotalCupom;
    this.calculoTotalCupom = this.calculoTotalCupom - somaTroca;
    
   return this.calculoTotalCupom;
   }

    public double getValorApenasCupom() {
        return valorApenasCupom;
    }

    public int getEnderecoNum() {
        return enderecoNum;
    }

    public void setEnderecoNum(int enderecoNum) {
        this.enderecoNum = enderecoNum;
    }
    
    
   
   
}
