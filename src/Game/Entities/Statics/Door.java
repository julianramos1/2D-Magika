package Game.Entities.Statics;

import Game.Entities.Creatures.Player;
import Game.GameStates.State;
import Game.Items.Item;
import Main.Handler;
import Resources.Images;
import Worlds.BaseWorld;

import java.awt.*;

import com.sun.beans.editors.BooleanEditor;

/**
 * Created by Elemental on 2/2/2017.
 */


public class Door extends StaticEntity {

	private Rectangle ir = new Rectangle();
	public Boolean EP = false;
	public Boolean bone = false;

	private BaseWorld world;

	public Door(Handler handler, float x, float y,BaseWorld world) {
		super(handler, x, y, 64, 100);
		this.world=world;
		health=10000000;
		bounds.x=0;
		bounds.y=0;
		bounds.width = 100;
		bounds.height = 64;

		ir.width = bounds.width;
		ir.height = bounds.height;
		int irx=(int)(bounds.x-handler.getGameCamera().getxOffset()+x);
		int iry= (int)(bounds.y-handler.getGameCamera().getyOffset()+height);
		ir.y=iry;
		ir.x=irx;
	}

	@Override
	public void tick() {

		if(isBeinghurt()){
			setHealth(10000000);
		}
		//This is where the condition to put the door invisible should work.
		//TODO
		if(handler.getKeyManager().attbut){
			EP=true;

		}else if(!handler.getKeyManager().attbut){
			EP=false;
		}

	} 

	@Override
	public void render(Graphics g) {
		for (Item i : handler.getWorld().getEntityManager().getPlayer().getInventory().getInventoryItems() ) {
			if (i.getName() == "Bone" && i.getCount() == 1) {
				bone = true;
			}
		}
		for (Item j : handler.getWorld().getEntityManager().getPlayer().getInventory().getInventoryItems() ) {
			if ((j.getName() == "Stick" && j.getCount() >= 3) && bone == true) {
				g.drawImage(Images.door,(int)(x-handler.getGameCamera().getxOffset()),(int)(y-handler.getGameCamera().getyOffset()),width,height,null);
				g.setColor(Color.black);
				checkForPlayer(g, handler.getWorld().getEntityManager().getPlayer());

			}
			return;
		}

	}

	private void checkForPlayer(Graphics g, Player p) {
		Rectangle pr = p.getCollisionBounds(0,0);

		if(ir.contains(pr) && !EP){
			g.drawImage(Images.E,(int) x+width,(int) y+10,32,32,null);
		}else if(ir.contains(pr) && EP){
			g.drawImage(Images.EP,(int) x+width,(int) y+10,32,32,null);
			g.drawImage(Images.loading,0,0,800,600,null);
			handler.setWorld(world);

		}


	}

	@Override
	public void die() {

	}
}
