package gameObjects.items;

import extra.Coords;
import gameObjects.GameObj;
import gameObjects.other.Sprite;
import main.MainPanel;

import java.awt.image.BufferedImage;

public abstract class Item extends GameObj {

	protected String ID;
	protected int peso;
	
	public Item(MainPanel mp, String name, String desc, String iD, Coords pos, int peso, Sprite sprites) {
		super(mp,pos);
		this.name = name;
		this.desc = desc;
		ID = iD;
		this.pos = pos;
		this.peso = peso;
		this.sprites = sprites;
	}
	
	public String getName() {
		return name;
	}
	public String getDesc() {
		return desc;
	}
	public String getID() {
		return ID;
	}
	public Coords getPos() {
		return pos;
	}
	public int getPeso() {
		return peso;
	}
	public Sprite getSprites() {
		return sprites;
	}

	
}