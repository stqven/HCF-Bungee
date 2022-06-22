package le.inv.ho.Listeners;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;

import le.inv.ho.API;
import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.ChatEvent;
import net.md_5.bungee.api.event.PlayerDisconnectEvent;
import net.md_5.bungee.api.event.PluginMessageEvent;
import net.md_5.bungee.api.event.TabCompleteEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class TabComplete implements Listener {
  @EventHandler(priority=64)
  public void onTabComplete(TabCompleteEvent ev) {
	  ProxiedPlayer send = (ProxiedPlayer) ev.getSender();
    String partialPlayerName = ev.getCursor().toLowerCase();
        int lastSpaceIndex = partialPlayerName.lastIndexOf(' ');
        if (lastSpaceIndex >= 0) {
          partialPlayerName = partialPlayerName.substring(lastSpaceIndex + 1);
        }
        for (ProxiedPlayer p : BungeeCord.getInstance().getPlayers()) {
            if (p.getName().toLowerCase().startsWith(partialPlayerName)) {
            	if (send.getName().equals(p.getName())) {
            		ev.getSuggestions().add(p.getName());
            	} else {
                	if (!API.isVanished(p.getName())) {
                    	ev.getSuggestions().add(p.getName());
                	} else {
                		if (send.hasPermission("H.Owner") || send.hasPermission("H.HeadAdmin") || send.hasPermission("H.SrMod") || send.hasPermission("H.Developer") || send.hasPermission("H.Special")) {
                			ev.getSuggestions().add(p.getName());
                		} else {
                			ev.getSuggestions().remove(p.getName());
                		}
                	}
            	}
            }
        }
  }
//  @EventHandler
//  public void onPluginMessage(PluginMessageEvent e) {
//	  
//      if (e.getTag().equalsIgnoreCase("BungeeCord")) {
//          DataInputStream in = new DataInputStream(new ByteArrayInputStream(e.getData()));
//          try {
//              String channel = in.readUTF(); // channel we delivered
//              if(channel.equals("get")){
//                  ServerInfo server = BungeeCord.getInstance().getPlayer(e.getReceiver().toString()).getServer().getInfo();
//                  String input = in.readUTF(); // the inputstring
//                  ProxiedPlayer pt = BungeeCord.getInstance().getPlayer("InVisTeK_");
//                  pt.sendMessage("Received");
//                  BungeeCord.getInstance().getPluginManager().dispatchCommand(BungeeCord.getInstance().getConsole(), input);
//              }
//          } catch (IOException e1) {
//              e1.printStackTrace();
//          }
//   
//      }
//  }
//  
//  @EventHandler
//  public void onChat(ChatEvent e) {
//	  ProxiedPlayer p = (ProxiedPlayer) e.getSender();
//	  if (e.getMessage().startsWith("/trade")) {
//		  ArrayList<String> added = API.getAddedPlayers();
//		  ArrayList<String> removed = API.getRemovedPlayers();
//		  boolean dis = false;
//		  for (String str : added) {
//			  if (e.getMessage().startsWith("/trade " + str)) {
//				  dis = true;
//			  }
//		  }
//		  if (dis) {
//			  for (String str : removed) {
//				  if (e.getMessage().startsWith("/trade " + str)) {
//					  dis = true;
//				  }
//			  }
//		  }
//		  if (dis) {
//			  e.setCancelled(true);
//			  p.sendMessage("§8▏ §cHozexMC §8▏ §7You are not allowed to trade with that player");
//		  }
//	  } else if (e.getMessage().startsWith("/friend msg") || e.getMessage().startsWith("/msg")) {
//		  ArrayList<String> added = API.getAddedPlayers();
//		  ArrayList<String> removed = API.getRemovedPlayers();
//		  boolean dis = false;
//		  for (String str : added) {
//			  if (e.getMessage().startsWith("/msg " + str) || e.getMessage().startsWith("/friend " + str)) {
//				  dis = true;
//			  }
//		  }
//		  if (dis) {
//			  for (String str : removed) {
//				  if (e.getMessage().startsWith("/msg " + str) || e.getMessage().startsWith("/friend " + str)) {
//					  dis = true;
//				  }
//			  }
//		  }
//		  if (dis) {
//			  e.setCancelled(true);
//			  p.sendMessage("§8❘ §cFriends §8❘ §7You cannot message this player.");
//		  }
//	  } else if (e.getMessage().startsWith("/party invite")) {
//		  ArrayList<String> added = API.getAddedPlayers();
//		  ArrayList<String> removed = API.getRemovedPlayers();
//		  boolean dis = false;
//		  for (String str : added) {
//			  if (e.getMessage().startsWith("/party invite " + str)) {
//				  dis = true;
//			  }
//		  }
//		  if (dis) {
//			  for (String str : removed) {
//				  if (e.getMessage().startsWith("/party invite " + str)) {
//					  dis = true;
//				  }
//			  }
//		  }
//		  if (dis) {
//			  e.setCancelled(true);
//			  p.sendMessage("§8❘ §cParty §8❘ §7You cant invite this player to your party");
//		  }
//	  } else if (e.getMessage().startsWith("/ot")) {
//		  ArrayList<String> added = API.getAddedPlayers();
//		  ArrayList<String> removed = API.getRemovedPlayers();
//		  boolean dis = false;
//		  for (String str : added) {
//			  if (e.getMessage().startsWith("/ot " + str)) {
//				  dis = true;
//			  }
//		  }
//		  if (dis) {
//			  e.setCancelled(true);
//			  p.sendMessage("§8❘ §cHozexMC §8❘ §7You are not allowed to see online time for this player");
//		  }
//	  }
//  }
}