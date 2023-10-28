package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ComponentInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.BaseBundle;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.CollectionUtils;
import com.google.android.gms.common.wrappers.PackageManagerWrapper;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzcf;
import java.io.ByteArrayInputStream;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicLong;
import javax.security.auth.x500.X500Principal;

public final class zzlh
  extends zzgs
{
  private static final String[] buttons = { "_err" };
  private static final String[] value = { "firebase_", "google_", "ga_" };
  private Integer a = null;
  private final AtomicLong counter = new AtomicLong(0L);
  private int id;
  private SecureRandom iterator;
  
  zzlh(zzfy paramZzfy)
  {
    super(paramZzfy);
  }
  
  public static void add(zzik paramZzik, Bundle paramBundle, boolean paramBoolean)
  {
    boolean bool = paramBoolean;
    if (paramBundle != null)
    {
      bool = paramBoolean;
      if (paramZzik != null) {
        if ((paramBundle.containsKey("_sc")) && (!paramBoolean))
        {
          bool = false;
        }
        else
        {
          String str = a;
          if (str != null) {
            paramBundle.putString("_sn", str);
          } else {
            paramBundle.remove("_sn");
          }
          str = c;
          if (str != null) {
            paramBundle.putString("_sc", str);
          } else {
            paramBundle.remove("_sc");
          }
          paramBundle.putLong("_si", g);
          return;
        }
      }
    }
    if ((paramBundle != null) && (paramZzik == null) && (bool))
    {
      paramBundle.remove("_sn");
      paramBundle.remove("_sc");
      paramBundle.remove("_si");
    }
  }
  
  static MessageDigest getInstance()
  {
    int i = 0;
    while (i < 2)
    {
      try
      {
        MessageDigest localMessageDigest = MessageDigest.getInstance("MD5");
        if (localMessageDigest != null) {
          return localMessageDigest;
        }
      }
      catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
      {
        for (;;) {}
      }
      i += 1;
    }
    return null;
  }
  
  public static ArrayList parse(List paramList)
  {
    if (paramList == null) {
      return new ArrayList(0);
    }
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      Object localObject1 = (zzac)paramList.next();
      Bundle localBundle = new Bundle();
      localBundle.putString("app_id", name);
      localBundle.putString("origin", type);
      localBundle.putLong("creation_timestamp", value);
      localBundle.putString("name", context.type);
      zzgu.put(localBundle, Preconditions.checkNotNull(context.get()));
      localBundle.putBoolean("active", status);
      Object localObject2 = text;
      if (localObject2 != null) {
        localBundle.putString("trigger_event_name", (String)localObject2);
      }
      localObject2 = source;
      if (localObject2 != null)
      {
        localBundle.putString("timed_out_event_name", type);
        localObject2 = this$0;
        if (localObject2 != null) {
          localBundle.putBundle("timed_out_event_params", ((zzau)localObject2).get());
        }
      }
      localBundle.putLong("trigger_timeout", id);
      localObject2 = count;
      if (localObject2 != null)
      {
        localBundle.putString("triggered_event_name", type);
        localObject2 = this$0;
        if (localObject2 != null) {
          localBundle.putBundle("triggered_event_params", ((zzau)localObject2).get());
        }
      }
      localBundle.putLong("triggered_timestamp", context.size);
      localBundle.putLong("time_to_live", size);
      localObject1 = data;
      if (localObject1 != null)
      {
        localBundle.putString("expired_event_name", type);
        localObject1 = this$0;
        if (localObject1 != null) {
          localBundle.putBundle("expired_event_params", ((zzau)localObject1).get());
        }
      }
      localArrayList.add(localBundle);
    }
    return localArrayList;
  }
  
  static long read(byte[] paramArrayOfByte)
  {
    Preconditions.checkNotNull(paramArrayOfByte);
    int i = paramArrayOfByte.length;
    int j = 0;
    boolean bool;
    if (i > 0) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkState(bool);
    i -= 1;
    long l = 0L;
    while ((i >= 0) && (i >= paramArrayOfByte.length - 8))
    {
      l += ((paramArrayOfByte[i] & 0xFF) << j);
      j += 8;
      i -= 1;
    }
    return l;
  }
  
  static boolean zzah(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (paramString.startsWith("_"));
  }
  
  static boolean zzai(String paramString)
  {
    Preconditions.checkNotEmpty(paramString);
    return (paramString.charAt(0) != '_') || (paramString.equals("_ep"));
  }
  
  static boolean zzaj(Context paramContext)
  {
    Preconditions.checkNotNull(paramContext);
    try
    {
      PackageManager localPackageManager = paramContext.getPackageManager();
      if (localPackageManager == null) {
        return false;
      }
      paramContext = localPackageManager.getReceiverInfo(new ComponentName(paramContext, "com.google.android.gms.measurement.AppMeasurementReceiver"), 0);
      if (paramContext != null)
      {
        if (enabled) {
          return true;
        }
      }
      else {
        return false;
      }
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
    return false;
  }
  
  static boolean zzak(Context paramContext, boolean paramBoolean)
  {
    Preconditions.checkNotNull(paramContext);
    if (Build.VERSION.SDK_INT >= 24) {
      return zzat(paramContext, "com.google.android.gms.measurement.AppMeasurementJobService");
    }
    return zzat(paramContext, "com.google.android.gms.measurement.AppMeasurementService");
  }
  
  public static boolean zzal(String paramString)
  {
    return !buttons[0].equals(paramString);
  }
  
  static final boolean zzao(Bundle paramBundle, int paramInt)
  {
    if (paramBundle.getLong("_err") == 0L)
    {
      paramBundle.putLong("_err", paramInt);
      return true;
    }
    return false;
  }
  
  static final boolean zzap(String paramString)
  {
    Preconditions.checkNotNull(paramString);
    return paramString.matches("^(1:\\d+:android:[a-f0-9]+|ca-app-pub-.*)$");
  }
  
  private final int zzaq(String paramString)
  {
    if ("_ldl".equals(paramString))
    {
      this$0.append();
      return 2048;
    }
    if ("_id".equals(paramString))
    {
      this$0.append();
      return 256;
    }
    if ("_lgclid".equals(paramString))
    {
      this$0.append();
      return 100;
    }
    this$0.append();
    return 36;
  }
  
  private final Object zzar(int paramInt, Object paramObject, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramObject == null) {
      return null;
    }
    if (!(paramObject instanceof Long))
    {
      if ((paramObject instanceof Double)) {
        return paramObject;
      }
      if ((paramObject instanceof Integer)) {
        return Long.valueOf(((Integer)paramObject).intValue());
      }
      if ((paramObject instanceof Byte)) {
        return Long.valueOf(((Byte)paramObject).byteValue());
      }
      if ((paramObject instanceof Short)) {
        return Long.valueOf(((Short)paramObject).shortValue());
      }
      if ((paramObject instanceof Boolean))
      {
        long l;
        if (true != ((Boolean)paramObject).booleanValue()) {
          l = 0L;
        } else {
          l = 1L;
        }
        return Long.valueOf(l);
      }
      if ((paramObject instanceof Float)) {
        return Double.valueOf(((Float)paramObject).doubleValue());
      }
      if ((!(paramObject instanceof String)) && (!(paramObject instanceof Character)) && (!(paramObject instanceof CharSequence)))
      {
        if (paramBoolean2)
        {
          if (((paramObject instanceof Bundle[])) || ((paramObject instanceof Parcelable[])))
          {
            ArrayList localArrayList = new ArrayList();
            paramObject = (Parcelable[])paramObject;
            int i = paramObject.length;
            paramInt = 0;
            while (paramInt < i)
            {
              Bundle localBundle = paramObject[paramInt];
              if ((localBundle instanceof Bundle))
              {
                localBundle = apply((Bundle)localBundle);
                if (!localBundle.isEmpty()) {
                  localArrayList.add(localBundle);
                }
              }
              paramInt += 1;
            }
            return localArrayList.toArray(new Bundle[localArrayList.size()]);
          }
        }
        else {
          return null;
        }
      }
      else {
        return getText(paramObject.toString(), paramInt, paramBoolean1);
      }
    }
    else
    {
      return paramObject;
    }
    return null;
  }
  
  private static boolean zzas(String paramString, String[] paramArrayOfString)
  {
    Preconditions.checkNotNull(paramArrayOfString);
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      if (zzlf.put(paramString, paramArrayOfString[i])) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  private static boolean zzat(Context paramContext, String paramString)
  {
    try
    {
      PackageManager localPackageManager = paramContext.getPackageManager();
      if (localPackageManager == null) {
        return false;
      }
      paramContext = localPackageManager.getServiceInfo(new ComponentName(paramContext, paramString), 0);
      if (paramContext != null)
      {
        if (enabled) {
          return true;
        }
      }
      else {
        return false;
      }
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
    return false;
  }
  
  final void add(Bundle paramBundle, int paramInt, String paramString1, String paramString2, Object paramObject)
  {
    if (zzao(paramBundle, paramInt))
    {
      this$0.append();
      paramBundle.putString("_ev", getText(paramString1, 40, true));
      if (paramObject != null)
      {
        Preconditions.checkNotNull(paramBundle);
        if (((paramObject instanceof String)) || ((paramObject instanceof CharSequence))) {
          paramBundle.putLong("_el", paramObject.toString().length());
        }
      }
    }
  }
  
  final void add(Bundle paramBundle, String paramString, Object paramObject)
  {
    if (paramBundle == null) {
      return;
    }
    if ((paramObject instanceof Long))
    {
      paramBundle.putLong(paramString, ((Long)paramObject).longValue());
      return;
    }
    if ((paramObject instanceof String))
    {
      paramBundle.putString(paramString, String.valueOf(paramObject));
      return;
    }
    if ((paramObject instanceof Double))
    {
      paramBundle.putDouble(paramString, ((Double)paramObject).doubleValue());
      return;
    }
    if ((paramObject instanceof Bundle[]))
    {
      paramBundle.putParcelableArray(paramString, (Bundle[])paramObject);
      return;
    }
    if (paramString != null)
    {
      if (paramObject != null) {
        paramBundle = paramObject.getClass().getSimpleName();
      } else {
        paramBundle = null;
      }
      this$0.zzay().isEmpty().append("Not putting event parameter. Invalid value type. name, type", this$0.next().next(paramString), paramBundle);
    }
  }
  
  public final void add(zzcf paramZzcf, byte[] paramArrayOfByte)
  {
    Bundle localBundle = new Bundle();
    localBundle.putByteArray("r", paramArrayOfByte);
    try
    {
      paramZzcf.append(localBundle);
      return;
    }
    catch (RemoteException paramZzcf)
    {
      this$0.zzay().hasNext().append("Error returning byte array to wrapper", paramZzcf);
    }
  }
  
  final void add(zzlg paramZzlg, String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2)
  {
    Bundle localBundle = new Bundle();
    zzao(localBundle, paramInt1);
    if ((!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString3))) {
      localBundle.putString(paramString2, paramString3);
    }
    if ((paramInt1 == 6) || (paramInt1 == 7) || (paramInt1 == 2)) {
      localBundle.putLong("_el", paramInt2);
    }
    paramZzlg.visitLocalVariable(paramString1, "_err", localBundle);
  }
  
  final boolean add(String paramString1, int paramInt, String paramString2)
  {
    if (paramString2 == null)
    {
      this$0.zzay().equals().append("Name is required and can't be null. Type", paramString1);
      return false;
    }
    if (paramString2.codePointCount(0, paramString2.length()) > paramInt)
    {
      this$0.zzay().equals().append("Name is too long. Type, maximum supported length, name", paramString1, Integer.valueOf(paramInt), paramString2);
      return false;
    }
    return true;
  }
  
  final boolean add(String paramString1, String[] paramArrayOfString1, String[] paramArrayOfString2, String paramString2)
  {
    if (paramString2 == null)
    {
      this$0.zzay().equals().append("Name is required and can't be null. Type", paramString1);
      return false;
    }
    Preconditions.checkNotNull(paramString2);
    String[] arrayOfString = value;
    int i = 0;
    while (i < 3)
    {
      if (paramString2.startsWith(arrayOfString[i]))
      {
        this$0.zzay().equals().append("Name starts with reserved prefix. Type, name", paramString1, paramString2);
        return false;
      }
      i += 1;
    }
    if ((paramArrayOfString1 != null) && (zzas(paramString2, paramArrayOfString1)) && ((paramArrayOfString2 == null) || (!zzas(paramString2, paramArrayOfString2))))
    {
      this$0.zzay().equals().append("Name is reserved. Type, name", paramString1, paramString2);
      return false;
    }
    return true;
  }
  
  final Bundle apply(Bundle paramBundle)
  {
    Bundle localBundle = new Bundle();
    if (paramBundle != null)
    {
      Iterator localIterator = paramBundle.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        Object localObject = execute(str, paramBundle.get(str));
        if (localObject == null) {
          this$0.zzay().isEmpty().append("Param value can't be null", this$0.next().next(str));
        } else {
          add(localBundle, str, localObject);
        }
      }
    }
    return localBundle;
  }
  
  public final void c(zzcf paramZzcf, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("r", paramString);
    try
    {
      paramZzcf.append(localBundle);
      return;
    }
    catch (RemoteException paramZzcf)
    {
      this$0.zzay().hasNext().append("Error returning string value to wrapper", paramZzcf);
    }
  }
  
  public final long create(long paramLong1, long paramLong2)
  {
    return (paramLong1 + paramLong2 * 60000L) / 86400000L;
  }
  
  public final void create(zzcf paramZzcf, ArrayList paramArrayList)
  {
    Bundle localBundle = new Bundle();
    localBundle.putParcelableArrayList("r", paramArrayList);
    try
    {
      paramZzcf.append(localBundle);
      return;
    }
    catch (RemoteException paramZzcf)
    {
      this$0.zzay().hasNext().append("Error returning bundle list to wrapper", paramZzcf);
    }
  }
  
  public final int d()
  {
    if (a == null) {
      a = Integer.valueOf(GoogleApiAvailabilityLight.getInstance().getApkVersion(this$0.zzau()) / 1000);
    }
    return a.intValue();
  }
  
  final String encrypt()
  {
    byte[] arrayOfByte = new byte[16];
    iterator().nextBytes(arrayOfByte);
    return String.format(Locale.US, "%032x", new Object[] { new BigInteger(1, arrayOfByte) });
  }
  
  final Object execute(String paramString, Object paramObject)
  {
    boolean bool = "_ev".equals(paramString);
    int i = 256;
    if (bool)
    {
      this$0.append();
      return zzar(256, paramObject, true, true);
    }
    if (zzah(paramString))
    {
      this$0.append();
    }
    else
    {
      this$0.append();
      i = 100;
    }
    return zzar(i, paramObject, false, true);
  }
  
  final int get(String paramString)
  {
    if (!zzac("event param", paramString)) {
      return 3;
    }
    if (!add("event param", null, null, paramString)) {
      return 14;
    }
    this$0.append();
    if (!add("event param", 40, paramString)) {
      return 3;
    }
    return 0;
  }
  
  final int get(String paramString, Object paramObject)
  {
    boolean bool;
    if ("_ldl".equals(paramString)) {
      bool = zzaa("user property referrer", paramString, zzaq(paramString), paramObject);
    } else {
      bool = zzaa("user property", paramString, zzaq(paramString), paramObject);
    }
    if (bool) {
      return 0;
    }
    return 7;
  }
  
  final int get(String paramString1, String paramString2, String paramString3, Object paramObject, Bundle paramBundle, List paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    append();
    if (zzaf(paramObject)) {
      if (paramBoolean2)
      {
        if (!zzas(paramString3, zzgw.items)) {
          return 20;
        }
        Object localObject = this$0.getName();
        ((zzgr)localObject).append();
        ((Log)localObject).next();
        if ((((zzjs)localObject).start()) && (this$0.get().d() < 200900)) {
          return 25;
        }
        this$0.append();
        boolean bool = paramObject instanceof Parcelable[];
        if (bool)
        {
          i = ((Parcelable[])paramObject).length;
        }
        else
        {
          if (!(paramObject instanceof ArrayList)) {
            break label270;
          }
          i = ((ArrayList)paramObject).size();
        }
        if (i > 200)
        {
          this$0.zzay().isEmpty().append("Parameter array is too long; discarded. Value kind, name, array length", "param", paramString3, Integer.valueOf(i));
          this$0.append();
          if (bool)
          {
            localObject = (Parcelable[])paramObject;
            if (localObject.length > 200) {
              paramBundle.putParcelableArray(paramString3, (Parcelable[])Arrays.copyOf((Object[])localObject, 200));
            }
          }
          else if ((paramObject instanceof ArrayList))
          {
            localObject = (ArrayList)paramObject;
            if (((ArrayList)localObject).size() > 200) {
              paramBundle.putParcelableArrayList(paramString3, new ArrayList(((ArrayList)localObject).subList(0, 200)));
            }
          }
          i = 17;
          break label273;
        }
      }
      else
      {
        return 21;
      }
    }
    label270:
    int i = 0;
    label273:
    int j;
    if ((!zzah(paramString2)) && (!zzah(paramString3)))
    {
      this$0.append();
      j = 100;
    }
    else
    {
      this$0.append();
      j = 256;
    }
    if (zzaa("param", paramString3, j, paramObject)) {
      return i;
    }
    if (paramBoolean2)
    {
      if ((paramObject instanceof Bundle))
      {
        parse(paramString1, paramString2, paramString3, (Bundle)paramObject, paramList, paramBoolean1);
        return i;
      }
      int k;
      if ((paramObject instanceof Parcelable[]))
      {
        paramObject = (Parcelable[])paramObject;
        k = paramObject.length;
        j = 0;
        while (j < k)
        {
          paramBundle = paramObject[j];
          if (!(paramBundle instanceof Bundle))
          {
            this$0.zzay().isEmpty().append("All Parcelable[] elements must be of type Bundle. Value type, name", paramBundle.getClass(), paramString3);
            break label585;
          }
          parse(paramString1, paramString2, paramString3, (Bundle)paramBundle, paramList, paramBoolean1);
          j += 1;
        }
      }
      if ((paramObject instanceof ArrayList))
      {
        paramBundle = (ArrayList)paramObject;
        k = paramBundle.size();
        j = 0;
        for (;;)
        {
          if (j >= k) {
            break label587;
          }
          paramObject = paramBundle.get(j);
          if (!(paramObject instanceof Bundle))
          {
            paramString2 = this$0.zzay().isEmpty();
            if (paramObject != null) {
              paramString1 = paramObject.getClass();
            } else {
              paramString1 = "null";
            }
            paramString2.append("All ArrayList elements must be of type Bundle. Value type, name", paramString1, paramString3);
            break;
          }
          parse(paramString1, paramString2, paramString3, (Bundle)paramObject, paramList, paramBoolean1);
          j += 1;
        }
        return i;
      }
    }
    label585:
    return 4;
    label587:
    return i;
  }
  
  final Bundle get(String paramString1, String paramString2, Bundle paramBundle, List paramList, boolean paramBoolean)
  {
    boolean bool = zzas(paramString2, zzgv.content);
    if (paramBundle != null)
    {
      Bundle localBundle = new Bundle(paramBundle);
      int m = this$0.append().execute();
      Iterator localIterator = new TreeSet(paramBundle.keySet()).iterator();
      int i;
      for (int k = 0; localIterator.hasNext(); k = i)
      {
        String str = (String)localIterator.next();
        int j;
        if ((paramList != null) && (paramList.contains(str)))
        {
          j = 0;
        }
        else
        {
          if (!paramBoolean) {
            i = get(str);
          } else {
            i = 0;
          }
          j = i;
          if (i == 0) {
            j = getIndex(str);
          }
        }
        Object localObject;
        if (j != 0)
        {
          if (j == 3) {
            localObject = str;
          } else {
            localObject = null;
          }
          add(localBundle, j, str, str, localObject);
          localBundle.remove(str);
          i = k;
        }
        else
        {
          i = get(paramString1, paramString2, str, paramBundle.get(str), localBundle, paramList, paramBoolean, bool);
          if (i == 17)
          {
            add(localBundle, 17, str, str, Boolean.FALSE);
          }
          else if ((i != 0) && (!"_ev".equals(str)))
          {
            if (i == 21) {
              localObject = paramString2;
            } else {
              localObject = str;
            }
            add(localBundle, i, (String)localObject, str, paramBundle.get(str));
            localBundle.remove(str);
            i = k;
            continue;
          }
          i = k;
          if (zzai(str))
          {
            j = k + 1;
            i = j;
            if (j > m)
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("Event can't contain more than ");
              ((StringBuilder)localObject).append(m);
              ((StringBuilder)localObject).append(" params");
              this$0.zzay().equals().append(((StringBuilder)localObject).toString(), this$0.next().toString(paramString2), this$0.next().getValue(paramBundle));
              zzao(localBundle, 5);
              localBundle.remove(str);
              i = j;
            }
          }
        }
      }
      return localBundle;
    }
    return null;
  }
  
  final zzaw get(String paramString1, String paramString2, Bundle paramBundle, String paramString3, long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return null;
    }
    if (parse(paramString2) == 0)
    {
      if (paramBundle != null) {
        paramBundle = new Bundle(paramBundle);
      } else {
        paramBundle = new Bundle();
      }
      paramBundle.putString("_o", paramString3);
      paramBundle = get(paramString1, paramString2, paramBundle, CollectionUtils.listOf("_o"), true);
      paramString1 = paramBundle;
      if (paramBoolean1) {
        paramString1 = apply(paramBundle);
      }
      Preconditions.checkNotNull(paramString1);
      return new zzaw(paramString2, new zzau(paramString1), paramString3, paramLong);
    }
    this$0.zzay().iterator().append("Invalid conditional property event name", this$0.next().get(paramString2));
    throw new IllegalArgumentException();
  }
  
  public final URL get(long paramLong1, String paramString1, String paramString2, long paramLong2)
  {
    try
    {
      Preconditions.checkNotEmpty(paramString2);
      Preconditions.checkNotEmpty(paramString1);
      int i = d();
      String str = String.format("v%s.%s", new Object[] { Long.valueOf(73000L), Integer.valueOf(i) });
      str = String.format("https://www.googleadservices.com/pagead/conversion/app/deeplink?id_type=adid&sdk_version=%s&rdid=%s&bundleid=%s&retry=%s", new Object[] { str, paramString2, paramString1, Long.valueOf(paramLong2) });
      paramString2 = str;
      zzfy localZzfy = this$0;
      boolean bool = paramString1.equals(localZzfy.append().escape());
      if (bool) {
        paramString2 = str.concat("&ddl_test=1");
      }
      paramString1 = new URL(paramString2);
      return paramString1;
    }
    catch (IllegalArgumentException paramString1) {}catch (MalformedURLException paramString1) {}
    this$0.zzay().iterator().append("Failed to create BOW URL for Deferred Deep Link. exception", ((Exception)paramString1).getMessage());
    return null;
  }
  
  final boolean get(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      if (!zzap(paramString1))
      {
        if (!this$0.isEmpty()) {
          break label110;
        }
        this$0.zzay().equals().append("Invalid google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI. provided id", zzeo.get(paramString1));
        return false;
      }
    }
    else
    {
      if (TextUtils.isEmpty(paramString2)) {
        break label84;
      }
      if (!zzap(paramString2))
      {
        this$0.zzay().equals().append("Invalid admob_app_id. Analytics disabled.", zzeo.get(paramString2));
        return false;
      }
    }
    return true;
    label84:
    if (this$0.isEmpty()) {
      this$0.zzay().equals().append("Missing google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI");
    }
    label110:
    return false;
  }
  
  final int getIndex(String paramString)
  {
    if (!zzab("event param", paramString)) {
      return 3;
    }
    if (!add("event param", null, null, paramString)) {
      return 14;
    }
    this$0.append();
    if (!add("event param", 40, paramString)) {
      return 3;
    }
    return 0;
  }
  
  public final String getText(String paramString, int paramInt, boolean paramBoolean)
  {
    if (paramString == null) {
      return null;
    }
    if (paramString.codePointCount(0, paramString.length()) > paramInt)
    {
      if (paramBoolean) {
        return String.valueOf(paramString.substring(0, paramString.offsetByCodePoints(0, paramInt))).concat("...");
      }
      return null;
    }
    return paramString;
  }
  
  public final int getTime(int paramInt)
  {
    return GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(this$0.zzau(), 12451000);
  }
  
  final int getType(String paramString)
  {
    if (!zzab("user property", paramString)) {
      return 6;
    }
    if (!add("user property", zzgx.name, null, paramString)) {
      return 15;
    }
    this$0.append();
    if (!add("user property", 24, paramString)) {
      return 6;
    }
    return 0;
  }
  
  final SecureRandom iterator()
  {
    append();
    if (iterator == null) {
      iterator = new SecureRandom();
    }
    return iterator;
  }
  
  public final long next()
  {
    long l1;
    if (counter.get() == 0L)
    {
      localAtomicLong = counter;
      try
      {
        l1 = new Random(System.nanoTime() ^ this$0.zzav().currentTimeMillis()).nextLong();
        int i = id + 1;
        id = i;
        long l2 = i;
        return l1 + l2;
      }
      catch (Throwable localThrowable1)
      {
        throw localThrowable1;
      }
    }
    AtomicLong localAtomicLong = counter;
    try
    {
      counter.compareAndSet(-1L, 1L);
      l1 = counter.getAndIncrement();
      return l1;
    }
    catch (Throwable localThrowable2)
    {
      throw localThrowable2;
    }
  }
  
  final int parse(String paramString)
  {
    if (!zzab("event", paramString)) {
      return 2;
    }
    if (!add("event", zzgv.source, zzgv.message, paramString)) {
      return 13;
    }
    this$0.append();
    if (!add("event", 40, paramString)) {
      return 2;
    }
    return 0;
  }
  
  final Bundle parse(Uri paramUri)
  {
    Bundle localBundle;
    if (paramUri != null) {
      try
      {
        boolean bool = paramUri.isHierarchical();
        String str5;
        String str6;
        String str7;
        String str3;
        String str1;
        if (bool)
        {
          str4 = paramUri.getQueryParameter("utm_campaign");
          str5 = paramUri.getQueryParameter("utm_source");
          str6 = paramUri.getQueryParameter("utm_medium");
          str7 = paramUri.getQueryParameter("gclid");
          str2 = paramUri.getQueryParameter("utm_id");
          str3 = paramUri.getQueryParameter("dclid");
          str1 = paramUri.getQueryParameter("srsltid");
        }
        else
        {
          str4 = null;
          str5 = null;
          str6 = null;
          str7 = null;
          str2 = null;
          str3 = null;
          str1 = null;
        }
        if ((TextUtils.isEmpty(str4)) && (TextUtils.isEmpty(str5)) && (TextUtils.isEmpty(str6)) && (TextUtils.isEmpty(str7)) && (TextUtils.isEmpty(str2)) && (TextUtils.isEmpty(str3)) && (TextUtils.isEmpty(str1))) {
          return null;
        }
        localBundle = new Bundle();
        if (!TextUtils.isEmpty(str4)) {
          localBundle.putString("campaign", str4);
        }
        if (!TextUtils.isEmpty(str5)) {
          localBundle.putString("source", str5);
        }
        if (!TextUtils.isEmpty(str6)) {
          localBundle.putString("medium", str6);
        }
        if (!TextUtils.isEmpty(str7)) {
          localBundle.putString("gclid", str7);
        }
        String str4 = paramUri.getQueryParameter("utm_term");
        if (!TextUtils.isEmpty(str4)) {
          localBundle.putString("term", str4);
        }
        str4 = paramUri.getQueryParameter("utm_content");
        if (!TextUtils.isEmpty(str4)) {
          localBundle.putString("content", str4);
        }
        str4 = paramUri.getQueryParameter("aclid");
        if (!TextUtils.isEmpty(str4)) {
          localBundle.putString("aclid", str4);
        }
        str4 = paramUri.getQueryParameter("cp1");
        if (!TextUtils.isEmpty(str4)) {
          localBundle.putString("cp1", str4);
        }
        str4 = paramUri.getQueryParameter("anid");
        if (!TextUtils.isEmpty(str4)) {
          localBundle.putString("anid", str4);
        }
        if (!TextUtils.isEmpty(str2)) {
          localBundle.putString("campaign_id", str2);
        }
        if (!TextUtils.isEmpty(str3)) {
          localBundle.putString("dclid", str3);
        }
        String str2 = paramUri.getQueryParameter("utm_source_platform");
        if (!TextUtils.isEmpty(str2)) {
          localBundle.putString("source_platform", str2);
        }
        str2 = paramUri.getQueryParameter("utm_creative_format");
        if (!TextUtils.isEmpty(str2)) {
          localBundle.putString("creative_format", str2);
        }
        paramUri = paramUri.getQueryParameter("utm_marketing_tactic");
        if (!TextUtils.isEmpty(paramUri)) {
          localBundle.putString("marketing_tactic", paramUri);
        }
        if (TextUtils.isEmpty(str1)) {
          break label527;
        }
        localBundle.putString("srsltid", str1);
        return localBundle;
      }
      catch (UnsupportedOperationException paramUri)
      {
        this$0.zzay().hasNext().append("Install referrer url isn't a hierarchical URI", paramUri);
      }
    }
    return null;
    label527:
    return localBundle;
  }
  
  final void parse(String paramString1, String paramString2, String paramString3, Bundle paramBundle, List paramList, boolean paramBoolean)
  {
    if (paramBundle == null) {
      return;
    }
    this$0.append();
    Iterator localIterator = new TreeSet(paramBundle.keySet()).iterator();
    int k = 0;
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      int j;
      int i;
      if ((paramList != null) && (paramList.contains(str1)))
      {
        j = 0;
      }
      else
      {
        if (!paramBoolean) {
          i = get(str1);
        } else {
          i = 0;
        }
        j = i;
        if (i == 0) {
          j = getIndex(str1);
        }
      }
      if (j != 0)
      {
        String str2;
        if (j == 3) {
          str2 = str1;
        } else {
          str2 = null;
        }
        add(paramBundle, j, str1, str1, str2);
        paramBundle.remove(str1);
      }
      else
      {
        if (zzaf(paramBundle.get(str1)))
        {
          this$0.zzay().isEmpty().append("Nested Bundle parameters are not allowed; discarded. event name, param name, child param name", paramString2, paramString3, str1);
          i = 22;
        }
        else
        {
          i = get(paramString1, paramString2, str1, paramBundle.get(str1), paramBundle, paramList, paramBoolean, false);
        }
        if ((i != 0) && (!"_ev".equals(str1)))
        {
          add(paramBundle, i, str1, str1, paramBundle.get(str1));
          paramBundle.remove(str1);
        }
        else if ((zzai(str1)) && (!zzas(str1, zzgw.fields)))
        {
          i = k + 1;
          k = i;
          if (i > 0)
          {
            this$0.zzay().equals().append("Item cannot contain custom parameters", this$0.next().toString(paramString2), this$0.next().getValue(paramBundle));
            zzao(paramBundle, 23);
            paramBundle.remove(str1);
            k = i;
          }
        }
      }
    }
  }
  
  protected final boolean parse()
  {
    return true;
  }
  
  public final void readMessage(zzcf paramZzcf, int paramInt)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("r", paramInt);
    try
    {
      paramZzcf.append(localBundle);
      return;
    }
    catch (RemoteException paramZzcf)
    {
      this$0.zzay().hasNext().append("Error returning int value to wrapper", paramZzcf);
    }
  }
  
  final void remove(zzep paramZzep, int paramInt)
  {
    Iterator localIterator = new TreeSet(data.keySet()).iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (zzai(str))
      {
        int j = i + 1;
        i = j;
        if (j > paramInt)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Event can't contain more than ");
          localStringBuilder.append(paramInt);
          localStringBuilder.append(" params");
          this$0.zzay().equals().append(localStringBuilder.toString(), this$0.next().toString(length), this$0.next().getValue(data));
          zzao(data, 5);
          data.remove(str);
          i = j;
        }
      }
    }
  }
  
  public final void removeAccount(zzcf paramZzcf, Bundle paramBundle)
  {
    try
    {
      paramZzcf.append(paramBundle);
      return;
    }
    catch (RemoteException paramZzcf)
    {
      this$0.zzay().hasNext().append("Error returning bundle value to wrapper", paramZzcf);
    }
  }
  
  final Object save(String paramString, Object paramObject)
  {
    if ("_ldl".equals(paramString)) {
      return zzar(zzaq(paramString), paramObject, true, false);
    }
    return zzar(zzaq(paramString), paramObject, false, false);
  }
  
  public final void sendResponse(zzcf paramZzcf, long paramLong)
  {
    Bundle localBundle = new Bundle();
    localBundle.putLong("r", paramLong);
    try
    {
      paramZzcf.append(localBundle);
      return;
    }
    catch (RemoteException paramZzcf)
    {
      this$0.zzay().hasNext().append("Error returning long value to wrapper", paramZzcf);
    }
  }
  
  final void set(Bundle paramBundle1, Bundle paramBundle2)
  {
    if (paramBundle2 == null) {
      return;
    }
    Iterator localIterator = paramBundle2.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (!paramBundle1.containsKey(str)) {
        this$0.get().add(paramBundle1, str, paramBundle2.get(str));
      }
    }
  }
  
  public final void set(zzcf paramZzcf, boolean paramBoolean)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("r", paramBoolean);
    try
    {
      paramZzcf.append(localBundle);
      return;
    }
    catch (RemoteException paramZzcf)
    {
      this$0.zzay().hasNext().append("Error returning boolean value to wrapper", paramZzcf);
    }
  }
  
  final void startSession(Bundle paramBundle, long paramLong)
  {
    long l2 = paramBundle.getLong("_et");
    long l1 = l2;
    if (l2 != 0L) {
      this$0.zzay().hasNext().append("Params already contained engagement", Long.valueOf(l2));
    } else {
      l1 = 0L;
    }
    paramBundle.putLong("_et", paramLong + l1);
  }
  
  protected final void zzaA()
  {
    append();
    SecureRandom localSecureRandom = new SecureRandom();
    long l2 = localSecureRandom.nextLong();
    long l1 = l2;
    if (l2 == 0L)
    {
      long l3 = localSecureRandom.nextLong();
      l2 = l3;
      l1 = l2;
      if (l3 == 0L)
      {
        this$0.zzay().hasNext().append("Utils falling back to Random for random id");
        l1 = l2;
      }
    }
    counter.set(l1);
  }
  
  final boolean zzaa(String paramString1, String paramString2, int paramInt, Object paramObject)
  {
    if (paramObject == null) {
      return true;
    }
    if ((!(paramObject instanceof Long)) && (!(paramObject instanceof Float)) && (!(paramObject instanceof Integer)) && (!(paramObject instanceof Byte)) && (!(paramObject instanceof Short)) && (!(paramObject instanceof Boolean)))
    {
      if ((paramObject instanceof Double)) {
        return true;
      }
      if ((!(paramObject instanceof String)) && (!(paramObject instanceof Character)) && (!(paramObject instanceof CharSequence))) {
        return false;
      }
      paramObject = paramObject.toString();
      if (paramObject.codePointCount(0, paramObject.length()) > paramInt)
      {
        this$0.zzay().isEmpty().append("Value is too long; discarded. Value kind, name, value length", paramString1, paramString2, Integer.valueOf(paramObject.length()));
        return false;
      }
    }
    return true;
  }
  
  final boolean zzab(String paramString1, String paramString2)
  {
    if (paramString2 == null)
    {
      this$0.zzay().equals().append("Name is required and can't be null. Type", paramString1);
      return false;
    }
    if (paramString2.length() == 0)
    {
      this$0.zzay().equals().append("Name is required and can't be empty. Type", paramString1);
      return false;
    }
    int j = paramString2.codePointAt(0);
    int i = j;
    if (!Character.isLetter(j)) {
      if (j == 95)
      {
        i = 95;
      }
      else
      {
        this$0.zzay().equals().append("Name must start with a letter or _ (underscore). Type, name", paramString1, paramString2);
        return false;
      }
    }
    j = paramString2.length();
    i = Character.charCount(i);
    while (i < j)
    {
      int k = paramString2.codePointAt(i);
      if ((k != 95) && (!Character.isLetterOrDigit(k)))
      {
        this$0.zzay().equals().append("Name must consist of letters, digits or _ (underscores). Type, name", paramString1, paramString2);
        return false;
      }
      i += Character.charCount(k);
    }
    return true;
  }
  
  final boolean zzac(String paramString1, String paramString2)
  {
    if (paramString2 == null)
    {
      this$0.zzay().equals().append("Name is required and can't be null. Type", paramString1);
      return false;
    }
    if (paramString2.length() == 0)
    {
      this$0.zzay().equals().append("Name is required and can't be empty. Type", paramString1);
      return false;
    }
    int i = paramString2.codePointAt(0);
    if (!Character.isLetter(i))
    {
      this$0.zzay().equals().append("Name must start with a letter. Type, name", paramString1, paramString2);
      return false;
    }
    int j = paramString2.length();
    i = Character.charCount(i);
    while (i < j)
    {
      int k = paramString2.codePointAt(i);
      if ((k != 95) && (!Character.isLetterOrDigit(k)))
      {
        this$0.zzay().equals().append("Name must consist of letters, digits or _ (underscores). Type, name", paramString1, paramString2);
        return false;
      }
      i += Character.charCount(k);
    }
    return true;
  }
  
  final boolean zzad(String paramString)
  {
    append();
    if (Wrappers.packageManager(this$0.zzau()).checkCallingOrSelfPermission(paramString) == 0) {
      return true;
    }
    this$0.zzay().e().append("Permission not granted", paramString);
    return false;
  }
  
  final boolean zzae(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    String str = this$0.append().getRecurrence();
    this$0.zzaw();
    return str.equals(paramString);
  }
  
  final boolean zzaf(Object paramObject)
  {
    return ((paramObject instanceof Parcelable[])) || ((paramObject instanceof ArrayList)) || ((paramObject instanceof Bundle));
  }
  
  final boolean zzag(Context paramContext, String paramString)
  {
    X500Principal localX500Principal = new X500Principal("CN=Android Debug,O=Android,C=US");
    try
    {
      paramContext = Wrappers.packageManager(paramContext).getPackageInfo(paramString, 64);
      if (paramContext != null)
      {
        paramContext = signatures;
        if ((paramContext != null) && (paramContext.length > 0))
        {
          paramContext = paramContext[0];
          paramString = CertificateFactory.getInstance("X.509");
          paramContext = paramString.generateCertificate(new ByteArrayInputStream(paramContext.toByteArray()));
          paramContext = (X509Certificate)paramContext;
          boolean bool = paramContext.getSubjectX500Principal().equals(localX500Principal);
          return bool;
        }
      }
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      this$0.zzay().iterator().append("Package name not found", paramContext);
    }
    catch (CertificateException paramContext)
    {
      this$0.zzay().iterator().append("Error obtaining certificate", paramContext);
    }
    return true;
  }
  
  final boolean zzam(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    boolean bool1 = TextUtils.isEmpty(paramString1);
    boolean bool2 = TextUtils.isEmpty(paramString2);
    if ((!bool1) && (!bool2))
    {
      Preconditions.checkNotNull(paramString1);
      return !paramString1.equals(paramString2);
    }
    if ((bool1) && (bool2))
    {
      if ((!TextUtils.isEmpty(paramString3)) && (!TextUtils.isEmpty(paramString4))) {
        return !paramString3.equals(paramString4);
      }
      return !TextUtils.isEmpty(paramString4);
    }
    if (!bool1)
    {
      if (TextUtils.isEmpty(paramString4)) {
        return false;
      }
      if (!TextUtils.isEmpty(paramString3)) {
        return !paramString3.equals(paramString4);
      }
      return true;
    }
    if (!TextUtils.isEmpty(paramString3)) {
      return !paramString3.equals(paramString4);
    }
    return true;
  }
  
  final byte[] zzan(Parcelable paramParcelable)
  {
    if (paramParcelable == null) {
      return null;
    }
    Parcel localParcel = Parcel.obtain();
    try
    {
      paramParcelable.writeToParcel(localParcel, 0);
      paramParcelable = localParcel.marshall();
      localParcel.recycle();
      return paramParcelable;
    }
    catch (Throwable paramParcelable)
    {
      localParcel.recycle();
      throw paramParcelable;
    }
  }
}
