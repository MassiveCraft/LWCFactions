package com.massivecraft.lwcfactions;

import java.util.logging.Logger;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import com.griefcraft.lwc.LWC;

public class LWCFactions extends JavaPlugin
{
	private Logger logger = Logger.getLogger("LWC-Factions");

	/**
	 * Initialize LWCFactions
	 */
	public void init()
	{
		LWC.getInstance().getModuleLoader()
				.registerModule(this, new LWCFactionsModule(this));
		log("Hooked into LWC!");
	}

	public void onEnable()
	{
		Plugin lwc = getServer().getPluginManager().getPlugin("LWC");

		if (lwc != null)
		{
			init();
		}
		else
		{

			log("Waiting for LWC to be enabled...");
		}
	}

	public void onDisable()
	{

	}

	private void log(String message)
	{
		logger.info("LWC-Factions: " + message);
	}
}