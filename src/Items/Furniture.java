import java.awt.image.BufferedImage;

public class Furniture extends Item implements Breakable {

	protected int durability;
	protected Item[] inventory;
	
	public Furniture(String name, String desc, String iD, Coords pos, int peso, BufferedImage[] sprites, long frameRate, int durability, Item[] inventory) {
		super(name, desc, iD, pos, peso, sprites, frameRate);
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
		if( strength >= /*vedremo*/ )	{
			durability = 0;
		}
	}

	@Override
	public void damage( int dmg ) {
		durability -= dmg;
	}

}
