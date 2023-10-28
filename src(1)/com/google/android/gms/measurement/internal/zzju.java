package com.google.android.gms.measurement.internal;

import android.util.Pair;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.drm.identifier.AdvertisingIdClient;
import com.google.android.gms.drm.identifier.AdvertisingIdClient.Info;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public final class zzju
  extends zzkn
{
  public final zzez buf;
  public final zzez context;
  private final Map delegate = new HashMap();
  public final zzez ids;
  public final zzez this$0;
  public final zzez uri;
  
  zzju(zzkz paramZzkz)
  {
    super(paramZzkz);
    paramZzkz = this$0.put();
    paramZzkz.getClass();
    this$0 = new zzez(paramZzkz, "last_delete_stale", 0L);
    paramZzkz = this$0.put();
    paramZzkz.getClass();
    ids = new zzez(paramZzkz, "backoff", 0L);
    paramZzkz = this$0.put();
    paramZzkz.getClass();
    context = new zzez(paramZzkz, "last_upload", 0L);
    paramZzkz = this$0.put();
    paramZzkz.getClass();
    uri = new zzez(paramZzkz, "last_upload_attempt", 0L);
    paramZzkz = this$0.put();
    paramZzkz.getClass();
    buf = new zzez(paramZzkz, "midnight_offset", 0L);
  }
  
  final Pair add(String paramString)
  {
    append();
    long l = this$0.zzav().elapsedRealtime();
    Object localObject = (zzjt)delegate.get(paramString);
    if ((localObject != null) && (l < value)) {
      return new Pair(type, Boolean.valueOf(text));
    }
    AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(true);
    l += this$0.append().put(paramString, zzeb.notes);
    localObject = this$0;
    zzjt localZzjt;
    try
    {
      localObject = AdvertisingIdClient.getAdvertisingIdInfo(((zzfy)localObject).zzau());
      if (localObject == null)
      {
        localObject = Boolean.FALSE;
        localObject = new Pair("", localObject);
        return localObject;
      }
      String str = ((AdvertisingIdClient.Info)localObject).getId();
      if (str != null) {
        localObject = new zzjt(str, ((AdvertisingIdClient.Info)localObject).isLimitAdTrackingEnabled(), l);
      } else {
        localObject = new zzjt("", ((AdvertisingIdClient.Info)localObject).isLimitAdTrackingEnabled(), l);
      }
    }
    catch (Exception localException)
    {
      this$0.zzay().e().append("Unable to get advertising id", localException);
      localZzjt = new zzjt("", false, l);
    }
    delegate.put(paramString, localZzjt);
    AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(false);
    return new Pair(type, Boolean.valueOf(text));
  }
  
  final Pair add(String paramString, zzai paramZzai)
  {
    if (paramZzai.get(zzah.count)) {
      return add(paramString);
    }
    return new Pair("", Boolean.FALSE);
  }
  
  protected final boolean registerAlarm()
  {
    return false;
  }
  
  final String toString(String paramString, boolean paramBoolean)
  {
    append();
    if (paramBoolean) {
      paramString = (String)addfirst;
    } else {
      paramString = "00000000-0000-0000-0000-000000000000";
    }
    MessageDigest localMessageDigest = zzlh.getInstance();
    if (localMessageDigest == null) {
      return null;
    }
    return String.format(Locale.US, "%032X", new Object[] { new BigInteger(1, localMessageDigest.digest(paramString.getBytes())) });
  }
}
