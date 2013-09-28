package com.wlan222.twitbukkit;

import java.util.ArrayList;

public interface SocialNetwork {

	public boolean auth();

	public boolean checkAuth();
	
	public void init();

	public boolean isAuthenthicated();

	public void post(SocialStatus s) throws UnauthenthicatedException;

	public ArrayList<SocialStatus> getNews() throws UnauthenthicatedException;
	
	public ArrayList<SocialStatus> getNews(String user) throws UnauthenthicatedException;

}
