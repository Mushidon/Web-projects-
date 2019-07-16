/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistência;

/**
 *
 * @author mayor
 */
public interface SQLDAO {
    
    public void inserir(String login) throws Exception;
    public String buscar(String login) throws Exception;
    
}
