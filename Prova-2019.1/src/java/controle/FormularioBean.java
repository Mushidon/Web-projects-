/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import Persistência.FormularioSQLDAO;
import java.io.Serializable;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import modelo.Formulario;

/**
 *
 * @author Aluno
 */
@ManagedBean(name = "formularioBean")
@SessionScoped
public class FormularioBean implements Serializable {

    private Formulario formulario;
    private List<Formulario> formularios;
    private Formulario formularioSelecionado;

    public FormularioBean() {
        this.formulario = new Formulario();

    }

    public Formulario getFormulario() {
        return this.formulario;
    }

    public Formulario getFormularioSelecionado() {
        return formularioSelecionado;
    }

    public void setFormularioSelecionado(Formulario formulario) {
        this.formularioSelecionado = formulario;
    }

    public List<Formulario> getFormularios() throws SQLException, ClassNotFoundException, ParseException {
        formularios = new ArrayList<Formulario>();
        this.formularios = new FormularioSQLDAO().findAll();
        return formularios;
    }

    public void enviar() throws SQLException, ClassNotFoundException, Exception {
        FormularioSQLDAO banco = this.getBanco();
        banco.save(this.getFormulario());
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Dados salvos com sucesso"));
    }

    public void remover() throws SQLException, ClassNotFoundException, Exception {
        FormularioSQLDAO banco = this.getBanco();
        banco.delete(this.formularioSelecionado.remetente);
        formularios.remove(this.formularioSelecionado);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Item removido"));
    }

    public void alterar() throws SQLException, ClassNotFoundException, Exception {
        FormularioSQLDAO banco = this.getBanco();
        banco.update(this.getFormulario());
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Dados alterados com sucesso"));
    }

    public String formatador(Date data) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        return sdf.format(data);

    }

    public FormularioSQLDAO getBanco() throws SQLException, ClassNotFoundException {
        return new FormularioSQLDAO();
    }
}
