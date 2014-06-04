package com.massivecraft.lwcfactions;

import com.griefcraft.lwc.LWC;
import com.griefcraft.scripting.JavaModule;
import com.griefcraft.scripting.event.LWCProtectionRegisterEvent;
import com.massivecraft.factions.listeners.FactionsListenerMain;
import com.massivecraft.massivecore.ps.PS;

public class LWCFactionsModule extends JavaModule
{
	/**
	 * The bukkit plugin
	 */
	@SuppressWarnings("unused")
	private LWCFactions plugin;
	
	/**
	 * The LWC object, set by load ()
	 */
	@SuppressWarnings("unused")
	private LWC lwc;

	public LWCFactionsModule(LWCFactions plugin)
	{
		this.plugin = plugin;
	}

	@Override
	public void onRegisterProtection(LWCProtectionRegisterEvent event)
	{
		if (FactionsListenerMain.canPlayerBuildAt(event.getPlayer(), PS.valueOf(event.getBlock()), false)) return;
		event.setCancelled(true);
	}
	
}
