package Worlds;
import Game.Entities.Creatures.Player;
import Game.Entities.Creatures.SkelyEnemy;
import Game.Entities.Creatures.Zombie;
import Game.Entities.Statics.Chest;
import Game.Entities.Statics.Door;
import Game.Entities.Statics.Snow;
import Main.Handler;

/**
 * Created by Elemental on 2/10/2017.
 */
public class IceWorld extends BaseWorld{
	private Handler handler;
	private Player player;
	
	public IceWorld(Handler handler, String path, Player player, Chest chest) {
		super(handler,path,player,chest);
		this.handler = handler;
		this.player=player;
		
        entityManager.addEntity(new SkelyEnemy(handler, 1000, 500));
        entityManager.addEntity(new Snow(handler, 300, 500));
        entityManager.addEntity(new Snow(handler, 1000, 400));
        entityManager.addEntity(new Snow(handler, 250, 100));
        entityManager.addEntity(new Snow(handler, 670, 345));
        entityManager.addEntity(new Snow(handler, 730, 200));
        entityManager.addEntity(new Snow(handler, 400, 234));
        entityManager.addEntity(new Snow(handler, 900, 87));

	}

}