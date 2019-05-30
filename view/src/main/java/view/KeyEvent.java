package view;

import java.awt.event.KeyListener;

import contract.IController;


public class KeyEvent implements KeyListener {
private IController control;
	public KeyEvent(IController controller) {
		this.control=controller;
	}

	@Override
	public void keyPressed(java.awt.event.KeyEvent arg0) {}

	@Override
	public void keyReleased(java.awt.event.KeyEvent arg0) {}

	@Override
	public void keyTyped(java.awt.event.KeyEvent arg0) {
		// TODO Try without control
		char caracterInput=arg0.getKeyChar();
		
		switch(caracterInput)
		{
		case 'z':
			this.control.move(1);
			break;
			
		case 's':
			this.control.move(2);
			break;
			
		case 'q':
			this.control.move(3);
		break;
		
		case 'd':
			this.control.move(4);
			break;
		}
	}
}
