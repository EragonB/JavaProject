package view;

import java.awt.event.KeyListener;

import contract.IController;


public class KeyEvent implements KeyListener {
private IController control;
	public KeyEvent(IController controller) {
		// TODO Auto-generated constructor stub
		this.control=controller;
	}

	@Override
	public void keyPressed(java.awt.event.KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(java.awt.event.KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(java.awt.event.KeyEvent arg0) {
		// TODO Auto-generated method stub
char c=arg0.getKeyChar();

switch(c)
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
