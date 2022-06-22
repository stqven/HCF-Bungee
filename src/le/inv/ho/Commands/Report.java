package le.inv.ho.Commands;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import le.inv.ho.API;
import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;

public class Report extends Command {
	private Plugin plugin;
	
	public Report(Plugin plugin) {
		super("report");
		this.plugin = plugin;
	}
	
	ArrayList<String> list = new ArrayList();
	
	public void addDelay(ProxiedPlayer p) {
		list.add(p.getName());
		ProxyServer.getInstance().getScheduler().schedule(plugin, new Runnable() {
			
			@Override
			public void run() {
				list.remove(p.getName());
				
			}
		}, 25, TimeUnit.SECONDS);
	}
	
	public boolean isDelay(ProxiedPlayer p) {
		if (list.contains(p.getName())) {
			return true;
		} else {
			return false;
		}
	}
	
	
	
	@Override
	public void execute(CommandSender sender, String[] args) {
		ProxiedPlayer p = (ProxiedPlayer) sender;
		if (args.length == 0) {
			p.sendMessage("§8┃ §cHozexMC §8┃ §7/report [player] [reason] §8(evedence)");
		} else if (args.length == 1) {
			p.sendMessage("§c§lReport reasons:");
			p.sendMessage("§eKillAura §8▪§e Fly §8▪§e Speed §8▪§e AutoCLicker §8▪§e Glitch §8▪§e BadSkin §8▪§e NoKnock");
			p.sendMessage("§eAdversting §8▪§e Spamming §8▪§e Swearing §8▪§e Disrespect");
		} else if (args.length == 2) {
		    File file3 = new File("plugins/Hozex-Bungee/mods.yml");
			Configuration modsh;
			try {
				modsh = ConfigurationProvider.getProvider(YamlConfiguration.class).load(file3);
			ProxiedPlayer t = BungeeCord.getInstance().getPlayer(args[0]);
			if (t == p) {
				sender.sendMessage("§8┃ §cHozexMC §8┃ §7You can't report yourself");
				return;
			}
			if (t == null) {
				sender.sendMessage("§8┃ §cHozexMC §8┃ §7This player isn't online");
				return;
			}
			if (isDelay(p) == true) {
				sender.sendMessage("§8┃ §cHozexMC §8┃ §7You can report only every 25 seconds.");
				return;
			}
			if (p.hasPermission("hozex.bans")) {
				sender.sendMessage("§8┃ §cHozexMC §8┃ §7You can't use this command");
				return;
			}
			if (args[1].equalsIgnoreCase("KillAura")) {
				if (!modsh.getStringList("mods").contains(args[0])) {
					for (ProxiedPlayer all : BungeeCord.getInstance().getPlayers()) {
						if (all.hasPermission("H.Owner") || all.hasPermission("H.Admin") || all.hasPermission("H.SrMod") || all.hasPermission("H.Mod") || all.hasPermission("H.Lord") || all.hasPermission("H.Developer") || all.hasPermission("H.Helper")) {
							String name = BungeeCord.getInstance().getPlayer(args[0]).getServer().getInfo().getName();
							all.sendMessage(API.getHoverClickRunCommandMessage("§4┃ §7" + API.getP(t.getName()) + "§9 was reported by §7" + API.getP(p.getName()) + "§9 for §9(§4§lKillAura§9)", "§eGo to §6" + name, "s" + name));
						}
					}
					sender.sendMessage("§8┃ §aHozexMC §8┃ §7Thank you for reporting§c " + t.getName());
					addDelay(p);
				} else {
					sender.sendMessage("§8┃ §cHozexMC §8┃ §7You can't report that player");
				}
			} else if (args[1].equalsIgnoreCase("Fly")) {
					if (!modsh.getStringList("mods").contains(args[0])) {
						for (ProxiedPlayer all : BungeeCord.getInstance().getPlayers()) {
							if (all.hasPermission("H.Owner") || all.hasPermission("H.Admin") || all.hasPermission("H.SrMod") || all.hasPermission("H.Mod") || all.hasPermission("H.Lord") || all.hasPermission("H.Developer") || all.hasPermission("H.Helper")) {
								String name = BungeeCord.getInstance().getPlayer(args[0]).getServer().getInfo().getName();
								all.sendMessage(API.getHoverClickRunCommandMessage("§4┃ §7" + API.getP(t.getName()) + "§9 was reported by §7" + API.getP(p.getName()) + "§9 for §9(§4§lFly§9)", "§eGo to §6" + name, "s" + name));
							}
						}
						sender.sendMessage("§8┃ §aHozexMC §8┃ §7Thank you for reporting§c " + t.getName());
						addDelay(p);
					} else {
						sender.sendMessage("§8┃ §cHozexMC §8┃ §7You can't report that player");
					}
			} else if (args[1].equalsIgnoreCase("Speed")) {
				if (!modsh.getStringList("mods").contains(args[0])) {
					for (ProxiedPlayer all : BungeeCord.getInstance().getPlayers()) {
						if (all.hasPermission("H.Owner") || all.hasPermission("H.Admin") || all.hasPermission("H.SrMod") || all.hasPermission("H.Mod") || all.hasPermission("H.Lord") || all.hasPermission("H.Developer") || all.hasPermission("H.Helper")) {
							String name = BungeeCord.getInstance().getPlayer(args[0]).getServer().getInfo().getName();
							all.sendMessage(API.getHoverClickRunCommandMessage("§4┃ §7" + API.getP(t.getName()) + "§9 was reported by §7" + API.getP(p.getName()) + "§9 for §9(§4§lSpeed§9)", "§eGo to §6" + name, "s" + name));
						}
					}
					sender.sendMessage("§8┃ §aHozexMC §8┃ §7Thank you for reporting§c " + t.getName());
					addDelay(p);
				} else {
					sender.sendMessage("§8┃ §cHozexMC §8┃ §7You can't report that player");
				}
			} else if (args[1].equalsIgnoreCase("AutoClicker") || args[1].equalsIgnoreCase("Auto")) {
				if (!modsh.getStringList("mods").contains(args[0])) {
					for (ProxiedPlayer all : BungeeCord.getInstance().getPlayers()) {
						if (all.hasPermission("H.Owner") || all.hasPermission("H.Admin") || all.hasPermission("H.SrMod") || all.hasPermission("H.Mod") || all.hasPermission("H.Lord") || all.hasPermission("H.Developer") || all.hasPermission("H.Helper")) {
							String name = BungeeCord.getInstance().getPlayer(args[0]).getServer().getInfo().getName();
							all.sendMessage(API.getHoverClickRunCommandMessage("§4┃ §7" + API.getP(t.getName()) + "§9 was reported by §7" + API.getP(p.getName()) + "§9 for §9(§4§lAutoClicker§9)", "§eGo to §6" + name, "s" + name));
						}
					}
					sender.sendMessage("§8┃ §aHozexMC §8┃ §7Thank you for reporting§c " + t.getName());
					addDelay(p);
				} else {
					sender.sendMessage("§8┃ §cHozexMC §8┃ §7You can't report that player");
				}
			} else if (args[1].equalsIgnoreCase("Glitch")) {
				if (!modsh.getStringList("mods").contains(args[0])) {
					for (ProxiedPlayer all : BungeeCord.getInstance().getPlayers()) {
						if (all.hasPermission("H.Owner") || all.hasPermission("H.Admin") || all.hasPermission("H.SrMod") || all.hasPermission("H.Mod") || all.hasPermission("H.Lord") || all.hasPermission("H.Developer") || all.hasPermission("H.Helper")) {
							String name = BungeeCord.getInstance().getPlayer(args[0]).getServer().getInfo().getName();
							all.sendMessage(API.getHoverClickRunCommandMessage("§4┃ §7" + API.getP(t.getName()) + "§9 was reported by §7" + API.getP(p.getName()) + "§9 for §9(§4§lGlitch§9)", "§eGo to §6" + name, "s" + name));
						}
					}
					sender.sendMessage("§8┃ §aHozexMC §8┃ §7Thank you for reporting§c " + t.getName());
					addDelay(p);
				} else {
					sender.sendMessage("§8┃ §cHozexMC §8┃ §7You can't report that player");
				}
			} else if (args[1].equalsIgnoreCase("NoKnock")) {
				if (!modsh.getStringList("mods").contains(args[0])) {
					for (ProxiedPlayer all : BungeeCord.getInstance().getPlayers()) {
						if (all.hasPermission("H.Owner") || all.hasPermission("H.Admin") || all.hasPermission("H.SrMod") || all.hasPermission("H.Mod") || all.hasPermission("H.Lord") || all.hasPermission("H.Developer") || all.hasPermission("H.Helper")) {
							String name = BungeeCord.getInstance().getPlayer(args[0]).getServer().getInfo().getName();
							all.sendMessage(API.getHoverClickRunCommandMessage("§4┃ §7" + API.getP(t.getName()) + "§9 was reported by §7" + API.getP(p.getName()) + "§9 for §9(§4§lNoKnock§9)", "§eGo to §6" + name, "s" + name));
						}
					}
					sender.sendMessage("§8┃ §aHozexMC §8┃ §7Thank you for reporting§c " + t.getName());
					addDelay(p);
				} else {
					sender.sendMessage("§8┃ §cHozexMC §8┃ §7You can't report that player");
				}
			} else if (args[1].equalsIgnoreCase("Adversting")) {
				if (!modsh.getStringList("mods").contains(args[0])) {
					for (ProxiedPlayer all : BungeeCord.getInstance().getPlayers()) {
						if (all.hasPermission("H.Owner") || all.hasPermission("H.Admin") || all.hasPermission("H.SrMod") || all.hasPermission("H.Mod") || all.hasPermission("H.Lord") || all.hasPermission("H.Developer") || all.hasPermission("H.Helper")) {
							String name = BungeeCord.getInstance().getPlayer(args[0]).getServer().getInfo().getName();
							all.sendMessage(API.getHoverClickRunCommandMessage("§4┃ §7" + API.getP(t.getName()) + "§9 was reported by §7" + API.getP(p.getName()) + "§9 for §9(§c§lAdvertising§9)", "§eGo to §6" + name, "s" + name));
						}
					}
					sender.sendMessage("§8┃ §aHozexMC §8┃ §7Thank you for reporting§c " + t.getName());
					addDelay(p);
				} else {
					sender.sendMessage("§8┃ §cHozexMC §8┃ §7You can't report that player");
				}
			} else if (args[1].equalsIgnoreCase("Spamming")) {
				if (!modsh.getStringList("mods").contains(args[0])) {
					for (ProxiedPlayer all : BungeeCord.getInstance().getPlayers()) {
						if (all.hasPermission("H.Owner") || all.hasPermission("H.Admin") || all.hasPermission("H.SrMod") || all.hasPermission("H.Mod") || all.hasPermission("H.Lord") || all.hasPermission("H.Developer") || all.hasPermission("H.Helper")) {
							String name = BungeeCord.getInstance().getPlayer(args[0]).getServer().getInfo().getName();
							all.sendMessage(API.getHoverClickRunCommandMessage("§4┃ §7" + API.getP(t.getName()) + "§9 was reported by §7" + API.getP(p.getName()) + "§9 for §9(§c§lSpamming§9)", "§eGo to §6" + name, "s" + name));
						}
					}
					sender.sendMessage("§8┃ §aHozexMC §8┃ §7Thank you for reporting§c " + t.getName());
					addDelay(p);
				} else {
					sender.sendMessage("§8┃ §cHozexMC §8┃ §7You can't report that player");
				}
			} else if (args[1].equalsIgnoreCase("Swearing")) {
				if (!modsh.getStringList("mods").contains(args[0])) {
					for (ProxiedPlayer all : BungeeCord.getInstance().getPlayers()) {
						if (all.hasPermission("H.Owner") || all.hasPermission("H.Admin") || all.hasPermission("H.SrMod") || all.hasPermission("H.Mod") || all.hasPermission("H.Lord") || all.hasPermission("H.Developer") || all.hasPermission("H.Helper")) {
							String name = BungeeCord.getInstance().getPlayer(args[0]).getServer().getInfo().getName();
							all.sendMessage(API.getHoverClickRunCommandMessage("§4┃ §7" + API.getP(t.getName()) + "§9 was reported by §7" + API.getP(p.getName()) + "§9 for §9(§c§lSwaring§9)", "§eGo to §6" + name, "s" + name));
						}
					}
					sender.sendMessage("§8┃ §aHozexMC §8┃ §7Thank you for reporting§c " + t.getName());
					addDelay(p);
				} else {
					sender.sendMessage("§8┃ §cHozexMC §8┃ §7You can't report that player");
				}
			} else if (args[1].equalsIgnoreCase("Disrespect")) {
				if (!modsh.getStringList("mods").contains(args[0])) {
					for (ProxiedPlayer all : BungeeCord.getInstance().getPlayers()) {
						if (all.hasPermission("H.Owner") || all.hasPermission("H.Admin") || all.hasPermission("H.SrMod") || all.hasPermission("H.Mod") || all.hasPermission("H.Lord") || all.hasPermission("H.Developer") || all.hasPermission("H.Helper")) {
							String name = BungeeCord.getInstance().getPlayer(args[0]).getServer().getInfo().getName();
							all.sendMessage(API.getHoverClickRunCommandMessage("§4┃ §7" + API.getP(t.getName()) + "§9 was reported by §7" + API.getP(p.getName()) + "§9 for §9(§c§lDisrespect§9)", "§eGo to §6" + name, "s" + name));
						}
					}
					sender.sendMessage("§8┃ §aHozexMC §8┃ §7Thank you for reporting§c " + t.getName());
					addDelay(p);
				} else {
					sender.sendMessage("§8┃ §cHozexMC §8┃ §7You can't report that player");
				}
			} else {
				p.sendMessage("§c§lReport reasons:");
				p.sendMessage("§eKillAura §8▪§e Fly §8▪§e Speed §8▪§e AutoCLicker §8▪§e Glitch §8▪§e BadSkin §8▪§e NoKnock");
				p.sendMessage("§eAdversting §8▪§e Spamming §8▪§e Swearing §8▪§e Disrespect");
			}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
		    File file3 = new File("plugins/Hozex-Bungee/mods.yml");
			Configuration modsh;
			try {
				modsh = ConfigurationProvider.getProvider(YamlConfiguration.class).load(file3);
			ProxiedPlayer t = BungeeCord.getInstance().getPlayer(args[0]);
			if (t == p) {
				sender.sendMessage("§8┃ §cHozexMC §8┃ §7You can't report yourself");
				return;
			}
			if (t == null) {
				sender.sendMessage("§8┃ §cHozexMC §8┃ §7This player isn't online");
				return;
			}
			if (isDelay(p) == true) {
				sender.sendMessage("§8┃ §cHozexMC §8┃ §7You can report only every 25 seconds.");
				return;
			}
			if (p.hasPermission("hozex.bans")) {
				sender.sendMessage("§8┃ §cHozexMC §8┃ §7You can't use this command");
				return;
			}
			if (args[1].equalsIgnoreCase("KillAura")) {
				if (!modsh.getStringList("mods").contains(args[0])) {
					if (args[2].startsWith("prntscr.com/") || args[2].startsWith("prnt.sc/") || args[2].startsWith("prntscr.com/") || args[2].startsWith("https://prntscr.com/") || args[2].startsWith("https://prnt.sc/") || args[2].startsWith("https://prntscr.com/")) {
						p.sendMessage("§8┃ §cHozexMC §8┃ §eInvalid evedence: You can't report hackers with pictures, it must be a video");
						return;
					} else if (!args[2].startsWith("drive.google.com/") && !args[2].startsWith("youtube.com/") && !args[2].startsWith("youtu.be/")  && !args[2].startsWith("https://youtube.com/") && !args[2].startsWith("https://drive.google.com/") && !args[2].startsWith("https://youtu.be/")) {
	            		p.sendMessage("§8┃ §6HozexMC §8┃ §ethis link should be prntscr for chat§e §eb§er§ee§ea§ek§ee§er§es§e §eo§er§e §ea§e §e(§eY§eT§e)§e §ev§ei§ed§ee§eo§e §ef§eo§er§e §eh§ea§ec§ek§ee§er§es");
	            		p.sendMessage("§8┃ §6HozexMC §8┃ §eYou can download lightshot for free from the link below");
	            		p.sendMessage("§8┃ §6HozexMC §8┃ §eapp.prntscr.com/en/download.html");	
	            		return;
            		}
					for (ProxiedPlayer all : BungeeCord.getInstance().getPlayers()) {
						if (all.hasPermission("H.Owner") || all.hasPermission("H.Admin") || all.hasPermission("H.SrMod") || all.hasPermission("H.Mod") || all.hasPermission("H.Lord") || all.hasPermission("H.Developer") || all.hasPermission("H.Helper")) {
							String name = BungeeCord.getInstance().getPlayer(args[0]).getServer().getInfo().getName();
							all.sendMessage(API.getHoverClickRunCommandMessage("§4┃ §7" + API.getP(t.getName()) + "§9 was reported by §7" + API.getP(p.getName()) + "§9 for §9(§4§lKillAura§9)", "§eGo to §6" + name, "s" + name));
							all.sendMessage("§9Evedence: §f" + args[2]);
						}
					}
					sender.sendMessage("§8┃ §aHozexMC §8┃ §7Thank you for reporting§c " + t.getName());
					addDelay(p);
				} else {
					sender.sendMessage("§8┃ §cHozexMC §8┃ §7You can't report that player");
				}
			} else if (args[1].equalsIgnoreCase("Fly")) {
					if (!modsh.getStringList("mods").contains(args[0])) {
						if (args[2].startsWith("prntscr.com/") || args[2].startsWith("prnt.sc/") || args[2].startsWith("prntscr.com/") || args[2].startsWith("https://prntscr.com/") || args[2].startsWith("https://prnt.sc/") || args[2].startsWith("https://prntscr.com/")) {
							p.sendMessage("§8┃ §cHozexMC §8┃ §eInvalid evedence: You can't report hackers with pictures, it must be a video");
							return;
						} else if (!args[2].startsWith("drive.google.com/") && !args[2].startsWith("youtube.com/") && !args[2].startsWith("youtu.be/")  && !args[2].startsWith("https://youtube.com/") && !args[2].startsWith("https://drive.google.com/") && !args[2].startsWith("https://youtu.be/")) {
		            		p.sendMessage("§8┃ §6HozexMC §8┃ §ethis link should be prntscr for chat§e §eb§er§ee§ea§ek§ee§er§es§e §eo§er§e §ea§e §e(§eY§eT§e)§e §ev§ei§ed§ee§eo§e §ef§eo§er§e §eh§ea§ec§ek§ee§er§es");
		            		p.sendMessage("§8┃ §6HozexMC §8┃ §eYou can download lightshot for free from the link below");
		            		p.sendMessage("§8┃ §6HozexMC §8┃ §eapp.prntscr.com/en/download.html");	
		            		return;
	            		}
						for (ProxiedPlayer all : BungeeCord.getInstance().getPlayers()) {
							if (all.hasPermission("H.Owner") || all.hasPermission("H.Admin") || all.hasPermission("H.SrMod") || all.hasPermission("H.Mod") || all.hasPermission("H.Lord") || all.hasPermission("H.Developer") || all.hasPermission("H.Helper")) {
								String name = BungeeCord.getInstance().getPlayer(args[0]).getServer().getInfo().getName();
								all.sendMessage(API.getHoverClickRunCommandMessage("§4┃ §7" + API.getP(t.getName()) + "§9 was reported by §7" + API.getP(p.getName()) + "§9 for §9(§4§lFly§9)", "§eGo to §6" + name, "s" + name));
								all.sendMessage("§9Evedence: §f" + args[2]);
							}
						}
						sender.sendMessage("§8┃ §aHozexMC §8┃ §7Thank you for reporting§c " + t.getName());
						addDelay(p);
					} else {
						sender.sendMessage("§8┃ §cHozexMC §8┃ §7You can't report that player");
					}
			} else if (args[1].equalsIgnoreCase("Speed")) {
				if (!modsh.getStringList("mods").contains(args[0])) {
					if (args[2].startsWith("prntscr.com/") || args[2].startsWith("prnt.sc/") || args[2].startsWith("prntscr.com/") || args[2].startsWith("https://prntscr.com/") || args[2].startsWith("https://prnt.sc/") || args[2].startsWith("https://prntscr.com/")) {
						p.sendMessage("§8┃ §cHozexMC §8┃ §eInvalid evedence: You can't report hackers with pictures, it must be a video");
						return;
					} else if (!args[2].startsWith("drive.google.com/") && !args[2].startsWith("youtube.com/") && !args[2].startsWith("youtu.be/")  && !args[2].startsWith("https://youtube.com/") && !args[2].startsWith("https://drive.google.com/") && !args[2].startsWith("https://youtu.be/")) {
	            		p.sendMessage("§8┃ §6HozexMC §8┃ §ethis link should be prntscr for chat§e §eb§er§ee§ea§ek§ee§er§es§e §eo§er§e §ea§e §e(§eY§eT§e)§e §ev§ei§ed§ee§eo§e §ef§eo§er§e §eh§ea§ec§ek§ee§er§es");
	            		p.sendMessage("§8┃ §6HozexMC §8┃ §eYou can download lightshot for free from the link below");
	            		p.sendMessage("§8┃ §6HozexMC §8┃ §eapp.prntscr.com/en/download.html");	
	            		return;
            		}
					for (ProxiedPlayer all : BungeeCord.getInstance().getPlayers()) {
						if (all.hasPermission("H.Owner") || all.hasPermission("H.Admin") || all.hasPermission("H.SrMod") || all.hasPermission("H.Mod") || all.hasPermission("H.Lord") || all.hasPermission("H.Developer") || all.hasPermission("H.Helper")) {
							String name = BungeeCord.getInstance().getPlayer(args[0]).getServer().getInfo().getName();
							all.sendMessage(API.getHoverClickRunCommandMessage("§4┃ §7" + API.getP(t.getName()) + "§9 was reported by §7" + API.getP(p.getName()) + "§9 for §9(§4§lSpeed§9)", "§eGo to §6" + name, "s" + name));
							all.sendMessage("§9Evedence: §f" + args[2]);
						}
					}
					sender.sendMessage("§8┃ §aHozexMC §8┃ §7Thank you for reporting§c " + t.getName());
					addDelay(p);
				} else {
					sender.sendMessage("§8┃ §cHozexMC §8┃ §7You can't report that player");
				}
			} else if (args[1].equalsIgnoreCase("AutoClicker") || args[1].equalsIgnoreCase("Auto")) {
				if (!modsh.getStringList("mods").contains(args[0])) {
					if (args[2].startsWith("prntscr.com/") || args[2].startsWith("prnt.sc/") || args[2].startsWith("prntscr.com/") || args[2].startsWith("https://prntscr.com/") || args[2].startsWith("https://prnt.sc/") || args[2].startsWith("https://prntscr.com/")) {
						p.sendMessage("§8┃ §cHozexMC §8┃ §eInvalid evedence: You can't report hackers with pictures, it must be a video");
						return;
					} else if (!args[2].startsWith("drive.google.com/") && !args[2].startsWith("youtube.com/") && !args[2].startsWith("youtu.be/")  && !args[2].startsWith("https://youtube.com/") && !args[2].startsWith("https://drive.google.com/") && !args[2].startsWith("https://youtu.be/")) {
	            		p.sendMessage("§8┃ §6HozexMC §8┃ §ethis link should be prntscr for chat§e §eb§er§ee§ea§ek§ee§er§es§e §eo§er§e §ea§e §e(§eY§eT§e)§e §ev§ei§ed§ee§eo§e §ef§eo§er§e §eh§ea§ec§ek§ee§er§es");
	            		p.sendMessage("§8┃ §6HozexMC §8┃ §eYou can download lightshot for free from the link below");
	            		p.sendMessage("§8┃ §6HozexMC §8┃ §eapp.prntscr.com/en/download.html");	
	            		return;
            		}
					for (ProxiedPlayer all : BungeeCord.getInstance().getPlayers()) {
						if (all.hasPermission("H.Owner") || all.hasPermission("H.Admin") || all.hasPermission("H.SrMod") || all.hasPermission("H.Mod") || all.hasPermission("H.Lord") || all.hasPermission("H.Developer") || all.hasPermission("H.Helper")) {
							String name = BungeeCord.getInstance().getPlayer(args[0]).getServer().getInfo().getName();
							all.sendMessage(API.getHoverClickRunCommandMessage("§4┃ §7" + API.getP(t.getName()) + "§9 was reported by §7" + API.getP(p.getName()) + "§9 for §9(§4§lAutoClicker§9)", "§eGo to §6" + name, "s" + name));
							all.sendMessage("§9Evedence: §f" + args[2]);
						}
					}
					sender.sendMessage("§8┃ §aHozexMC §8┃ §7Thank you for reporting§c " + t.getName());
					addDelay(p);
				} else {
					sender.sendMessage("§8┃ §cHozexMC §8┃ §7You can't report that player");
				}
			} else if (args[1].equalsIgnoreCase("Glitch")) {
				if (!modsh.getStringList("mods").contains(args[0])) {
					if (args[2].startsWith("prntscr.com/") || args[2].startsWith("prnt.sc/") || args[2].startsWith("prntscr.com/") || args[2].startsWith("https://prntscr.com/") || args[2].startsWith("https://prnt.sc/") || args[2].startsWith("https://prntscr.com/")) {
						p.sendMessage("§8┃ §cHozexMC §8┃ §eInvalid evedence: You can't report hackers with pictures, it must be a video");
						return;
					} else if (!args[2].startsWith("drive.google.com/") && !args[2].startsWith("youtube.com/") && !args[2].startsWith("youtu.be/")  && !args[2].startsWith("https://youtube.com/") && !args[2].startsWith("https://drive.google.com/") && !args[2].startsWith("https://youtu.be/")) {
	            		p.sendMessage("§8┃ §6HozexMC §8┃ §ethis link should be prntscr for chat§e §eb§er§ee§ea§ek§ee§er§es§e §eo§er§e §ea§e §e(§eY§eT§e)§e §ev§ei§ed§ee§eo§e §ef§eo§er§e §eh§ea§ec§ek§ee§er§es");
	            		p.sendMessage("§8┃ §6HozexMC §8┃ §eYou can download lightshot for free from the link below");
	            		p.sendMessage("§8┃ §6HozexMC §8┃ §eapp.prntscr.com/en/download.html");	
	            		return;
            		}
					for (ProxiedPlayer all : BungeeCord.getInstance().getPlayers()) {
						if (all.hasPermission("H.Owner") || all.hasPermission("H.Admin") || all.hasPermission("H.SrMod") || all.hasPermission("H.Mod") || all.hasPermission("H.Lord") || all.hasPermission("H.Developer") || all.hasPermission("H.Helper")) {
							String name = BungeeCord.getInstance().getPlayer(args[0]).getServer().getInfo().getName();
							all.sendMessage(API.getHoverClickRunCommandMessage("§4┃ §7" + API.getP(t.getName()) + "§9 was reported by §7" + API.getP(p.getName()) + "§9 for §9(§4§lGlitch§9)", "§eGo to §6" + name, "s" + name));
							all.sendMessage("§9Evedence: §f" + args[2]);
						}
					}
					sender.sendMessage("§8┃ §aHozexMC §8┃ §7Thank you for reporting§c " + t.getName());
					addDelay(p);
				} else {
					sender.sendMessage("§8┃ §cHozexMC §8┃ §7You can't report that player");
				}
			} else if (args[1].equalsIgnoreCase("NoKnock")) {
				if (!modsh.getStringList("mods").contains(args[0])) {
					if (args[2].startsWith("prntscr.com/") || args[2].startsWith("prnt.sc/") || args[2].startsWith("prntscr.com/") || args[2].startsWith("https://prntscr.com/") || args[2].startsWith("https://prnt.sc/") || args[2].startsWith("https://prntscr.com/")) {
						p.sendMessage("§8┃ §cHozexMC §8┃ §eInvalid evedence: You can't report hackers with pictures, it must be a video");
						return;
					} else if (!args[2].startsWith("drive.google.com/") && !args[2].startsWith("youtube.com/") && !args[2].startsWith("youtu.be/")  && !args[2].startsWith("https://youtube.com/") && !args[2].startsWith("https://drive.google.com/") && !args[2].startsWith("https://youtu.be/")) {
	            		p.sendMessage("§8┃ §6HozexMC §8┃ §ethis link should be prntscr for chat§e §eb§er§ee§ea§ek§ee§er§es§e §eo§er§e §ea§e §e(§eY§eT§e)§e §ev§ei§ed§ee§eo§e §ef§eo§er§e §eh§ea§ec§ek§ee§er§es");
	            		p.sendMessage("§8┃ §6HozexMC §8┃ §eYou can download lightshot for free from the link below");
	            		p.sendMessage("§8┃ §6HozexMC §8┃ §eapp.prntscr.com/en/download.html");	
	            		return;
            		}
					for (ProxiedPlayer all : BungeeCord.getInstance().getPlayers()) {
						if (all.hasPermission("H.Owner") || all.hasPermission("H.Admin") || all.hasPermission("H.SrMod") || all.hasPermission("H.Mod") || all.hasPermission("H.Lord") || all.hasPermission("H.Developer") || all.hasPermission("H.Helper")) {
							String name = BungeeCord.getInstance().getPlayer(args[0]).getServer().getInfo().getName();
							all.sendMessage(API.getHoverClickRunCommandMessage("§4┃ §7" + API.getP(t.getName()) + "§9 was reported by §7" + API.getP(p.getName()) + "§9 for §9(§4§lNoKnock§9)", "§eGo to §6" + name, "s" + name));
							all.sendMessage("§9Evedence: §f" + args[2]);
						}
					}
					sender.sendMessage("§8┃ §aHozexMC §8┃ §7Thank you for reporting§c " + t.getName());
					addDelay(p);
				} else {
					sender.sendMessage("§8┃ §cHozexMC §8┃ §7You can't report that player");
				}
			} else if (args[1].equalsIgnoreCase("Adversting")) {
				if (!modsh.getStringList("mods").contains(args[0])) {
					if (!args[2].startsWith("prntscr.com/") && !args[2].startsWith("prnt.sc/") && !args[2].startsWith("prntscr.com/") && !args[2].startsWith("https://prntscr.com/") && !args[2].startsWith("https://prnt.sc/") && !args[2].startsWith("https://prntscr.com/")) {
	            		p.sendMessage("§8┃ §6HozexMC §8┃ §ethis link should be prntscr for chat§e §eb§er§ee§ea§ek§ee§er§es§e §eo§er§e §ea§e §e(§eY§eT§e)§e §ev§ei§ed§ee§eo§e §ef§eo§er§e §eh§ea§ec§ek§ee§er§es");
	            		p.sendMessage("§8┃ §6HozexMC §8┃ §eYou can download lightshot for free from the link below");
	            		p.sendMessage("§8┃ §6HozexMC §8┃ §eapp.prntscr.com/en/download.html");	
						return;
					}
					for (ProxiedPlayer all : BungeeCord.getInstance().getPlayers()) {
						if (all.hasPermission("H.Owner") || all.hasPermission("H.Admin") || all.hasPermission("H.SrMod") || all.hasPermission("H.Mod") || all.hasPermission("H.Lord") || all.hasPermission("H.Developer") || all.hasPermission("H.Helper")) {
							String name = BungeeCord.getInstance().getPlayer(args[0]).getServer().getInfo().getName();
							all.sendMessage(API.getHoverClickRunCommandMessage("§4┃ §7" + API.getP(t.getName()) + "§9 was reported by §7" + API.getP(p.getName()) + "§9 for §9(§c§lAdvertising§9)", "§eGo to §6" + name, "s" + name));
							all.sendMessage("§9Evedence: §f" + args[2]);
						}
					}
					sender.sendMessage("§8┃ §aHozexMC §8┃ §7Thank you for reporting§c " + t.getName());
					addDelay(p);
				} else {
					sender.sendMessage("§8┃ §cHozexMC §8┃ §7You can't report that player");
				}
			} else if (args[1].equalsIgnoreCase("Spamming")) {
				if (!modsh.getStringList("mods").contains(args[0])) {
					if (!args[2].startsWith("prntscr.com/") && !args[2].startsWith("prnt.sc/") && !args[2].startsWith("prntscr.com/") && !args[2].startsWith("https://prntscr.com/") && !args[2].startsWith("https://prnt.sc/") && !args[2].startsWith("https://prntscr.com/")) {
	            		p.sendMessage("§8┃ §6HozexMC §8┃ §ethis link should be prntscr for chat§e §eb§er§ee§ea§ek§ee§er§es§e §eo§er§e §ea§e §e(§eY§eT§e)§e §ev§ei§ed§ee§eo§e §ef§eo§er§e §eh§ea§ec§ek§ee§er§es");
	            		p.sendMessage("§8┃ §6HozexMC §8┃ §eYou can download lightshot for free from the link below");
	            		p.sendMessage("§8┃ §6HozexMC §8┃ §eapp.prntscr.com/en/download.html");	
						return;
					}
					for (ProxiedPlayer all : BungeeCord.getInstance().getPlayers()) {
						if (all.hasPermission("H.Owner") || all.hasPermission("H.Admin") || all.hasPermission("H.SrMod") || all.hasPermission("H.Mod") || all.hasPermission("H.Lord") || all.hasPermission("H.Developer") || all.hasPermission("H.Helper")) {
							String name = BungeeCord.getInstance().getPlayer(args[0]).getServer().getInfo().getName();
							all.sendMessage(API.getHoverClickRunCommandMessage("§4┃ §7" + API.getP(t.getName()) + "§9 was reported by §7" + API.getP(p.getName()) + "§9 for §9(§c§lSpamming§9)", "§eGo to §6" + name, "s" + name));
							all.sendMessage("§9Evedence: §f" + args[2]);
						}
					}
					sender.sendMessage("§8┃ §aHozexMC §8┃ §7Thank you for reporting§c " + t.getName());
					addDelay(p);
				} else {
					sender.sendMessage("§8┃ §cHozexMC §8┃ §7You can't report that player");
				}
			} else if (args[1].equalsIgnoreCase("Swearing")) {
				if (!modsh.getStringList("mods").contains(args[0])) {
					if (!args[2].startsWith("prntscr.com/") && !args[2].startsWith("prnt.sc/") && !args[2].startsWith("prntscr.com/") && !args[2].startsWith("https://prntscr.com/") && !args[2].startsWith("https://prnt.sc/") && !args[2].startsWith("https://prntscr.com/")) {
	            		p.sendMessage("§8┃ §6HozexMC §8┃ §ethis link should be prntscr for chat§e §eb§er§ee§ea§ek§ee§er§es§e §eo§er§e §ea§e §e(§eY§eT§e)§e §ev§ei§ed§ee§eo§e §ef§eo§er§e §eh§ea§ec§ek§ee§er§es");
	            		p.sendMessage("§8┃ §6HozexMC §8┃ §eYou can download lightshot for free from the link below");
	            		p.sendMessage("§8┃ §6HozexMC §8┃ §eapp.prntscr.com/en/download.html");	
						return;
					}
					for (ProxiedPlayer all : BungeeCord.getInstance().getPlayers()) {
						if (all.hasPermission("H.Owner") || all.hasPermission("H.Admin") || all.hasPermission("H.SrMod") || all.hasPermission("H.Mod") || all.hasPermission("H.Lord") || all.hasPermission("H.Developer") || all.hasPermission("H.Helper")) {
							String name = BungeeCord.getInstance().getPlayer(args[0]).getServer().getInfo().getName();
							all.sendMessage(API.getHoverClickRunCommandMessage("§4┃ §7" + API.getP(t.getName()) + "§9 was reported by §7" + API.getP(p.getName()) + "§9 for §9(§c§lSwaring§9)", "§eGo to §6" + name, "s" + name));
							all.sendMessage("§9Evedence: §f" + args[2]);
						}
					}
					sender.sendMessage("§8┃ §aHozexMC §8┃ §7Thank you for reporting§c " + t.getName());
					addDelay(p);
				} else {
					sender.sendMessage("§8┃ §cHozexMC §8┃ §7You can't report that player");
				}
			} else if (args[1].equalsIgnoreCase("Disrespect")) {
				if (!modsh.getStringList("mods").contains(args[0])) {
					if (!args[2].startsWith("prntscr.com/") && !args[2].startsWith("prnt.sc/") && !args[2].startsWith("prntscr.com/") && !args[2].startsWith("https://prntscr.com/") && !args[2].startsWith("https://prnt.sc/") && !args[2].startsWith("https://prntscr.com/")) {
	            		p.sendMessage("§8┃ §6HozexMC §8┃ §ethis link should be prntscr for chat§e §eb§er§ee§ea§ek§ee§er§es§e §eo§er§e §ea§e §e(§eY§eT§e)§e §ev§ei§ed§ee§eo§e §ef§eo§er§e §eh§ea§ec§ek§ee§er§es");
	            		p.sendMessage("§8┃ §6HozexMC §8┃ §eYou can download lightshot for free from the link below");
	            		p.sendMessage("§8┃ §6HozexMC §8┃ §eapp.prntscr.com/en/download.html");	
						return;
					}
					for (ProxiedPlayer all : BungeeCord.getInstance().getPlayers()) {
						if (all.hasPermission("H.Owner") || all.hasPermission("H.Admin") || all.hasPermission("H.SrMod") || all.hasPermission("H.Mod") || all.hasPermission("H.Lord") || all.hasPermission("H.Developer") || all.hasPermission("H.Helper")) {
							String name = BungeeCord.getInstance().getPlayer(args[0]).getServer().getInfo().getName();
							all.sendMessage(API.getHoverClickRunCommandMessage("§4┃ §7" + API.getP(t.getName()) + "§9 was reported by §7" + API.getP(p.getName()) + "§9 for §9(§c§lDisrespect§9)", "§eGo to §6" + name, "s" + name));
							all.sendMessage("§9Evedence: §f" + args[2]);
						}
					}
					sender.sendMessage("§8┃ §aHozexMC §8┃ §7Thank you for reporting§c " + t.getName());
					addDelay(p);
				} else {
					sender.sendMessage("§8┃ §cHozexMC §8┃ §7You can't report that player");
				}
			} else {
				p.sendMessage("§c§lReport reasons:");
				p.sendMessage("§eKillAura §8▪§e Fly §8▪§e Speed §8▪§e AutoCLicker §8▪§e Glitch §8▪§e BadSkin §8▪§e NoKnock");
				p.sendMessage("§eAdversting §8▪§e Spamming §8▪§e Swearing §8▪§e Disrespect");
			}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
