import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
public class textReceiver implements ActionListener{
	
	private JTextField jtf;
	private window window;
	public textReceiver(window window, JTextField jtf){
		this.jtf = jtf;
		this.window = window;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(this.jtf.getText());
		this.window.setMP3Folder(this.jtf.getText());
	}
	
	public String getText(){
		return this.jtf.getText();
	}
}
