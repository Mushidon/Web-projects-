/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import negocio.Usuario;

/**
 *
 * @author mayor
 */
public interface ImcDAO {
    public void inserir (Usuario usuario) throws Exception; 
}
