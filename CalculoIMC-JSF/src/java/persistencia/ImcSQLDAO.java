/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import negocio.Usuario;

/**
 *
 * @author mayor
 */
public class ImcSQLDAO implements ImcDAO {

    private static final String DRIVER_NAME = "org.hsqldb.jdbcDriver";
    private static final String DB_URI = "jdbc:hsqldb:hsql://localhost/";
    private static final String DB_USER = "SA";
    private static final String DB_PWD = "";
    private static final String INSERIR = "INSERT INTO IMC(PESO) VALUES(?)";

    public ImcSQLDAO() throws SQLException, ClassNotFoundException {
        Class.forName(ImcSQLDAO.DRIVER_NAME);
    };
			
private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(ImcSQLDAO.DB_URI,
                ImcSQLDAO.DB_USER, ImcSQLDAO.DB_PWD);
    };

public void inserir(Usuario usuario) throws Exception {
        PreparedStatement stmt = this.getConnection().prepareStatement(ImcSQLDAO.INSERIR);

        stmt.setDouble(1, usuario.getIMCTradicional());

        stmt.execute();
        stmt.close();
    
    }
}
