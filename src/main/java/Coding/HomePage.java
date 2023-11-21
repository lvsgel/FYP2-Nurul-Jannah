package Coding;


import ImageSteganography.Decryption;
import ImageSteganography.Encryption;
import Audio_Steganography.Encode_Audio;
import Audio_Steganography.Decode_Audio;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.Image;
import java.awt.Insets;
import java.io.File;

/**
 *
 * @author Nurul Jannah binti Shahrol Nizam
 */
public class HomePage extends javax.swing.JFrame {

    /**
     * Creates new form MainMenu
     * @throws MalformedURLException
     */
    public HomePage() throws MalformedURLException {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() throws MalformedURLException {
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();



        this.setTitle("File Encryption Steganography");
        this.setResizable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        // Create a maroon red color
        int maroonR = 128; // R value for maroon
        int maroonG = 0;   // G value for maroon
        int maroonB = 0;   // B value for maroon

        jPanel1.setBackground(new java.awt.Color(maroonR, maroonG, maroonB));

        // Use a grey color for the border
        int greyR = 169; // R value for grey
        int greyG = 169; // G value for grey
        int greyB = 169; // B value for grey

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(greyR, greyG, greyB), java.awt.Color.lightGray));

        try {
            // Specify the local file path to your image
            String imagePath = "src/main/java/images/UPTM.png";
        
            File imageFile = new File(imagePath);
            URL imageUrl = imageFile.toURI().toURL();
        
            ImageIcon imageIcon = new ImageIcon(imageUrl);
            // Display the imageIcon using a JLabel or any other suitable component
        
            // Hardcoded dimensions
            int hardcodedWidth = 900; // Example value, set as you need
            int hardcodedHeight = 250; // Example value, set as you need
        
            // Resize the ImageIcon
            Image image = imageIcon.getImage();
            Image newImage = image.getScaledInstance(hardcodedWidth, hardcodedHeight, Image.SCALE_SMOOTH);
            imageIcon = new ImageIcon(newImage);
        
            jLabel1.setIcon(imageIcon); // Set the resized image as the icon for jLabel1.
            jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER); // Center the image
            jLabel1.setText(""); // Remove the text from jLabel1.
        
        } catch (Exception e) {
            e.printStackTrace();
            // Handle the exception, perhaps show a default image or an error message
        }
        

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
        );

        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel2MouseEntered(evt);
            }
        });

        // Create a light blue color for the background
        Color backgroundColor = new Color(0, 27, 64); // Dark Sapphire
        jPanel3.setBackground(backgroundColor);

        // Use a cute and simple font
        Font labelFont = new Font("Arial", Font.LAYOUT_RIGHT_TO_LEFT, 20);
        jLabel3.setFont(labelFont);
        jLabel3.setForeground(Color.LIGHT_GRAY); // Change text color to dark gray
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("By Nurul Jannah binti Shahrol Nizam");

        // Add a margin around jLabel3 for better aesthetics
        jLabel3.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 66, Short.MAX_VALUE)
        );
        // Set a font
        jButton5.setFont(new java.awt.Font("Comic Sans MS", java.awt.Font.BOLD, 16));
        
        // Set a different foreground color
        jButton5.setForeground(new java.awt.Color(64, 64, 64)); // Dark Grey

        // Add some padding and round the corners for a cute look
        jButton5.setMargin(new Insets(10, 20, 10, 20));
        
        jButton5.setBorder(BorderFactory.createEmptyBorder());
        BorderFactory.createCompoundBorder(
            BorderFactory.createMatteBorder(5, 15, 5, 15, new Color(255, 105, 180)),
            BorderFactory.createLineBorder(new Color(255, 105, 180), 2)
        );
        // Set a cute and simple cursor
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        

        // Set the Encode text for the button
        String buttonText2 = "ENCODE IMAGE";
        jButton5.setText(buttonText2);

        // Remove the image icon
        jButton5.setIcon(null);

        // Get the width and height of the button (optional)
        jButton5.setPreferredSize(new Dimension(200, 50)); // example dimensions  // example dimensions

        // Set the button cursor and action listener
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent evt) {
                  jButton5ActionPerformed(evt);
                }
            });

        // Set a font
        jButton6.setFont(new java.awt.Font("Comic Sans MS", java.awt.Font.BOLD, 16));
        
        // Set a different foreground color
        jButton6.setForeground(new java.awt.Color(64, 64, 64)); // Dark Grey
        
        // Add some padding and round the corners for a cute look
        jButton6.setMargin(new Insets(10, 20, 10, 20));
        
        jButton6.setBorder(BorderFactory.createEmptyBorder());
        BorderFactory.createCompoundBorder(
            BorderFactory.createMatteBorder(5, 15, 5, 15, new Color(255, 105, 180)),
            BorderFactory.createLineBorder(new Color(255, 105, 180), 2)
        );

        // Set a cute and simple cursor
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        // Set the Decode text for the button
        String buttonText1 = "DECODE IMAGE";
        jButton6.setText(buttonText1);

        // Remove the image icon
        jButton6.setIcon(null);

        // Get the width and height of the button (optional)
        jButton6.setPreferredSize(new Dimension(200, 50)); // example dimensions  // example dimensions

        // Set the button cursor and action listener
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
               public void actionPerformed(java.awt.event.ActionEvent evt) {
                      jButton6ActionPerformed(evt);
                    }
                });

        // Set a font for Email
        jButton8.setFont(new java.awt.Font("Comic Sans MS", java.awt.Font.BOLD, 18));
        
        // Set a different foreground color
        jButton8.setForeground(new java.awt.Color(64, 64, 64)); // Dark Grey
        
        // Add some padding and round the corners for a cute look
        jButton8.setMargin(new Insets(10, 20, 10, 20));
        
        jButton8.setBorder(BorderFactory.createEmptyBorder());
        BorderFactory.createCompoundBorder(
            BorderFactory.createMatteBorder(5, 15, 5, 15, new Color(255, 105, 180)),
            BorderFactory.createLineBorder(new Color(255, 105, 180), 2)
        );

        // Set a cute and simple cursor
        jButton8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        

        // Set the Email text for the button
        String buttonText = "EMAIL";
        jButton8.setText(buttonText);

        // Remove the image icon
        jButton8.setIcon(null);

        // Get the width and height of the button (optional)
        jButton8.setPreferredSize(new Dimension(200, 50)); // example dimensions

        // Set the button cursor and action listener
        jButton8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        // Set a font
        jButton9.setFont(new java.awt.Font("Comic Sans MS", java.awt.Font.BOLD, 16));
        
        // Set a different foreground color
        jButton9.setForeground(new java.awt.Color(64, 64, 64)); // Dark Grey

        // Add some padding and round the corners for a cute look
        jButton9.setMargin(new Insets(10, 20, 10, 20));
        
        jButton9.setBorder(BorderFactory.createEmptyBorder());
        BorderFactory.createCompoundBorder(
            BorderFactory.createMatteBorder(15, 15, 15, 15, new Color(255, 105, 180)),
            BorderFactory.createLineBorder(new Color(255, 105, 180), 2)
        );
        // Set a cute and simple cursor
        jButton9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        

        // Set the Encode audio for the button
        String buttonText9 = "ENCODE AUDIO";
        jButton9.setText(buttonText9);

        // Remove the image icon
        jButton9.setIcon(null);

        // Get the width and height of the button (optional)
        jButton9.setPreferredSize(new Dimension(150, 50)); // example dimensions  // example dimensions

        // Set the button cursor and action listener
        jButton9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton9.addActionListener(new java.awt.event.ActionListener() {
           public void actionPerformed(java.awt.event.ActionEvent evt) {
                  jButton9ActionPerformed(evt);
                }
            });

            // Set a font for Decode
        jButton10.setFont(new java.awt.Font("Comic Sans MS", java.awt.Font.BOLD, 16));
        
        // Set a different foreground color
        jButton10.setForeground(new java.awt.Color(64, 64, 64)); // Dark Grey
        
        // Add some padding and round the corners for a cute look
        jButton10.setMargin(new Insets(10, 20, 10, 20));
        
        jButton10.setBorder(BorderFactory.createEmptyBorder());
        BorderFactory.createCompoundBorder(
            BorderFactory.createMatteBorder(5, 15, 5, 15, new Color(255, 105, 180)),
            BorderFactory.createLineBorder(new Color(255, 105, 180), 2)
        );

        // Set a cute and simple cursor
        jButton10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        

        // Set the Decode text for the button
        String buttonText10 = "DECODE AUDIO";
        jButton10.setText(buttonText10);

        // Remove the image icon
        jButton10.setIcon(null);

        // Get the width and height of the button (optional)
        jButton10.setPreferredSize(new Dimension(200, 50)); // example dimensions

        // Set the button cursor and action listener
        jButton10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        
        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(200, 200, 200) // This gap can be adjusted as per the design requirement
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGap(200, 200, 200) // This gap can be adjusted as per the design requirement
                                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(200, 200, 200)) // This gap can be adjusted as per the design requirement
        );

        // Vertical layout
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50) // This gap can be adjusted as per the design requirement
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 150, Short.MAX_VALUE) // This gap can be adjusted as per the design requirement
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseEntered

    }//GEN-LAST:event_jLabel2MouseEntered

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        Encryption a = new Encryption();

        a.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        Decryption a = new Decryption();

        a.setVisible(true);
    }//GEN-LAST:event_jButton6ActionPerformed

     private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        SendEmail se = new SendEmail();
        se.setVisible(true);
        se.setLocationRelativeTo(null);
    }//GEN-LAST:event_jButton8ActionPerformed

        private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        Encode_Audio a = new Encode_Audio();

        a.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        Decode_Audio a = new Decode_Audio();

        a.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    

   

    

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
    
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new HomePage().setVisible(true);
                } catch (MalformedURLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JButton jButton10;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;}
    // End of variables declaration//GEN-END:variables

    