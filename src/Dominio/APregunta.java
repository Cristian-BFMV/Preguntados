/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import java.util.ArrayList;

/**
 *
 * @author cristian
 */
public abstract class APregunta {
    private String enunciado;
    private String [] opciones;
    private String opcionCorrecta;
    
    public APregunta(String enunciado, String [] opciones, String opcionCorrecta){
        this.enunciado = enunciado;
        this.opcionCorrecta = opcionCorrecta;
        this.opciones = opciones;
    }

    public APregunta() {
    }
    
    public abstract void crearRegistrarPregunta();
    public abstract ArrayList<String> recuperarPreguntas();

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public String[] getOpciones() {
        return opciones;
    }

    public void setOpciones(String[] opciones) {
        this.opciones = opciones;
    }

    public String getOpcionCorrecta() {
        return opcionCorrecta;
    }

    public void setOpcionCorrecta(String opcionCorrecta) {
        this.opcionCorrecta = opcionCorrecta;
    }
    
    
}
