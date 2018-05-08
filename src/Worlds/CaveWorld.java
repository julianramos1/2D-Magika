package Worlds;
import Game.Entities.Creatures.Player;
import Game.Entities.Creatures.Zombie;
import Game.Entities.Statics.CaveDoor;
import Game.Entities.Statics.Chest;
import Game.Entities.Statics.Door;
import Main.Handler;

/**
 * Created by Elemental on 2/10/2017.
 */
public class CaveWorld extends BaseWorld{
	private Handler handler;
	private Player player;
	private Chest chest;
    private BaseWorld iceWorld;
	
	public CaveWorld(Handler handler, String path, Player player, Chest chest) {
		super(handler,path,player,chest);
		this.handler = handler;
		this.player=player;
		this.chest=chest;
        iceWorld = new IceWorld(handler,"res/Maps/finalMap.map",player,chest);
		
        entityManager.addEntity(new Zombie(handler, 1000, 500));
        entityManager.addEntity(new CaveDoor(handler, 100, 0, iceWorld));

	}
}