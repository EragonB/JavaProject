package FactoryPicture;

import java.awt.Image;

public class MotherTradFactory {
	MotherTrad BackgroundRock = new BackgroundRock();
	MotherTrad Dirt = new Dirt();
	MotherTrad Wall = new Wall();
	MotherTrad Enemy = new Enemy();
	MotherTrad Diamond = new Diamond();
	MotherTrad Stone = new Stone();
	MotherTrad Door = new Door();
	MotherTrad ManUp = new ManUp();
	MotherTrad ManDown = new ManDown();
	MotherTrad ManLeft = new ManLeft();
	MotherTrad ManRight = new ManRight();
	
	
	public Image getPhoto(char Caractere) {
		switch(Caractere) {
		
		case ' ':
			return BackgroundRock.getPicture();
			
		case 'T':
			return Dirt.getPicture();
			
		case 'X':
			return Wall.getPicture();
			
		case 'E':
			return Enemy.getPicture();
			
		case 'D':
			return Diamond.getPicture();
			
		case 'P':
			return Stone.getPicture();
			
		case 'A':
			return Door.getPicture();
			
		case 'O':
			return ManUp.getPicture();
			
		case 'L':
			return ManDown.getPicture();
			
		case 'K':
			return ManLeft.getPicture();
			
		case 'M':
			return ManRight.getPicture();
		}
		return null;
	}

}
