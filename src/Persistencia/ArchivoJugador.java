/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author cristian
 */
public class ArchivoJugador implements Archivo {

    private File fileJugador;
    private FileWriter writerJugador;
    private BufferedWriter bufferJugador;
    private PrintWriter printJugador;
    private FileReader readerJugador;
    private BufferedReader bufferReadJugador;
    private  static ArchivoJugador aj;

    private ArchivoJugador() {
        fileJugador = new File("jugador.txt");
    }
    
    public static ArchivoJugador getInstance(){
        if(aj==null){
            aj = new ArchivoJugador();
        }
        return aj;
    }

    @Override
    public void registrarObjeto(String jugador) {
        if (!fileJugador.exists()) {
            try {
                fileJugador.createNewFile();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Ha salido algo mal, lo sentimos");
            }
        }
        try {
            writerJugador = new FileWriter(fileJugador, true);
            bufferJugador = new BufferedWriter(writerJugador);
            printJugador = new PrintWriter(bufferJugador);
            printJugador.println(jugador);
            cerrarArchivo();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Ha salido algo mal, lo sentimos");
        }
    }

    @Override
    public ArrayList<String> extraerObjeto() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void cerrarArchivo() {
        try {
            writerJugador.flush();
            bufferJugador.flush();
            printJugador.flush();
            writerJugador.close();
            bufferJugador.close();
            printJugador.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Ha salido algo mal, lo sentimos");
        }
    }

    @Override
    public boolean verificarUnicidad(String nick) {
        String aux;
        //Si no se ha creado el archivo, significa que no hay jugadores registrados
        if (!fileJugador.exists()) {
            return true;
        } else {
            try {                
                readerJugador = new FileReader(fileJugador);
                bufferReadJugador = new BufferedReader(readerJugador);
                while((aux=bufferReadJugador.readLine())!=null){
                   //Si el nick enviado como parametro coincide con el primer String en el archivo, el jugador ya está registrado
                    if(nick.equalsIgnoreCase(aux.substring(0, aux.indexOf(",")))){
                        return false;
                    }
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Ha salido algo mal, lo sentimos");
            }
        }
        return true;
    }

    @Override
    public boolean verificarLogin(String nick, String pass) {        
        String aux;
        if (!fileJugador.exists()) {
            JOptionPane.showMessageDialog(null, "No se ha encontrado el archivo, lo sentimos");
        } else {
            try {
                readerJugador = new FileReader(fileJugador);
                bufferReadJugador = new BufferedReader(readerJugador);
                while((aux=bufferReadJugador.readLine())!=null){
                    if(nick.equalsIgnoreCase(aux.substring(0, aux.indexOf(","))) && pass.equalsIgnoreCase(aux.substring(aux.indexOf(",")+1))){
                        return true;
                    }
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Ha salido algo mal, lo sentimos");
            }
        }
        return false;
    }        
}
