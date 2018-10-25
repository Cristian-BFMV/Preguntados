/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

/**
 *
 * @author cristian
 */
public abstract class AJugador {
    private String nick;
    private String pass;
    
    public AJugador (String nick, String pass){
        this.nick = nick;
        this.pass = pass;
    }

    public AJugador() {
    }
    
    public abstract boolean verificarRegistro(String nick);
    public abstract void registrarJugador();
    public abstract boolean verificarLogin(String nick, String pass);

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
