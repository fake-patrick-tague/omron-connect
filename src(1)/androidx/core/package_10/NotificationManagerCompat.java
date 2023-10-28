package androidx.core.package_10;

import android.app.AppOpsManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationChannelGroup;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageItemInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.BaseBundle;
import android.os.Build.VERSION;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.provider.Settings.Secure;
import android.support.v4.app.INotificationSideChannel;
import android.support.v4.app.INotificationSideChannel.Stub;
import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class NotificationManagerCompat
{
  public static final String ACTION_BIND_SIDE_CHANNEL = "android.support.BIND_NOTIFICATION_SIDE_CHANNEL";
  private static final String CHECK_OP_NO_THROW = "checkOpNoThrow";
  public static final String EXTRA_USE_SIDE_CHANNEL = "android.support.useSideChannel";
  public static final int IMPORTANCE_DEFAULT = 3;
  public static final int IMPORTANCE_HIGH = 4;
  public static final int IMPORTANCE_LOW = 2;
  public static final int IMPORTANCE_MAX = 5;
  public static final int IMPORTANCE_MIN = 1;
  public static final int IMPORTANCE_NONE = 0;
  public static final int IMPORTANCE_UNSPECIFIED = -1000;
  static final int MAX_SIDE_CHANNEL_SDK_VERSION = 19;
  private static final String OP_POST_NOTIFICATION = "OP_POST_NOTIFICATION";
  private static final String SETTING_ENABLED_NOTIFICATION_LISTENERS = "enabled_notification_listeners";
  private static final int SIDE_CHANNEL_RETRY_BASE_INTERVAL_MS = 1000;
  private static final int SIDE_CHANNEL_RETRY_MAX_COUNT = 6;
  private static final String TAG = "NotifManCompat";
  private static Set<String> sEnabledNotificationListenerPackages = new HashSet();
  private static String sEnabledNotificationListeners;
  private static final Object sEnabledNotificationListenersLock = new Object();
  private static final Object sLock = new Object();
  private static d sSideChannelManager;
  private final Context mContext;
  private final NotificationManager mNotificationManager;
  
  private NotificationManagerCompat(Context paramContext)
  {
    mContext = paramContext;
    mNotificationManager = ((NotificationManager)paramContext.getSystemService("notification"));
  }
  
  public static NotificationManagerCompat from(Context paramContext)
  {
    return new NotificationManagerCompat(paramContext);
  }
  
  public static Set getEnabledListenerPackages(Context paramContext)
  {
    Object localObject = Settings.Secure.getString(paramContext.getContentResolver(), "enabled_notification_listeners");
    paramContext = sEnabledNotificationListenersLock;
    if (localObject != null) {}
    for (;;)
    {
      int i;
      try
      {
        if (!((String)localObject).equals(sEnabledNotificationListeners))
        {
          String[] arrayOfString = ((String)localObject).split(":", -1);
          HashSet localHashSet = new HashSet(arrayOfString.length);
          int j = arrayOfString.length;
          i = 0;
          if (i < j)
          {
            ComponentName localComponentName = ComponentName.unflattenFromString(arrayOfString[i]);
            if (localComponentName != null) {
              localHashSet.add(localComponentName.getPackageName());
            }
          }
          else
          {
            sEnabledNotificationListenerPackages = localHashSet;
            sEnabledNotificationListeners = (String)localObject;
          }
        }
        else
        {
          localObject = sEnabledNotificationListenerPackages;
          return localObject;
        }
      }
      catch (Throwable localThrowable)
      {
        throw localThrowable;
      }
      i += 1;
    }
  }
  
  private void pushSideChannelQueue(e paramE)
  {
    Object localObject = sLock;
    try
    {
      if (sSideChannelManager == null) {
        sSideChannelManager = new d(mContext.getApplicationContext());
      }
      sSideChannelManager.queueTask(paramE);
      return;
    }
    catch (Throwable paramE)
    {
      throw paramE;
    }
  }
  
  private static boolean useSideChannelForNotification(Notification paramNotification)
  {
    paramNotification = NotificationCompat.getExtras(paramNotification);
    return (paramNotification != null) && (paramNotification.getBoolean("android.support.useSideChannel"));
  }
  
  public boolean areNotificationsEnabled()
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 24) {
      return mNotificationManager.areNotificationsEnabled();
    }
    if (i >= 19)
    {
      Object localObject1 = (AppOpsManager)mContext.getSystemService("appops");
      Object localObject2 = mContext.getApplicationInfo();
      String str = mContext.getApplicationContext().getPackageName();
      i = uid;
      try
      {
        Object localObject3 = Class.forName(AppOpsManager.class.getName());
        localObject2 = Integer.TYPE;
        localObject2 = ((Class)localObject3).getMethod("checkOpNoThrow", new Class[] { localObject2, localObject2, String.class });
        localObject3 = ((Class)localObject3).getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class);
        localObject3 = (Integer)localObject3;
        int j = ((Integer)localObject3).intValue();
        localObject1 = ((Method)localObject2).invoke(localObject1, new Object[] { Integer.valueOf(j), Integer.valueOf(i), str });
        localObject1 = (Integer)localObject1;
        i = ((Integer)localObject1).intValue();
        return i == 0;
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        return true;
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        return true;
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        return true;
      }
      catch (InvocationTargetException localInvocationTargetException)
      {
        return true;
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        return true;
      }
      catch (RuntimeException localRuntimeException) {}
    }
    return true;
  }
  
  public void cancel(int paramInt)
  {
    cancel(null, paramInt);
  }
  
  public void cancel(String paramString, int paramInt)
  {
    mNotificationManager.cancel(paramString, paramInt);
    if (Build.VERSION.SDK_INT <= 19) {
      pushSideChannelQueue(new a(mContext.getPackageName(), paramInt, paramString));
    }
  }
  
  public void cancelAll()
  {
    mNotificationManager.cancelAll();
    if (Build.VERSION.SDK_INT <= 19) {
      pushSideChannelQueue(new a(mContext.getPackageName()));
    }
  }
  
  public void createNotificationChannel(NotificationChannel paramNotificationChannel)
  {
    if (Build.VERSION.SDK_INT >= 26) {
      mNotificationManager.createNotificationChannel(paramNotificationChannel);
    }
  }
  
  public void createNotificationChannel(Switch paramSwitch)
  {
    createNotificationChannel(paramSwitch.a());
  }
  
  public void createNotificationChannelGroup(NotificationChannelGroup paramNotificationChannelGroup)
  {
    if (Build.VERSION.SDK_INT >= 26) {
      mNotificationManager.createNotificationChannelGroup(paramNotificationChannelGroup);
    }
  }
  
  public void createNotificationChannelGroup(b paramB)
  {
    createNotificationChannelGroup(paramB.a());
  }
  
  public void createNotificationChannelGroups(List paramList)
  {
    if (Build.VERSION.SDK_INT >= 26) {
      mNotificationManager.createNotificationChannelGroups(paramList);
    }
  }
  
  public void createNotificationChannelGroupsCompat(List paramList)
  {
    if ((Build.VERSION.SDK_INT >= 26) && (!paramList.isEmpty()))
    {
      ArrayList localArrayList = new ArrayList(paramList.size());
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        localArrayList.add(((b)paramList.next()).a());
      }
      mNotificationManager.createNotificationChannelGroups(localArrayList);
    }
  }
  
  public void createNotificationChannels(List paramList)
  {
    if (Build.VERSION.SDK_INT >= 26) {
      mNotificationManager.createNotificationChannels(paramList);
    }
  }
  
  public void createNotificationChannelsCompat(List paramList)
  {
    if ((Build.VERSION.SDK_INT >= 26) && (!paramList.isEmpty()))
    {
      ArrayList localArrayList = new ArrayList(paramList.size());
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        localArrayList.add(((Switch)paramList.next()).a());
      }
      mNotificationManager.createNotificationChannels(localArrayList);
    }
  }
  
  public void deleteNotificationChannel(String paramString)
  {
    if (Build.VERSION.SDK_INT >= 26) {
      mNotificationManager.deleteNotificationChannel(paramString);
    }
  }
  
  public void deleteNotificationChannelGroup(String paramString)
  {
    if (Build.VERSION.SDK_INT >= 26) {
      mNotificationManager.deleteNotificationChannelGroup(paramString);
    }
  }
  
  public void deleteUnlistedNotificationChannels(Collection paramCollection)
  {
    if (Build.VERSION.SDK_INT >= 26)
    {
      Iterator localIterator = mNotificationManager.getNotificationChannels().iterator();
      while (localIterator.hasNext())
      {
        NotificationChannel localNotificationChannel = (NotificationChannel)localIterator.next();
        if ((!paramCollection.contains(localNotificationChannel.getId())) && ((Build.VERSION.SDK_INT < 30) || (!paramCollection.contains(localNotificationChannel.getParentChannelId())))) {
          mNotificationManager.deleteNotificationChannel(localNotificationChannel.getId());
        }
      }
    }
  }
  
  public int getImportance()
  {
    if (Build.VERSION.SDK_INT >= 24) {
      return mNotificationManager.getImportance();
    }
    return 64536;
  }
  
  public NotificationChannel getNotificationChannel(String paramString)
  {
    if (Build.VERSION.SDK_INT >= 26) {
      return mNotificationManager.getNotificationChannel(paramString);
    }
    return null;
  }
  
  public NotificationChannel getNotificationChannel(String paramString1, String paramString2)
  {
    if (Build.VERSION.SDK_INT >= 30) {
      return mNotificationManager.getNotificationChannel(paramString1, paramString2);
    }
    return getNotificationChannel(paramString1);
  }
  
  public Switch getNotificationChannelCompat(String paramString)
  {
    if (Build.VERSION.SDK_INT >= 26)
    {
      paramString = getNotificationChannel(paramString);
      if (paramString != null) {
        return new Switch(paramString);
      }
    }
    return null;
  }
  
  public Switch getNotificationChannelCompat(String paramString1, String paramString2)
  {
    if (Build.VERSION.SDK_INT >= 26)
    {
      paramString1 = getNotificationChannel(paramString1, paramString2);
      if (paramString1 != null) {
        return new Switch(paramString1);
      }
    }
    return null;
  }
  
  public NotificationChannelGroup getNotificationChannelGroup(String paramString)
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 28) {
      return mNotificationManager.getNotificationChannelGroup(paramString);
    }
    if (i >= 26)
    {
      Iterator localIterator = getNotificationChannelGroups().iterator();
      while (localIterator.hasNext())
      {
        NotificationChannelGroup localNotificationChannelGroup = (NotificationChannelGroup)localIterator.next();
        if (localNotificationChannelGroup.getId().equals(paramString)) {
          return localNotificationChannelGroup;
        }
      }
    }
    return null;
  }
  
  public b getNotificationChannelGroupCompat(String paramString)
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 28)
    {
      paramString = getNotificationChannelGroup(paramString);
      if (paramString != null) {
        return new b(paramString);
      }
    }
    else if (i >= 26)
    {
      paramString = getNotificationChannelGroup(paramString);
      if (paramString != null) {
        return new b(paramString, getNotificationChannels());
      }
    }
    return null;
  }
  
  public List getNotificationChannelGroups()
  {
    if (Build.VERSION.SDK_INT >= 26) {
      return mNotificationManager.getNotificationChannelGroups();
    }
    return Collections.emptyList();
  }
  
  public List getNotificationChannelGroupsCompat()
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 26)
    {
      Object localObject = getNotificationChannelGroups();
      if (!((List)localObject).isEmpty())
      {
        List localList;
        if (i >= 28) {
          localList = Collections.emptyList();
        } else {
          localList = getNotificationChannels();
        }
        ArrayList localArrayList = new ArrayList(((List)localObject).size());
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          NotificationChannelGroup localNotificationChannelGroup = (NotificationChannelGroup)((Iterator)localObject).next();
          if (Build.VERSION.SDK_INT >= 28) {
            localArrayList.add(new b(localNotificationChannelGroup));
          } else {
            localArrayList.add(new b(localNotificationChannelGroup, localList));
          }
        }
        return localArrayList;
      }
    }
    return Collections.emptyList();
  }
  
  public List getNotificationChannels()
  {
    if (Build.VERSION.SDK_INT >= 26) {
      return mNotificationManager.getNotificationChannels();
    }
    return Collections.emptyList();
  }
  
  public List getNotificationChannelsCompat()
  {
    if (Build.VERSION.SDK_INT >= 26)
    {
      Object localObject = getNotificationChannels();
      if (!((List)localObject).isEmpty())
      {
        ArrayList localArrayList = new ArrayList(((List)localObject).size());
        localObject = ((List)localObject).iterator();
        while (((Iterator)localObject).hasNext()) {
          localArrayList.add(new Switch((NotificationChannel)((Iterator)localObject).next()));
        }
        return localArrayList;
      }
    }
    return Collections.emptyList();
  }
  
  public void notify(int paramInt, Notification paramNotification)
  {
    notify(null, paramInt, paramNotification);
  }
  
  public void notify(String paramString, int paramInt, Notification paramNotification)
  {
    if (useSideChannelForNotification(paramNotification))
    {
      pushSideChannelQueue(new b(mContext.getPackageName(), paramInt, paramString, paramNotification));
      mNotificationManager.cancel(paramString, paramInt);
      return;
    }
    mNotificationManager.notify(paramString, paramInt, paramNotification);
  }
  
  class a
    implements NotificationManagerCompat.e
  {
    final boolean all;
    final int id;
    final String tag;
    
    a()
    {
      id = 0;
      tag = null;
      all = true;
    }
    
    a(int paramInt, String paramString)
    {
      id = paramInt;
      tag = paramString;
      all = false;
    }
    
    public void send(INotificationSideChannel paramINotificationSideChannel)
      throws RemoteException
    {
      if (all)
      {
        paramINotificationSideChannel.cancelAll(NotificationManagerCompat.this);
        return;
      }
      paramINotificationSideChannel.cancel(NotificationManagerCompat.this, id, tag);
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder("CancelTask[");
      localStringBuilder.append("packageName:");
      localStringBuilder.append(NotificationManagerCompat.this);
      localStringBuilder.append(", id:");
      localStringBuilder.append(id);
      localStringBuilder.append(", tag:");
      localStringBuilder.append(tag);
      localStringBuilder.append(", all:");
      localStringBuilder.append(all);
      localStringBuilder.append("]");
      return localStringBuilder.toString();
    }
  }
  
  class b
    implements NotificationManagerCompat.e
  {
    final int id;
    final Notification notif;
    final String tag;
    
    b(int paramInt, String paramString, Notification paramNotification)
    {
      id = paramInt;
      tag = paramString;
      notif = paramNotification;
    }
    
    public void send(INotificationSideChannel paramINotificationSideChannel)
      throws RemoteException
    {
      paramINotificationSideChannel.notify(NotificationManagerCompat.this, id, tag, notif);
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder("NotifyTask[");
      localStringBuilder.append("packageName:");
      localStringBuilder.append(NotificationManagerCompat.this);
      localStringBuilder.append(", id:");
      localStringBuilder.append(id);
      localStringBuilder.append(", tag:");
      localStringBuilder.append(tag);
      localStringBuilder.append("]");
      return localStringBuilder.toString();
    }
  }
  
  class c
  {
    final IBinder iBinder;
    
    c(IBinder paramIBinder)
    {
      iBinder = paramIBinder;
    }
  }
  
  class d
    implements Handler.Callback, ServiceConnection
  {
    private Set<String> mCachedEnabledPackages = new HashSet();
    private final Handler mHandler;
    private final HandlerThread mHandlerThread;
    private final Map<ComponentName, androidx.core.app.NotificationManagerCompat.d.a> mRecordMap = new HashMap();
    
    d()
    {
      this$1 = new HandlerThread("NotificationManagerCompat");
      mHandlerThread = NotificationManagerCompat.this;
      start();
      mHandler = new Handler(getLooper(), this);
    }
    
    private boolean ensureServiceBound(a paramA)
    {
      if (bound) {
        return true;
      }
      Object localObject = new Intent("android.support.BIND_NOTIFICATION_SIDE_CHANNEL").setComponent(componentName);
      boolean bool = bindService((Intent)localObject, this, 33);
      bound = bool;
      if (bool)
      {
        retryCount = 0;
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Unable to bind to listener ");
        ((StringBuilder)localObject).append(componentName);
        Log.w("NotifManCompat", ((StringBuilder)localObject).toString());
        unbindService(this);
      }
      return bound;
    }
    
    private void ensureServiceUnbound(a paramA)
    {
      if (bound)
      {
        unbindService(this);
        bound = false;
      }
      service = null;
    }
    
    private void handleQueueTask(NotificationManagerCompat.e paramE)
    {
      updateListenerMap();
      Iterator localIterator = mRecordMap.values().iterator();
      while (localIterator.hasNext())
      {
        a localA = (a)localIterator.next();
        taskQueue.add(paramE);
        processListenerQueue(localA);
      }
    }
    
    private void handleRetryListenerQueue(ComponentName paramComponentName)
    {
      paramComponentName = (a)mRecordMap.get(paramComponentName);
      if (paramComponentName != null) {
        processListenerQueue(paramComponentName);
      }
    }
    
    private void handleServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
    {
      paramComponentName = (a)mRecordMap.get(paramComponentName);
      if (paramComponentName != null)
      {
        service = INotificationSideChannel.Stub.asInterface(paramIBinder);
        retryCount = 0;
        processListenerQueue(paramComponentName);
      }
    }
    
    private void handleServiceDisconnected(ComponentName paramComponentName)
    {
      paramComponentName = (a)mRecordMap.get(paramComponentName);
      if (paramComponentName != null) {
        ensureServiceUnbound(paramComponentName);
      }
    }
    
    private void processListenerQueue(a paramA)
    {
      Object localObject1;
      if (Log.isLoggable("NotifManCompat", 3))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("Processing component ");
        ((StringBuilder)localObject1).append(componentName);
        ((StringBuilder)localObject1).append(", ");
        ((StringBuilder)localObject1).append(taskQueue.size());
        ((StringBuilder)localObject1).append(" queued tasks");
        Log.d("NotifManCompat", ((StringBuilder)localObject1).toString());
      }
      if (taskQueue.isEmpty()) {
        return;
      }
      if ((ensureServiceBound(paramA)) && (service != null)) {}
      for (;;)
      {
        localObject1 = (NotificationManagerCompat.e)taskQueue.peek();
        if (localObject1 != null) {}
        try
        {
          boolean bool = Log.isLoggable("NotifManCompat", 3);
          if (bool)
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("Sending task ");
            ((StringBuilder)localObject2).append(localObject1);
            Log.d("NotifManCompat", ((StringBuilder)localObject2).toString());
          }
          localObject2 = service;
          ((NotificationManagerCompat.e)localObject1).send((INotificationSideChannel)localObject2);
          localObject1 = taskQueue;
          ((ArrayDeque)localObject1).remove();
        }
        catch (RemoteException localRemoteException)
        {
          Object localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("RemoteException communicating with ");
          ((StringBuilder)localObject2).append(componentName);
          Log.w("NotifManCompat", ((StringBuilder)localObject2).toString(), localRemoteException);
          break label275;
          if (Log.isLoggable("NotifManCompat", 3))
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("Remote service has died: ");
            localStringBuilder.append(componentName);
            Log.d("NotifManCompat", localStringBuilder.toString());
          }
          if (!taskQueue.isEmpty())
          {
            scheduleListenerRetry(paramA);
            return;
            scheduleListenerRetry(paramA);
            return;
          }
        }
        catch (DeadObjectException localDeadObjectException)
        {
          label275:
          for (;;) {}
        }
      }
    }
    
    private void scheduleListenerRetry(a paramA)
    {
      if (mHandler.hasMessages(3, componentName)) {
        return;
      }
      int i = retryCount + 1;
      retryCount = i;
      StringBuilder localStringBuilder;
      if (i > 6)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("Giving up on delivering ");
        localStringBuilder.append(taskQueue.size());
        localStringBuilder.append(" tasks to ");
        localStringBuilder.append(componentName);
        localStringBuilder.append(" after ");
        localStringBuilder.append(retryCount);
        localStringBuilder.append(" retries");
        Log.w("NotifManCompat", localStringBuilder.toString());
        taskQueue.clear();
        return;
      }
      i = (1 << i - 1) * 1000;
      if (Log.isLoggable("NotifManCompat", 3))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("Scheduling retry for ");
        localStringBuilder.append(i);
        localStringBuilder.append(" ms");
        Log.d("NotifManCompat", localStringBuilder.toString());
      }
      paramA = mHandler.obtainMessage(3, componentName);
      mHandler.sendMessageDelayed(paramA, i);
    }
    
    private void updateListenerMap()
    {
      Object localObject1 = NotificationManagerCompat.getEnabledListenerPackages(NotificationManagerCompat.this);
      if (((Set)localObject1).equals(mCachedEnabledPackages)) {
        return;
      }
      mCachedEnabledPackages = ((Set)localObject1);
      Object localObject2 = getPackageManager().queryIntentServices(new Intent().setAction("android.support.BIND_NOTIFICATION_SIDE_CHANNEL"), 0);
      HashSet localHashSet = new HashSet();
      localObject2 = ((List)localObject2).iterator();
      Object localObject3;
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (ResolveInfo)((Iterator)localObject2).next();
        if (((Set)localObject1).contains(serviceInfo.packageName))
        {
          Object localObject4 = serviceInfo;
          localObject4 = new ComponentName(packageName, name);
          if (serviceInfo.permission != null)
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("Permission present on component ");
            ((StringBuilder)localObject3).append(localObject4);
            ((StringBuilder)localObject3).append(", not adding listener record.");
            Log.w("NotifManCompat", ((StringBuilder)localObject3).toString());
          }
          else
          {
            localHashSet.add(localObject4);
          }
        }
      }
      localObject1 = localHashSet.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ComponentName)((Iterator)localObject1).next();
        if (!mRecordMap.containsKey(localObject2))
        {
          if (Log.isLoggable("NotifManCompat", 3))
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("Adding listener record for ");
            ((StringBuilder)localObject3).append(localObject2);
            Log.d("NotifManCompat", ((StringBuilder)localObject3).toString());
          }
          mRecordMap.put(localObject2, new a((ComponentName)localObject2));
        }
      }
      localObject1 = mRecordMap.entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        if (!localHashSet.contains(((Map.Entry)localObject2).getKey()))
        {
          if (Log.isLoggable("NotifManCompat", 3))
          {
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("Removing listener record for ");
            ((StringBuilder)localObject3).append(((Map.Entry)localObject2).getKey());
            Log.d("NotifManCompat", ((StringBuilder)localObject3).toString());
          }
          ensureServiceUnbound((a)((Map.Entry)localObject2).getValue());
          ((Iterator)localObject1).remove();
        }
      }
    }
    
    public boolean handleMessage(Message paramMessage)
    {
      int i = what;
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 2)
          {
            if (i != 3) {
              return false;
            }
            handleRetryListenerQueue((ComponentName)obj);
            return true;
          }
          handleServiceDisconnected((ComponentName)obj);
          return true;
        }
        paramMessage = (NotificationManagerCompat.c)obj;
        handleServiceConnected(componentName, iBinder);
        return true;
      }
      handleQueueTask((NotificationManagerCompat.e)obj);
      return true;
    }
    
    public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
    {
      if (Log.isLoggable("NotifManCompat", 3))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Connected to service ");
        localStringBuilder.append(paramComponentName);
        Log.d("NotifManCompat", localStringBuilder.toString());
      }
      mHandler.obtainMessage(1, new NotificationManagerCompat.c(paramComponentName, paramIBinder)).sendToTarget();
    }
    
    public void onServiceDisconnected(ComponentName paramComponentName)
    {
      if (Log.isLoggable("NotifManCompat", 3))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Disconnected from service ");
        localStringBuilder.append(paramComponentName);
        Log.d("NotifManCompat", localStringBuilder.toString());
      }
      mHandler.obtainMessage(2, paramComponentName).sendToTarget();
    }
    
    public void queueTask(NotificationManagerCompat.e paramE)
    {
      mHandler.obtainMessage(0, paramE).sendToTarget();
    }
    
    class a
    {
      boolean bound = false;
      int retryCount = 0;
      INotificationSideChannel service;
      ArrayDeque<androidx.core.app.NotificationManagerCompat.e> taskQueue = new ArrayDeque();
      
      a() {}
    }
  }
  
  abstract interface e
  {
    public abstract void send(INotificationSideChannel paramINotificationSideChannel)
      throws RemoteException;
  }
}
