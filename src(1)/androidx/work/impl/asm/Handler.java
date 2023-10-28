package androidx.work.impl.asm;

import android.os.Build.VERSION;
import androidx.work.BackoffPolicy;
import androidx.work.NetworkType;
import androidx.work.OutOfQuotaPolicy;
import androidx.work.Type;
import androidx.work.WorkInfo.State;

public class Handler
{
  public static int a(BackoffPolicy paramBackoffPolicy)
  {
    int i = c.i[paramBackoffPolicy.ordinal()];
    if (i != 1)
    {
      if (i == 2) {
        return 1;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Could not convert ");
      localStringBuilder.append(paramBackoffPolicy);
      localStringBuilder.append(" to int");
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    return 0;
  }
  
  public static int a(NetworkType paramNetworkType)
  {
    int i = c.c[paramNetworkType.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4)
          {
            if (i != 5)
            {
              if ((Build.VERSION.SDK_INT >= 30) && (paramNetworkType == NetworkType.b)) {
                return 5;
              }
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("Could not convert ");
              localStringBuilder.append(paramNetworkType);
              localStringBuilder.append(" to int");
              throw new IllegalArgumentException(localStringBuilder.toString());
            }
          }
          else {
            return 3;
          }
        }
        else {
          return 2;
        }
      }
      else {
        return 1;
      }
    }
    else {
      return 0;
    }
    return 4;
  }
  
  public static int a(OutOfQuotaPolicy paramOutOfQuotaPolicy)
  {
    int i = c.d[paramOutOfQuotaPolicy.ordinal()];
    if (i != 1)
    {
      if (i == 2) {
        return 1;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Could not convert ");
      localStringBuilder.append(paramOutOfQuotaPolicy);
      localStringBuilder.append(" to int");
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    return 0;
  }
  
  public static int a(WorkInfo.State paramState)
  {
    switch (c.b[paramState.ordinal()])
    {
    default: 
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Could not convert ");
      localStringBuilder.append(paramState);
      localStringBuilder.append(" to int");
      throw new IllegalArgumentException(localStringBuilder.toString());
    case 6: 
      return 5;
    case 5: 
      return 4;
    case 4: 
      return 3;
    case 3: 
      return 2;
    case 2: 
      return 1;
    }
    return 0;
  }
  
  public static NetworkType a(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 4)
            {
              if ((Build.VERSION.SDK_INT >= 30) && (paramInt == 5)) {
                return NetworkType.b;
              }
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("Could not convert ");
              localStringBuilder.append(paramInt);
              localStringBuilder.append(" to NetworkType");
              throw new IllegalArgumentException(localStringBuilder.toString());
            }
            return NetworkType.r;
          }
          return NetworkType.d;
        }
        return NetworkType.a;
      }
      return NetworkType.g;
    }
    return NetworkType.c;
  }
  
  public static WorkInfo.State b(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 4)
            {
              if (paramInt == 5) {
                return WorkInfo.State.c;
              }
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("Could not convert ");
              localStringBuilder.append(paramInt);
              localStringBuilder.append(" to State");
              throw new IllegalArgumentException(localStringBuilder.toString());
            }
            return WorkInfo.State.p;
          }
          return WorkInfo.State.d;
        }
        return WorkInfo.State.i;
      }
      return WorkInfo.State.b;
    }
    return WorkInfo.State.a;
  }
  
  public static BackoffPolicy c(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt == 1) {
        return BackoffPolicy.b;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Could not convert ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" to BackoffPolicy");
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    return BackoffPolicy.c;
  }
  
  public static OutOfQuotaPolicy getValue(int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt == 1) {
        return OutOfQuotaPolicy.b;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Could not convert ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" to OutOfQuotaPolicy");
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    return OutOfQuotaPolicy.a;
  }
  
  public static Type read(byte[] paramArrayOfByte)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: fail exe a4 = a3\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:92)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:1)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.dfs(Cfg.java:255)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze0(BaseAnalyze.java:75)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze(BaseAnalyze.java:69)\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer.transform(UnSSATransformer.java:274)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:163)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\nCaused by: java.lang.NullPointerException\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer$LiveA.onUseLocal(UnSSATransformer.java:552)\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer$LiveA.onUseLocal(UnSSATransformer.java:1)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.onUse(BaseAnalyze.java:166)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.onUse(BaseAnalyze.java:1)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.travel(Cfg.java:331)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.travel(Cfg.java:387)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:90)\n\t... 17 more\n");
  }
  
  /* Error */
  public static byte[] write(Type paramType)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 146	androidx/work/Type:get	()I
    //   4: istore_1
    //   5: aconst_null
    //   6: astore 5
    //   8: aconst_null
    //   9: astore_3
    //   10: iload_1
    //   11: ifne +5 -> 16
    //   14: aconst_null
    //   15: areturn
    //   16: new 148	java/io/ByteArrayOutputStream
    //   19: dup
    //   20: invokespecial 149	java/io/ByteArrayOutputStream:<init>	()V
    //   23: astore 6
    //   25: new 151	java/io/ObjectOutputStream
    //   28: dup
    //   29: aload 6
    //   31: invokespecial 154	java/io/ObjectOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   34: astore 4
    //   36: aload 4
    //   38: aload_0
    //   39: invokevirtual 146	androidx/work/Type:get	()I
    //   42: invokevirtual 158	java/io/ObjectOutputStream:writeInt	(I)V
    //   45: aload_0
    //   46: invokevirtual 161	androidx/work/Type:getValue	()Ljava/util/Set;
    //   49: invokeinterface 167 1 0
    //   54: astore_0
    //   55: aload_0
    //   56: invokeinterface 173 1 0
    //   61: istore_2
    //   62: iload_2
    //   63: ifeq +39 -> 102
    //   66: aload_0
    //   67: invokeinterface 177 1 0
    //   72: astore_3
    //   73: aload_3
    //   74: checkcast 179	androidx/work/Segment
    //   77: astore_3
    //   78: aload 4
    //   80: aload_3
    //   81: invokevirtual 182	androidx/work/Segment:getValue	()Landroid/net/Uri;
    //   84: invokevirtual 185	android/net/Uri:toString	()Ljava/lang/String;
    //   87: invokevirtual 188	java/io/ObjectOutputStream:writeUTF	(Ljava/lang/String;)V
    //   90: aload 4
    //   92: aload_3
    //   93: invokevirtual 190	androidx/work/Segment:get	()Z
    //   96: invokevirtual 194	java/io/ObjectOutputStream:writeBoolean	(Z)V
    //   99: goto -44 -> 55
    //   102: aload 4
    //   104: invokevirtual 197	java/io/ObjectOutputStream:close	()V
    //   107: goto +8 -> 115
    //   110: astore_0
    //   111: aload_0
    //   112: invokevirtual 200	java/io/IOException:printStackTrace	()V
    //   115: aload 6
    //   117: invokevirtual 201	java/io/ByteArrayOutputStream:close	()V
    //   120: goto +68 -> 188
    //   123: astore_0
    //   124: aload 4
    //   126: astore_3
    //   127: goto +67 -> 194
    //   130: astore_3
    //   131: aload 4
    //   133: astore_0
    //   134: aload_3
    //   135: astore 4
    //   137: goto +12 -> 149
    //   140: astore_0
    //   141: goto +53 -> 194
    //   144: astore 4
    //   146: aload 5
    //   148: astore_0
    //   149: aload_0
    //   150: astore_3
    //   151: aload 4
    //   153: invokevirtual 200	java/io/IOException:printStackTrace	()V
    //   156: aload_0
    //   157: ifnull +15 -> 172
    //   160: aload_0
    //   161: invokevirtual 197	java/io/ObjectOutputStream:close	()V
    //   164: goto +8 -> 172
    //   167: astore_0
    //   168: aload_0
    //   169: invokevirtual 200	java/io/IOException:printStackTrace	()V
    //   172: aload 6
    //   174: invokevirtual 201	java/io/ByteArrayOutputStream:close	()V
    //   177: goto +11 -> 188
    //   180: astore_0
    //   181: aload_0
    //   182: checkcast 139	java/io/IOException
    //   185: invokevirtual 200	java/io/IOException:printStackTrace	()V
    //   188: aload 6
    //   190: invokevirtual 205	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   193: areturn
    //   194: aload_3
    //   195: ifnull +15 -> 210
    //   198: aload_3
    //   199: invokevirtual 197	java/io/ObjectOutputStream:close	()V
    //   202: goto +8 -> 210
    //   205: astore_3
    //   206: aload_3
    //   207: invokevirtual 200	java/io/IOException:printStackTrace	()V
    //   210: aload 6
    //   212: invokevirtual 201	java/io/ByteArrayOutputStream:close	()V
    //   215: goto +8 -> 223
    //   218: astore_3
    //   219: aload_3
    //   220: invokevirtual 200	java/io/IOException:printStackTrace	()V
    //   223: aload_0
    //   224: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	225	0	paramType	Type
    //   4	7	1	i	int
    //   61	2	2	bool	boolean
    //   9	118	3	localObject1	Object
    //   130	5	3	localIOException1	java.io.IOException
    //   150	49	3	localType	Type
    //   205	2	3	localIOException2	java.io.IOException
    //   218	2	3	localIOException3	java.io.IOException
    //   34	102	4	localObject2	Object
    //   144	8	4	localIOException4	java.io.IOException
    //   6	141	5	localObject3	Object
    //   23	188	6	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    // Exception table:
    //   from	to	target	type
    //   102	107	110	java/io/IOException
    //   36	55	123	java/lang/Throwable
    //   55	62	123	java/lang/Throwable
    //   66	73	123	java/lang/Throwable
    //   78	99	123	java/lang/Throwable
    //   36	55	130	java/io/IOException
    //   55	62	130	java/io/IOException
    //   66	73	130	java/io/IOException
    //   78	99	130	java/io/IOException
    //   25	36	140	java/lang/Throwable
    //   151	156	140	java/lang/Throwable
    //   25	36	144	java/io/IOException
    //   160	164	167	java/io/IOException
    //   115	120	180	java/io/IOException
    //   172	177	180	java/io/IOException
    //   198	202	205	java/io/IOException
    //   210	215	218	java/io/IOException
  }
}
