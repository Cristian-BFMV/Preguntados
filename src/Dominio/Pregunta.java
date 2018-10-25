/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import Persistencia.Archivo;
import Persistencia.ArchivoPregunta;
import java.util.ArrayList;

/**
 *
 * @author cristian
 */
public class Pregunta extends APregunta{
    
    private Archivo ar;
    
    public Pregunta(String enunciado, String opcionCorrecta, String [] opciones){
        super(enunciado, opciones, opcionCorrecta);
    }

    public Pregunta() {
    }

    @Override
    public void crearRegistrarPregunta() {
        ar.registrarObjeto(this.toString());
    }

    @Override
    public ArrayList<String> recuperarPreguntas() {
        ArrayList<String> aux;
        ar = ArchivoPregunta.getInstance(); 
        aux = ar.extraerObjeto();
        return aux;
    }       
    
    @Override
    public String toString(){
        String aux="";
        for (String opcion : super.getOpciones()) {
            aux = aux.concat(opcion);            
        }
        return super.getEnunciado()+","+aux+","+super.getOpcionCorrecta();
    }
}
