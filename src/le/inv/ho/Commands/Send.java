package le.inv.ho.Commands;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.config.ServerInfo;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.connection.Server;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.command.PlayerCommand;

public class Send extends Command {
	
	private static Plugin plugin;
	
	public Send(Plugin plugin) {
		super("hsend");
		this.plugin = plugin;
	}
	
	public void execute(CommandSender hsender, String[] args) {
		ProxiedPlayer p = (ProxiedPlayer) hsender;
		if (p.hasPermission("H.Owner") || p.hasPermission("H.HeadAdmin") || p.hasPermission("H.Admin") || p.hasPermission("H.SendCMD")) {
		if (args.length == 0) {
			p.sendMessage("§cNot enough arguments, usage: /hsend");
			p.sendMessage("§c §c<server|player|all|current> <target>");
		} else if (args.length == 1) {
			p.sendMessage("§cNot enough arguments, usage: /hsend");
			p.sendMessage("§c §c<server|player|all|current> <target>");
		} else if (args.length == 2) {
			ServerInfo server = BungeeCord.getInstance().getServerInfo(args[1]);
			ServerInfo custom = BungeeCord.getInstance().getServerInfo(args[0]);
			ProxiedPlayer pl = BungeeCord.getInstance().getPlayer(args[0]);
			if (p.hasPermission("H.Owner") || p.hasPermission("H.HeadAdmin") || p.hasPermission("H.Admin")) {
			if (server != null) {
				if (args[0].equalsIgnoreCase("all")) {
            		BungeeCord.getInstance().getScheduler().schedule(plugin, new Runnable() {
    					@Override
    					public void run() {
    						for (ProxiedPlayer all : BungeeCord.getInstance().getPlayers()) {
    							  if (all.hasPermission("H.Owner")) {
    								  all.connect(server);
    								  if (p.getName().equals(all.getName())) {
    	    								all.sendMessage("§6You have summoned yourself to " + server.getName());
      								  } else {
      									  if (p.getName().equals("iImHero")) {
        	    								all.sendMessage("§6" + p.getName() + " summoned you to " + server.getName());
      									  } else {
        	    								all.sendMessage("§6someone summoned you to " + server.getName());
      									  }
      								  }
    							  } else if (all.hasPermission("H.HeadAdmin")) {
    								  all.connect(server);
    								  if (p.getName().equals(all.getName())) {
    	    								all.sendMessage("§6You have summoned yourself to " + server.getName());
      								  } else {
      									  if (p.getName().equals("iImHero")) {
      	    								all.sendMessage("§6" + p.getName() + " summoned you to " + server.getName());
    									  } else {
      	    								all.sendMessage("§6someone summoned you to " + server.getName());
    									  }
      								  }
    							  } else if (all.hasPermission("H.Admin")) {
    								  all.connect(server);
    								  if (p.getName().equals(all.getName())) {
    	    								all.sendMessage("§6You have summoned yourself to " + server.getName());
      								  } else {
      									  if (p.getName().equals("iImHero")) {
      	    								all.sendMessage("§6" + p.getName() + " summoned you to " + server.getName());
    									  } else {
      	    								all.sendMessage("§6someone summoned you to " + server.getName());
    									  }
      								  }
    							  } else if (all.hasPermission("H.Developer")) {
    								  all.connect(server);
      								all.sendMessage("§6" + p.getName() + " summoned you to " + server.getName());
    							  } else if (all.hasPermission("H.Special")) {
    								  all.connect(server);
    								  if (p.getName().equals(all.getName())) {
    	    								all.sendMessage("§6You have summoned yourself to " + server.getName());
      								  } else {
      									  if (p.getName().equals("iImHero")) {
      	    								all.sendMessage("§6" + p.getName() + " summoned you to " + server.getName());
    									  } else {
      	    								all.sendMessage("§6someone summoned you to " + server.getName());
    									  }
      								  }
    							  } else if (all.hasPermission("H.SrMod")) {
    								  all.connect(server);
    								  if (p.getName().equals(all.getName())) {
    	    								all.sendMessage("§6You have summoned yourself to " + server.getName());
      								  } else {
      									  if (p.getName().equals("iImHero")) {
      	    								all.sendMessage("§6" + p.getName() + " summoned you to " + server.getName());
    									  } else {
      	    								all.sendMessage("§6someone summoned you to " + server.getName());
    									  }
      								  }
    							  }
    						}
    					}
    				}, 1, TimeUnit.SECONDS);
            		
            		BungeeCord.getInstance().getScheduler().schedule(plugin, new Runnable() {
    					@Override
    					public void run() {
    						for (ProxiedPlayer all : BungeeCord.getInstance().getPlayers()) {
    							  if (all.hasPermission("H.Mod")) {
    								  all.connect(server);
  									  if (p.getName().equals("iImHero")) {
  	    								all.sendMessage("§6" + p.getName() + " summoned you to " + server.getName());
									  } else {
  	    								all.sendMessage("§6someone summoned you to " + server.getName());
									  }
    							  } else if (all.hasPermission("H.Helper")) {
    								  all.connect(server);
  									  if (p.getName().equals("iImHero")) {
  	    								all.sendMessage("§6" + p.getName() + " summoned you to " + server.getName());
									  } else {
  	    								all.sendMessage("§6someone summoned you to " + server.getName());
									  }
    							  } else if (all.hasPermission("H.VIP")) {
    								  all.connect(server);
  									  if (p.getName().equals("iImHero")) {
  	    								all.sendMessage("§6" + p.getName() + " summoned you to " + server.getName());
									  } else {
  	    								all.sendMessage("§6someone summoned you to " + server.getName());
									  }
    							  } else if (all.hasPermission("H.Builder")) {
    								  all.connect(server);
  									  if (p.getName().equals("iImHero")) {
  	    								all.sendMessage("§6" + p.getName() + " summoned you to " + server.getName());
									  } else {
  	    								all.sendMessage("§6someone summoned you to " + server.getName());
									  }
    							  }
    						}
    					}
    				}, 3, TimeUnit.SECONDS);
            		
            		BungeeCord.getInstance().getScheduler().schedule(plugin, new Runnable() {
    					@Override
    					public void run() {
    						for (ProxiedPlayer all : BungeeCord.getInstance().getPlayers()) {
    							  if (all.hasPermission("H.Emerald")) {
    								  all.connect(server);
  									  if (p.getName().equals("iImHero")) {
  	    								all.sendMessage("§6" + p.getName() + " summoned you to " + server.getName());
									  } else {
  	    								all.sendMessage("§6someone summoned you to " + server.getName());
									  }
    							  } else if (all.hasPermission("H.Diamond")) {
    								  all.connect(server);
  									  if (p.getName().equals("iImHero")) {
  	    								all.sendMessage("§6" + p.getName() + " summoned you to " + server.getName());
									  } else {
  	    								all.sendMessage("§6someone summoned you to " + server.getName());
									  }
    							  } else if (all.hasPermission("H.Gold")) {
    								  all.connect(server);
  									  if (p.getName().equals("iImHero")) {
  	    								all.sendMessage("§6" + p.getName() + " summoned you to " + server.getName());
									  } else {
  	    								all.sendMessage("§6someone summoned you to " + server.getName());
									  }
    							  } else if (all.hasPermission("H.YouTuber")) {
    								  all.connect(server);
  									  if (p.getName().equals("iImHero")) {
  	    								all.sendMessage("§6" + p.getName() + " summoned you to " + server.getName());
									  } else {
  	    								all.sendMessage("§6someone summoned you to " + server.getName());
									  }
    							  }
    						}
    					}
    				}, 5, TimeUnit.SECONDS);
            		
            		BungeeCord.getInstance().getScheduler().schedule(plugin, new Runnable() {
    					@Override
    					public void run() {
    						for (ProxiedPlayer all : BungeeCord.getInstance().getPlayers()) {
     							all.connect(server);
    							if (p.hasPermission("H.Owner") || p.hasPermission("H.HeadAdmin") || p.hasPermission("H.Admin") || p.hasPermission("H.SrMod") || p.hasPermission("H.Developer")) {
									  if (p.getName().equals("iImHero")) {
  	    								all.sendMessage("§6" + p.getName() + " summoned you to " + server.getName());
									  } else {
  	    								all.sendMessage("§6someone summoned you to " + server.getName());
									  }
    							} else {
    								all.sendMessage("You have been summoned you to " + server.getName());
    							}
    						}
    					}
    				}, 6, TimeUnit.SECONDS);
				} else if (args[0].equalsIgnoreCase("current")) {
            		BungeeCord.getInstance().getScheduler().schedule(plugin, new Runnable() {
    					@Override
    					public void run() {
    						for (ProxiedPlayer all : BungeeCord.getInstance().getServerInfo(p.getServer().getInfo().getName()).getPlayers()) {
    							  if (all.hasPermission("H.Owner")) {
    								  all.connect(server);
    								  if (p.getName().equals(all.getName())) {
    	    								all.sendMessage("§6You have summoned yourself to " + server.getName());
      								  } else {
      									  if (p.getName().equals("iImHero")) {
      	    								all.sendMessage("§6" + p.getName() + " summoned you to " + server.getName());
    									  } else {
      	    								all.sendMessage("§6someone summoned you to " + server.getName());
    									  }
      								  }
    							  } else if (all.hasPermission("H.HeadAdmin")) {
    								  all.connect(server);
    								  if (p.getName().equals(all.getName())) {
    	    								all.sendMessage("§6You have summoned yourself to " + server.getName());
      								  } else {
      									  if (p.getName().equals("iImHero")) {
      	    								all.sendMessage("§6" + p.getName() + " summoned you to " + server.getName());
    									  } else {
      	    								all.sendMessage("§6someone summoned you to " + server.getName());
    									  }
      								  }
    							  } else if (all.hasPermission("H.Admin")) {
    								  all.connect(server);
    								  if (p.getName().equals(all.getName())) {
    	    								all.sendMessage("§6You have summoned yourself to " + server.getName());
      								  } else {
      									  if (p.getName().equals("iImHero")) {
      	    								all.sendMessage("§6" + p.getName() + " summoned you to " + server.getName());
    									  } else {
      	    								all.sendMessage("§6someone summoned you to " + server.getName());
    									  }
      								  }
    							  } else if (all.hasPermission("H.Developer")) {
    								  all.connect(server);
      								all.sendMessage("§6" + p.getName() + " summoned you to " + server.getName());
    							  } else if (all.hasPermission("H.Special")) {
    								  all.connect(server);
    								  if (p.getName().equals(all.getName())) {
    	    								all.sendMessage("§6You have summoned yourself to " + server.getName());
      								  } else {
      									  if (p.getName().equals("iImHero")) {
      	    								all.sendMessage("§6" + p.getName() + " summoned you to " + server.getName());
    									  } else {
      	    								all.sendMessage("§6someone summoned you to " + server.getName());
    									  }
      								  }
    							  } else if (all.hasPermission("H.SrMod")) {
    								  all.connect(server);
    								  if (p.getName().equals(all.getName())) {
    	    								all.sendMessage("§6You have summoned yourself to " + server.getName());
      								  } else {
      									  if (p.getName().equals("iImHero")) {
      	    								all.sendMessage("§6" + p.getName() + " summoned you to " + server.getName());
    									  } else {
      	    								all.sendMessage("§6someone summoned you to " + server.getName());
    									  }
      								  }
    							  }
    						}
    					}
    				}, 1, TimeUnit.SECONDS);
            		
            		BungeeCord.getInstance().getScheduler().schedule(plugin, new Runnable() {
    					@Override
    					public void run() {
    						for (ProxiedPlayer all : BungeeCord.getInstance().getServerInfo(p.getServer().getInfo().getName()).getPlayers()) {
    							  if (all.hasPermission("H.Mod")) {
    								  all.connect(server);
      								all.sendMessage("You have been summoned you to " + server.getName());
    							  } else if (all.hasPermission("H.Helper")) {
    								  all.connect(server);
      								all.sendMessage("You have been summoned you to " + server.getName());
    							  } else if (all.hasPermission("H.VIP")) {
    								  all.connect(server);
      								all.sendMessage("You have been summoned you to " + server.getName());
    							  } else if (all.hasPermission("H.Builder")) {
    								  all.connect(server);
      								all.sendMessage("You have been summoned you to " + server.getName());
    							  }
    						}
    					}
    				}, 3, TimeUnit.SECONDS);
            		
            		BungeeCord.getInstance().getScheduler().schedule(plugin, new Runnable() {
    					@Override
    					public void run() {
    						for (ProxiedPlayer all : BungeeCord.getInstance().getServerInfo(p.getServer().getInfo().getName()).getPlayers()) {
    							  if (all.hasPermission("H.Emerald")) {
    								  all.connect(server);
      								all.sendMessage("You have been summoned you to " + server.getName());
    							  } else if (all.hasPermission("H.Diamond")) {
    								  all.connect(server);
      								all.sendMessage("You have been summoned you to " + server.getName());
    							  } else if (all.hasPermission("H.Gold")) {
    								  all.connect(server);
      								all.sendMessage("You have been summoned you to " + server.getName());
    							  } else if (all.hasPermission("H.YouTuber")) {
    								  all.connect(server);
      								all.sendMessage("You have been summoned you to " + server.getName());
    							  }
    						}
    					}
    				}, 5, TimeUnit.SECONDS);
            		
            		BungeeCord.getInstance().getScheduler().schedule(plugin, new Runnable() {
    					@Override
    					public void run() {
    						for (ProxiedPlayer all : BungeeCord.getInstance().getServerInfo(p.getServer().getInfo().getName()).getPlayers()) {
     							all.connect(server);
    							if (p.hasPermission("H.Owner") || p.hasPermission("H.HeadAdmin") || p.hasPermission("H.Admin") || p.hasPermission("H.SrMod") || p.hasPermission("H.Developer")) {
    								all.sendMessage("§6" + p.getName() + " summoned you to " + server.getName());
    							} else {
    								all.sendMessage("You have been summoned you to " + server.getName());
    							}
    						}
    					}
    				}, 6, TimeUnit.SECONDS);
				} else {
					if (custom != null) {
						
	            		BungeeCord.getInstance().getScheduler().schedule(plugin, new Runnable() {
	    					@Override
	    					public void run() {
	    						for (ProxiedPlayer all : BungeeCord.getInstance().getServerInfo(custom.getName()).getPlayers()) {
	    							  if (all.hasPermission("H.Owner")) {
	    								  all.connect(server);
	    								  if (p.getName().equals(all.getName())) {
	    	    								all.sendMessage("§6You have summoned yourself to " + server.getName());
	      								  } else {
	      									  if (p.getName().equals("iImHero")) {
	        	    								all.sendMessage("§6" + p.getName() + " summoned you to " + server.getName());
	      									  } else {
	        	    								all.sendMessage("§6someone summoned you to " + server.getName());
	      									  }
	      								  }
	    							  } else if (all.hasPermission("H.HeadAdmin")) {
	    								  all.connect(server);
	    								  if (p.getName().equals(all.getName())) {
	    	    								all.sendMessage("§6You have summoned yourself to " + server.getName());
	      								  } else {
	      									  if (p.getName().equals("iImHero")) {
	        	    								all.sendMessage("§6" + p.getName() + " summoned you to " + server.getName());
	      									  } else {
	        	    								all.sendMessage("§6someone summoned you to " + server.getName());
	      									  }
	      								  }
	    							  } else if (all.hasPermission("H.Admin")) {
	    								  all.connect(server);
	    								  if (p.getName().equals(all.getName())) {
	    	    								all.sendMessage("§6You have summoned yourself to " + server.getName());
	      								  } else {
	    	    								all.sendMessage("§6" + p.getName() + " summoned you to " + server.getName());
	      								  }
	    							  } else if (all.hasPermission("H.Developer")) {
	    								  all.connect(server);
      									  if (p.getName().equals("iImHero")) {
      	    								all.sendMessage("§6" + p.getName() + " summoned you to " + server.getName());
    									  } else {
      	    								all.sendMessage("§6someone summoned you to " + server.getName());
    									  }
	    							  } else if (all.hasPermission("H.Special")) {
	    								  all.connect(server);
	    								  if (p.getName().equals(all.getName())) {
	    	    								all.sendMessage("§6You have summoned yourself to " + server.getName());
	      								  } else {
	      									  if (p.getName().equals("iImHero")) {
	        	    								all.sendMessage("§6" + p.getName() + " summoned you to " + server.getName());
	      									  } else {
	        	    								all.sendMessage("§6someone summoned you to " + server.getName());
	      									  }
	      								  }
	    							  } else if (all.hasPermission("H.SrMod")) {
	    								  all.connect(server);
	    								  if (p.getName().equals(all.getName())) {
	    	    								all.sendMessage("§6You have summoned yourself to " + server.getName());
	      								  } else {
	      									  if (p.getName().equals("iImHero")) {
	        	    								all.sendMessage("§6" + p.getName() + " summoned you to " + server.getName());
	      									  } else {
	        	    								all.sendMessage("§6someone summoned you to " + server.getName());
	      									  }
	      								  }
	    							  }
	    						}
	    					}
	    				}, 1, TimeUnit.SECONDS);
	            		
	            		BungeeCord.getInstance().getScheduler().schedule(plugin, new Runnable() {
	    					@Override
	    					public void run() {
	    						for (ProxiedPlayer all : BungeeCord.getInstance().getServerInfo(custom.getName()).getPlayers()) {
	    							  if (all.hasPermission("H.Mod")) {
	    								  all.connect(server);
	      								all.sendMessage("You have been summoned you to " + server.getName());
	    							  } else if (all.hasPermission("H.Helper")) {
	    								  all.connect(server);
	      								all.sendMessage("You have been summoned you to " + server.getName());
	    							  } else if (all.hasPermission("H.VIP")) {
	    								  all.connect(server);
	      								all.sendMessage("You have been summoned you to " + server.getName());
	    							  } else if (all.hasPermission("H.Builder")) {
	    								  all.connect(server);
	      								all.sendMessage("You have been summoned you to " + server.getName());
	    							  }
	    						}
	    					}
	    				}, 3, TimeUnit.SECONDS);
	            		
	            		BungeeCord.getInstance().getScheduler().schedule(plugin, new Runnable() {
	    					@Override
	    					public void run() {
	    						for (ProxiedPlayer all : BungeeCord.getInstance().getServerInfo(custom.getName()).getPlayers()) {
	    							  if (all.hasPermission("H.Emerald")) {
	    								  all.connect(server);
	      								all.sendMessage("You have been summoned you to " + server.getName());
	    							  } else if (all.hasPermission("H.Diamond")) {
	    								  all.connect(server);
	      								all.sendMessage("You have been summoned you to " + server.getName());
	    							  } else if (all.hasPermission("H.Gold")) {
	    								  all.connect(server);
	      								all.sendMessage("You have been summoned you to " + server.getName());
	    							  } else if (all.hasPermission("H.YouTuber")) {
	    								  all.connect(server);
	      								all.sendMessage("You have been summoned you to " + server.getName());
	    							  }
	    						}
	    					}
	    				}, 5, TimeUnit.SECONDS);
	            		
	            		BungeeCord.getInstance().getScheduler().schedule(plugin, new Runnable() {
	    					@Override
	    					public void run() {
	    						for (ProxiedPlayer all : BungeeCord.getInstance().getServerInfo(custom.getName()).getPlayers()) {
	     							all.connect(server);
	    							if (p.hasPermission("H.Owner") || p.hasPermission("H.HeadAdmin") || p.hasPermission("H.Admin") || p.hasPermission("H.SrMod") || p.hasPermission("H.Developer")) {
    									  if (p.getName().equals("iImHero")) {
      	    								all.sendMessage("§6" + p.getName() + " summoned you to " + server.getName());
    									  } else {
      	    								all.sendMessage("§6someone summoned you to " + server.getName());
    									  }
	    							} else {
	    								all.sendMessage("You have been summoned you to " + server.getName());
	    							}
	    						}
	    					}
	    				}, 6, TimeUnit.SECONDS);
					} else {
						if (pl != null) {
							if (pl.hasPermission("H.Owner") || pl.hasPermission("H.HeadAdmin") || pl.hasPermission("H.Admin")) {
								p.sendMessage("§cYou are not allowed to use this command on InVisTeK_");
							} else {
								pl.connect(server);
								p.sendMessage("§aSuccessfully summoned player(s)");
								pl.sendMessage("§6" + p.getName() + " summoned you to " + server.getName());
							}
						} else {
							p.sendMessage("§cThat player is not online");
						}
					}
				}
			} else {
				p.sendMessage("§cThe specified server does not exist");
			}
			} else {
				p.sendMessage("§cNo perms.");
			}
		}
	}
	}
	
}
