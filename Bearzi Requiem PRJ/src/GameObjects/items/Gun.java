package GameObjects.items;

import GameObjects.items.Item;
import extra.Coords;

import java.awt.image.BufferedImage;

public class Gun extends Item implements Transportable, Interactable {
	protected int attack;
	protected int magazine;
	protected int ammo;
	protected long fireRate;
	protected long coolDown;
	protected WeaponType type;
	
	
	public Gun(String name, String desc, String iD, Coords pos, int peso, BufferedImage[] sprites, long frameRate, int attack, int magazine, int ammo, long fireRate, long coolDown, WeaponType type) {
		super(name, desc, iD, pos, peso, sprites, frameRate);
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

}
