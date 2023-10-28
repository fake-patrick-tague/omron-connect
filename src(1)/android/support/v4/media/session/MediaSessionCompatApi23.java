package android.support.v4.media.session;

import android.net.Uri;
import android.os.Bundle;

class MediaSessionCompatApi23
{
  private MediaSessionCompatApi23() {}
  
  public static Object createCallback(Callback paramCallback)
  {
    return new CallbackProxy(paramCallback);
  }
  
  public static abstract interface Callback
    extends MediaSessionCompatApi21.Callback
  {
    public abstract void onPlayFromUri(Uri paramUri, Bundle paramBundle);
  }
  
  static class CallbackProxy<T extends MediaSessionCompatApi23.Callback>
    extends MediaSessionCompatApi21.CallbackProxy<T>
  {
    public CallbackProxy(MediaSessionCompatApi23.Callback paramCallback)
    {
      super();
    }
    
    public void onPlayFromUri(Uri paramUri, Bundle paramBundle)
    {
      MediaSessionCompat.ensureClassLoader(paramBundle);
      ((MediaSessionCompatApi23.Callback)mCallback).onPlayFromUri(paramUri, paramBundle);
    }
  }
}
