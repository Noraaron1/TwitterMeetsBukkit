package com.wlan222.twitbukkit;

import java.util.List;

import org.bukkit.plugin.java.JavaPlugin;

import twitter4j.Paging;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

public class TwitBukkit extends JavaPlugin {

	public void onEnable() {
		try {
			for (Status s : getTweets("google", 1, 10)) {
				getLogger().info(
						"[" + s.getUser().getName() + "] " + s.getText());
			}
		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public List<Status> getTweets(String username, Paging p)
			throws TwitterException {
		Twitter twitter = TwitterFactory.getSingleton();
		Paging paging = new Paging(1, 100);
		List<Status> statuses;

		statuses = twitter.getUserTimeline(username, paging);

		return statuses;
	}

	//username = The User whose Tweets we want
	//start = use 1 if unclear
	//stop = use how many tweets to get
	public List<Status> getTweets(String username, int start, int stop)
			throws TwitterException {
		return getTweets(username, new Paging(start, stop));
	}

	public List<Status> getTweets(String username) throws TwitterException {
		return getTweets(username, 1, 100);
	}

}
