/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

/**
 *
 * @author mayor
 */
public class Mesa {
    private double valor;
    private int quantidade;
    private int percentual;
    
    public Mesa() {
       
    }
    
    public void setValor(double valor){
        this.valor=valor;
    }
    
    public double getValor(){
        return this.valor;
    }
    
    public void setQuantidade(int quantidade){
        this.quantidade = quantidade;
    }   
    
   public int getQuantidade(){
       return this.quantidade;
   } 
   
   public void setPercentual(int percentual){
       this.percentual = percentual;
   }
   
   public int getPercentual(){
       return this.percentual;
   }
   
   public double getValorTotal(){
       return this.getValor() + (this.getValor() * this.getPercentual())/100;
   }

   public double getValorPorPessoa(){
        return this.getValorTotal()/this.getQuantidade();
     }    

}