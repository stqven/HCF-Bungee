package le.inv.ho.Commands;

import java.io.File;
import java.io.IOException;

import de.simonsator.partyandfriends.api.pafplayers.OnlinePAFPlayer;
import de.simonsator.partyandfriends.api.party.PartyAPI;
import de.simonsator.partyandfriends.api.party.PartyManager;
import de.simonsator.partyandfriends.friends.commands.Friends;
import de.simonsator.partyandfriends.friends.settings.FriendRequestSetting;
import de.simonsator.partyandfriends.party.command.PartyChat;
import le.inv.ho.Arabic;
import le.inv.ho.Main;
import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.ChatEvent;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;
import net.md_5.bungee.event.EventHandler;

public class Chat extends Command implements Listener {
	private Main bcb;
	
	public Chat(Main bcb) {
		super("chat");
	    this.bcb = bcb;
	}
	
	public void execute(CommandSender sender, String[] args) {
		ProxiedPlayer p = (ProxiedPlayer) sender;
		if (args.length == 0) {
			p.sendMessage("§8❘ §cHozexMC §8❘ §7/chat §8[§eAll §7(A) §8- §eParty §7(P) §8- §eGang §7(G)§8]");
		} else {
			if (args[0].equals("all") || args[0].equals("a")) {
                File file = new File(this.bcb.getDataFolder().getPath(), "chat.yml");
              	  Configuration config;
				try {
					config = ConfigurationProvider.getProvider(YamlConfiguration.class).load(file);
					config.set(p.getName() + ".chat", "all");
	              	  ConfigurationProvider.getProvider(YamlConfiguration.class).save(config, file);
				} catch (IOException e) {
					e.printStackTrace();
				}
				p.sendMessage("§8❘ §aHozexMC §8❘ §7You are now talking in the §7(§ePublic chat§7)");
			} else if (args[0].equals("gang") || args[0].equals("g")) {
                File file = new File(this.bcb.getDataFolder().getPath(), "chat.yml");
            	  Configuration config;
				try {
					config = ConfigurationProvider.getProvider(YamlConfiguration.class).load(file);
					config.set(p.getName() + ".chat", "gang");
	              	  ConfigurationProvider.getProvider(YamlConfiguration.class).save(config, file);
				} catch (IOException e) {
					e.printStackTrace();
				}
				p.sendMessage("§8❘ §aHozexMC §8❘ §7You are now talking in the §7(§eGang chat§7)");
				p.sendMessage("§8❘ §eHozexMC §8❘ §7Only works when you are in a gang");
			} else if (args[0].equals("party") || args[0].equals("p")) {
				if (de.simonsator.partyandfriends.api.party.PartyManager.getInstance().getParty(p.getUniqueId()) != null) {
	                File file = new File(this.bcb.getDataFolder().getPath(), "chat.yml");
	            	  Configuration config;
					try {
						config = ConfigurationProvider.getProvider(YamlConfiguration.class).load(file);
						if (config.getString(p.getName() + ".chat").contains("party")) {
							p.sendMessage("§8❘ §cHozexMC §8❘ §7You are already talking in the party chat");
						} else {
							config.set(p.getName() + ".chat", "party");
			              	  ConfigurationProvider.getProvider(YamlConfiguration.class).save(config, file);
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
					p.sendMessage("§8❘ §aHozexMC §8❘ §7You are now talking in the §7(§eParty chat§7)");
					p.sendMessage("§8❘ §eHozexMC §8❘ §7Only works when you are in a Party");
				} else {
					p.sendMessage("§8❘ §cHozexMC §8❘ §7You are not in a party");
				}
			} else {
				p.sendMessage("§8❘ §cHozexMC §8❘ §7/chat §8[§eAll §7(A) §8- §eParty §7(P) §8- §eGang §7(G)§8]");
			}
		}
	}
	
	@EventHandler
	public void onChatP(ChatEvent e) {
		if (e.getMessage().startsWith("/gchat") || e.getMessage().startsWith("/gangchat")) {
			if (e.getMessage().equals("/gchat") || e.getMessage().equals("/gangchat")) {
				e.setMessage("/gc");
			} else {
				String armsg = e.getMessage().replace("/gchat ", "").replace("/gangchat ", "");
				e.setMessage("/gc " + Arabic.changeArabic(armsg));
			}
		}
	}
	
	@EventHandler
	public void onPartyLeave(de.simonsator.partyandfriends.api.events.party.LeftPartyEvent e) {
        File file = new File(this.bcb.getDataFolder().getPath(), "chat.yml");
    	  Configuration config;
		try {
			config = ConfigurationProvider.getProvider(YamlConfiguration.class).load(file);
			if (config.getString(e.getPlayer().getName() + ".chat").contains("party")) {
				e.getPlayer().sendMessage("§8❘ §aHozexMC §8❘ §7You are now talking in the §7(§ePublic chat§7)");
				config.set(e.getPlayer().getName() + ".chat", "all");
              	ConfigurationProvider.getProvider(YamlConfiguration.class).save(config, file);
			}
		} catch (IOException evt) {
			evt.printStackTrace();
		}
	}
	
	@EventHandler
	public void onChat(ChatEvent e) {
		ProxiedPlayer p = (ProxiedPlayer) e.getSender();
		if (e.getMessage().startsWith("/")) {
			
		} else {
	        File file = new File(this.bcb.getDataFolder().getPath(), "chat.yml");
	    	  Configuration config;
			try {
				config = ConfigurationProvider.getProvider(YamlConfiguration.class).load(file);
				if (config.contains(p.getName() + ".chat")) {
					if (config.getString(p.getName() + ".chat").contains("all")) {
						
					} else if (config.getString(p.getName() + ".chat").contains("gang")) {
						if (p.getServer().getInfo().getName().contains("SkyPvP") || p.getServer().getInfo().getName().contains("RedstonePvP")) {
							e.setMessage("/gc " + e.getMessage());
						} else {
							
						}
					} else if (config.getString(p.getName() + ".chat").contains("party")) {
						e.setMessage("/party msg " + e.getMessage());
					} else {
						
					}
				} else {
				}
			} catch (IOException ec) {
				ec.printStackTrace();
			}
		}
	}

}
