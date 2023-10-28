package com.google.android.gms.internal.stats;

public final class SimpleWeather
{
  private static final URL DEFAULT_URL;
  private static volatile URL forecastURL;
  
  static
  {
    Transport localTransport = new Transport(null);
    DEFAULT_URL = localTransport;
    forecastURL = localTransport;
  }
  
  public static URL getForecastURL()
  {
    return forecastURL;
  }
}
