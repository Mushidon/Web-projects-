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
public class Usuario {
    

    private double peso;
    private double altura;
    
        public Usuario(){
            
        }
    
        
    public void setPeso(double peso){
            this.peso = peso;
    }
    
    public void setAltura(double altura){
        this.altura = altura;
    }
    
    public double getPeso(){
        return this.peso;
    }
    
    public double getAltura(){
        return this.altura;
    }
 
    public String calculateIMC(){
        double IMC = this.getPeso() / Math.pow(this.altura, 2);
       
               return "O seu IMC é: " + String.format("%.2f",IMC)+ ", " + this.avaliação(IMC);
            
   
    }
      
      public String avaliação(double IMC){
        if(IMC<=25)
            return "seu peso está Normal";
        
        else if (IMC>=30) 
            return "Você está obeso";
        
        else 
            return "você está com sobrepeso";
        
      }
    
}

