package keepcalm.mods.bukkit.forgeHandler.commands;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;

public abstract class CraftCommandBase extends CommandBase {
	
	public String joinListOfStrings(String[] str) {
		String ret = "";
		for (String j : str) {
			ret += j + " ";
		}
		return ret.trim();
	}
	
	@Override
	public abstract String getCommandName();

	@Override
	public abstract void processCommand(ICommandSender var1, String[] var2);

}
