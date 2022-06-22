package le.inv.ho.Listeners;

import le.inv.ho.Main;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.ChatEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class CommandListener implements Listener {
	
	@EventHandler
	public void onCMD(ChatEvent e) {
		ProxiedPlayer p = (ProxiedPlayer) e.getSender();
		if (p.getServer().getInfo().getName().contains("AuthMe")) {
			if (e.getMessage().startsWith("/l") || e.getMessage().startsWith("/login") || e.getMessage().startsWith("/reg") || e.getMessage().startsWith("/register")) {
				
			} else {
				e.setCancelled(true);
				return;
			}
		}
		if (e.getMessage().startsWith("/")) {
			if ((!p.hasPermission("H.Owner") && !p.hasPermission("H.HeadAdmin") && !p.hasPermission("H.Admin")) || p.getName().equalsIgnoreCase("LondonMama")) {
				if (Main.cmddelay.containsKey(p.getName())) {
					Long delay = Main.cmddelay.get(p.getName());
					if ((System.currentTimeMillis()) <= delay + 1000) {
						e.setCancelled(true);
						p.sendMessage("§8▏ §cHozexMC §8▏ §7You are typing command too fast");
						return;
					} else {
						Main.cmddelay.replace(p.getName(), System.currentTimeMillis());
					}
				} else {
					Main.cmddelay.put(p.getName(), System.currentTimeMillis());
				}
			}
			String msg = e.getMessage();
//			if (msg.contains(":")) {
//				if (p.getServer().getInfo().getName().equals("AuthMe")) {
//					if (!msg.startsWith("/l") && !msg.startsWith("/reg")) {
//						e.setCancelled(true);
//						e.setMessage("");
//						p.sendMessage("§8▏ §cHozexMC §8▏ §7Unknown command.");
//					}
//				}
//				else {
//					if (!e.getMessage().startsWith("/dropitems_v1.2") && !e.getMessage().startsWith("//") && !e.getMessage().startsWith("/msg ") && !e.getMessage().startsWith("/r ") && !e.getMessage().startsWith("/friend ") && !e.getMessage().startsWith("/message ") && !e.getMessage().startsWith("/reply ") && !p.hasPermission("H.Owner") && !p.hasPermission("H.HeadAdmin") && !p.hasPermission("H.Admin")) {
//						e.setCancelled(true);
//						p.sendMessage("§8▏ §cHozexMC §8▏ §7Unknown command.");
//					}
//				}
//			}
		}
	}

}
