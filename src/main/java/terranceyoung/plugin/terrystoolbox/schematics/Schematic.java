package terranceyoung.plugin.terrystoolbox.schematics;

import org.bukkit.Location;
import terranceyoung.plugin.terrystoolbox.data.Data;

public class Schematic extends Data {

    Location origin;

    public Schematic(String name) {
        super(name, ".tyschem");
    }
}
