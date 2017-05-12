package gameObjects;

import java.awt.Image;

import gameFileIO.ImageReader;
import utility.Util;

public class Tile extends Entity {

	private int ID;
	public Tile(int tileID) {// should not need to be used - chunk should use its own x/y positioning
		super(0, 0, ImageReader.getImageFromURL(Util.getFileURL("rsc\\tile_"+tileID+".png")));
		this.setID(tileID);
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}


}
