package Game.Entities.Statics;

import Game.Items.Item;
import Game.Tiles.Tile;
import Resources.Images;
import Main.Handler;

import javax.sound.sampled.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by Alejandro on 4/29/2018.
 */
public class Bush extends StaticEntity {
	private File audioFile;
	private AudioInputStream audioStream;
	private AudioFormat format;
	private DataLine.Info info;
	private Clip audioClip;

	public Bush(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILEHEIGHT * 2, Tile.TILEWIDTH);
		bounds.x=0;
		bounds.y=50;
		bounds.width = 64;
		bounds.height = 64;
		health=8;

		try {
			audioFile = new File("res/music/Chopping.wav");
			audioStream = AudioSystem.getAudioInputStream(audioFile);
			format = audioStream.getFormat();
			info = new DataLine.Info(Clip.class, format);
			audioClip = (Clip) AudioSystem.getLine(info);
			audioClip.open(audioStream);
			audioClip.setMicrosecondPosition(2000);

		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}

	}


	@Override
	public void tick() {
		if(isBeinghurt()){
			audioClip.start();
		}
		if(!isBeinghurt() && !handler.getKeyManager().attbut){
			audioClip.stop();
		}
		if(!isActive()){
			audioClip.stop();

		}

	}

	@Override
	public void render(Graphics g) {
		renderLife(g);
		g.drawImage(Images.bush[0],(int)(x-handler.getGameCamera().getxOffset()),(int)(y-handler.getGameCamera().getyOffset()),width,height,null);
	}


// TODO : Change woodItem for STICKS!!!
	@Override
	public void die() {
		handler.getWorld().getItemManager().addItem(Item.berry.createNew((int)x + bounds.x,(int)y + bounds.y,1));
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

}
