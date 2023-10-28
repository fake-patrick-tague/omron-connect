package com.braze;

import com.braze.enums.BrazeDateFormat;
import com.braze.enums.Gender;
import com.braze.enums.Month;
import com.braze.enums.NotificationSubscriptionType;
import com.braze.support.BrazeLogger;
import com.braze.support.BrazeLogger.Priority;
import com.braze.support.DateTimeUtils;
import com.braze.support.ValidationUtils;
import java.util.Date;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.t;
import kotlin.text.g;
import kotlin.x.c.a;
import kotlin.x.d.i;
import protect.package_9.ClassWriter;
import protect.package_9.Direction;
import protect.package_9.MethodWriter;
import protect.package_9.b;
import protect.package_9.c;
import protect.package_9.k;
import protect.package_9.p;

public final class BrazeUser
{
  private final c brazeManager;
  private volatile String internalUserId;
  private final protect.package_9.j locationManager;
  private final k serverConfigStorageProvider;
  private final protect.package_9.JSONObject userCache;
  private final ReentrantLock userIdLock;
  
  public BrazeUser(protect.package_9.JSONObject paramJSONObject, c paramC, String paramString, protect.package_9.j paramJ, k paramK)
  {
    userCache = paramJSONObject;
    brazeManager = paramC;
    internalUserId = paramString;
    locationManager = paramJ;
    serverConfigStorageProvider = paramK;
    userIdLock = new ReentrantLock();
  }
  
  public final boolean addAlias(String paramString1, String paramString2)
  {
    i.e(paramString1, "alias");
    i.e(paramString2, "label");
    if (g.o(paramString1))
    {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, BrazeLogger.Priority.PREPARED, null, a.PLAYING, 2, null);
      return false;
    }
    if (g.o(paramString2))
    {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, BrazeLogger.Priority.PREPARED, null, b.cn, 2, null);
      return false;
    }
    Object localObject = ClassWriter.o;
    try
    {
      paramString2 = ((MethodWriter)localObject).d(paramString1, paramString2);
      if (paramString2 != null)
      {
        localObject = brazeManager;
        boolean bool = ((c)localObject).a(paramString2);
        return bool;
      }
    }
    catch (Exception paramString2)
    {
      BrazeLogger.INSTANCE.brazelog(this, BrazeLogger.Priority.this$0, paramString2, new c(paramString1));
    }
    return false;
  }
  
  public final boolean addToCustomAttributeArray(String paramString1, String paramString2)
  {
    i.e(paramString1, "key");
    i.e(paramString2, "value");
    Object localObject1 = serverConfigStorageProvider;
    try
    {
      boolean bool = b.b(paramString1, ((k)localObject1).getMediaItem());
      if (!bool)
      {
        paramString2 = BrazeLogger.INSTANCE;
        localObject1 = BrazeLogger.Priority.PREPARED;
        localObject2 = d.cn;
        BrazeLogger.brazelog$default(paramString2, this, (BrazeLogger.Priority)localObject1, null, (a)localObject2, 2, null);
        return false;
      }
      bool = b.c(paramString2);
      if (!bool) {
        return false;
      }
      localObject1 = ValidationUtils.ensureBrazeFieldLength(paramString1);
      paramString2 = ValidationUtils.ensureBrazeFieldLength(paramString2);
      Object localObject2 = ClassWriter.o;
      paramString2 = ((MethodWriter)localObject2).b((String)localObject1, paramString2);
      if (paramString2 == null) {
        return false;
      }
      localObject1 = brazeManager;
      bool = ((c)localObject1).a(paramString2);
      return bool;
    }
    catch (Exception paramString2)
    {
      BrazeLogger.INSTANCE.brazelog(this, BrazeLogger.Priority.PREPARED, paramString2, new e(paramString1));
    }
    return false;
  }
  
  public final boolean addToSubscriptionGroup(String paramString)
  {
    i.e(paramString, "subscriptionGroupId");
    try
    {
      boolean bool = g.o(paramString);
      if (bool)
      {
        localObject1 = BrazeLogger.INSTANCE;
        localObject2 = BrazeLogger.Priority.PREPARED;
        f localF = f.cn;
        BrazeLogger.brazelog$default((BrazeLogger)localObject1, this, (BrazeLogger.Priority)localObject2, null, localF, 2, null);
        return false;
      }
      Object localObject1 = ClassWriter.o;
      Object localObject2 = Direction.N;
      localObject1 = ((MethodWriter)localObject1).a(paramString, (Direction)localObject2);
      if (localObject1 != null)
      {
        localObject2 = brazeManager;
        ((c)localObject2).a((p)localObject1);
      }
      return true;
    }
    catch (Exception localException)
    {
      BrazeLogger.INSTANCE.brazelog(this, BrazeLogger.Priority.PREPARED, localException, new g(paramString));
    }
    return false;
  }
  
  public final String getUserId()
  {
    ReentrantLock localReentrantLock = userIdLock;
    localReentrantLock.lock();
    try
    {
      String str = internalUserId;
      localReentrantLock.unlock();
      return str;
    }
    catch (Throwable localThrowable)
    {
      localReentrantLock.unlock();
      throw localThrowable;
    }
  }
  
  public final boolean incrementCustomUserAttribute(String paramString, final int paramInt)
  {
    i.e(paramString, "key");
    Object localObject1 = serverConfigStorageProvider;
    try
    {
      boolean bool = b.b(paramString, ((k)localObject1).getMediaItem());
      if (!bool) {
        return false;
      }
      localObject1 = ValidationUtils.ensureBrazeFieldLength(paramString);
      Object localObject2 = ClassWriter.o;
      localObject1 = ((MethodWriter)localObject2).a((String)localObject1, paramInt);
      if (localObject1 == null) {
        return false;
      }
      localObject2 = brazeManager;
      bool = ((c)localObject2).a((p)localObject1);
      return bool;
    }
    catch (Exception localException)
    {
      BrazeLogger.INSTANCE.brazelog(this, BrazeLogger.Priority.PREPARED, localException, new h(paramString, paramInt));
    }
    return false;
  }
  
  public final boolean removeFromCustomAttributeArray(String paramString1, String paramString2)
  {
    i.e(paramString1, "key");
    i.e(paramString2, "value");
    Object localObject1 = serverConfigStorageProvider;
    try
    {
      boolean bool = b.b(paramString1, ((k)localObject1).getMediaItem());
      if (!bool)
      {
        paramString2 = BrazeLogger.INSTANCE;
        localObject1 = BrazeLogger.Priority.PREPARED;
        localObject2 = i.cn;
        BrazeLogger.brazelog$default(paramString2, this, (BrazeLogger.Priority)localObject1, null, (a)localObject2, 2, null);
        return false;
      }
      bool = b.c(paramString2);
      if (!bool) {
        return false;
      }
      localObject1 = ValidationUtils.ensureBrazeFieldLength(paramString1);
      paramString2 = ValidationUtils.ensureBrazeFieldLength(paramString2);
      Object localObject2 = ClassWriter.o;
      paramString2 = ((MethodWriter)localObject2).f((String)localObject1, paramString2);
      if (paramString2 == null) {
        return false;
      }
      localObject1 = brazeManager;
      bool = ((c)localObject1).a(paramString2);
      return bool;
    }
    catch (Exception paramString2)
    {
      BrazeLogger.INSTANCE.brazelog(this, BrazeLogger.Priority.PREPARED, paramString2, new j(paramString1));
    }
    return false;
  }
  
  public final boolean removeFromSubscriptionGroup(String paramString)
  {
    i.e(paramString, "subscriptionGroupId");
    try
    {
      boolean bool = g.o(paramString);
      if (bool)
      {
        localObject1 = BrazeLogger.INSTANCE;
        localObject2 = BrazeLogger.Priority.PREPARED;
        k localK = k.cn;
        BrazeLogger.brazelog$default((BrazeLogger)localObject1, this, (BrazeLogger.Priority)localObject2, null, localK, 2, null);
        return false;
      }
      Object localObject1 = ClassWriter.o;
      Object localObject2 = Direction.S;
      localObject1 = ((MethodWriter)localObject1).a(paramString, (Direction)localObject2);
      if (localObject1 != null)
      {
        localObject2 = brazeManager;
        ((c)localObject2).a((p)localObject1);
      }
      return true;
    }
    catch (Exception localException)
    {
      BrazeLogger.INSTANCE.brazelog(this, BrazeLogger.Priority.PREPARED, localException, new l(paramString));
    }
    return false;
  }
  
  public final boolean setCountry(String paramString)
  {
    if (paramString != null) {
      try
      {
        boolean bool = g.o(paramString);
        if (bool == true) {
          i = 1;
        }
      }
      catch (Exception localException)
      {
        break label74;
      }
    }
    int i = 0;
    if (i != 0)
    {
      localObject = BrazeLogger.INSTANCE;
      BrazeLogger.Priority localPriority = BrazeLogger.Priority.PREPARED;
      n localN = n.PLAYING;
      BrazeLogger.brazelog$default((BrazeLogger)localObject, this, localPriority, null, localN, 2, null);
      return false;
    }
    Object localObject = userCache;
    ((protect.package_9.JSONObject)localObject).onPostExecute(paramString);
    return true;
    label74:
    BrazeLogger.INSTANCE.brazelog(this, BrazeLogger.Priority.PREPARED, (Throwable)localObject, new o(paramString));
    return false;
  }
  
  public final boolean setCustomAttribute(String paramString, final Object paramObject, boolean paramBoolean)
  {
    i.e(paramString, "key");
    i.e(paramObject, "value");
    if (!b.b(paramString, serverConfigStorageProvider.getMediaItem()))
    {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, BrazeLogger.Priority.PREPARED, null, p.dd, 2, null);
      return false;
    }
    String str = ValidationUtils.ensureBrazeFieldLength(paramString);
    final Object localObject = b.a(b.c, paramObject, 0, 2, null);
    if (localObject == null)
    {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, BrazeLogger.Priority.PREPARED, null, new q(paramString, paramObject), 2, null);
      return false;
    }
    if (((localObject instanceof org.json.JSONObject)) && (paramBoolean))
    {
      paramString = ClassWriter.o.a(str, (org.json.JSONObject)localObject);
      if (paramString == null)
      {
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, BrazeLogger.Priority.PREPARED, null, new r(str, localObject), 2, null);
        return false;
      }
      return brazeManager.a(paramString);
    }
    return userCache.put(str, localObject);
  }
  
  public final boolean setCustomAttributeArray(String paramString, String[] paramArrayOfString)
  {
    i.e(paramString, "key");
    i.e(paramArrayOfString, "values");
    Object localObject = serverConfigStorageProvider;
    try
    {
      boolean bool = b.b(paramString, ((k)localObject).getMediaItem());
      if (!bool) {
        return false;
      }
      localObject = ValidationUtils.ensureBrazeFieldLength(paramString);
      paramArrayOfString = b.toArray(paramArrayOfString);
      MethodWriter localMethodWriter = ClassWriter.o;
      paramArrayOfString = localMethodWriter.a((String)localObject, paramArrayOfString);
      if (paramArrayOfString == null) {
        return false;
      }
      localObject = brazeManager;
      bool = ((c)localObject).a(paramArrayOfString);
      return bool;
    }
    catch (Exception paramArrayOfString)
    {
      BrazeLogger.INSTANCE.brazelog(this, BrazeLogger.Priority.PREPARED, paramArrayOfString, new s(paramString));
    }
    return false;
  }
  
  public final boolean setCustomAttributeToSecondsFromEpoch(String paramString, long paramLong)
  {
    i.e(paramString, "key");
    return setCustomAttribute$default(this, paramString, DateTimeUtils.createDate(paramLong), false, 4, null);
  }
  
  public final boolean setCustomUserAttribute(String paramString, double paramDouble)
  {
    i.e(paramString, "key");
    try
    {
      boolean bool = setCustomAttribute$default(this, paramString, Double.valueOf(paramDouble), false, 4, null);
      return bool;
    }
    catch (Exception localException)
    {
      BrazeLogger.INSTANCE.brazelog(this, BrazeLogger.Priority.PREPARED, localException, new y(paramString));
    }
    return false;
  }
  
  public final boolean setCustomUserAttribute(String paramString, float paramFloat)
  {
    i.e(paramString, "key");
    try
    {
      boolean bool = setCustomAttribute$default(this, paramString, Float.valueOf(paramFloat), false, 4, null);
      return bool;
    }
    catch (Exception localException)
    {
      BrazeLogger.INSTANCE.brazelog(this, BrazeLogger.Priority.PREPARED, localException, new v(paramString));
    }
    return false;
  }
  
  public final boolean setCustomUserAttribute(String paramString, int paramInt)
  {
    i.e(paramString, "key");
    try
    {
      boolean bool = setCustomAttribute$default(this, paramString, Integer.valueOf(paramInt), false, 4, null);
      return bool;
    }
    catch (Exception localException)
    {
      BrazeLogger.INSTANCE.brazelog(this, BrazeLogger.Priority.PREPARED, localException, new u(paramString));
    }
    return false;
  }
  
  public final boolean setCustomUserAttribute(String paramString, long paramLong)
  {
    i.e(paramString, "key");
    try
    {
      boolean bool = setCustomAttribute$default(this, paramString, Long.valueOf(paramLong), false, 4, null);
      return bool;
    }
    catch (Exception localException)
    {
      BrazeLogger.INSTANCE.brazelog(this, BrazeLogger.Priority.PREPARED, localException, new w(paramString));
    }
    return false;
  }
  
  public final boolean setCustomUserAttribute(String paramString1, String paramString2)
  {
    i.e(paramString1, "key");
    i.e(paramString2, "value");
    try
    {
      boolean bool = setCustomAttribute$default(this, paramString1, paramString2, false, 4, null);
      return bool;
    }
    catch (Exception paramString2)
    {
      BrazeLogger.INSTANCE.brazelog(this, BrazeLogger.Priority.PREPARED, paramString2, new x(paramString1));
    }
    return false;
  }
  
  public final boolean setCustomUserAttribute(String paramString, boolean paramBoolean)
  {
    i.e(paramString, "key");
    try
    {
      paramBoolean = setCustomAttribute$default(this, paramString, Boolean.valueOf(paramBoolean), false, 4, null);
      return paramBoolean;
    }
    catch (Exception localException)
    {
      BrazeLogger.INSTANCE.brazelog(this, BrazeLogger.Priority.PREPARED, localException, new t(paramString));
    }
    return false;
  }
  
  public final boolean setCustomUserAttributeToSecondsFromEpoch(String paramString, final long paramLong)
  {
    i.e(paramString, "key");
    try
    {
      boolean bool = setCustomAttributeToSecondsFromEpoch(paramString, paramLong);
      return bool;
    }
    catch (Exception localException)
    {
      BrazeLogger.INSTANCE.brazelog(this, BrazeLogger.Priority.PREPARED, localException, new c0(paramString, paramLong));
    }
    return false;
  }
  
  public final boolean setDateOfBirth(int paramInt1, final Month paramMonth, final int paramInt2)
  {
    i.e(paramMonth, "month");
    try
    {
      Object localObject1 = DateTimeUtils.createDate$default(paramInt1, paramMonth.getValue(), paramInt2, 0, 0, 0, 56, null);
      Object localObject2 = BrazeDateFormat.SHORT;
      localObject1 = DateTimeUtils.formatDate$default((Date)localObject1, (BrazeDateFormat)localObject2, null, 2, null);
      localObject2 = userCache;
      boolean bool = ((protect.package_9.JSONObject)localObject2).getIcon((String)localObject1);
      return bool;
    }
    catch (Exception localException)
    {
      BrazeLogger.INSTANCE.brazelog(this, BrazeLogger.Priority.PREPARED, localException, new d0(paramInt1, paramMonth, paramInt2));
    }
    return false;
  }
  
  public final boolean setEmail(String paramString)
  {
    if (paramString != null) {
      try
      {
        bool = g.o(paramString);
        if (bool == true) {
          i = 1;
        }
      }
      catch (Exception localException)
      {
        break label252;
      }
    }
    int i = 0;
    Object localObject1;
    if (i != 0)
    {
      localObject1 = BrazeLogger.INSTANCE;
      localObject2 = BrazeLogger.Priority.PREPARED;
      e0 localE0 = e0.PLAYING;
      BrazeLogger.brazelog$default((BrazeLogger)localObject1, this, (BrazeLogger.Priority)localObject2, null, localE0, 2, null);
      return false;
    }
    if (paramString != null)
    {
      i = paramString.length();
      i -= 1;
      int j = 0;
      int k = 0;
      while (j <= i)
      {
        if (k == 0) {
          m = j;
        } else {
          m = i;
        }
        int m = i.f(paramString.charAt(m), 32);
        if (m <= 0) {
          m = 1;
        } else {
          m = 0;
        }
        if (k == 0)
        {
          if (m == 0) {
            k = 1;
          } else {
            j += 1;
          }
        }
        else
        {
          if (m == 0) {
            break;
          }
          i -= 1;
        }
      }
      localObject1 = paramString.subSequence(j, i + 1).toString();
    }
    else
    {
      localObject1 = null;
    }
    if (localObject1 != null)
    {
      bool = ValidationUtils.isValidEmailAddress((String)localObject1);
      if (!bool)
      {
        localObject1 = BrazeLogger.INSTANCE;
        BrazeLogger.brazelog$default((BrazeLogger)localObject1, this, null, null, new f0(paramString), 3, null);
        return false;
      }
    }
    Object localObject2 = userCache;
    boolean bool = ((protect.package_9.JSONObject)localObject2).get((String)localObject1);
    return bool;
    label252:
    BrazeLogger.INSTANCE.brazelog(this, BrazeLogger.Priority.PREPARED, (Throwable)localObject1, new g0(paramString));
    return false;
  }
  
  public final boolean setEmailNotificationSubscriptionType(NotificationSubscriptionType paramNotificationSubscriptionType)
  {
    i.e(paramNotificationSubscriptionType, "emailNotificationSubscriptionType");
    protect.package_9.JSONObject localJSONObject = userCache;
    try
    {
      localJSONObject.writeValue(paramNotificationSubscriptionType);
      return true;
    }
    catch (Exception localException)
    {
      BrazeLogger.INSTANCE.brazelog(this, BrazeLogger.Priority.PREPARED, localException, new h0(paramNotificationSubscriptionType));
    }
    return false;
  }
  
  public final boolean setFirstName(String paramString)
  {
    if (paramString != null) {
      try
      {
        boolean bool = g.o(paramString);
        if (bool == true) {
          i = 1;
        }
      }
      catch (Exception localException)
      {
        break label74;
      }
    }
    int i = 0;
    if (i != 0)
    {
      localObject = BrazeLogger.INSTANCE;
      BrazeLogger.Priority localPriority = BrazeLogger.Priority.PREPARED;
      i0 localI0 = i0.PLAYING;
      BrazeLogger.brazelog$default((BrazeLogger)localObject, this, localPriority, null, localI0, 2, null);
      return false;
    }
    Object localObject = userCache;
    ((protect.package_9.JSONObject)localObject).increment(paramString);
    return true;
    label74:
    BrazeLogger.INSTANCE.brazelog(this, BrazeLogger.Priority.PREPARED, (Throwable)localObject, new j0(paramString));
    return false;
  }
  
  public final boolean setGender(Gender paramGender)
  {
    i.e(paramGender, "gender");
    protect.package_9.JSONObject localJSONObject = userCache;
    try
    {
      localJSONObject.writeValue(paramGender);
      return true;
    }
    catch (Exception localException)
    {
      BrazeLogger.INSTANCE.brazelog(this, BrazeLogger.Priority.PREPARED, localException, new k0(paramGender));
    }
    return false;
  }
  
  public final boolean setHomeCity(String paramString)
  {
    if (paramString != null) {
      try
      {
        boolean bool = g.o(paramString);
        if (bool == true) {
          i = 1;
        }
      }
      catch (Exception localException)
      {
        break label74;
      }
    }
    int i = 0;
    if (i != 0)
    {
      localObject = BrazeLogger.INSTANCE;
      BrazeLogger.Priority localPriority = BrazeLogger.Priority.PREPARED;
      l0 localL0 = l0.PLAYING;
      BrazeLogger.brazelog$default((BrazeLogger)localObject, this, localPriority, null, localL0, 2, null);
      return false;
    }
    Object localObject = userCache;
    ((protect.package_9.JSONObject)localObject).writeValue(paramString);
    return true;
    label74:
    BrazeLogger.INSTANCE.brazelog(this, BrazeLogger.Priority.PREPARED, (Throwable)localObject, new m0(paramString));
    return false;
  }
  
  public final boolean setLanguage(String paramString)
  {
    if (paramString != null) {
      try
      {
        boolean bool = g.o(paramString);
        if (bool == true) {
          i = 1;
        }
      }
      catch (Exception localException)
      {
        break label74;
      }
    }
    int i = 0;
    if (i != 0)
    {
      localObject = BrazeLogger.INSTANCE;
      BrazeLogger.Priority localPriority = BrazeLogger.Priority.PREPARED;
      n0 localN0 = n0.PLAYING;
      BrazeLogger.brazelog$default((BrazeLogger)localObject, this, localPriority, null, localN0, 2, null);
      return false;
    }
    Object localObject = userCache;
    ((protect.package_9.JSONObject)localObject).setLanguage(paramString);
    return true;
    label74:
    BrazeLogger.INSTANCE.brazelog(this, BrazeLogger.Priority.PREPARED, (Throwable)localObject, new o0(paramString));
    return false;
  }
  
  public final boolean setLastName(String paramString)
  {
    if (paramString != null) {
      try
      {
        boolean bool = g.o(paramString);
        if (bool == true) {
          i = 1;
        }
      }
      catch (Exception localException)
      {
        break label74;
      }
    }
    int i = 0;
    if (i != 0)
    {
      localObject = BrazeLogger.INSTANCE;
      BrazeLogger.Priority localPriority = BrazeLogger.Priority.PREPARED;
      q0 localQ0 = q0.PLAYING;
      BrazeLogger.brazelog$default((BrazeLogger)localObject, this, localPriority, null, localQ0, 2, null);
      return false;
    }
    Object localObject = userCache;
    ((protect.package_9.JSONObject)localObject).has(paramString);
    return true;
    label74:
    BrazeLogger.INSTANCE.brazelog(this, BrazeLogger.Priority.PREPARED, (Throwable)localObject, new r0(paramString));
    return false;
  }
  
  public final void setLocationCustomAttribute(String paramString, final double paramDouble1, double paramDouble2)
  {
    i.e(paramString, "key");
    Object localObject1 = serverConfigStorageProvider;
    try
    {
      boolean bool = b.b(paramString, ((k)localObject1).getMediaItem());
      if (!bool)
      {
        localObject1 = BrazeLogger.INSTANCE;
        localObject2 = BrazeLogger.Priority.PREPARED;
        s0 localS0 = s0.PLAYING;
        BrazeLogger.brazelog$default((BrazeLogger)localObject1, this, (BrazeLogger.Priority)localObject2, null, localS0, 2, null);
        return;
      }
      bool = ValidationUtils.isValidLocation(paramDouble1, paramDouble2);
      if (!bool)
      {
        localObject1 = BrazeLogger.INSTANCE;
        localObject2 = BrazeLogger.Priority.PREPARED;
        BrazeLogger.brazelog$default((BrazeLogger)localObject1, this, (BrazeLogger.Priority)localObject2, null, new t0(paramDouble1, paramDouble2), 2, null);
        return;
      }
      localObject1 = ValidationUtils.ensureBrazeFieldLength(paramString);
      Object localObject2 = ClassWriter.o;
      localObject1 = ((MethodWriter)localObject2).a((String)localObject1, paramDouble1, paramDouble2);
      if (localObject1 != null)
      {
        localObject2 = brazeManager;
        ((c)localObject2).a((p)localObject1);
        return;
      }
    }
    catch (Exception localException)
    {
      BrazeLogger.INSTANCE.brazelog(this, BrazeLogger.Priority.PREPARED, localException, new u0(paramString, paramDouble1, paramDouble2));
    }
  }
  
  public final boolean setPhoneNumber(String paramString)
  {
    if (paramString != null) {
      try
      {
        bool = g.o(paramString);
        if (bool == true) {
          i = 1;
        }
      }
      catch (Exception localException)
      {
        break label259;
      }
    }
    int i = 0;
    Object localObject1;
    Object localObject3;
    if (i != 0)
    {
      localObject1 = BrazeLogger.INSTANCE;
      localObject2 = BrazeLogger.Priority.PREPARED;
      localObject3 = v0.PLAYING;
      BrazeLogger.brazelog$default((BrazeLogger)localObject1, this, (BrazeLogger.Priority)localObject2, null, (a)localObject3, 2, null);
      return false;
    }
    if (paramString != null)
    {
      i = paramString.length();
      i -= 1;
      int j = 0;
      int k = 0;
      while (j <= i)
      {
        if (k == 0) {
          m = j;
        } else {
          m = i;
        }
        int m = i.f(paramString.charAt(m), 32);
        if (m <= 0) {
          m = 1;
        } else {
          m = 0;
        }
        if (k == 0)
        {
          if (m == 0) {
            k = 1;
          } else {
            j += 1;
          }
        }
        else
        {
          if (m == 0) {
            break;
          }
          i -= 1;
        }
      }
      localObject1 = paramString.subSequence(j, i + 1).toString();
    }
    else
    {
      localObject1 = null;
    }
    if (localObject1 != null)
    {
      bool = ValidationUtils.isValidPhoneNumber((String)localObject1);
      if (!bool)
      {
        localObject2 = BrazeLogger.INSTANCE;
        localObject3 = BrazeLogger.Priority.PREPARED;
        BrazeLogger.brazelog$default((BrazeLogger)localObject2, this, (BrazeLogger.Priority)localObject3, null, new w0((String)localObject1), 2, null);
        return false;
      }
    }
    Object localObject2 = userCache;
    boolean bool = ((protect.package_9.JSONObject)localObject2).put((String)localObject1);
    return bool;
    label259:
    BrazeLogger.INSTANCE.brazelog(this, BrazeLogger.Priority.PREPARED, (Throwable)localObject1, new x0(paramString));
    return false;
  }
  
  public final boolean setPushNotificationSubscriptionType(NotificationSubscriptionType paramNotificationSubscriptionType)
  {
    i.e(paramNotificationSubscriptionType, "pushNotificationSubscriptionType");
    protect.package_9.JSONObject localJSONObject = userCache;
    try
    {
      localJSONObject.getNames(paramNotificationSubscriptionType);
      return true;
    }
    catch (Exception localException)
    {
      BrazeLogger.INSTANCE.brazelog(this, BrazeLogger.Priority.PREPARED, localException, new y0(paramNotificationSubscriptionType));
    }
    return false;
  }
  
  public final void setUserId(String paramString)
  {
    i.e(paramString, "userId");
    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, BrazeLogger.Priority.$EnumSwitchMapping$0, null, new d1(paramString), 2, null);
    ReentrantLock localReentrantLock = userIdLock;
    localReentrantLock.lock();
    try
    {
      boolean bool = i.a(internalUserId, "");
      if (!bool)
      {
        bool = i.a(internalUserId, paramString);
        if (!bool)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("setExternalId can not be used to change the external ID of a UserCache from a non-empty value to a new value. Was: [");
          localStringBuilder.append(internalUserId);
          localStringBuilder.append("], tried to change to: [");
          localStringBuilder.append(paramString);
          localStringBuilder.append(']');
          throw new IllegalArgumentException(localStringBuilder.toString());
        }
      }
      internalUserId = paramString;
      userCache.set(paramString);
      paramString = t.a;
      localReentrantLock.unlock();
      return;
    }
    catch (Throwable paramString)
    {
      localReentrantLock.unlock();
      throw paramString;
    }
  }
  
  static final class a
    extends kotlin.x.d.j
    implements a<String>
  {
    public static final a PLAYING = new a();
    
    a()
    {
      super();
    }
    
    public final String getText()
    {
      return "Invalid alias parameter: alias is required to be non-null and non-empty. Not adding alias.";
    }
  }
  
  static final class b
    extends kotlin.x.d.j
    implements a<String>
  {
    public static final b cn = new b();
    
    b()
    {
      super();
    }
    
    public final String getText()
    {
      return "Invalid label parameter: label is required to be non-null and non-empty. Not adding alias.";
    }
  }
  
  static final class c
    extends kotlin.x.d.j
    implements a<String>
  {
    c(String paramString)
    {
      super();
    }
    
    public final String substring()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Failed to set alias: ");
      localStringBuilder.append(src);
      return localStringBuilder.toString();
    }
  }
  
  static final class c0
    extends kotlin.x.d.j
    implements a<String>
  {
    c0(String paramString, long paramLong)
    {
      super();
    }
    
    public final String doGet()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Failed to set custom attribute ");
      localStringBuilder.append(mUrlString);
      localStringBuilder.append(" to ");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(" seconds from epoch.");
      return localStringBuilder.toString();
    }
  }
  
  static final class d
    extends kotlin.x.d.j
    implements a<String>
  {
    public static final d cn = new d();
    
    d()
    {
      super();
    }
    
    public final String getText()
    {
      return "Custom attribute key was invalid. Not adding to attribute array.";
    }
  }
  
  static final class d0
    extends kotlin.x.d.j
    implements a<String>
  {
    d0(int paramInt1, Month paramMonth, int paramInt2)
    {
      super();
    }
    
    public final String encode()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Failed to set date of birth to: ");
      localStringBuilder.append(idx);
      localStringBuilder.append('-');
      localStringBuilder.append(paramMonth.getValue());
      localStringBuilder.append('-');
      localStringBuilder.append(paramInt2);
      return localStringBuilder.toString();
    }
  }
  
  static final class d1
    extends kotlin.x.d.j
    implements a<String>
  {
    d1(String paramString)
    {
      super();
    }
    
    public final String substring()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("User object user id set to: ");
      localStringBuilder.append(src);
      return localStringBuilder.toString();
    }
  }
  
  static final class e
    extends kotlin.x.d.j
    implements a<String>
  {
    e(String paramString)
    {
      super();
    }
    
    public final String extract()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Failed to add custom attribute with key '");
      localStringBuilder.append(dest);
      localStringBuilder.append("'.");
      return localStringBuilder.toString();
    }
  }
  
  static final class e0
    extends kotlin.x.d.j
    implements a<String>
  {
    public static final e0 PLAYING = new e0();
    
    e0()
    {
      super();
    }
    
    public final String getText()
    {
      return "Invalid email parameter: email is required to be non-empty. Not setting email.";
    }
  }
  
  static final class f
    extends kotlin.x.d.j
    implements a<String>
  {
    public static final f cn = new f();
    
    f()
    {
      super();
    }
    
    public final String getText()
    {
      return "Invalid subscription group ID: subscription group ID is required to be non-null and non-empty. Not adding user to subscription group.";
    }
  }
  
  static final class f0
    extends kotlin.x.d.j
    implements a<String>
  {
    f0(String paramString)
    {
      super();
    }
    
    public final String substring()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Email address is not valid: ");
      localStringBuilder.append(src);
      return localStringBuilder.toString();
    }
  }
  
  static final class g
    extends kotlin.x.d.j
    implements a<String>
  {
    g(String paramString)
    {
      super();
    }
    
    public final String substring()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Failed to add user to subscription group ");
      localStringBuilder.append(src);
      return localStringBuilder.toString();
    }
  }
  
  static final class g0
    extends kotlin.x.d.j
    implements a<String>
  {
    g0(String paramString)
    {
      super();
    }
    
    public final String substring()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Failed to set email to: ");
      localStringBuilder.append(src);
      return localStringBuilder.toString();
    }
  }
  
  static final class h
    extends kotlin.x.d.j
    implements a<String>
  {
    h(String paramString, int paramInt)
    {
      super();
    }
    
    public final String get()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Failed to increment custom attribute ");
      localStringBuilder.append(k);
      localStringBuilder.append(" by ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append('.');
      return localStringBuilder.toString();
    }
  }
  
  static final class h0
    extends kotlin.x.d.j
    implements a<String>
  {
    h0(NotificationSubscriptionType paramNotificationSubscriptionType)
    {
      super();
    }
    
    public final String substring()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Failed to set email notification subscription to: ");
      localStringBuilder.append(src);
      return localStringBuilder.toString();
    }
  }
  
  static final class i
    extends kotlin.x.d.j
    implements a<String>
  {
    public static final i cn = new i();
    
    i()
    {
      super();
    }
    
    public final String getText()
    {
      return "Custom attribute key was invalid. Not removing from attribute array.";
    }
  }
  
  static final class i0
    extends kotlin.x.d.j
    implements a<String>
  {
    public static final i0 PLAYING = new i0();
    
    i0()
    {
      super();
    }
    
    public final String getText()
    {
      return "Invalid first name parameter: first name is required to be non-empty. Not setting first name.";
    }
  }
  
  static final class j
    extends kotlin.x.d.j
    implements a<String>
  {
    j(String paramString)
    {
      super();
    }
    
    public final String extract()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Failed to remove custom attribute with key '");
      localStringBuilder.append(dest);
      localStringBuilder.append("'.");
      return localStringBuilder.toString();
    }
  }
  
  static final class j0
    extends kotlin.x.d.j
    implements a<String>
  {
    j0(String paramString)
    {
      super();
    }
    
    public final String substring()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Failed to set first name to: ");
      localStringBuilder.append(src);
      return localStringBuilder.toString();
    }
  }
  
  static final class k
    extends kotlin.x.d.j
    implements a<String>
  {
    public static final k cn = new k();
    
    k()
    {
      super();
    }
    
    public final String getText()
    {
      return "Invalid subscription group ID: subscription group ID is required to be non-null and non-empty. Not removing user from subscription group.";
    }
  }
  
  static final class k0
    extends kotlin.x.d.j
    implements a<String>
  {
    k0(Gender paramGender)
    {
      super();
    }
    
    public final String substring()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Failed to set gender to: ");
      localStringBuilder.append(arr);
      return localStringBuilder.toString();
    }
  }
  
  static final class l
    extends kotlin.x.d.j
    implements a<String>
  {
    l(String paramString)
    {
      super();
    }
    
    public final String substring()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Failed to remove user from subscription group ");
      localStringBuilder.append(src);
      return localStringBuilder.toString();
    }
  }
  
  static final class l0
    extends kotlin.x.d.j
    implements a<String>
  {
    public static final l0 PLAYING = new l0();
    
    l0()
    {
      super();
    }
    
    public final String getText()
    {
      return "Invalid home city parameter: home city is required to be non-blank. Not setting home city.";
    }
  }
  
  static final class m0
    extends kotlin.x.d.j
    implements a<String>
  {
    m0(String paramString)
    {
      super();
    }
    
    public final String substring()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Failed to set home city to: ");
      localStringBuilder.append(src);
      return localStringBuilder.toString();
    }
  }
  
  static final class n
    extends kotlin.x.d.j
    implements a<String>
  {
    public static final n PLAYING = new n();
    
    n()
    {
      super();
    }
    
    public final String getText()
    {
      return "Invalid country parameter: country is required to be non-blank. Not setting country.";
    }
  }
  
  static final class n0
    extends kotlin.x.d.j
    implements a<String>
  {
    public static final n0 PLAYING = new n0();
    
    n0()
    {
      super();
    }
    
    public final String getText()
    {
      return "Invalid language parameter: language is required to be non-empty. Not setting language.";
    }
  }
  
  static final class o
    extends kotlin.x.d.j
    implements a<String>
  {
    o(String paramString)
    {
      super();
    }
    
    public final String substring()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Failed to set country to: ");
      localStringBuilder.append(src);
      return localStringBuilder.toString();
    }
  }
  
  static final class o0
    extends kotlin.x.d.j
    implements a<String>
  {
    o0(String paramString)
    {
      super();
    }
    
    public final String substring()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Failed to set language to: ");
      localStringBuilder.append(src);
      return localStringBuilder.toString();
    }
  }
  
  static final class p
    extends kotlin.x.d.j
    implements a<String>
  {
    public static final p dd = new p();
    
    p()
    {
      super();
    }
    
    public final String getText()
    {
      return "Custom attribute key cannot be null.";
    }
  }
  
  static final class q
    extends kotlin.x.d.j
    implements a<String>
  {
    q(String paramString, Object paramObject)
    {
      super();
    }
    
    public final String request()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Could not add unsupported custom attribute value with key: ");
      localStringBuilder.append(mUserId);
      localStringBuilder.append(" and value: ");
      localStringBuilder.append(paramObject);
      return localStringBuilder.toString();
    }
  }
  
  static final class q0
    extends kotlin.x.d.j
    implements a<String>
  {
    public static final q0 PLAYING = new q0();
    
    q0()
    {
      super();
    }
    
    public final String getText()
    {
      return "Invalid last name parameter: last name is required to be non-empty. Not setting last name.";
    }
  }
  
  static final class r
    extends kotlin.x.d.j
    implements a<String>
  {
    r(String paramString, Object paramObject)
    {
      super();
    }
    
    public final String get()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Could not build NestedCustomAttributeEvent for key ");
      localStringBuilder.append(mTable);
      localStringBuilder.append(" and ");
      localStringBuilder.append(localObject);
      return localStringBuilder.toString();
    }
  }
  
  static final class r0
    extends kotlin.x.d.j
    implements a<String>
  {
    r0(String paramString)
    {
      super();
    }
    
    public final String substring()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Failed to set last name to: ");
      localStringBuilder.append(src);
      return localStringBuilder.toString();
    }
  }
  
  static final class s
    extends kotlin.x.d.j
    implements a<String>
  {
    s(String paramString)
    {
      super();
    }
    
    public final String extract()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Failed to set custom attribute array with key: '");
      localStringBuilder.append(dest);
      localStringBuilder.append("'.");
      return localStringBuilder.toString();
    }
  }
  
  static final class s0
    extends kotlin.x.d.j
    implements a<String>
  {
    public static final s0 PLAYING = new s0();
    
    s0()
    {
      super();
    }
    
    public final String getText()
    {
      return "Custom location attribute key was invalid. Not setting attribute.";
    }
  }
  
  static final class t
    extends kotlin.x.d.j
    implements a<String>
  {
    t(String paramString)
    {
      super();
    }
    
    public final String loadFile()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Failed to set custom boolean attribute ");
      localStringBuilder.append(configFile);
      localStringBuilder.append('.');
      return localStringBuilder.toString();
    }
  }
  
  static final class t0
    extends kotlin.x.d.j
    implements a<String>
  {
    t0(double paramDouble1, double paramDouble2)
    {
      super();
    }
    
    public final String extract()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Cannot set custom location attribute due with invalid latitude '");
      localStringBuilder.append(outputDir);
      localStringBuilder.append(" and longitude '");
      localStringBuilder.append(currentTime);
      localStringBuilder.append('\'');
      return localStringBuilder.toString();
    }
  }
  
  static final class u
    extends kotlin.x.d.j
    implements a<String>
  {
    u(String paramString)
    {
      super();
    }
    
    public final String loadFile()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Failed to set custom integer attribute ");
      localStringBuilder.append(configFile);
      localStringBuilder.append('.');
      return localStringBuilder.toString();
    }
  }
  
  static final class u0
    extends kotlin.x.d.j
    implements a<String>
  {
    u0(String paramString, double paramDouble1, double paramDouble2)
    {
      super();
    }
    
    public final String get()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Failed to set custom location attribute with key '");
      localStringBuilder.append(methodName);
      localStringBuilder.append("' and latitude '");
      localStringBuilder.append(paramDouble1);
      localStringBuilder.append("' and longitude '");
      localStringBuilder.append(payload);
      localStringBuilder.append('\'');
      return localStringBuilder.toString();
    }
  }
  
  static final class v
    extends kotlin.x.d.j
    implements a<String>
  {
    v(String paramString)
    {
      super();
    }
    
    public final String loadFile()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Failed to set custom float attribute ");
      localStringBuilder.append(configFile);
      localStringBuilder.append('.');
      return localStringBuilder.toString();
    }
  }
  
  static final class v0
    extends kotlin.x.d.j
    implements a<String>
  {
    public static final v0 PLAYING = new v0();
    
    v0()
    {
      super();
    }
    
    public final String getText()
    {
      return "Invalid phone number parameter: phone number is required to be non-empty. Not setting phone number.";
    }
  }
  
  static final class w
    extends kotlin.x.d.j
    implements a<String>
  {
    w(String paramString)
    {
      super();
    }
    
    public final String loadFile()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Failed to set custom long attribute ");
      localStringBuilder.append(configFile);
      localStringBuilder.append('.');
      return localStringBuilder.toString();
    }
  }
  
  static final class w0
    extends kotlin.x.d.j
    implements a<String>
  {
    w0(String paramString)
    {
      super();
    }
    
    public final String substring()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Phone number contains invalid characters (allowed are digits, spaces, or any of the following +.-()): ");
      localStringBuilder.append(src);
      return localStringBuilder.toString();
    }
  }
  
  static final class x
    extends kotlin.x.d.j
    implements a<String>
  {
    x(String paramString)
    {
      super();
    }
    
    public final String loadFile()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Failed to set custom string attribute ");
      localStringBuilder.append(configFile);
      localStringBuilder.append('.');
      return localStringBuilder.toString();
    }
  }
  
  static final class x0
    extends kotlin.x.d.j
    implements a<String>
  {
    x0(String paramString)
    {
      super();
    }
    
    public final String substring()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Failed to set phone number to: ");
      localStringBuilder.append(src);
      return localStringBuilder.toString();
    }
  }
  
  static final class y
    extends kotlin.x.d.j
    implements a<String>
  {
    y(String paramString)
    {
      super();
    }
    
    public final String loadFile()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Failed to set custom double attribute ");
      localStringBuilder.append(configFile);
      localStringBuilder.append('.');
      return localStringBuilder.toString();
    }
  }
  
  static final class y0
    extends kotlin.x.d.j
    implements a<String>
  {
    y0(NotificationSubscriptionType paramNotificationSubscriptionType)
    {
      super();
    }
    
    public final String substring()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Failed to set push notification subscription to: ");
      localStringBuilder.append(src);
      return localStringBuilder.toString();
    }
  }
}
