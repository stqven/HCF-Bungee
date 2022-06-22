package le.inv.ho.Commands;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import le.inv.ho.msgsql;
import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Listener;

public class BansAPI implements Listener {
	
	public static void banPlayer(String id, String reason, long time, String by, String banid, String eve) {
		if (isBanned(id)) {
			changeLastBan(id, reason, time);
		} else {
			ProxiedPlayer t = BungeeCord.getInstance().getPlayer(msgsql.getIDPlayer(id));
			if (t != null) {
			      msgsql.update("INSERT INTO hozex_bans (ID, Reason, Time, Date, Moderator, BanID, Server, Evedence, Unban) VALUES ('" + id + "', '" + reason + "', '" + (System.currentTimeMillis() + time) + "', '" + System.currentTimeMillis() + "', '" + by + "', '" + banid + "', '" + t.getServer().getInfo().getName() + "', '" + eve + "', '-');");
			} else {
			      msgsql.update("INSERT INTO hozex_bans (ID, Reason, Time, Date, Moderator, BanID, Server, Evedence, Unban) VALUES ('" + id + "', '" + reason + "', '" + (System.currentTimeMillis() + time) + "', '" + System.currentTimeMillis() + "', '" + by + "', '" + banid + "', '" + "-" + "', '" + eve + "', '-');");
			}	
		}
	}
	
	public static void unbanPlayer(String id, String pname) {
		if (isBanned(id)) {
			  msgsql.update("UPDATE hozex_bans SET Unban='" + pname + "' WHERE Date='" + getDates(id, 1).get(0) + "'");
		}
	}
	
	public static void removeUnbanPlayer(String id) {
		  msgsql.update("UPDATE hozex_bans SET Unban='-' WHERE Date='" + getDates(id, 1).get(0) + "'");
	}
	
	public static void removeBan(String id, long date) {
		msgsql.update("DELETE FROM hozex_bans WHERE Date='" + date + "'");
	}
	
	  public static ArrayList<String> getReasons(String id, int limit) {
		    ArrayList<String> reason = new ArrayList();
		    ResultSet Result;
		    if (limit == -1) {
			    Result = msgsql.getResult("SELECT * FROM hozex_bans WHERE ID='" + id + "' ORDER BY Date desc LIMIT 100");	
		    } else {
			    Result = msgsql.getResult("SELECT * FROM hozex_bans WHERE ID='" + id + "' ORDER BY Date desc LIMIT " + limit);
		    }
		    try {
		      while (Result.next()) {
		        reason.add(Result.getString("Reason"));
		      }
		    } catch (SQLException localSQLException) {}
		    return reason;
	}
	  
	  public static ArrayList<String> getTime(String id, int limit) {
		    ArrayList<String> time = new ArrayList();
		    ResultSet Result;
		    if (limit == -1) {
			    Result = msgsql.getResult("SELECT * FROM hozex_bans WHERE ID='" + id + "' ORDER BY Date desc LIMIT 100");	
		    } else {
			    Result = msgsql.getResult("SELECT * FROM hozex_bans WHERE ID='" + id + "' ORDER BY Date desc LIMIT " + limit);
		    }
		    try {
		      while (Result.next()) {
		        time.add(Result.getString("Time"));
		      }
		    } catch (SQLException localSQLException) {}
		    return time;
	}
	  
	  public static ArrayList<String> getModerators(String id, int limit) {
		    ArrayList<String> time = new ArrayList();
		    ResultSet Result;
		    if (limit == -1) {
			    Result = msgsql.getResult("SELECT * FROM hozex_bans WHERE ID='" + id + "' ORDER BY Date desc LIMIT 100");	
		    } else {
			    Result = msgsql.getResult("SELECT * FROM hozex_bans WHERE ID='" + id + "' ORDER BY Date desc LIMIT " + limit);
		    }
		    try {
		      while (Result.next()) {
		        time.add(Result.getString("Moderator"));
		      }
		    } catch (SQLException localSQLException) {}
		    return time;
	}
	  
	  public static ArrayList<String> getUnban(String id, int limit) {
		    ArrayList<String> time = new ArrayList();
		    ResultSet Result;
		    if (limit == -1) {
			    Result = msgsql.getResult("SELECT * FROM hozex_bans WHERE ID='" + id + "' ORDER BY Date desc LIMIT 100");	
		    } else {
			    Result = msgsql.getResult("SELECT * FROM hozex_bans WHERE ID='" + id + "' ORDER BY Date desc LIMIT " + limit);
		    }
		    try {
		      while (Result.next()) {
		        time.add(Result.getString("Unban"));
		      }
		    } catch (SQLException localSQLException) {}
		    return time;
	}
	  
	  public static ArrayList<String> getBanIDs(String id, int limit) {
		    ArrayList<String> time = new ArrayList();
		    ResultSet Result;
		    if (limit == -1) {
			    Result = msgsql.getResult("SELECT * FROM hozex_bans WHERE ID='" + id + "' ORDER BY Date desc LIMIT 100");	
		    } else {
			    Result = msgsql.getResult("SELECT * FROM hozex_bans WHERE ID='" + id + "' ORDER BY Date desc LIMIT " + limit);
		    }
		    try {
		      while (Result.next()) {
		        time.add(Result.getString("BanID"));
		      }
		    } catch (SQLException localSQLException) {}
		    return time;
	}
	  
	  public static ArrayList<String> getServers(String id, int limit) {
		    ArrayList<String> time = new ArrayList();
		    ResultSet Result;
		    if (limit == -1) {
			    Result = msgsql.getResult("SELECT * FROM hozex_bans WHERE ID='" + id + "' ORDER BY Date desc LIMIT 100");	
		    } else {
			    Result = msgsql.getResult("SELECT * FROM hozex_bans WHERE ID='" + id + "' ORDER BY Date desc LIMIT " + limit);
		    }
		    try {
		      while (Result.next()) {
		        time.add(Result.getString("Server"));
		      }
		    } catch (SQLException localSQLException) {}
		    return time;
	}
	
	  public static ArrayList<String> getDates(String id, int limit) {
		    ArrayList<String> date = new ArrayList();
		    ResultSet Result;
		    if (limit == -1) {
			    Result = msgsql.getResult("SELECT * FROM hozex_bans WHERE ID='" + id + "' ORDER BY Date desc LIMIT 100");	
		    } else {
			    Result = msgsql.getResult("SELECT * FROM hozex_bans WHERE ID='" + id + "' ORDER BY Date desc LIMIT " + limit);
		    }
		    try {
		      while (Result.next()) {
		        date.add(Result.getString("Date"));
		      }
		    } catch (SQLException localSQLException) {}
		    return date;
	}
	  
	  public static ArrayList<String> getEvedences(String id, int limit) {
		    ArrayList<String> evedence = new ArrayList();
		    ResultSet Result;
		    if (limit == -1) {
			    Result = msgsql.getResult("SELECT * FROM hozex_bans WHERE ID='" + id + "' ORDER BY Date desc LIMIT 100");	
		    } else {
			    Result = msgsql.getResult("SELECT * FROM hozex_bans WHERE ID='" + id + "' ORDER BY Date desc LIMIT " + limit);
		    }
		    try {
		      while (Result.next()) {
		        evedence.add(Result.getString("Evedence"));
		      }
		    } catch (SQLException localSQLException) {}
		    return evedence;
	}
	  
	  public static void changeLastBan(String id, String reason, long time) {
		  if (isBanned(id)) {
			  long oldtime = Long.valueOf(getTime(id, 1).get(0));
			  if (reason != null) {
				  msgsql.update("UPDATE hozex_bans SET Reason='" + reason + "' WHERE Time='" + oldtime + "'");
			  }
			  if (time != -1) {
				  msgsql.update("UPDATE hozex_bans SET Time='" + (System.currentTimeMillis() + time) + "' WHERE Time='" + oldtime + "'");  
			  }
		  }
	  }
	  public static boolean isBanned(String id) {
		  if (isListed(id)) {
			  if (!getUnban(id, 1).get(0).equals("-")) return false;
			  if (Long.valueOf(getTime(id, 1).get(0)) >= System.currentTimeMillis()) {
				  return true;
			  } else {
				  return false;
			  }
		  } else {
			  return false;
		  }
	  }
	  
	  public static boolean isListed(String id) {
		    ResultSet Result = msgsql.getResult("SELECT * FROM hozex_bans WHERE ID='" + id + "'");
		    try {
		      if (Result.next()) {
		        return true;
		      }
		    }
		    catch (SQLException localSQLException) {}
		    return false;
	}
	  
	  public static int countBans(String id) {
		  if (isListed(id)) {
			  return getReasons(id, 100).size();
		  } else {
			  return 0;
		  }
	  }
}
