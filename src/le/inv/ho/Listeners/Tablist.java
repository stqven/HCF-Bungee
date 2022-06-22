package le.inv.ho.Listeners;

import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.connection.Server;
import net.md_5.bungee.api.event.ServerConnectEvent;
import net.md_5.bungee.api.event.ServerConnectedEvent;
import net.md_5.bungee.api.event.ServerDisconnectEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.event.EventHandler;

public class Tablist implements Listener {
	
	private Plugin plugin;
	
	public Tablist(Plugin plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onJoin(ServerConnectedEvent e) {
		ProxiedPlayer p = e.getPlayer();
		Server ss = e.getServer();
		rlTablist(p, ss);
	}
	
	@EventHandler
	public void onConnect(ServerConnectEvent e) {
		ProxiedPlayer p = e.getPlayer();
		for (ProxiedPlayer all : BungeeCord.getInstance().getPlayers()) {
			if (all.getName().equals(p.getName())) {
				
			} else {
				rlTablist(all, all.getServer());
			}
		}
	}
	
	@EventHandler
	public void onLeave(ServerDisconnectEvent e) {
		for (ProxiedPlayer all : BungeeCord.getInstance().getPlayers()) {
			rlTablist(all, all.getServer());
		}
	}
	
	public void rlTablist(ProxiedPlayer p, Server ss) {
		TextComponent l1 = new TextComponent("§7\n§ePlay.§6HozexMC§e.Net\n§eOnline Players §8§ §7" + BungeeCord.getInstance().getPlayers().size() + "\n§7");
		TextComponent l2 = new TextComponent("§7\n§eServer §8§ §7" + ss.getInfo().getName() + "\n§7 §eEmail §8§ §7HozexMC@Gmail.com §7\n§e§eWebsite §8§ §7HozexMC.net\n§7");
		p.setTabHeader(l1, l2);
	}
}
