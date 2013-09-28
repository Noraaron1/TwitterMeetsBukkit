package com.wlan222.twitbukkit.socialnetworks;

import java.util.ArrayList;

import org.bukkit.Bukkit;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

import com.wlan222.twitbukkit.SocialNetwork;
import com.wlan222.twitbukkit.SocialStatus;
import com.wlan222.twitbukkit.TwitBukkit;
import com.wlan222.twitbukkit.UnauthenthicatedException;

public class SocialUnauthTwitter implements SocialNetwork {

	private Twitter twitter;
	private boolean authenthicated = false;

	@Override
	public boolean auth() {
		ConfigurationBuilder cb = new ConfigurationBuilder();
		cb.setUseSSL(true);
		cb.setApplicationOnlyAuthEnabled(true);

		this.twitter = new TwitterFactory(cb.build()).getInstance();

		twitter.setOAuthConsumer(TwitBukkit.consumer_key,
				TwitBukkit.consumer_secret);
		authenthicated = true;
		try {
			twitter.getOAuth2Token();
		} catch (TwitterException e) {
			authenthicated = false;
			Bukkit.getLogger().severe("Failed to authenthicate to Twitter");
		}

		return authenthicated;
	}

	@Override
	public boolean checkAuth() {
		return authenthicated;
	}

	@Override
	public boolean isAuthenthicated() {
		return authenthicated;
	}

	@Override
	public void post(SocialStatus s) throws UnauthenthicatedException {
		throw new UnauthenthicatedException(
				"Tried to post while using Application-Only Authenthication");
	}

	@Override
	public ArrayList<SocialStatus> getNews() throws UnauthenthicatedException {
		throw new UnauthenthicatedException(
				"Tried to get user tweets while using Application-Only Authenthication");
	}

	@Override
	public void init() {

	}

	@Override
	public ArrayList<SocialStatus> getNews(String user)
			throws UnauthenthicatedException {
		ArrayList<SocialStatus> statuses = new ArrayList<SocialStatus>();
		try {
			for (Status s : twitter.getUserTimeline(user)) {
				statuses.add(new SocialStatus(s.getUser().getScreenName(), s
						.getText(), "Twitter"));
			}
		} catch (TwitterException e) {
			return null;
		}
		if (!statuses.isEmpty()) {
			return statuses;
		}
		return null;
	}
}
