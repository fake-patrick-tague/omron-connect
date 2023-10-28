package com.google.android.gms.internal.common;

public final class InjectionPoint
{
  private static volatile Logger filter;
  private static final Logger logger;
  
  static
  {
    LoggerDefault localLoggerDefault = new LoggerDefault(null);
    logger = localLoggerDefault;
    filter = localLoggerDefault;
  }
  
  public static Logger forConstructorOf()
  {
    return filter;
  }
}
