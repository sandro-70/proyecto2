/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto2;

/**
 *
 * @author ferna
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class Proyecto2{
    public static void main(String[] args) {
        
        JFrame frame = new JFrame("Tablero");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        BufferedImage image = null;
        
        int posiciontablero [][];
        posiciontablero=new int[10][10];
        try {
            image = ImageIO.read(new File("C:\\Users\\ferna\\Downloads\\Tablero.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }

         //Se crea el tamaño de los botones
        int buttonSize = Math.min(image.getWidth() / 10, image.getHeight() / 10);
        
        JPanel panel = new JPanel();
        panel.setLayout(new OverlayLayout(panel));
        Border bordes=LineBorder.createBlackLineBorder();
        

        // Create a transparent overlay panel
        JPanel overlayPanel = new JPanel();
        overlayPanel.setOpaque(false);
        
        
        overlayPanel.setPreferredSize(new Dimension(buttonSize*10,buttonSize*10));
        overlayPanel.setLayout(new GridLayout(10, 10));
        
       
        

        // Creamos los botones del tablero
        for (int i = 1; i <= 100; i++) {
            JButton button = new JButton(" ");
            button.setOpaque(false);
            button.setContentAreaFilled(false);
            button.setBorder(bordes);
            button.setBorderPainted(true);
            
            
            button.setBackground(new Color(0, 0, 0, 0)); // Fully transparent color

            // se asigna el tamaño de los botones
            button.setPreferredSize(new Dimension(buttonSize, buttonSize));

            // Add an ActionListener to the button
            button.addActionListener(new ActionListener() {
                @Override       
                public void actionPerformed(ActionEvent e) {
                    // Perform the desired action when the button is clicked
                    System.out.println("Button clicked");
                }
            });
            
            overlayPanel.add(button);
        }
        

        // Creamos un label con la imagen
        ImageIcon imageIcon = new ImageIcon(image);
        JLabel label = new JLabel(imageIcon);
        
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);

        
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setLayout(new BorderLayout());
        
        layeredPane.add(label, BorderLayout.CENTER);
        overlayPanel.setOpaque(false);
        overlayPanel.setBackground(new Color(0, 0, 0, 0));
        
        layeredPane.add(overlayPanel, BorderLayout.CENTER);
        panel.add(label,BorderLayout.CENTER);
        panel.add(layeredPane, BorderLayout.CENTER);
        
        // Se agrega el panel al frame
        frame.getContentPane().add(panel);
        
        
        frame.setUndecorated(false);
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
    }
}




