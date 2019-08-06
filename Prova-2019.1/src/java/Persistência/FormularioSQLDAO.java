/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistência;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.text.ParseException;
import modelo.Formulario;

/**
 *
 * @author Aluno
 * 
 *create table formulario (
	destinatario varchar(255),
	telefaxDestinatario varchar(255),
	emailDestinatario varchar(255),
	remetente varchar(255),
	remetenteTelefax varchar(255),
	remetenteEmail varchar(255),
	data date
); 
 * 
 */
public class FormularioSQLDAO {

    private static final String DRIVER_NAME = "org.hsqldb.jdbcDriver";
    private static final String DB_URI = "jdbc:hsqldb:hsql://localhost/";
    private static final String DB_USER = "SA";
    private static final String DB_PWD = "";
    private static final String INSERIR = "INSERT INTO formulario(destinatario,telefaxDestinatario,emailDestinatario,remetente,remetenteTelefax,remetenteEmail,data) VALUES(?,?,?,?,?,?,?)";
    private static final String BUSCAR = "SELECT* FROM formulario where remetente = ?";
    
    public FormularioSQLDAO() throws SQLException, ClassNotFoundException {
        Class.forName(FormularioSQLDAO.DRIVER_NAME);
    }

    ;
			
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(FormularioSQLDAO.DB_URI,
                FormularioSQLDAO.DB_USER, FormularioSQLDAO.DB_PWD);
    }

    ;
    
    public void save(Formulario formulario) throws Exception {
        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
       
        java.util.Date dataConvertida = sdf.parse(sdf.format(formulario.getData()));
        java.sql.Date sql = new java.sql.Date(dataConvertida.getTime());
        
        PreparedStatement stmt = this.getConnection().prepareStatement(FormularioSQLDAO.INSERIR);

        stmt.setString(1, formulario.getDestinatario());
        stmt.setString(2, formulario.getTelefaxDestinatario());
        stmt.setString(3, formulario.getEmailDestinatario());
        stmt.setString(4, formulario.getRemetente());
        stmt.setString(5, formulario.getTelefaxRemetente());
        stmt.setString(6, formulario.getEmailRemetente());
        stmt.setDate(7, sql);
        stmt.execute();
        stmt.close();

    }
    
    public Formulario buscarByRemetente(String remetente) throws SQLException, ParseException{
        PreparedStatement stmt = this.getConnection().prepareStatement(FormularioSQLDAO.BUSCAR);
        stmt.setString(1, remetente);
        ResultSet rSet = stmt.executeQuery();
        Formulario formulario = new Formulario();
            while( rSet.next() ) {
               formulario.setDestinatario(rSet.getString("destinatario")); 
               formulario.setTelefaxDestinatario(rSet.getString("telefaxDestinatario")); 
               formulario.setEmailDestinatario(rSet.getString("emailDestinatario"));
               formulario.setRemetente(rSet.getString("remetente")); 
               formulario.setTelefaxRemetente(rSet.getString("remetenteTelefax")); 
               formulario.setEmailRemetente(rSet.getString("remetenteEmail")); 
               formulario.setData(rSet.getDate("data"));
            }
            
        return formulario;
    }

}
