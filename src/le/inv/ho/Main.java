package le.inv.ho;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import le.inv.ho.Commands.*;
import le.inv.ho.Listeners.ChatListener;
import le.inv.ho.Listeners.CommandListener;
import le.inv.ho.Listeners.JoinMessages;
import le.inv.ho.Listeners.PartyAndFriends;
import le.inv.ho.Listeners.PlayerMessagingListener;
import le.inv.ho.Listeners.ServerKick;
import le.inv.ho.Listeners.TabComplete;
import le.inv.ho.Listeners.Tablist;
import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.api.plugin.PluginManager;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;

public class Main extends Plugin {
  public static Main m;
  public static boolean MAINTENANCE = false;
  static Main sharedInstance;
  public String px;
  public String blocked;
  public String alreadyadded;
  public String added;
  public String removed;
  public String notcontains;
  public static String datebase;
  public static String User;
  public static String pss;
  public static int y;
  public static int counter = 0;
  public static HashMap<String, Long> cmddelay = new HashMap<String, Long>();
  
  
  private void registerCommandEvents(PluginManager pm) {
	  
	  // Listeners
	  getProxy().getPluginManager().registerListener(this, new ServerKick());
	  getProxy().getPluginManager().registerListener(this, new TabComplete());
	  getProxy().getPluginManager().registerListener(this, new PartyAndFriends());
	  getProxy().getPluginManager().registerListener(this, new Tablist(this));
	  getProxy().getPluginManager().registerListener(this, new ChatListener(this));
	  getProxy().getPluginManager().registerListener(this, new le.inv.ho.Commands.Chat(this));
	  getProxy().getPluginManager().registerListener(this, new CommandListener());
	  getProxy().getPluginManager().registerListener(this, new PlayerMessagingListener());
	  getProxy().getPluginManager().registerListener(this, new JoinMessages(this));
	  
	  
	  // Commands
	  getProxy().getPluginManager().registerCommand(this, new BStopCommand(this));
	  getProxy().getPluginManager().registerCommand(this, new TeamChat(this));
	  getProxy().getPluginManager().registerCommand(this, new HubCommand("hub"));
	  getProxy().getPluginManager().registerCommand(this, new PingCommand());
	  getProxy().getPluginManager().registerCommand(this, new ModChat(this));
	  getProxy().getPluginManager().registerCommand(this, new Find());
	  ProxyServer.getInstance().getPluginManager().registerCommand(this, new Bans(this));
	  ProxyServer.getInstance().getPluginManager().registerCommand(this, new IDCommand(this));
	  ProxyServer.getInstance().getPluginManager().registerCommand(this, new Evedence(null));
	  getProxy().getPluginManager().registerCommand(this, new CC());
	  getProxy().getPluginManager().registerCommand(this, new DiscordCommand());
	  getProxy().getPluginManager().registerCommand(this, new Store());
	  getProxy().getPluginManager().registerCommand(this, new glist());
	  getProxy().getPluginManager().registerCommand(this, new blockadv());
	  getProxy().getPluginManager().registerCommand(this, new ModAdd());
	  getProxy().getPluginManager().registerCommand(this, new Send(this));
	  getProxy().getPluginManager().registerCommand(this, new HAlert(this));
	  getProxy().getPluginManager().registerCommand(this, new avgping());
	  getProxy().getPluginManager().registerCommand(this, new AnTitle(this));
	  getProxy().getPluginManager().registerCommand(this, new Role());
//	  getProxy().getPluginManager().registerCommand(this, new bcbadd(this));
	  getProxy().getPluginManager().registerCommand(this, new le.inv.ho.Commands.Chat(this));
	  getProxy().getPluginManager().registerCommand(this, new Servers(this));
//	  getProxy().getPluginManager().registerCommand(this, new TeamChat(this));
	  getProxy().getPluginManager().registerCommand(this, new testcmd(this));
	  getProxy().getPluginManager().registerCommand(this, new AdminChat(this));
	  getProxy().getPluginManager().registerCommand(this, new mainmode());
	  getProxy().getPluginManager().registerCommand(this, new Website());
	  getProxy().getPluginManager().registerCommand(this, new otmove(this));
	  getProxy().getPluginManager().registerCommand(this, new OTRewards(this));
      getProxy().getPluginManager().registerCommand(this, new Contact());
      getProxy().getPluginManager().registerCommand(this, new Verify(this));
      datebase = "s6510_utilts";
	    User = "u6510_IXbBvWzXNf";
	    pss = "weU!Iub@f+gz4pjjc2ozoj=o";
	    y = 12;
	    msgsql.connect();
	    mysql.connect();
	    msq.connect();
	    autoRefresh();
	    for (ProxiedPlayer all : BungeeCord.getInstance().getPlayers()) {
	    	msgsql.addPlayer(all.getName());
	    }
		  BungeeCord.getInstance().getScheduler().schedule(this, new Runnable() {
				@Override
				public void run() {
					startBroadcast();
				}
			}, 10, TimeUnit.SECONDS);
  }
  
  public static int getRandom(int lower, int upper) {
      Random random = new Random();
      return random.nextInt((upper - lower) + 1) + lower;
  }
  
  public void startBroadcast() {
	  ArrayList<String> msg = new ArrayList<String>();
	  msg.add("§8[§6§l✴§8] §6Gold §fRank: §e30 Sawa§8╱§e5$");
	  msg.add("§8[§6§l✴§8] §bDiamond §fRank: §e50 Sawa§8╱§e8$");
	  msg.add("§8[§6§l✴§8] §aEmerald §fRank: §e75 Sawa§8╱§e12$");
      msg.add("§8[§6§l✴§8] §fIf you want to buy a rank contact us at §e/discord");
      msg.add("§8[§6§l✴§8] §fLink your minecraft account with discord by §e/verify");
	  msg.add("§8[§6§l✴§8] §fJoin our discord server: §9HozexMC.Net/discord");
	  msg.add("§8[§6§l✴§8] §fIf you found a hacker you could report him by §e/report");
	  BungeeCord.getInstance().getScheduler().schedule(this, new Runnable() {
		@Override
		public void run() {
			for (ProxiedPlayer all : BungeeCord.getInstance().getPlayers()) {
				all.sendMessage(msg.get(0));
			}
		}
	}, 0*4, TimeUnit.MINUTES);
	  BungeeCord.getInstance().getScheduler().schedule(this, new Runnable() {
		@Override
		public void run() {
			for (ProxiedPlayer all : BungeeCord.getInstance().getPlayers()) {
				all.sendMessage(msg.get(1));
			}
		}
	}, 1*4, TimeUnit.MINUTES);
	  BungeeCord.getInstance().getScheduler().schedule(this, new Runnable() {
		@Override
		public void run() {
			for (ProxiedPlayer all : BungeeCord.getInstance().getPlayers()) {
				all.sendMessage(msg.get(2));
			}
		}
	}, 2*4, TimeUnit.MINUTES);
	  BungeeCord.getInstance().getScheduler().schedule(this, new Runnable() {
		@Override
		public void run() {
			for (ProxiedPlayer all : BungeeCord.getInstance().getPlayers()) {
				all.sendMessage(msg.get(3));
			}
		}
	}, 3*4, TimeUnit.MINUTES);
	  BungeeCord.getInstance().getScheduler().schedule(this, new Runnable() {
		@Override
		public void run() {
			for (ProxiedPlayer all : BungeeCord.getInstance().getPlayers()) {
				all.sendMessage(msg.get(4));
			}
		}
	}, 4*4, TimeUnit.MINUTES);
      BungeeCord.getInstance().getScheduler().schedule(this, new Runnable() {
          @Override
          public void run() {
              for (ProxiedPlayer all : BungeeCord.getInstance().getPlayers()) {
                  all.sendMessage(msg.get(5));
              }
          }
      }, 5*4, TimeUnit.MINUTES);
      BungeeCord.getInstance().getScheduler().schedule(this, new Runnable() {
          @Override
          public void run() {
              for (ProxiedPlayer all : BungeeCord.getInstance().getPlayers()) {
                  all.sendMessage(msg.get(6));
              }
          }
      }, 5*4, TimeUnit.MINUTES);
	  BungeeCord.getInstance().getScheduler().schedule(this, new Runnable() {
		@Override
		public void run() {
			startBroadcast();
		}
	}, 7*4, TimeUnit.MINUTES);
  }
  
  public void autoRefresh() {
	    for (ProxiedPlayer all : BungeeCord.getInstance().getPlayers()) {
	    	otmove.OTRefresh(all.getName());
	    	API.updateGroup(all.getName());
	    }
	    BungeeCord.getInstance().getScheduler().schedule(this, new Runnable() {
			@Override
			public void run() {
				autoRefresh();
			}
		}, 1, TimeUnit.MINUTES);
  }
  
	public void allPing() {
		File file = new File("plugins/Hozex-Bungee/mods.yml");
		getProxy().getScheduler().schedule(this, new Runnable() {
			
			@Override
			public void run() {
				try {
					  for (ProxiedPlayer all : getProxy().getPlayers()) {
							Configuration config = ConfigurationProvider.getProvider(YamlConfiguration.class).load(file);
							int high = config.getInt(all.getName() + "high_ping");
							int low = config.getInt(all.getName() + "low_ping");
							int current = all.getPing();
							if (current > high) {
								config.set(all.getName() + "high_ping", all.getPing());
							} else if (current < low) {
								config.set(all.getName() + "low_ping", all.getPing());
							} else {
								
							}
							ConfigurationProvider.getProvider(YamlConfiguration.class).save(config, file);
					  }
				} catch (IOException e) {
					e.printStackTrace();
				}
				allPing();
			}
		}, 5, TimeUnit.SECONDS);
		
	}
  
  public void clearLists() {
      BungeeCord.getInstance().getScheduler().schedule(this, new Runnable() {
          @Override
          public void run() {
        	  
          }
      }, 1, 1440, TimeUnit.MINUTES);
  }
  public void onEnable() {
	    registerCommandEvents(BungeeCord.getInstance().getPluginManager());
	    m = this;
    try {
      if (!getDataFolder().exists()) {
        getDataFolder().mkdir();
      }
      File file = new File(getDataFolder().getPath(), "config.yml");
      if (!file.exists()) {
        file.createNewFile();
        Configuration config = ConfigurationProvider.getProvider(YamlConfiguration.class).load(file);
        System.out.println("§aconfig.yml§7 created!");
        ConfigurationProvider.getProvider(YamlConfiguration.class).save(config, file);
      } else {
        Configuration config = ConfigurationProvider.getProvider(YamlConfiguration.class).load(file);
        System.out.println("§aconfig.yml§7 loaded!");
      }
    } catch (IOException e) {
      e.printStackTrace();
    } try {
        if (!getDataFolder().exists()) {
            getDataFolder().mkdir();
          }
          File file = new File(getDataFolder().getPath(), "infos.yml");
          if (!file.exists()) {
            file.createNewFile();
            Configuration config = ConfigurationProvider.getProvider(YamlConfiguration.class).load(file);
            System.out.println("§infos.yml§7 created!");
            ConfigurationProvider.getProvider(YamlConfiguration.class).save(config, file);
          } else {
            Configuration config = ConfigurationProvider.getProvider(YamlConfiguration.class).load(file);
            System.out.println("§infos.yml§7 loaded!");
          }
        } catch (IOException e) {
          e.printStackTrace();
        } try {
            if (!getDataFolder().exists()) {
                getDataFolder().mkdir();
              }
            File file = new File(getDataFolder().getPath(), "mods.yml");
            if (!file.exists()) {
              file.createNewFile();
              Configuration config = ConfigurationProvider.getProvider(YamlConfiguration.class).load(file);
              System.out.println("§amods.yml§7 created!");
              ConfigurationProvider.getProvider(YamlConfiguration.class).save(config, file);
            } else {
              Configuration config = ConfigurationProvider.getProvider(YamlConfiguration.class).load(file);
              System.out.println("§amods.yml§7 loaded!");
            }
            } catch (IOException e) {
              e.printStackTrace();
            } try {
                if (!getDataFolder().exists()) {
                    getDataFolder().mkdir();
                  }
                File file = new File(getDataFolder().getPath(), "blockadv.yml");
                if (!file.exists()) {
                  file.createNewFile();
                  Configuration config = ConfigurationProvider.getProvider(YamlConfiguration.class).load(file);
                  System.out.println("§ablockadv.yml§7 created!");
                  ConfigurationProvider.getProvider(YamlConfiguration.class).save(config, file);
                } else {
                  Configuration config = ConfigurationProvider.getProvider(YamlConfiguration.class).load(file);
                  System.out.println("§ablockadv.yml§7 loaded!");
                }
                } catch (IOException e) {
                  e.printStackTrace();
                } try {
                if (!getDataFolder().exists()) {
                    getDataFolder().mkdir();
                  }
                File file = new File(getDataFolder().getPath(), "commands.yml");
                if (!file.exists()) {
                  file.createNewFile();
                  Configuration config = ConfigurationProvider.getProvider(YamlConfiguration.class).load(file);
                  System.out.println("§acommands.yml§7 created!");
                  ConfigurationProvider.getProvider(YamlConfiguration.class).save(config, file);
                } else {
                  Configuration config = ConfigurationProvider.getProvider(YamlConfiguration.class).load(file);
                  System.out.println("§acommands.yml§7 loaded!");
                }
                } catch (IOException e) {
                  e.printStackTrace();
                } try {
            if (!getDataFolder().exists()) {
                getDataFolder().mkdir();
              }
              File file = new File(getDataFolder().getPath(), "chats.yml");
              if (!file.exists()) {
                file.createNewFile();
                Configuration config = ConfigurationProvider.getProvider(YamlConfiguration.class).load(file);
                System.out.println("§achats.yml§7 created!");
                ConfigurationProvider.getProvider(YamlConfiguration.class).save(config, file);
              } else {
                Configuration config = ConfigurationProvider.getProvider(YamlConfiguration.class).load(file);
                System.out.println("§achats.yml§7 loaded!");
              }
            } catch (IOException e) {
              e.printStackTrace();
            } try {
            if (!getDataFolder().exists()) {
                getDataFolder().mkdir();
              }
              File file = new File(getDataFolder().getPath(), "delay.yml");
              if (!file.exists()) {
                file.createNewFile();
                Configuration config = ConfigurationProvider.getProvider(YamlConfiguration.class).load(file);
                System.out.println("§adelay.yml§7 created!");
                ConfigurationProvider.getProvider(YamlConfiguration.class).save(config, file);
              } else {
                Configuration config = ConfigurationProvider.getProvider(YamlConfiguration.class).load(file);
                System.out.println("§adelay.yml§7 loaded!");
              }
            } catch (IOException e) {
              e.printStackTrace();
            } try {
                if (!getDataFolder().exists()) {
                    getDataFolder().mkdir();
                  }
                  File file = new File(getDataFolder().getPath(), "pings.yml");
                  if (!file.exists()) {
                    file.createNewFile();
                    Configuration config = ConfigurationProvider.getProvider(YamlConfiguration.class).load(file);
                    System.out.println("§apings.yml§7 created!");
                    ConfigurationProvider.getProvider(YamlConfiguration.class).save(config, file);
                  } else {
                    Configuration config = ConfigurationProvider.getProvider(YamlConfiguration.class).load(file);
                    System.out.println("§apings.yml§7 loaded!");
                  }
                } catch (IOException e) {
                  e.printStackTrace();
                } try {
        if (!getDataFolder().exists()) {
            getDataFolder().mkdir();
          }
          File file = new File(getDataFolder().getPath(), "commands.yml");
          if (!file.exists())
          {
            file.createNewFile();
            Configuration config = ConfigurationProvider.getProvider(YamlConfiguration.class).load(file);
            List<String> list = config.getStringList("commands");
            list.add("plugins");
            list.add("?");
            config.set("commands", list);
            ConfigurationProvider.getProvider(YamlConfiguration.class).save(config, file);
          }
        } catch (IOException e) {
          e.printStackTrace();
        } try {
            if (!getDataFolder().exists()) {
                getDataFolder().mkdir();
              }
              File file = new File(getDataFolder().getPath(), "bansid.yml");
              if (!file.exists())
              {
                file.createNewFile();
                Configuration config = ConfigurationProvider.getProvider(YamlConfiguration.class).load(file);
                config.set("gg", "hi");
                ConfigurationProvider.getProvider(YamlConfiguration.class).save(config, file);
              }
            } catch (IOException e) {
              e.printStackTrace();
            } try {
                if (!getDataFolder().exists()) {
                    getDataFolder().mkdir();
                  }
                  File file = new File(getDataFolder().getPath(), "chat.yml");
                  if (!file.exists()) {
                    file.createNewFile();
                    Configuration config = ConfigurationProvider.getProvider(YamlConfiguration.class).load(file);
                    System.out.println("§achat.yml§7 created!");
                    ConfigurationProvider.getProvider(YamlConfiguration.class).save(config, file);
                  } else {
                    Configuration config = ConfigurationProvider.getProvider(YamlConfiguration.class).load(file);
                    System.out.println("§achat.yml§7 loaded!");
                  }
                } catch (IOException e) {
                  e.printStackTrace();
                } try {
                if (!getDataFolder().exists()) {
                    getDataFolder().mkdir();
                  }
                  File file = new File(getDataFolder().getPath(), "base.yml");
                  if (!file.exists()) {
                    file.createNewFile();
                    Configuration config = ConfigurationProvider.getProvider(YamlConfiguration.class).load(file);
                    System.out.println("§abase.yml§7 created!");
                    ConfigurationProvider.getProvider(YamlConfiguration.class).save(config, file);
                  } else {
                    Configuration config = ConfigurationProvider.getProvider(YamlConfiguration.class).load(file);
                    System.out.println("§abase.yml§7 loaded!");
                  }
                } catch (IOException e) {
                  e.printStackTrace();
                } try {
                    if (!getDataFolder().exists()) {
                        getDataFolder().mkdir();
                      }
                      File file = new File(getDataFolder().getPath(), "alert.yml");
                      if (!file.exists()) {
                        file.createNewFile();
                        Configuration config = ConfigurationProvider.getProvider(YamlConfiguration.class).load(file);
                        System.out.println("§aalert.yml§7 created!");
                        ConfigurationProvider.getProvider(YamlConfiguration.class).save(config, file);
                      } else {
                        Configuration config = ConfigurationProvider.getProvider(YamlConfiguration.class).load(file);
                        System.out.println("§aalert.yml§7 loaded!");
                      }
                    } catch (IOException e) {
                      e.printStackTrace();
                    }
  }
  
  public static Main sharedInstance() {
	    return sharedInstance;
	  }
  
}