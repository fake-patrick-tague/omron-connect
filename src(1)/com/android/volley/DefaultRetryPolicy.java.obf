package com.android.volley;

public class DefaultRetryPolicy
  implements RetryPolicy
{
  public static final float DEFAULT_BACKOFF_MULT = 1.0F;
  public static final int DEFAULT_MAX_RETRIES = 1;
  public static final int DEFAULT_TIMEOUT_MS = 2500;
  private final float mBackoffMultiplier;
  private int mCurrentRetryCount;
  private int mCurrentTimeoutMs;
  private final int mMaxNumRetries;
  
  public DefaultRetryPolicy()
  {
    this(2500, 1, 1.0F);
  }
  
  public DefaultRetryPolicy(int paramInt1, int paramInt2, float paramFloat)
  {
    mCurrentTimeoutMs = paramInt1;
    mMaxNumRetries = paramInt2;
    mBackoffMultiplier = paramFloat;
  }
  
  public float getBackoffMultiplier()
  {
    return mBackoffMultiplier;
  }
  
  public int getCurrentRetryCount()
  {
    return mCurrentRetryCount;
  }
  
  public int getCurrentTimeout()
  {
    return mCurrentTimeoutMs;
  }
  
  protected boolean hasAttemptRemaining()
  {
    return mCurrentRetryCount <= mMaxNumRetries;
  }
  
  public void retry(VolleyError paramVolleyError)
    throws VolleyError
  {
    mCurrentRetryCount += 1;
    int i = mCurrentTimeoutMs;
    mCurrentTimeoutMs = (i + (int)(i * mBackoffMultiplier));
    if (hasAttemptRemaining()) {
      return;
    }
    throw paramVolleyError;
  }
}
