package map;

import Element.IElement;

public interface IMap {

	int getHeight();

	void setHeight(int height);

	int getWidth();

	void setWidth(int width);

	IElement getOnTheMapXY(int x, int y);

	void setOnTheMapXY(IElement element, int x, int y);

}