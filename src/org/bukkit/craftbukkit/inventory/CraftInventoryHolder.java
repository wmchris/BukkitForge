package org.bukkit.craftbukkit.inventory;

import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;

public class CraftInventoryHolder implements InventoryHolder {

	private Inventory inv;
	
	public CraftInventoryHolder(Inventory inv) {
		this.inv = inv;
	}
	
	@Override
	public Inventory getInventory() {
		return this.inv;
	}

}
