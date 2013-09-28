package com.wlan222.twitbukkit.socialnetworks;

import java.util.ArrayList;

import twitter4j.DirectMessage;
import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;
import twitter4j.User;
import twitter4j.UserList;
import twitter4j.UserStreamListener;
import twitter4j.auth.AccessToken;

import com.wlan222.twitbukkit.SocialNetwork;
import com.wlan222.twitbukkit.SocialStatus;
import com.wlan222.twitbukkit.TwitBukkit;
import com.wlan222.twitbukkit.UnauthenthicatedException;

public class SocialTwitter implements SocialNetwork {

	private boolean authenthicated = false;
	private TwitterStream twitter;
	private Twitter cTwitter;

	@Override
	public boolean auth() {
		this.twitter = new TwitterStreamFactory().getInstance();
		twitter.setOAuthConsumer(TwitBukkit.consumer_key,
				TwitBukkit.consumer_secret);
		twitter.setOAuthAccessToken(new AccessToken(TwitBukkit.access_token,
				TwitBukkit.access_secret));

		this.cTwitter = new TwitterFactory().getInstance();
		cTwitter.setOAuthConsumer(TwitBukkit.consumer_key,
				TwitBukkit.consumer_secret);
		cTwitter.setOAuthAccessToken(new AccessToken(TwitBukkit.access_token,
				TwitBukkit.access_secret));
		return true;
	}

	@Override
	public boolean checkAuth() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void post(SocialStatus s) {
		// TODO Auto-generated method stub

	}

	@Override
	public ArrayList<SocialStatus> getNews() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAuthenthicated() {
		return authenthicated;
	}

	@Override
	public void init() {
		UserStreamListener listener = new UserStreamListener() {
			public void onStatus(Status status) {

				System.out.println(status.getUser().getName() + " : "
						+ status.getText());

			}

			public void onDeletionNotice(
					StatusDeletionNotice statusDeletionNotice) {
			}

			public void onTrackLimitationNotice(int numberOfLimitedStatuses) {
			}

			public void onException(Exception ex) {
				ex.printStackTrace();
			}

			@Override
			public void onScrubGeo(long arg0, long arg1) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onStallWarning(StallWarning arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onBlock(User arg0, User arg1) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onDeletionNotice(long arg0, long arg1) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onDirectMessage(DirectMessage arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onFavorite(User arg0, User arg1, Status arg2) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onFollow(User arg0, User arg1) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onFriendList(long[] arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onUnblock(User arg0, User arg1) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onUnfavorite(User arg0, User arg1, Status arg2) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onUserListCreation(User arg0, UserList arg1) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onUserListDeletion(User arg0, UserList arg1) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onUserListMemberAddition(User arg0, User arg1,
					UserList arg2) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onUserListMemberDeletion(User arg0, User arg1,
					UserList arg2) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onUserListSubscription(User arg0, User arg1,
					UserList arg2) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onUserListUnsubscription(User arg0, User arg1,
					UserList arg2) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onUserListUpdate(User arg0, UserList arg1) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onUserProfileUpdate(User arg0) {
				// TODO Auto-generated method stub
				
			}
		};
		twitter.addListener(listener);
		twitter.user();
	}

	@Override
	public ArrayList<SocialStatus> getNews(String user)
			throws UnauthenthicatedException {
		// TODO Auto-generated method stub
		return null;
	}

}
