package com.google.android.gms.internal.fitness;

import java.io.IOException;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Comparator;
import java.util.Locale;

public abstract class zzfx
  implements Serializable, Iterable<Byte>
{
  public static final zzfx zzub;
  private static final zzgd zzuc;
  private static final Comparator<zzfx> zzue;
  private int zzud = 0;
  
  static
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: fail exe a1 = a0\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:92)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:1)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.dfs(Cfg.java:255)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze0(BaseAnalyze.java:75)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze(BaseAnalyze.java:69)\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer.transform(UnSSATransformer.java:274)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:163)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\nCaused by: java.lang.NullPointerException\n");
  }
  
  zzfx() {}
  
  static int add(int paramInt1, int paramInt2, int paramInt3)
  {
    int i = paramInt2 - paramInt1;
    if ((paramInt1 | paramInt2 | i | paramInt3 - paramInt2) < 0)
    {
      if (paramInt1 >= 0)
      {
        if (paramInt2 < paramInt1)
        {
          localStringBuilder = new StringBuilder(66);
          localStringBuilder.append("Beginning index larger than ending index: ");
          localStringBuilder.append(paramInt1);
          localStringBuilder.append(", ");
          localStringBuilder.append(paramInt2);
          throw new IndexOutOfBoundsException(localStringBuilder.toString());
        }
        localStringBuilder = new StringBuilder(37);
        localStringBuilder.append("End index: ");
        localStringBuilder.append(paramInt2);
        localStringBuilder.append(" >= ");
        localStringBuilder.append(paramInt3);
        throw new IndexOutOfBoundsException(localStringBuilder.toString());
      }
      StringBuilder localStringBuilder = new StringBuilder(32);
      localStringBuilder.append("Beginning index: ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" < 0");
      throw new IndexOutOfBoundsException(localStringBuilder.toString());
    }
    return i;
  }
  
  private static int next(byte paramByte)
  {
    return paramByte & 0xFF;
  }
  
  static zzgf readError(int paramInt)
  {
    return new zzgf(paramInt, null);
  }
  
  public static zzfx setInput(String paramString)
  {
    return new zzgh(paramString.getBytes(zzhc.UTF_8));
  }
  
  public abstract byte byteAt(int paramInt);
  
  protected abstract int computeHashCode(int paramInt1, int paramInt2, int paramInt3);
  
  public abstract boolean equals(Object paramObject);
  
  public abstract zzfx getPath(int paramInt1, int paramInt2);
  
  public final int hashCode()
  {
    int i = zzud;
    if (i == 0)
    {
      i = size();
      int j = computeHashCode(i, 0, i);
      i = j;
      if (j == 0) {
        i = 1;
      }
      zzud = i;
      return i;
    }
    return i;
  }
  
  abstract void markAllAsRead(zzfu paramZzfu)
    throws IOException;
  
  abstract byte nextValue(int paramInt);
  
  public abstract int size();
  
  public final String toString()
  {
    Locale localLocale = Locale.ROOT;
    String str2 = Integer.toHexString(System.identityHashCode(this));
    int i = size();
    String str1;
    if (size() <= 50) {
      str1 = zzjo.toString(this);
    } else {
      str1 = String.valueOf(zzjo.toString(getPath(0, 47))).concat("...");
    }
    return String.format(localLocale, "<ByteString@%s size=%d contents=\"%s\">", new Object[] { str2, Integer.valueOf(i), str1 });
  }
  
  protected abstract String writeText(Charset paramCharset);
  
  public final String zzav()
  {
    Charset localCharset = zzhc.UTF_8;
    if (size() == 0) {
      return "";
    }
    return writeText(localCharset);
  }
  
  public abstract boolean zzaw();
  
  protected final int zzax()
  {
    return zzud;
  }
}
