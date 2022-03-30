
package br.com.discada.services;

public class controleCupom {
    
    public double somaCupomTroca;    
    public String mensagemCupom;
    double calculoTotalCupom;
    
    public double somaCupomTroca (String[] cupons) {
        
        
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
   
   public double valorTotalCupom (double somaTroca, double desconto, double somaCompra) {
   
    double aux = somaCompra * (desconto/100);    
    this.calculoTotalCupom = somaCompra - aux;
    this.calculoTotalCupom = this.calculoTotalCupom - somaTroca;
   
   return this.calculoTotalCupom;
   }
}
