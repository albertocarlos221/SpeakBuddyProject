/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SpeakBuddy;
import java.io.File;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Carlos Alberto Alves Pereira
 */
public class Storage {
    String separ,dir;
    String[]linhas;
    FileWriter fw;
    BufferedWriter bw;
    FileReader fr;
    BufferedReader br;
    File arquivo, drt;
    
    public Storage(String user){
        
        separ = File.separator;
        dir=("."+separ+user+separ);
        drt=new File(dir);
        drt.mkdir();
        arquivo=new File(dir+" info.txt");
    }
        public void writeUserInfo(String []info) throws IOException{
            
            if(!arquivo.exists()){
                
                arquivo.createNewFile();
               
            }
            else{
                updateUserInfo();
            }
            
            fw = new FileWriter(arquivo, true);
            bw=new BufferedWriter(fw);
            for(int i=0;i<info.length;i++){
                bw.write(info[i]);
                bw.newLine();
            }
            bw.close();
            fw.close();
        }
        public void readUserInfo() throws IOException{
            fr=new FileReader(arquivo);
            br=new BufferedReader(fr);
            linhas=new String[4];
            int n=0;
            while( br.ready() ){
                arquivo=new File(dir+" info.txt");
                String linha = br.readLine();
                linhas[n]=linha;
                n++;
            }
            
            br.close();
            fr.close();
        }
        public void updateUserInfo() throws IOException{
            arquivo.delete();
            arquivo.createNewFile();
         
        }
}
