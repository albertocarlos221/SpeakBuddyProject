/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SpeakBuddy;


import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Line2D;
import javax.swing.*;

import java.util.Vector;

import java.io.*;
import javax.sound.sampled.*;
import java.awt.font.*;
import java.text.*;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Carlos Alberto Alves Pereira
 */

public class CaptureScreen extends javax.swing.JFrame implements ActionListener, ControlContext{

    /**
     * Creates new form CaptureScreen
     */
    final int bufSize = 16384;
    
    //Instancia e inicia classe necessárias na interação
    CaptureScreen.FormatControls formatControls = new CaptureScreen.FormatControls();
    CaptureScreen.Capture capture = new CaptureScreen.Capture();
    CaptureScreen.Playback playback = new CaptureScreen.Playback();
    Storage storage=new Storage("Student");
    AudioInputStream audioInputStream;
    CaptureScreen.SamplingGraph samplingGraph;

    //Declara variáveis de controle e contexto
    int progress,temp,ptemp, control;
    String fileName = "untitled",errStr;
    double duration, seconds,byt,aux;
    Vector lines = new Vector();
    
    File file;//variável do tipo File, que será usada no armazenamento de arquivos
    
   public CaptureScreen() {
        //Construtor do JFrame
        samplingGraph=new CaptureScreen.SamplingGraph();
        try {
            storage.readUserInfo();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        progress=Integer.parseInt(storage.linhas[1]);
        initComponents();//O método initComponents() é gerado pela ferramenta de criação
        //de interface do NetBeans, e é usado para iniciar e carregar os componentes do
        //JFrame
                      
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jPanel3 = new javax.swing.JPanel();
        savePro = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        sessionProgressBar = new javax.swing.JProgressBar();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        points = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        pausB = new javax.swing.JButton();
        captB = new javax.swing.JButton();
        textField = new javax.swing.JTextField();
        playB = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        saveB = new javax.swing.JButton();
        samplingPanel = new javax.swing.JPanel();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Practice Session - SpeakBuddy");
        setResizable(false);

        jPanel3.setBackground(new java.awt.Color(0, 153, 204));
        jPanel3.setPreferredSize(new java.awt.Dimension(720, 340));

        savePro.setBackground(new java.awt.Color(255, 201, 14));
        savePro.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        savePro.setText("Save Progress");
        savePro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveProActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(0, 153, 204));

        jLabel1.setBackground(new java.awt.Color(0, 153, 204));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/"+storage.linhas[0]+".png")));

        jLabel3.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Session Progress");

        jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Points:");

        points.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        points.setForeground(new java.awt.Color(255, 255, 255));
        points.setText(progress+"");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(sessionProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(points)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addGap(10, 10, 10))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sessionProgressBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(points))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(0, 153, 204));

        pausB.setBackground(new java.awt.Color(255, 201, 14));
        pausB.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        pausB.setText("Pause");
        pausB.setEnabled(false);
        pausB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pausBActionPerformed(evt);
            }
        });

        captB.setBackground(new java.awt.Color(255, 201, 14));
        captB.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        captB.setText("Record");
        captB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                captBActionPerformed(evt);
            }
        });

        textField.setText(fileName);

        playB.setBackground(new java.awt.Color(255, 201, 14));
        playB.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        playB.setText("Play");
        playB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playBActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("File name:");

        saveB.setBackground(new java.awt.Color(255, 201, 14));
        saveB.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        saveB.setText("Save File");
        saveB.setEnabled(false);
        saveB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBActionPerformed(evt);
            }
        });

        samplingPanel.setBackground(new java.awt.Color(153, 153, 153));
        samplingPanel.add(samplingGraph);

        javax.swing.GroupLayout samplingPanelLayout = new javax.swing.GroupLayout(samplingPanel);
        samplingPanel.setLayout(samplingPanelLayout);
        samplingPanelLayout.setHorizontalGroup(
            samplingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 426, Short.MAX_VALUE)
        );
        samplingPanelLayout.setVerticalGroup(
            samplingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 178, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 22, Short.MAX_VALUE)
                .addComponent(samplingPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(playB)
                .addGap(91, 91, 91)
                .addComponent(captB)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pausB)
                .addGap(39, 39, 39))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(122, 122, 122)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(saveB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(textField, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(playB)
                    .addComponent(captB)
                    .addComponent(pausB))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(samplingPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(saveB)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(313, 313, 313)
                .addComponent(savePro)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(savePro)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    public void createAudioInputStream(File file, boolean updateComponents) {
    //Cria fluxo de dados que receberá o arquivo de audio gravado
        if (file != null && file.isFile()) {
            try {
                this.file = file;
                errStr = null;
                audioInputStream = AudioSystem.getAudioInputStream(file);
                playB.setEnabled(true);
                fileName = file.getName();
                long milliseconds = (long)((audioInputStream.getFrameLength() * 1000) / audioInputStream.getFormat().getFrameRate());
                duration = milliseconds / 1000.0;
                saveB.setEnabled(true);
                if (updateComponents) {
                    formatControls.setFormat(audioInputStream.getFormat());
                    samplingGraph.createWaveForm(null);
                }
            } catch (Exception ex) { 
                reportStatus(ex.toString());
            }
        } else {
            reportStatus("Audio file required.");
        }
    }//fim do método createAudioInputStream()
    
    private void reportStatus(String msg) {
    //Este método retornará uma mensagem de erro quando for chamado
    //A instrução que chamá-lo deverá passar a mensagem de erro a ser exibida, como argumento
        if ((errStr = msg) != null) {
            System.out.println(errStr);
            samplingGraph.repaint();
        }
    }//fim do método reporStatus()
     

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void open() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void close() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public class Playback implements Runnable {
    //A classe Playback, que será executada como uma thread, é responsável pela
    //reprodução do audio recem gravado pelo usuario
        
        SourceDataLine line;
        Thread thread;

        public void start() {
            errStr = null;
            thread = new Thread(this);
            thread.setName("Playback");
            thread.start();
        }

        public void stop() {
            thread = null;
        }
        
        private void shutDown(String message) {
            if ((errStr = message) != null) {
                System.err.println(errStr);
                samplingGraph.repaint();
            }
            if (thread != null) {
                thread = null;
                samplingGraph.stop();
                captB.setEnabled(true);
                pausB.setEnabled(false);
                playB.setText("Play");
            } 
        }

        public void run() {

            // reload the file if loaded by file
            if (file != null) {
                createAudioInputStream(file, false);
            }

            // make sure we have something to play
            if (audioInputStream == null) {
                shutDown("No loaded audio to play back");
                return;
            }
            // reset to the beginnning of the stream
            try {
                audioInputStream.reset();
            } catch (Exception e) {
                shutDown("Unable to reset the stream\n" + e);
                return;
            }

            // get an AudioInputStream of the desired format for playback
            AudioFormat format = formatControls.getFormat();
            AudioInputStream playbackInputStream = AudioSystem.getAudioInputStream(format, audioInputStream);
                        
            if (playbackInputStream == null) {
                shutDown("Unable to convert stream of format " + audioInputStream + " to format " + format);
                return;
            }

            // define the required attributes for our line, 
            // and make sure a compatible line is supported.

            DataLine.Info info = new DataLine.Info(SourceDataLine.class, 
                format);
            if (!AudioSystem.isLineSupported(info)) {
                shutDown("Line matching " + info + " not supported.");
                return;
            }

            // get and open the source data line for playback.

            try {
                line = (SourceDataLine) AudioSystem.getLine(info);
                line.open(format, bufSize);
            } catch (LineUnavailableException ex) { 
                shutDown("Unable to open the line: " + ex);
                return;
            }

            // play back the captured audio data

            int frameSizeInBytes = format.getFrameSize();
            int bufferLengthInFrames = line.getBufferSize() / 8;
            int bufferLengthInBytes = bufferLengthInFrames * frameSizeInBytes;
            byte[] data = new byte[bufferLengthInBytes];
            int numBytesRead = 0;

            // start the source data line
            line.start();

            while (thread != null) {
                try {
                    if ((numBytesRead = playbackInputStream.read(data)) == -1) {
                        break;
                    }
                    int numBytesRemaining = numBytesRead;
                    while (numBytesRemaining > 0 ) {
                        numBytesRemaining -= line.write(data, 0, numBytesRemaining);
                    }
                } catch (Exception e) {
                    shutDown("Error during playback: " + e);
                    break;
                }
            }
            // we reached the end of the stream.  let the data play out, then
            // stop and close the line.
            if (thread != null) {
                line.drain();
            }
            line.stop();
            line.close();
            line = null;
            shutDown(null);
        }
    }//fim da classe Playback
    
    public void saveToFile(String name, AudioFileFormat.Type fileType) {
    //O método saveToFile(), como o propio nome sugere, executa instruções
    //necessárias para salvar a gravação realizada em um arquivo do tipo wav
    
        if (audioInputStream == null) {
            reportStatus("No loaded audio to save");
            return;
        } else if (file != null) {
            createAudioInputStream(file, false);
        }

        // reset to the beginnning of the captured data
        try {
            audioInputStream.reset();
        } catch (Exception e) { 
            reportStatus("Unable to reset stream " + e);
            return;
        }
        
        File file = new File(fileName = name);
        
        JOptionPane.showMessageDialog(this,"Your recording was saved successfully!","File Saved",1,null);
        
        //Terminado o armazenamento do arquivo, a pontuação do usuario exibida
        //na tela é atualizada
        temp=sessionProgressBar.getValue();
        sessionProgressBar.setValue(temp+10);
        temp=(sessionProgressBar.getValue()-temp);
        progress=(temp*5)+progress;
        points.setText(progress+"");
             
        try {
            if (AudioSystem.write(audioInputStream, fileType, file) == -1) {
                throw new IOException("Problems writing to file");
            }
        } catch (Exception ex) { reportStatus(ex.toString()); }
        samplingGraph.repaint();
    }//fim do método saveToFile()
    
    public void saveProgress(){
    //O método saveProgress() executará instruções para que o progresso do usuario
    //na seção de treino seja salvo
        String []infor;
        
        try {
           infor=storage.linhas;
            int points2= Integer.parseInt(points.getText());
            infor[1]=points2+"";
            storage.writeUserInfo(infor);
        } catch (IOException ex) {
            Logger.getLogger(CaptureScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(this, "Your progress was saved!","Progress Saved",1,null);
        //Fim do salvamento do progresso
    
    }//Fim do método saveProgress()    

    class Capture implements Runnable {
    //A classe Capture executará uma thread responsável pela captura do áudio
    //proveniente do microfone do usuario
        TargetDataLine line;
        Thread thread;

        public void start() {
            errStr = null;
            thread = new Thread(this);
            thread.setName("Capture");
            thread.start();
        }

        public void stop() {
            thread = null;
        }
        
        private void shutDown(String message) {
            if ((errStr = message) != null && thread != null) {
                thread = null;
                samplingGraph.stop();
                
                playB.setEnabled(true);
                pausB.setEnabled(false);
                saveB.setEnabled(true);
                captB.setText("Record");
                System.err.println(errStr);
                samplingGraph.repaint();
            }
        }

        public void run() {

            duration = 0;
            audioInputStream = null;
            
            // define the required attributes for our line, 
            // and make sure a compatible line is supported.

            AudioFormat format = formatControls.getFormat();
            DataLine.Info info = new DataLine.Info(TargetDataLine.class, 
                format);
                        
            if (!AudioSystem.isLineSupported(info)) {
                shutDown("Line matching " + info + " not supported.");
                return;
            }

            // get and open the target data line for capture.

            try {
                line = (TargetDataLine) AudioSystem.getLine(info);
                line.open(format, line.getBufferSize());
            } catch (LineUnavailableException ex) { 
                shutDown("Unable to open the line: " + ex);
                return;
            } catch (SecurityException ex) { 
                shutDown(ex.toString());
                Juke.showInfoDialog();
                return;
            } catch (Exception ex) { 
                shutDown(ex.toString());
                return;
            }

            // play back the captured audio data
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            int frameSizeInBytes = format.getFrameSize();
            int bufferLengthInFrames = line.getBufferSize() / 8;
            int bufferLengthInBytes = bufferLengthInFrames * frameSizeInBytes;
            byte[] data = new byte[bufferLengthInBytes];
            int numBytesRead;
            
            line.start();

            while (thread != null) {
                if((numBytesRead = line.read(data, 0, bufferLengthInBytes)) == -1) {
                    break;
                }
                out.write(data, 0, numBytesRead);
            }

            // we reached the end of the stream.  stop and close the line.
            line.stop();
            line.close();
            line = null;

            // stop and close the output stream
            try {
                out.flush();
                out.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            // load bytes into the audio input stream for playback

            byte audioBytes[] = out.toByteArray();
            ByteArrayInputStream bais = new ByteArrayInputStream(audioBytes);
            audioInputStream = new AudioInputStream(bais, format, audioBytes.length / frameSizeInBytes);

            long milliseconds = (long)((audioInputStream.getFrameLength() * 1000) / format.getFrameRate());
            duration = milliseconds / 1000.0;

            try {
                audioInputStream.reset();
            } catch (Exception ex) { 
                ex.printStackTrace(); 
                return;
            }

            samplingGraph.createWaveForm(audioBytes);
            aux=duration;
        }
    }//fim da classe Capture
    
    class FormatControls {
    //A classe FormatControls definirá o formato e as propriedades do arquivo de audio
        public AudioFormat getFormat() {
        AudioFormat.Encoding encoding = AudioFormat.Encoding.PCM_SIGNED;
            float rate = Float.valueOf(10001);
            int sampleSize = 16;
            String signedString = "signed";
            boolean bigEndian = true;
            int channels = 2;
     return new AudioFormat(encoding, rate, sampleSize, 
                          channels, (sampleSize/8)*channels, rate, bigEndian);   
    }
    public void setFormat(AudioFormat format) {
            AudioFormat.Encoding type = format.getEncoding();
            type = AudioFormat.Encoding.PCM_SIGNED;
            
            float rate = format.getFrameRate();
            rate = 10001;
            int ss=format.getSampleSizeInBits();
            ss=16;
            boolean ib =format.isBigEndian();
            ib=true;
            int ch=format.getChannels();
            ch=2;
            
        }
}//fim da classe FormatControls

class SamplingGraph extends JPanel implements Runnable {
//O JPanel SamplingGraph servirá para o usuario como feedback do que foi gravado
//(curva do audio capturado, duração), esse JPanel é incorporado à interface
        private Thread thread;
        private Font font10 = new Font("serif", Font.PLAIN, 10);
        private Font font12 = new Font("serif", Font.PLAIN, 12);
        Color jfcBlue = new Color(204, 204, 255);
        Color pink = new Color(255, 175, 175);
 

        public SamplingGraph() {
            setBackground(new Color(20, 20, 20));//seta a cor da área de gravação/reprodução
            setPreferredSize(new Dimension(426, 178));
            setSize(new Dimension(426, 178));
        }


        public void createWaveForm(byte[] audioBytes) {

            lines.removeAllElements();  // clear the old vector

            AudioFormat format = audioInputStream.getFormat();
            if (audioBytes == null) {
                try {
                    audioBytes = new byte[
                        (int) (audioInputStream.getFrameLength() 
                        * format.getFrameSize())];
                    audioInputStream.read(audioBytes);
                } catch (Exception ex) { 
                    reportStatus(ex.toString());
                    return; 
                }
            }

            Dimension d = samplingPanel.getSize();
            int w = d.width;
            int h = d.height-15;
            int[] audioData = null;
            if (format.getSampleSizeInBits() == 16) {
                 int nlengthInSamples = audioBytes.length / 2;
                 ptemp=nlengthInSamples;
                 audioData = new int[nlengthInSamples];
                 if (format.isBigEndian()) {
                    for (int i = 0; i < nlengthInSamples; i++) {
                         /* First byte is MSB (high order) */
                         int MSB = (int) audioBytes[2*i];
                         /* Second byte is LSB (low order) */
                         int LSB = (int) audioBytes[2*i+1];
                         audioData[i] = MSB << 8 | (255 & LSB);
                     }
                 } else {
                     for (int i = 0; i < nlengthInSamples; i++) {
                         /* First byte is LSB (low order) */
                         int LSB = (int) audioBytes[2*i];
                         /* Second byte is MSB (high order) */
                         int MSB = (int) audioBytes[2*i+1];
                         audioData[i] = MSB << 8 | (255 & LSB);
                     }
                 }
             } else if (format.getSampleSizeInBits() == 8) {
                 int nlengthInSamples = audioBytes.length;
                 audioData = new int[nlengthInSamples];
                 if (format.getEncoding().toString().startsWith("PCM_SIGN")) {
                     for (int i = 0; i < audioBytes.length; i++) {
                         audioData[i] = audioBytes[i];
                     }
                 } else {
                     for (int i = 0; i < audioBytes.length; i++) {
                         audioData[i] = audioBytes[i] - 128;
                     }
                 }
            }
               
            int frames_per_pixel = audioBytes.length / format.getFrameSize()/w;
            byte my_byte = 0;
            double y_last = 0;
            int numChannels = format.getChannels();
            for (double x = 0; x < w && audioData != null; x++) {
                int idx = (int) (frames_per_pixel * numChannels * x);
                if (format.getSampleSizeInBits() == 8) {
                     my_byte = (byte) audioData[idx];
                } else {
                     my_byte = (byte) (128 * audioData[idx] / 32768 );
                }
                double y_new = (double) (h * (128 - my_byte) / 256);
                lines.add(new Line2D.Double(x, y_last, x, y_new));
                y_last = y_new;
            }

            repaint();
            byt=audioBytes.length;
        }


        public void paint(Graphics g) {

            Dimension d = samplingPanel.getSize();
            int w = d.width;
            int h = d.height;
            int INFOPAD = 15;

            Graphics2D g2 = (Graphics2D) g;
            g2.setBackground(getBackground());
            g2.clearRect(0, 0, w, h);
            g2.setColor(Color.white);//seta a cor do painel inferior de gravação, onde de encontram as informações do arquivo(Duração, posição etc)
            g2.fillRect(0, h-INFOPAD, w, INFOPAD);

            if (errStr != null) {//configurações de msgs de erro de reprodução e/ou gravação
                g2.setColor(jfcBlue);
                g2.setFont(new Font("serif", Font.BOLD, 18));
                g2.drawString("ERROR", 5, 20);
                AttributedString as = new AttributedString(errStr);
                as.addAttribute(TextAttribute.FONT, font12, 0, errStr.length());
                AttributedCharacterIterator aci = as.getIterator();
                FontRenderContext frc = g2.getFontRenderContext();
                LineBreakMeasurer lbm = new LineBreakMeasurer(aci, frc);
                float x = 5, y = 25;
                lbm.setPosition(0);
                while (lbm.getPosition() < errStr.length()) {
                    TextLayout tl = lbm.nextLayout(w-x-5);
                    if (!tl.isLeftToRight()) {
                        x = w - tl.getAdvance();
                    }
                    tl.draw(g2, x, y += tl.getAscent());
                    y += tl.getDescent() + tl.getLeading();
                }
            } else if (capture.thread != null) {//configuração da cor do contador de tempo quando a gravação está sendo feita
                g2.setColor(Color.black);
                g2.setFont(font12);
                g2.drawString("Length: " + String.valueOf(seconds), 3, h-4);
            } else {//configuração da cor do texto no painel inferior de gravação
                g2.setColor(Color.black);
                g2.setFont(font12);
                g2.drawString("File: " + fileName + "  Length: " + String.valueOf(duration) + "  Position: " + String.valueOf(seconds), 3, h-4);

                if (audioInputStream != null) {
                    // .. render sampling graph ..
                    g2.setColor(jfcBlue);//seta a cor da linha horizontal do gravador
                    for (int i = 1; i < lines.size(); i++) {
                        g2.draw((Line2D) lines.get(i));
                    }

                    // .. draw current position ..
                    if (seconds != 0) {//configuração da linha vertical de reprodução
                        double loc = seconds/duration*w;
                        g2.setColor(pink);
                        g2.setStroke(new BasicStroke(3));
                        g2.draw(new Line2D.Double(loc, 0, loc, h-INFOPAD-2));
                    }
                }
            }
        }
    
        public void start() {
            thread = new Thread(this);
            thread.setName("SamplingGraph");
            thread.start();
            seconds = 0;
        }

        public void stop() {
            if (thread != null) {
                thread.interrupt();
            }
            thread = null;
        }

        public void run() {
            seconds = 0;
            while (thread != null) {
                if ((playback.line != null) && (playback.line.isOpen()) ) {

                    long milliseconds = (long)(playback.line.getMicrosecondPosition() / 1000);
                    seconds =  milliseconds / 1000.0;
                } else if ( (capture.line != null) && (capture.line.isActive()) ) {

                    long milliseconds = (long)(capture.line.getMicrosecondPosition() / 1000);
                    seconds =  milliseconds / 1000.0;
                }

                try { thread.sleep(100); } catch (Exception e) { break; }

                repaint();
                                
                while ((capture.line != null && !capture.line.isActive()) ||
                       (playback.line != null && !playback.line.isOpen())) 
                {
                    try { thread.sleep(10); } catch (Exception e) { break; }
                }
            }
            seconds = 0;
            repaint();
        }
    }//fim da classe SamplingGraph

    private void saveBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBActionPerformed
        if((control==1)||(aux<30)){
            JOptionPane.showMessageDialog(this, "Recording too short!\nYour recordings must have a duration equal or bigger than 30 seconds.\n"
                    + "\nCome on, buddy! I bet you have much more to say!", "Short Recording",1,null);
            saveB.setEnabled(false);
        }
        else{
            saveToFile(fileName=textField.getText()+".wav".trim(), AudioFileFormat.Type.WAVE);
            control=1;
            saveB.setEnabled(false);
        }
        
    }//GEN-LAST:event_saveBActionPerformed

    private void pausBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pausBActionPerformed
        if (pausB.getText().startsWith("Pause")) {
            if (capture.thread != null) {
                capture.line.stop();
            } else {
                if (playback.thread != null) {
                    playback.line.stop();
                }
            }
            pausB.setText("Resume");
        } else {
            if (capture.thread != null) {
                capture.line.start();
            } else {
                if (playback.thread != null) {
                    playback.line.start();
                }
            }
            pausB.setText("Pause");
        }
    }//GEN-LAST:event_pausBActionPerformed

    private void captBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_captBActionPerformed
        control=0;
        pausB.setEnabled(true);
        if (captB.getText().startsWith("Record")) {
            file = null;
            capture.start();
            fileName = "untitled";
            samplingGraph.start();
            playB.setEnabled(false);
            pausB.setEnabled(true);
            saveB.setEnabled(false);
            captB.setText("Stop");
        } else {
            lines.removeAllElements();
            capture.stop();
            samplingGraph.stop();
            playB.setEnabled(true);
            pausB.setEnabled(false);
            saveB.setEnabled(true);
            captB.setText("Record");}
    }//GEN-LAST:event_captBActionPerformed

    private void playBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playBActionPerformed
        pausB.setEnabled(true);
        if (playB.getText().startsWith("Play")) {
            playback.start();
            samplingGraph.start();
            captB.setEnabled(false);
            pausB.setEnabled(true);
            playB.setText("Stop");
        } else {
            playback.stop();
            samplingGraph.stop();
            captB.setEnabled(true);
            pausB.setEnabled(false);
            playB.setText("Play");}
    }//GEN-LAST:event_playBActionPerformed

    private void saveProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveProActionPerformed
        saveProgress();
    }//GEN-LAST:event_saveProActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton captB;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JButton pausB;
    private javax.swing.JButton playB;
    private javax.swing.JLabel points;
    private javax.swing.JPanel samplingPanel;
    private javax.swing.JButton saveB;
    private javax.swing.JButton savePro;
    private javax.swing.JProgressBar sessionProgressBar;
    private javax.swing.JTextField textField;
    // End of variables declaration//GEN-END:variables
}
