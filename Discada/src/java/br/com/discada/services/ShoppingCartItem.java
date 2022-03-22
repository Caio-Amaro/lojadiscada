
package br.com.discada.services;

import br.com.discada.model.jpa.Produto;


public class ShoppingCartItem {
    
    private Produto produto;
    private int quantity = 1;    
    //private double total;
   
    
    public ShoppingCartItem(){}
    
    public ShoppingCartItem (Produto produto)
    {
        this.produto = produto;
        int quantity;
        
    }

    
    public Produto getProduto() {
        return produto;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public void incrementyQuantity()
    {
        quantity++;
    }
    
    public void decrementQuantity()
    {
        quantity--;
    }
    
    public double getTotal()
    {
        double total = 0;
        total = (this.getQuantity() * produto.getPropreco());
        return total;
    }

   

  
    
    
    
}
