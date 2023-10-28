package com.alivecor.kardia_ai;

public class Tester
{
  private long nativeHandle = 0L;
  
  public Tester()
  {
    init();
  }
  
  private native void dispose();
  
  private native void init();
  
  protected void finalize()
  {
    dispose();
  }
  
  public native String testEnhancedOfflineFilter(String paramString1, String paramString2, int paramInt1, int paramInt2);
  
  public native String testEnhancedStreamingFilter(String paramString1, String paramString2, int paramInt1, int paramInt2);
  
  public native String testFile(String paramString1, String paramString2);
  
  public native String testNotchOfflineFilter(String paramString1, String paramString2, int paramInt1, int paramInt2);
  
  public native String testNotchStreamingFilter(String paramString1, String paramString2, int paramInt1, int paramInt2);
  
  public native String testStandardOfflineFilter(String paramString1, String paramString2, int paramInt1, int paramInt2);
  
  public native String testStandardStreamingFilter(String paramString1, String paramString2, int paramInt1, int paramInt2);
}
