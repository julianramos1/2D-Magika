package Worlds;
import com.sun.glass.events.KeyEvent;

import Game.Entities.Creatures.Player;
import Game.Entities.Creatures.Zombie;
import Game.Entities.Statics.CaveDoor;
import Game.Entities.Statics.Chest;
import Game.Entities.Statics.Door;
import Game.Entities.Statics.IceChest;
import Game.Entities.Statics.Rock;
import Main.Handler;

/**
 * Created by Elemental on 2/10/2017.
 */
public class CaveWorld extends BaseWorld{
	private Handler handler;
	private Player player;
	private Chest iceChest;
    private BaseWorld iceWorld;
	
	public CaveWorld(Handler handler, String path, Player player, Chest chest) {
		super(handler,path,player,chest);
		this.handler = handler;
		this.player=player;
		iceChest = new IceChest(handler, 1300, 0);
        iceWorld = new IceWorld(handler,"res/Maps/finalMap.map",player,iceChest);
		
        entityManager.addEntity(new Zombie(handler, 1000, 500));
        entityManager.addEntity(new CaveDoor(handler, 100, 0, iceWorld));
        entityManager.addEntity(new Rock(handler, 100, 450));
        entityManager.addEntity(new Rock(handler, 167, 234));
        entityManager.addEntity(new Rock(handler, 675, 123));
        entityManager.addEntity(new Rock(handler, 229, 800));
        entityManager.addEntity(new Rock(handler, 100, 1000));
        entityManager.addEntity(new Rock(handler, 667, 109));
        entityManager.addEntity(new Rock(handler, 768, 563));
        entityManager.addEntity(new Rock(handler, 90, 670));
        entityManager.addEntity(new Rock(handler, 456, 800));
        entityManager.addEntity(new Rock(handler, 78, 900));
        entityManager.addEntity(new Rock(handler, 700, 850));
        entityManager.addEntity(new Rock(handler, 65, 1234));
        entityManager.addEntity(new Rock(handler, 200, 1000));
        entityManager.addEntity(new Rock(handler, 300, 699));
        entityManager.addEntity(new Rock(handler, 888, 1000));
        entityManager.addEntity(new Rock(handler, 768, 900));
        entityManager.addEntity(new Rock(handler, 809, 800));
        entityManager.addEntity(new Rock(handler, 980, 645));
        entityManager.addEntity(new Rock(handler, 1200, 1200));
        entityManager.addEntity(new Rock(handler, 1000, 333));
        entityManager.addEntity(new Rock(handler, 222, 988));
        entityManager.addEntity(new Rock(handler, 345, 900));
        entityManager.addEntity(new Rock(handler, 789, 600));
        entityManager.addEntity(new Rock(handler, 650, 877));
        entityManager.addEntity(new Rock(handler, 666, 990));
        entityManager.addEntity(new Rock(handler, 809, 800));
        entityManager.addEntity(new Rock(handler, 999, 645));
        entityManager.addEntity(new Rock(handler, 1100, 800));


	}
	@Override
	public void tick() {
		// TODO Auto-generated method stub
		super.tick();
		if(handler.getKeyManager().keyJustPressed(KeyEvent.VK_N)){
			BaseWorld iceWorld = new IceWorld(handler,"res/Maps/finalMap.map",handler.getWorld().getEntityManager().getPlayer(), iceChest);
			handler.setWorld(iceWorld);
		}
	}
}