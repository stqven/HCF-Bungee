package le.inv.ho.Commands;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;

public class OTRewards extends Command {
	
	private Plugin plugin;
	
	public OTRewards(Plugin plugin) {
		super("otrewards");
		this.plugin = plugin;
	}
	
	public void execute(CommandSender sender, String[] args) {
		
		  ProxiedPlayer p = (ProxiedPlayer)sender;
		  
		  if (args.length == 0) {
			  rewardMessage(p);
		  } else if (args.length == 1) {
			  if (p.hasPermission("JustDefault")) {
				  if (args[0].equalsIgnoreCase("1")) {
					  if (!p.hasPermission("Node.1")) {
						  rewardCommand(p, 1);
					  } else {
						  p.sendMessage("§cYou already have this!");
					  }
				  } else if (args[0].equalsIgnoreCase("2")) {
					  if (!p.hasPermission("Node.2")) {
						  rewardCommand(p, 2);
					  } else {
						  p.sendMessage("§cYou already have this!");
					  }
				  } else if (args[0].equalsIgnoreCase("3")) {
					  if (!p.hasPermission("Node.3")) {
						  rewardCommand(p, 3);
					  } else {
						  p.sendMessage("§cYou already have this!");
					  }
				  } else {
					  rewardMessage(p);
				  }
			  } else {
				  p.sendMessage("§cThis command is only for the default rank members");
			  }
		  }
		  
	}
	
	public static void rewardMessage(ProxiedPlayer p) {
		if (p.hasPermission("JustDefault")) {
			  p.sendMessage("§f§l1. §3Actor rank §c(Cost 6 days)");
			  p.sendMessage("§f§l2. §3Enter Gold room §c(Cost 5 days)");
			  p.sendMessage("§f§l3. §3Fly in lobbies §c(Cost 3 days)");
			  p.sendMessage("§4Notice: §cEverything here is for 3 days and It will");
			  p.sendMessage("§cbe removed from your after that.");
		} else {
			  p.sendMessage("§cThis command is only for the default rank members");
		}
	}
	
	public void rewardCommand(ProxiedPlayer p, int n) {
		
		  File file1 = new File("plugins/OnlineTime/names.yml");
		  File file2 = new File("plugins/OnlineTime/time.yml");	
		
		if (n == 1) { // n == 1
			if (!p.hasPermission("Node.1")) {
				  try {
						Configuration names = ConfigurationProvider.getProvider(YamlConfiguration.class).load(file1);
						Configuration time = ConfigurationProvider.getProvider(YamlConfiguration.class).load(file2);
						
						  String uuid1 = names.getString(p.getName());
						  int time1 = time.getInt(uuid1);
						  
						  if (time1 > 518600 || time1 == 518600) {
							  int total = ((time1) - (518400)); // Days
							  time.set(uuid1, total);
			 	        	  ProxyServer.getInstance().getPluginManager().dispatchCommand(ProxyServer.getInstance().getConsole(), "lpb user " + p.getName() + " parent addtemp Actor 3d");
			 	        	  ProxyServer.getInstance().getPluginManager().dispatchCommand(ProxyServer.getInstance().getConsole(), "lpb user " + p.getName() + " settemp Node.1 3d");
	  						p.sendMessage("§c-6 Days..");
			 	        	  ProxyServer.getInstance().getPluginManager().dispatchCommand(ProxyServer.getInstance().getConsole(), "pm reload OnlineTime");
			 	        	  
				    		  ConfigurationProvider.getProvider(YamlConfiguration.class).save(time, file2);
						  } else {
							  p.sendMessage("§cYou don't have enough OnlineTime to buy this!");
						  }
						
					} catch (IOException e) {
						e.printStackTrace();
					}
			} else {
				  p.sendMessage("§cYou already have this!");
			}
			
		} else if (n == 2) { // n == 2
			if (!p.hasPermission("Node.2")) {
				  try {
						Configuration names = ConfigurationProvider.getProvider(YamlConfiguration.class).load(file1);
						Configuration time = ConfigurationProvider.getProvider(YamlConfiguration.class).load(file2);
						
						  String uuid1 = names.getString(p.getName());
						  int time1 = time.getInt(uuid1);
						  
						  if (time1 > 432050 || time1 == 432050) {
							  int total = ((time1) - (432000)); // Days
							  time.set(uuid1, total);
			 	        	  ProxyServer.getInstance().getPluginManager().dispatchCommand(ProxyServer.getInstance().getConsole(), "lpb user " + p.getName() + " parent addtemp LikeGold 3d");
			 	        	  ProxyServer.getInstance().getPluginManager().dispatchCommand(ProxyServer.getInstance().getConsole(), "lpb user " + p.getName() + " settemp Node.2 3d");
	  						p.sendMessage("§c-5 Days..");
			 	        	  ProxyServer.getInstance().getPluginManager().dispatchCommand(ProxyServer.getInstance().getConsole(), "pm reload OnlineTime");
			 	        	  ConfigurationProvider.getProvider(YamlConfiguration.class).save(time, file2);
						  } else {
							  p.sendMessage("§cYou don't have enough OnlineTime to buy this!");
						  }
						
					} catch (IOException e) {
						e.printStackTrace();
					}
			} else {
				  p.sendMessage("§cYou don't have enough OnlineTime to buy this!");
			}
		} else if (n == 3) { // n == 3
			if (!p.hasPermission("Node.3")) {
				  try {
						Configuration names = ConfigurationProvider.getProvider(YamlConfiguration.class).load(file1);
						Configuration time = ConfigurationProvider.getProvider(YamlConfiguration.class).load(file2);
						
						  String uuid1 = names.getString(p.getName());
						  int time1 = time.getInt(uuid1);
						  
						  if (time1 > 259500 || time1 == 259500) {
							  int total = ((time1) - (259200)); // Days
							  time.set(uuid1, total);
			 	        	  ProxyServer.getInstance().getPluginManager().dispatchCommand(ProxyServer.getInstance().getConsole(), "lpb user " + p.getName() + " settemp essentials.fly 3d Hub");
			 	        	  ProxyServer.getInstance().getPluginManager().dispatchCommand(ProxyServer.getInstance().getConsole(), "lpb user " + p.getName() + " settemp Node.3 3d");
	  						p.sendMessage("§c-3 Days..");
			 	        	  ProxyServer.getInstance().getPluginManager().dispatchCommand(ProxyServer.getInstance().getConsole(), "pm reload OnlineTime");
				    		  ConfigurationProvider.getProvider(YamlConfiguration.class).save(time, file2);
				    		  
						  } else {
							  p.sendMessage("§cYou don't have enough OnlineTime to buy this!");
						  }
						
					} catch (IOException e) {
						e.printStackTrace();
					}
			} else {
				  p.sendMessage("§cYou don't have enough OnlineTime to buy this!");
			}
		} else {
			rewardMessage(p);
		}
	}

}
