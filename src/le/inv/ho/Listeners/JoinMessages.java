package le.inv.ho.Listeners;

import le.inv.ho.BanU;
import le.inv.ho.Main;
import le.inv.ho.msgsql;
import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.LoginEvent;
import net.md_5.bungee.api.event.ServerConnectEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class JoinMessages implements Listener {
	  private Main bcb;
	  
	  public JoinMessages(Main bcb) {
	    this.bcb = bcb;
	  }
	  @EventHandler
	  public void onConnect(ServerConnectEvent e) {
		  ProxiedPlayer p = (ProxiedPlayer) e.getPlayer();
//			String pID = Integer.toString(msgsql.getPlayerID(p.getName()));
//			if (BanU.isBanned(pID)) {
//				Long time = Long.valueOf(BanU.getTime(pID, 1).get(0)) - System.currentTimeMillis();
//				int day = (int) (time/((1000*3600*24)));
//				int hour = (int) ((time%(1000*3600*24))/(1000*3600));
//				int min = (int) (((time%((1000*3600*24)))%(1000*3600))/(1000*60));
//				int sec = (int) ((((time%((1000*3600*24)))%(1000*3600))%(1000*60))/(1000));
//				StringBuilder time1 = new StringBuilder();
//				if (day > 0) {
//					if (day > 1) {
//						time1.append(day + " days ");
//					} else {
//						time1.append(day + " day ");
//					}
//				}
//				if (hour > 0) {
//					if (hour > 1) {
//						time1.append(hour + " hours ");
//					} else {
//						time1.append(hour + " hour ");
//					}
//				}
//				if (time1.equals("")) {
//					if (min > 0) {
//						if (min > 1) {
//							time1.append(min + " minutes ");
//						} else {
//							time1.append(min + " minute ");
//						}
//					}
//				}
//				if (time1.toString().equals("")) {
//					if (sec > 1) {
//						time1.append(sec + " seconds ");
//					} else {
//						time1.append(sec + " second ");
//					}
//				}
//				p.disconnect("§3HozexMC\n\nTemporarly Banned\n\n\n§bYou were banned from §eHozexMC §bNetwork\n§bfor the reason §c" + BanU.getReasons(pID, 1).get(0) + " #" + BanU.getBanIDs(pID, 1).get(0) + "\n§bYou will be unbanned in §c" + time1 + "\n\n§7If you think this has happened by mistake appeal at:\n§ahttps://discord.gg/qk4HT43");
//	  			e.setCancelled(true);
//			}
	  }
	  
//	  @EventHandler
//	  public void onBotKick(ServerConnectEvent e) {
//		  ProxiedPlayer p = e.getPlayer();
//		  otmove.OTRefresh(p.getName());
//		  if (p.getName().length() > 16) {
//			  e.setCancelled(true);
//			  return;
//		  }
//			File file = new File("plugins/HN-Bungee/blockadv.yml");
//			try {
//				Configuration config = ConfigurationProvider.getProvider(YamlConfiguration.class).load(file);
//				List<String> l = config.getStringList("adv");
//				boolean block = false;
//				for (String str : l) {
//					if (p.getName().toLowerCase().contains(str)) {
//						block = true;
//					}
//				}
//				if (block) {
//					e.setCancelled(true);
//				}
//			} catch (IOException ex) {}
//		  if (p.getName().toLowerCase().contains("mcspam") || p.getName().toLowerCase().contains("bot") || p.getName().toLowerCase().contains("mcstorm")) {
//			  e.setCancelled(true);
//			  return;
//		  }
//	      if (API.isModerator(p)) {
//	    	  if (API.hasNick(p.getName())) {
//	    		  BungeeCord.getInstance().getPluginManager().dispatchCommand(BungeeCord.getInstance().getConsole(), "sr drop " + p.getName());
//	    		  BungeeCord.getInstance().getPluginManager().dispatchCommand(p, "sr update");
//	    		  if (p.getName().equals("InVisTeK_") || p.getName().equals("SqlM7md")) {
//		    		  BungeeCord.getInstance().getPluginManager().dispatchCommand(BungeeCord.getInstance().getConsole(), "lpb user " + p.getName() + " group set Owner");
//		    		  BungeeCord.getInstance().getPluginManager().dispatchCommand(BungeeCord.getInstance().getConsole(), "lpb sync");
//		    		  BungeeCord.getInstance().getPluginManager().dispatchCommand(BungeeCord.getInstance().getConsole(), "lpb networksync");
//	    		  } else if (p.getName().equals("abdulloh") || p.getName().equals("iFqhad")) {
//		    		  BungeeCord.getInstance().getPluginManager().dispatchCommand(BungeeCord.getInstance().getConsole(), "lpb user " + p.getName() + " permission set H.Owner false");
//		    		  BungeeCord.getInstance().getPluginManager().dispatchCommand(BungeeCord.getInstance().getConsole(), "lpb user " + p.getName() + " group set headadmin");
//		    		  BungeeCord.getInstance().getPluginManager().dispatchCommand(BungeeCord.getInstance().getConsole(), "lpb sync");
//		    		  BungeeCord.getInstance().getPluginManager().dispatchCommand(BungeeCord.getInstance().getConsole(), "lpb networksync");
//	    		  } else if (p.getName().equals("xXM7mo0odXx") || p.getName().equals("Bskwet")) {
//		    		  BungeeCord.getInstance().getPluginManager().dispatchCommand(BungeeCord.getInstance().getConsole(), "lpb user " + p.getName() + " permission set H.Owner false");
//		    		  BungeeCord.getInstance().getPluginManager().dispatchCommand(BungeeCord.getInstance().getConsole(), "lpb user " + p.getName() + " permission set H.HeadAdmin false");
//		    		  BungeeCord.getInstance().getPluginManager().dispatchCommand(BungeeCord.getInstance().getConsole(), "lpb user " + p.getName() + " group set admin");
//		    		  BungeeCord.getInstance().getPluginManager().dispatchCommand(BungeeCord.getInstance().getConsole(), "lpb sync");
//		    		  BungeeCord.getInstance().getPluginManager().dispatchCommand(BungeeCord.getInstance().getConsole(), "lpb networksync");
//	    		  } else {
//		    		  BungeeCord.getInstance().getPluginManager().dispatchCommand(BungeeCord.getInstance().getConsole(), "lpb sync");
//		    		  BungeeCord.getInstance().getPluginManager().dispatchCommand(BungeeCord.getInstance().getConsole(), "lpb networksync");
//	    		  }
//	    		  mysql.update("DELETE FROM Nicks WHERE Name='" + p.getName() + "'");
//	    	  }
//	      }
//	  }
	  
//	@EventHandler
//	public void onSS(ServerSwitchEvent e) {
//		ProxiedPlayer p = e.getPlayer();
//		Server ss = p.getServer();
//		if (p.hasPermission("H.Owner") || p.hasPermission("H.HeadAdmin") || p.hasPermission("H.Admin") || p.hasPermission("H.SrMod") || p.hasPermission("H.Developer") || p.hasPermission("H.Mod") || p.hasPermission("H.Helper")) {
//			for (ProxiedPlayer all : ss.getInfo().getPlayers()) {
//				
//			}
//		} else {
//			
//		}
//		if (p.hasPermission("H.Vanished")) return;
//		if (p.hasPermission("H.Owner")) {
//			if (!p.getName().equals("InVisTeK_")) {
//				if (!API.isVanished(p.getName())) {
//					if (ss.getInfo().getName().equals("Hub")) {
//						TextComponent join = API.getHoverClickRunCommandSuggest("§e" + p.getName() + " §7joined the lobby", "§7Rank: §eOwner", "contact");
//						for (ProxiedPlayer all : BungeeCord.getInstance().getServerInfo(ss.getInfo().getName()).getPlayers()) {
//							if (!all.getName().equals(p.getName())) {
//								all.sendMessage(join);
//							}
//						}
//					} else {
//						TextComponent join = API.getHoverClickRunCommandSuggest("§e" + p.getName() + " §7joined the game", "§7Rank: §eOwner", "contact");
//						for (ProxiedPlayer all : BungeeCord.getInstance().getServerInfo(ss.getInfo().getName()).getPlayers()) {
//							if (!all.getName().equals(p.getName())) {
//								all.sendMessage(join);
//							}
//						}
//					}
//					}
//			}
//		} else if (p.hasPermission("H.HeadAdmin")) {
//			if (!API.isVanished(p.getName())) {
//			if (ss.getInfo().getName().equals("Hub")) {
//				TextComponent join = API.getHoverClickRunCommandSuggest("§6" + p.getName() + " §7joined the lobby", "§7Rank: §6HeadAdmin", "contact");
//				for (ProxiedPlayer all : BungeeCord.getInstance().getServerInfo(ss.getInfo().getName()).getPlayers()) {
//					if (!all.getName().equals(p.getName())) {
//						all.sendMessage(join);
//					}
//				}
//			} else {
//				TextComponent join = API.getHoverClickRunCommandSuggest("§6" + p.getName() + " §7joined the game", "§7Rank: §6HeadAdmin", "contact");
//				for (ProxiedPlayer all : BungeeCord.getInstance().getServerInfo(ss.getInfo().getName()).getPlayers()) {
//					if (!all.getName().equals(p.getName())) {
//						all.sendMessage(join);
//					}
//				}
//			}
//			}
//		} else if (p.hasPermission("H.Admin")) {
//			if (!API.isVanished(p.getName())) {
//			if (ss.getInfo().getName().equals("Hub")) {
//				TextComponent join = API.getHoverClickRunCommandSuggest("§4" + p.getName() + " §7joined the lobby", "§7Rank: §4Admin", "contact");
//				for (ProxiedPlayer all : BungeeCord.getInstance().getServerInfo(ss.getInfo().getName()).getPlayers()) {
//					if (!all.getName().equals(p.getName())) {
//						all.sendMessage(join);
//					}
//				}
//			} else {
//				TextComponent join = API.getHoverClickRunCommandSuggest("§4" + p.getName() + " §7joined the game", "§7Rank: §4Admin", "contact");
//				for (ProxiedPlayer all : BungeeCord.getInstance().getServerInfo(ss.getInfo().getName()).getPlayers()) {
//					if (!all.getName().equals(p.getName())) {
//						all.sendMessage(join);
//					}
//				}
//			}
//			}
//		} else if (p.hasPermission("H.Developer")) {
//			if (!API.isVanished(p.getName())) {
//			if (ss.getInfo().getName().equals("Hub")) {
//				TextComponent join = API.getHoverClickRunCommandSuggest("§f" + p.getName() + " §7joined the lobby", "§7Rank: §fDeveloper", "contact");
//				for (ProxiedPlayer all : BungeeCord.getInstance().getServerInfo(ss.getInfo().getName()).getPlayers()) {
//					if (!all.getName().equals(p.getName())) {
//						all.sendMessage(join);
//					}
//				}
//			} else {
//				TextComponent join = API.getHoverClickRunCommandSuggest("§f" + p.getName() + " §7joined the game", "§7Rank: §fDeveloper", "contact");
//				for (ProxiedPlayer all : BungeeCord.getInstance().getServerInfo(ss.getInfo().getName()).getPlayers()) {
//					if (!all.getName().equals(p.getName())) {
//						all.sendMessage(join);
//					}
//				}
//			}
//			}
//		} else if (p.hasPermission("H.Special")) {
//			if (!API.isVanished(p.getName())) {
//			if (ss.getInfo().getName().equals("Hub")) {
//				TextComponent join = API.getHoverClickRunCommandSuggest("§f" + p.getName() + " §7joined the lobby", "§7Rank: §fSpecial", "contact");
//				for (ProxiedPlayer all : BungeeCord.getInstance().getServerInfo(ss.getInfo().getName()).getPlayers()) {
//					if (!all.getName().equals(p.getName())) {
//						all.sendMessage(join);
//					}
//				}
//			} else {
//				TextComponent join = API.getHoverClickRunCommandSuggest("§f" + p.getName() + " §7joined the game", "§7Rank: §fSpecial", "contact");
//				for (ProxiedPlayer all : BungeeCord.getInstance().getServerInfo(ss.getInfo().getName()).getPlayers()) {
//					if (!all.getName().equals(p.getName())) {
//						all.sendMessage(join);
//					}
//				}
//			}
//			}
//		} else if (p.hasPermission("H.SrMod")) {
//			if (!API.isVanished(p.getName())) {
//			if (ss.getInfo().getName().equals("Hub")) {
//				TextComponent join = API.getHoverClickRunCommandSuggest("§4" + p.getName() + " §7joined the lobby", "§7Rank: §4SrMod", "contact");
//				for (ProxiedPlayer all : BungeeCord.getInstance().getServerInfo(ss.getInfo().getName()).getPlayers()) {
//					if (!all.getName().equals(p.getName())) {
//						all.sendMessage(join);
//					}
//				}
//			} else {
//				TextComponent join = API.getHoverClickRunCommandSuggest("§4" + p.getName() + " §7joined the game", "§7Rank: §4SrMod", "contact");
//				for (ProxiedPlayer all : BungeeCord.getInstance().getServerInfo(ss.getInfo().getName()).getPlayers()) {
//					if (!all.getName().equals(p.getName())) {
//						all.sendMessage(join);
//					}
//				}
//			}
//			}
//		} else if (p.hasPermission("H.Mod")) {
//			if (!API.isVanished(p.getName())) {
//			if (ss.getInfo().getName().equals("Hub")) {
//				TextComponent join = API.getHoverClickRunCommandSuggest("§c" + p.getName() + " §7joined the lobby", "§7Rank: §cMod", "contact");
//				for (ProxiedPlayer all : BungeeCord.getInstance().getServerInfo(ss.getInfo().getName()).getPlayers()) {
//					if (!all.getName().equals(p.getName())) {
//						all.sendMessage(join);
//					}
//				}
//			} else {
//				TextComponent join = API.getHoverClickRunCommandSuggest("§c" + p.getName() + " §7joined the game", "§7Rank: §cMod", "contact");
//				for (ProxiedPlayer all : BungeeCord.getInstance().getServerInfo(ss.getInfo().getName()).getPlayers()) {
//					if (!all.getName().equals(p.getName())) {
//						all.sendMessage(join);
//					}
//				}
//			}
//			}
//		} else if (p.hasPermission("H.Helper")) {
//			if (!API.isVanished(p.getName())) {
//			if (ss.getInfo().getName().equals("Hub")) {
//				TextComponent join = API.getHoverClickRunCommandSuggest("§3" + p.getName() + " §7joined the lobby", "§7Rank: §3Helper", "contact");
//				for (ProxiedPlayer all : BungeeCord.getInstance().getServerInfo(ss.getInfo().getName()).getPlayers()) {
//					if (!all.getName().equals(p.getName())) {
//						all.sendMessage(join);
//					}
//				}
//			} else {
//				TextComponent join = API.getHoverClickRunCommandSuggest("§3" + p.getName() + " §7joined the game", "§7Rank: §3Helper", "contact");
//				for (ProxiedPlayer all : BungeeCord.getInstance().getServerInfo(ss.getInfo().getName()).getPlayers()) {
//					if (!all.getName().equals(p.getName())) {
//						all.sendMessage(join);
//					}
//				}
//			}
//			}
//		} else if (p.hasPermission("H.Builder")) {
//			if (ss.getInfo().getName().equals("Hub")) {
//				TextComponent join = API.getHoverClickRunCommandSuggest("§2" + p.getName() + " §7joined the lobby", "§7Rank: §2Builder", "contact");
//				for (ProxiedPlayer all : BungeeCord.getInstance().getServerInfo(ss.getInfo().getName()).getPlayers()) {
//					if (!all.getName().equals(p.getName())) {
//						all.sendMessage(join);
//					}
//				}
//			} else {
//				TextComponent join = API.getHoverClickRunCommandSuggest("§2" + p.getName() + " §7joined the game", "§7Rank: §2Builder", "contact");
//				for (ProxiedPlayer all : BungeeCord.getInstance().getServerInfo(ss.getInfo().getName()).getPlayers()) {
//					if (!all.getName().equals(p.getName())) {
//						all.sendMessage(join);
//					}
//				}
//			}
//		} else if (p.hasPermission("H.VIP")) {
//			if (ss.getInfo().getName().equals("Hub")) {
//				TextComponent join = API.getHoverClickRunCommandSuggest("§5" + p.getName() + " §7joined the lobby", "§7Rank: §5VIP", "contact");
//				for (ProxiedPlayer all : BungeeCord.getInstance().getServerInfo(ss.getInfo().getName()).getPlayers()) {
//					if (!all.getName().equals(p.getName())) {
//						all.sendMessage(join);
//					}
//				}
//			} else {
//				TextComponent join = API.getHoverClickRunCommandSuggest("§5" + p.getName() + " §7joined the game", "§7Rank: §5VIP", "contact");
//				for (ProxiedPlayer all : BungeeCord.getInstance().getServerInfo(ss.getInfo().getName()).getPlayers()) {
//					if (!all.getName().equals(p.getName())) {
//						all.sendMessage(join);
//					}
//				}
//			}
//		} else if (p.hasPermission("H.Emerald")) {
//			if (ss.getInfo().getName().equals("Hub")) {
//				TextComponent join = API.getHoverClickRunCommandSuggest("§a" + p.getName() + " §7joined the lobby", "§7Rank: §aEmerald", "contact");
//				for (ProxiedPlayer all : BungeeCord.getInstance().getServerInfo(ss.getInfo().getName()).getPlayers()) {
//					if (!all.getName().equals(p.getName())) {
//						all.sendMessage(join);
//					}
//				}
//			} else {
//				TextComponent join = API.getHoverClickRunCommandSuggest("§a" + p.getName() + " §7joined the game", "§7Rank: §aEmerald", "contact");
//				for (ProxiedPlayer all : BungeeCord.getInstance().getServerInfo(ss.getInfo().getName()).getPlayers()) {
//					if (!all.getName().equals(p.getName())) {
//						all.sendMessage(join);
//					}
//				}
//			}
//		} else if (p.hasPermission("H.Diamond")) {
//			if (ss.getInfo().getName().equals("Hub")) {
//				TextComponent join = API.getHoverClickRunCommandSuggest("§b" + p.getName() + " §7joined the lobby", "§7Rank: §bDiamond", "contact");
//				for (ProxiedPlayer all : BungeeCord.getInstance().getServerInfo(ss.getInfo().getName()).getPlayers()) {
//					if (!all.getName().equals(p.getName())) {
//						all.sendMessage(join);
//					}
//				}
//			} else {
//				TextComponent join = API.getHoverClickRunCommandSuggest("§b" + p.getName() + " §7joined the game", "§7Rank: §bDiamond", "contact");
//				for (ProxiedPlayer all : BungeeCord.getInstance().getServerInfo(ss.getInfo().getName()).getPlayers()) {
//					if (!all.getName().equals(p.getName())) {
//						all.sendMessage(join);
//					}
//				}
//			}
//		} else if (p.hasPermission("H.Gold")) {
//			if (ss.getInfo().getName().equals("Hub")) {
//				TextComponent join = API.getHoverClickRunCommandSuggest("§6" + p.getName() + " §7joined the lobby", "§7Rank: §6Gold", "contact");
//				for (ProxiedPlayer all : BungeeCord.getInstance().getServerInfo(ss.getInfo().getName()).getPlayers()) {
//					if (!all.getName().equals(p.getName())) {
//						all.sendMessage(join);
//					}
//				}
//			} else {
//				TextComponent join = API.getHoverClickRunCommandSuggest("§6" + p.getName() + " §7joined the game", "§7Rank: §6Gold", "contact");
//				for (ProxiedPlayer all : BungeeCord.getInstance().getServerInfo(ss.getInfo().getName()).getPlayers()) {
//					if (!all.getName().equals(p.getName())) {
//						all.sendMessage(join);
//					}
//				}
//			}
//		} else if (p.hasPermission("H.YouTuber")) {
//			if (ss.getInfo().getName().equals("Hub")) {
//				TextComponent join = API.getHoverClickRunCommandSuggest("§5" + p.getName() + " §7joined the lobby", "§7Rank: §5YouTuber", "contact");
//				for (ProxiedPlayer all : BungeeCord.getInstance().getServerInfo(ss.getInfo().getName()).getPlayers()) {
//					if (!all.getName().equals(p.getName())) {
//						all.sendMessage(join);
//					}
//				}
//			} else {
//				TextComponent join = API.getHoverClickRunCommandSuggest("§5" + p.getName() + " §7joined the game", "§7Rank: §5YouTuber", "contact");
//				for (ProxiedPlayer all : BungeeCord.getInstance().getServerInfo(ss.getInfo().getName()).getPlayers()) {
//					if (!all.getName().equals(p.getName())) {
//						all.sendMessage(join);
//					}
//				}
//			}
//		}
//	}

}
