/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import negocio.Mesa;

/**
 *
 * @author mayor
 */

@Named(value = "mesaBean")
@RequestScoped
public class MesaControllerBean {
    private Mesa mesa;
    
    public MesaControllerBean(){
        this.mesa = new Mesa(); 
    }
    
    public Mesa getMesa(){
        return this.mesa;
    }
    
    public void calcularValorTotal(){
        FacesContext context = FacesContext.getCurrentInstance(); 
        context.addMessage(null, new FacesMessage("O valor total com gorjeta é:" + this.getMesa().getValorTotal()));
    }
    
    public void calcularValorPorPessoa(){
        FacesContext context = FacesContext.getCurrentInstance(); 
        context.addMessage(null, new FacesMessage("O valor por pessoa com gorjeta é:" + this.getMesa().getValorPorPessoa()));
    }
}
