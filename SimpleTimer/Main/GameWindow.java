package Main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.Timer;






public class GameWindow extends JFrame {
	//private static final long serialVersionUID = 1L;
	//BufferedImage img, StartWhite, StartYellow;
	



	public GameWindow() {
		
	
        

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        pack();
        this.setLocationRelativeTo( getRootPane());
       
        //img = getImage("/textures/sheets/Clock.png");
        setVisible(true);
        setResizable(false);
        //setIconImage(img);
        
        final Timer timer = new Timer(500, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                 
                     try {
			close();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}}

        });
        timer.start();

       
    }
	
	
	

	private BufferedImage getImage(String filename) {
		// This time, you can use an InputStream to load
		try {
			// Grab the InputStream for the image.
			InputStream in = getClass().getResourceAsStream(filename);
			
			// Then read it in.
			return ImageIO.read(in);
		} catch (IOException e) {
			System.out.println("The image was not loaded.");
			System.exit(1);
		}
		return null;
	}
	
	public void close() throws InterruptedException{
	
		this.dispose();
	}
	

	
}