package view;

import java.awt.event.KeyListener;

public class KeyEvent implements KeyListener {

	public KeyEvent() {
		// TODO Auto-generated constructor stub
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
	break;
	
case 's':
	break;
	
case 'q':
break;

case 'd':
	break;
}
	}

}
