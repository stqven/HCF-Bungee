package le.inv.ho.Commands;

import java.io.Console;
import java.util.concurrent.TimeUnit;

import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.command.ConsoleCommandSender;

public class BStopCommand extends Command {
	private Plugin plugin;
  
	public BStopCommand(Plugin plugin) {
		super("bstop");
		this.plugin = plugin;
	}
  
  public void execute(CommandSender sender, String[] args) {
        		if (sender instanceof ConsoleCommandSender || sender.hasPermission("H.Owner") || sender.hasPermission("H.HeadAdmin")) {
            		if (args.length == 0) {
                		BungeeCord.getInstance().broadcast("§8▏ §6HozexMC §8▏ §7The server will restart in §61 §7minute!");
                		
                		BungeeCord.getInstance().getScheduler().schedule(plugin, new Runnable() {
        					@Override
        					public void run() {
        						BungeeCord.getInstance().broadcast("§8▏ §6HozexMC §8▏ §7The server will restart in §650 §7seconds!");
        					}
        				}, 10, TimeUnit.SECONDS);
                		
                		BungeeCord.getInstance().getScheduler().schedule(plugin, new Runnable() {
        					@Override
        					public void run() {
        						BungeeCord.getInstance().broadcast("§8▏ §6HozexMC §8▏ §7The server will restart in §640 §7seconds!");
        					}
        				}, 20, TimeUnit.SECONDS);
                		
                		BungeeCord.getInstance().getScheduler().schedule(plugin, new Runnable() {
        					@Override
        					public void run() {
        						BungeeCord.getInstance().broadcast("§8▏ §6HozexMC §8▏ §7The server will restart in §630 §7seconds!");
        					}
        				}, 30, TimeUnit.SECONDS);
                		
                		BungeeCord.getInstance().getScheduler().schedule(plugin, new Runnable() {
        					@Override
        					public void run() {
        						BungeeCord.getInstance().broadcast("§8▏ §6HozexMC §8▏ §7The server will restart in §620 §7seconds!");
        					}
        				}, 40, TimeUnit.SECONDS);
                		
                		BungeeCord.getInstance().getScheduler().schedule(plugin, new Runnable() {
        					@Override
        					public void run() {
        						BungeeCord.getInstance().broadcast("§8▏ §6HozexMC §8▏ §7The server will restart in §610 §7seconds!");
        					}
        				}, 50, TimeUnit.SECONDS);
                		
                		BungeeCord.getInstance().getScheduler().schedule(plugin, new Runnable() {
        					@Override
        					public void run() {
        						BungeeCord.getInstance().broadcast("§8▏ §6HozexMC §8▏ §7The server will restart in §65 §7seconds!");
        					}
        				}, 55, TimeUnit.SECONDS);
                		
                		BungeeCord.getInstance().getScheduler().schedule(plugin, new Runnable() {
        					@Override
        					public void run() {
        						BungeeCord.getInstance().broadcast("§8▏ §6HozexMC §8▏ §7The server will restart in §64 §7seconds!");
        					}
        				}, 56, TimeUnit.SECONDS);
                		
                		BungeeCord.getInstance().getScheduler().schedule(plugin, new Runnable() {
        					@Override
        					public void run() {
        						BungeeCord.getInstance().broadcast("§8▏ §6HozexMC §8▏ §7The server will restart in §63 §7seconds!");
        					}
        				}, 57, TimeUnit.SECONDS);
                		
                		BungeeCord.getInstance().getScheduler().schedule(plugin, new Runnable() {
        					@Override
        					public void run() {
        						BungeeCord.getInstance().broadcast("§8▏ §6HozexMC §8▏ §7The server will restart in §62 §7seconds!");
        					}
        				}, 58, TimeUnit.SECONDS);
                		
                		BungeeCord.getInstance().getScheduler().schedule(plugin, new Runnable() {
        					@Override
        					public void run() {
        						BungeeCord.getInstance().broadcast("§8▏ §6HozexMC §8▏ §7The server will restart in §61 §7seconds!");
        					}
        				}, 59, TimeUnit.SECONDS);
                		
                		BungeeCord.getInstance().getScheduler().schedule(plugin, new Runnable() {
        					@Override
        					public void run() {
        		        		BungeeCord.getInstance().broadcast("§8▏ §eHozexMC §8▏ §7See you soon.");
        		        		for (ProxiedPlayer all : BungeeCord.getInstance().getPlayers()) {
        		        			all.disconnect("§8+ §8§m---------§7§m-§6§m-§e§m-------------§6§m-§7§m-§8§m---------§8 +\n§7\n§6Hozex§eMC \n §eServer Restarting... \n §aWe will back as soon as possiple\n§7\n§8+ §8§m---------§7§m-§6§m-§e§m-------------§6§m-§7§m-§8§m---------§8 +");
        		        		}
        		                BungeeCord.getInstance().stop();
        		                BungeeCord.getInstance().stop("§8+ §8§m---------§7§m-§6§m-§e§m-------------§6§m-§7§m-§8§m---------§8 +\\n§7\\n§6Hozex§eMC \\n §eServer Restarting... \\n §aWe will back as soon as possiple\\n§7\\n§8+ §8§m---------§7§m-§6§m-§e§m-------------§6§m-§7§m-§8§m---------§8 +");
        		                try {
        							BungeeCord.getInstance().start();
        						} catch (Exception e) {
        							e.printStackTrace();
        						}
        					}
        				}, 1, TimeUnit.MINUTES);
            		} else if (args.length == 1) {
            			if (args[0].equalsIgnoreCase("now") || args[0].equalsIgnoreCase("n")) {
    		        		BungeeCord.getInstance().broadcast("§8▏ §eHozexMC §8▏ §7See you soon.");
    		        		for (ProxiedPlayer all : BungeeCord.getInstance().getPlayers()) {
    		        			all.disconnect("§8+ §8§m---------§7§m-§6§m-§e§m-------------§6§m-§7§m-§8§m---------§8 +\n§7\n§6Hozex§eMC \n §eServer Restarting... \n §aWe will back as soon as possiple\n§7\n§8+ §8§m---------§7§m-§6§m-§e§m-------------§6§m-§7§m-§8§m---------§8 +");
    		        		}
    		                BungeeCord.getInstance().stop();
    		                BungeeCord.getInstance().stop("§8+ §8§m---------§7§m-§6§m-§e§m-------------§6§m-§7§m-§8§m---------§8 +\\n§7\\n§6Hozex§eMC \\n §eServer Restarting... \\n §aWe will back as soon as possiple\\n§7\\n§8+ §8§m---------§7§m-§6§m-§e§m-------------§6§m-§7§m-§8§m---------§8 +");
    		                try {
    							BungeeCord.getInstance().start();
    						} catch (Exception e) {
    							e.printStackTrace();
    						}
            			}
            		}
        		} else {
            		sender.sendMessage("§8▏ §cHozexMC §8▏ §7Unknown command.");
            	}
  }
}