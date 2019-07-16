/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistência;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author Victor Hugo
 * SQL DA TABELA
				  	
					create table Login (	
					
                                            usuario VARCHAR(50),		
						
						
					);
	 
 */
public class LoginSQLDAO implements SQLDAO {
    
    private static final String DRIVER_NAME = "org.hsqldb.jdbcDriver";
    private static final String DB_URI = "jdbc:hsqldb:hsql://localhost/";
    private static final String DB_USER = "SA";
    private static final String DB_PWD = "";
    private static final String INSERIR = "INSERT INTO Login(usuario) VALUES(?)";
    private static final String BUSCAR = "SELECT* FROM Login WHERE usuario = (?)";
                        
                        
    public LoginSQLDAO() throws SQLException, ClassNotFoundException {
	Class.forName(LoginSQLDAO.DRIVER_NAME);
	};
			
    private Connection getConnection() throws SQLException {
	return DriverManager.getConnection(LoginSQLDAO.DB_URI, 
		LoginSQLDAO.DB_USER, LoginSQLDAO.DB_PWD);
	};

    
    public void inserir(String login) throws Exception {
      PreparedStatement stmt = this.getConnection().prepareStatement(LoginSQLDAO.INSERIR);
      stmt.setString(1, login);			
      stmt.execute();
      stmt.close();
    }

   
    public String buscar(String login) throws Exception {
        PreparedStatement stmt = this.getConnection().prepareStatement(LoginSQLDAO.BUSCAR);
	stmt.setString(1, login);
	stmt.execute();
	ResultSet rSet = stmt.executeQuery();
        String usuario = rSet.getString("usuario");
        if(usuario!=null)
            return "Login feito com sucesso";
        return "Usuario não encontrado";
        
    }
			
}