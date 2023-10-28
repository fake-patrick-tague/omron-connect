package com.braze.ui.inappmessage.jsinterface;

import android.content.Context;
import com.braze.Braze;
import com.braze.Braze.Companion;
import com.braze.BrazeUser;
import com.braze.enums.Gender;
import com.braze.enums.Month;
import com.braze.enums.Month.Companion;
import com.braze.enums.NotificationSubscriptionType;
import com.braze.enums.NotificationSubscriptionType.Companion;
import com.braze.support.BrazeLogger;
import com.braze.support.BrazeLogger.Priority;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;
import kotlin.t;
import kotlin.x.c.a;
import kotlin.x.c.l;
import kotlin.x.d.i;
import kotlin.x.d.j;
import org.json.JSONArray;
import org.json.JSONObject;

public final class InAppMessageUserJavascriptInterface
{
  public static final Companion Companion = new Companion(null);
  private final Context context;
  
  public InAppMessageUserJavascriptInterface(Context paramContext)
  {
    context = paramContext;
  }
  
  public final void addAlias(String paramString1, final String paramString2)
  {
    i.e(paramString1, "alias");
    i.e(paramString2, "label");
    Companion.access$runOnUser(Companion, Braze.Companion.getInstance(context), new j(paramString1)
    {
      public final void invoke(BrazeUser paramAnonymousBrazeUser)
      {
        i.e(paramAnonymousBrazeUser, "it");
        paramAnonymousBrazeUser.addAlias(InAppMessageUserJavascriptInterface.this, paramString2);
      }
    });
  }
  
  public final void addToCustomAttributeArray(String paramString1, final String paramString2)
  {
    i.e(paramString1, "key");
    i.e(paramString2, "value");
    Companion.access$runOnUser(Companion, Braze.Companion.getInstance(context), new j(paramString1)
    {
      public final void invoke(BrazeUser paramAnonymousBrazeUser)
      {
        i.e(paramAnonymousBrazeUser, "it");
        paramAnonymousBrazeUser.addToCustomAttributeArray(InAppMessageUserJavascriptInterface.this, paramString2);
      }
    });
  }
  
  public final void addToSubscriptionGroup(String paramString)
  {
    i.e(paramString, "subscriptionGroupId");
    Companion.access$runOnUser(Companion, Braze.Companion.getInstance(context), new j(paramString)
    {
      public final void invoke(BrazeUser paramAnonymousBrazeUser)
      {
        i.e(paramAnonymousBrazeUser, "it");
        paramAnonymousBrazeUser.addToSubscriptionGroup(InAppMessageUserJavascriptInterface.this);
      }
    });
  }
  
  public final void incrementCustomUserAttribute(String paramString)
  {
    i.e(paramString, "attribute");
    Companion.access$runOnUser(Companion, Braze.Companion.getInstance(context), new j(paramString)
    {
      public final void invoke(BrazeUser paramAnonymousBrazeUser)
      {
        i.e(paramAnonymousBrazeUser, "it");
        BrazeUser.incrementCustomUserAttribute$default(paramAnonymousBrazeUser, InAppMessageUserJavascriptInterface.this, 0, 2, null);
      }
    });
  }
  
  public final Month monthFromInt(int paramInt)
  {
    if ((paramInt >= 1) && (paramInt <= 12)) {
      return Month.Companion.getMonth(paramInt - 1);
    }
    return null;
  }
  
  public final Gender parseGender(String paramString)
  {
    i.e(paramString, "genderString");
    Object localObject = Locale.US;
    i.d(localObject, "US");
    paramString = paramString.toLowerCase((Locale)localObject);
    i.d(paramString, "this as java.lang.String).toLowerCase(locale)");
    localObject = Gender.MALE;
    if (i.a(paramString, ((Gender)localObject).forJsonPut())) {
      return localObject;
    }
    localObject = Gender.FEMALE;
    if (i.a(paramString, ((Gender)localObject).forJsonPut())) {
      return localObject;
    }
    localObject = Gender.OTHER;
    if (i.a(paramString, ((Gender)localObject).forJsonPut())) {
      return localObject;
    }
    localObject = Gender.UNKNOWN;
    if (i.a(paramString, ((Gender)localObject).forJsonPut())) {
      return localObject;
    }
    localObject = Gender.NOT_APPLICABLE;
    if (i.a(paramString, ((Gender)localObject).forJsonPut())) {
      return localObject;
    }
    localObject = Gender.PREFER_NOT_TO_SAY;
    if (i.a(paramString, ((Gender)localObject).forJsonPut())) {
      return localObject;
    }
    return null;
  }
  
  public final String[] parseStringArrayFromJsonString(String paramString)
  {
    try
    {
      paramString = new JSONArray(paramString);
      int j = paramString.length();
      ArrayList localArrayList = new ArrayList(j);
      int i = 0;
      while (i < j)
      {
        localArrayList.add(paramString.getString(i));
        i += 1;
      }
      paramString = localArrayList.toArray(new String[0]);
      if (paramString != null) {
        return (String[])paramString;
      }
      paramString = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
      throw paramString;
    }
    catch (Exception paramString)
    {
      BrazeLogger.INSTANCE.brazelog(this, BrazeLogger.Priority.this$0, paramString, parseStringArrayFromJsonString.2.INSTANCE);
    }
    return null;
  }
  
  public final void removeFromCustomAttributeArray(String paramString1, final String paramString2)
  {
    i.e(paramString1, "key");
    i.e(paramString2, "value");
    Companion.access$runOnUser(Companion, Braze.Companion.getInstance(context), new j(paramString1)
    {
      public final void invoke(BrazeUser paramAnonymousBrazeUser)
      {
        i.e(paramAnonymousBrazeUser, "it");
        paramAnonymousBrazeUser.removeFromCustomAttributeArray(InAppMessageUserJavascriptInterface.this, paramString2);
      }
    });
  }
  
  public final void removeFromSubscriptionGroup(String paramString)
  {
    i.e(paramString, "subscriptionGroupId");
    Companion.access$runOnUser(Companion, Braze.Companion.getInstance(context), new j(paramString)
    {
      public final void invoke(BrazeUser paramAnonymousBrazeUser)
      {
        i.e(paramAnonymousBrazeUser, "it");
        paramAnonymousBrazeUser.removeFromSubscriptionGroup(InAppMessageUserJavascriptInterface.this);
      }
    });
  }
  
  public final void setCountry(String paramString)
  {
    Companion.access$runOnUser(Companion, Braze.Companion.getInstance(context), new j(paramString)
    {
      public final void invoke(BrazeUser paramAnonymousBrazeUser)
      {
        i.e(paramAnonymousBrazeUser, "it");
        paramAnonymousBrazeUser.setCountry(InAppMessageUserJavascriptInterface.this);
      }
    });
  }
  
  public final void setCustomAttribute(BrazeUser paramBrazeUser, String paramString1, final String paramString2)
  {
    i.e(paramBrazeUser, "user");
    i.e(paramString1, "key");
    i.e(paramString2, "jsonStringValue");
    try
    {
      Object localObject = new JSONObject(paramString2).get("value");
      if ((localObject instanceof String))
      {
        localObject = (String)localObject;
        paramBrazeUser.setCustomUserAttribute(paramString1, (String)localObject);
        return;
      }
      if ((localObject instanceof Boolean))
      {
        localObject = (Boolean)localObject;
        paramBrazeUser.setCustomUserAttribute(paramString1, ((Boolean)localObject).booleanValue());
        return;
      }
      if ((localObject instanceof Integer))
      {
        localObject = (Number)localObject;
        paramBrazeUser.setCustomUserAttribute(paramString1, ((Number)localObject).intValue());
        return;
      }
      if ((localObject instanceof Double))
      {
        localObject = (Number)localObject;
        paramBrazeUser.setCustomUserAttribute(paramString1, ((Number)localObject).doubleValue());
        return;
      }
      paramBrazeUser = BrazeLogger.INSTANCE;
      localObject = BrazeLogger.Priority.PREPARED;
      BrazeLogger.brazelog$default(paramBrazeUser, this, (BrazeLogger.Priority)localObject, null, new j(paramString1)
      {
        public final String invoke()
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Failed to parse custom attribute type for key: ");
          localStringBuilder.append(InAppMessageUserJavascriptInterface.this);
          localStringBuilder.append(" and json string value: ");
          localStringBuilder.append(paramString2);
          return localStringBuilder.toString();
        }
      }, 2, null);
      return;
    }
    catch (Exception paramBrazeUser)
    {
      BrazeLogger.INSTANCE.brazelog(this, BrazeLogger.Priority.this$0, paramBrazeUser, new j(paramString1)
      {
        public final String invoke()
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Failed to parse custom attribute type for key: ");
          localStringBuilder.append(InAppMessageUserJavascriptInterface.this);
          localStringBuilder.append(" and json string value: ");
          localStringBuilder.append(paramString2);
          return localStringBuilder.toString();
        }
      });
    }
  }
  
  public final void setCustomLocationAttribute(String paramString, final double paramDouble1, double paramDouble2)
  {
    i.e(paramString, "attribute");
    Companion.access$runOnUser(Companion, Braze.Companion.getInstance(context), new j(paramString)
    {
      public final void invoke(BrazeUser paramAnonymousBrazeUser)
      {
        i.e(paramAnonymousBrazeUser, "it");
        paramAnonymousBrazeUser.setLocationCustomAttribute(InAppMessageUserJavascriptInterface.this, paramDouble1, $longitude);
      }
    });
  }
  
  public final void setCustomUserAttributeArray(String paramString1, final String paramString2)
  {
    i.e(paramString1, "key");
    paramString2 = parseStringArrayFromJsonString(paramString2);
    if (paramString2 == null)
    {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, BrazeLogger.Priority.PREPARED, null, new j(paramString1)
      {
        public final String invoke()
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Failed to set custom attribute array for key ");
          localStringBuilder.append(InAppMessageUserJavascriptInterface.this);
          return localStringBuilder.toString();
        }
      }, 2, null);
      return;
    }
    Companion.access$runOnUser(Companion, Braze.Companion.getInstance(context), new j(paramString1)
    {
      public final void invoke(BrazeUser paramAnonymousBrazeUser)
      {
        i.e(paramAnonymousBrazeUser, "it");
        paramAnonymousBrazeUser.setCustomAttributeArray(InAppMessageUserJavascriptInterface.this, paramString2);
      }
    });
  }
  
  public final void setCustomUserAttributeJSON(final String paramString1, final String paramString2)
  {
    i.e(paramString1, "key");
    i.e(paramString2, "jsonStringValue");
    Companion.access$runOnUser(Companion, Braze.Companion.getInstance(context), new j(paramString1)
    {
      public final void invoke(BrazeUser paramAnonymousBrazeUser)
      {
        i.e(paramAnonymousBrazeUser, "it");
        setCustomAttribute(paramAnonymousBrazeUser, paramString1, paramString2);
      }
    });
  }
  
  public final void setDateOfBirth(int paramInt1, int paramInt2, final int paramInt3)
  {
    final Month localMonth = monthFromInt(paramInt2);
    if (localMonth == null)
    {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, BrazeLogger.Priority.PREPARED, null, new j(paramInt2)
      {
        public final String invoke()
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Failed to parse month for value ");
          localStringBuilder.append($monthInt);
          return localStringBuilder.toString();
        }
      }, 2, null);
      return;
    }
    Companion.access$runOnUser(Companion, Braze.Companion.getInstance(context), new j(paramInt1)
    {
      public final void invoke(BrazeUser paramAnonymousBrazeUser)
      {
        i.e(paramAnonymousBrazeUser, "it");
        paramAnonymousBrazeUser.setDateOfBirth($year, localMonth, paramInt3);
      }
    });
  }
  
  public final void setEmail(String paramString)
  {
    Companion.access$runOnUser(Companion, Braze.Companion.getInstance(context), new j(paramString)
    {
      public final void invoke(BrazeUser paramAnonymousBrazeUser)
      {
        i.e(paramAnonymousBrazeUser, "it");
        paramAnonymousBrazeUser.setEmail(InAppMessageUserJavascriptInterface.this);
      }
    });
  }
  
  public final void setEmailNotificationSubscriptionType(String paramString)
  {
    i.e(paramString, "subscriptionType");
    NotificationSubscriptionType localNotificationSubscriptionType = subscriptionTypeFromJavascriptString(paramString);
    if (localNotificationSubscriptionType == null)
    {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, BrazeLogger.Priority.PREPARED, null, new j(paramString)
      {
        public final String invoke()
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Failed to parse email subscription type in Braze HTML in-app message javascript interface with subscription ");
          localStringBuilder.append(InAppMessageUserJavascriptInterface.this);
          return localStringBuilder.toString();
        }
      }, 2, null);
      return;
    }
    Companion.access$runOnUser(Companion, Braze.Companion.getInstance(context), new j(localNotificationSubscriptionType)
    {
      public final void invoke(BrazeUser paramAnonymousBrazeUser)
      {
        i.e(paramAnonymousBrazeUser, "it");
        paramAnonymousBrazeUser.setEmailNotificationSubscriptionType(InAppMessageUserJavascriptInterface.this);
      }
    });
  }
  
  public final void setFirstName(String paramString)
  {
    Companion.access$runOnUser(Companion, Braze.Companion.getInstance(context), new j(paramString)
    {
      public final void invoke(BrazeUser paramAnonymousBrazeUser)
      {
        i.e(paramAnonymousBrazeUser, "it");
        paramAnonymousBrazeUser.setFirstName(InAppMessageUserJavascriptInterface.this);
      }
    });
  }
  
  public final void setGender(String paramString)
  {
    i.e(paramString, "genderString");
    Gender localGender = parseGender(paramString);
    if (localGender == null)
    {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, BrazeLogger.Priority.PREPARED, null, new j(paramString)
      {
        public final String invoke()
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Failed to parse gender in Braze HTML in-app message javascript interface with gender: ");
          localStringBuilder.append(InAppMessageUserJavascriptInterface.this);
          return localStringBuilder.toString();
        }
      }, 2, null);
      return;
    }
    Companion.access$runOnUser(Companion, Braze.Companion.getInstance(context), new j(localGender)
    {
      public final void invoke(BrazeUser paramAnonymousBrazeUser)
      {
        i.e(paramAnonymousBrazeUser, "it");
        paramAnonymousBrazeUser.setGender(InAppMessageUserJavascriptInterface.this);
      }
    });
  }
  
  public final void setHomeCity(String paramString)
  {
    Companion.access$runOnUser(Companion, Braze.Companion.getInstance(context), new j(paramString)
    {
      public final void invoke(BrazeUser paramAnonymousBrazeUser)
      {
        i.e(paramAnonymousBrazeUser, "it");
        paramAnonymousBrazeUser.setHomeCity(InAppMessageUserJavascriptInterface.this);
      }
    });
  }
  
  public final void setLanguage(String paramString)
  {
    Companion.access$runOnUser(Companion, Braze.Companion.getInstance(context), new j(paramString)
    {
      public final void invoke(BrazeUser paramAnonymousBrazeUser)
      {
        i.e(paramAnonymousBrazeUser, "it");
        paramAnonymousBrazeUser.setLanguage(InAppMessageUserJavascriptInterface.this);
      }
    });
  }
  
  public final void setLastName(String paramString)
  {
    Companion.access$runOnUser(Companion, Braze.Companion.getInstance(context), new j(paramString)
    {
      public final void invoke(BrazeUser paramAnonymousBrazeUser)
      {
        i.e(paramAnonymousBrazeUser, "it");
        paramAnonymousBrazeUser.setLastName(InAppMessageUserJavascriptInterface.this);
      }
    });
  }
  
  public final void setPhoneNumber(String paramString)
  {
    Companion.access$runOnUser(Companion, Braze.Companion.getInstance(context), new j(paramString)
    {
      public final void invoke(BrazeUser paramAnonymousBrazeUser)
      {
        i.e(paramAnonymousBrazeUser, "it");
        paramAnonymousBrazeUser.setPhoneNumber(InAppMessageUserJavascriptInterface.this);
      }
    });
  }
  
  public final void setPushNotificationSubscriptionType(String paramString)
  {
    i.e(paramString, "subscriptionType");
    NotificationSubscriptionType localNotificationSubscriptionType = subscriptionTypeFromJavascriptString(paramString);
    if (localNotificationSubscriptionType == null)
    {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, BrazeLogger.Priority.PREPARED, null, new j(paramString)
      {
        public final String invoke()
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Failed to parse push subscription type in Braze HTML in-app message javascript interface with subscription: ");
          localStringBuilder.append(InAppMessageUserJavascriptInterface.this);
          return localStringBuilder.toString();
        }
      }, 2, null);
      return;
    }
    Companion.access$runOnUser(Companion, Braze.Companion.getInstance(context), new j(localNotificationSubscriptionType)
    {
      public final void invoke(BrazeUser paramAnonymousBrazeUser)
      {
        i.e(paramAnonymousBrazeUser, "it");
        paramAnonymousBrazeUser.setPushNotificationSubscriptionType(InAppMessageUserJavascriptInterface.this);
      }
    });
  }
  
  public final NotificationSubscriptionType subscriptionTypeFromJavascriptString(String paramString)
  {
    return NotificationSubscriptionType.Companion.fromValue(paramString);
  }
  
  public static final class Companion
  {
    private Companion() {}
    
    private final void runOnUser(Braze paramBraze, l paramL)
    {
      paramBraze.getCurrentUser(new NowPlayingFragment.10(paramL));
    }
    
    private static final void runOnUser$lambda-0(l paramL, BrazeUser paramBrazeUser)
    {
      i.e(paramL, "$block");
      i.e(paramBrazeUser, "it");
      paramL.invoke(paramBrazeUser);
    }
  }
}
