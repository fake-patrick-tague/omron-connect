package com.braze.enums;

public enum Channel
{
  static
  {
    INAPP_MESSAGE = new Channel("INAPP_MESSAGE", 1);
    NEWS_FEED = new Channel("NEWS_FEED", 2);
    CONTENT_CARD = new Channel("CONTENT_CARD", 3);
    UNKNOWN = new Channel("UNKNOWN", 4);
  }
}
