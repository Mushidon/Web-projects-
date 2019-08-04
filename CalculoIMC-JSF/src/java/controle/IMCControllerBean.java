/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.io.Serializable;
import java.sql.SQLException;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import negocio.Usuario;
import persistencia.ImcSQLDAO;

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
            context.addMessage(null,new FacesMessage( this.getUsuario().calculateIMCTradicional())); 
        }
        
        public void calcularIMCOxford(){
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(this.getUsuario().calculateIMCOxford()));
        }
        
        public void calcularIMCHilderburg(){
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(this.getUsuario().calculateIMCHilderburg()));
        }
        
        public void salvarIMC()  throws SQLException, ClassNotFoundException, Exception{
            new ImcSQLDAO().inserir(this.getUsuario());
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("IMC Salvo com sucesso"));
        }
}
