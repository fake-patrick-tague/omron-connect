package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzeq;
import com.google.android.gms.internal.measurement.zzex;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

abstract class TFloatLinkedList
{
  Boolean a;
  Long b;
  Long c;
  final String size;
  Boolean start;
  final int type;
  
  TFloatLinkedList(String paramString, int paramInt)
  {
    size = paramString;
    type = paramInt;
  }
  
  static Boolean get(String paramString, zzeq paramZzeq)
  {
    if (!zzlb.get(paramString)) {
      return null;
    }
    try
    {
      paramString = toString(new BigDecimal(paramString), paramZzeq, 0.0D);
      return paramString;
    }
    catch (NumberFormatException paramString) {}
    return null;
  }
  
  static Boolean get(String paramString, zzex paramZzex, zzeo paramZzeo)
  {
    Preconditions.checkNotNull(paramZzex);
    if (paramString == null) {
      return null;
    }
    if (paramZzex.read())
    {
      if (paramZzex.next() == 1) {
        return null;
      }
      if (paramZzex.next() == 7)
      {
        if (paramZzex.getCardinality() == 0) {
          return null;
        }
      }
      else if (!paramZzex.validate()) {
        return null;
      }
      int i = paramZzex.next();
      boolean bool = paramZzex.count();
      String str;
      if ((!bool) && (i != 2) && (i != 7)) {
        str = paramZzex.getName().toUpperCase(Locale.ENGLISH);
      } else {
        str = paramZzex.getName();
      }
      Object localObject;
      if (paramZzex.getCardinality() == 0)
      {
        paramZzex = null;
      }
      else
      {
        localObject = paramZzex.list();
        paramZzex = (zzex)localObject;
        if (!bool)
        {
          paramZzex = new ArrayList(((List)localObject).size());
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext()) {
            paramZzex.add(((String)((Iterator)localObject).next()).toUpperCase(Locale.ENGLISH));
          }
          paramZzex = Collections.unmodifiableList(paramZzex);
        }
      }
      if (i == 2) {
        localObject = str;
      } else {
        localObject = null;
      }
      return valueOf(paramString, i, bool, str, paramZzex, (String)localObject, paramZzeo);
    }
    return null;
  }
  
  static Boolean set(Boolean paramBoolean, boolean paramBoolean1)
  {
    if (paramBoolean == null) {
      return null;
    }
    if (paramBoolean.booleanValue() != paramBoolean1) {
      paramBoolean1 = true;
    } else {
      paramBoolean1 = false;
    }
    return Boolean.valueOf(paramBoolean1);
  }
  
  static Boolean toString(double paramDouble, zzeq paramZzeq)
  {
    try
    {
      paramZzeq = toString(new BigDecimal(paramDouble), paramZzeq, Math.ulp(paramDouble));
      return paramZzeq;
    }
    catch (NumberFormatException paramZzeq)
    {
      for (;;) {}
    }
    return null;
  }
  
  /* Error */
  static Boolean toString(BigDecimal paramBigDecimal, zzeq paramZzeq, double paramDouble)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 49	com/google/android/gms/common/internal/Preconditions:checkNotNull	(Ljava/lang/Object;)Ljava/lang/Object;
    //   4: pop
    //   5: aload_1
    //   6: invokevirtual 148	com/google/android/gms/internal/measurement/zzeq:hasAlias	()Z
    //   9: ifeq +436 -> 445
    //   12: aload_1
    //   13: invokevirtual 151	com/google/android/gms/internal/measurement/zzeq:testConnection	()I
    //   16: istore 4
    //   18: iconst_1
    //   19: istore 6
    //   21: iconst_1
    //   22: istore 7
    //   24: iconst_1
    //   25: istore 8
    //   27: iconst_1
    //   28: istore 9
    //   30: iconst_1
    //   31: istore 5
    //   33: iload 4
    //   35: iconst_1
    //   36: if_icmpne +5 -> 41
    //   39: aconst_null
    //   40: areturn
    //   41: aload_1
    //   42: invokevirtual 151	com/google/android/gms/internal/measurement/zzeq:testConnection	()I
    //   45: iconst_5
    //   46: if_icmpne +22 -> 68
    //   49: aload_1
    //   50: invokevirtual 153	com/google/android/gms/internal/measurement/zzeq:next	()Z
    //   53: ifeq +13 -> 66
    //   56: aload_1
    //   57: invokevirtual 156	com/google/android/gms/internal/measurement/zzeq:equals	()Z
    //   60: ifeq +391 -> 451
    //   63: goto +14 -> 77
    //   66: aconst_null
    //   67: areturn
    //   68: aload_1
    //   69: invokevirtual 159	com/google/android/gms/internal/measurement/zzeq:isSigned	()Z
    //   72: ifne +5 -> 77
    //   75: aconst_null
    //   76: areturn
    //   77: aload_1
    //   78: invokevirtual 151	com/google/android/gms/internal/measurement/zzeq:testConnection	()I
    //   81: istore 4
    //   83: aload_1
    //   84: invokevirtual 151	com/google/android/gms/internal/measurement/zzeq:testConnection	()I
    //   87: iconst_5
    //   88: if_icmpne +62 -> 150
    //   91: aload_1
    //   92: invokevirtual 162	com/google/android/gms/internal/measurement/zzeq:getMajor	()Ljava/lang/String;
    //   95: invokestatic 33	com/google/android/gms/measurement/internal/zzlb:get	(Ljava/lang/String;)Z
    //   98: ifeq +50 -> 148
    //   101: aload_1
    //   102: invokevirtual 165	com/google/android/gms/internal/measurement/zzeq:getMinor	()Ljava/lang/String;
    //   105: invokestatic 33	com/google/android/gms/measurement/internal/zzlb:get	(Ljava/lang/String;)Z
    //   108: ifne +5 -> 113
    //   111: aconst_null
    //   112: areturn
    //   113: new 35	java/math/BigDecimal
    //   116: dup
    //   117: aload_1
    //   118: invokevirtual 162	com/google/android/gms/internal/measurement/zzeq:getMajor	()Ljava/lang/String;
    //   121: invokespecial 38	java/math/BigDecimal:<init>	(Ljava/lang/String;)V
    //   124: astore 10
    //   126: new 35	java/math/BigDecimal
    //   129: dup
    //   130: aload_1
    //   131: invokevirtual 165	com/google/android/gms/internal/measurement/zzeq:getMinor	()Ljava/lang/String;
    //   134: invokespecial 38	java/math/BigDecimal:<init>	(Ljava/lang/String;)V
    //   137: astore 11
    //   139: aload 10
    //   141: astore_1
    //   142: aconst_null
    //   143: astore 10
    //   145: goto +35 -> 180
    //   148: aconst_null
    //   149: areturn
    //   150: aload_1
    //   151: invokevirtual 168	com/google/android/gms/internal/measurement/zzeq:getUUID	()Ljava/lang/String;
    //   154: invokestatic 33	com/google/android/gms/measurement/internal/zzlb:get	(Ljava/lang/String;)Z
    //   157: ifne +5 -> 162
    //   160: aconst_null
    //   161: areturn
    //   162: new 35	java/math/BigDecimal
    //   165: dup
    //   166: aload_1
    //   167: invokevirtual 168	com/google/android/gms/internal/measurement/zzeq:getUUID	()Ljava/lang/String;
    //   170: invokespecial 38	java/math/BigDecimal:<init>	(Ljava/lang/String;)V
    //   173: astore 10
    //   175: aconst_null
    //   176: astore_1
    //   177: aconst_null
    //   178: astore 11
    //   180: iload 4
    //   182: iconst_5
    //   183: if_icmpne +10 -> 193
    //   186: aload_1
    //   187: ifnull +264 -> 451
    //   190: goto +10 -> 200
    //   193: aload 10
    //   195: ifnonnull +5 -> 200
    //   198: aconst_null
    //   199: areturn
    //   200: iload 4
    //   202: iconst_1
    //   203: isub
    //   204: istore 4
    //   206: iload 4
    //   208: iconst_1
    //   209: if_icmpeq +204 -> 413
    //   212: iload 4
    //   214: iconst_2
    //   215: if_icmpeq +166 -> 381
    //   218: iload 4
    //   220: iconst_3
    //   221: if_icmpeq +44 -> 265
    //   224: iload 4
    //   226: iconst_4
    //   227: if_icmpeq +5 -> 232
    //   230: aconst_null
    //   231: areturn
    //   232: aload_1
    //   233: ifnull +218 -> 451
    //   236: aload_0
    //   237: aload_1
    //   238: invokevirtual 172	java/math/BigDecimal:compareTo	(Ljava/math/BigDecimal;)I
    //   241: iflt +15 -> 256
    //   244: aload_0
    //   245: aload 11
    //   247: invokevirtual 172	java/math/BigDecimal:compareTo	(Ljava/math/BigDecimal;)I
    //   250: ifgt +6 -> 256
    //   253: goto +6 -> 259
    //   256: iconst_0
    //   257: istore 5
    //   259: iload 5
    //   261: invokestatic 133	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   264: areturn
    //   265: aload 10
    //   267: ifnonnull +5 -> 272
    //   270: aconst_null
    //   271: areturn
    //   272: dload_2
    //   273: dconst_0
    //   274: dcmpl
    //   275: ifeq +81 -> 356
    //   278: aload_0
    //   279: aload 10
    //   281: new 35	java/math/BigDecimal
    //   284: dup
    //   285: dload_2
    //   286: invokespecial 137	java/math/BigDecimal:<init>	(D)V
    //   289: new 35	java/math/BigDecimal
    //   292: dup
    //   293: iconst_2
    //   294: invokespecial 173	java/math/BigDecimal:<init>	(I)V
    //   297: invokevirtual 177	java/math/BigDecimal:multiply	(Ljava/math/BigDecimal;)Ljava/math/BigDecimal;
    //   300: invokevirtual 180	java/math/BigDecimal:subtract	(Ljava/math/BigDecimal;)Ljava/math/BigDecimal;
    //   303: invokevirtual 172	java/math/BigDecimal:compareTo	(Ljava/math/BigDecimal;)I
    //   306: ifle +41 -> 347
    //   309: aload_0
    //   310: aload 10
    //   312: new 35	java/math/BigDecimal
    //   315: dup
    //   316: dload_2
    //   317: invokespecial 137	java/math/BigDecimal:<init>	(D)V
    //   320: new 35	java/math/BigDecimal
    //   323: dup
    //   324: iconst_2
    //   325: invokespecial 173	java/math/BigDecimal:<init>	(I)V
    //   328: invokevirtual 177	java/math/BigDecimal:multiply	(Ljava/math/BigDecimal;)Ljava/math/BigDecimal;
    //   331: invokevirtual 182	java/math/BigDecimal:add	(Ljava/math/BigDecimal;)Ljava/math/BigDecimal;
    //   334: invokevirtual 172	java/math/BigDecimal:compareTo	(Ljava/math/BigDecimal;)I
    //   337: ifge +10 -> 347
    //   340: iload 6
    //   342: istore 5
    //   344: goto +6 -> 350
    //   347: iconst_0
    //   348: istore 5
    //   350: iload 5
    //   352: invokestatic 133	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   355: areturn
    //   356: aload_0
    //   357: aload 10
    //   359: invokevirtual 172	java/math/BigDecimal:compareTo	(Ljava/math/BigDecimal;)I
    //   362: ifne +10 -> 372
    //   365: iload 7
    //   367: istore 5
    //   369: goto +6 -> 375
    //   372: iconst_0
    //   373: istore 5
    //   375: iload 5
    //   377: invokestatic 133	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   380: areturn
    //   381: aload 10
    //   383: ifnonnull +5 -> 388
    //   386: aconst_null
    //   387: areturn
    //   388: aload_0
    //   389: aload 10
    //   391: invokevirtual 172	java/math/BigDecimal:compareTo	(Ljava/math/BigDecimal;)I
    //   394: ifle +10 -> 404
    //   397: iload 8
    //   399: istore 5
    //   401: goto +6 -> 407
    //   404: iconst_0
    //   405: istore 5
    //   407: iload 5
    //   409: invokestatic 133	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   412: areturn
    //   413: aload 10
    //   415: ifnonnull +5 -> 420
    //   418: aconst_null
    //   419: areturn
    //   420: aload_0
    //   421: aload 10
    //   423: invokevirtual 172	java/math/BigDecimal:compareTo	(Ljava/math/BigDecimal;)I
    //   426: ifge +10 -> 436
    //   429: iload 9
    //   431: istore 5
    //   433: goto +6 -> 439
    //   436: iconst_0
    //   437: istore 5
    //   439: iload 5
    //   441: invokestatic 133	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   444: areturn
    //   445: aconst_null
    //   446: areturn
    //   447: astore_0
    //   448: aconst_null
    //   449: areturn
    //   450: astore_0
    //   451: aconst_null
    //   452: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	453	0	paramBigDecimal	BigDecimal
    //   0	453	1	paramZzeq	zzeq
    //   0	453	2	paramDouble	double
    //   16	212	4	i	int
    //   31	409	5	bool1	boolean
    //   19	322	6	bool2	boolean
    //   22	344	7	bool3	boolean
    //   25	373	8	bool4	boolean
    //   28	402	9	bool5	boolean
    //   124	298	10	localBigDecimal1	BigDecimal
    //   137	109	11	localBigDecimal2	BigDecimal
    // Exception table:
    //   from	to	target	type
    //   113	126	447	java/lang/NumberFormatException
    //   126	139	447	java/lang/NumberFormatException
    //   162	175	450	java/lang/NumberFormatException
  }
  
  static Boolean valueOf(long paramLong, zzeq paramZzeq)
  {
    try
    {
      paramZzeq = toString(new BigDecimal(paramLong), paramZzeq, 0.0D);
      return paramZzeq;
    }
    catch (NumberFormatException paramZzeq)
    {
      for (;;) {}
    }
    return null;
  }
  
  private static Boolean valueOf(String paramString1, int paramInt, boolean paramBoolean, String paramString2, List paramList, String paramString3, zzeo paramZzeo)
  {
    if (paramInt == 7)
    {
      if (paramList != null) {
        if (paramList.isEmpty()) {
          break label244;
        }
      } else {
        return null;
      }
    }
    else if (paramString2 == null) {
      return null;
    }
    String str = paramString1;
    if (!paramBoolean)
    {
      str = paramString1;
      if (paramInt != 2) {
        str = paramString1.toUpperCase(Locale.ENGLISH);
      }
    }
    switch (paramInt - 1)
    {
    default: 
      return null;
    case 6: 
      if (paramList == null) {
        return null;
      }
      return Boolean.valueOf(paramList.contains(str));
    case 5: 
      return Boolean.valueOf(str.equals(paramString2));
    case 4: 
      return Boolean.valueOf(str.contains(paramString2));
    case 3: 
      return Boolean.valueOf(str.endsWith(paramString2));
    case 2: 
      return Boolean.valueOf(str.startsWith(paramString2));
    }
    if (paramString3 == null) {
      return null;
    }
    if (true != paramBoolean) {
      paramInt = 66;
    } else {
      paramInt = 0;
    }
    try
    {
      paramBoolean = Pattern.compile(paramString3, paramInt).matcher(str).matches();
      return Boolean.valueOf(paramBoolean);
    }
    catch (PatternSyntaxException paramString1)
    {
      for (;;) {}
    }
    if (paramZzeo != null)
    {
      paramZzeo.hasNext().append("Invalid regular expression in REGEXP audience filter. expression", paramString3);
      return null;
    }
    label244:
    return null;
  }
  
  abstract boolean add();
  
  abstract int get();
  
  abstract boolean remove();
}
