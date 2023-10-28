package com.braze.support;

import java.math.BigDecimal;
import java.util.Locale;
import java.util.Set;
import kotlin.collections.g0;
import kotlin.text.e;
import kotlin.text.g;
import kotlin.x.c.a;
import kotlin.x.d.i;
import kotlin.x.d.j;
import kotlin.x.d.s;
import protect.package_9.k;

public final class ValidationUtils
{
  private static final e EMAIL_ADDRESS_REGEX = new e(".+@.+\\..+");
  public static final ValidationUtils INSTANCE = new ValidationUtils();
  private static final e PHONE_NUMBER_REGEX = new e("^[0-9 .\\(\\)\\+\\-]+$");
  private static final Set<String> VALID_CURRENCY_CODES = g0.d(new String[] { "AED", "AFN", "ALL", "AMD", "ANG", "AOA", "ARS", "AUD", "AWG", "AZN", "BAM", "BBD", "BDT", "BGN", "BHD", "BIF", "BMD", "BND", "BOB", "BRL", "BSD", "BTC", "BTN", "BWP", "BYR", "BZD", "CAD", "CDF", "CHF", "CLF", "CLP", "CNY", "COP", "CRC", "CUC", "CUP", "CVE", "CZK", "DJF", "DKK", "DOP", "DZD", "EEK", "EGP", "ERN", "ETB", "EUR", "FJD", "FKP", "GBP", "GEL", "GGP", "GHS", "GIP", "GMD", "GNF", "GTQ", "GYD", "HKD", "HNL", "HRK", "HTG", "HUF", "IDR", "ILS", "IMP", "INR", "IQD", "IRR", "ISK", "JEP", "JMD", "JOD", "JPY", "KES", "KGS", "KHR", "KMF", "KPW", "KRW", "KWD", "KYD", "KZT", "LAK", "LBP", "LKR", "LRD", "LSL", "LTL", "LVL", "LYD", "MAD", "MDL", "MGA", "MKD", "MMK", "MNT", "MOP", "MRO", "MTL", "MUR", "MVR", "MWK", "MXN", "MYR", "MZN", "NAD", "NGN", "NIO", "NOK", "NPR", "NZD", "OMR", "PAB", "PEN", "PGK", "PHP", "PKR", "PLN", "PYG", "QAR", "RON", "RSD", "RUB", "RWF", "SAR", "SBD", "SCR", "SDG", "SEK", "SGD", "SHP", "SLL", "SOS", "SRD", "STD", "SVC", "SYP", "SZL", "THB", "TJS", "TMT", "TND", "TOP", "TRY", "TTD", "TWD", "TZS", "UAH", "UGX", "USD", "UYU", "UZS", "VEF", "VND", "VUV", "WST", "XAF", "XAG", "XAU", "XCD", "XDR", "XOF", "XPD", "XPF", "XPT", "YER", "ZAR", "ZMK", "ZMW", "ZWL" });
  
  private ValidationUtils() {}
  
  public static final String ensureBrazeFieldLength(String paramString)
  {
    if ((paramString != null) && (!g.o(paramString))) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0) {
      return "";
    }
    s localS = new s();
    paramString = g.l0(paramString).toString();
    b = paramString;
    int i = paramString.length();
    paramString = INSTANCE;
    if (i > 255)
    {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, paramString, BrazeLogger.Priority.PREPARED, null, new a(localS), 2, null);
      paramString = ((String)b).substring(0, 255);
      i.d(paramString, "this as java.lang.String?ing(startIndex, endIndex)");
      b = paramString;
    }
    return (String)b;
  }
  
  public static final boolean isValidEmailAddress(String paramString)
  {
    int i;
    if ((paramString != null) && (paramString.length() != 0)) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0) {
      return false;
    }
    if (paramString.length() > 255) {
      return false;
    }
    return EMAIL_ADDRESS_REGEX.a(paramString);
  }
  
  public static final boolean isValidLocation(double paramDouble1, double paramDouble2)
  {
    return (paramDouble1 < 90.0D) && (paramDouble1 > -90.0D) && (paramDouble2 < 180.0D) && (paramDouble2 > -180.0D);
  }
  
  public static final boolean isValidLogCustomEventInput(String paramString, k paramK)
  {
    i.e(paramK, "serverConfigStorageProvider");
    int i;
    if ((paramString != null) && (!g.o(paramString))) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0) {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, INSTANCE, BrazeLogger.Priority.PREPARED, null, b.PLAYING, 2, null);
    }
    for (;;)
    {
      return false;
      if (!paramK.setTitle().contains(paramString)) {
        break;
      }
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, INSTANCE, BrazeLogger.Priority.PREPARED, null, new c(paramString), 2, null);
    }
    return true;
  }
  
  public static final boolean isValidLogPurchaseInput(String paramString1, String paramString2, BigDecimal paramBigDecimal, int paramInt, k paramK)
  {
    i.e(paramK, "serverConfigStorageProvider");
    int i;
    if ((paramString1 != null) && (!g.o(paramString1))) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0) {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, INSTANCE, BrazeLogger.Priority.PREPARED, null, d.PLAYING, 2, null);
    }
    for (;;)
    {
      return false;
      if (paramK.getView().contains(paramString1))
      {
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, INSTANCE, BrazeLogger.Priority.PREPARED, null, new e(paramString1), 2, null);
      }
      else
      {
        if ((paramString2 != null) && (!g.o(paramString2))) {
          i = 0;
        } else {
          i = 1;
        }
        if (i != 0)
        {
          BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, INSTANCE, BrazeLogger.Priority.PREPARED, null, f.PLAYING, 2, null);
        }
        else
        {
          paramString1 = INSTANCE;
          paramK = VALID_CURRENCY_CODES;
          String str = g.l0(paramString2).toString();
          Locale localLocale = Locale.US;
          i.d(localLocale, "US");
          str = str.toUpperCase(localLocale);
          i.d(str, "this as java.lang.String).toUpperCase(locale)");
          if (!paramK.contains(str))
          {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, paramString1, BrazeLogger.Priority.PREPARED, null, new g(paramString2), 2, null);
          }
          else if (paramBigDecimal == null)
          {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, paramString1, BrazeLogger.Priority.PREPARED, null, h.PLAYING, 2, null);
          }
          else if (paramInt <= 0)
          {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, paramString1, BrazeLogger.Priority.PREPARED, null, new i(paramInt), 2, null);
          }
          else
          {
            if (paramInt <= 100) {
              break;
            }
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, paramString1, BrazeLogger.Priority.PREPARED, null, new j(paramInt), 2, null);
          }
        }
      }
    }
    return true;
  }
  
  public static final boolean isValidPhoneNumber(String paramString)
  {
    return (paramString != null) && (PHONE_NUMBER_REGEX.a(paramString));
  }
  
  public static final boolean isValidPushStoryClickInput(String paramString1, String paramString2)
  {
    int i;
    if ((paramString1 != null) && (!g.o(paramString1))) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0) {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, INSTANCE, BrazeLogger.Priority.PREPARED, null, k.PLAYING, 2, null);
    }
    for (;;)
    {
      return false;
      if ((paramString2 != null) && (!g.o(paramString2))) {
        i = 0;
      } else {
        i = 1;
      }
      if (i == 0) {
        break;
      }
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, INSTANCE, BrazeLogger.Priority.PREPARED, null, l.STARTED, 2, null);
    }
    return true;
  }
  
  public final Set getVALID_CURRENCY_CODES()
  {
    return VALID_CURRENCY_CODES;
  }
  
  static final class a
    extends j
    implements a<String>
  {
    a(s paramS)
    {
      super();
    }
    
    public final String get()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Provided string field is too long [");
      localStringBuilder.append(((String)second.b).length());
      localStringBuilder.append("]. The max length is 255, truncating provided field.");
      return localStringBuilder.toString();
    }
  }
  
  static final class b
    extends j
    implements a<String>
  {
    public static final b PLAYING = new b();
    
    b()
    {
      super();
    }
    
    public final String getText()
    {
      return "The custom event name cannot be null or contain only whitespaces. Invalid custom event.";
    }
  }
  
  static final class c
    extends j
    implements a<String>
  {
    c(String paramString)
    {
      super();
    }
    
    public final String substring()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("The custom event is a blocklisted custom event: ");
      localStringBuilder.append(src);
      localStringBuilder.append(". Invalid custom event.");
      return localStringBuilder.toString();
    }
  }
  
  static final class d
    extends j
    implements a<String>
  {
    public static final d PLAYING = new d();
    
    d()
    {
      super();
    }
    
    public final String getText()
    {
      return "The productId is empty, not logging in-app purchase to Braze.";
    }
  }
  
  static final class e
    extends j
    implements a<String>
  {
    e(String paramString)
    {
      super();
    }
    
    public final String substring()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("The productId is a blocklisted productId: ");
      localStringBuilder.append(src);
      return localStringBuilder.toString();
    }
  }
  
  static final class f
    extends j
    implements a<String>
  {
    public static final f PLAYING = new f();
    
    f()
    {
      super();
    }
    
    public final String substring()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("The currencyCode is empty. Expected one of ");
      localStringBuilder.append(ValidationUtils.INSTANCE.getVALID_CURRENCY_CODES());
      return localStringBuilder.toString();
    }
  }
  
  static final class g
    extends j
    implements a<String>
  {
    g(String paramString)
    {
      super();
    }
    
    public final String substring()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("The currencyCode ");
      localStringBuilder.append(start);
      localStringBuilder.append(" is invalid. Expected one of ");
      localStringBuilder.append(ValidationUtils.INSTANCE.getVALID_CURRENCY_CODES());
      return localStringBuilder.toString();
    }
  }
  
  static final class h
    extends j
    implements a<String>
  {
    public static final h PLAYING = new h();
    
    h()
    {
      super();
    }
    
    public final String getText()
    {
      return "The price is null.";
    }
  }
  
  static final class i
    extends j
    implements a<String>
  {
    i(int paramInt)
    {
      super();
    }
    
    public final String substring()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("The requested purchase quantity of ");
      localStringBuilder.append(src);
      localStringBuilder.append(" is less than one. Invalid purchase");
      return localStringBuilder.toString();
    }
  }
  
  static final class j
    extends j
    implements a<String>
  {
    j(int paramInt)
    {
      super();
    }
    
    public final String substring()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("The requested purchase quantity of ");
      localStringBuilder.append(src);
      localStringBuilder.append(" is greater than the maximum of 100");
      return localStringBuilder.toString();
    }
  }
  
  static final class k
    extends j
    implements a<String>
  {
    public static final k PLAYING = new k();
    
    k()
    {
      super();
    }
    
    public final String getText()
    {
      return "Campaign ID cannot be null or blank";
    }
  }
  
  static final class l
    extends j
    implements a<String>
  {
    public static final l STARTED = new l();
    
    l()
    {
      super();
    }
    
    public final String getText()
    {
      return "Push story page ID cannot be null or blank";
    }
  }
}
