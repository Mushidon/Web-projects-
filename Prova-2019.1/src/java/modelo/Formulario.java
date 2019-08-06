/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author Aluno
 */
public class Formulario {

    public String destinatario;
    public String telefaxDestinatario;
    public String emailDestinatario;
    public String remetente;
    public String telefaxRemetente;
    public String emailRemetente;
    public Date data;

    public Formulario() {

    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public void setTelefaxDestinatario(String telefax) {
        this.telefaxDestinatario = telefax;
    }

    public void setEmailDestinatario(String email) {
        this.emailDestinatario = email;
    }

    public void setRemetente(String remetente) {
        this.remetente = remetente;
    }

    public void setEmailRemetente(String email) {
        this.emailRemetente = email;
    }

    public void setTelefaxRemetente(String telefax) {
        this.telefaxRemetente = telefax;
    }

    public void setData(Date data) throws ParseException {
       
        this.data = data;
 
    }

    public String getDestinatario() {
        return this.destinatario;
    }

    public String getTelefaxDestinatario() {
        return this.telefaxDestinatario;
    }

    public String getEmailDestinatario() {
        return this.emailDestinatario;
    }

    public String getRemetente() {
        return this.remetente;
    }

    public String getTelefaxRemetente() {
        return this.telefaxRemetente;
    }

    public String getEmailRemetente() {
        return this.emailRemetente;
    }

    public Date getData() {
        return this.data;
    }
}
