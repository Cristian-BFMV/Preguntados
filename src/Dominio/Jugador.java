/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/*To do:
1-Completar la persistencia de jugadores, esto es, verificar el login(Done), la unicidad para el registro está hecha, el registro en el archivo también
2-Hacer litelarmente todo en la vista, no es necesario(me lo parece) colocar una capa para los controladores
3-Completar todo lo relacionado con las preguntas, cosas como: en la clases hacer los llamados respectivos en lo relacionado con persistencia. Nota: persistencia lista, solo faltan las pruebas.
*/
/*
*/
package Dominio;

import Persistencia.Archivo;
import Persistencia.ArchivoJugador;

/**
 *
 * @author cristian
 */
public class Jugador extends AJugador{
        private Archivo ar;
    
    public Jugador(String nick, String pass) {
       super(nick, pass);
    }

    public Jugador() {
    }

    @Override
    public void registrarJugador() {
        ar = ArchivoJugador.getInstance();
        ar.registrarObjeto(this.toString());        
    }
    
    @Override
    public String toString(){
        return super.getNick()+","+super.getPass();
    }
    
    @Override
    public boolean verificarLogin(String nick, String pass) {
        ar = ArchivoJugador.getInstance();
        return ar.verificarLogin(nick, pass);
    }    

    @Override
    public boolean verificarRegistro(String nick) {
        ar = ArchivoJugador.getInstance();
        return ar.verificarUnicidad(nick);
    }
}
