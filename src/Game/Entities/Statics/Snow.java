package Game.Entities.Statics;

import Game.Items.Item;
import Game.Tiles.Tile;
import Resources.Images;
import Main.Handler;

import javax.sound.sampled.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Random;


public class Snow extends StaticEntity {
	private File audioFile;
	private AudioInputStream audioStream;
	private AudioFormat format;
	private DataLine.Info info;
	private Clip audioClip;
    private Random randint;


	public Snow(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILEHEIGHT, Tile.TILEWIDTH);
		bounds.x=0;
		bounds.y=0; 
		bounds.width = 64;
		bounds.height = 64;
		health=6;
	}

	@Override
	public void render(Graphics g) {
		renderLife(g);
		g.drawImage(Images.snow[0],(int)(x-handler.getGameCamera().getxOffset()),(int)(y-handler.getGameCamera().getyOffset()),width,height,null);
	}


	@Override
	public void die() {
		handler.getWorld().getItemManager().addItem(Item.snowBall.createNew((int)x + bounds.x,(int)y + bounds.y,1));

	}

	public void renderLife(Graphics g) {
		if (beinghurt && count <=8){
			if(count == 8){
				count = 0;
				beinghurt=false;
			}
			if(getHealth()<0){
				g.drawImage(Images.numbers[0],(int)(x-handler.getGameCamera().getxOffset()+bounds.x),(int)(y-handler.getGameCamera().getyOffset()-getHeight()+(bounds.height/3)),42,42,null);
			}	
			else{g.drawImage(Images.numbers[getHealth()],(int)(x-handler.getGameCamera().getxOffset()+bounds.x),(int)(y-handler.getGameCamera().getyOffset()-getHeight()+(bounds.height/3)),42,42,null);
			}
			count++;
		}
	}


	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		
	}

}
