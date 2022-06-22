package le.inv.ho.Listeners;

import java.util.ArrayList;

import javax.swing.event.ListDataListener;

import le.inv.ho.API;
import le.inv.ho.Main;
import le.inv.ho.msgsql;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.ChatEvent;
import net.md_5.bungee.api.event.ServerConnectEvent;
import net.md_5.bungee.api.event.ServerConnectedEvent;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class PlayerMessagingListener implements Listener {
	
	  @EventHandler
	  public void onRegisterNewJoin(ServerConnectedEvent e) {
		  msgsql.addPlayer(e.getPlayer().getName());
	  }
	  
	  @EventHandler
	  public void onRegisterNewJoin(ServerConnectEvent e) {
		  msgsql.addPlayer(e.getPlayer().getName());
	  }

}
