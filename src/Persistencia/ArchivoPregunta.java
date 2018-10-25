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
public class ArchivoPregunta implements Archivo {

    private File filePregunta;
    private FileWriter writerPregunta;
    private BufferedWriter bufferPregunta;
    private PrintWriter printPregunta;
    private FileReader readerPregunta;
    private BufferedReader bufferReadPregunta;
    private static ArchivoPregunta ar;

    private ArchivoPregunta() {
        filePregunta = new File("preguntas.txt");
    }

    public static ArchivoPregunta getInstance() {
        if (ar == null) {
            ar = new ArchivoPregunta();
        }
        return ar;
    }

    @Override
    public void registrarObjeto(String pregunta) {
        if (!filePregunta.exists()) {
            try {
                filePregunta.createNewFile();
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Ha salido algo mal, lo sentimos");
            }
        }
        try {
            writerPregunta = new FileWriter(filePregunta, true);
            bufferPregunta = new BufferedWriter(writerPregunta);
            printPregunta = new PrintWriter(bufferPregunta);
            printPregunta.println(pregunta);
            cerrarArchivo();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Ha salido algo mal, lo sentimos");
        }
    }

    @Override
    public ArrayList<String> extraerObjeto() {
        if (!filePregunta.exists()) {
            JOptionPane.showMessageDialog(null, "No se ha encontrado el archivo de preguntas");
            return null;
        }
        ArrayList<String> preguntas = new ArrayList<>();
        String aux;
        try {
            readerPregunta = new FileReader(filePregunta);
            bufferReadPregunta = new BufferedReader(readerPregunta);
            while ((aux = bufferReadPregunta.readLine()) != null) {
                preguntas.add(aux);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Ha salido algo mal, lo sentimos");
        }
        return preguntas;
    }

    @Override
    public void cerrarArchivo() {
        try{
            writerPregunta.flush();
            bufferPregunta.flush();
            printPregunta.flush();
            writerPregunta.close();
            bufferPregunta.close();
            printPregunta.close();
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, "Ha salido algo mal, lo sentimos");
        }
    }

    @Override
    public boolean verificarUnicidad(String nick) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean verificarLogin(String nick, String pass) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
