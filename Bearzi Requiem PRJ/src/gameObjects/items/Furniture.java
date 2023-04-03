package gameObjects.items;

import extra.Coords;
import gameObjects.other.Sprite;
import main.MainPanel;

import java.awt.*;

import java.awt.image.BufferedImage;

public class Furniture extends Item implements Breakable{

	protected int durability;
	protected Item[] inventory;
	
	public Furniture(MainPanel mp, String name, String desc, String iD, Coords pos, Sprite sprite, int peso, Sprite sprites, int durability, Item[] inventory) {
		super(mp, name, desc, iD, pos, sprite, peso, sprites);
		this.durability = durability;
		this.inventory = inventory;
	}
	
	public int getDurability() {
		return durability;
	}

	public Item[] getInventory() {
		return inventory;
	}

	@Override
	public void destroy( int strength ) {
		if( strength >= 0/*vedremo*/ )	{
			durability = 0;
		}
	}

	@Override
	public void damage( int dmg ) {
		durability -= dmg;
	}

	@Override
	public void draw(Graphics2D g2) {

	}

	@Override
	public void update() {

	}

	@Override
	public boolean isInsideScreen() {
		return true;
	}

	@Override
	public void syncCamera() {

	}
}
