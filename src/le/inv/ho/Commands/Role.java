package le.inv.ho.Commands;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import le.inv.ho.API;
import le.inv.ho.Main;
import me.lucko.luckperms.LuckPerms;
import me.lucko.luckperms.api.LuckPermsApi;
import me.lucko.luckperms.api.Node;
import me.lucko.luckperms.common.node.factory.NodeBuilder;
import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;

public class Role extends Command {
	private Main bcb;
	
	public Role() {
		super("Role");
		this.bcb = bcb;
	}

	@Override
	public void execute(CommandSender sender, String[] args) {
		ProxiedPlayer p = (ProxiedPlayer) sender;
	      if (p.hasPermission("H.Owner") || p.hasPermission("H.HeadAdmin") || p.hasPermission("H.Admin")) {
  	        if (args.length == 0) {
  	        	p.sendMessage("" + LuckPerms.getApi().getUser(p.getName()).getTemporaryPermissionNodes());
  	            p.sendMessage("§8┃ §cHozexMC §8┃ §7/Role <player> <rank>");
  	            p.sendMessage("§8┃ §cHozexMC §8┃ §7/Role <player1> to <player2>");
  	        } else if (args.length == 1) {
	              p.sendMessage("§8§m=------------------------------==");
	    	      if (p.hasPermission("H.Owner") || p.hasPermission("H.HeadAdmin") || p.hasPermission("H.Admin")) {
	      	        p.sendMessage(API.getHoverClickRunCommandMessage("§b➥ §cMod", "§eSet §6" + args[0] + "'s §erank to Mod", "setrank " + args[0] + " mod"));
	      	        p.sendMessage(API.getHoverClickRunCommandMessage("§b➥ §3Helper", "§eSet §6" + args[0] + "'s §erank to Helper", "setrank " + args[0] + " helper"));
	        	        p.sendMessage(API.getHoverClickRunCommandMessage("§b➥ §2Builder", "§eSet §6" + args[0] + "'s §erank to Builder", "setrank " + args[0] + " builder"));
	    	            p.sendMessage(API.getHoverClickRunCommandMessage("§b➥ §5VIP", "§eSet §6" + args[0] + "'s §erank to VIP", "setrank " + args[0] + " VIP"));
	    	            p.sendMessage(API.getHoverClickRunCommandMessage("§b➥ §aEmerald", "§eSet §6" + args[0] + "'s §erank to Emerald", "setrank " + args[0] + " emerald"));
	    	            p.sendMessage(API.getHoverClickRunCommandMessage("§b➥ §bDiamond", "§eSet §6" + args[0] + "'s §erank to Diamond", "setrank " + args[0] + " diamond"));
	    	            p.sendMessage(API.getHoverClickRunCommandMessage("§b➥ §6Gold", "§eSet §6" + args[0] + "'s §erank to Gold", "setrank " + args[0] + " gold"));
	    	            p.sendMessage(API.getHoverClickRunCommandMessage("§b➥ §5YouTuber", "§eSet §6" + args[0] + "'s §erank to YouTuber", "setrank " + args[0] + " youtuber"));
	    	            p.sendMessage(API.getHoverClickRunCommandMessage("§b➥ §7Default", "§eSet §6" + args[0] + "'s §erank to Default", "setrank " + args[0] + " default"));
	              }
	              p.sendMessage("§8§m=------------------------------==");
	  	          p.sendMessage("§8┃ §cHozexMC §8┃ §7/Role <player> <rank>");
	  	          p.sendMessage("§8┃ §cHozexMC §8┃ §7/Role <player1> to <player2>");
  	        } else if (args.length == 2) {
  	        	if (args[1].equalsIgnoreCase("to")) {
  	  	          p.sendMessage("§8┃ §cHozexMC §8┃ §7/Role <player1> to <player2>");
  	        	} else {
  	  	        	ProxiedPlayer t = BungeeCord.getInstance().getPlayer(args[0]);
  	  	          if (args[1].equalsIgnoreCase("Moderator") || args[1].contains("Mod")) {
  	  	        	  ProxyServer.getInstance().getPluginManager().dispatchCommand(ProxyServer.getInstance().getConsole(), "lpb user " + args[0] + " group set Mod");
  	  	        	  ProxyServer.getInstance().getPluginManager().dispatchCommand(ProxyServer.getInstance().getConsole(), "lpb user " + args[0] + " sync");
  	  	        	  ProxyServer.getInstance().getPluginManager().dispatchCommand(ProxyServer.getInstance().getConsole(), "lpb user " + args[0] + " networksync");
  	  	        	  if (t != null) {
  	  	  	            t.sendMessage("§eYou have recived §cMod §eRank");
  	  	        	  }
  		  	            p.sendMessage("§8┃ §aHozexMC §8┃ §7You have set §6" + API.getP(args[0]) + "§7's rank to §cMod");
  		  	            for (ProxiedPlayer admins : BungeeCord.getInstance().getPlayers()) {
  		  	            	if (admins.getName().equals(p.getName())) {
  		  	            		
  		  	            	} else {
  			  	            	if (admins.hasPermission("H.Owner") || admins.hasPermission("H.HeadAdmin") || admins.hasPermission("H.Admin")) {
  			  	            		admins.sendMessage("§8┃ §eHozexMC §8┃ §7" + API.getP(p.getName()) + " §7has given §6" + args[0] + " §cMod");
  			  	            	}
  		  	            	}
  		  	            }
  	  	          } else if (args[1].equalsIgnoreCase("VIP")) {
  	 	        	  ProxyServer.getInstance().getPluginManager().dispatchCommand(ProxyServer.getInstance().getConsole(), "lpb user " + args[0] + " group set VIP");
  	  	        	  ProxyServer.getInstance().getPluginManager().dispatchCommand(ProxyServer.getInstance().getConsole(), "lpb user " + args[0] + " sync");
  	  	        	  ProxyServer.getInstance().getPluginManager().dispatchCommand(ProxyServer.getInstance().getConsole(), "lpb user " + args[0] + " networksync");
  	  	        	  if (t != null) {
  	  	  	            t.sendMessage("§eYou have recived §5VIP §eRank");
  	  	        	  }
  		  	            p.sendMessage("§8┃ §aHozexMC §8┃ §7You have set §6" + API.getP(args[0]) + "§7's rank to §5VIP");
  		  	            for (ProxiedPlayer admins : BungeeCord.getInstance().getPlayers()) {
  		  	            	if (admins.getName().equals(p.getName())) {
  		  	            		
  		  	            	} else {
  			  	            	if (admins.hasPermission("H.Owner") || admins.hasPermission("H.HeadAdmin") || admins.hasPermission("H.Admin")) {
  			  	            		admins.sendMessage("§8┃ §eHozexMC §8┃ §7" + API.getP(p.getName()) + " §7has given §6" + args[0] + " §5VIP");
  			  	            	}
  		  	            	}
  		  	            }
  	  	          } else if (args[1].equalsIgnoreCase("Helper") || args[1].contains("Help")) {
  	 	        	  ProxyServer.getInstance().getPluginManager().dispatchCommand(ProxyServer.getInstance().getConsole(), "lpb user " + args[0] + " group set Helper");
  	  	        	  ProxyServer.getInstance().getPluginManager().dispatchCommand(ProxyServer.getInstance().getConsole(), "lpb user " + args[0] + " sync");
  	  	        	  ProxyServer.getInstance().getPluginManager().dispatchCommand(ProxyServer.getInstance().getConsole(), "lpb user " + args[0] + " networksync");
  	  	        	  if (t != null) {
  	  	  	            t.sendMessage("§eYou have recived §3Helper §eRank");
  	  	        	  }
  		  	            p.sendMessage("§8┃ §aHozexMC §8┃ §7You have set §6" + API.getP(args[0]) + "§7's rank to §3Helper");
  		  	            for (ProxiedPlayer admins : BungeeCord.getInstance().getPlayers()) {
  		  	            	if (admins.getName().equals(p.getName())) {
  		  	            		
  		  	            	} else {
  			  	            	if (admins.hasPermission("H.Owner") || admins.hasPermission("H.HeadAdmin") || admins.hasPermission("H.Admin")) {
  			  	            		admins.sendMessage("§8┃ §eHozexMC §8┃ §7" + API.getP(p.getName()) + " §7has given §6" + args[0] + " §3Helper");
  			  	            	}
  		  	            	}
  		  	            }
  	  	          } else if (args[1].equalsIgnoreCase("Builder") || args[1].contains("Build")) {
  	 	        	  ProxyServer.getInstance().getPluginManager().dispatchCommand(ProxyServer.getInstance().getConsole(), "lpb user " + args[0] + " group set Builder");
  	  	        	  ProxyServer.getInstance().getPluginManager().dispatchCommand(ProxyServer.getInstance().getConsole(), "lpb user " + args[0] + " sync");
  	  	        	  ProxyServer.getInstance().getPluginManager().dispatchCommand(ProxyServer.getInstance().getConsole(), "lpb user " + args[0] + " networksync");
  	  	        	  if (t != null) {
  	  	  	            t.sendMessage("§eYou have recived §2Builder §eRank");
  	  	        	  }
  		  	            p.sendMessage("§8┃ §aHozexMC §8┃ §7You have set §6" + API.getP(args[0]) + "§7's rank to §2Builder");
  		  	            for (ProxiedPlayer admins : BungeeCord.getInstance().getPlayers()) {
  		  	            	if (admins.getName().equals(p.getName())) {
  		  	            		
  		  	            	} else {
  			  	            	if (admins.hasPermission("H.Owner") || admins.hasPermission("H.HeadAdmin") || admins.hasPermission("H.Admin")) {
  			  	            		admins.sendMessage("§8┃ §eHozexMC §8┃ §7" + API.getP(p.getName()) + " §7has given §6" + args[0] + " §2Builder");
  			  	            	}
  		  	            	}
  		  	            }
  	  	          } else if (args[1].equalsIgnoreCase("Emerald") || args[1].contains("Eme")) {
  	 	        	  ProxyServer.getInstance().getPluginManager().dispatchCommand(ProxyServer.getInstance().getConsole(), "lpb user " + args[0] + " group set Emerald");
  	  	        	  ProxyServer.getInstance().getPluginManager().dispatchCommand(ProxyServer.getInstance().getConsole(), "lpb user " + args[0] + " sync");
  	  	        	  ProxyServer.getInstance().getPluginManager().dispatchCommand(ProxyServer.getInstance().getConsole(), "lpb user " + args[0] + " networksync");
  	  	        	  if (t != null) {
  	  	  	            t.sendMessage("§eYou have recived §aEmerald §eRank");
  	  	        	  }
  		  	            p.sendMessage("§8┃ §aHozexMC §8┃ §7You have set §6" + API.getP(args[0]) + "§7's rank to §aEmerald");
  		  	            for (ProxiedPlayer admins : BungeeCord.getInstance().getPlayers()) {
  		  	            	if (admins.getName().equals(p.getName())) {
  		  	            		
  		  	            	} else {
  			  	            	if (admins.hasPermission("H.Owner") || admins.hasPermission("H.HeadAdmin") || admins.hasPermission("H.Admin")) {
  			  	            		admins.sendMessage("§8┃ §eHozexMC §8┃ §7" + API.getP(p.getName()) + " §7has given §6" + args[0] + " §aEmerald");
  			  	            	}
  		  	            	}
  		  	            }
  	  	          } else if (args[1].equalsIgnoreCase("Diamond") || args[1].contains("Dia")) {
  	 	        	  ProxyServer.getInstance().getPluginManager().dispatchCommand(ProxyServer.getInstance().getConsole(), "lpb user " + args[0] + " group set Diamond");
  	  	        	  ProxyServer.getInstance().getPluginManager().dispatchCommand(ProxyServer.getInstance().getConsole(), "lpb user " + args[0] + " sync");
  	  	        	  ProxyServer.getInstance().getPluginManager().dispatchCommand(ProxyServer.getInstance().getConsole(), "lpb user " + args[0] + " networksync");
  	  	        	  if (t != null) {
  	  	  	            t.sendMessage("§eYou have recived §bDiamond §eRank");
  	  	        	  }
  		  	            p.sendMessage("§8┃ §aHozexMC §8┃ §7You have set §6" + API.getP(args[0]) + "§7's rank to §bDiamond");
  		  	            for (ProxiedPlayer admins : BungeeCord.getInstance().getPlayers()) {
  		  	            	if (admins.getName().equals(p.getName())) {
  		  	            		
  		  	            	} else {
  			  	            	if (admins.hasPermission("H.Owner") || admins.hasPermission("H.HeadAdmin") || admins.hasPermission("H.Admin")) {
  			  	            		admins.sendMessage("§8┃ §eHozexMC §8┃ §7" + API.getP(p.getName()) + " §7has given §6" + args[0] + " §bDiamond");
  			  	            	}
  		  	            	}
  		  	            }
  	  	          } else if (args[1].equalsIgnoreCase("Gold") || args[1].contains("Go")) {
  	 	        	  ProxyServer.getInstance().getPluginManager().dispatchCommand(ProxyServer.getInstance().getConsole(), "lpb user " + args[0] + " group set Gold");
  	  	        	  ProxyServer.getInstance().getPluginManager().dispatchCommand(ProxyServer.getInstance().getConsole(), "lpb user " + args[0] + " sync");
  	  	        	  ProxyServer.getInstance().getPluginManager().dispatchCommand(ProxyServer.getInstance().getConsole(), "lpb user " + args[0] + " networksync");
  	  	        	  if (t != null) {
  	  	  	            t.sendMessage("§eYou have recived §6Gold §eRank");
  	  	        	  }
  		  	            p.sendMessage("§8┃ §aHozexMC §8┃ §7You have set §6" + API.getP(args[0]) + "§7's rank to §6Gold");
  		  	            for (ProxiedPlayer admins : BungeeCord.getInstance().getPlayers()) {
  		  	            	if (admins.getName().equals(p.getName())) {
  		  	            		
  		  	            	} else {
  			  	            	if (admins.hasPermission("H.Owner") || admins.hasPermission("H.HeadAdmin") || admins.hasPermission("H.Admin")) {
  			  	            		admins.sendMessage("§8┃ §eHozexMC §8┃ §7" + API.getP(p.getName()) + " §7has given §6" + args[0] + "§6Gold");
  			  	            	}
  		  	            	}
  		  	            }
  	  	          } else if (args[1].equalsIgnoreCase("YouTuber") || args[1].contains("You")) {
  	 	        	  ProxyServer.getInstance().getPluginManager().dispatchCommand(ProxyServer.getInstance().getConsole(), "lpb user " + args[0] + " group set YouTuber");
  	  	        	  ProxyServer.getInstance().getPluginManager().dispatchCommand(ProxyServer.getInstance().getConsole(), "lpb user " + args[0] + " sync");
  	  	        	  ProxyServer.getInstance().getPluginManager().dispatchCommand(ProxyServer.getInstance().getConsole(), "lpb user " + args[0] + " networksync");
  	  	        	  if (t != null) {
  	  	  	            t.sendMessage("§eYou have recived §5YouTuber §eRank");
  	  	        	  }
  		  	            p.sendMessage("§8┃ §aHozexMC §8┃ §7You have set §6" + API.getP(args[0]) + "§7's rank to §5YouTuber");
  		  	            for (ProxiedPlayer admins : BungeeCord.getInstance().getPlayers()) {
  		  	            	if (admins.getName().equals(p.getName())) {
  		  	            		
  		  	            	} else {
  			  	            	if (admins.hasPermission("H.Owner") || admins.hasPermission("H.HeadAdmin") || admins.hasPermission("H.Admin")) {
  			  	            		admins.sendMessage("§8┃ §eHozexMC §8┃ §7" + API.getP(p.getName()) + " §7has given §6" + args[0] + "§5YouTuber");
  			  	            	}
  		  	            	}
  		  	            }
  	  	          } else if (args[1].equalsIgnoreCase("Default") || args[1].equalsIgnoreCase("Member") || args[1].contains("Reset") || args[1].contains("Def") || args[1].contains("Mem")) {
  	 	        	  ProxyServer.getInstance().getPluginManager().dispatchCommand(ProxyServer.getInstance().getConsole(), "lpb user " + args[0] + " clear");
  	 	        	  ProxyServer.getInstance().getPluginManager().dispatchCommand(ProxyServer.getInstance().getConsole(), "lpb user " + args[0] + " group set Default");
  	  	        	  ProxyServer.getInstance().getPluginManager().dispatchCommand(ProxyServer.getInstance().getConsole(), "lpb user " + args[0] + " sync");
  	  	        	  ProxyServer.getInstance().getPluginManager().dispatchCommand(ProxyServer.getInstance().getConsole(), "lpb user " + args[0] + " networksync");
  	  	        	  if (t != null) {
  	  	  	            t.sendMessage("§eYou have recived §7Default §eRank");
  	  	        	  }
  		  	            p.sendMessage("§8┃ §aHozexMC §8┃ §7You have set §6" + API.getP(args[0]) + "§7's rank to §7Default");
  		  	            for (ProxiedPlayer admins : BungeeCord.getInstance().getPlayers()) {
  		  	            	if (admins.hasPermission("H.Owner") || admins.hasPermission("H.HeadAdmin") || admins.hasPermission("H.Admin")) {
  		  	            		admins.sendMessage("§8┃ §eHozexMC §8┃ §7" + API.getP(p.getName()) + " §7has given §6" + args[0] + " §7Default");
  		  	            	}
  		  	            }
  	  	          } else {
  	  	          	
  	  	              p.sendMessage("§8§m=------------------------------==");
  	  	              if (p.hasPermission("H.Owner") || p.hasPermission("H.Admin") || p.hasPermission("H.Manager")) {
  	  	      	        p.sendMessage(API.getHoverClickRunCommandMessage("§b➥ §cMod", "§eSet §6" + args[0] + "'s §erank to Mod", "setrank " + args[0] + " mod"));
  	  	      	        p.sendMessage(API.getHoverClickRunCommandMessage("§b➥ §3Helper", "§eSet §6" + args[0] + "'s §erank to Helper", "setrank " + args[0] + " helper"));
  	  	        	        p.sendMessage(API.getHoverClickRunCommandMessage("§b➥ §2Builder", "§eSet §6" + args[0] + "'s §erank to Builder", "setrank " + args[0] + " builder"));
  	  	    	            p.sendMessage(API.getHoverClickRunCommandMessage("§b➥ §5VIP", "§eSet §6" + args[0] + "'s §erank to VIP", "setrank " + args[0] + " vip"));
  	  	    	            p.sendMessage(API.getHoverClickRunCommandMessage("§b➥ §aEmerald", "§eSet §6" + args[0] + "'s §erank to Emerald", "setrank " + args[0] + " emerald"));
  	  	    	            p.sendMessage(API.getHoverClickRunCommandMessage("§b➥ §bDiamond", "§eSet §6" + args[0] + "'s §erank to Diamond", "setrank " + args[0] + " diamond"));
  	  	    	            p.sendMessage(API.getHoverClickRunCommandMessage("§b➥ §6Gold", "§eSet §6" + args[0] + "'s §erank to Gold", "setrank " + args[0] + " gold"));
  	  	    	            p.sendMessage(API.getHoverClickRunCommandMessage("§b➥ §7YouTuber", "§eSet §6" + args[0] + "'s §erank to YouTuber", "setrank " + args[0] + " YouTuber"));
  	  	    	            p.sendMessage(API.getHoverClickRunCommandMessage("§b➥ §7Default", "§eSet §6" + args[0] + "'s §erank to Default", "setrank " + args[0] + " default"));
  	  	              }
  	  	              p.sendMessage("§8§m=------------------------------==");
  	  	              p.sendMessage("§8┃ §cHozexMC §8┃ §a/Role <player> §c<rank>");
  	  	          }
  	        	}
  	        } else {
  	        	
  	        	
  	        	if (args[1].equalsIgnoreCase("to")) {
    	  	          p.sendMessage("§8┃ §cHozexMC §8┃ §7/Role <player1> to <player2>");
    	  	          ProxiedPlayer player1 = BungeeCord.getInstance().getPlayer(args[0]);
    	  	          ProxiedPlayer player2 = BungeeCord.getInstance().getPlayer(args[2]);
    	  			  File file = new File(bcb.getDataFolder().getPath(), "infos.yml");
    	  			try {
    	  				Configuration config = ConfigurationProvider.getProvider(YamlConfiguration.class).load(file);
    	  				List<String> list1 = (List<String>) config.getList(args[0] + ".ips");
    	  				List<String> list2 = (List<String>) config.getList(args[2] + ".ips");
    	  				if (player2 != null) {
        	  				boolean isContains = false;
        	  				boolean isContains2 = false;
        	  				for (String l1Lines : list1) {
        	  					if (list2.contains(l1Lines)) {
        	  						if (isContains == true) {
            	  						isContains2 = true;
        	  						}
        	  						isContains = true;
        	  					}
        	  				}
        	  				if (isContains == true) {
        	  					String p1rank = API.getPrimaryGroup(args[0]);
        	  					if (isContains2 == true) {
        	  						p.sendMessage("§8┃ §eHozexMC §8┃ §e" + args[0] + " §7and §e" + args[1] + " §7have §emore than 1 IP §7in common");
        	  						p.sendMessage("§8┃ §eHozexMC §8┃ §eAre you sure about moving their ranks? §8[§aY §8| §cN§8]§7. You have 1 minute to decide");
        	  						try {
	        	  						config.set(p.getName() + ".isSelecting", args[0] + "," + args[1]);
										ConfigurationProvider.getProvider(YamlConfiguration.class).save(config, file);
									} catch (IOException e) {
										e.printStackTrace();
									}
        	  						BungeeCord.getInstance().getScheduler().schedule(bcb, new Runnable() {
										
										@Override
										public void run() {
		        	  						try {
			        	  						config.set(p.getName() + ".isSelecting", "--");
												ConfigurationProvider.getProvider(YamlConfiguration.class).save(config, file);
			        	  						p.sendMessage("§8┃ §aHozexMC §8┃ §7Time expired to move §e" + args[0] + "'s §7rank to §e" + args[2]);
											} catch (IOException e) {
												e.printStackTrace();
											}
										}
									}, 1, TimeUnit.MINUTES);
        	  					} else {
        	  						p.sendMessage("§8┃ §aHozexMC §8┃ §e" + args[0] + " §7and §e" + args[1] + " §7have §eonly 1 IP §7in common");
        	  						p.sendMessage("§8┃ §eHozexMC §8┃ §eAre you sure about moving their ranks? §8[§aY §8| §cN§8]§7. You have 1 minute to decide");
        	  						try {
	        	  						config.set(p.getName() + ".isSelecting", args[0] + "," + args[1]);
										ConfigurationProvider.getProvider(YamlConfiguration.class).save(config, file);
									} catch (IOException e) {
										e.printStackTrace();
									}
        	  						BungeeCord.getInstance().getScheduler().schedule(bcb, new Runnable() {
										
										@Override
										public void run() {
		        	  						try {
			        	  						config.set(p.getName() + ".isSelecting", "--");
												ConfigurationProvider.getProvider(YamlConfiguration.class).save(config, file);
			        	  						p.sendMessage("§8┃ §aHozexMC §8┃ §7Time expired to move §e" + args[0] + "'s §7rank to §e" + args[2]);
											} catch (IOException e) {
												e.printStackTrace();
											}
										}
									}, 1, TimeUnit.MINUTES);
        	  					}
        	  				} else {
    	  						p.sendMessage("§8┃ §aHozexMC §8┃ §e" + args[0] + " §7and §e" + args[1] + " §cdon't have anything in common§7, They might not be the same person");
    	  						p.sendMessage("§8┃ §eHozexMC §8┃ §eAre you sure about moving their ranks? §8[§aY §8| §cN§8]§7. You have 1 minute to decide");
    	  						try {
        	  						config.set(p.getName() + ".isSelecting", args[0] + "," + args[1]);
									ConfigurationProvider.getProvider(YamlConfiguration.class).save(config, file);
								} catch (IOException e) {
									e.printStackTrace();
								}
    	  						BungeeCord.getInstance().getScheduler().schedule(bcb, new Runnable() {
									
									@Override
									public void run() {
	        	  						try {
		        	  						config.set(p.getName() + ".isSelecting", "--");
											ConfigurationProvider.getProvider(YamlConfiguration.class).save(config, file);
		        	  						p.sendMessage("§8┃ §aHozexMC §8┃ §7Time expired to move §e" + args[0] + "'s §7rank to §e" + args[2]);
										} catch (IOException e) {
											e.printStackTrace();
										}
									}
								}, 1, TimeUnit.MINUTES);
        	  				}
    	  				} else {
    	    	  	          p.sendMessage("§8┃ §cHozexMC §8┃ §e" + args[2] + " §7is offline!");
    	  				}
    	  				
    	  			} catch (IOException e) {
    	  				e.printStackTrace();
    	  			}
    	  	          
    	        	} else {
    	  	        	ProxiedPlayer t = BungeeCord.getInstance().getPlayer(args[0]);
    	  	          if (args[1].equalsIgnoreCase("Moderator") || args[1].contains("Mod")) {
    	  	        	  ProxyServer.getInstance().getPluginManager().dispatchCommand(ProxyServer.getInstance().getConsole(), "lpb user " + args[0] + " group set Mod");
    	  	        	  ProxyServer.getInstance().getPluginManager().dispatchCommand(ProxyServer.getInstance().getConsole(), "lpb user " + args[0] + " sync");
    	  	        	  ProxyServer.getInstance().getPluginManager().dispatchCommand(ProxyServer.getInstance().getConsole(), "lpb user " + args[0] + " networksync");
    	  	        	  if (t != null) {
    	  	  	            t.sendMessage("§eYou have recived §cMod §eRank");
    	  	        	  }
    		  	            p.sendMessage("§8┃ §aHozexMC §8┃ §7You have set §6" + API.getP(args[0]) + "§7's rank to §cMod");
    		  	            for (ProxiedPlayer admins : BungeeCord.getInstance().getPlayers()) {
    		  	            	if (admins.getName().equals(p.getName())) {
    		  	            		
    		  	            	} else {
    			  	            	if (admins.hasPermission("H.Owner") || admins.hasPermission("H.HeadAdmin") || admins.hasPermission("H.Admin")) {
    			  	            		admins.sendMessage("§8┃ §eHozexMC §8┃ §7" + API.getP(p.getName()) + " §7has given §6" + args[0] + " §cMod");
    			  	            	}
    		  	            	}
    		  	            }
    	  	          } else if (args[1].equalsIgnoreCase("VIP")) {
    	 	        	  ProxyServer.getInstance().getPluginManager().dispatchCommand(ProxyServer.getInstance().getConsole(), "lpb user " + args[0] + " group set VIP");
    	  	        	  ProxyServer.getInstance().getPluginManager().dispatchCommand(ProxyServer.getInstance().getConsole(), "lpb user " + args[0] + " sync");
    	  	        	  ProxyServer.getInstance().getPluginManager().dispatchCommand(ProxyServer.getInstance().getConsole(), "lpb user " + args[0] + " networksync");
    	  	        	  if (t != null) {
    	  	  	            t.sendMessage("§eYou have recived §5VIP §eRank");
    	  	        	  }
    		  	            p.sendMessage("§8┃ §aHozexMC §8┃ §7You have set §6" + API.getP(args[0]) + "§7's rank to §5VIP");
    		  	            for (ProxiedPlayer admins : BungeeCord.getInstance().getPlayers()) {
    		  	            	if (admins.getName().equals(p.getName())) {
    		  	            		
    		  	            	} else {
    			  	            	if (admins.hasPermission("H.Owner") || admins.hasPermission("H.HeadAdmin") || admins.hasPermission("H.Admin")) {
    			  	            		admins.sendMessage("§8┃ §eHozexMC §8┃ §7" + API.getP(p.getName()) + " §7has given §6" + args[0] + " §5VIP");
    			  	            	}
    		  	            	}
    		  	            }
    	  	          } else if (args[1].equalsIgnoreCase("Helper") || args[1].contains("Help")) {
    	 	        	  ProxyServer.getInstance().getPluginManager().dispatchCommand(ProxyServer.getInstance().getConsole(), "lpb user " + args[0] + " group set Helper");
    	  	        	  ProxyServer.getInstance().getPluginManager().dispatchCommand(ProxyServer.getInstance().getConsole(), "lpb user " + args[0] + " sync");
    	  	        	  ProxyServer.getInstance().getPluginManager().dispatchCommand(ProxyServer.getInstance().getConsole(), "lpb user " + args[0] + " networksync");
    	  	        	  if (t != null) {
    	  	  	            t.sendMessage("§eYou have recived §3Helper §eRank");
    	  	        	  }
    		  	            p.sendMessage("§8┃ §aHozexMC §8┃ §7You have set §6" + API.getP(args[0]) + "§7's rank to §3Helper");
    		  	            for (ProxiedPlayer admins : BungeeCord.getInstance().getPlayers()) {
    		  	            	if (admins.getName().equals(p.getName())) {
    		  	            		
    		  	            	} else {
    			  	            	if (admins.hasPermission("H.Owner") || admins.hasPermission("H.HeadAdmin") || admins.hasPermission("H.Admin")) {
    			  	            		admins.sendMessage("§8┃ §eHozexMC §8┃ §7" + API.getP(p.getName()) + " §7has given §6" + args[0] + " §3Helper");
    			  	            	}
    		  	            	}
    		  	            }
    	  	          } else if (args[1].equalsIgnoreCase("Builder") || args[1].contains("Build")) {
    	 	        	  ProxyServer.getInstance().getPluginManager().dispatchCommand(ProxyServer.getInstance().getConsole(), "lpb user " + args[0] + " group set Builder");
    	  	        	  ProxyServer.getInstance().getPluginManager().dispatchCommand(ProxyServer.getInstance().getConsole(), "lpb user " + args[0] + " sync");
    	  	        	  ProxyServer.getInstance().getPluginManager().dispatchCommand(ProxyServer.getInstance().getConsole(), "lpb user " + args[0] + " networksync");
    	  	        	  if (t != null) {
    	  	  	            t.sendMessage("§eYou have recived §2Builder §eRank");
    	  	        	  }
    		  	            p.sendMessage("§8┃ §aHozexMC §8┃ §7You have set §6" + API.getP(args[0]) + "§7's rank to §2Builder");
    		  	            for (ProxiedPlayer admins : BungeeCord.getInstance().getPlayers()) {
    		  	            	if (admins.getName().equals(p.getName())) {
    		  	            		
    		  	            	} else {
    			  	            	if (admins.hasPermission("H.Owner") || admins.hasPermission("H.HeadAdmin") || admins.hasPermission("H.Admin")) {
    			  	            		admins.sendMessage("§8┃ §eHozexMC §8┃ §7" + API.getP(p.getName()) + " §7has given §6" + args[0] + " §2Builder");
    			  	            	}
    		  	            	}
    		  	            }
    	  	          } else if (args[1].equalsIgnoreCase("Emerald") || args[1].contains("Eme")) {
    	 	        	  ProxyServer.getInstance().getPluginManager().dispatchCommand(ProxyServer.getInstance().getConsole(), "lpb user " + args[0] + " group set Emerald");
    	  	        	  ProxyServer.getInstance().getPluginManager().dispatchCommand(ProxyServer.getInstance().getConsole(), "lpb user " + args[0] + " sync");
    	  	        	  ProxyServer.getInstance().getPluginManager().dispatchCommand(ProxyServer.getInstance().getConsole(), "lpb user " + args[0] + " networksync");
    	  	        	  if (t != null) {
    	  	  	            t.sendMessage("§eYou have recived §aEmerald §eRank");
    	  	        	  }
    		  	            p.sendMessage("§8┃ §aHozexMC §8┃ §7You have set §6" + API.getP(args[0]) + "§7's rank to §aEmerald");
    		  	            for (ProxiedPlayer admins : BungeeCord.getInstance().getPlayers()) {
    		  	            	if (admins.getName().equals(p.getName())) {
    		  	            		
    		  	            	} else {
    			  	            	if (admins.hasPermission("H.Owner") || admins.hasPermission("H.HeadAdmin") || admins.hasPermission("H.Admin")) {
    			  	            		admins.sendMessage("§8┃ §eHozexMC §8┃ §7" + API.getP(p.getName()) + " §7has given §6" + args[0] + " §aEmerald");
    			  	            	}
    		  	            	}
    		  	            }
    	  	          } else if (args[1].equalsIgnoreCase("Diamond") || args[1].contains("Dia")) {
    	 	        	  ProxyServer.getInstance().getPluginManager().dispatchCommand(ProxyServer.getInstance().getConsole(), "lpb user " + args[0] + " group set Diamond");
    	  	        	  ProxyServer.getInstance().getPluginManager().dispatchCommand(ProxyServer.getInstance().getConsole(), "lpb user " + args[0] + " sync");
    	  	        	  ProxyServer.getInstance().getPluginManager().dispatchCommand(ProxyServer.getInstance().getConsole(), "lpb user " + args[0] + " networksync");
    	  	        	  if (t != null) {
    	  	  	            t.sendMessage("§eYou have recived §bDiamond §eRank");
    	  	        	  }
    		  	            p.sendMessage("§8┃ §aHozexMC §8┃ §7You have set §6" + API.getP(args[0]) + "§7's rank to §bDiamond");
    		  	            for (ProxiedPlayer admins : BungeeCord.getInstance().getPlayers()) {
    		  	            	if (admins.getName().equals(p.getName())) {
    		  	            		
    		  	            	} else {
    			  	            	if (admins.hasPermission("H.Owner") || admins.hasPermission("H.HeadAdmin") || admins.hasPermission("H.Admin")) {
    			  	            		admins.sendMessage("§8┃ §eHozexMC §8┃ §7" + API.getP(p.getName()) + " §7has given §6" + args[0] + " §bDiamond");
    			  	            	}
    		  	            	}
    		  	            }
    	  	          } else if (args[1].equalsIgnoreCase("Gold") || args[1].contains("Go")) {
    	 	        	  ProxyServer.getInstance().getPluginManager().dispatchCommand(ProxyServer.getInstance().getConsole(), "lpb user " + args[0] + " group set Gold");
    	  	        	  ProxyServer.getInstance().getPluginManager().dispatchCommand(ProxyServer.getInstance().getConsole(), "lpb user " + args[0] + " sync");
    	  	        	  ProxyServer.getInstance().getPluginManager().dispatchCommand(ProxyServer.getInstance().getConsole(), "lpb user " + args[0] + " networksync");
    	  	        	  if (t != null) {
    	  	  	            t.sendMessage("§eYou have recived §6Gold §eRank");
    	  	        	  }
    		  	            p.sendMessage("§8┃ §aHozexMC §8┃ §7You have set §6" + API.getP(args[0]) + "§7's rank to §6Gold");
    		  	            for (ProxiedPlayer admins : BungeeCord.getInstance().getPlayers()) {
    		  	            	if (admins.getName().equals(p.getName())) {
    		  	            		
    		  	            	} else {
    			  	            	if (admins.hasPermission("H.Owner") || admins.hasPermission("H.HeadAdmin") || admins.hasPermission("H.Admin")) {
    			  	            		admins.sendMessage("§8┃ §eHozexMC §8┃ §7" + API.getP(p.getName()) + " §7has given §6" + args[0] + "§6Gold");
    			  	            	}
    		  	            	}
    		  	            }
    	  	          } else if (args[1].equalsIgnoreCase("YouTuber") || args[1].contains("You")) {
    	 	        	  ProxyServer.getInstance().getPluginManager().dispatchCommand(ProxyServer.getInstance().getConsole(), "lpb user " + args[0] + " group set YouTuber");
    	  	        	  ProxyServer.getInstance().getPluginManager().dispatchCommand(ProxyServer.getInstance().getConsole(), "lpb user " + args[0] + " sync");
    	  	        	  ProxyServer.getInstance().getPluginManager().dispatchCommand(ProxyServer.getInstance().getConsole(), "lpb user " + args[0] + " networksync");
    	  	        	  if (t != null) {
    	  	  	            t.sendMessage("§eYou have recived §5YouTuber §eRank");
    	  	        	  }
    		  	            p.sendMessage("§8┃ §aHozexMC §8┃ §7You have set §6" + API.getP(args[0]) + "§7's rank to §5YouTuber");
    		  	            for (ProxiedPlayer admins : BungeeCord.getInstance().getPlayers()) {
    		  	            	if (admins.getName().equals(p.getName())) {
    		  	            		
    		  	            	} else {
    			  	            	if (admins.hasPermission("H.Owner") || admins.hasPermission("H.HeadAdmin") || admins.hasPermission("H.Admin")) {
    			  	            		admins.sendMessage("§8┃ §eHozexMC §8┃ §7" + API.getP(p.getName()) + " §7has given §6" + args[0] + "§5YouTuber");
    			  	            	}
    		  	            	}
    		  	            }
    	  	          } else if (args[1].equalsIgnoreCase("Default") || args[1].equalsIgnoreCase("Member") || args[1].contains("Reset") || args[1].contains("Def") || args[1].contains("Mem")) {
    	 	        	  ProxyServer.getInstance().getPluginManager().dispatchCommand(ProxyServer.getInstance().getConsole(), "lpb user " + args[0] + " clear");
    	 	        	  ProxyServer.getInstance().getPluginManager().dispatchCommand(ProxyServer.getInstance().getConsole(), "lpb user " + args[0] + " group set Default");
    	  	        	  ProxyServer.getInstance().getPluginManager().dispatchCommand(ProxyServer.getInstance().getConsole(), "lpb user " + args[0] + " sync");
    	  	        	  ProxyServer.getInstance().getPluginManager().dispatchCommand(ProxyServer.getInstance().getConsole(), "lpb user " + args[0] + " networksync");
    	  	        	  if (t != null) {
    	  	  	            t.sendMessage("§eYou have recived §7Default §eRank");
    	  	        	  }
    		  	            p.sendMessage("§8┃ §aHozexMC §8┃ §7You have set §6" + API.getP(args[0]) + "§7's rank to §7Default");
    		  	            for (ProxiedPlayer admins : BungeeCord.getInstance().getPlayers()) {
    		  	            	if (admins.hasPermission("H.Owner") || admins.hasPermission("H.HeadAdmin") || admins.hasPermission("H.Admin")) {
    		  	            		admins.sendMessage("§8┃ §eHozexMC §8┃ §7" + API.getP(p.getName()) + " §7has given §6" + args[0] + " §7Default");
    		  	            	}
    		  	            }
    	  	          } else {
    	  	          	
    	  	              p.sendMessage("§8§m=------------------------------==");
    	  	              if (p.hasPermission("H.Owner") || p.hasPermission("H.Admin") || p.hasPermission("H.Manager")) {
    	  	      	        p.sendMessage(API.getHoverClickRunCommandMessage("§b➥ §cMod", "§eSet §6" + args[0] + "'s §erank to Mod", "setrank " + args[0] + " mod"));
    	  	      	        p.sendMessage(API.getHoverClickRunCommandMessage("§b➥ §3Helper", "§eSet §6" + args[0] + "'s §erank to Helper", "setrank " + args[0] + " helper"));
    	  	        	        p.sendMessage(API.getHoverClickRunCommandMessage("§b➥ §2Builder", "§eSet §6" + args[0] + "'s §erank to Builder", "setrank " + args[0] + " builder"));
    	  	    	            p.sendMessage(API.getHoverClickRunCommandMessage("§b➥ §5VIP", "§eSet §6" + args[0] + "'s §erank to VIP", "setrank " + args[0] + " vip"));
    	  	    	            p.sendMessage(API.getHoverClickRunCommandMessage("§b➥ §aEmerald", "§eSet §6" + args[0] + "'s §erank to Emerald", "setrank " + args[0] + " emerald"));
    	  	    	            p.sendMessage(API.getHoverClickRunCommandMessage("§b➥ §bDiamond", "§eSet §6" + args[0] + "'s §erank to Diamond", "setrank " + args[0] + " diamond"));
    	  	    	            p.sendMessage(API.getHoverClickRunCommandMessage("§b➥ §6Gold", "§eSet §6" + args[0] + "'s §erank to Gold", "setrank " + args[0] + " gold"));
    	  	    	            p.sendMessage(API.getHoverClickRunCommandMessage("§b➥ §7YouTuber", "§eSet §6" + args[0] + "'s §erank to YouTuber", "setrank " + args[0] + " YouTuber"));
    	  	    	            p.sendMessage(API.getHoverClickRunCommandMessage("§b➥ §7Default", "§eSet §6" + args[0] + "'s §erank to Default", "setrank " + args[0] + " default"));
    	  	              }
    	  	              p.sendMessage("§8§m=------------------------------==");
    	  	              p.sendMessage("§8┃ §cHozexMC §8┃ §a/Role <player> §c<rank>");
    	  	          }
    	        	}
  	        	
  	        	
  	        }
    } else {
      p.sendMessage("§8┃ §cHozexMC §8┃ §7Unknown command.");
    }
	}

}
