package Game.Entities.Statics;

import Game.Entities.EntityBase;
import Game.Entities.EntityManager;
import Game.Entities.Creatures.Player;
import Game.GameStates.State;
import Game.Inventories.Inventory;
import Game.Items.Item;
import Game.Tiles.Tile;
import Main.Handler;
import Resources.Images;
import Worlds.BaseWorld;
import Worlds.CaveWorld;

import java.awt.*;

import javax.swing.JOptionPane;

import com.sun.corba.se.spi.activation.InitialNameServiceOperations;
import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * Created by Elemental on 2/2/2017.
 */


public class Chest extends StaticEntity {

	public Rectangle ir = new Rectangle();
	public Boolean EP = false;
	private Inventory chestInventory;
	protected EntityManager entityManager;
	private BaseWorld caveWorld;
	public boolean isOpen = false;

	public Chest(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT);
		health=10000000;
		bounds.x=0;
		bounds.y=0;
		bounds.width = 68;
		bounds.height = 64;

		ir.width = bounds.width;
		ir.height = bounds.height;
		int irx=(int)(bounds.x-handler.getGameCamera().getxOffset()+x);
		int iry= (int)(bounds.y-handler.getGameCamera().getyOffset()+height);
		ir.y=iry;
		ir.x=irx;

		chestInventory = new Inventory(handler);
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
		if(handler.getKeyManager().attbut && ir.contains(handler.getWorld().getEntityManager().getPlayer().getCollisionBounds(0,0))) {
			for (Item i : handler.getWorld().getEntityManager().getPlayer().getInventory().getInventoryItems() ) {
				if (i.getName() == "Stick" && i.getCount() >= 1) {
					for (int j = 0; j <= i.getCount(); j++) {
						chestInventory.addItem(Item.stick);
						i.setCount(i.getCount() - 1);
						System.out.println("Added stick to chest");
					}
					
				}
			}
			for (Item j : handler.getWorld().getEntityManager().getPlayer().getInventory().getInventoryItems() ) {
				if (j.getName() == "Bone" && j.getCount() == 1) {
					chestInventory.addItem(Item.bone);
					System.out.println("Added bone to chest");
					j.setCount(j.getCount() - 1);
				}
			}
		}
		chestInventory.tick();

	}
	
	// TODO Terminar de fix el chest hoy during the day !!!
	
	@Override
	public void render(Graphics g) {
		caveWorld = new CaveWorld(handler,"res/Maps/caveMap.map",handler.getWorld().getEntityManager().getPlayer(), handler.getWorld().getEntityManager().getChest());
		if(handler.getKeyManager().attbut && ir.contains(handler.getWorld().getEntityManager().getPlayer().getCollisionBounds(0,0)) || isOpen == true) {
			isOpen = true;
			g.drawImage(Images.chest[1],(int)(x-handler.getGameCamera().getxOffset()),(int)(y-handler.getGameCamera().getyOffset()),width,height,null);
			g.drawImage(Images.requirements,(int)((x+70)-handler.getGameCamera().getxOffset()),(int)(y-handler.getGameCamera().getyOffset()),width,height,null);
		}
		
		else {
			g.drawImage(Images.chest[0],(int)(x-handler.getGameCamera().getxOffset()),(int)(y-handler.getGameCamera().getyOffset()),width,height,null);
		}
		g.setColor(Color.black);
		checkForPlayer(g, handler.getWorld().getEntityManager().getPlayer());
	}

	private void checkForPlayer(Graphics g, Player p) {
		Rectangle pr = p.getCollisionBounds(0,0);

		if(ir.contains(pr) && !EP){
			g.drawImage(Images.E,(int) x+width,(int) y+10,32,32,null);
		}else if(ir.contains(pr) && EP){
			g.drawImage(Images.EP,(int) x+width,(int) y+10,32,32,null);

		}


	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	@Override
	public void die() {

	}
	public Inventory getChestInventory() {
		return chestInventory;
	}
}
