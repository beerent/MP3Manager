import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class window extends JFrame{
	
	private songManager songMan;
	
	public window(){
		songMan = new songManager();
		setTitle("MP3 Manager");
		setSize(500, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);	
		setButtons();
	}
	
	private void setButtons(){
		JButton selectButton = new JButton("Select MP3 Folder");
		selectButton.addActionListener(new ActionListener() {
			 
            public void actionPerformed(ActionEvent e){
            	getMusicFolder();
            }
        });      

		//selectButton.setLayout(null);

		JPanel buttonPane = new JPanel();
		buttonPane.add(selectButton);

        this.getContentPane().add(buttonPane, BorderLayout.NORTH);
        //this.pack();
        this.setLocation(500, 500);
        this.setVisible(true);
	}
	
	private void getMusicFolder(){
		//create input frame
		JFrame musicInputFrame = new JFrame();
		musicInputFrame.setSize(200, 400);
		
		//create text field
		final JTextField musicFolderInput = new JTextField();
		musicInputFrame.getContentPane().add(musicFolderInput);
		
		//create submit button
		JButton submit = new JButton("Submit Folder");
		textReceiver tr = new textReceiver(this, musicFolderInput);
		submit.addActionListener(tr);
		
		musicInputFrame.getContentPane().add(submit);
		
		//display mini frame
		musicInputFrame.setLayout(new GridLayout(2, 1));
		musicInputFrame.pack();
		musicInputFrame.setLocation(550, 550);
		musicInputFrame.setVisible(true);
	}
	
	public void setMP3Folder(String dir){
		this.songMan.setMP3Folder(dir);
	}
	
	public static void main(String[] args) {
		window window = new window();
		window.setVisible(true);
	}

}
