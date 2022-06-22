package le.inv.ho;

import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;

public class API {
	
  public static TextComponent getHoverMessage(String message, String hovermessage) {
    TextComponent tc = new TextComponent(message);
    tc.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(hovermessage).create()));
    return tc;
  }

  public static TextComponent getClickRunCommandMessage(String message, String commandNoSlash) {
    TextComponent tc = new TextComponent(message);
    tc.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/" + commandNoSlash));
    return tc;
  }

  public static TextComponent getURLMessage(String message, String url) {
    TextComponent tc = new TextComponent(message);
    tc.setClickEvent(new ClickEvent(ClickEvent.Action.OPEN_URL, url));
    return tc;
  }

  public static TextComponent getHoverClickRunCommandMessage(String message, String hovermessage, String commandNoSlash) {
	    TextComponent tc = new TextComponent(message);
	    tc.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(hovermessage).create()));
	    tc.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/" + commandNoSlash));
	    return tc;
	  }
  
  public static TextComponent getHoverClickRunCommandSuggest(String message, String hovermessage, String commandNoSlash) {
	    TextComponent tc = new TextComponent(message);
	    tc.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder(hovermessage).create()));
	    tc.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/" + commandNoSlash));
	    return tc;
	  }
  
  public static String getColor(String player) {
	  if (API.getPrimaryGroup(player).equalsIgnoreCase("Owner")) {
	    	return ("§e" + player);
	  } else if (API.getPrimaryGroup(player).equalsIgnoreCase("HeadAdmin")) {
	    	return ("§6" + player);
	  } else if (API.getPrimaryGroup(player).equalsIgnoreCase("Admin")) {
	    	return ("§4" + player);
	  } else if (API.getPrimaryGroup(player).equalsIgnoreCase("SrMod")) {
	    	return ("§4" + player);
	  } else if (API.getPrimaryGroup(player).equalsIgnoreCase("Developer")) {
	    	return ("§f" + player);
	  } else if (API.getPrimaryGroup(player).equalsIgnoreCase("Special")) {
	    	return ("§f" + player);
	  } else if (API.getPrimaryGroup(player).equalsIgnoreCase("VIP")) {
	    	return ("§5" + player);
	  } else if (API.getPrimaryGroup(player).equalsIgnoreCase("Mod")) {
	    	return ("§c" + player);
	  } else if (API.getPrimaryGroup(player).equalsIgnoreCase("Helper")) {
	    	return ("§3" + player);
	  } else if (API.getPrimaryGroup(player).equalsIgnoreCase("Builder")) {
	    	return ("§2" + player);
	  } else if (API.getPrimaryGroup(player).equalsIgnoreCase("Emerald")) {
	    	return ("§a" + player);
	  } else if (API.getPrimaryGroup(player).equalsIgnoreCase("Diamond")) {
	    	return ("§b" + player);
	  } else if (API.getPrimaryGroup(player).equalsIgnoreCase("Gold")) {
	    	return ("§6" + player);
	  } else if (API.getPrimaryGroup(player).equalsIgnoreCase("YouTuber")) {
	    	return ("§5" + player);
	  } else if (API.getPrimaryGroup(player).equalsIgnoreCase("Actor")) {
	    	return ("§7" + player);
	  } else {
	    	return ("§7" + player);
	  }
  }
  
  public static String getP(String player) {
	  ProxiedPlayer p = BungeeCord.getInstance().getPlayer(player);
	  if (p != null) {
		  if (p.getServer().getInfo().getName().contains("Prison")) {
			    if (p.hasPermission("H.Owner")) {
			    	return ("§e" + p.getName());
			      } else if (p.hasPermission("H.HeadAdmin")) {
			    	  return ("§6" + p.getName());
				  } else if (p.hasPermission("H.Admin")) {
			    	  return ("§4" + p.getName());
				  } else if (p.hasPermission("H.SrMod")) {
			    	  return ("§4" + p.getName());
			      } else if (p.hasPermission("H.Developer")) {
			    	  return ("§f" + p.getName());
				  } else if (p.hasPermission("H.Special")) {
			    	  return ("§f" + p.getName());
				  } else if (p.hasPermission("H.VIP")) {
			    	  return ("§5" + p.getName());
				  } else if (p.hasPermission("H.Mod")) {
			    	  return ("§c" + p.getName());
			      } else if (p.hasPermission("H.Helper")) {
			    	  return ("§3" + p.getName());
			      } else if (p.hasPermission("H.PLapis")) {
			    	  return ("§8(§5P§8) §9" + p.getName());
			      } else if (p.hasPermission("H.PStone")) {
			    	  return ("§8(§5P§8) §b" + p.getName());
			      } else if (p.hasPermission("H.PVIP")) {
			    	  return ("§8(§5P§8) §a" + p.getName());
			      }
		  } else {
			    if (p.hasPermission("H.Owner")) {
			    	return ("§e" + p.getName());
			      } else if (p.hasPermission("H.HeadAdmin")) {
			    	  return ("§6" + p.getName());
				  } else if (p.hasPermission("H.Admin")) {
			    	  return ("§4" + p.getName());
				  } else if (p.hasPermission("H.SrMod")) {
			    	  return ("§4" + p.getName());
			      } else if (p.hasPermission("H.Developer")) {
			    	  return ("§f" + p.getName());
				  } else if (p.hasPermission("H.Special")) {
			    	  return ("§f" + p.getName());
				  } else if (p.hasPermission("H.VIP")) {
			    	  return ("§5" + p.getName());
				  } else if (p.hasPermission("H.Mod")) {
			    	  return ("§c" + p.getName());
			      } else if (p.hasPermission("H.Helper")) {
			    	  return ("§3" + p.getName());
			      } else if (p.hasPermission("H.YouTuber")) {
			    	  return ("§5" + p.getName());
			      } else if (p.hasPermission("H.Builder")) {
			    	  return ("§2" + p.getName());
			      } else if (p.hasPermission("H.Emerald")) {
			    	  return ("§a" + p.getName());
			      } else if (p.hasPermission("H.Diamond")) {
			    	  return ("§b" + p.getName());
			      } else if (p.hasPermission("H.Gold")) {
			    	  return ("§6" + p.getName());
				  } else {
			    	  return ("§7" + p.getName());
				  }
		  }
	  } else {
		  return ("§c[OFF] " + player);
	  }
	return null;
  }
  
  public static String getPRank(String player) {
	  ProxiedPlayer p = BungeeCord.getInstance().getPlayer(player);
	  if (p != null) {
		  if (p.getServer().getInfo().getName().contains("Prison")) {
			    if (p.hasPermission("H.Owner")) {
			    	return ("§eOwner");
			      } else if (p.hasPermission("H.HeadAdmin")) {
			    	  return ("§6HeadAdmin");
				  } else if (p.hasPermission("H.Admin")) {
			    	  return ("§4Admin");
				  } else if (p.hasPermission("H.SrMod")) {
			    	  return ("§4Sr§cMod");
			      } else if (p.hasPermission("H.Developer")) {
			    	  return ("§fDev");
				  } else if (p.hasPermission("H.Special")) {
			    	  return ("§fSpecial");
				  } else if (p.hasPermission("H.VIP")) {
			    	  return ("§5VIP");
				  } else if (p.hasPermission("H.Mod")) {
			    	  return ("§cMod");
			      } else if (p.hasPermission("H.Helper")) {
			    	  return ("§3Helper");
			      } else if (p.hasPermission("H.PLapis")) {
			    	  return ("§8(§5P§8) §9Lapis");
			      } else if (p.hasPermission("H.PStone")) {
			    	  return ("§8(§5P§8) §bStone");
			      } else if (p.hasPermission("H.PVIP")) {
			    	  return ("§8(§5P§8) §aVIP");
			      } else {
			    	  return ("§7Default");
				  }
		  } else {
			    if (p.hasPermission("H.Owner")) {
			    	return ("§eOwner");
			      } else if (p.hasPermission("H.HeadAdmin")) {
			    	  return ("§6HeadAdmin");
				  } else if (p.hasPermission("H.Admin")) {
			    	  return ("§4Admin");
				  } else if (p.hasPermission("H.SrMod")) {
			    	  return ("§4Sr§cMod");
			      } else if (p.hasPermission("H.Developer")) {
			    	  return ("§fDev");
				  } else if (p.hasPermission("H.Special")) {
			    	  return ("§fSpecial");
				  } else if (p.hasPermission("H.VIP")) {
			    	  return ("§5VIP");
				  } else if (p.hasPermission("H.Mod")) {
			    	  return ("§cMod");
			      } else if (p.hasPermission("H.Helper")) {
			    	  return ("§3Helper");
			      } else if (p.hasPermission("H.YouTuber")) {
			    	  return ("§5YouTuber");
			      } else if (p.hasPermission("H.Builder")) {
			    	  return ("§2Builder");
			      } else if (p.hasPermission("H.Emerald")) {
			    	  return ("§aEmerald");
			      } else if (p.hasPermission("H.Diamond")) {
			    	  return ("§bDiamond");
			      } else if (p.hasPermission("H.Gold")) {
			    	  return ("§6Gold");
				  } else {
			    	  return ("§7Default");
				  }
		  }
	  } else {
		  return ("§c[OFF] " + player);
	  }
  }
  
  public static int getCurrentOT(String name) {
	  File file1 = new File("plugins/OnlineTime/names.yml");
	  File file2 = new File("plugins/OnlineTime/time.yml");	
	  int time1 = 600;
	  try {
			Configuration names = ConfigurationProvider.getProvider(YamlConfiguration.class).load(file1);
			Configuration time = ConfigurationProvider.getProvider(YamlConfiguration.class).load(file2);
			
			  String uuid1 = names.getString(name);
			  time1 = time.getInt(uuid1);
		} catch (IOException e) {
			e.printStackTrace();
		}
	  return time1;
  }
  
  public static void setOT(String Name, int Amount) {
	    if (exists(Name)) {
	      int Time = Amount;
	      mysql.update("UPDATE OT SET Time='" + Time + "' WHERE Name='" + Name + "'");
	    } else {
		      mysql.update("INSERT INTO OT (Name, Time) VALUES ('" + Name + "', '" + Amount + "');");
	    }
	  }
  public static boolean exists(String Name) {
	    ResultSet Result = mysql.getResult("SELECT * FROM OT WHERE Name='" + Name + "'");
	    try {
	      if (Result.next()) {
	        return true;
	      }
	    }
	    catch (SQLException localSQLException) {}
	    return false;
	  }
  
  public static boolean existsGroup(String Name) {
	    ResultSet Result = mysql.getResult("SELECT * FROM PRank WHERE Name='" + Name + "'");
	    try {
	      if (Result.next()) {
	        return true;
	      }
	    }
	    catch (SQLException localSQLException) {}
	    return false;
	  }

  public static boolean existsInLuckperms(String Name) {
	  ResultSet Result = msq.getResult("SELECT * FROM lp_players WHERE username='" + Name + "'");
	    try {
	      if (Result.next()) {
	        return true;
	      }
	    }
	    catch (SQLException localSQLException) {}
	    return false;
	  }
  
  public static void updateGroup(String Name) {
	    if (!existsGroup(Name)) {
	        mysql.update("INSERT INTO PRank (Name, Rank) VALUES ('" + Name + "', '" + getPrimaryGroup(Name) + "')");
	    } else {
		      mysql.update("UPDATE PRank SET Rank='" + getPrimaryGroup(Name) + "' WHERE Name='" + Name + "'");
	    }
	  }
  
  
  
  public static String getPrimaryGroup(String Name) {
	    String Group = "";
	      ResultSet Result = msq.getResult("SELECT * FROM lp_players WHERE username='" + Name + "'");
	      try {
	        if (Result.next()) {
	          Group = Result.getString("primary_group");
	        }
	      }
	      catch (SQLException localSQLException) {}
	    return Group;
	  }
  
  public static void setGroup(String Name) {
	    if (existsGroup(Name)) {
	      mysql.update("UPDATE PRank SET Rank='" + getPrimaryGroup(Name) + "' WHERE Name='" + Name + "'");
	    }
	  }
  
  public static int getRanking(String Name) {
    int Ranking = 1;
    if (exists(Name)) {
      ResultSet Result = mysql.getResult("SELECT * FROM OT ORDER Time desc");
      try {
        while (Result.next()) {
          if (Result.getString("Name").equalsIgnoreCase(Name)) {
            return Ranking;
          }
          Ranking++;
        }
      }
      catch (SQLException localSQLException) {}
    }
    return Ranking;
  }
  
  public static void create(ProxiedPlayer p) {
	    if (!exists(p.getName())) {
	        mysql.update("INSERT INTO OT (Name, Time) VALUES ('" + p.getName() + "', '0')");
	    } else {
	    }
	  }
  
  public static boolean hasNick(String name) {
	    ResultSet Result = mysql.getResult("SELECT * FROM Nicks WHERE Name='" + name + "'");
	    try {
	      if (Result.next()) {
	        return true;
	      }
	    }
	    catch (SQLException localSQLException) {}
	    return false;
	  }
  
  public static boolean isModerator(String name) {
	  if (getPrimaryGroup(name).contains("Owner") || getPrimaryGroup(name).contains("HeadAdmin") || getPrimaryGroup(name).contains("Admin") || getPrimaryGroup(name).contains("SrMod") || getPrimaryGroup(name).contains("Mod") || getPrimaryGroup(name).contains("Special") || getPrimaryGroup(name).contains("Helper") || getPrimaryGroup(name).contains("Developer")) {
		  return true;
	  } else {
		  return false;
	  }
  }
  public static String getNickRank(String name) {
      ResultSet Result = mysql.getResult("SELECT * FROM Nicks WHERE Name='" + name + "'");
      try {
        if (Result.next()) {
          return Result.getString("Rank");
        } else {
	      return null;
        }
      }
      catch (SQLException localSQLException) {
    	  return null;
      }
}
  public static ArrayList<String> getTopPlayers() {
	    ArrayList<String> Top = new ArrayList();
	    ResultSet Result = mysql.getResult("SELECT * FROM OT ORDER BY Time desc LIMIT 10");
	    try {
	      while (Result.next()) {
	        Top.add(Result.getString("Name"));
	      }
	    } catch (SQLException localSQLException) {}
	    return Top;
	  }
  
  public static ArrayList<String> getPlayers() {
	    ArrayList<String> Top = new ArrayList();
	    ResultSet Result = msq.getResult("SELECT * FROM lp_players ORDER BY username desc LIMIT 10");
	    try {
	      while (Result.next()) {
	    	  if (Result.getString("username").length() < 15) {
	  	        Top.add(Result.getString("username"));
	    	  }
	      }
	    } catch (SQLException localSQLException) {}
	    return Top;
	  }
  public static int getOT(String Name) {
	    int Played = 0;
	    if (exists(Name)) {
	      ResultSet Result = mysql.getResult("SELECT * FROM OT WHERE Name='" + Name + "'");
	      try {
	        if (Result.next()) {
	          Played = Result.getInt("Time");
	        }
	      }
	      catch (SQLException sQLException) {}
	    } 
	    return Played;
	  }
  
  public static boolean isVanished(String Name) {
	  int vanished = 0;
	      ResultSet Result = msq.getResult("SELECT * FROM premiumvanish_playerdata WHERE Name='" + Name + "'");
	      try {
	        if (Result.next()) {
	          vanished = Result.getInt("Vanished");
	        }
	      }
	      catch (SQLException sQLException) {}
	      if (vanished == 0) {
	    	  return false;
	      } else {
	    	  return true;
	      }
	  }
  public static void setVanished(String Name, boolean vanished) {
	  if (vanished) {
	      msq.update("UPDATE premiumvanish_playerdata SET Vanished=1 WHERE Name='" + Name + "'");
	  } else {
	      msq.update("UPDATE premiumvanish_playerdata SET Vanished=0 WHERE Name='" + Name + "'");
	  }
  }
  public static ArrayList<Integer> getDaysOT(String Name) {
	    int sec = getOT(Name);
	    int dd = sec/(3600*24);
	    int hh = (sec%(3600*24))/(3600);
	    int mm = ((sec%(3600*24))%(3600))/60;
	    ArrayList<Integer> total = new ArrayList<Integer>();
	    total.add(dd); total.add(hh); total.add(mm);
	    return total;
	  }
}