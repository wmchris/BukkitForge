package org.bukkit.craftbukkit.entity;


import org.bukkit.Location;
import org.bukkit.craftbukkit.CraftServer;
import org.bukkit.entity.Projectile;
//import org.bukkit.craftbukkit.CraftServer;

public abstract class AbstractProjectile extends CraftEntity implements Projectile {

    private boolean doesBounce;

    public AbstractProjectile(CraftServer server, net.minecraft.entity.Entity entity) {
        super(server, entity);
        doesBounce = false;
    }

    public boolean doesBounce() {
        return doesBounce;
    }

    public void setBounce(boolean doesBounce) {
        this.doesBounce = doesBounce;
    }
    
    @Override
    public Location getLocation() {
    	return new Location(getWorld(), getHandle().posX, getHandle().posY, getHandle().posZ);
    }
    
    public Location getLocation(Location loc) {
    	if (loc == null) return null;
    	loc.setX(getHandle().posX);
    	loc.setY(getHandle().posY);
    	loc.setZ(getHandle().posZ);
    	loc.setWorld(getWorld());
    	return loc;
    }

}
