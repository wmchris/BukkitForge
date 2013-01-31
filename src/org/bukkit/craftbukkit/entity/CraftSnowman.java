package org.bukkit.craftbukkit.entity;

import net.minecraft.entity.monster.EntitySnowman;

import org.bukkit.craftbukkit.CraftServer;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Snowman;
//import org.bukkit.craftbukkit.CraftServer;

public class CraftSnowman extends CraftGolem implements Snowman {
    public CraftSnowman(CraftServer server, EntitySnowman entity) {
        super(server, entity);
    }

    @Override
    public EntitySnowman getHandle() {
        return (EntitySnowman) entity;
    }

    @Override
    public String toString() {
        return "CraftSnowman";
    }

    public EntityType getType() {
        return EntityType.SNOWMAN;
    }
}
