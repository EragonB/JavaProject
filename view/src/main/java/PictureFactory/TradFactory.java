package PictureFactory;

import java.awt.Image;


public class TradFactory {
	MotherTrad BackGround = new BackGround();
	MotherTrad Dirt = new Dirt();
	MotherTrad Wall = new Wall();
	MotherTrad Enemy = new Enemy();
	MotherTrad Diamond = new Diamond();
	MotherTrad Stone = new Stone();
	MotherTrad ManUp = new ManUp();
	MotherTrad ManDown = new ManDown();
	MotherTrad ManRight = new ManRight();
	MotherTrad ManLeft = new ManLeft();

	
	public Image getPicture(char CharacterMap) {
		switch(CharacterMap)
		{
		case ' ':
			return BackGround.getPicture();
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
