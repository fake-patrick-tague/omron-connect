package androidx.media;

import android.media.session.MediaSessionManager.RemoteUserInfo;
import android.os.Build.VERSION;

public final class Monitor
{
  CipherParameters parameters;
  
  public Monitor(MediaSessionManager.RemoteUserInfo paramRemoteUserInfo)
  {
    parameters = new GOST3410Parameters(paramRemoteUserInfo);
  }
  
  public Monitor(String paramString, int paramInt1, int paramInt2)
  {
    if (Build.VERSION.SDK_INT >= 28)
    {
      parameters = new GOST3410Parameters(paramString, paramInt1, paramInt2);
      return;
    }
    parameters = new ElGamalParameters(paramString, paramInt1, paramInt2);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof Monitor)) {
      return false;
    }
    return parameters.equals(parameters);
  }
  
  public int hashCode()
  {
    return parameters.hashCode();
  }
}
