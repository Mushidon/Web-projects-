/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import Persistência.FormularioSQLDAO;
import java.io.Serializable;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import modelo.Formulario;

/**
 *
 * @author Aluno
 */
@Named(value = "formularioBean")
@RequestScoped
public class FormularioBean implements Serializable {

    private Formulario formulario;

    public FormularioBean() {
        this.formulario = new Formulario();
    }

    public Formulario getFormulario() {
        return this.formulario;
    }

    public void save() throws SQLException, ClassNotFoundException, Exception {
        new FormularioSQLDAO().save(this.getFormulario());
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Dados salvos com sucesso"));
    }
    
      public void buscarData() throws SQLException, ClassNotFoundException, Exception {
        FormularioSQLDAO formularioDAO = new FormularioSQLDAO();
        Formulario formularioEncontrado = formularioDAO.buscarByRemetente(this.formulario.getRemetente());
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Seu registro foi encontrado e a data é:" + sdf.format(formularioEncontrado.getData())));
    }
    
    public void exibirData(){
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Data de envio do email:" + sdf.format(this.getFormulario().getData())));
    }
}
