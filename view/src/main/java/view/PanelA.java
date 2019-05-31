package view;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

public class PanelA extends JPanel{


	int MapValue;
	public void paintComponent(Graphics g)
	{
		Image image = null;
		ItemListener a ;
		try {
			image = ImageIO.read(new File("../picture/boulder.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		g.drawImage(image, 0, 0, this);
		
		String[] Map = { "1" , "2" , "3"};
		JComboBox List = new JComboBox(Map);

		List.setSelectedIndex(0);
		List.setBounds(400, 100, 100, 20);
		List.addItemListener(new ItemListener() {

			public void itemStateChanged(ItemEvent e) {
				
				setMap(Integer.valueOf(Map[List.getSelectedIndex()]));
			}
		});
		
		
		JButton buttonNewGame = new JButton("New Game");
		buttonNewGame.setBounds(100, 100, 100, 50);
		buttonNewGame.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("Bonjour");
			}
		});
		
		JButton buttonExit = new JButton("Exit");
		buttonExit.setBounds(100, 400, 100, 50);
		buttonExit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
			
		});
		
		this.add(List);
		this.add(buttonNewGame);
		this.add(buttonExit);
		
	}

	public void setMap(int val)
	{
		this.MapValue = val;
	}

	public int getMap()
	{
		return this.MapValue;
	}
	
	
}
