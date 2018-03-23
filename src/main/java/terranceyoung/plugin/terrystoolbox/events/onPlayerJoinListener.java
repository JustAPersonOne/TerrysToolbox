package terranceyoung.plugin.terrystoolbox.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import terranceyoung.plugin.terrystoolbox.TerrysToolbox;

public class onPlayerJoinListener implements Listener {
    @SuppressWarnings("unused")
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        if(!TerrysToolbox.playerData.isPlayerOnDatabase(event.getPlayer().getName())) {
            TerrysToolbox.playerData.addPlayer(event.getPlayer());
        }
    }
}
