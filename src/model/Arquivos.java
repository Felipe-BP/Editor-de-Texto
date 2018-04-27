/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Felipe Bueno de Paula
 */
public class Arquivos {
    
    public void saveFile(File file, String txt) throws IOException{
        try{
            FileWriter fw;
            fw = new FileWriter(file);
            fw.write(txt);
            fw.close();
        } catch(FileNotFoundException e){
            System.out.println("Erro ao salvar "+e.getMessage());
        }
    }
    
}
