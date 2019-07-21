package terranceyoung.plugin.terrystoolbox.data;

import terranceyoung.plugin.terrystoolbox.TerrysToolbox;
import org.bukkit.entity.Player;

import java.util.UUID;

public class DataPlayers extends Data {
    public DataPlayers() {
        super("players");
    }

    public boolean isPlayerOnDatabase(String name) {
        return getData().has(name);
    }

    public boolean addPlayer(Player player) {
        if (!isPlayerOnDatabase(player.getName())) {
            getData().put(player.getName(), player.getUniqueId());
            save();
            return true;
        } else {
            return false;
        }
    }

    public void addAllOnlinePlayers() {
        Object playerArray[] = TerrysToolbox.instance.getServer().getOnlinePlayers().toArray();
        for (int i = 0; i < playerArray.length; i++) {
            addPlayer((Player) playerArray[i]);
        }
    }

    public UUID getUUIDByPlayerName(String name) {
        return UUID.fromString(getData().get(name).toString());
    }
}
