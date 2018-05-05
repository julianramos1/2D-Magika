package Game.GameStates;

import Game.Entities.Creatures.Player;
import Game.Entities.Statics.Chest;
import Main.Handler;
import Worlds.BaseWorld;
import Worlds.World1;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by Elemental on 12/10/2016.
 */
public class GameState extends State {
    public GameState(Handler handler){
        super(handler);
        Player player = new Player(handler, 100, 100);
        Chest chest = new Chest(handler, 1000, 0);
        BaseWorld world = new World1(handler, "res/Maps/map1.map", player, chest);
        handler.setWorld(world);
        handler.getWorld().getEntityManager().setPlayer(player);
        handler.getWorld().getEntityManager().setChest(chest);
    }


    @Override
    public void tick() {
        handler.getWorld().tick();
    }

    @Override
    public void render(Graphics g) {
        handler.getWorld().render(g);

    }

}
