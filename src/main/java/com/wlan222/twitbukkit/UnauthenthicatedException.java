package com.wlan222.twitbukkit;

public class UnauthenthicatedException extends Exception
{
      /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//Parameterless Constructor
      public UnauthenthicatedException() {}

      //Constructor that accepts a message
      public UnauthenthicatedException(String message)
      {
         super(message);
      }
 }