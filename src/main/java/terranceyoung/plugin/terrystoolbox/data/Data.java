package terranceyoung.plugin.terrystoolbox.data;

import org.bukkit.plugin.java.JavaPlugin;
import terranceyoung.plugin.terrystoolbox.TerrysToolbox;
import terranceyoung.plugin.terrystoolbox.data.json.*;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public abstract class Data {

    private JSONObject data;

    private FileReader reader;
    private FileWriter writer;

    private File dataFile;

    public Data(JavaPlugin plugin, String name, String ext) {
        dataFile = new File(plugin.getDataFolder(), name + ext);
        fileExists(dataFile);

        try {
            reader = new FileReader(dataFile);
            writer = new FileWriter(dataFile);
        } catch (Exception e){
            e.printStackTrace();
        }

        save();
    }

    public Data(String name, String ext) {
        this(TerrysToolbox.instance, name, ext);
    }

    public Data(JavaPlugin plugin, String name) {
        this(plugin, name, ".json");
    }

    public Data(String name) {
        this(TerrysToolbox.instance, name);
    }

    public JSONObject getData() {
        return data;
    }

    public boolean save() {
        try {
            writer = new FileWriter(dataFile);
            writer.write(data.toString());
            writer.flush();
            writer.close();
            return true;
        } catch(Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean load() {
        try {
            Scanner sc = new Scanner(dataFile).useDelimiter("\\Z");
            data = new JSONObject(sc.next());
            sc.close();
            return true;
        } catch(Exception e) {
            data = new JSONObject();
            return false;
        }
    }

    public boolean fileExists(File file) {
        if ( !(file.exists()) ) {
            try {
                file.createNewFile();
                data = new JSONObject();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return false;
        } else {
            load();
            return true;
        }
    }

    public void close() {
        try {
            writer.close();
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
