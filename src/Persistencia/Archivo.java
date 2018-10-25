/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import java.util.ArrayList;

/**
 *
 * @author cristian
 */
public interface Archivo {
    //Objeto se refiere a la hilera a escribir en el archivo
    public void registrarObjeto(String objeto);        
    public ArrayList<String> extraerObjeto();
    public void cerrarArchivo();
    public boolean verificarUnicidad(String nick);
    public boolean verificarLogin(String nick, String pass);
    
}
