package le.inv.ho.Commands;

import java.util.ArrayList;
import java.util.Map;

import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;

public class CC extends Command {
	
	public CC() {
	    super("cc", "H.ClearChat", new String[] { "clearchat" });
	}
	
	public void execute(CommandSender sender, String[] args) {
		ProxiedPlayer p = (ProxiedPlayer) sender;
		if (p.hasPermission("H.Owner") || p.hasPermission("H.HeadAdmin") || p.hasPermission("H.Admin") || p.hasPermission("H.Developer") || p.hasPermission("H.Special") || p.hasPermission("H.SrMod") || p.hasPermission("H.Mod") || p.hasPermission("H.Helper")) {
			if (args.length == 0) {
					for (ProxiedPlayer all : BungeeCord.getInstance().getServerInfo(p.getServer().getInfo().getName()).getPlayers()) {
						clearChat(p, all);
					}
			} else if (args.length == 1) {
					if (args[0].equalsIgnoreCase("global")) {
						if (p.hasPermission("H.Owner") || p.hasPermission("H.HeadAdmin") || p.hasPermission("H.Admin")) {
							for (ProxiedPlayer all : BungeeCord.getInstance().getPlayers()) {
								clearChat(p, all);
							}
						} else {
		            		p.sendMessage("§8┃ §6HozexMC §8┃ §ethis link should be prntscr or yt");
		            		p.sendMessage("§8┃ §6HozexMC §8┃ §eYou can download lightshot for free from here");
		            		p.sendMessage("§8┃ §6HozexMC §8┃ §eapp.prntscr.com/en/download.html §7[CLICKABLE]");
						}
					} else {
	    				String reason = args[0].toLowerCase();
	    				
	    	            if (args[0].startsWith("prntscr.com/") || args[0].startsWith("prnt.sc/") || args[0].startsWith("prntscr.com/")) {
	    	            	
	    					for (ProxiedPlayer all : BungeeCord.getInstance().getServerInfo(p.getServer().getInfo().getName()).getPlayers()) {
	    						
	    					  	  if (all.hasPermission("H.Owner") || all.hasPermission("H.HeadAdmin") || all.hasPermission("H.Admin") || all.hasPermission("H.Developer") || all.hasPermission("H.Special") || all.hasPermission("H.SrMod") || (all.hasPermission("H.Mod") || all.hasPermission("H.Helper"))) {
	    							  all.sendMessage( new TextComponent( "" ));
	    							  all.sendMessage( new TextComponent( "" ));
	    							  all.sendMessage( new TextComponent( "§8▏ §eHozexMC §8▏ §7The server chat was cleared by §c" + p.getName()));
		  					          all.sendMessage(new TextComponent("§8» §eEvedence:§7 " + reason));
	    						  } else {
	    							  all.sendMessage(new TextComponent("§7§m+§8§m----------§7§m-------------------------------§8§m----------§7+"));
	    					          for (int i = 0; i < 100; i++) {
	    					        	  all.sendMessage( new TextComponent( "" ));
	    					            }
	    							  all.sendMessage( new TextComponent( "§8▏ §eHozexMC §8▏ §7The server chat was cleared by §c" + p.getName()));
	    						  }
	  					}
	    	            	
	    	            } else {
		            		p.sendMessage("§8┃ §6HozexMC §8┃ §ethis link should be prntscr or yt");
		            		p.sendMessage("§8┃ §6HozexMC §8┃ §eYou can download lightshot for free from here");
		            		p.sendMessage("§8┃ §6HozexMC §8┃ §eapp.prntscr.com/en/download.html §7[CLICKABLE]");
						}
					}
			}
		} else {
			p.sendMessage("§8┃ §cHozexMC §8┃ §7Unknown command.");
		}
	}
	
	public void clearChat(ProxiedPlayer by, ProxiedPlayer all) {
  	  if (all.hasPermission("H.Owner") || all.hasPermission("H.HeadAdmin") || all.hasPermission("H.Admin")) {
		  all.sendMessage( new TextComponent( "" ));
		  all.sendMessage( new TextComponent( "" ));
		  all.sendMessage( new TextComponent( "§8▏ §eHozexMC §8▏ §7The server chat was cleared by §c" + by.getName() ));
	  } else if (all.hasPermission("H.Developer") || all.hasPermission("H.Special") || all.hasPermission("H.SrMod") || (all.hasPermission("H.Mod") || all.hasPermission("H.Helper"))) {
		  all.sendMessage( new TextComponent( "" ));
		  all.sendMessage( new TextComponent( "" ));
		  all.sendMessage( new TextComponent( "§8▏ §eHozexMC §8▏ §7The server chat was cleared by §c" + by.getName() ));
	  } else {
		  all.sendMessage(new TextComponent("§7§m+§8§m----------§7§m-------------------------------§8§m----------§7+"));
          for (int i = 0; i < 100; i++) {
        	  all.sendMessage( new TextComponent( "" ));
            }
		  all.sendMessage( new TextComponent( "§8▏ §eHozexMC §8▏ §7The server chat was cleared by §c" + by.getName() ));
	  }
	}

}
