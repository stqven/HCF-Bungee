package le.inv.ho.Listeners;

import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.ServerKickEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class ServerKick implements Listener {
  @EventHandler(priority=64)
  public void onKick(ServerKickEvent e) {
    ProxiedPlayer p = e.getPlayer();
    if (!e.getKickedFrom().getName().contains("AuthMe")) {
		e.setCancelled(true);
    	if (!e.getKickReason().contains("disconnect.spam") && !e.getKickReason().contains("proxy") ) {
            p.sendMessage("§8▏ §eHozexMC §8▏ §cYou have kicked from " + e.getKickedFrom().getName());
            if (e.getKickReason().toLowerCase().contains("permissions data for your")) {
                p.sendMessage("§8▏ §eHozexMC §8▏ §cReason:§f Please wait.. Server is loading");
            } else {
                p.sendMessage("§8▏ §eHozexMC §8▏ §cReason:§f " + e.getKickReason());
            }
    	}
    }
  }
  
}