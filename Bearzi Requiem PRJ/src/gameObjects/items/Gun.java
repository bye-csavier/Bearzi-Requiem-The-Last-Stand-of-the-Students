package gameObjects.items;

import extra.Coords;
import gameObjects.other.Sprite;
import main.MainPanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Gun extends Item implements Transportable, Interactable {
	protected int attack;
	protected int magazine;
	protected int ammo;
	protected long fireRate;
	protected long coolDown;
	protected WeaponType type;
	
	
	public Gun(MainPanel mp, String name, String desc, String iD, Coords pos, Sprite sprite, int peso, Sprite sprites, int attack, int magazine, int ammo, long fireRate, long coolDown, WeaponType type) {
		super(mp, name, desc, iD, pos, sprite, peso, sprites);
		this.attack = attack;
		this.magazine = magazine;
		this.ammo = ammo;
		this.fireRate = fireRate;
		this.coolDown = coolDown;
		this.type = type;
	}

	@Override
	public boolean carry( int strength ) {
		if( strength > peso )	{
			return true;
		}		
		return false;
	}

	@Override
	public void interact() {
		// TODO Far sparare l'arma alla pressione del tasto designato con il giusto CD
		
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
