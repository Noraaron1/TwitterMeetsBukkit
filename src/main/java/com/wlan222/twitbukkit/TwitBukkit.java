package com.wlan222.twitbukkit;

import java.util.ArrayList;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import com.wlan222.twitbukkit.socialnetworks.SocialTwitter;
import com.wlan222.twitbukkit.socialnetworks.SocialUnauthTwitter;

public class TwitBukkit extends JavaPlugin implements Listener {

	public static String consumer_key = "";

	public static String consumer_secret = "";

	public static String access_token = "";

	public static String access_secret = "";

	public void onEnable() {
		SocialUnauthTwitter sut = new SocialUnauthTwitter();
		sut.auth();
		sut.init();
		SocialTwitter st = new SocialTwitter();
		st.auth();
		st.init();
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {

		if (cmd.getName().equalsIgnoreCase("get")) {
			if (args.length == 1) {
				new TwitterThread(args[0], sender).run();
			}
		}
		return true;

	}
}

class TwitterThread extends Thread {

	private String twitterUser;
	private CommandSender sender;

	public TwitterThread(String twitterUser, CommandSender sender) {
		this.twitterUser = twitterUser;
		this.sender = sender;
	}

	@Override
	public void run() {
		SocialUnauthTwitter sut = new SocialUnauthTwitter();
		sut.auth();
		ArrayList<SocialStatus> statuses = null;
		try {
			statuses = sut.getNews(twitterUser);
		} catch (UnauthenthicatedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (statuses != null) {
			for (SocialStatus s : statuses) {
				sender.sendMessage("[" + s.getOrigin() + "] [" + s.getAuthor()
						+ "] " + s.getMessage());
			}
		} else {
			sender.sendMessage("Couldn't get tweets");
		}
	}

}
