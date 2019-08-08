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
import java.sql.Date;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import modelo.Formulario;

/**
 *
 * @author Aluno
 *
 * create table formulario ( destinatario varchar(255), telefaxDestinatario
 * varchar(255), emailDestinatario varchar(255), remetente varchar(255),
 * remetenteTelefax varchar(255), remetenteEmail varchar(255), data date );
 *
 */
public class FormularioSQLDAO {

    private static final String DRIVER_NAME = "org.hsqldb.jdbcDriver";
    private static final String DB_URI = "jdbc:hsqldb:hsql://localhost/";
    private static final String DB_USER = "SA";
    private static final String DB_PWD = "";
    private static final String INSERIR = "INSERT INTO formulario(destinatario,telefaxDestinatario,emailDestinatario,remetente,remetenteTelefax,remetenteEmail,data) VALUES(?,?,?,?,?,?,?)";
    private static final String BUSCAR = "SELECT* FROM formulario";
    private static final String DELETAR = "DELETE FROM formulario WHERE remetente = ? ";
    private static final String UPDATE = "UPDATE formulario SET destinatario = ? WHERE remetente = ?";

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

        java.sql.Date sql = new java.sql.Date(formulario.getData().getTime());

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

    ;
    
        public List<Formulario> findAll() throws SQLException, ParseException {

        PreparedStatement stmt = this.getConnection().prepareStatement(FormularioSQLDAO.BUSCAR);
        stmt.execute();
        ResultSet rSet = stmt.executeQuery();
        List<Formulario> formularios = new ArrayList<Formulario>();

        while (rSet.next()) {
            Formulario formularioEncontrado = new Formulario();
            formularioEncontrado.setDestinatario(rSet.getString("destinatario"));
            formularioEncontrado.setTelefaxDestinatario(rSet.getString("telefaxDestinatario"));
            formularioEncontrado.setEmailDestinatario(rSet.getString("emailDestinatario"));
            formularioEncontrado.setRemetente(rSet.getString("remetente"));
            formularioEncontrado.setTelefaxRemetente(rSet.getString("remetenteTelefax"));
            formularioEncontrado.setEmailRemetente(rSet.getString("remetenteEmail"));
            formularioEncontrado.setData(rSet.getDate("data"));

            formularios.add(formularioEncontrado);

        }

        stmt.close();

        return formularios;
    }

    public void delete(String remetente) throws Exception {

        PreparedStatement stmt = this.getConnection().prepareStatement(FormularioSQLDAO.DELETAR);
        stmt.setString(1, remetente);
        stmt.execute();
        stmt.close();

    }

    ;

        public void update(Formulario formulario) throws SQLException {

        java.sql.Date sql = new java.sql.Date(formulario.getData().getTime());
        PreparedStatement stmt = this.getConnection().prepareStatement(FormularioSQLDAO.UPDATE);

        stmt.setString(1, formulario.getDestinatario());
        stmt.setString(2, formulario.getRemetente());
        stmt.executeUpdate();
        stmt.close();

    }

}
