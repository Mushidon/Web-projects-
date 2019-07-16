/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

import java.io.IOException;
import java.sql.SQLException;
import persistência.LoginSQLDAO;

/**
 *
 * @author mayor
 */
public class Session {
      
    private LoginSQLDAO loginSQLDAO;
	
	public Session() throws ClassNotFoundException, IOException, SQLException {
		this.loginSQLDAO= new LoginSQLDAO();
	}
        
    public String getLogin (String login) throws SQLException, Exception {
		return this.loginSQLDAO.buscar(login);
				
	}
}
