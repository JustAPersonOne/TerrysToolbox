package terranceyoung.plugin.terrystoolbox;

import org.bukkit.plugin.java.JavaPlugin;
import terranceyoung.plugin.terrystoolbox.commands.SchematicExecutor;
import terranceyoung.plugin.terrystoolbox.commands.ToolboxExecutor;
import terranceyoung.plugin.terrystoolbox.data.DataPlayers;
import terranceyoung.plugin.terrystoolbox.events.onPlayerJoinListener;

public class TerrysToolbox extends JavaPlugin {

    public static TerrysToolbox instance;
    public static DataPlayers playerData;

    @Override
    public void onEnable() {
        instance = this;

        // check if data folder exists, if not create it
        if(!getDataFolder().exists()) {
            getDataFolder().mkdirs();
        }

        // set any data
        playerData = new DataPlayers();

        // set commands
        getCommand("tyatbac").setExecutor(new ToolboxExecutor());
        getCommand("tyschem").setExecutor(new SchematicExecutor());

        // set listeners
        getServer().getPluginManager().registerEvents(new onPlayerJoinListener(), this);
    }

    @Override
    public void onDisable() {
        playerData.save();
        playerData.close();
    }
}
