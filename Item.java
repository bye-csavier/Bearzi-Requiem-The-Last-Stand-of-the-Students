import java.awt.image.BufferedImage;

public abstract class Item {
	protected String name;
	protected String desc;
	protected String ID;
	protected Coords pos;
	protected int peso;
	protected BufferedImage[] sprites;
	protected long frameRate;
	
	public Item(String name, String desc, String iD, Coords pos, int peso, BufferedImage[] sprites, long frameRate) {
		super();
		this.name = name;
		this.desc = desc;
		ID = iD;
		this.pos = pos;
		this.peso = peso;
		this.sprites = sprites;
		this.frameRate = frameRate;
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
	public BufferedImage[] getSprites() {
		return sprites;
	}
	public long getFrameRate() {
		return frameRate;
	}
	
}