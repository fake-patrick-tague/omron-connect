package androidx.core.graphics;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.Typeface.CustomFallbackBuilder;
import android.graphics.fonts.Font;
import android.graphics.fonts.Font.Builder;
import android.graphics.fonts.FontFamily;
import android.graphics.fonts.FontFamily.Builder;
import android.graphics.fonts.FontStyle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import v7.v7.asm.Label;

public class c
  extends h
{
  public c() {}
  
  private static int update(FontStyle paramFontStyle1, FontStyle paramFontStyle2)
  {
    int j = Math.abs(paramFontStyle1.getWeight() - paramFontStyle2.getWeight()) / 100;
    int i;
    if (paramFontStyle1.getSlant() == paramFontStyle2.getSlant()) {
      i = 0;
    } else {
      i = 2;
    }
    return j + i;
  }
  
  private Font write(FontFamily paramFontFamily, int paramInt)
  {
    if ((paramInt & 0x1) != 0) {
      i = 700;
    } else {
      i = 400;
    }
    int j = 1;
    if ((paramInt & 0x2) != 0) {
      paramInt = 1;
    } else {
      paramInt = 0;
    }
    FontStyle localFontStyle = new FontStyle(i, paramInt);
    Font localFont2 = paramFontFamily.getFont(0);
    Font localFont1 = localFont2;
    int i = update(localFontStyle, localFont2.getStyle());
    paramInt = j;
    while (paramInt < paramFontFamily.getSize())
    {
      localFont2 = paramFontFamily.getFont(paramInt);
      int k = update(localFontStyle, localFont2.getStyle());
      j = i;
      if (k < i)
      {
        localFont1 = localFont2;
        j = k;
      }
      paramInt += 1;
      i = j;
    }
    return localFont1;
  }
  
  public Typeface a(Context paramContext, Resources paramResources, int paramInt1, String paramString, int paramInt2)
  {
    try
    {
      paramContext = new Font.Builder(paramResources, paramInt1).build();
      paramResources = new FontFamily.Builder(paramContext).build();
      paramContext = new Typeface.CustomFallbackBuilder(paramResources).setStyle(paramContext.getStyle()).build();
      return paramContext;
    }
    catch (Exception paramContext)
    {
      for (;;) {}
    }
    return null;
  }
  
  public Typeface a(Context paramContext, CancellationSignal paramCancellationSignal, Label[] paramArrayOfLabel, int paramInt)
  {
    ContentResolver localContentResolver = paramContext.getContentResolver();
    int k = paramArrayOfLabel.length;
    paramContext = null;
    int i = 0;
    while (i < k)
    {
      Label localLabel = paramArrayOfLabel[i];
      Object localObject = paramContext;
      try
      {
        ParcelFileDescriptor localParcelFileDescriptor = localContentResolver.openFileDescriptor(localLabel.getName(), "r", paramCancellationSignal);
        if (localParcelFileDescriptor == null)
        {
          localObject = paramContext;
          if (localParcelFileDescriptor == null) {}
        }
        else
        {
          for (;;)
          {
            localObject = paramContext;
            localParcelFileDescriptor.close();
            localObject = paramContext;
            break label186;
            try
            {
              localObject = new Font.Builder(localParcelFileDescriptor).setWeight(localLabel.e());
              boolean bool = localLabel.b();
              int j;
              if (bool) {
                j = 1;
              } else {
                j = 0;
              }
              localObject = ((Font.Builder)localObject).setSlant(j).setTtcIndex(localLabel.a()).build();
              if (paramContext == null)
              {
                localObject = new FontFamily.Builder((Font)localObject);
                paramContext = (Context)localObject;
              }
              else
              {
                paramContext.addFont((Font)localObject);
              }
            }
            catch (Throwable localThrowable1)
            {
              try
              {
                localParcelFileDescriptor.close();
              }
              catch (Throwable localThrowable2) {}
            }
          }
        }
      }
      catch (IOException paramContext)
      {
        for (;;)
        {
          try
          {
            paramContext = paramContext.build();
            paramContext = new Typeface.CustomFallbackBuilder(paramContext).setStyle(write(paramContext, paramInt).getStyle()).build();
            return paramContext;
          }
          catch (Exception paramContext) {}
          paramContext = paramContext;
        }
      }
      catch (Exception paramContext)
      {
        label186:
        return null;
      }
      try
      {
        localThrowable1.addSuppressed(localThrowable2);
        throw localThrowable1;
      }
      catch (IOException localIOException)
      {
        Context localContext = paramContext;
        break label186;
      }
      catch (Exception paramContext)
      {
        return null;
      }
      i += 1;
      paramContext = localThrowable1;
    }
    if (paramContext == null) {
      return null;
    }
    return null;
  }
  
  /* Error */
  public Typeface a(Context paramContext, androidx.core.content.asm.i paramI, Resources paramResources, int paramInt)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokevirtual 149	androidx/core/content/asm/i:a	()[Landroidx/core/content/asm/h;
    //   4: astore 9
    //   6: aload 9
    //   8: arraylength
    //   9: istore 7
    //   11: aconst_null
    //   12: astore_1
    //   13: iconst_0
    //   14: istore 5
    //   16: iload 5
    //   18: iload 7
    //   20: if_icmpge +108 -> 128
    //   23: aload 9
    //   25: iload 5
    //   27: aaload
    //   28: astore_2
    //   29: new 54	android/graphics/fonts/Font$Builder
    //   32: dup
    //   33: aload_3
    //   34: aload_2
    //   35: invokevirtual 152	androidx/core/content/asm/h:e	()I
    //   38: invokespecial 57	android/graphics/fonts/Font$Builder:<init>	(Landroid/content/res/Resources;I)V
    //   41: aload_2
    //   42: invokevirtual 155	androidx/core/content/asm/h:c	()I
    //   45: invokevirtual 121	android/graphics/fonts/Font$Builder:setWeight	(I)Landroid/graphics/fonts/Font$Builder;
    //   48: astore 10
    //   50: aload_2
    //   51: invokevirtual 158	androidx/core/content/asm/h:k	()Z
    //   54: istore 8
    //   56: iload 8
    //   58: ifeq +9 -> 67
    //   61: iconst_1
    //   62: istore 6
    //   64: goto +6 -> 70
    //   67: iconst_0
    //   68: istore 6
    //   70: aload 10
    //   72: iload 6
    //   74: invokevirtual 128	android/graphics/fonts/Font$Builder:setSlant	(I)Landroid/graphics/fonts/Font$Builder;
    //   77: aload_2
    //   78: invokevirtual 159	androidx/core/content/asm/h:a	()I
    //   81: invokevirtual 133	android/graphics/fonts/Font$Builder:setTtcIndex	(I)Landroid/graphics/fonts/Font$Builder;
    //   84: aload_2
    //   85: invokevirtual 163	androidx/core/content/asm/h:h	()Ljava/lang/String;
    //   88: invokevirtual 167	android/graphics/fonts/Font$Builder:setFontVariationSettings	(Ljava/lang/String;)Landroid/graphics/fonts/Font$Builder;
    //   91: invokevirtual 61	android/graphics/fonts/Font$Builder:build	()Landroid/graphics/fonts/Font;
    //   94: astore_2
    //   95: aload_1
    //   96: ifnonnull +17 -> 113
    //   99: new 63	android/graphics/fonts/FontFamily$Builder
    //   102: dup
    //   103: aload_2
    //   104: invokespecial 66	android/graphics/fonts/FontFamily$Builder:<init>	(Landroid/graphics/fonts/Font;)V
    //   107: astore_2
    //   108: aload_2
    //   109: astore_1
    //   110: goto +9 -> 119
    //   113: aload_1
    //   114: aload_2
    //   115: invokevirtual 137	android/graphics/fonts/FontFamily$Builder:addFont	(Landroid/graphics/fonts/Font;)Landroid/graphics/fonts/FontFamily$Builder;
    //   118: pop
    //   119: iload 5
    //   121: iconst_1
    //   122: iadd
    //   123: istore 5
    //   125: goto -109 -> 16
    //   128: aload_1
    //   129: ifnonnull +5 -> 134
    //   132: aconst_null
    //   133: areturn
    //   134: aload_1
    //   135: invokevirtual 69	android/graphics/fonts/FontFamily$Builder:build	()Landroid/graphics/fonts/FontFamily;
    //   138: astore_1
    //   139: new 71	android/graphics/Typeface$CustomFallbackBuilder
    //   142: dup
    //   143: aload_1
    //   144: invokespecial 74	android/graphics/Typeface$CustomFallbackBuilder:<init>	(Landroid/graphics/fonts/FontFamily;)V
    //   147: aload_0
    //   148: aload_1
    //   149: iload 4
    //   151: invokespecial 143	androidx/core/graphics/c:write	(Landroid/graphics/fonts/FontFamily;I)Landroid/graphics/fonts/Font;
    //   154: invokevirtual 43	android/graphics/fonts/Font:getStyle	()Landroid/graphics/fonts/FontStyle;
    //   157: invokevirtual 78	android/graphics/Typeface$CustomFallbackBuilder:setStyle	(Landroid/graphics/fonts/FontStyle;)Landroid/graphics/Typeface$CustomFallbackBuilder;
    //   160: invokevirtual 81	android/graphics/Typeface$CustomFallbackBuilder:build	()Landroid/graphics/Typeface;
    //   163: astore_1
    //   164: aload_1
    //   165: areturn
    //   166: astore_1
    //   167: aconst_null
    //   168: areturn
    //   169: astore_2
    //   170: goto -51 -> 119
    //   173: astore_1
    //   174: aconst_null
    //   175: areturn
    //   176: astore_1
    //   177: aconst_null
    //   178: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	179	0	this	c
    //   0	179	1	paramContext	Context
    //   0	179	2	paramI	androidx.core.content.asm.i
    //   0	179	3	paramResources	Resources
    //   0	179	4	paramInt	int
    //   14	110	5	i	int
    //   62	11	6	j	int
    //   9	12	7	k	int
    //   54	3	8	bool	boolean
    //   4	20	9	arrayOfH	androidx.core.content.asm.h[]
    //   48	23	10	localBuilder	Font.Builder
    // Exception table:
    //   from	to	target	type
    //   0	6	166	java/lang/Exception
    //   29	56	169	java/io/IOException
    //   70	95	169	java/io/IOException
    //   99	108	169	java/io/IOException
    //   113	119	169	java/io/IOException
    //   29	56	173	java/lang/Exception
    //   70	95	173	java/lang/Exception
    //   99	108	173	java/lang/Exception
    //   113	119	173	java/lang/Exception
    //   134	139	176	java/lang/Exception
    //   139	164	176	java/lang/Exception
  }
  
  protected Typeface a(Context paramContext, InputStream paramInputStream)
  {
    throw new RuntimeException("Do not use this function in API 29 or later.");
  }
  
  protected Label a(Label[] paramArrayOfLabel, int paramInt)
  {
    throw new RuntimeException("Do not use this function in API 29 or later.");
  }
}
