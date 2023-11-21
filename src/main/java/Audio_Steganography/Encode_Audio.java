
package Audio_Steganography;
import Coding.SendEmail;
import java.awt.Cursor;
import java.awt.Font;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.Mixer;
import javax.sound.sampled.TargetDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author jannah
 */
public class Encode_Audio extends javax.swing.JFrame {

    private static final String algorithm = "PBEWithMD5AndDES";
    byte[] audioBytes;
    byte[] Message;
    char pwd[];
    
  boolean stopCapture = false;
  ByteArrayOutputStream byteArrayOutputStream;
  AudioFormat audioFormat;
  TargetDataLine targetDataLine;
  AudioInputStream audioInputStreamForEncode;
  AudioInputStream audioInputStream;
  
    String inputAudioFilePath;
    
	private final AudioPlayer player = new AudioPlayer();
	private Thread playbackThread;
	private RecordTimer timer;
	private boolean isRecording = false;
	private boolean isPlaying = false;
	private String saveFilePath;
        private String SaveEncodeAudio;
        String EncodeAudioPath;

        
        // Icons used for buttons
	private final ImageIcon iconRecord = new ImageIcon(getClass().getResource(
			"/images/Record.gif"));
	private final ImageIcon iconStop = new ImageIcon(getClass().getResource(
			"/images/Stop.gif"));
	private final ImageIcon iconPlay = new ImageIcon(getClass().getResource(
			"/images/Play.gif"));
    
    
    public Encode_Audio() {
        initComponents();
        jLabelEmbedded.setVisible(false);
        jButtonPlayEncodedAudio.setVisible(false);
                captureBtn.setFont(new Font("Sans", Font.BOLD, 14));
		captureBtn.setIcon(iconRecord);
		playBtn.setFont(new Font("Sans", Font.BOLD, 14));
		playBtn.setIcon(iconPlay);
		playBtn.setEnabled(false); 
                jLabel2.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        captureBtn = new javax.swing.JButton();
        playBtn = new javax.swing.JButton();
        labelRecordTime = new javax.swing.JLabel();
        jButtonSelectAudio = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaMessage = new javax.swing.JTextArea();
        jTextFieldSelectAudio = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButtonEncode = new javax.swing.JButton();
        jButtonSave = new javax.swing.JButton();
        jLabelEmbedded = new javax.swing.JLabel();
        jButtonSend = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jButtonOpenDecoder = new javax.swing.JButton();
        jTextPassword = new javax.swing.JTextField();
        jButtonPlayEncodedAudio = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        captureBtn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        captureBtn.setText("Record Audio");
        captureBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        captureBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                captureBtnActionPerformed(evt);
            }
        });

        playBtn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        playBtn.setText("Play");
        playBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        playBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playBtnActionPerformed(evt);
            }
        });

        labelRecordTime.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelRecordTime.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelRecordTime.setText("RecordTime : 00:00:00");

        jButtonSelectAudio.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButtonSelectAudio.setText("Select Audio");
        jButtonSelectAudio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonSelectAudio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSelectAudioActionPerformed(evt);
            }
        });

        jTextAreaMessage.setColumns(20);
        jTextAreaMessage.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        jTextAreaMessage.setRows(5);
        jTextAreaMessage.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Enter Message :", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N
        jScrollPane1.setViewportView(jTextAreaMessage);

        jTextFieldSelectAudio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Password : ");

        jButtonEncode.setFont(new java.awt.Font("Aharoni", 1, 24)); // NOI18N
        jButtonEncode.setText("Encode");
        jButtonEncode.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonEncode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEncodeActionPerformed(evt);
            }
        });

        jButtonSave.setFont(new java.awt.Font("Aharoni", 1, 24)); // NOI18N
        jButtonSave.setText("Save");
        jButtonSave.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveActionPerformed(evt);
            }
        });

        jLabelEmbedded.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabelEmbedded.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelEmbedded.setText("hh:mm:ss");

        jButtonSend.setFont(new java.awt.Font("Aharoni", 1, 24)); // NOI18N
        jButtonSend.setText("Send");
        jButtonSend.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSendActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Encode Audio");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
        );

        jButtonOpenDecoder.setFont(new java.awt.Font("Aharoni", 1, 24)); // NOI18N
        jButtonOpenDecoder.setText("Open Decoder");
        jButtonOpenDecoder.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonOpenDecoder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOpenDecoderActionPerformed(evt);
            }
        });

        jTextPassword.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jButtonPlayEncodedAudio.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButtonPlayEncodedAudio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Play.gif"))); // NOI18N
        jButtonPlayEncodedAudio.setText("Play");
        jButtonPlayEncodedAudio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonPlayEncodedAudio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPlayEncodedAudioActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Encoded Succesfully !");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(captureBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelRecordTime, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(playBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButtonEncode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonSelectAudio, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonPlayEncodedAudio, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldSelectAudio)
                            .addComponent(jTextPassword)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButtonSave, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                                    .addComponent(jLabelEmbedded, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButtonSend, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButtonOpenDecoder, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(playBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(captureBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelRecordTime, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFieldSelectAudio)
                    .addComponent(jButtonSelectAudio, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextPassword)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonPlayEncodedAudio, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 1, Short.MAX_VALUE))
                    .addComponent(jLabelEmbedded, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonSave, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonSend, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButtonEncode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButtonOpenDecoder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void captureBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_captureBtnActionPerformed
	if (isRecording == false) 
		startRecording();
        else 
		stopRecording();
               
    }//GEN-LAST:event_captureBtnActionPerformed

    private void playBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playBtnActionPerformed
    	if (!isPlaying) 
		playBack();
        else 
		stopPlaying();           	
    }//GEN-LAST:event_playBtnActionPerformed

    private void jButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveActionPerformed
               if(jButtonPlayEncodedAudio.isShowing())
       showFileDialog(false);
        else
            JOptionPane.showMessageDialog(this, "Error! Audio is Not Decoded ");
    }//GEN-LAST:event_jButtonSaveActionPerformed

    private void jButtonSelectAudioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSelectAudioActionPerformed

               showFileDialog(true);
    }//GEN-LAST:event_jButtonSelectAudioActionPerformed

    private void jButtonOpenDecoderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonOpenDecoderActionPerformed
        Decode_Audio audio = new Decode_Audio();
        audio.setVisible(true);
        audio.setLocationRelativeTo(null);
        this.dispose();
        
    }//GEN-LAST:event_jButtonOpenDecoderActionPerformed
   
    private void jButtonEncodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEncodeActionPerformed
        if(jTextFieldSelectAudio.getText().equals("")
                || jTextPassword.getText().equals("")
                || jTextAreaMessage.getText().equals(""))
            JOptionPane.showMessageDialog(this, "Please Fill all the Field !");
        else{
            embed(); 
            if(embed()){
            jButtonPlayEncodedAudio.setVisible(true);
            jLabelEmbedded.setVisible(true);
            jLabel2.setVisible(true);
            }
            else
                JOptionPane.showMessageDialog(this, "Embed Error");
        }
    }//GEN-LAST:event_jButtonEncodeActionPerformed

    boolean isPlayingEncodedAudio = false;  
    private void jButtonPlayEncodedAudioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPlayEncodedAudioActionPerformed
        if (isPlayingEncodedAudio == false)
		playEncodedAudio();
	 else 
		stopPlayingEncoded();			
    }//GEN-LAST:event_jButtonPlayEncodedAudioActionPerformed

    private void jButtonSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSendActionPerformed
        
        SendEmail se = new SendEmail();
        se.setVisible(true);
        se.setLocationRelativeTo(null);
        se.pack();
        
    }//GEN-LAST:event_jButtonSendActionPerformed

 /************* Start recording sound, the time will count up. *************/
	private void startRecording() {
                    captureBtn.setText("Stop");
                    captureBtn.setIcon(iconStop);
                    playBtn.setEnabled(false);
                    isRecording = true;
                    captureAudio();

		timer = new RecordTimer(labelRecordTime);
		timer.start();
	}

/************** Stop recording and save the sound into a WAV file. ***************/
private void stopRecording() {
        timer.cancel();
        captureBtn.setText("Record");
        captureBtn.setIcon(iconRecord);
        playBtn.setEnabled(true);
        isRecording = false;
        stopCapture = true;
        setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        saveAudioFile();
}

/****************** Start playing back the sound. *****************************/
private void playBack() {
		timer = new RecordTimer(labelRecordTime);
		timer.start();
		isPlaying = true;
		playbackThread = new Thread(new Runnable() {
		@Override
		public void run() {
			try {
			playBtn.setText("Stop");
			playBtn.setIcon(iconStop);
			captureBtn.setEnabled(false);

			player.play(saveFilePath);
			timer.reset();

			playBtn.setText("Play");
			captureBtn.setEnabled(true);
			playBtn.setIcon(iconPlay);
                        isPlaying = false;
		} catch (UnsupportedAudioFileException | LineUnavailableException | IOException ex) {
		}
	}
    });
	playbackThread.start();
}

/****************** Stop playing back. ********************************** */
	private void stopPlaying() {         
		timer.reset();
		timer.interrupt();
		player.stop();
		playbackThread.interrupt();               
	}
        private void stopPlayingEncoded() {         
		timer.reset();
		timer.interrupt();
                jButtonPlayEncodedAudio.setText("Play");
                jButtonPlayEncodedAudio.setIcon(iconPlay);
                isPlayingEncodedAudio = false;
		player.stop();
		playbackThread.interrupt();  
                
                
	}
/*==================================================================================*/        
/*==================================================================================*/
/******************Start Save the recorded sound into a WAV file. *******************/
        
   private void saveAudioFile() {
    JFileChooser fileChooser = new JFileChooser();

    int userSelection = fileChooser.showSaveDialog(null);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File saveFilePath = fileChooser.getSelectedFile();
            System.out.println("Selected file path: " + saveFilePath.getAbsolutePath());

            // Save the captured audio to the selected file path
            try {
                AudioSystem.write(audioInputStream, AudioFileFormat.Type.WAVE, saveFilePath);
                System.out.println("Audio saved successfully");
            } catch (Exception e) {
                System.out.println("Failed to save audio. Reason: " + e.getMessage());
            }
        }
    }

    /**
     * save Method for saving Audio After Recording
     * @param wavFile
     * @throws java.io.IOException
     */
    public void save(File wavFile) throws IOException {
		byte[] audioData = byteArrayOutputStream.toByteArray();
		ByteArrayInputStream bais = new ByteArrayInputStream(audioData);
                AudioFormat audioFormat = getAudioFormat();
		AudioInputStream audioInputStream = new AudioInputStream(bais, audioFormat,
				audioData.length / audioFormat.getFrameSize());		
		AudioSystem.write(audioInputStream, AudioFileFormat.Type.WAVE, wavFile);

		audioInputStream.close();
		byteArrayOutputStream.close();
}
/*************** End of save Method for saving Audio After Recording. *************/     
/**********************************************************************************/
/*================================================================================*/
/****************************** Start of Capture Audio. ***************************/    
  //This method captures audio input
  //from a microphone and saves it in a
  // ByteArrayOutputStream object.
    
  private void captureAudio(){
    try{
      //Get and display a list of
      // available mixers.
      Mixer.Info[] mixerInfo =  AudioSystem.getMixerInfo();
      System.out.println("Available mixers:");
      for(int cnt = 0; cnt < mixerInfo.length; cnt++){
      	System.out.println(mixerInfo[cnt].getName());
      }//end for loop
      //Get everything set up for capture
      audioFormat = getAudioFormat();
      DataLine.Info dataLineInfo = new DataLine.Info(TargetDataLine.class, audioFormat);
      //Select one of the available
      // mixers.
      Mixer mixer = AudioSystem.getMixer(mixerInfo[3]);  
      //Get a TargetDataLine on the selected
      // mixer.
      targetDataLine = (TargetDataLine)
              mixer.getLine(dataLineInfo);
      //Prepare the line for use.
      targetDataLine.open(audioFormat);
      targetDataLine.start();
      //Create a thread to capture the microphone
      // data and start it running.  It will run
      // until the Stop button is clicked.
      Thread captureThread = new CaptureThread();
      captureThread.start();
    } catch (Exception e) {
      System.out.println(e);
    }//end catch
  }
  //This method creates and returns an
  // AudioFormat object for a given set of format
  // parameters.  If these parameters don't work
  // well for you, try some of the other
  // allowable parameter values, which are shown
  // in comments following the declartions.
  private AudioFormat getAudioFormat(){
    float sampleRate = 8000.0F;
    //8000,11025,16000,22050,44100
    int sampleSizeInBits = 16;
    //8,16
    int channels = 1;
    //1,2
    boolean signed = true;
    //true,false
    boolean bigEndian = false;
    //true,false
    return new AudioFormat(sampleRate, sampleSizeInBits, channels, signed, bigEndian);
  }//end getAudioFormat
//=================================================================================//
//Inner class to capture data from microphone
class CaptureThread extends Thread{
  //An arbitrary-size temporary holding buffer
  byte tempBuffer[] = new byte[10000];
  public void run(){
    byteArrayOutputStream =  new ByteArrayOutputStream();
    stopCapture = false;
    try{//Loop until stopCapture is set by
        // another thread that services the Stop
        // button.
      while(!stopCapture){
        //Read data from the internal buffer of
        // the data line.
        int cnt = targetDataLine.read(tempBuffer, 0, tempBuffer.length);
        if(cnt > 0){
          //Save data in output stream object.
          byteArrayOutputStream.write(tempBuffer, 0, cnt);
        }//end if
      }//end while
      byteArrayOutputStream.close();
    }catch (Exception e) {
      System.out.println(e);
      System.exit(0);
    }//end catch
  }//end run
}//end inner class CaptureThread
/****************************End of Capture Audio Methods. ************************/
//================================================================================//
//================================================================================//
/*================================================================================*/
/************** Open File for select Audio or Save Encoded Audio . ****************/
/*================================================================================*/    
 private java.io.File showFileDialog(final boolean open) {
    JFileChooser fc = new JFileChooser("Open a File");
    javax.swing.filechooser.FileFilter ff = new javax.swing.filechooser.FileFilter(){
       @Override
       public boolean accept(File f) {
          String name = f.getName().toLowerCase();
          if(open)
             return f.isDirectory() ||
                name.endsWith(".wav");
          return f.isDirectory()|| name.endsWith(".wav");
          }
       @Override
       public String getDescription() {
          if(open)
             return "Audio (*.wav)";
          return "Audio (*.wav)";
          }
       };
    fc.setAcceptAllFileFilterUsed(false);
    fc.addChoosableFileFilter(ff);
 
    java.io.File f = null;
   if(open && fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION){
       
       EncodeAudioPath = fc.getSelectedFile().getAbsolutePath();
      jTextFieldSelectAudio.setText(fc.getSelectedFile().getAbsolutePath());
   }
    else if(!open && fc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION){
      
                SaveEncodeAudio = fc.getSelectedFile().getAbsolutePath();
        
/************** now write the byte array to an audio file. ************************/ 
File fileOut = new File(SaveEncodeAudio);
ByteArrayInputStream byteIS = new ByteArrayInputStream(audioBytes);
AudioInputStream audioIS = new AudioInputStream(byteIS,
        audioInputStreamForEncode.getFormat(), audioInputStreamForEncode.getFrameLength());

// Change the file format to WAV
if (AudioSystem.isFileTypeSupported(AudioFileFormat.Type.WAVE, audioIS)) {
    try {
        AudioSystem.write(audioIS, AudioFileFormat.Type.WAVE, fileOut);
        System.out.println("Steganographed WAV file is written as " + SaveEncodeAudio + "...");
        System.out.println();
    } catch (Exception e) {
        System.err.println("Sound File write error");
    }
}
}
    return f;
    }
 /**************************** End Of File Dialog Window. *************************/
/*================================================================================*/
/*================================================================================*/
/**************************** Start Of Encoding Functions. *************************/
/*================================================================================*/
    /**
     * End Of File Dialog Window.
     * @return
     */
    public boolean embed() {
              
                pwd = jTextPassword.getText().toCharArray();                
                Message = jTextAreaMessage.getText().getBytes();
                inputAudioFilePath = jTextFieldSelectAudio.getText();
                audioBytes = readAudio(inputAudioFilePath);
                
                try {
		audioInputStreamForEncode =
                        AudioSystem.getAudioInputStream(new File(inputAudioFilePath));
		} catch (UnsupportedAudioFileException | IOException e) {
		} 
                 
                 if(audioBytes == null)
                     return false;
                 else{
                       
		System.out.println("Embedding the text message in the audio file ...");
		System.out.println("The plain text data length: "+ Message.length);
                                
		// Encrypt the text data.
		byte[] encryptedTextBytes = null;
		try {                    
			encryptedTextBytes = encrypt(Message, pwd);
			if (encryptedTextBytes.length * 8 > audioBytes.length)
				return false;

		} catch (Exception e) {
			System.out.println("Error while encrypting the plain text data: "
					+ e);
		}
		System.out.println("The encrypted message length: "
				+ encryptedTextBytes.length);

		// First encode the length of the encrypted text
		int messageLength = encryptedTextBytes.length;
		byte[] len = bit_conversion(messageLength);

		System.out
		.println("The audio bytes before embedding the message length: "
		+ audioBytes.length);

		audioBytes = encode_text(audioBytes, len, 0);
		System.out.println("The audio bytes after embedding the message length: "
						+ audioBytes.length);
		audioBytes = encode_text(audioBytes, encryptedTextBytes, 32);
		System.out.println("The audio bytes after embedding the text message: "
				+ audioBytes.length);

		System.out.println();
                            
		return true;
	}
    }
 
 private byte[] encode_text(byte[] data, byte[] addition, int offset)
	{
		// check that the data + offset will fit in the image

		if (addition.length + offset > data.length) {
			throw new IllegalArgumentException("File not long enough!");
		}

		// loop through each addition byte
		for (int i = 0; i < addition.length; ++i) {
			// loop through the 8 bits of each byte
			int add = addition[i];
			for (int bit = 7; bit >= 0; --bit, ++offset) // ensure the new													// through both
															// loops
			{
				// assign an integer to b, shifted by bit spaces AND 1
				// a single bit of the current byte
				int b = (add >>> bit) & 1;

				// assign the bit by taking: [(previous byte value) AND 0xfe] OR
				// bit to add

				// changes the last bit of the byte in the image to be the bit
				// of addition

				data[offset] = (byte) ((data[offset] & 0xFE) | b);
			}
		}
		return data;
	}
 
 private byte[] bit_conversion(int i) {
		return (new byte[] { 0, 0, 0, (byte) (i & 0x000000FF) });
	}
 
 public static byte[] readAudio(String audioFilePath) {

		System.out.println("Reading the audio file......");

		 AudioInputStream audioInputStream = null;
		byte[] audioBytes = null;
		File audioFile = new File(audioFilePath);

		try {
			audioInputStream = AudioSystem.getAudioInputStream(audioFile);
			int bytesPerFrame = audioInputStream.getFormat().getFrameSize();
			// Set an arbitrary buffer size of 1024 frames.
			int numBytes = 154600 * bytesPerFrame;
			audioBytes = new byte[numBytes];

			try {
				audioInputStream.read(audioBytes);

			} catch (Exception ex) {
//				System.out.println("Audio file error:" + ex);
                            JOptionPane.showMessageDialog(null, "Audio Error Please Check Your Audio File!");
                            return null;
			}
		} catch (UnsupportedAudioFileException | IOException e) {
//			System.out.println("Audio file error:" + e);
                    JOptionPane.showMessageDialog(null, "Audio Error Check The Audio File");
                    return null;
		}
		return audioBytes;
	}
 
 public byte[] encrypt(byte[] plainText, char password[]) {
		System.out.println("Encrypting the plaintext message: "
				+ new String(plainText));
		System.out.println("The plain message size is: " + plainText.length);
		System.out.println("The encryption password length: " + password.length);
		PBEKeySpec pbeKeySpec;
		PBEParameterSpec pbeParamSpec;
		SecretKeyFactory keyFac;
		byte[] cipherbuff = null;
		// Salt
		byte[] salt = { (byte) 0xc7, (byte) 0x73, (byte) 0x21, (byte) 0x8c,
				(byte) 0x7e, (byte) 0xc8, (byte) 0xee, (byte) 0x99 };

		// Iteration count
		int count = 20;

		// Create PBE parameter set
		pbeParamSpec = new PBEParameterSpec(salt, count);

		try {
			pbeKeySpec = new PBEKeySpec(password);

			keyFac = SecretKeyFactory.getInstance(algorithm);
			SecretKey pbeKey = keyFac.generateSecret(pbeKeySpec);

			// Create PBE Cipher
			Cipher pbeCipher = Cipher.getInstance(algorithm);

			// Initialize PBE Cipher with key and parameters
			pbeCipher.init(Cipher.ENCRYPT_MODE, pbeKey, pbeParamSpec);

			cipherbuff = pbeCipher.doFinal(plainText);
		} catch (NoSuchAlgorithmException | InvalidKeySpecException | NoSuchPaddingException | InvalidKeyException | InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException ex) {
			// Handle the error...
			System.out.println("Caught Exception while encryption: " + ex);
		}

		System.out.println("The encrypted message: " + new String(cipherbuff));
		System.out
			.println("The encrypted message length: " + cipherbuff.length);
		return cipherbuff;
	}
 
 private void playEncodedAudio() {
		timer = new RecordTimer(jLabelEmbedded);
		timer.start();
                
		isPlayingEncodedAudio = true;
		playbackThread = new Thread(new Runnable() {
		@Override
		public void run() {
			try {
			jButtonPlayEncodedAudio.setText("Stop");
			jButtonPlayEncodedAudio.setIcon(iconStop);
			                           
			player.play(EncodeAudioPath);                       
			timer.reset();
                        isPlaying = false;
                        
                        } catch (UnsupportedAudioFileException | LineUnavailableException | IOException ex) {
		}
            }
        });
	playbackThread.start();
}
/*************************** End Of Encoding Functions. ****************************/ 
/*=================================================================================*/ 
/*=================================================================================*/ 
/*=================================================================================*/ 
/*=================================================================================*/ 
/*=================================================================================*/
    /**
     * End Of Encoding Functions.
     * @param args
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Encode_Audio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Encode_Audio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Encode_Audio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Encode_Audio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Encode_Audio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton captureBtn;
    private javax.swing.JButton jButtonEncode;
    private javax.swing.JButton jButtonOpenDecoder;
    private javax.swing.JButton jButtonPlayEncodedAudio;
    private javax.swing.JButton jButtonSave;
    private javax.swing.JButton jButtonSelectAudio;
    private javax.swing.JButton jButtonSend;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelEmbedded;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextAreaMessage;
    private javax.swing.JTextField jTextFieldSelectAudio;
    private javax.swing.JTextField jTextPassword;
    private javax.swing.JLabel labelRecordTime;
    private javax.swing.JButton playBtn;
    // End of variables declaration//GEN-END:variables
}
