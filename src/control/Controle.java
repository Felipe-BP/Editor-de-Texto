/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import model.Arquivos;

/**
 *
 * @author Felipe Bueno de Paula
 */
public class Controle {
    public void salvarArquivo(String txt) throws IOException{
        Arquivos arq = new Arquivos();
        JFileChooser chooser;
        chooser = new JFileChooser();
        chooser.setDialogTitle("Salvar em");
        String caminho = "";
        
        int retorno = chooser.showSaveDialog(null);
        if (retorno == JFileChooser.APPROVE_OPTION){
            caminho = chooser.getSelectedFile().getAbsolutePath();
            File dir = new File(caminho);
            arq.saveFile(dir, txt);
        }
    }
}
