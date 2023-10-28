package androidx.media;

import android.media.session.MediaSessionManager.RemoteUserInfo;
import v7.v7.util.Context;

final class GOST3410Parameters
  implements CipherParameters
{
  final MediaSessionManager.RemoteUserInfo q;
  
  GOST3410Parameters(MediaSessionManager.RemoteUserInfo paramRemoteUserInfo)
  {
    q = paramRemoteUserInfo;
  }
  
  GOST3410Parameters(String paramString, int paramInt1, int paramInt2)
  {
    q = new MediaSessionManager.RemoteUserInfo(paramString, paramInt1, paramInt2);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof GOST3410Parameters)) {
      return false;
    }
    paramObject = (GOST3410Parameters)paramObject;
    return q.equals(q);
  }
  
  public int hashCode()
  {
    return Context.getType(new Object[] { q });
  }
}
