/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import negocio.Usuario;

/**
 *
 * @author mayor
 */
@Named(value = "imcBean")
@RequestScoped
public class IMCControllerBean implements Serializable {
    private Usuario usuario;
        public IMCControllerBean(){
            this.usuario = new Usuario(); 
        }
        
        public Usuario getUsuario(){
            return usuario;
        }
        
        public void calcularIMCTradicional(){
        
        
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null,new FacesMessage("CalculoIMC", "O seu IMC é:" + this.getUsuario().calculateIMC())); 
          
            
   
    }
        
}
