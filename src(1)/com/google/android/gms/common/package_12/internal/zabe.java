package com.google.android.gms.common.package_12.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.fragment.package_11.FragmentActivity;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.internal.zat;
import com.google.android.gms.common.internal.Channel;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.b;
import com.google.android.gms.common.internal.service.Common;
import com.google.android.gms.common.internal.service.Preferences;
import com.google.android.gms.common.package_12.Attribute;
import com.google.android.gms.common.package_12.GoogleApiClient;
import com.google.android.gms.common.package_12.GoogleApiClient.Builder;
import com.google.android.gms.common.package_12.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.package_12.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.package_12.PendingResult;
import com.google.android.gms.common.package_12.Status;
import com.google.android.gms.common.util.ClientLibraryUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.gms.signin.zae;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;

public final class zabe
  extends GoogleApiClient
  implements zabz
{
  Set<com.google.android.gms.common.api.internal.zada> active;
  private final Context context;
  final Map<com.google.android.gms.common.api.Api.AnyClientKey<?>, com.google.android.gms.common.api.Api.Client> data;
  private final b delegate;
  private final zabc handler;
  private Integer hash;
  private final ArrayList<zat> id;
  private final Looper key;
  private final ListenerHolders listeners;
  private final Lock lock;
  final zadc log;
  @VisibleForTesting
  final Queue<com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl<?, ?>> queue = new LinkedList();
  private volatile boolean state;
  Set<Scope> tag;
  final ClientSettings target;
  final Map<Api<?>, Boolean> text;
  private zaca this$0 = null;
  private long thread;
  private final Channel threads;
  private long timeout;
  @VisibleForTesting
  zabx timer;
  final com.google.android.gms.common.api.Api.AbstractClientBuilder<? extends zae, SignInOptions> title;
  private final int transactions;
  private final GoogleApiAvailability type;
  
  public zabe(Context paramContext, Lock paramLock, Looper paramLooper, ClientSettings paramClientSettings, GoogleApiAvailability paramGoogleApiAvailability, com.google.android.gms.common.package_12.Api.AbstractClientBuilder paramAbstractClientBuilder, Map paramMap1, List paramList1, List paramList2, Map paramMap2, int paramInt1, int paramInt2, ArrayList paramArrayList)
  {
    long l;
    if (true != ClientLibraryUtils.isPackageSide()) {
      l = 120000L;
    } else {
      l = 10000L;
    }
    thread = l;
    timeout = 5000L;
    tag = new HashSet();
    listeners = new ListenerHolders();
    hash = null;
    active = null;
    zaay localZaay = new zaay(this);
    threads = localZaay;
    context = paramContext;
    lock = paramLock;
    delegate = new b(paramLooper, localZaay);
    key = paramLooper;
    handler = new zabc(this, paramLooper);
    type = paramGoogleApiAvailability;
    transactions = paramInt1;
    if (paramInt1 >= 0) {
      hash = Integer.valueOf(paramInt2);
    }
    text = paramMap1;
    data = paramMap2;
    id = paramArrayList;
    log = new zadc();
    paramContext = paramList1.iterator();
    while (paramContext.hasNext())
    {
      paramLock = (GoogleApiClient.ConnectionCallbacks)paramContext.next();
      delegate.close(paramLock);
    }
    paramContext = paramList2.iterator();
    while (paramContext.hasNext())
    {
      paramLock = (GoogleApiClient.OnConnectionFailedListener)paramContext.next();
      delegate.a(paramLock);
    }
    target = paramClientSettings;
    title = paramAbstractClientBuilder;
  }
  
  private final void clear()
  {
    delegate.onCreate();
    ((zaca)Preconditions.checkNotNull(this$0)).next();
  }
  
  private final void init(int paramInt)
  {
    Object localObject1 = hash;
    if (localObject1 == null) {
      hash = Integer.valueOf(paramInt);
    } else {
      if (((Integer)localObject1).intValue() != paramInt) {
        break label252;
      }
    }
    if (this$0 != null) {
      return;
    }
    localObject1 = data.values().iterator();
    boolean bool = false;
    paramInt = 0;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (com.google.android.gms.common.package_12.Api.Client)((Iterator)localObject1).next();
      bool |= ((com.google.android.gms.common.package_12.Api.Client)localObject2).requiresSignIn();
      paramInt |= ((com.google.android.gms.common.package_12.Api.Client)localObject2).providesSignIn();
    }
    int i = hash.intValue();
    if (i != 1)
    {
      if ((i == 2) && (bool)) {
        this$0 = zaaa.add(context, this, lock, key, type, data, target, text, title, id);
      }
    }
    else
    {
      if (!bool) {
        break label242;
      }
      if (paramInt != 0) {
        break label232;
      }
    }
    this$0 = new zabi(context, this, lock, key, type, data, target, text, title, id, this);
    return;
    label232:
    throw new IllegalStateException("Cannot use SIGN_IN_MODE_REQUIRED with GOOGLE_SIGN_IN_API. Use connect(SIGN_IN_MODE_OPTIONAL) instead.");
    label242:
    throw new IllegalStateException("SIGN_IN_MODE_REQUIRED cannot be used on a GoogleApiClient that does not contain any authenticated APIs. Use connect() instead.");
    label252:
    localObject1 = toString(paramInt);
    Object localObject2 = toString(hash.intValue());
    StringBuilder localStringBuilder = new StringBuilder(((String)localObject1).length() + 51 + ((String)localObject2).length());
    localStringBuilder.append("Cannot use sign-in mode: ");
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append(". Mode was already set to ");
    localStringBuilder.append((String)localObject2);
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  private final void setBoolean(GoogleApiClient paramGoogleApiClient, StatusPendingResult paramStatusPendingResult, boolean paramBoolean)
  {
    Common.prefs.getString(paramGoogleApiClient).setResultCallback(new zabb(this, paramStatusPendingResult, paramBoolean, paramGoogleApiClient));
  }
  
  static String toString(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3) {
          return "UNKNOWN";
        }
        return "SIGN_IN_MODE_NONE";
      }
      return "SIGN_IN_MODE_OPTIONAL";
    }
    return "SIGN_IN_MODE_REQUIRED";
  }
  
  public static int transform(Iterable paramIterable, boolean paramBoolean)
  {
    paramIterable = paramIterable.iterator();
    boolean bool2 = false;
    boolean bool1 = false;
    while (paramIterable.hasNext())
    {
      com.google.android.gms.common.package_12.Api.Client localClient = (com.google.android.gms.common.package_12.Api.Client)paramIterable.next();
      bool2 |= localClient.requiresSignIn();
      bool1 |= localClient.providesSignIn();
    }
    if (bool2)
    {
      if ((bool1) && (paramBoolean)) {
        return 2;
      }
      return 1;
    }
    return 3;
  }
  
  public final ConnectionResult blockingConnect()
  {
    Object localObject = Looper.myLooper();
    Looper localLooper = Looper.getMainLooper();
    boolean bool2 = true;
    boolean bool1;
    if (localObject != localLooper) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    Preconditions.checkState(bool1, "blockingConnect must not be called on the UI thread");
    lock.lock();
    try
    {
      int i = transactions;
      if (i >= 0)
      {
        localObject = hash;
        if (localObject != null) {
          bool1 = bool2;
        } else {
          bool1 = false;
        }
        Preconditions.checkState(bool1, "Sign-in mode should have been set explicitly by auto-manage.");
      }
      else
      {
        localObject = hash;
        if (localObject == null)
        {
          hash = Integer.valueOf(transform(data.values(), false));
        }
        else
        {
          i = ((Integer)localObject).intValue();
          if (i == 2) {
            break label177;
          }
        }
      }
      init(((Integer)Preconditions.checkNotNull(hash)).intValue());
      delegate.onCreate();
      localObject = ((zaca)Preconditions.checkNotNull(this$0)).doInBackground();
      lock.unlock();
      return localObject;
      label177:
      throw new IllegalStateException("Cannot call blockingConnect() when sign-in mode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
    }
    catch (Throwable localThrowable)
    {
      lock.unlock();
      throw localThrowable;
    }
  }
  
  public final ConnectionResult blockingConnect(long paramLong, TimeUnit paramTimeUnit)
  {
    boolean bool;
    if (Looper.myLooper() != Looper.getMainLooper()) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkState(bool, "blockingConnect must not be called on the UI thread");
    Preconditions.checkNotNull(paramTimeUnit, "TimeUnit must not be null");
    lock.lock();
    try
    {
      Integer localInteger = hash;
      if (localInteger == null)
      {
        hash = Integer.valueOf(transform(data.values(), false));
      }
      else
      {
        int i = localInteger.intValue();
        if (i == 2) {
          break label143;
        }
      }
      init(((Integer)Preconditions.checkNotNull(hash)).intValue());
      delegate.onCreate();
      paramTimeUnit = ((zaca)Preconditions.checkNotNull(this$0)).execute(paramLong, paramTimeUnit);
      lock.unlock();
      return paramTimeUnit;
      label143:
      throw new IllegalStateException("Cannot call blockingConnect() when sign-in mode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
    }
    catch (Throwable paramTimeUnit)
    {
      lock.unlock();
      throw paramTimeUnit;
    }
  }
  
  public final PendingResult clearDefaultAccountAndReconnect()
  {
    Preconditions.checkState(isConnected(), "GoogleApiClient is not connected yet.");
    Object localObject1 = hash;
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (localObject1 != null) {
      if (((Integer)localObject1).intValue() != 2) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
    }
    Preconditions.checkState(bool1, "Cannot use clearDefaultAccountAndReconnect with GOOGLE_SIGN_IN_API");
    localObject1 = new StatusPendingResult(this);
    if (data.containsKey(Common.CLIENT_KEY))
    {
      setBoolean(this, (StatusPendingResult)localObject1, false);
      return localObject1;
    }
    AtomicReference localAtomicReference = new AtomicReference();
    Object localObject2 = new zaaz(this, localAtomicReference, (StatusPendingResult)localObject1);
    zaba localZaba = new zaba(this, (StatusPendingResult)localObject1);
    GoogleApiClient.Builder localBuilder = new GoogleApiClient.Builder(context);
    localBuilder.addApi(Common.context);
    localBuilder.addConnectionCallbacks((GoogleApiClient.ConnectionCallbacks)localObject2);
    localBuilder.addOnConnectionFailedListener(localZaba);
    localBuilder.setHandler(handler);
    localObject2 = localBuilder.build();
    localAtomicReference.set(localObject2);
    ((GoogleApiClient)localObject2).connect();
    return localObject1;
  }
  
  public final void connect()
  {
    Object localObject = lock;
    zabe localZabe = this;
    ((Lock)localObject).lock();
    try
    {
      int i = transactions;
      int j = 2;
      boolean bool2 = false;
      if (i >= 0)
      {
        localObject = hash;
        if (localObject != null) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        Preconditions.checkState(bool1, "Sign-in mode should have been set explicitly by auto-manage.");
      }
      else
      {
        localObject = hash;
        if (localObject == null)
        {
          hash = Integer.valueOf(transform(data.values(), false));
        }
        else
        {
          i = ((Integer)localObject).intValue();
          if (i == 2) {
            break label248;
          }
        }
      }
      i = ((Integer)Preconditions.checkNotNull(hash)).intValue();
      localObject = lock;
      ((Lock)localObject).lock();
      if ((i != 3) && (i != 1)) {
        if (i == 2)
        {
          i = j;
        }
        else
        {
          bool1 = bool2;
          break label165;
        }
      }
      boolean bool1 = true;
      try
      {
        label165:
        localObject = new StringBuilder(33);
        ((StringBuilder)localObject).append("Illegal sign-in mode: ");
        ((StringBuilder)localObject).append(i);
        Preconditions.checkArgument(bool1, ((StringBuilder)localObject).toString());
        localZabe.init(i);
        localZabe.clear();
        lock.unlock();
        lock.unlock();
        return;
      }
      catch (Throwable localThrowable2)
      {
        lock.unlock();
        throw localThrowable2;
      }
      label248:
      throw new IllegalStateException("Cannot call connect() when SignInMode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
    }
    catch (Throwable localThrowable1)
    {
      lock.unlock();
      throw localThrowable1;
    }
  }
  
  public final void connect(int paramInt)
  {
    lock.lock();
    boolean bool2 = true;
    boolean bool1 = bool2;
    int i = paramInt;
    if (paramInt != 3)
    {
      bool1 = bool2;
      i = paramInt;
      if (paramInt != 1) {
        if (paramInt == 2)
        {
          i = 2;
          bool1 = bool2;
        }
        else
        {
          bool1 = false;
          i = paramInt;
        }
      }
    }
    try
    {
      StringBuilder localStringBuilder = new StringBuilder(33);
      localStringBuilder.append("Illegal sign-in mode: ");
      localStringBuilder.append(i);
      Preconditions.checkArgument(bool1, localStringBuilder.toString());
      init(i);
      clear();
      lock.unlock();
      return;
    }
    catch (Throwable localThrowable)
    {
      lock.unlock();
      throw localThrowable;
    }
  }
  
  /* Error */
  public final void disconnect()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 112	com/google/android/gms/common/package_12/internal/zabe:lock	Ljava/util/concurrent/locks/Lock;
    //   4: invokeinterface 270 1 0
    //   9: aload_0
    //   10: getfield 149	com/google/android/gms/common/package_12/internal/zabe:log	Lcom/google/android/gms/common/package_12/internal/zadc;
    //   13: invokevirtual 444	com/google/android/gms/common/package_12/internal/zadc:write	()V
    //   16: aload_0
    //   17: getfield 66	com/google/android/gms/common/package_12/internal/zabe:this$0	Lcom/google/android/gms/common/package_12/internal/zaca;
    //   20: astore_2
    //   21: aload_2
    //   22: ifnull +9 -> 31
    //   25: aload_2
    //   26: invokeinterface 447 1 0
    //   31: aload_0
    //   32: getfield 97	com/google/android/gms/common/package_12/internal/zabe:listeners	Lcom/google/android/gms/common/package_12/internal/ListenerHolders;
    //   35: invokevirtual 448	com/google/android/gms/common/package_12/internal/ListenerHolders:clear	()V
    //   38: aload_0
    //   39: getfield 71	com/google/android/gms/common/package_12/internal/zabe:queue	Ljava/util/Queue;
    //   42: invokeinterface 451 1 0
    //   47: astore_2
    //   48: aload_2
    //   49: invokeinterface 160 1 0
    //   54: istore_1
    //   55: iload_1
    //   56: ifeq +25 -> 81
    //   59: aload_2
    //   60: invokeinterface 164 1 0
    //   65: checkcast 453	com/google/android/gms/common/package_12/internal/BaseImplementation$ApiMethodImpl
    //   68: astore_3
    //   69: aload_3
    //   70: aconst_null
    //   71: invokevirtual 458	com/google/android/gms/common/package_12/internal/BasePendingResult:next	(Lcom/google/android/gms/common/package_12/internal/zadb;)V
    //   74: aload_3
    //   75: invokevirtual 461	com/google/android/gms/common/package_12/internal/BasePendingResult:cancel	()V
    //   78: goto -30 -> 48
    //   81: aload_0
    //   82: getfield 71	com/google/android/gms/common/package_12/internal/zabe:queue	Ljava/util/Queue;
    //   85: invokeinterface 462 1 0
    //   90: aload_0
    //   91: getfield 66	com/google/android/gms/common/package_12/internal/zabe:this$0	Lcom/google/android/gms/common/package_12/internal/zaca;
    //   94: astore_2
    //   95: aload_2
    //   96: ifnonnull +15 -> 111
    //   99: aload_0
    //   100: getfield 112	com/google/android/gms/common/package_12/internal/zabe:lock	Ljava/util/concurrent/locks/Lock;
    //   103: astore_2
    //   104: aload_2
    //   105: invokeinterface 277 1 0
    //   110: return
    //   111: aload_0
    //   112: invokevirtual 281	com/google/android/gms/common/package_12/internal/zabe:release	()Z
    //   115: pop
    //   116: aload_0
    //   117: getfield 119	com/google/android/gms/common/package_12/internal/zabe:delegate	Lcom/google/android/gms/common/internal/b;
    //   120: invokevirtual 463	com/google/android/gms/common/internal/b:write	()V
    //   123: aload_0
    //   124: getfield 112	com/google/android/gms/common/package_12/internal/zabe:lock	Ljava/util/concurrent/locks/Lock;
    //   127: astore_2
    //   128: goto -24 -> 104
    //   131: astore_2
    //   132: aload_0
    //   133: getfield 112	com/google/android/gms/common/package_12/internal/zabe:lock	Ljava/util/concurrent/locks/Lock;
    //   136: invokeinterface 277 1 0
    //   141: aload_2
    //   142: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	143	0	this	zabe
    //   54	2	1	bool	boolean
    //   20	108	2	localObject	Object
    //   131	11	2	localThrowable	Throwable
    //   68	7	3	localApiMethodImpl	BaseImplementation.ApiMethodImpl
    // Exception table:
    //   from	to	target	type
    //   9	21	131	java/lang/Throwable
    //   25	31	131	java/lang/Throwable
    //   31	48	131	java/lang/Throwable
    //   48	55	131	java/lang/Throwable
    //   59	78	131	java/lang/Throwable
    //   81	95	131	java/lang/Throwable
    //   111	123	131	java/lang/Throwable
  }
  
  public final void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    paramPrintWriter.append(paramString).append("mContext=").println(context);
    paramPrintWriter.append(paramString).append("mResuming=").print(state);
    paramPrintWriter.append(" mWorkQueue.size()=").print(queue.size());
    Object localObject = log;
    paramPrintWriter.append(" mUnconsumedApiCalls.size()=").println(data.size());
    localObject = this$0;
    if (localObject != null) {
      ((zaca)localObject).write(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    }
  }
  
  /* Error */
  public final BaseImplementation.ApiMethodImpl enqueue(BaseImplementation.ApiMethodImpl paramApiMethodImpl)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 505	com/google/android/gms/common/package_12/internal/BaseImplementation$ApiMethodImpl:getApi	()Lcom/google/android/gms/common/package_12/Attribute;
    //   4: astore_3
    //   5: aload_0
    //   6: getfield 142	com/google/android/gms/common/package_12/internal/zabe:data	Ljava/util/Map;
    //   9: aload_1
    //   10: invokevirtual 509	com/google/android/gms/common/package_12/internal/BaseImplementation$ApiMethodImpl:getClientKey	()Lcom/google/android/gms/common/package_12/Api$AnyClientKey;
    //   13: invokeinterface 382 2 0
    //   18: istore_2
    //   19: aload_3
    //   20: ifnull +11 -> 31
    //   23: aload_3
    //   24: invokevirtual 514	com/google/android/gms/common/package_12/Attribute:get	()Ljava/lang/String;
    //   27: astore_3
    //   28: goto +7 -> 35
    //   31: ldc_w 516
    //   34: astore_3
    //   35: new 245	java/lang/StringBuilder
    //   38: dup
    //   39: aload_3
    //   40: invokestatic 519	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   43: invokevirtual 250	java/lang/String:length	()I
    //   46: bipush 65
    //   48: iadd
    //   49: invokespecial 252	java/lang/StringBuilder:<init>	(I)V
    //   52: astore 4
    //   54: aload 4
    //   56: ldc_w 521
    //   59: invokevirtual 258	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: pop
    //   63: aload 4
    //   65: aload_3
    //   66: invokevirtual 258	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: pop
    //   70: aload 4
    //   72: ldc_w 523
    //   75: invokevirtual 258	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: pop
    //   79: iload_2
    //   80: aload 4
    //   82: invokevirtual 263	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   85: invokestatic 438	com/google/android/gms/common/internal/Preconditions:checkArgument	(ZLjava/lang/Object;)V
    //   88: aload_0
    //   89: getfield 112	com/google/android/gms/common/package_12/internal/zabe:lock	Ljava/util/concurrent/locks/Lock;
    //   92: invokeinterface 270 1 0
    //   97: aload_0
    //   98: getfield 66	com/google/android/gms/common/package_12/internal/zabe:this$0	Lcom/google/android/gms/common/package_12/internal/zaca;
    //   101: astore_3
    //   102: aload_3
    //   103: ifnonnull +33 -> 136
    //   106: aload_0
    //   107: getfield 71	com/google/android/gms/common/package_12/internal/zabe:queue	Ljava/util/Queue;
    //   110: aload_1
    //   111: invokeinterface 525 2 0
    //   116: pop
    //   117: aload_0
    //   118: getfield 112	com/google/android/gms/common/package_12/internal/zabe:lock	Ljava/util/concurrent/locks/Lock;
    //   121: astore 4
    //   123: aload_1
    //   124: astore_3
    //   125: aload 4
    //   127: astore_1
    //   128: aload_1
    //   129: invokeinterface 277 1 0
    //   134: aload_3
    //   135: areturn
    //   136: aload_3
    //   137: aload_1
    //   138: invokeinterface 527 2 0
    //   143: astore_3
    //   144: aload_0
    //   145: getfield 112	com/google/android/gms/common/package_12/internal/zabe:lock	Ljava/util/concurrent/locks/Lock;
    //   148: astore_1
    //   149: goto -21 -> 128
    //   152: astore_1
    //   153: aload_0
    //   154: getfield 112	com/google/android/gms/common/package_12/internal/zabe:lock	Ljava/util/concurrent/locks/Lock;
    //   157: invokeinterface 277 1 0
    //   162: aload_1
    //   163: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	164	0	this	zabe
    //   0	164	1	paramApiMethodImpl	BaseImplementation.ApiMethodImpl
    //   18	62	2	bool	boolean
    //   4	140	3	localObject1	Object
    //   52	74	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   97	102	152	java/lang/Throwable
    //   106	117	152	java/lang/Throwable
    //   136	144	152	java/lang/Throwable
  }
  
  public final BaseImplementation.ApiMethodImpl execute(BaseImplementation.ApiMethodImpl paramApiMethodImpl)
  {
    Object localObject1 = paramApiMethodImpl.getApi();
    boolean bool = data.containsKey(paramApiMethodImpl.getClientKey());
    if (localObject1 != null) {
      localObject1 = ((Attribute)localObject1).get();
    } else {
      localObject1 = "the API";
    }
    Object localObject2 = new StringBuilder(String.valueOf(localObject1).length() + 65);
    ((StringBuilder)localObject2).append("GoogleApiClient is not configured to use ");
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append(" required for this call.");
    Preconditions.checkArgument(bool, ((StringBuilder)localObject2).toString());
    lock.lock();
    try
    {
      localObject1 = this$0;
      if (localObject1 != null)
      {
        bool = state;
        if (bool)
        {
          queue.add(paramApiMethodImpl);
          for (;;)
          {
            bool = queue.isEmpty();
            if (bool) {
              break;
            }
            localObject1 = (BaseImplementation.ApiMethodImpl)queue.remove();
            log.close((BasePendingResult)localObject1);
            ((BaseImplementation.ApiMethodImpl)localObject1).setFailedResult(Status.RESULT_INTERNAL_ERROR);
          }
          localObject2 = lock;
          localObject1 = paramApiMethodImpl;
        }
        for (paramApiMethodImpl = (BaseImplementation.ApiMethodImpl)localObject2;; paramApiMethodImpl = lock)
        {
          paramApiMethodImpl.unlock();
          return localObject1;
          localObject1 = ((zaca)localObject1).read(paramApiMethodImpl);
        }
      }
      throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }
    catch (Throwable paramApiMethodImpl)
    {
      lock.unlock();
      throw paramApiMethodImpl;
    }
  }
  
  /* Error */
  public final void get(zada paramZada)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 112	com/google/android/gms/common/package_12/internal/zabe:lock	Ljava/util/concurrent/locks/Lock;
    //   4: invokeinterface 270 1 0
    //   9: aload_0
    //   10: getfield 101	com/google/android/gms/common/package_12/internal/zabe:active	Ljava/util/Set;
    //   13: astore_3
    //   14: aload_3
    //   15: ifnonnull +23 -> 38
    //   18: ldc_w 552
    //   21: ldc_w 554
    //   24: new 556	java/lang/Exception
    //   27: dup
    //   28: invokespecial 557	java/lang/Exception:<init>	()V
    //   31: invokestatic 563	android/util/Log:wtf	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   34: pop
    //   35: goto +102 -> 137
    //   38: aload_3
    //   39: aload_1
    //   40: invokeinterface 565 2 0
    //   45: istore_2
    //   46: iload_2
    //   47: ifne +23 -> 70
    //   50: ldc_w 552
    //   53: ldc_w 567
    //   56: new 556	java/lang/Exception
    //   59: dup
    //   60: invokespecial 557	java/lang/Exception:<init>	()V
    //   63: invokestatic 563	android/util/Log:wtf	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   66: pop
    //   67: goto +70 -> 137
    //   70: aload_0
    //   71: getfield 112	com/google/android/gms/common/package_12/internal/zabe:lock	Ljava/util/concurrent/locks/Lock;
    //   74: invokeinterface 270 1 0
    //   79: aload_0
    //   80: getfield 101	com/google/android/gms/common/package_12/internal/zabe:active	Ljava/util/Set;
    //   83: astore_1
    //   84: aload_1
    //   85: ifnonnull +15 -> 100
    //   88: aload_0
    //   89: getfield 112	com/google/android/gms/common/package_12/internal/zabe:lock	Ljava/util/concurrent/locks/Lock;
    //   92: invokeinterface 277 1 0
    //   97: goto +25 -> 122
    //   100: aload_1
    //   101: invokeinterface 568 1 0
    //   106: istore_2
    //   107: aload_0
    //   108: getfield 112	com/google/android/gms/common/package_12/internal/zabe:lock	Ljava/util/concurrent/locks/Lock;
    //   111: invokeinterface 277 1 0
    //   116: iload_2
    //   117: iconst_1
    //   118: ixor
    //   119: ifne +18 -> 137
    //   122: aload_0
    //   123: getfield 66	com/google/android/gms/common/package_12/internal/zabe:this$0	Lcom/google/android/gms/common/package_12/internal/zaca;
    //   126: astore_1
    //   127: aload_1
    //   128: ifnull +9 -> 137
    //   131: aload_1
    //   132: invokeinterface 570 1 0
    //   137: aload_0
    //   138: getfield 112	com/google/android/gms/common/package_12/internal/zabe:lock	Ljava/util/concurrent/locks/Lock;
    //   141: invokeinterface 277 1 0
    //   146: return
    //   147: astore_1
    //   148: aload_0
    //   149: getfield 112	com/google/android/gms/common/package_12/internal/zabe:lock	Ljava/util/concurrent/locks/Lock;
    //   152: invokeinterface 277 1 0
    //   157: aload_1
    //   158: athrow
    //   159: astore_1
    //   160: aload_0
    //   161: getfield 112	com/google/android/gms/common/package_12/internal/zabe:lock	Ljava/util/concurrent/locks/Lock;
    //   164: invokeinterface 277 1 0
    //   169: aload_1
    //   170: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	171	0	this	zabe
    //   0	171	1	paramZada	zada
    //   45	74	2	bool	boolean
    //   13	26	3	localSet	Set
    // Exception table:
    //   from	to	target	type
    //   79	84	147	java/lang/Throwable
    //   100	107	147	java/lang/Throwable
    //   9	14	159	java/lang/Throwable
    //   18	35	159	java/lang/Throwable
    //   38	46	159	java/lang/Throwable
    //   50	67	159	java/lang/Throwable
    //   70	79	159	java/lang/Throwable
    //   88	97	159	java/lang/Throwable
    //   107	116	159	java/lang/Throwable
    //   122	127	159	java/lang/Throwable
    //   131	137	159	java/lang/Throwable
    //   148	159	159	java/lang/Throwable
  }
  
  public final com.google.android.gms.common.package_12.Api.Client getClient(com.google.android.gms.common.package_12.Api.AnyClientKey paramAnyClientKey)
  {
    paramAnyClientKey = (com.google.android.gms.common.package_12.Api.Client)data.get(paramAnyClientKey);
    Preconditions.checkNotNull(paramAnyClientKey, "Appropriate Api was not requested.");
    return paramAnyClientKey;
  }
  
  public final ConnectionResult getConnectionResult(Attribute paramAttribute)
  {
    lock.lock();
    try
    {
      boolean bool = isConnected();
      if (!bool)
      {
        bool = state;
        if (!bool) {
          throw new IllegalStateException("Cannot invoke getConnectionResult unless GoogleApiClient is connected");
        }
      }
      bool = data.containsKey(paramAttribute.getKey());
      if (bool)
      {
        ConnectionResult localConnectionResult = ((zaca)Preconditions.checkNotNull(this$0)).put(paramAttribute);
        if (localConnectionResult == null)
        {
          bool = state;
          if (bool) {
            localConnectionResult = ConnectionResult.RESULT_SUCCESS;
          }
          for (paramAttribute = lock;; paramAttribute = lock)
          {
            paramAttribute.unlock();
            return localConnectionResult;
            Log.w("GoogleApiClientImpl", getString());
            Log.wtf("GoogleApiClientImpl", String.valueOf(paramAttribute.get()).concat(" requested in getConnectionResult is not connected but is not present in the failed  connections map"), new Exception());
            localConnectionResult = new ConnectionResult(8, null);
          }
        }
        lock.unlock();
        return localConnectionResult;
      }
      throw new IllegalArgumentException(String.valueOf(paramAttribute.get()).concat(" was never registered with GoogleApiClient"));
    }
    catch (Throwable paramAttribute)
    {
      lock.unlock();
      throw paramAttribute;
    }
  }
  
  public final Context getContext()
  {
    return context;
  }
  
  public final Looper getLooper()
  {
    return key;
  }
  
  final String getString()
  {
    StringWriter localStringWriter = new StringWriter();
    dump("", null, new PrintWriter(localStringWriter), null);
    return localStringWriter.toString();
  }
  
  public final boolean hasApi(Attribute paramAttribute)
  {
    return data.containsKey(paramAttribute.getKey());
  }
  
  public final boolean hasConnectedApi(Attribute paramAttribute)
  {
    if (!isConnected()) {
      return false;
    }
    paramAttribute = (com.google.android.gms.common.package_12.Api.Client)data.get(paramAttribute.getKey());
    return (paramAttribute != null) && (paramAttribute.isConnected());
  }
  
  public final boolean isConnected()
  {
    zaca localZaca = this$0;
    return (localZaca != null) && (localZaca.isEmpty());
  }
  
  public final boolean isConnecting()
  {
    zaca localZaca = this$0;
    return (localZaca != null) && (localZaca.remove());
  }
  
  public final boolean isConnectionCallbacksRegistered(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    return delegate.write(paramConnectionCallbacks);
  }
  
  public final boolean isConnectionFailedListenerRegistered(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    return delegate.write(paramOnConnectionFailedListener);
  }
  
  public final boolean maybeSignIn(SignInConnectionListener paramSignInConnectionListener)
  {
    zaca localZaca = this$0;
    return (localZaca != null) && (localZaca.remove(paramSignInConnectionListener));
  }
  
  public final void maybeSignOut()
  {
    zaca localZaca = this$0;
    if (localZaca != null) {
      localZaca.connect();
    }
  }
  
  public final void reconnect()
  {
    disconnect();
    connect();
  }
  
  public final void registerConnectionCallbacks(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    delegate.close(paramConnectionCallbacks);
  }
  
  public final void registerConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    delegate.a(paramOnConnectionFailedListener);
  }
  
  public final ListenerHolder registerListener(Object paramObject)
  {
    lock.lock();
    try
    {
      paramObject = listeners.add(paramObject, key, "NO_TYPE");
      lock.unlock();
      return paramObject;
    }
    catch (Throwable paramObject)
    {
      lock.unlock();
      throw paramObject;
    }
  }
  
  final boolean release()
  {
    if (!state) {
      return false;
    }
    state = false;
    handler.removeMessages(2);
    handler.removeMessages(1);
    zabx localZabx = timer;
    if (localZabx != null)
    {
      localZabx.close();
      timer = null;
    }
    return true;
  }
  
  public final void run(int paramInt, boolean paramBoolean)
  {
    int i = paramInt;
    Context localContext;
    if (paramInt == 1) {
      if ((!paramBoolean) && (!state))
      {
        state = true;
        if ((timer == null) && (!ClientLibraryUtils.isPackageSide()))
        {
          localObject = type;
          localContext = context;
        }
      }
    }
    try
    {
      localContext = localContext.getApplicationContext();
      localObject = ((GoogleApiAvailability)localObject).start(localContext, new zabd(this));
      timer = ((zabx)localObject);
    }
    catch (SecurityException localSecurityException)
    {
      int j;
      for (;;) {}
    }
    Object localObject = handler;
    ((Handler)localObject).sendMessageDelayed(((Handler)localObject).obtainMessage(1), thread);
    localObject = handler;
    ((Handler)localObject).sendMessageDelayed(((Handler)localObject).obtainMessage(2), timeout);
    i = 1;
    localObject = log.data;
    paramInt = 0;
    localObject = (BasePendingResult[])((Set)localObject).toArray(new BasePendingResult[0]);
    j = localObject.length;
    while (paramInt < j)
    {
      localObject[paramInt].forceFailureUnlessReady(zadc.LOG_TAG);
      paramInt += 1;
    }
    delegate.a(i);
    delegate.write();
    if (i == 2)
    {
      clear();
      return;
    }
  }
  
  public final void run(Bundle paramBundle)
  {
    while (!queue.isEmpty()) {
      execute((BaseImplementation.ApiMethodImpl)queue.remove());
    }
    delegate.run(paramBundle);
  }
  
  public final void run(ConnectionResult paramConnectionResult)
  {
    if (!type.isPlayServicesPossiblyUpdating(context, paramConnectionResult.getErrorCode())) {
      release();
    }
    if (!state)
    {
      delegate.a(paramConnectionResult);
      delegate.write();
    }
  }
  
  public final void shutdown(zada paramZada)
  {
    lock.lock();
    try
    {
      Set localSet = active;
      if (localSet == null) {
        active = new HashSet();
      }
      active.add(paramZada);
      lock.unlock();
      return;
    }
    catch (Throwable paramZada)
    {
      lock.unlock();
      throw paramZada;
    }
  }
  
  public final void stopAutoManage(FragmentActivity paramFragmentActivity)
  {
    paramFragmentActivity = new LifecycleActivity(paramFragmentActivity);
    if (transactions >= 0)
    {
      MainActivity.removeTab(paramFragmentActivity).onCreate(transactions);
      return;
    }
    throw new IllegalStateException("Called stopAutoManage but automatic lifecycle management is not enabled.");
  }
  
  public final void unregisterConnectionCallbacks(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    delegate.add(paramConnectionCallbacks);
  }
  
  public final void unregisterConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    delegate.close(paramOnConnectionFailedListener);
  }
}
