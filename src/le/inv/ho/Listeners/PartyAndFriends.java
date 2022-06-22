package le.inv.ho.Listeners;

import le.inv.ho.Arabic;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;	

public class PartyAndFriends implements Listener {
	
	@EventHandler
	public void onFriendSendMessage(de.simonsator.partyandfriends.api.events.message.FriendOnlineMessageEvent e) {
		e.setMessage(Arabic.changeArabic(e.getMessage()));
	}
	
	@EventHandler
	public void onFriendMessage(de.simonsator.partyandfriends.api.events.message.FriendMessageEvent e) {
		e.setMessage(Arabic.changeArabic(e.getMessage()));
	}
	@EventHandler
	public void onFriendSimpleMessage(de.simonsator.partyandfriends.api.events.message.SimpleMessageEvent e) {
		e.setMessage(Arabic.changeArabic(e.getMessage()));
	}
	
	@EventHandler
	public void onFriendSimpleMessage(de.simonsator.partyandfriends.api.events.message.PartyMessageEvent e) {
		e.setMessage(Arabic.changeArabic(e.getMessage()));
	}
}
