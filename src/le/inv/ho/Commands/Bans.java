package le.inv.ho.Commands;

import java.awt.TextComponent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import le.inv.ho.API;
import le.inv.ho.BanU;
import le.inv.ho.Main;
import le.inv.ho.MuteU;
import le.inv.ho.Utilts;
import le.inv.ho.msgsql;
import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;

public class Bans extends Command {
	  private Main bcb;
	  public Bans(Main bcb) {
	    super("b", "hozex.bans", new String[] { "m" });
	    this.bcb = bcb;
	  } 
	  @SuppressWarnings("deprecation")
	public void execute(CommandSender sender, String[] args) {
		  if (args.length == 0) {
	  			sender.sendMessage("§8§m--------------§7§m-------§f- « §4Bans§7 §f» §f§m-§7§m-------§8§m--------------");
		        sender.sendMessage("§b⚪ §61. Hacking §7[5d]");
		        sender.sendMessage("§b⚪ §62. Refusing to AnyDesk §7[5d]");
		        sender.sendMessage("§b⚪ §63. Teaming §7[10h]");
		        sender.sendMessage("§b⚪ §64. Glitch §7[4d]");
		        sender.sendMessage("§b⚪ §65. Redstone Farming §7[1d]");
		        sender.sendMessage("§b⚪ §66. BadSkin §7[7 days]");
		        sender.sendMessage("§b⚪ §67. BadName §7[30d]");
		        sender.sendMessage("§b⚪ §68. Swearing §7[7h]");
		        sender.sendMessage("§b⚪ §69. Spamming §7[3h]");
		        sender.sendMessage("§b⚪ §610. Disrespect §7[3h]");
		        sender.sendMessage("§b⚪ §611. Politics and Racism §7[7h]");
		        sender.sendMessage("§b⚪ §612. Advertising §7[7d]");
		        sender.sendMessage("§b⚪ §613. Interfering with Administration §7[2h]");
		        sender.sendMessage("§b⚪ §614. ServerName §7[3d]");
				sender.sendMessage("§8§m---------------§7§m-------§f- « §c✦§7 §f» §f§m-§7§m-------§8§m---------------");
		        sender.sendMessage("§4§8⚪ §eHozexMC §8⚪§7 §a/b <player> <ID> §7[Evedence]");
		  } else if (args.length == 1) {
			  if (sender instanceof ProxiedPlayer) {
				  sender.sendMessage("§8§m--------------§7§m-------§f- « §4Bans§7 §f» §f§m-§7§m-------§8§m--------------");
		          sender.sendMessage(API.getHoverClickRunCommandSuggest("§b⚪ §61. Hacking §7[5d]", "§eBan §6" + args[0] + "§e for Hacking", "b " + args[0] + " 6"));
		          sender.sendMessage(API.getHoverClickRunCommandSuggest("§b⚪ §62. Refusing to AnyDesk §7[5d]", "§eBan §6" + args[0] + "§e for Refusing to AnyDesk", "b " + args[0] + " 7"));
		          sender.sendMessage(API.getHoverClickRunCommandSuggest("§b⚪ §63. Teaming §7[10h]", "§eBan §6" + args[0] + "§e for Teaming", "b " + args[0] + " 8"));
		          sender.sendMessage(API.getHoverClickRunCommandSuggest("§b⚪ §64. Glitch §7[4d]", "§eBan §6" + args[0] + "§e for Glitch", "b " + args[0] + " 9"));
		          sender.sendMessage(API.getHoverClickRunCommandSuggest("§b⚪ §65. Redstone Farming §7[1d]", "§eBan §6" + args[0] + "§e for Redstone Farming", "b " + args[0] + " 10"));
		          sender.sendMessage(API.getHoverClickRunCommandSuggest("§b⚪ §66. BadSkin §7[7d]", "§eBan §6" + args[0] + "§e for BadSkin", "b " + args[0] + " 11"));
		          sender.sendMessage(API.getHoverClickRunCommandSuggest("§b⚪ §67. BadName §7[30d]", "§eBan §6" + args[0] + "§e for BadName", "b " + args[0] + " 12"));
		          sender.sendMessage(API.getHoverClickRunCommandSuggest("§b⚪ §68. Swearing §7[7h]", "§eMute §6" + args[0] + "§e for Swaring", "b " + args[0] + " 2"));
				  sender.sendMessage(API.getHoverClickRunCommandSuggest("§b⚪ §69. Spamming §7[3h]", "§eMute §6" + args[0] + "§e for Spamming", "b " + args[0] + " 1"));
		          sender.sendMessage(API.getHoverClickRunCommandSuggest("§b⚪ §610. Disrespect §7[3h]", "§eMute §6" + args[0] + "§e for Disrespect", "b " + args[0] + " 3"));
		          sender.sendMessage(API.getHoverClickRunCommandSuggest("§b⚪ §611. Politicies and Racism §7[7h]", "§eMute §6" + args[0] + "§e for Politicies and Racism", "b " + args[0] + " 4"));
		          sender.sendMessage(API.getHoverClickRunCommandSuggest("§b⚪ §612. Advertising §7[7d]", "§eMute §6" + args[0] + "§e for Advertising", "b " + args[0] + " 5"));
		          sender.sendMessage(API.getHoverClickRunCommandSuggest("§b⚪ §613. Interfering with Administration §7[2h]", "§eMute §6" + args[0] + "§e for Interfering with Administration", "b " + args[0] + " 13"));
		          sender.sendMessage(API.getHoverClickRunCommandSuggest("§b⚪ §614. ServerName §7[3d]", "§eMute §6" + args[0] + "§e for ServerName", "b " + args[0] + " 14"));
		   		  sender.sendMessage("§8§m---------------§7§m-------§f- « §c✦§7 §f» §f§m-§7§m-------§8§m---------------");
		          sender.sendMessage("§4§8⚪ §eHozexMC §8⚪§7 §a/b <player> <ID> §7[Evedence]");
			  } else {
		  			sender.sendMessage("§8§m--------------§7§m-------§f- « §4Bans§7 §f» §f§m-§7§m-------§8§m--------------");
			        sender.sendMessage("§b⚪ §61. Hacking §7[5d]");
			        sender.sendMessage("§b⚪ §62. Refusing to AnyDesk §7[5d]");
			        sender.sendMessage("§b⚪ §63. Teaming §7[10h]");
			        sender.sendMessage("§b⚪ §64. Glitch §7[4d]");
			        sender.sendMessage("§b⚪ §65. Redstone Farming §7[1d]");
			        sender.sendMessage("§b⚪ §66. BadSkin §7[7 days]");
			        sender.sendMessage("§b⚪ §67. BadName §7[30d]");
			        sender.sendMessage("§b⚪ §68. Swearing §7[7h]");
			        sender.sendMessage("§b⚪ §69. Spamming §7[3h]");
			        sender.sendMessage("§b⚪ §610. Disrespect §7[3h]");
			        sender.sendMessage("§b⚪ §611. Politics and Racism §7[7h]");
			        sender.sendMessage("§b⚪ §612. Advertising §7[7d]");
			        sender.sendMessage("§b⚪ §613. Interfering with Administration §7[2h]");
			        sender.sendMessage("§b⚪ §613. ServerName §7[3d]");
					sender.sendMessage("§8§m---------------§7§m-------§f- « §c✦§7 §f» §f§m-§7§m-------§8§m---------------");
			        sender.sendMessage("§4§8⚪ §eHozexMC §8⚪§7 §a/b <player> <ID> §7[Evedence]");
			  }
		  } else if (args.length == 2) {
			  if (args[1].equalsIgnoreCase("1")) {
				  punishPlayer(args[0], "Hacking", "5d", true, sender, "-");
			  } else if (args[1].equalsIgnoreCase("2")) {
				  punishPlayer(args[0], "Refusing to AnyDesk", "5d", true, sender, "-");
			  } else if (args[1].equalsIgnoreCase("3")) {
				  punishPlayer(args[0], "Teaming", "10h", true, sender, "-");
			  } else if (args[1].equalsIgnoreCase("4")) {
				  punishPlayer(args[0], "Glitch", "4d", true, sender, "-");
			  } else if (args[1].equalsIgnoreCase("5")) {
				  punishPlayer(args[0], "Redstone Farming", "1d", true, sender, "-");
			  } else if (args[1].equalsIgnoreCase("6")) {
				  punishPlayer(args[0], "BadSkin", "7d", true, sender, "-");
			  } else if (args[1].equalsIgnoreCase("7")) {
				  punishPlayer(args[0], "BadName", "30d", true, sender, "-");
			  } else if (args[1].equalsIgnoreCase("8")) {
				  punishPlayer(args[0], "Swearing", "7h", false, sender, "-");
			  } else if (args[1].equalsIgnoreCase("9")) {
				  punishPlayer(args[0], "Spamming", "3h", false, sender, "-");
			  } else if (args[1].equalsIgnoreCase("10")) {
				  punishPlayer(args[0], "Disrespect", "3h", false, sender, "-");
			  } else if (args[1].equalsIgnoreCase("11")) {
				  punishPlayer(args[0], "Politicies and Racism", "7h", false, sender, "-");
			  } else if (args[1].equalsIgnoreCase("12")) {
				  punishPlayer(args[0], "Advertising", "7d", false, sender, "-");
			  } else if (args[1].equalsIgnoreCase("13")) {
				  punishPlayer(args[0], "Interfering with Administration", "2h", false, sender, "-");
			  } else if (args[1].equalsIgnoreCase("14")) {
				  punishPlayer(args[0], "ServerName", "3d", false, sender, "-");
			  } else {
				  if (sender instanceof ProxiedPlayer) {
					  sender.sendMessage("§8§m--------------§7§m-------§f- « §4Bans§7 §f» §f§m-§7§m-------§8§m--------------");
			          sender.sendMessage(API.getHoverClickRunCommandSuggest("§b⚪ §61. Hacking §7[5d]", "§eBan §6" + args[0] + "§e for Hacking", "b " + args[0] + " 1"));
			          sender.sendMessage(API.getHoverClickRunCommandSuggest("§b⚪ §62. Refusing to AnyDesk §7[5d]", "§eBan §6" + args[0] + "§e for Refusing to AnyDesk", "b " + args[0] + " 2"));
			          sender.sendMessage(API.getHoverClickRunCommandSuggest("§b⚪ §63. Teaming §7[10h]", "§eBan §6" + args[0] + "§e for Teaming", "b " + args[0] + " 3"));
			          sender.sendMessage(API.getHoverClickRunCommandSuggest("§b⚪ §64. Glitch §7[4d]", "§eBan §6" + args[0] + "§e for Glitch", "b " + args[0] + " 4"));
			          sender.sendMessage(API.getHoverClickRunCommandSuggest("§b⚪ §65. Redstone Farming §7[1d]", "§eBan §6" + args[0] + "§e for Redstone Farming", "b " + args[0] + " 5"));
			          sender.sendMessage(API.getHoverClickRunCommandSuggest("§b⚪ §66. BadSkin §7[7d]", "§eBan §6" + args[0] + "§e for BadSkin", "b " + args[0] + " 6"));
			          sender.sendMessage(API.getHoverClickRunCommandSuggest("§b⚪ §67. BadName §7[30d]", "§eBan §6" + args[0] + "§e for BadName", "b " + args[0] + " 7"));
			          sender.sendMessage(API.getHoverClickRunCommandSuggest("§b⚪ §68. Swearing §7[7h]", "§eMute §6" + args[0] + "§e for Swaring", "b " + args[0] + " 8"));
					  sender.sendMessage(API.getHoverClickRunCommandSuggest("§b⚪ §69. Spamming §7[3h]", "§eMute §6" + args[0] + "§e for Spamming", "b " + args[0] + " 9"));
			          sender.sendMessage(API.getHoverClickRunCommandSuggest("§b⚪ §610. Disrespect §7[3h]", "§eMute §6" + args[0] + "§e for Disrespect", "b " + args[0] + " 10"));
			          sender.sendMessage(API.getHoverClickRunCommandSuggest("§b⚪ §611. Politicies and Racism §7[7h]", "§eMute §6" + args[0] + "§e for Politicies and Racism", "b " + args[0] + " 11"));
			          sender.sendMessage(API.getHoverClickRunCommandSuggest("§b⚪ §612. Advertising §7[7d]", "§eMute §6" + args[0] + "§e for Advertising", "b " + args[0] + " 12"));
			          sender.sendMessage(API.getHoverClickRunCommandSuggest("§b⚪ §613. Interfering with Administration §7[2h]", "§eMute §6" + args[0] + "§e for Interfering with Administration", "b " + args[0] + " 13"));
			          sender.sendMessage(API.getHoverClickRunCommandSuggest("§b⚪ §614. ServerName §7[3d]", "§eMute §6" + args[0] + "§e for ServerName", "b " + args[0] + " 14"));
			   		  sender.sendMessage("§8§m---------------§7§m-------§f- « §c✦§7 §f» §f§m-§7§m-------§8§m---------------");
			          sender.sendMessage("§4§8⚪ §eHozexMC §8⚪§7 §a/b <player> <ID> §7[Evedence]");
				  } else {
					  sender.sendMessage("§8§m--------------§7§m-------§f- « §4Bans§7 §f» §f§m-§7§m-------§8§m--------------");
			          sender.sendMessage(API.getHoverClickRunCommandSuggest("§b⚪ §61. Hacking §7[5d]", "§eBan §6" + args[0] + "§e for Hacking", "b " + args[0] + " 1"));
			          sender.sendMessage(API.getHoverClickRunCommandSuggest("§b⚪ §62. Refusing to AnyDesk §7[5d]", "§eBan §6" + args[0] + "§e for Refusing to AnyDesk", "b " + args[0] + " 2"));
			          sender.sendMessage(API.getHoverClickRunCommandSuggest("§b⚪ §63. Teaming §7[10h]", "§eBan §6" + args[0] + "§e for Teaming", "b " + args[0] + " 3"));
			          sender.sendMessage(API.getHoverClickRunCommandSuggest("§b⚪ §64. Glitch §7[4d]", "§eBan §6" + args[0] + "§e for Glitch", "b " + args[0] + " 4"));
			          sender.sendMessage(API.getHoverClickRunCommandSuggest("§b⚪ §65. Redstone Farming §7[1d]", "§eBan §6" + args[0] + "§e for Redstone Farming", "b " + args[0] + " 5"));
			          sender.sendMessage(API.getHoverClickRunCommandSuggest("§b⚪ §66. BadSkin §7[7d]", "§eBan §6" + args[0] + "§e for BadSkin", "b " + args[0] + " 6"));
			          sender.sendMessage(API.getHoverClickRunCommandSuggest("§b⚪ §67. BadName §7[30d]", "§eBan §6" + args[0] + "§e for BadName", "b " + args[0] + " 7"));
			          sender.sendMessage(API.getHoverClickRunCommandSuggest("§b⚪ §68. Swearing §7[7h]", "§eMute §6" + args[0] + "§e for Swaring", "b " + args[0] + " 8"));
					  sender.sendMessage(API.getHoverClickRunCommandSuggest("§b⚪ §69. Spamming §7[3h]", "§eMute §6" + args[0] + "§e for Spamming", "b " + args[0] + " 9"));
			          sender.sendMessage(API.getHoverClickRunCommandSuggest("§b⚪ §610. Disrespect §7[3h]", "§eMute §6" + args[0] + "§e for Disrespect", "b " + args[0] + " 10"));
			          sender.sendMessage(API.getHoverClickRunCommandSuggest("§b⚪ §611. Politicies and Racism §7[7h]", "§eMute §6" + args[0] + "§e for Politicies and Racism", "b " + args[0] + " 11"));
			          sender.sendMessage(API.getHoverClickRunCommandSuggest("§b⚪ §612. Advertising §7[7d]", "§eMute §6" + args[0] + "§e for Advertising", "b " + args[0] + " 12"));
			          sender.sendMessage(API.getHoverClickRunCommandSuggest("§b⚪ §613. Interfering with Administration §7[2h]", "§eMute §6" + args[0] + "§e for Interfering with Administration", "b " + args[0] + " 13"));
			          sender.sendMessage(API.getHoverClickRunCommandSuggest("§b⚪ §614. ServerName §7[3d]", "§eMute §6" + args[0] + "§e for ServerName", "b " + args[0] + " 14"));
			   		  sender.sendMessage("§8§m---------------§7§m-------§f- « §c✦§7 §f» §f§m-§7§m-------§8§m---------------");
				        sender.sendMessage("§4§8⚪ §eHozexMC §8⚪§7 §a/b <player> <ID> §7[Evedence]");
				  }
			  }
		  } else {
			  if (args[1].equalsIgnoreCase("1")) {
				  punishPlayer(args[0], "Hacking", "5d", true, sender, args[2]);
			  } else if (args[1].equalsIgnoreCase("2")) {
				  punishPlayer(args[0], "Refusing to AnyDesk", "5d", true, sender, args[2]);
			  } else if (args[1].equalsIgnoreCase("3")) {
				  punishPlayer(args[0], "Teaming", "10h", true, sender, args[2]);
			  } else if (args[1].equalsIgnoreCase("4")) {
				  punishPlayer(args[0], "Glitch", "4d", true, sender, args[2]);
			  } else if (args[1].equalsIgnoreCase("5")) {
				  punishPlayer(args[0], "Redstone Farming", "1d", true, sender, args[2]);
			  } else if (args[1].equalsIgnoreCase("6")) {
				  punishPlayer(args[0], "BadSkin", "7d", true, sender, args[2]);
			  } else if (args[1].equalsIgnoreCase("7")) {
				  punishPlayer(args[0], "BadName", "30d", true, sender, args[2]);
			  } else if (args[1].equalsIgnoreCase("8")) {
				  punishPlayer(args[0], "Swearing", "7h", false, sender, args[2]);
			  } else if (args[1].equalsIgnoreCase("9")) {
				  punishPlayer(args[0], "Spamming", "3h", false, sender, args[2]);
			  } else if (args[1].equalsIgnoreCase("10")) {
				  punishPlayer(args[0], "Disrespect", "3h", false, sender, args[2]);
			  } else if (args[1].equalsIgnoreCase("11")) {
				  punishPlayer(args[0], "Politicies and Racism", "7h", false, sender, args[2]);
			  } else if (args[1].equalsIgnoreCase("12")) {
				  punishPlayer(args[0], "Advertising", "7d", false, sender, args[2]);
			  } else if (args[1].equalsIgnoreCase("13")) {
				  punishPlayer(args[0], "Interfering with Administration", "2h", false, sender, args[2]);
			  } else if (args[1].equalsIgnoreCase("14")) {
				  punishPlayer(args[0], "ServerName", "3d", false, sender, args[2]);
			  } else {
				  if (sender instanceof ProxiedPlayer) {
					  sender.sendMessage("§8§m--------------§7§m-------§f- « §4Bans§7 §f» §f§m-§7§m-------§8§m--------------");
			          sender.sendMessage(API.getHoverClickRunCommandSuggest("§b⚪ §61. Hacking §7[5d]", "§eBan §6" + args[0] + "§e for Hacking", "b " + args[0] + " 1"));
			          sender.sendMessage(API.getHoverClickRunCommandSuggest("§b⚪ §62. Refusing to AnyDesk §7[5d]", "§eBan §6" + args[0] + "§e for Refusing to AnyDesk", "b " + args[0] + " 2"));
			          sender.sendMessage(API.getHoverClickRunCommandSuggest("§b⚪ §63. Teaming §7[10h]", "§eBan §6" + args[0] + "§e for Teaming", "b " + args[0] + " 3"));
			          sender.sendMessage(API.getHoverClickRunCommandSuggest("§b⚪ §64. Glitch §7[4d]", "§eBan §6" + args[0] + "§e for Glitch", "b " + args[0] + " 4"));
			          sender.sendMessage(API.getHoverClickRunCommandSuggest("§b⚪ §65. Redstone Farming §7[1d]", "§eBan §6" + args[0] + "§e for Redstone Farming", "b " + args[0] + " 5"));
			          sender.sendMessage(API.getHoverClickRunCommandSuggest("§b⚪ §66. BadSkin §7[7d]", "§eBan §6" + args[0] + "§e for BadSkin", "b " + args[0] + " 6"));
			          sender.sendMessage(API.getHoverClickRunCommandSuggest("§b⚪ §67. BadName §7[30d]", "§eBan §6" + args[0] + "§e for BadName", "b " + args[0] + " 7"));
			          sender.sendMessage(API.getHoverClickRunCommandSuggest("§b⚪ §68. Swearing §7[7h]", "§eMute §6" + args[0] + "§e for Swaring", "b " + args[0] + " 8"));
					  sender.sendMessage(API.getHoverClickRunCommandSuggest("§b⚪ §69. Spamming §7[3h]", "§eMute §6" + args[0] + "§e for Spamming", "b " + args[0] + " 9"));
			          sender.sendMessage(API.getHoverClickRunCommandSuggest("§b⚪ §610. Disrespect §7[3h]", "§eMute §6" + args[0] + "§e for Disrespect", "b " + args[0] + " 10"));
			          sender.sendMessage(API.getHoverClickRunCommandSuggest("§b⚪ §611. Politicies and Racism §7[7h]", "§eMute §6" + args[0] + "§e for Politicies and Racism", "b " + args[0] + " 11"));
			          sender.sendMessage(API.getHoverClickRunCommandSuggest("§b⚪ §612. Advertising §7[7d]", "§eMute §6" + args[0] + "§e for Advertising", "b " + args[0] + " 12"));
			          sender.sendMessage(API.getHoverClickRunCommandSuggest("§b⚪ §613. Interfering with Administration §7[2h]", "§eMute §6" + args[0] + "§e for Interfering with Administration", "b " + args[0] + " 13"));
			          sender.sendMessage(API.getHoverClickRunCommandSuggest("§b⚪ §614. ServerName §7[3d]", "§eMute §6" + args[0] + "§e for ServerName", "b " + args[0] + " 14"));
			   		  sender.sendMessage("§8§m---------------§7§m-------§f- « §c✦§7 §f» §f§m-§7§m-------§8§m---------------");
			          sender.sendMessage("§4§8⚪ §eHozexMC §8⚪§7 §a/b <player> <ID> §7[Evedence]");
				  } else {
			  			sender.sendMessage("§8§m--------------§7§m-------§f- « §4Bans§7 §f» §f§m-§7§m-------§8§m--------------");
				        sender.sendMessage("§b⚪ §61. Hacking §7[5d]");
				        sender.sendMessage("§b⚪ §62. Refusing to AnyDesk §7[5d]");
				        sender.sendMessage("§b⚪ §63. Teaming §7[10h]");
				        sender.sendMessage("§b⚪ §64. Glitch §7[4d]");
				        sender.sendMessage("§b⚪ §65. Redstone Farming §7[1d]");
				        sender.sendMessage("§b⚪ §66. BadSkin §7[7 days]");
				        sender.sendMessage("§b⚪ §67. BadName §7[30d]");
				        sender.sendMessage("§b⚪ §68. Swearing §7[7h]");
				        sender.sendMessage("§b⚪ §69. Spamming §7[3h]");
				        sender.sendMessage("§b⚪ §610. Disrespect §7[3h]");
				        sender.sendMessage("§b⚪ §611. Politics and Racism §7[7h]");
				        sender.sendMessage("§b⚪ §612. Advertising §7[7d]");
				        sender.sendMessage("§b⚪ §613. Interfering with Administration §7[2h]");
						sender.sendMessage("§8§m---------------§7§m-------§f- « §c✦§7 §f» §f§m-§7§m-------§8§m---------------");
				        sender.sendMessage("§4§8⚪ §eHozexMC §8⚪§7 §a/b <player> <ID> §7[Evedence]");
				  }
			  }
		  }
	  }
		
	  @SuppressWarnings("deprecation")
	public void punishPlayer(String name, String reason, String duration, boolean ban, CommandSender sender, String evedence) {
		  File file2 = new File(this.bcb.getDataFolder().getPath(), "bansid.yml");	 
//		  if (sender instanceof ProxiedPlayer) {
//			  if (ban) {
//				  if (!sender.hasPermission("H.Owner") && !sender.hasPermission("H.HeadAdmin") && !sender.hasPermission("H.Admin") && !sender.hasPermission("H.Developer") && !sender.hasPermission("H.Special") && !sender.hasPermission("H.SrMod") && !sender.hasPermission("H.Mod")) {
//			    		sender.sendMessage("§8┃ §cHozexMC §8┃ §7You don't have permssions to ban players");	
//			    		return;
//				  }
//			  }
//		  }
		  if (!evedence.equalsIgnoreCase("-")) {
              if (evedence.startsWith("prntscr.com/") || evedence.startsWith("drive.google.com/") || evedence.startsWith("prnt.sc/") || evedence.startsWith("prntscr.com/") || evedence.startsWith("youtube.com/") || evedence.startsWith("youtu.be/") || evedence.startsWith("https://prntscr.com/") || evedence.startsWith("https://prnt.sc/") || evedence.startsWith("https://prntscr.com/") || evedence.startsWith("https://youtube.com/") || evedence.startsWith("https://drive.google.com/") || evedence.startsWith("https://youtu.be/")) {
              } else {
      		sender.sendMessage("§8┃ §6HozexMC §8┃ §ethis link should be prntscr or yt");
      		sender.sendMessage("§8┃ §6HozexMC §8┃ §eYou can download lightshot for free from the link below");
      		sender.sendMessage("§8┃ §6HozexMC §8┃ §eapp.prntscr.com/en/download.html");
      	  return;
              }
		}
		    if (!API.isModerator(name)) {
		    	if (ban) {
		    		if (sender.hasPermission("H.Owner") || sender.hasPermission("H.HeadAdmin") || sender.hasPermission("H.Admin") || sender.hasPermission("H.Developer") || sender.hasPermission("H.Special") || sender.hasPermission("H.SrMod") || sender.hasPermission("H.Mod")) {
		    			
		    		} else {
		    			sender.sendMessage("§8┃ §6HozexMC §8┃ §7You don't have permissions to use that ID");
		    			return;
		    		}
		    	}
		        try {
		          	  Configuration config = ConfigurationProvider.getProvider(YamlConfiguration.class).load(file2);
		          	  int ids = Main.getRandom(10000, 100000);
		          	  config.set(ids + ".name", name);
		          	  if (sender instanceof ProxiedPlayer) {
		              	  config.set(sender.getName() + ".mod.bans", Integer.valueOf(config.getInt(sender.getName() + ".mod.bans")).intValue() + 1);
		              	  config.set(ids + ".by", sender.getName());
		          	  } else {
		              	  config.set(ids + ".by", "CONSOLE");
		          	  }
		          	  ConfigurationProvider.getProvider(YamlConfiguration.class).save(config, file2);
		          	  if (sender instanceof ProxiedPlayer) {
			          	  if (ban) {
		            			ProxyServer.getInstance().getPluginManager().dispatchCommand(sender, "tempban " + name + " " + duration + " " + reason + " #" + ids);
		            			ProxyServer.getInstance().getPluginManager().dispatchCommand(sender, "tempipban " + name + " " + duration + " " + reason + " #" + ids);
			          	  } else {
		            			ProxyServer.getInstance().getPluginManager().dispatchCommand(sender, "tempmute " + name + " " + duration + " " + reason + " #" + ids);
		            			ProxyServer.getInstance().getPluginManager().dispatchCommand(sender, "tempipmute " + name + " " + duration + " " + reason + " #" + ids);
			          	  }
		          	  } else {
			          	  if (ban) {
		            			ProxyServer.getInstance().getPluginManager().dispatchCommand(sender, "tempban " + name + " " + duration + " " + reason + " #" + ids);
		            			ProxyServer.getInstance().getPluginManager().dispatchCommand(sender, "tempipban " + name + " " + duration + " " + reason + " #" + ids);
			          	  } else {
		            			ProxyServer.getInstance().getPluginManager().dispatchCommand(sender, "tempmute " + name + " " + duration + " " + reason + " #" + ids);
		            			ProxyServer.getInstance().getPluginManager().dispatchCommand(sender, "tempipmute " + name + " " + duration + " " + reason + " #" + ids);
			          	  }
		          	  }
		    			if (ban) {
                    		if (sender instanceof ProxiedPlayer) {
                    			System.out.println("§8┃ §6HozexMC §8┃ §3" + API.getP(name) + " §7was banned by " + API.getP(sender.getName()) + " §7for §4" + reason);
                    		} else {
                    			System.out.println("§8┃ §6HozexMC §8┃ §3" + API.getP(name) + " §7was banned by §cCONSOLE §7for §4" + reason);
                    		}
                    		System.out.println("§8┃ §6HozexMC §8┃ §7Ban ID:§c " + ids);
                  		  if (!evedence.equalsIgnoreCase("-")) {
                        		System.out.println("§8┃ §6HozexMC §8┃ §7Evedence:§c " + evedence);	
                    		}
		    				for (ProxiedPlayer all : BungeeCord.getInstance().getPlayers()) {
		    					if (all.hasPermission("H.Owner") || all.hasPermission("H.HeadAdmin") || all.hasPermission("H.Admin") || all.hasPermission("H.Developer") || all.hasPermission("H.Special") || all.hasPermission("H.SrMod") || all.hasPermission("H.Mod") || all.hasPermission("H.Helper")) {
		                    		if (sender instanceof ProxiedPlayer) {
		                    			all.sendMessage("§8┃ §6HozexMC §8┃ §3" + API.getP(name) + " §7was banned by " + API.getP(sender.getName()) + " §7for §4" + reason);
		                    		} else {
		                    			all.sendMessage("§8┃ §6HozexMC §8┃ §3" + API.getP(name) + " §7was banned by §cCONSOLE §7for §4" + reason);
		                    		}
		                    		all.sendMessage("§8┃ §6HozexMC §8┃ §7Ban ID:§c " + ids);
		    					}
	                    		if (!evedence.equalsIgnoreCase("-")) {
			                      	  if (all.hasPermission("H.Owner") || all.hasPermission("H.HeadAdmin") || all.hasPermission("H.Admin") || all.hasPermission("H.SrMod")) {
				                      	  all.sendMessage("§8┃ §6HozexMC §8┃ §7Evedence:§c " + evedence);
			                      	  }
		    					}
		    				}
		    				ProxiedPlayer t = BungeeCord.getInstance().getPlayer(name);
		    				if (t != null) {
								for (ProxiedPlayer all : BungeeCord.getInstance().getServerInfo(t.getServer().getInfo().getName()).getPlayers()) {
									if (all.hasPermission("H.Owner") || all.hasPermission("H.HeadAdmin") || all.hasPermission("H.Admin") || all.hasPermission("H.Developer") || all.hasPermission("H.Special") || all.hasPermission("H.SrMod") || all.hasPermission("H.Mod") || all.hasPermission("H.Helper")) {
									} else {
										all.sendMessage("§cA§c §cP§clayer §cw§ca§cs §cr§cemoved §cf§crom §cy§co§cu§cr§c §cgame §cf§co§cr§c §ch§ca§cc§ck§ci§cn§cg");
										all.sendMessage("§cT§ch§ca§cnks §cfor §creporting §chim");
									}
								}
							}
		    			} else {
                    		if (sender instanceof ProxiedPlayer) {
                    			System.out.println("§8┃ §6HozexMC §8┃ §3" + API.getP(name) + " §7was muted by " + API.getP(sender.getName()) + " §7for §c" + reason);
                    		} else {
                    			System.out.println("§8┃ §6HozexMC §8┃ §3" + API.getP(name) + " §7was muted by §cCONSOLE §7for §c" + reason);
                    		}
                    		System.out.println("§8┃ §6HozexMC §8┃ §7Mute ID:§c " + ids);
                    		if (!evedence.equalsIgnoreCase("-")) {
                        		System.out.println("§8┃ §6HozexMC §8┃ §7Evedence:§c " + evedence);	
                    		}
		    				for (ProxiedPlayer all : BungeeCord.getInstance().getPlayers()) {
		    					if (all.hasPermission("H.Owner") || all.hasPermission("H.HeadAdmin") || all.hasPermission("H.Admin") || all.hasPermission("H.Developer") || all.hasPermission("H.Special") || all.hasPermission("H.SrMod") || all.hasPermission("H.Mod") || all.hasPermission("H.Helper")) {
		                    		if (sender instanceof ProxiedPlayer) {
		                    			all.sendMessage("§8┃ §6HozexMC §8┃ §3" + API.getP(name) + " §7was muted by " + API.getP(sender.getName()) + " §7for §c" + reason);
		                    		} else {
		                    			all.sendMessage("§8┃ §6HozexMC §8┃ §3" + API.getP(name) + " §7was muted by §cCONSOLE §7for §c" + reason);
		                    		}
		                    		all.sendMessage("§8┃ §6HozexMC §8┃ §7Mute ID:§c " + ids);
		    					}
	                    		if (!evedence.equalsIgnoreCase("-")) {
			                      	  if (all.hasPermission("H.Owner") || all.hasPermission("H.HeadAdmin") || all.hasPermission("H.Admin") || all.hasPermission("H.SrMod")) {
				                      	  all.sendMessage("§8┃ §6HozexMC §8┃ §7Evedence:§c " + evedence);
			                      	  }
		    					}
		    				}
		    			}
		    			ProxiedPlayer t = BungeeCord.getInstance().getPlayer(name);
		          	  if (t != null) {
		          		  if (ban) {
		                  	  config.set(ids + ".server", t.getServer().getInfo().getName());
		                		t.sendMessage("§8§m--------------§7§m-------§f- « §4Bans§7 §f» §f§m-§7§m-------§8§m--------------");
		                		t.sendMessage("§8┃ §eHozexMC §8┃ §7You have been banned from this server!");
		                		t.sendMessage("§8┃ §eHozexMC §8┃ §7Ban ID: §c" + ids);
		            			t.sendMessage("§8┃ §eHozexMC §8┃ §7Appeal at: §cdiscord.gg/yXBxY4v");
		            			t.sendMessage("§8┃ §eHozexMC §8┃ §7Give us your BanID");
		          			t.sendMessage("§8§m---------------§7§m-------§f- « §c✦§7 §f» §f§m-§7§m-------§8§m---------------");
		          		  } else {
		                  	  config.set(ids + ".server", t.getServer().getInfo().getName());
		                		t.sendMessage("§8§m--------------§7§m-------§f- « §4Bans§7 §f» §f§m-§7§m-------§8§m--------------");
		                		t.sendMessage("§8┃ §eHozexMC §8┃ §7You have been muted from this server!");
		                		t.sendMessage("§8┃ §eHozexMC §8┃ §7Mute ID: §c" + ids);
		            			t.sendMessage("§8┃ §eHozexMC §8┃ §7Appeal at: §cdiscord.gg/yXBxY4v");
		            			t.sendMessage("§8┃ §eHozexMC §8┃ §7Give us your MuteID");
		          			t.sendMessage("§8§m---------------§7§m-------§f- « §c✦§7 §f» §f§m-§7§m-------§8§m---------------");
		          		  }
		          	  } else {
		              	  config.set(ids + ".server", "OFFLINE");
		          	  }
		          	  config.set(ids + ".reason", reason);
		          	  if (ban) {
		              	  config.set(ids + ".type", "Ban");  
		          	  } else {
		              	  config.set(ids + ".type", "Mute");
		          	  }
              		if (!evedence.equalsIgnoreCase("-")) {
		              	  config.set(ids + ".evedence", evedence);
		          	  } else {
		              	  config.set(ids + ".evedence", "none");
		          	  }
		          	  config.set(ids + ".biptimes", "0");
		          	  config.set(ids + ".btimes", "0");
		      		  ConfigurationProvider.getProvider(YamlConfiguration.class).save(config, file2);
		            } catch (IOException e) {
		          	  e.printStackTrace();
		            }
	  }
}
}