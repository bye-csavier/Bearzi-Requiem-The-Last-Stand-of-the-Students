package gameObjects.items;

import extra.Coords;
import gameObjects.GameObj;
import gameObjects.other.Sprite;
import main.MainPanel;

public abstract class Item extends GameObj {

	protected String ID;
	protected int peso;
	
	public Item(MainPanel mp, String name, String desc, String iD, Coords pos, Sprite sprite, int peso, Sprite sprites) {
		super(mp,pos,sprite);
		this.name = name;
		this.desc = desc;
		ID = iD;
		this.sprite.pos = pos;
		this.peso = peso;
		this.sprite = sprites;
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
		return sprite.pos;
	}
	public int getPeso() {
		return peso;
	}
	public Sprite getSprite() {
		return sprite;
	}

	
}