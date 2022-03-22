
package br.com.discada.services;


import br.com.discada.controller.ControleServlet;
import br.com.discada.model.DAO.ItemPedidoDao;
import br.com.discada.model.jpa.Cartaocredi;
import br.com.discada.model.jpa.Clientes;
import br.com.discada.model.jpa.Endereco;
import br.com.discada.model.jpa.Itempedido;
import br.com.discada.model.jpa.Pedido;
import br.com.discada.model.jpa.Produto;
import br.com.discada.model.jpa.Tipostatus;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

public class ShoppingCart {
   
    
    public List<ShoppingCartItem> items;
    int numberOfItems;
    double subtotal;
    double total;
    
    @EJB
    private ItemPedidoDao itiDao;
    
    
    public ShoppingCart()
    {
        this.items = new ArrayList<ShoppingCartItem>();
        numberOfItems = 0;
        subtotal = 0.0;
        
    }
    
    public synchronized void addItem(Produto produto) 
    {
        boolean newItem = true;
        
        for (ShoppingCartItem scItem : items) {
        
            if(scItem.getProduto().getProid() == produto.getProid()) {
                newItem = false;
                scItem.incrementyQuantity();
            }
        
        }
        
        if(newItem){
            ShoppingCartItem scItem = new ShoppingCartItem(produto);
            items.add(scItem);
        }
        
        numberOfItems++;
        subtotal += produto.getPropreco();
    
    }
    
    
     public synchronized void update(Produto produto, String quantity)
     {
         int qty = -1;
         
         qty = Integer.parseInt(quantity);
         
         if(qty >= 0)
         {
             ShoppingCartItem item = null;
             
             for(ShoppingCartItem scItem : items)
             {
               
                 if(scItem.getProduto().getProid().intValue() == produto.getProid().intValue());
                 {
                     numberOfItems += (qty - scItem.getQuantity());
                     subtotal += (qty - scItem.getQuantity()) * produto.getPropreco();
                     if (qty > 0) 
                     {
                         scItem.setQuantity(qty);
                         
                     } else 
                     {
                         item = scItem;
                         break;
                     }
                     
                 }
             
                }
             
             if(item != null) 
             {
                 items.remove(item);
             }
         }
    
     } 
     
     public synchronized List<ShoppingCartItem> getItems()
     {
         return items;
         
     }
     
     public synchronized int getnumberOfItems()
     {
         numberOfItems = 0;
         
         for(ShoppingCartItem scItem : items)
         {
             numberOfItems += scItem.getQuantity();
         }
         
         return numberOfItems;
     }
     
     
     public synchronized double getSubtotal()
     {
         double value = 0;
         
         for(ShoppingCartItem scItem : items)
         {
             Produto produto =(Produto)scItem.getProduto();
             value += (scItem.getQuantity() * produto.getPropreco());
         }
         
         return value;
     
     }
     
     public synchronized void calculateTotal()
     {
         double value = 0;
         double aux = 20.50;
         
         value = this.getSubtotal();
         value += aux;
         
         subtotal = value;
   
     }
     
     public synchronized double getTotal() 
     {
         return total;
     }
     
     /*public synchronized void getTotal() 
     {
         String surcharge = "0.00";
         total = subtotal  + Double.parseDouble(surcharge) * this.numberOfItems;
     }*/
     
     public synchronized void clear() 
     {
         items.clear();
         numberOfItems = 0;
         subtotal = 0;
     
     }
     
    public void pedido (String idpedido,String idproduto, String propreco, String quantidade, String valorTotal)
    {
            ShoppingCart item = new ShoppingCart();
        
            Pedido pedid = new Pedido();
            Clientes cl = new Clientes();
            Endereco en = new Endereco();
            Tipostatus ti = new Tipostatus();
            Cartaocredi cr = new Cartaocredi();
            Produto produto = new Produto();
            Itempedido pedido = new Itempedido();
            
        
         for(ShoppingCartItem ite : items)
        {
            
            pedid.setIdpedido(Integer.parseInt(idpedido));
            produto.setProid(Integer.parseInt(idproduto));
            double preco = Double.parseDouble(propreco);
            int quant = Integer.parseInt(quantidade);
            Double vlrt = Double.parseDouble(valorTotal);
            
            pedido.setIdped(pedid);
            pedido.setIdpro(produto);
            pedido.setIdstatus(ti);
            pedido.setValoritem(preco);
            pedido.setQuantidade(quant);
            pedido.setValortotalitem(vlrt);
            
                try {
                    itiDao.persist(pedido);
                    
                } catch (Exception ex) {
                    Logger.getLogger(ControleServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
            
            
            }
  
    
    }
 
    
}
