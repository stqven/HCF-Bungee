package le.inv.ho.Commands;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import le.inv.ho.msgsql;
import net.md_5.bungee.BungeeCord;
import net.md_5.bungee.api.connection.ProxiedPlayer;

public class MutesAPI {
	
	public static void mutePlayer(String id, String reason, long time, String by, String muteid, String eve) {
		if (isMuted(id)) {
			changeLastMute(id, reason, time);
		} else {
			ProxiedPlayer t = BungeeCord.getInstance().getPlayer(msgsql.getIDPlayer(id));
			if (t != null) {
			      msgsql.update("INSERT INTO hozex_mutes (ID, Reason, Time, Date, Moderator, MuteID, Server, Evedence, Unmute) VALUES ('" + id + "', '" + reason + "', '" + (System.currentTimeMillis() + time) + "', '" + System.currentTimeMillis() + "', '" + by + "', '" + muteid + "', '" + t.getServer().getInfo().getName() + "', '" + eve + "', '-');");
			} else {
			      msgsql.update("INSERT INTO hozex_mutes (ID, Reason, Time, Date, Moderator, MuteID, Server, Evedence, Unmute) VALUES ('" + id + "', '" + reason + "', '" + (System.currentTimeMillis() + time) + "', '" + System.currentTimeMillis() + "', '" + by + "', '" + muteid + "', '" + "-" + "', '" + eve + "', '-');");
			}	
		}
	}
	
	public static void unmutePlayer(String id, String pname) {
		if (isMuted(id)) {
			  msgsql.update("UPDATE hozex_mutes SET Unmute='" + pname + "' WHERE Date='" + getDates(id, 1).get(0) + "'");
		}
	}
	
	public static void removeUnmutePlayer(String id) {
		  msgsql.update("UPDATE hozex_mutes SET Unmute='-' WHERE Date='" + getDates(id, 1).get(0) + "'");
	}
	
	public static void removeMute(String id, long date) {
		msgsql.update("DELETE FROM hozex_mutes WHERE Date='" + date + "'");
	}
	
	  public static ArrayList<String> getReasons(String id, int limit) {
		    ArrayList<String> reason = new ArrayList();
		    ResultSet Result;
		    if (limit == -1) {
			    Result = msgsql.getResult("SELECT * FROM hozex_mutes WHERE ID='" + id + "' ORDER BY Date desc LIMIT 100");	
		    } else {
			    Result = msgsql.getResult("SELECT * FROM hozex_mutes WHERE ID='" + id + "' ORDER BY Date desc LIMIT " + limit);
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
			    Result = msgsql.getResult("SELECT * FROM hozex_mutes WHERE ID='" + id + "' ORDER BY Date desc LIMIT 100");	
		    } else {
			    Result = msgsql.getResult("SELECT * FROM hozex_mutes WHERE ID='" + id + "' ORDER BY Date desc LIMIT " + limit);
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
			    Result = msgsql.getResult("SELECT * FROM hozex_mutes WHERE ID='" + id + "' ORDER BY Date desc LIMIT 100");	
		    } else {
			    Result = msgsql.getResult("SELECT * FROM hozex_mutes WHERE ID='" + id + "' ORDER BY Date desc LIMIT " + limit);
		    }
		    try {
		      while (Result.next()) {
		        time.add(Result.getString("Moderator"));
		      }
		    } catch (SQLException localSQLException) {}
		    return time;
	}
	  
	  public static ArrayList<String> getUnmute(String id, int limit) {
		    ArrayList<String> time = new ArrayList();
		    ResultSet Result;
		    if (limit == -1) {
			    Result = msgsql.getResult("SELECT * FROM hozex_mutes WHERE ID='" + id + "' ORDER BY Date desc LIMIT 100");	
		    } else {
			    Result = msgsql.getResult("SELECT * FROM hozex_mutes WHERE ID='" + id + "' ORDER BY Date desc LIMIT " + limit);
		    }
		    try {
		      while (Result.next()) {
		        time.add(Result.getString("Unmute"));
		      }
		    } catch (SQLException localSQLException) {}
		    return time;
	}
	  
	  public static ArrayList<String> getMuteIDs(String id, int limit) {
		    ArrayList<String> time = new ArrayList();
		    ResultSet Result;
		    if (limit == -1) {
			    Result = msgsql.getResult("SELECT * FROM hozex_mutes WHERE ID='" + id + "' ORDER BY Date desc LIMIT 100");	
		    } else {
			    Result = msgsql.getResult("SELECT * FROM hozex_mutes WHERE ID='" + id + "' ORDER BY Date desc LIMIT " + limit);
		    }
		    try {
		      while (Result.next()) {
		        time.add(Result.getString("MuteID"));
		      }
		    } catch (SQLException localSQLException) {}
		    return time;
	}
	  
	  public static ArrayList<String> getServers(String id, int limit) {
		    ArrayList<String> time = new ArrayList();
		    ResultSet Result;
		    if (limit == -1) {
			    Result = msgsql.getResult("SELECT * FROM hozex_mutes WHERE ID='" + id + "' ORDER BY Date desc LIMIT 100");	
		    } else {
			    Result = msgsql.getResult("SELECT * FROM hozex_mutes WHERE ID='" + id + "' ORDER BY Date desc LIMIT " + limit);
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
			    Result = msgsql.getResult("SELECT * FROM hozex_mutes WHERE ID='" + id + "' ORDER BY Date desc LIMIT 100");	
		    } else {
			    Result = msgsql.getResult("SELECT * FROM hozex_mutes WHERE ID='" + id + "' ORDER BY Date desc LIMIT " + limit);
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
			    Result = msgsql.getResult("SELECT * FROM hozex_mutes WHERE ID='" + id + "' ORDER BY Date desc LIMIT 100");	
		    } else {
			    Result = msgsql.getResult("SELECT * FROM hozex_mutes WHERE ID='" + id + "' ORDER BY Date desc LIMIT " + limit);
		    }
		    try {
		      while (Result.next()) {
		        evedence.add(Result.getString("Evedence"));
		      }
		    } catch (SQLException localSQLException) {}
		    return evedence;
	}
	  
	  public static void changeLastMute(String id, String reason, long time) {
		  if (isMuted(id)) {
			  long oldtime = Long.valueOf(getTime(id, 1).get(0));
			  if (reason != null) {
				  msgsql.update("UPDATE hozex_mutes SET Reason='" + reason + "' WHERE Time='" + oldtime + "'");
			  }
			  if (time != -1) {
				  msgsql.update("UPDATE hozex_mutes SET Time='" + (System.currentTimeMillis() + time) + "' WHERE Time='" + oldtime + "'");  
			  }
		  }
	  }
	  public static boolean isMuted(String id) {
		  if (isListed(id)) {
			  if (!getUnmute(id, 1).get(0).equals("-")) return false;
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
		    ResultSet Result = msgsql.getResult("SELECT * FROM hozex_mutes WHERE ID='" + id + "'");
		    try {
		      if (Result.next()) {
		        return true;
		      }
		    }
		    catch (SQLException localSQLException) {}
		    return false;
	}
	  
	  public static int countMutes(String id) {
		  if (isListed(id)) {
			  return getReasons(id, 100).size();
		  } else {
			  return 0;
		  }
	  }
}
