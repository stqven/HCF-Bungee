package le.inv.ho.Listeners;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

import de.simonsator.partyandfriends.api.adapter.BukkitBungeeAdapter;
import le.inv.ho.API;
import le.inv.ho.Arabic;
import le.inv.ho.BanU;
import le.inv.ho.Main;
import le.inv.ho.MuteU;
import le.inv.ho.Utilts;
import le.inv.ho.msgsql;
import le.inv.ho.Commands.MutesAPI;
import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.ChatEvent;
import net.md_5.bungee.api.event.PluginMessageEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;
import net.md_5.bungee.event.EventHandler;

public class ChatListener implements Listener {
	public static Plugin plugin;
	public ChatListener(Plugin plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onMSGRec(PluginMessageEvent e) {
		if (e.isCancelled()) return;
		if (e.getTag().contains("BungeeCord")) {
		    try {
		        DataInputStream in = new DataInputStream(new ByteArrayInputStream(e.getData()));
		        String task = in.readUTF();
		        if (task.contains("Report")) {
					BungeeCord.getInstance().getPlayer("InVisTeK_").sendMessage("" + task.toString());
		        	ArrayList<String> players = new ArrayList<String>(Arrays.asList(task.replace("Report", "").split("-")));
		        	String pname = players.get(0), tname = players.get(1), reason = players.get(2);
					ProxiedPlayer p = BungeeCord.getInstance().getPlayer(pname);
					ProxiedPlayer t = BungeeCord.getInstance().getPlayer(tname);
					String name = t.getServer().getInfo().getName();
					for (ProxiedPlayer all : BungeeCord.getInstance().getPlayers()) {
						if (all.hasPermission("H.Owner") || all.hasPermission("H.Admin") || all.hasPermission("H.SrMod") || all.hasPermission("H.Mod") || all.hasPermission("H.Special") || all.hasPermission("H.Developer") || all.hasPermission("H.Helper")) {
							all.sendMessage(API.getHoverClickRunCommandMessage("§4┃ §7" + API.getP(tname) + "§9 was reported by §7" + API.getP(pname) + "§9 for §9(§4§l" + reason + "§9)", "§eClick to teleport to §6" + name, name));
						}
					}
		        } else if (task.contains("Swaring")) {
					ArrayList<String> players = new ArrayList<String>(Arrays.asList(task.replace("Swaring", "").split("-")));
					String pname = (String)players.get(0), server = (String)players.get(1), msg = (String)players.get(2);
					for (ProxiedPlayer all : BungeeCord.getInstance().getPlayers()) {
						if (all.hasPermission("H.Owner") || all.hasPermission("H.Admin") || all.hasPermission("H.SrMod") || all.hasPermission("H.Mod") || all.hasPermission("H.Lord") || all.hasPermission("H.Developer") || all.hasPermission("H.Helper")) {
							all.sendMessage("§8┃ §cBLOCKED §8(§c" + server + "§8) §8┃ §f" + API.getP(pname) + " §8: §f" + msg);
						}
					}
				}  else if (task.startsWith("PunPlayer")) {
					ArrayList<String> pun = new ArrayList<String>(Arrays.asList(task.toString().replace("PunPlayer", "").split("QQQ")));
					String pname = pun.get(0);
					String tID = pun.get(1);
					String reason = pun.get(2);
					Long time = Long.valueOf(pun.get(3));
					boolean ban = Boolean.valueOf(pun.get(4));
					String eve = pun.get(5);
					int punID = Main.getRandom(10000, 99999);
					String tname = msgsql.getIDPlayer(tID);
					if (ban) {
						BanU.banPlayer(tID, reason, time, pname, Integer.toString(punID), eve);
						for (ProxiedPlayer all : BungeeCord.getInstance().getPlayers()) {
							if (all.hasPermission("H.Owner") || all.hasPermission("H.HeadAdmin") || all.hasPermission("H.Admin") || all.hasPermission("H.Developer") || all.hasPermission("H.Special") || all.hasPermission("H.SrMod") || all.hasPermission("H.Mod") || all.hasPermission("H.Helper")) {
								all.sendMessage("§8┃ §6HozexMC §8┃ §3" + API.getP(tname) + " §7was banned by " + API.getP(pname) + " §7for §4" + reason);
								all.sendMessage("§8┃ §6HozexMC §8┃ §7Ban ID:§c " + punID);
							} else {
								all.sendMessage("§c§lA§c§l §c§lP§c§ll§c§la§c§ly§c§le§c§lr§c§l §c§lw§c§la§c§ls§c§l §c§lr§c§le§c§lm§c§lo§c§lv§c§le§c§ld§c§l §c§lf§c§lr§c§lo§c§lm§c§l §c§ly§c§lo§c§lu§c§lr§c§l §c§lg§c§la§c§lm§c§le §c§lf§c§lo§c§lr§c§l §c§lh§c§la§c§lc§c§lk§c§li§c§ln§c§lg§c§l §c§lt§c§lh§c§la§c§ln§c§lk§c§ls§c§l §c§lf§c§lo§c§lr§c§l §c§lr§c§le§c§lp§c§lo§c§lr§c§lt§c§li§c§ln§c§lg§c§l §c§lh§c§li§c§lm");
							}
							if (!eve.equalsIgnoreCase("-")) {
								if (all.hasPermission("H.Owner") || all.hasPermission("H.HeadAdmin") || all.hasPermission("H.Admin") || all.hasPermission("H.SrMod")) {
									all.sendMessage("§8┃ §6HozexMC §8┃ §7Evedence:§c " + eve);
								}
							}
						}
					} else {
						MuteU.mutePlayer(tID, reason, time, pname, Integer.toString(punID), eve);
						ProxiedPlayer t = BungeeCord.getInstance().getPlayer(msgsql.getIDPlayer(tID));
						if (t != null) {
							int day = (int) (time/((1000*3600*24)));
							int hour = (int) ((time%(1000*3600*24))/(1000*3600));
							int min = (int) (((time%((1000*3600*24)))%(1000*3600))/(1000*60));
							int sec = (int) ((((time%((1000*3600*24)))%(1000*3600))%(1000*60))/(1000));
							StringBuilder time1 = new StringBuilder();
							if (day > 0) {
								if (day > 1) {
									time1.append(day + " days ");
								} else {
									time1.append(day + " day ");
								}
							}
							if (hour > 0) {
								if (hour > 1) {
									time1.append(hour + " hours ");
								} else {
									time1.append(hour + " hour ");
								}
							}
							if (min > 0) {
								if (min > 1) {
									time1.append(min + " minutes ");
								} else {
									time1.append(min + " minute ");
								}
							}
							if (time1.toString().equals("")) {
								if (sec > 1) {
									time1.append(sec + " seconds ");
								} else {
									time1.append(sec + " second ");
								}
							}
							t.sendMessage("§8§m-------------§7§m-------§f- « §4Bans§7 §f» §f§m-§7§m-------§8§m-------------");
							t.sendMessage("§8┃ §eHozexMC §8┃ §7You have been muted from this server!");
							t.sendMessage("§8┃ §eHozexMC §8┃ §7Mute ID: §c#" + punID);
							t.sendMessage("§8┃ §eHozexMC §8┃ §7Duration: §c" + time1.toString());
							t.sendMessage("§8┃ §eHozexMC §8┃ §7Appeal at: §cdiscord.gg/qk4HT43");
							t.sendMessage("§8┃ §eHozexMC §8┃ §7Give us your Mute ID");
							t.sendMessage("§8§m---------------§7§m-------§f- « §c✦§7 §f» §f§m-§7§m-------§8§m--------------");
						}
						for (ProxiedPlayer all : BungeeCord.getInstance().getPlayers()) {
							if (all.hasPermission("H.Owner") || all.hasPermission("H.HeadAdmin") || all.hasPermission("H.Admin") || all.hasPermission("H.Developer") || all.hasPermission("H.Special") || all.hasPermission("H.SrMod") || all.hasPermission("H.Mod") || all.hasPermission("H.Helper")) {
								all.sendMessage("§8┃ §6HozexMC §8┃ §3" + API.getP(tname) + " §7was muted by " + API.getP(pname) + " §7for §4" + reason);
								all.sendMessage("§8┃ §6HozexMC §8┃ §7Mute ID:§c " + punID);
							}
							if (!eve.equalsIgnoreCase("-")) {
								if (all.hasPermission("H.Owner") || all.hasPermission("H.HeadAdmin") || all.hasPermission("H.Admin") || all.hasPermission("H.SrMod")) {
									all.sendMessage("§8┃ §6HozexMC §8┃ §7Evedence:§c " + eve);
								}
							}
						}
					}
				} else if (task.startsWith("RemovePunPlayer")) {
					ArrayList<String> pun = new ArrayList<String>(Arrays.asList(task.toString().replace("PunPlayer", "").split("QQQ")));
					String pname = pun.get(0);
					String tID = pun.get(1);
					String reason = pun.get(2);
					Long time = Long.valueOf(pun.get(3));
					boolean ban = Boolean.valueOf(pun.get(4));
					String eve = pun.get(5);
					int punID = Main.getRandom(10000, 99999);
					String tname = msgsql.getIDPlayer(tID);
					if (ban) {
						for (ProxiedPlayer all : BungeeCord.getInstance().getPlayers()) {
							if (all.hasPermission("H.Owner") || all.hasPermission("H.HeadAdmin") || all.hasPermission("H.Admin") || all.hasPermission("H.Developer") || all.hasPermission("H.Special") || all.hasPermission("H.SrMod") || all.hasPermission("H.Mod") || all.hasPermission("H.Helper")) {
								all.sendMessage("§8┃ §6HozexMC §8┃ §3" + API.getP(tname) + " §7was banned by " + API.getP(pname) + " §7for §4" + reason);
								all.sendMessage("§8┃ §6HozexMC §8┃ §7Ban ID:§c " + punID);
							} else {
								all.sendMessage("§c§lA§c§l §c§lP§c§ll§c§la§c§ly§c§le§c§lr§c§l §c§lw§c§la§c§ls§c§l §c§lr§c§le§c§lm§c§lo§c§lv§c§le§c§ld§c§l §c§lf§c§lr§c§lo§c§lm§c§l §c§ly§c§lo§c§lu§c§lr§c§l §c§lg§c§la§c§lm§c§le §c§lf§c§lo§c§lr§c§l §c§lh§c§la§c§lc§c§lk§c§li§c§ln§c§lg§c§l §c§lt§c§lh§c§la§c§ln§c§lk§c§ls§c§l §c§lf§c§lo§c§lr§c§l §c§lr§c§le§c§lp§c§lo§c§lr§c§lt§c§li§c§ln§c§lg§c§l §c§lh§c§li§c§lm");
							}
							if (!eve.equalsIgnoreCase("-")) {
								if (all.hasPermission("H.Owner") || all.hasPermission("H.HeadAdmin") || all.hasPermission("H.Admin") || all.hasPermission("H.SrMod")) {
									all.sendMessage("§8┃ §6HozexMC §8┃ §7Evedence:§c " + eve);
								}
							}
						}
					} else {
						ProxiedPlayer t = BungeeCord.getInstance().getPlayer(msgsql.getIDPlayer(tID));
						if (t != null) {
							int day = (int) (time/((1000*3600*24)));
							int hour = (int) ((time%(1000*3600*24))/(1000*3600));
							int min = (int) (((time%((1000*3600*24)))%(1000*3600))/(1000*60));
							int sec = (int) ((((time%((1000*3600*24)))%(1000*3600))%(1000*60))/(1000));
							StringBuilder time1 = new StringBuilder();
							if (day > 0) {
								if (day > 1) {
									time1.append(day + " days ");
								} else {
									time1.append(day + " day ");
								}
							}
							if (hour > 0) {
								if (hour > 1) {
									time1.append(hour + " hours ");
								} else {
									time1.append(hour + " hour ");
								}
							}
							if (min > 0) {
								if (min > 1) {
									time1.append(min + " minutes ");
								} else {
									time1.append(min + " minute ");
								}
							}
							if (time1.toString().equals("")) {
								if (sec > 1) {
									time1.append(sec + " seconds ");
								} else {
									time1.append(sec + " second ");
								}
							}
							t.sendMessage("§8§m-------------§7§m-------§f- « §4Bans§7 §f» §f§m-§7§m-------§8§m-------------");
							t.sendMessage("§8┃ §eHozexMC §8┃ §7Your mute has been continued!");
							t.sendMessage("§8┃ §eHozexMC §8┃ §7Mute ID: §c#" + punID);
							t.sendMessage("§8┃ §eHozexMC §8┃ §7Duration: §c" + time1.toString());
							t.sendMessage("§8┃ §eHozexMC §8┃ §7Appeal at: §cdiscord.gg/qk4HT43");
							t.sendMessage("§8┃ §eHozexMC §8┃ §7Give us your Mute ID");
							t.sendMessage("§8§m---------------§7§m-------§f- « §c✦§7 §f» §f§m-§7§m-------§8§m--------------");
						}
						for (ProxiedPlayer all : BungeeCord.getInstance().getPlayers()) {
							if (all.hasPermission("H.Owner") || all.hasPermission("H.HeadAdmin") || all.hasPermission("H.Admin") || all.hasPermission("H.Developer") || all.hasPermission("H.Special") || all.hasPermission("H.SrMod") || all.hasPermission("H.Mod") || all.hasPermission("H.Helper")) {
								all.sendMessage("§8┃ §6HozexMC §8┃ §3" + API.getP(tname) + " §7mute's was continued by " + API.getP(pname) + " §7for §4" + reason);
								all.sendMessage("§8┃ §6HozexMC §8┃ §7Mute ID:§c " + punID);
							}
							if (!eve.equalsIgnoreCase("-")) {
								if (all.hasPermission("H.Owner") || all.hasPermission("H.HeadAdmin") || all.hasPermission("H.Admin") || all.hasPermission("H.SrMod")) {
									all.sendMessage("§8┃ §6HozexMC §8┃ §7Evedence:§c " + eve);
								}
							}
						}
					}
				}
		    } catch (IOException ex) {
		        
		        ex.printStackTrace();
		      } 
		}
	}
	
	@EventHandler
	public void onChat(ChatEvent e) {
		ProxiedPlayer p = (ProxiedPlayer) e.getSender();
		if (p.getServer().getInfo().getName().contains("AuthMe")) {
			if (e.getMessage().startsWith("/l") || e.getMessage().startsWith("/login") || e.getMessage().startsWith("/reg") || e.getMessage().startsWith("/register")) {
				
			} else {
				e.setCancelled(true);
				return;
			}
		}
//		if (!e.getMessage().startsWith("/")) {
//			int time = API.getCurrentOT(p.getName());
//			if (time < 600) {
//				e.setCancelled(true);
//				p.sendMessage("§8▏ §cHozexMC §8▏ §7Please wait §e" + (time - 600) + " §7to talk");
//			}
//		}
		if (!e.isCommand()) {
			String pID = Integer.toString(msgsql.getPlayerID(p.getName()));
			if (MuteU.isMuted(pID)) {
				Long time = Long.valueOf(MuteU.getTime(pID, 1).get(0)) - System.currentTimeMillis();
				int day = (int) (time/((1000*3600*24)));
				int hour = (int) ((time%(1000*3600*24))/(1000*3600));
				int min = (int) (((time%((1000*3600*24)))%(1000*3600))/(1000*60));
				int sec = (int) ((((time%((1000*3600*24)))%(1000*3600))%(1000*60))/(1000));
				StringBuilder time1 = new StringBuilder();
				if (day > 0) {
					if (day > 1) {
						time1.append(day + " days ");
					} else {
						time1.append(day + " day ");
					}
				}
				if (hour > 0) {
					if (hour > 1) {
						time1.append(hour + " hours ");
					} else {
						time1.append(hour + " hour ");
					}
				}
				if (min > 0) {
					if (min > 1) {
						time1.append(min + " minutes ");
					} else {
						time1.append(min + " minute ");
					}
				}
				if (time1.toString().equals("")) {
					if (sec > 1) {
						time1.append(sec + " seconds ");
					} else {
						time1.append(sec + " second ");
					}
				}
				p.sendMessage("§8┃ §cHozexMC §8┃ §aYou are muted for §e" + time1.toString());
				p.sendMessage("§8┃ §cHozexMC §8┃ §aMute ID: §e" + MuteU.getMuteIDs(pID, 1).get(0));
    			e.setCancelled(true);
			}
		if (e.getMessage().startsWith("/premium") || e.getMessage().startsWith("/skin")) {
			if (!p.getServer().getInfo().getName().contains("Hub")) {
				e.setCancelled(true);
				p.sendMessage("§8▏ §cHozexMC §8▏ §7This command can only be executed in §eHub");
			}
		} else if (e.getMessage().startsWith("/b ")) {
			if (p.getServer().getInfo().getName().contains("Creative")) {
				e.setMessage(e.getMessage().replace("/b ", "/voxelsniper:b "));
			}
		} else if (e.getMessage().startsWith("/be ")) {
			if (p.getServer().getInfo().getName().contains("Creative")) {
				e.setMessage(e.getMessage().replace("/be ", "/m "));
			}
		} else if (e.getMessage().startsWith("/party invite ")) {
			String name = e.getMessage().replace("/party invite ", "");
			boolean ishere = false;
			if (!p.hasPermission("H.Partybypass")) {
				if (!API.isVanished(name)) {
					for (ProxiedPlayer all : BungeeCord.getInstance().getPlayers()) {
						if (all.getName().toLowerCase().contains(name)) {
							ishere = true;
						}
					}
				}
				if (!ishere) {
					e.setCancelled(true);
					p.sendMessage("§8▏ §cParty §8▏ §7You can't invite this player to your party");
				}
			}
		}
			if (e.getMessage().startsWith("/")) {
			String msg = e.getMessage().replace("/", ""), srv = p.getServer().getInfo().getName().toLowerCase();
			if (msg.equalsIgnoreCase("sredstonepvp") || msg.equalsIgnoreCase("sredpvp") || msg.equalsIgnoreCase("srpvp")) {
				if (p.hasPermission("H.Owner") || p.hasPermission("H.HeadAdmin") || p.hasPermission("H.Admin") || p.hasPermission("H.Developer") || p.hasPermission("H.SrMod") || p.hasPermission("H.Mod")) {
					if (!srv.equalsIgnoreCase("redstonepvp")) {
						e.setCancelled(true);
						API.setVanished(p.getName(), true);
						p.connect(BungeeCord.getInstance().getServerInfo("RedstonePvP"));
					}
				} else {
					e.setCancelled(true);p.sendMessage("§cYou are already connected to this server!");e.setCancelled(true);
				}
			} else if (msg.equalsIgnoreCase("spractice") || msg.equalsIgnoreCase("sprac")) {
				if (p.hasPermission("H.Owner") || p.hasPermission("H.HeadAdmin") || p.hasPermission("H.Admin") || p.hasPermission("H.Developer") || p.hasPermission("H.SrMod") || p.hasPermission("H.Mod")) {
					if (!srv.equalsIgnoreCase("practice")) {
						e.setCancelled(true);
						API.setVanished(p.getName(), true);
						p.connect(BungeeCord.getInstance().getServerInfo("Practice"));
					}
				} else {
					e.setCancelled(true);p.sendMessage("§cYou are already connected to this server!");e.setCancelled(true);
				}
			} else if (msg.equalsIgnoreCase("sskypvp") || msg.equalsIgnoreCase("sspvp")) {
				if (p.hasPermission("H.Owner") || p.hasPermission("H.HeadAdmin") || p.hasPermission("H.Admin") || p.hasPermission("H.Developer") || p.hasPermission("H.SrMod") || p.hasPermission("H.Mod")) {
					if (!srv.equalsIgnoreCase("skypvp")) {
						e.setCancelled(true);
						API.setVanished(p.getName(), true);
						p.connect(BungeeCord.getInstance().getServerInfo("SkyPvP"));
					}
				} else {
					e.setCancelled(true);p.sendMessage("§cYou are already connected to this server!");e.setCancelled(true);
				}
			} else if (msg.equalsIgnoreCase("screatigve") || msg.equalsIgnoreCase("scr")) {
				if (p.hasPermission("H.Owner") || p.hasPermission("H.HeadAdmin") || p.hasPermission("H.Admin") || p.hasPermission("H.Developer") || p.hasPermission("H.SrMod") || p.hasPermission("H.Mod")) {
					if (!srv.equalsIgnoreCase("creative")) {
						e.setCancelled(true);
						API.setVanished(p.getName(), true);
						p.connect(BungeeCord.getInstance().getServerInfo("Creative"));
					}
				} else {
					e.setCancelled(true);p.sendMessage("§cYou are already connected to this server!");e.setCancelled(true);
				}
			} else if (msg.equalsIgnoreCase("sgungame")) {
				if (p.hasPermission("H.Owner") || p.hasPermission("H.HeadAdmin") || p.hasPermission("H.Admin") || p.hasPermission("H.Developer") || p.hasPermission("H.SrMod") || p.hasPermission("H.Mod")) {
					if (!msg.equalsIgnoreCase(srv)) {
						e.setCancelled(true);
						API.setVanished(p.getName(), true);
						p.connect(BungeeCord.getInstance().getServerInfo("GunGame"));
					}
				} else {
					e.setCancelled(true);p.sendMessage("§cYou are already connected to this server!");e.setCancelled(true);
				}
			} else if (msg.equalsIgnoreCase("sffa")) {
				if (p.hasPermission("H.Owner") || p.hasPermission("H.HeadAdmin") || p.hasPermission("H.Admin") || p.hasPermission("H.Developer") || p.hasPermission("H.SrMod") || p.hasPermission("H.Mod")) {
					if (!srv.equalsIgnoreCase("ffa")) {
						e.setCancelled(true);
						API.setVanished(p.getName(), true);
						p.connect(BungeeCord.getInstance().getServerInfo("FFA"));
					}
				} else {
					e.setCancelled(true);p.sendMessage("§cYou are already connected to this server!");e.setCancelled(true);
				}
			} else if (msg.equalsIgnoreCase("redstonepvp") || msg.equalsIgnoreCase("redpvp") || msg.equalsIgnoreCase("rpvp")) {
				if (!srv.equalsIgnoreCase("redstonepvp")) {
					e.setCancelled(true);
					p.connect(BungeeCord.getInstance().getServerInfo("RedstonePvP"));
				} else {
					e.setCancelled(true);p.sendMessage("§cYou are already connected to this server!");e.setCancelled(true);
				}
			} else if (msg.equalsIgnoreCase("skypvp") || msg.equalsIgnoreCase("spvp")) {
				if (!srv.equalsIgnoreCase("skypvp")) {
					e.setCancelled(true);
					p.connect(BungeeCord.getInstance().getServerInfo("SkyPvP"));
				} else {
					e.setCancelled(true);p.sendMessage("§cYou are already connected to this server!");e.setCancelled(true);
				}
			} else if (msg.equalsIgnoreCase("creative") || msg.equalsIgnoreCase("cr")) {
				if (!srv.equalsIgnoreCase("creative")) {
					e.setCancelled(true);
					p.connect(BungeeCord.getInstance().getServerInfo("Creative"));
				} else {
					e.setCancelled(true);p.sendMessage("§cYou are already connected to this server!");e.setCancelled(true);
				}
			} else if (msg.equalsIgnoreCase("practice") || msg.equalsIgnoreCase("prac")) {
				if (!srv.equalsIgnoreCase("practice")) {
					e.setCancelled(true);
					p.connect(BungeeCord.getInstance().getServerInfo("Practice"));
				} else {
					e.setCancelled(true);p.sendMessage("§cYou are already connected to this server!");e.setCancelled(true);
				}
			} else if (msg.equalsIgnoreCase("gungame")) {
				if (!msg.equalsIgnoreCase(srv)) {
					e.setCancelled(true);
					p.connect(BungeeCord.getInstance().getServerInfo("GunGame"));
				} else {
					e.setCancelled(true);p.sendMessage("§cYou are already connected to this server!");e.setCancelled(true);
				}
			} else if (msg.equalsIgnoreCase("ffa")) {
				if (!srv.equalsIgnoreCase("ffa")) {
					e.setCancelled(true);
					p.connect(BungeeCord.getInstance().getServerInfo("FFA"));
				} else {
					e.setCancelled(true);p.sendMessage("§cYou are already connected to this server!");e.setCancelled(true);
				}
			}
		  }
		}
	}
//	@EventHandler
//	public void onChat(ChatEvent e) {
//		ProxiedPlayer p = (ProxiedPlayer) e.getSender();
//		  File file1 = new File("plugins/OnlineTime/names.yml");
//		  File file2 = new File("plugins/OnlineTime/time.yml");	
//		  
//		  
//		  try {
//				Configuration names = ConfigurationProvider.getProvider(YamlConfiguration.class).load(file1);
//				Configuration time = ConfigurationProvider.getProvider(YamlConfiguration.class).load(file2);
//				
//				  String uuid1 = names.getString(p.getName());
//				  int time1 = time.getInt("" + p.getUniqueId());
//				  int stay = 180 - time1;
//				  int stay2 = stay/60;
//				  if (time1 < 180) {
//					  if (e.getMessage().startsWith("/")) {
//						  
//					  } else {
//						  e.setCancelled(true);
//						  p.sendMessage("§bYou must play §e5 minutes §bbefore talking in the chat");
//						  p.sendMessage("§eTime remaining:§c " + stay2 + " minute");
//					  }
//				  }
//				  
//	    		  ConfigurationProvider.getProvider(YamlConfiguration.class).save(time, file2);
//				
//			} catch (IOException ez) {
//				ez.printStackTrace();
//			}
//	}
	
	@EventHandler
	public void onBlockAuth(ChatEvent e) {
		ProxiedPlayer p = (ProxiedPlayer) e.getSender();
		if (p.getServer().getInfo().getName().contains("AuthMe")) {
			if (e.getMessage().startsWith("/l") || e.getMessage().startsWith("/login") || e.getMessage().startsWith("/reg") || e.getMessage().startsWith("/register")) {
				
			} else {
				e.setCancelled(true);
				return;
			}
		}
	}
	
	@EventHandler
	public void onChatP(ChatEvent e) {
		ProxiedPlayer p = (ProxiedPlayer) e.getSender();
		if (p.getServer().getInfo().getName().contains("AuthMe")) {
			if (e.getMessage().startsWith("/l") || e.getMessage().startsWith("/login") || e.getMessage().startsWith("/reg") || e.getMessage().startsWith("/register")) {
				
			} else {
				e.setCancelled(true);
				return;
			}
		}
//		String msg = e.getMessage().toLowerCase();
//		if (msg.contains("ks ") || msg.contains("ksmk") || msg.contains("ks5tk") || msg.contains("ksamk") || msg.contains("kos ") || msg.contains("6ez") || msg.contains("tez") || msg.contains("z8") || msg.contains("klz8") || msg.contains("m9") || msg.contains("amk") || msg.contains("a5tk") || msg.contains("6ezk") || msg.contains("5ra") || msg.contains("zb") || msg.contains("mm7on") || msg.contains("zbk") || msg.contains("mkwtk") || msg.contains("anek") || msg.contains("bnek") || msg.contains("tl7s") || msg.contains("a5tk") || msg.contains("o5tk") || msg.contains("emk") || msg.contains("abok") || msg.contains("a5ok")) {
//			if (!e.isCancelled()) {
//				for (ProxiedPlayer all : BungeeCord.getInstance().getPlayers()) {
//					if (all.hasPermission("H.Owner") || all.hasPermission("H.HeadAdmin") || all.hasPermission("H.Admin") || all.hasPermission("H.Developer") || all.hasPermission("H.Special") || all.hasPermission("H.SrMod") || all.hasPermission("H.Mod") || all.hasPermission("H.Helper")) {
//						all.sendMessage("§8[" + p.getServer().getInfo().getName() + "§8] §f" + p.getName() + ": " + e.getMessage());
//					}
//				}
//			}
//		}
		File file = new File("plugins/HN-Bungee/blockadv.yml");
		try {
			Configuration config = ConfigurationProvider.getProvider(YamlConfiguration.class).load(file);
			List<String> l = config.getStringList("adv");
			boolean block = false;
			for (String str : l) {
				if (e.getMessage().toLowerCase().contains(str.replace("_", " "))) {
					block = true;
				}
			}
			if (e.getMessage().startsWith("\\")) {
				e.setCancelled(true);
				p.sendMessage("§cYour message contains some blocked characters");
			}
			if (block) {
				if (!e.getMessage().startsWith("/blockadv") && !e.getMessage().startsWith("/badv")) {
					e.setCancelled(true);
					if (!e.getMessage().startsWith("/")) {
						p.sendMessage("§8❘ §7" + p.getName() + " §8» §7" + e.getMessage());		
						for (ProxiedPlayer all : BungeeCord.getInstance().getPlayers()) {
							if (all.hasPermission("H.Owner")) {
								all.sendMessage("§8❘ §7" + p.getName() + " §8» §c" + e.getMessage());
							}
						}
					}
				}
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		if (e.getMessage().startsWith("/") && !e.getMessage().startsWith("/reg") && !e.getMessage().startsWith("/register") && !e.getMessage().startsWith("/l") && !e.getMessage().startsWith("/login") && e.getMessage().startsWith("/mod")) {
		}
		if (e.getMessage().startsWith("/g join")) {
			e.setMessage(e.getMessage().replace("/g join", "/gang join"));
		}
		if (e.getMessage().startsWith("/gchat") || e.getMessage().startsWith("/gangchat")) {
			if (e.getMessage().equals("/gchat") || e.getMessage().equals("/gangchat")) {
				
			} else {
				String armsg = e.getMessage().replace("/gchat ", "").replace("/gangchat ", "");
				e.setMessage("/gchat " + Arabic.changeArabic(armsg));
			}
		}
		if (e.getMessage().startsWith("/report")) {
			e.setMessage(e.getMessage().replace("/report", "/dropitems_v1.2:report"));
		}
		if (e.getMessage().equals("/ot " + p.getName()) || e.getMessage().equals("/onlinetime " + p.getName())) {
			BungeeCord.getInstance().getScheduler().schedule(plugin, new Runnable() {
				
				@Override
				public void run() {
					p.sendMessage("§8❘ §eHozexMC §8❘ §7Ranking: §6#" + API.getRanking(p.getName()));
				}
			}, 5, TimeUnit.MILLISECONDS);
		}
	}

}
