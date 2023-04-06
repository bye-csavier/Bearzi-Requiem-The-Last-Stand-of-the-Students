import java.awt.*;
import java.util.*;

import main.MainPanel;
import main.game;
import gameObjects.other.Sprite;
import rooms.room;
import rooms.stage;
import rooms.npcs.NPC;

public class Bullet extends GameObj {
	
	public NPC hit()	{
		for( NPC n : mp.game.stage.rooms[mp.game.stage.currentRoom].npcs )	{
			if( this.hitbox.intersects(n.hitbox) )	{
				return n;
			}
		}
		
		return null;
	}
	
	//@Override
	public void update()	{
		if( mp.game.stage.rooms[mp.game.stage.currentRoom].collisionMap[Room.xRelativeToTilemap(this.sprite.pos)][Room.yRelativeToTilemap(this.sprite.pos)] == 1 )	{
			//deallocazione
			return;
		}
		
		for( NPC n : mp.game.stage.rooms[currentRoom].npcs )	{
			if( Room.xRelativeToTilemap(n.sprite.pos) == Room.xRelativeToTilemap(this.sprite.pos) && Room.yRelativeToTilemap(n.sprite.pos) == Room.yRelativeToTilemap(this.sprite.pos) )	{
				//Game.rimuoviOggetto(this);
				return;
			}
		}
	}
	
    abstract public void draw(Graphics2D g2)	{
    	this.sprite.draw(g2);
    }
    
    abstract public void isInsideScreen();
    abstract public void syncCamera();
}
