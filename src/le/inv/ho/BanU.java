package le.inv.ho;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Listener;

public class BanU implements Listener {
	
	public static void banPlayer(String id, String reason, long time, String by, String banid, String eve) {
		if (isBanned(id)) {
			changeLastBan(id, reason, time);
		} else {
			Long current = System.currentTimeMillis();
			long total = Long.valueOf(current) + Long.valueOf(time);
			if (BungeeCord.getInstance().getPlayer(msgsql.getIDPlayer(id)) != null) {
			      msgsql.update("INSERT INTO hozex_bans (ID, Reason, Time, Date, Moderator, BanID, Server, Evedence, Unban) VALUES ('" + id + "', '" + reason + "', '" + total + "', '" + current + "', '" + by + "', '" + banid + "', '" + BungeeCord.getInstance().getPlayer(msgsql.getIDPlayer(id)).getServer().getInfo().getName() + "', '" + eve + "', '-');");
			} else {
			      msgsql.update("INSERT INTO hozex_bans (ID, Reason, Time, Date, Moderator, BanID, Server, Evedence, Unban) VALUES ('" + id + "', '" + reason + "', '" + total + "', '" + current + "', '" + by + "', '" + banid + "', '" + "-" + "', '" + eve + "', '-');");
			}
			ProxiedPlayer t = BungeeCord.getInstance().getPlayer(msgsql.getIDPlayer(id));
			if (t == null) return;
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
			if (time1.equals("")) {
				if (min > 0) {
					if (min > 1) {
						time1.append(min + " minutes ");
					} else {
						time1.append(min + " minute ");
					}
				}
			}
			if (time1.toString().equals("")) {
				if (sec > 1) {
					time1.append(sec + " seconds ");
				} else {
					time1.append(sec + " second ");
				}
			}
  			t.disconnect("§3HozexMC\n\nTemporarly Banned\n\n\n§bYou were banned from §eHozexMC §bNetwork\n§bfor the reason §c" + reason + "\n§bYou will be unbanned in §c" + time1 + "\n§bBanID: §f#" + banid + "\n§7If you think this has happened by mistake appeal at:\n§ahttps://discord.gg/yXBxY4v\n\n§bStore § §cHozexMC.Net §7[Maintenance]");
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
			  if (Long.valueOf(getTime(id, 1).get(0)) > System.currentTimeMillis()) {
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
			  int bans = 0;
			    ResultSet Result;
			    Result = msgsql.getResult("SELECT * FROM hozex_bans WHERE ID='" + id + "' ORDER BY Date desc LIMIT 100");	
			    try {
			      while (Result.next()) {
			    	  bans++;
			      }
			    } catch (SQLException localSQLException) {}
			    return bans;
		  } else {
			  return 0;
		  }
	  }
}
