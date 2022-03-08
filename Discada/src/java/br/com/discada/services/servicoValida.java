
package br.com.discada.services;

import br.com.discada.model.DAO.ClienteDao;
import br.com.discada.model.jpa.Clientes;
import br.com.discada.model.jpa.Segredo;
import java.util.List;
import javax.ejb.EJB;

public class servicoValida {
    
   /* @EJB
    private ClienteDao cliDao;*/
    
    private String mensagemValida;
   
    
    
    public servicoValida () {}
    
    
// Método para verificação da senha forte
// ---------------------------------------------------------------------------->    
    public boolean validaSenha (String login, String senha, String senhaDois){
    
        boolean pegouNumero = false;
        boolean pegouMaiscula = false;
        boolean pegouMinuscula = false;
        boolean pegouSimbolo = false;
        
        String acesso = login;
        String entradaUm = senha;
        String entradaDois = senhaDois;
        
        if (entradaUm.equals(entradaDois)) {
            // se senhas iguais condicionar a senhas fortes                    
            if (entradaUm.length() > 6){                    
                                        
                for(char s : entradaUm.toCharArray()){
                    // crio array de char para analisar os critérios de forma individual a senha
        
                    if (s >= '0' && s <= '9'){
                        pegouNumero = true; // critério de números
                    } else if (s >= 'A' && s <= 'Z'){
                        pegouMaiscula = true; // citério de maiúscula
                    } else if (s >= 'a' && s <= 'z') {
                        pegouMinuscula = true; // critério de minúscula
                     } else {
                        pegouSimbolo = true;
                        }
                }
                
                    if(pegouNumero == true && pegouMaiscula == true && pegouMinuscula == true 
                         && pegouSimbolo == true){
                         
                        this.mensagemValida = "A senha cumpre com os requisitos";
                        return true;
                     
            
                     
                    } else { this.mensagemValida = " sua senha precisa ter "
                        + "maíscula (A,B,C...), minúscula(a,b,c...), caracter especial(%,@...), número "
                        + "e no mínimo 6 caratecteres";
                        return false;
                      }
                    
               } else { this.mensagemValida = " sua senha precisa ter"
                   + " 6 caratecteres";
                   return false;
                 }
                
            } else {this.mensagemValida = " as senhas devem ser iguais!";
                return false;
              }
    }
    
// Fim do Método de validação de senha forte ---------------------------------->
    

    // Método para validar acesso no sistema
// ---------------------------------------------------------------------------->
    
    public int validaAcesso (String login, String senha, List<Segredo> lista){
    
        int idclit = 0;        
        for ( Segredo vam : lista ){

                if(vam != null && vam.getSecsenha().equals(senha) && vam.getSeclogin().equals(login))
                {
                    int idse = vam.getSecid();                    
                    
                    ClienteDao cli = new ClienteDao();
                    List<Clientes> c = cli.pegarClienteSegredo(1);

                        if(c != null && !c.isEmpty() && !c.equals("")) {

                            for (Clientes vem : c){

                                idclit = vem.getCliid();                               
                               
                            }
                        }                     
                }
        }
        
        return idclit;
    }
    
// ---------------------------------------------------------------------------->    
// métodos de acesso aqui ----------------------------------------------------->

    public String getMensagemValida() {
        return mensagemValida;
    }

// Fim dos métodos de acesso -------------------------------------------------->
    

    
    
    
} // fechamento da classe
