/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

/**
 *
 * @author HIEU
 */
public class Controller {
    private DAO dao;
    
    public Controller() {
        dao = new DAO();
    }
    
    public boolean checkLogin(String username, String password) {
        return dao.checkLogin(username, password);
    }
}
