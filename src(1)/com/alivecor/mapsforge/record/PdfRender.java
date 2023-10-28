package com.alivecor.mapsforge.record;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.text.TextUtils;
import com.alivecor.alivecorkitlite.R.string;
import com.alivecor.asm.Database;
import com.alivecor.mapsforge.core.EcgFile;
import com.alivecor.mapsforge.core.EcgFile.AliveFileFormat;
import com.alivecor.mapsforge.core.EcgFile.AliveFileInfo;
import com.alivecor.mapsforge.core.EcgFile.Lead;
import com.alivecor.mapsforge.core.model.MainsFilterFrequency;
import com.alivecor.mapsforge.core.model.YAxisScaleTypes;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import k.a.a.o;
import objectweb.asm.ClassWriter;
import objectweb.asm.R.id;
import objectweb.asm.ReportType;
import objectweb.asm.h;
import objectweb.asm.m;

public final class PdfRender
{
  static final float MM_TO_POINTS = 2.8346457F;
  public static final String NEW_LINE = System.getProperty("line.separator");
  static final String PAGE_KEY = "PdfRender";
  static final float STRIPHEIGHT_MM = 60.0F;
  static final int STRIPS_PER_SINGLE_LEAD_PAGE = 4;
  static final float STRIPWIDTH_MM = 200.0F;
  private short[] ecgBuf1;
  private short[] ecgBuf2;
  private short[] ecgBuf3;
  private short[] ecgBuf4;
  private short[] ecgBuf5;
  private short[] ecgBuf6;
  private final boolean embedFonts;
  private boolean isPreviewPDF;
  boolean isSingleLead;
  private int[] mAnnArray;
  String mAppName;
  String mAppVersion;
  int mCalpulseOffsetSamples;
  float mCalpulseOffset_mm;
  final Context mContext;
  private com.alivecor.mapsforge.core.asm.a mDateTimeFormatter;
  float mDetailsHeight;
  EcgFile mEcgFile;
  float mEcgTopMargin;
  h mFallbackFont;
  h mFallbackFontSmall;
  h mFontBold;
  h mFontNormal;
  h mFontSmall;
  float mFooterHeight;
  int mGainPercent = 100;
  final boolean mIsMuscleFilter;
  final boolean mIsTestMode;
  m mLogoImage = null;
  final File mOutFile;
  float mPageLeftMargin;
  float mPageTopMargin;
  objectweb.asm.d mPdf = null;
  int mSampleCount;
  int mSamplesPerStrip;
  int mSpeedPercent = 100;
  int mTotalEcgSamples;
  int mTotalPages;
  final PdfData pdfData;
  private int yAxisScale;
  
  PdfRender(Context paramContext, File paramFile, PdfData paramPdfData, boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = false;
    mSampleCount = 0;
    mContext = paramContext.getApplicationContext();
    mOutFile = paramFile;
    pdfData = paramPdfData;
    mDateTimeFormatter = com.alivecor.mapsforge.core.asm.a.getValue("EEEE, MMM dd yyyy, h:mm:ss a");
    embedFonts = paramBoolean2;
    mIsTestMode = false;
    mIsMuscleFilter = true;
    if (!paramBoolean1) {
      l.a.a.b("Can't disable muscle filter unless in test mode", new Object[0]);
    }
    paramBoolean1 = bool;
    if (isReportRawPDF == ReportRawPDFType.FULL) {
      paramBoolean1 = true;
    }
    isPreviewPDF = paramBoolean1;
    yAxisScale = YAxisScaleTypes.getYAxisScale(yAxisScaleTypes);
  }
  
  private String getDurationString(Resources paramResources)
  {
    return Util.formatDurationString(paramResources, pdfData.recordingDurationMillis);
  }
  
  private String getHeartRateString()
  {
    return Util.formatHeartRateString(pdfData.recordedHr);
  }
  
  private String getPatientAgeString(Resources paramResources)
  {
    return Util.patientAgeString(paramResources, pdfData.recordingDate.y(), pdfData.patientData.lastIndex);
  }
  
  private String getPatientDOBString()
  {
    return Util.getDOBString(pdfData.patientData.lastIndex);
  }
  
  /* Error */
  private void initFonts()
    throws Exception
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 121	com/alivecor/mapsforge/record/PdfRender:embedFonts	Z
    //   4: ifeq +316 -> 320
    //   7: aload_0
    //   8: getfield 105	com/alivecor/mapsforge/record/PdfRender:mContext	Landroid/content/Context;
    //   11: invokevirtual 217	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   14: ldc -37
    //   16: invokevirtual 225	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   19: astore_2
    //   20: aload_0
    //   21: new 227	objectweb/asm/h
    //   24: dup
    //   25: aload_0
    //   26: getfield 89	com/alivecor/mapsforge/record/PdfRender:mPdf	Lobjectweb/asm/d;
    //   29: aload_2
    //   30: iconst_1
    //   31: invokespecial 230	objectweb/asm/h:<init>	(Lobjectweb/asm/d;Ljava/io/InputStream;Z)V
    //   34: putfield 232	com/alivecor/mapsforge/record/PdfRender:mFontNormal	Lobjectweb/asm/h;
    //   37: aload_2
    //   38: ifnull +7 -> 45
    //   41: aload_2
    //   42: invokevirtual 237	java/io/InputStream:close	()V
    //   45: aload_0
    //   46: getfield 105	com/alivecor/mapsforge/record/PdfRender:mContext	Landroid/content/Context;
    //   49: invokevirtual 217	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   52: ldc -37
    //   54: invokevirtual 225	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   57: astore_2
    //   58: aload_0
    //   59: new 227	objectweb/asm/h
    //   62: dup
    //   63: aload_0
    //   64: getfield 89	com/alivecor/mapsforge/record/PdfRender:mPdf	Lobjectweb/asm/d;
    //   67: aload_2
    //   68: iconst_1
    //   69: invokespecial 230	objectweb/asm/h:<init>	(Lobjectweb/asm/d;Ljava/io/InputStream;Z)V
    //   72: putfield 239	com/alivecor/mapsforge/record/PdfRender:mFontSmall	Lobjectweb/asm/h;
    //   75: aload_2
    //   76: ifnull +7 -> 83
    //   79: aload_2
    //   80: invokevirtual 237	java/io/InputStream:close	()V
    //   83: aload_0
    //   84: getfield 105	com/alivecor/mapsforge/record/PdfRender:mContext	Landroid/content/Context;
    //   87: invokevirtual 217	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   90: ldc -15
    //   92: invokevirtual 225	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   95: astore_2
    //   96: aload_0
    //   97: new 227	objectweb/asm/h
    //   100: dup
    //   101: aload_0
    //   102: getfield 89	com/alivecor/mapsforge/record/PdfRender:mPdf	Lobjectweb/asm/d;
    //   105: aload_2
    //   106: iconst_1
    //   107: invokespecial 230	objectweb/asm/h:<init>	(Lobjectweb/asm/d;Ljava/io/InputStream;Z)V
    //   110: putfield 243	com/alivecor/mapsforge/record/PdfRender:mFontBold	Lobjectweb/asm/h;
    //   113: aload_2
    //   114: ifnull +7 -> 121
    //   117: aload_2
    //   118: invokevirtual 237	java/io/InputStream:close	()V
    //   121: aload_0
    //   122: getfield 105	com/alivecor/mapsforge/record/PdfRender:mContext	Landroid/content/Context;
    //   125: invokevirtual 217	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   128: ldc -11
    //   130: invokevirtual 225	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   133: astore_2
    //   134: aload_0
    //   135: new 227	objectweb/asm/h
    //   138: dup
    //   139: aload_0
    //   140: getfield 89	com/alivecor/mapsforge/record/PdfRender:mPdf	Lobjectweb/asm/d;
    //   143: aload_2
    //   144: iconst_1
    //   145: invokespecial 230	objectweb/asm/h:<init>	(Lobjectweb/asm/d;Ljava/io/InputStream;Z)V
    //   148: putfield 247	com/alivecor/mapsforge/record/PdfRender:mFallbackFont	Lobjectweb/asm/h;
    //   151: aload_2
    //   152: ifnull +7 -> 159
    //   155: aload_2
    //   156: invokevirtual 237	java/io/InputStream:close	()V
    //   159: aload_0
    //   160: getfield 105	com/alivecor/mapsforge/record/PdfRender:mContext	Landroid/content/Context;
    //   163: invokevirtual 217	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   166: ldc -11
    //   168: invokevirtual 225	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   171: astore_2
    //   172: aload_0
    //   173: new 227	objectweb/asm/h
    //   176: dup
    //   177: aload_0
    //   178: getfield 89	com/alivecor/mapsforge/record/PdfRender:mPdf	Lobjectweb/asm/d;
    //   181: aload_2
    //   182: iconst_1
    //   183: invokespecial 230	objectweb/asm/h:<init>	(Lobjectweb/asm/d;Ljava/io/InputStream;Z)V
    //   186: putfield 249	com/alivecor/mapsforge/record/PdfRender:mFallbackFontSmall	Lobjectweb/asm/h;
    //   189: aload_2
    //   190: ifnull +7 -> 197
    //   193: aload_2
    //   194: invokevirtual 237	java/io/InputStream:close	()V
    //   197: aload_0
    //   198: getfield 247	com/alivecor/mapsforge/record/PdfRender:mFallbackFont	Lobjectweb/asm/h;
    //   201: ldc -6
    //   203: invokevirtual 254	objectweb/asm/h:a	(F)Lobjectweb/asm/h;
    //   206: pop
    //   207: aload_0
    //   208: getfield 249	com/alivecor/mapsforge/record/PdfRender:mFallbackFontSmall	Lobjectweb/asm/h;
    //   211: ldc -1
    //   213: invokevirtual 254	objectweb/asm/h:a	(F)Lobjectweb/asm/h;
    //   216: pop
    //   217: goto +159 -> 376
    //   220: astore_1
    //   221: aload_2
    //   222: ifnull +16 -> 238
    //   225: aload_2
    //   226: invokevirtual 237	java/io/InputStream:close	()V
    //   229: goto +9 -> 238
    //   232: astore_2
    //   233: aload_1
    //   234: aload_2
    //   235: invokevirtual 259	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   238: aload_1
    //   239: athrow
    //   240: astore_1
    //   241: aload_2
    //   242: ifnull +16 -> 258
    //   245: aload_2
    //   246: invokevirtual 237	java/io/InputStream:close	()V
    //   249: goto +9 -> 258
    //   252: astore_2
    //   253: aload_1
    //   254: aload_2
    //   255: invokevirtual 259	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   258: aload_1
    //   259: athrow
    //   260: astore_1
    //   261: aload_2
    //   262: ifnull +16 -> 278
    //   265: aload_2
    //   266: invokevirtual 237	java/io/InputStream:close	()V
    //   269: goto +9 -> 278
    //   272: astore_2
    //   273: aload_1
    //   274: aload_2
    //   275: invokevirtual 259	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   278: aload_1
    //   279: athrow
    //   280: astore_1
    //   281: aload_2
    //   282: ifnull +16 -> 298
    //   285: aload_2
    //   286: invokevirtual 237	java/io/InputStream:close	()V
    //   289: goto +9 -> 298
    //   292: astore_2
    //   293: aload_1
    //   294: aload_2
    //   295: invokevirtual 259	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   298: aload_1
    //   299: athrow
    //   300: astore_1
    //   301: aload_2
    //   302: ifnull +16 -> 318
    //   305: aload_2
    //   306: invokevirtual 237	java/io/InputStream:close	()V
    //   309: goto +9 -> 318
    //   312: astore_2
    //   313: aload_1
    //   314: aload_2
    //   315: invokevirtual 259	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   318: aload_1
    //   319: athrow
    //   320: aload_0
    //   321: getfield 89	com/alivecor/mapsforge/record/PdfRender:mPdf	Lobjectweb/asm/d;
    //   324: astore_1
    //   325: getstatic 265	objectweb/asm/f:h	Lobjectweb/asm/f;
    //   328: astore_2
    //   329: aload_0
    //   330: new 227	objectweb/asm/h
    //   333: dup
    //   334: aload_1
    //   335: aload_2
    //   336: invokespecial 268	objectweb/asm/h:<init>	(Lobjectweb/asm/d;Lobjectweb/asm/f;)V
    //   339: putfield 232	com/alivecor/mapsforge/record/PdfRender:mFontNormal	Lobjectweb/asm/h;
    //   342: aload_0
    //   343: new 227	objectweb/asm/h
    //   346: dup
    //   347: aload_0
    //   348: getfield 89	com/alivecor/mapsforge/record/PdfRender:mPdf	Lobjectweb/asm/d;
    //   351: aload_2
    //   352: invokespecial 268	objectweb/asm/h:<init>	(Lobjectweb/asm/d;Lobjectweb/asm/f;)V
    //   355: putfield 239	com/alivecor/mapsforge/record/PdfRender:mFontSmall	Lobjectweb/asm/h;
    //   358: aload_0
    //   359: new 227	objectweb/asm/h
    //   362: dup
    //   363: aload_0
    //   364: getfield 89	com/alivecor/mapsforge/record/PdfRender:mPdf	Lobjectweb/asm/d;
    //   367: getstatic 271	objectweb/asm/f:j	Lobjectweb/asm/f;
    //   370: invokespecial 268	objectweb/asm/h:<init>	(Lobjectweb/asm/d;Lobjectweb/asm/f;)V
    //   373: putfield 243	com/alivecor/mapsforge/record/PdfRender:mFontBold	Lobjectweb/asm/h;
    //   376: aload_0
    //   377: getfield 232	com/alivecor/mapsforge/record/PdfRender:mFontNormal	Lobjectweb/asm/h;
    //   380: ldc -6
    //   382: invokevirtual 254	objectweb/asm/h:a	(F)Lobjectweb/asm/h;
    //   385: pop
    //   386: aload_0
    //   387: getfield 239	com/alivecor/mapsforge/record/PdfRender:mFontSmall	Lobjectweb/asm/h;
    //   390: ldc -1
    //   392: invokevirtual 254	objectweb/asm/h:a	(F)Lobjectweb/asm/h;
    //   395: pop
    //   396: aload_0
    //   397: getfield 243	com/alivecor/mapsforge/record/PdfRender:mFontBold	Lobjectweb/asm/h;
    //   400: ldc -6
    //   402: invokevirtual 254	objectweb/asm/h:a	(F)Lobjectweb/asm/h;
    //   405: pop
    //   406: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	407	0	this	PdfRender
    //   220	19	1	localThrowable1	Throwable
    //   240	19	1	localThrowable2	Throwable
    //   260	19	1	localThrowable3	Throwable
    //   280	19	1	localThrowable4	Throwable
    //   300	19	1	localThrowable5	Throwable
    //   324	11	1	localD	objectweb.asm.d
    //   19	207	2	localInputStream	InputStream
    //   232	14	2	localThrowable6	Throwable
    //   252	14	2	localThrowable7	Throwable
    //   272	14	2	localThrowable8	Throwable
    //   292	14	2	localThrowable9	Throwable
    //   312	3	2	localThrowable10	Throwable
    //   328	24	2	localF	objectweb.asm.f
    // Exception table:
    //   from	to	target	type
    //   172	189	220	java/lang/Throwable
    //   225	229	232	java/lang/Throwable
    //   134	151	240	java/lang/Throwable
    //   245	249	252	java/lang/Throwable
    //   96	113	260	java/lang/Throwable
    //   265	269	272	java/lang/Throwable
    //   58	75	280	java/lang/Throwable
    //   285	289	292	java/lang/Throwable
    //   20	37	300	java/lang/Throwable
    //   305	309	312	java/lang/Throwable
  }
  
  private void printCalPulse(ClassWriter paramClassWriter, float paramFloat)
    throws Exception
  {
    paramClassWriter.b();
    paramClassWriter.a(0.8D);
    paramClassWriter.init(0);
    paramClassWriter.c(1);
    paramClassWriter.f(1);
    float f2 = mSpeedPercent * 5 / 100.0F;
    float f4 = mGainPercent * 10 / 100.0F;
    double d1 = mPageLeftMargin;
    float f1 = 85.039375F + paramFloat;
    double d2 = f1;
    paramClassWriter.b(d1 + 7.086614370346069D, d2);
    paramClassWriter.c(mPageLeftMargin + 14.173229F, f1);
    float f3 = mPageLeftMargin;
    paramFloat += (30.0F - f4) * 2.8346457F;
    paramClassWriter.c(f3 + 14.173229F, paramFloat);
    f3 = mPageLeftMargin;
    f2 += 5.0F;
    f4 = 2.8346457F * f2;
    paramClassWriter.c(f3 + f4, paramFloat);
    paramClassWriter.c(mPageLeftMargin + f4, f1);
    paramClassWriter.a(mPageLeftMargin + (f2 + 2.5D) * 2.8346457481384277D, d2);
    paramClassWriter.c();
  }
  
  private void printEcg(ClassWriter paramClassWriter, int paramInt)
    throws Exception
  {
    paramClassWriter.put(mPageLeftMargin, mEcgTopMargin, 566.92914F, 680.315F);
    paramClassWriter.a(0.45D);
    float f2 = mGainPercent / 100.0F * 2.8346457F * 10.0F / 2000.0F;
    float f1 = f2;
    if (pdfData.isInverted) {
      f1 = -f2;
    }
    int n = mSampleCount;
    int m = 0;
    int i = 0;
    int i1;
    int k;
    int j;
    for (;;)
    {
      i1 = mSampleCount;
      int i2 = mTotalEcgSamples;
      if ((i1 >= i2) || (i >= 4)) {
        break;
      }
      k = mSamplesPerStrip;
      if ((paramInt == 1) && (i == 0)) {
        j = mCalpulseOffsetSamples;
      } else {
        j = 0;
      }
      k -= j;
      j = k;
      if (i1 + k > i2) {
        j = i2 - i1;
      }
      k = 0;
      while (k < j)
      {
        localObject = ecgBuf1;
        i1 = mSampleCount;
        float f3 = localObject[i1];
        i2 = mCalpulseOffsetSamples;
        int i3 = mSamplesPerStrip;
        f2 = mPageLeftMargin + (i1 + i2) % i3 * 200.0F / i3 * 2.8346457F;
        f3 = mEcgTopMargin + (i * 60 + 30) * 2.8346457F - f3 * f1;
        if (k == 0) {
          paramClassWriter.a(f2, f3);
        } else {
          paramClassWriter.c(f2, f3);
        }
        mSampleCount += 1;
        k += 1;
      }
      paramClassWriter.c();
      i += 1;
    }
    Object localObject = mAnnArray;
    if ((localObject != null) && (localObject.length > 0))
    {
      paramClassWriter.a(1.2D);
      localObject = mAnnArray;
      i = localObject.length;
      paramInt = m;
      while (paramInt < i)
      {
        j = localObject[paramInt];
        if (j > mSampleCount) {
          break;
        }
        k = mCalpulseOffsetSamples + j;
        m = mSamplesPerStrip;
        i1 = k / m;
        if (j > n)
        {
          double d1 = mPageLeftMargin;
          double d2 = k % m * 200.0D;
          double d3 = d2 / m;
          f1 = mEcgTopMargin;
          j = (i1 % 4 + 1) * 60;
          paramClassWriter.b(d1 + d3 * 2.8346457481384277D, f1 + j * 2.8346457F);
          paramClassWriter.a(mPageLeftMargin + d2 / mSamplesPerStrip * 2.8346457481384277D, mEcgTopMargin + (j - 2) * 2.8346457F);
        }
        paramInt += 1;
      }
      paramClassWriter.c();
    }
  }
  
  private int printEcgLead(ClassWriter paramClassWriter, int paramInt1, int paramInt2, int paramInt3, String paramString, short[] paramArrayOfShort, float paramFloat)
    throws Exception
  {
    paramClassWriter.a(0.45D);
    float f1 = mGainPercent / 100.0F * 2.8346457F * 10.0F / 2000.0F;
    objectweb.asm.a localA = new objectweb.asm.a(mFontBold);
    localA.a(paramString);
    float f2 = mPageLeftMargin;
    float f3 = paramFloat + 70.86614F;
    localA.set(f2 + 34.015747F, f3);
    localA.a(mPageLeftMargin + 34.015747F, f3);
    localA.a(paramClassWriter);
    int k = mSamplesPerStrip;
    if (paramInt1 == 1) {
      paramInt1 = paramInt3;
    } else {
      paramInt1 = 0;
    }
    int i = 0;
    int j = 0;
    while (i < k - paramInt1)
    {
      int m = paramInt2 + i;
      if (m >= paramArrayOfShort.length)
      {
        l.a.a.g("Didn't have sample at index %d", new Object[] { Integer.valueOf(m) });
        break;
      }
      f3 = paramArrayOfShort[m];
      m = mSamplesPerStrip;
      f2 = mPageLeftMargin + (j + paramInt3) % m * 200.0F / m * 2.8346457F;
      f3 = paramFloat + 85.039375F - f3 * f1;
      if (i == 0) {
        paramClassWriter.a(f2, f3);
      } else {
        paramClassWriter.c(f2, f3);
      }
      j += 1;
      i += 1;
    }
    paramClassWriter.c();
    return j;
  }
  
  private void printFooter(ClassWriter paramClassWriter, int paramInt)
    throws Exception
  {
    objectweb.asm.a localA = new objectweb.asm.a(mFontSmall);
    localA.a(mFallbackFontSmall);
    StringBuilder localStringBuilder;
    float f1;
    float f2;
    if (pdfData.recordingDurationMillis / 1000L > 30L)
    {
      localA.a(mContext.getString(R.string.kai_30_seconds_disclaimer_pdf));
      localA.a(mPageLeftMargin, mEcgTopMargin + 680.315F + localA.b());
      localA.a(paramClassWriter);
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("(c) Copyright 2013, AliveCor Inc. ");
      localStringBuilder.append(mAppName);
      localStringBuilder.append(" ");
      localStringBuilder.append(mAppVersion);
      localStringBuilder.append(", UUID: ");
      localStringBuilder.append(pdfData.recordingUuid);
      localA.a(localStringBuilder.toString());
      f1 = mPageLeftMargin;
      f2 = mEcgTopMargin + 691.65356F;
    }
    else
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("(c) Copyright 2013, AliveCor Inc. ");
      localStringBuilder.append(mAppName);
      localStringBuilder.append(" ");
      localStringBuilder.append(mAppVersion);
      localStringBuilder.append(", UUID: ");
      localStringBuilder.append(pdfData.recordingUuid);
      localA.a(localStringBuilder.toString());
      f1 = mPageLeftMargin;
      f2 = mEcgTopMargin + 680.315F;
    }
    localA.a(f1, f2 + localA.b());
    localA.a(paramClassWriter);
    localA.a(String.format(Locale.US, "Page %d of %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(mTotalPages) }));
    localA.a(mPageLeftMargin + 566.92914F - localA.a(), mEcgTopMargin + 680.315F + localA.b());
    localA.a(paramClassWriter);
  }
  
  private ArrayList splitWithDelimiters(h paramH, String paramString, Float paramFloat)
  {
    ArrayList localArrayList = new ArrayList();
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject1 = Pattern.compile("(\\S+)(\\s+)");
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(paramString);
    ((StringBuilder)localObject2).append(" ");
    Matcher localMatcher = ((Pattern)localObject1).matcher(((StringBuilder)localObject2).toString());
    for (;;)
    {
      paramString = "";
      int j;
      int k;
      do
      {
        if (!localMatcher.find()) {
          break;
        }
        String str = localMatcher.group(2);
        j = 1;
        localObject1 = localMatcher.group(1);
        k = Util.countMatches(str, NEW_LINE);
        localObject2 = paramString;
        do
        {
          paramString = new StringBuilder();
          paramString.append(localStringBuilder);
          paramString.append((String)localObject2);
          paramString.append((String)localObject1);
          if (paramH.a(paramString.toString()) > paramFloat.floatValue())
          {
            if (localStringBuilder.length() == 0)
            {
              i = paramH.b((String)localObject1, paramFloat.floatValue());
              localArrayList.add(((String)localObject1).substring(0, i));
              localObject1 = ((String)localObject1).substring(i);
            }
            else
            {
              localArrayList.add(localStringBuilder.toString());
              localStringBuilder.setLength(0);
            }
            paramString = "";
            i = 1;
          }
          else
          {
            localStringBuilder.append((String)localObject2);
            localStringBuilder.append((String)localObject1);
            paramString = str;
            i = 0;
          }
          localObject2 = paramString;
        } while (i != 0);
      } while (k <= 0);
      i = j;
      if (localStringBuilder.length() > 0)
      {
        localArrayList.add(localStringBuilder.toString());
        i = j;
      }
      while (i < k)
      {
        localArrayList.add("");
        i += 1;
      }
      localStringBuilder.setLength(0);
    }
    if (localStringBuilder.length() > 0) {
      localArrayList.add(localStringBuilder.toString());
    }
    int i = 0;
    while (i < localArrayList.size())
    {
      paramH = new StringBuilder();
      paramH.append("Line ");
      i += 1;
      paramH.append(i);
      paramH.append(":");
      paramH.append((String)localArrayList.get(0));
      l.a.a.d(paramH.toString(), new Object[0]);
    }
    return localArrayList;
  }
  
  void createReport()
    throws Exception
  {
    Object localObject1 = pdfData;
    mAppName = appName;
    localObject1 = recordingUuid;
    try
    {
      localObject1 = com.alivecor.mapsforge.core.asm.b.getId((String)localObject1);
      localObject3 = pdfData;
      boolean bool = isEnhancedFilter;
      int m = 1;
      if (bool)
      {
        localObject1 = recordingUuid;
        localObject1 = com.alivecor.mapsforge.core.asm.b.copyFile((String)localObject1);
        bool = ((File)localObject1).exists();
        if (!bool) {
          l.a.a.h("Couldn't find expected Enhanced-Filtered file: %s.", new Object[] { localObject1 });
        }
        localObject1 = pdfData.recordingUuid;
        localObject1 = com.alivecor.mapsforge.core.asm.b.toString((String)localObject1);
      }
      localObject3 = new EcgFile();
      mEcgFile = ((EcgFile)localObject3);
      bool = ((EcgFile)localObject3).open((String)localObject1);
      if (bool)
      {
        localObject1 = mEcgFile;
        int i = ((EcgFile)localObject1).getTotalLead1Samples();
        if (i >= 2)
        {
          localObject1 = mEcgFile.mAliveInfo.recorderSW;
          l.a.a.g("createReport(): Created on version %s", new Object[] { localObject1 });
          mAppVersion = mEcgFile.mAliveInfo.recorderSW;
          localObject1 = mOutFile;
          localObject1 = new objectweb.asm.d(new BufferedOutputStream(new FileOutputStream((File)localObject1)));
          mPdf = ((objectweb.asm.d)localObject1);
          float f1 = yAxisScale;
          i = (int)100.0F;
          mSpeedPercent = i;
          f1 = f1 * 100.0F / 10.0F;
          mGainPercent = ((int)f1);
          mSampleCount = 0;
          double d1 = i;
          d1 = 240000.0D / d1;
          mSamplesPerStrip = ((int)d1);
          localObject3 = pdfData.recordingDate;
          StringBuilder localStringBuilder = new StringBuilder();
          String str = mAppName;
          localStringBuilder.append(str);
          localStringBuilder.append(" ECG - ");
          localStringBuilder.append(org.joda.time.format.a.f().g((o)localObject3));
          ((objectweb.asm.d)localObject1).d(localStringBuilder.toString());
          localObject1 = mPdf;
          ((objectweb.asm.d)localObject1).a("");
          localObject1 = mPdf;
          ((objectweb.asm.d)localObject1).e("AliveCor Inc.");
          localObject1 = pdfData.logoAsset;
          localObject3 = mContext;
          try
          {
            localObject1 = new BufferedInputStream(((Context)localObject3).getAssets().open((String)localObject1));
            localObject3 = mPdf;
            localObject1 = new m((objectweb.asm.d)localObject3, (InputStream)localObject1, 1);
            mLogoImage = ((m)localObject1);
            f1 = ((m)localObject1).g();
            f1 = 79.37008F / f1;
            localObject1 = mLogoImage;
            ((m)localObject1).a(f1);
          }
          catch (Exception localException1)
          {
            l.a.a.c(localException1, "Exception opening png image", new Object[0]);
          }
          prepareECGData();
          Object localObject2 = ecgBuf1;
          if (localObject2 != null)
          {
            localObject2 = ecgBuf2;
            if (localObject2 == null)
            {
              bool = true;
              break label526;
            }
          }
          bool = false;
          label526:
          isSingleLead = bool;
          d1 = mSpeedPercent;
          double d2 = d1 / 100.0D;
          f1 = (float)(d2 * 5.0D + 5.0D + 5.0D);
          mCalpulseOffset_mm = f1;
          d1 = 100.0D / d1 * 300.0D * f1 / 25.0D;
          int k = (int)d1;
          mCalpulseOffsetSamples = k;
          if (bool)
          {
            i = mTotalEcgSamples;
            i += k;
            j = mSamplesPerStrip;
            j *= 4;
          }
          else
          {
            i = mTotalEcgSamples;
            i += k;
            j = mSamplesPerStrip;
          }
          i %= j;
          if (i < 150)
          {
            j = mTotalEcgSamples;
            mTotalEcgSamples = (j - i);
          }
          if (bool)
          {
            i = mTotalEcgSamples;
            d1 = k + i;
            i = mSamplesPerStrip;
            d1 /= i * 4 * 1.0D;
          }
          else
          {
            i = mTotalEcgSamples;
            d1 = k + i;
            d2 = mSamplesPerStrip;
            d1 /= d2 * 1.0D;
          }
          d1 = Math.ceil(d1);
          mTotalPages = ((int)d1);
          initFonts();
          localObject2 = mFontBold;
          f1 = ((h)localObject2).c();
          localObject2 = mFontSmall;
          float f2 = ((h)localObject2).c();
          mDetailsHeight = (f1 * 5.0F + f2 * 2.0F + 5.6692915F);
          localObject2 = mFontSmall;
          f1 = ((h)localObject2).c();
          mFooterHeight = (f1 + 2.8346457F);
          i = mTotalPages;
          l.a.a.a("createReport(): About to render pages.  Total pages %d", new Object[] { Integer.valueOf(i) });
          k = 0;
          int j = 1;
          i = m;
          for (;;)
          {
            m = mTotalPages;
            if (j > m) {
              break;
            }
            localObject2 = pdfData.paperSize;
            localObject3 = PdfData.PaperSize.LETTER;
            if (localObject2 == localObject3) {
              m = i;
            } else {
              m = 0;
            }
            localObject3 = mPdf;
            if (m != 0) {
              localObject2 = R.id.html;
            } else {
              localObject2 = ReportType.html;
            }
            localObject2 = new ClassWriter((objectweb.asm.d)localObject3, (float[])localObject2);
            f1 = ((ClassWriter)localObject2).put();
            mPageLeftMargin = ((f1 - 566.92914F) / 2.0F);
            f2 = ((ClassWriter)localObject2).next();
            f1 = mDetailsHeight;
            float f3 = mFooterHeight;
            f2 = (f2 - 680.315F - f1 - f3) / 2.0F;
            mPageTopMargin = f2;
            mEcgTopMargin = (f2 + f1);
            ((ClassWriter)localObject2).init(0);
            printHeader((ClassWriter)localObject2);
            printGrids((ClassWriter)localObject2);
            printFooter((ClassWriter)localObject2, j);
            bool = isSingleLead;
            if (bool)
            {
              localObject3 = new Object[i];
              localObject3[0] = Integer.valueOf(j);
              l.a.a.a("createReport(): Printing single-lead page %d", (Object[])localObject3);
              if (j == i)
              {
                f1 = mEcgTopMargin;
                printCalPulse((ClassWriter)localObject2, f1);
              }
              printEcg((ClassWriter)localObject2, j);
            }
            else
            {
              localObject3 = new Object[i];
              localObject3[0] = Integer.valueOf(j);
              l.a.a.a("createReport(): Printing six-lead page %d", (Object[])localObject3);
              if (j == i)
              {
                f1 = mEcgTopMargin;
                printCalPulse((ClassWriter)localObject2, f1);
                f1 = mEcgTopMargin;
                printCalPulse((ClassWriter)localObject2, f1 + 110.0F);
                f1 = mEcgTopMargin;
                printCalPulse((ClassWriter)localObject2, f1 + 220.0F);
                f1 = mEcgTopMargin;
                printCalPulse((ClassWriter)localObject2, f1 + 330.0F);
                f1 = mEcgTopMargin;
                printCalPulse((ClassWriter)localObject2, f1 + 440.0F);
                f1 = mEcgTopMargin;
                printCalPulse((ClassWriter)localObject2, f1 + 550.0F);
              }
              if (j == i) {
                i = mCalpulseOffsetSamples;
              } else {
                i = 0;
              }
              f1 = mPageLeftMargin;
              f2 = mEcgTopMargin;
              ((ClassWriter)localObject2).put(f1, f2, 566.92914F, 680.315F);
              localObject3 = ecgBuf1;
              f1 = mEcgTopMargin;
              m = printEcgLead((ClassWriter)localObject2, j, k, i, "I", (short[])localObject3, f1);
              localObject3 = ecgBuf2;
              f1 = mEcgTopMargin;
              printEcgLead((ClassWriter)localObject2, j, k, i, "II", (short[])localObject3, f1 + 110.0F);
              localObject3 = ecgBuf3;
              f1 = mEcgTopMargin;
              printEcgLead((ClassWriter)localObject2, j, k, i, "III", (short[])localObject3, f1 + 220.0F);
              localObject3 = ecgBuf4;
              f1 = mEcgTopMargin;
              printEcgLead((ClassWriter)localObject2, j, k, i, "aVR", (short[])localObject3, f1 + 330.0F);
              localObject3 = ecgBuf5;
              f1 = mEcgTopMargin;
              printEcgLead((ClassWriter)localObject2, j, k, i, "aVL", (short[])localObject3, f1 + 440.0F);
              localObject3 = ecgBuf6;
              f1 = mEcgTopMargin;
              printEcgLead((ClassWriter)localObject2, j, k, i, "aVF", (short[])localObject3, f1 + 550.0F);
              i = 1;
              l.a.a.a("Page %d drew %d samples", new Object[] { Integer.valueOf(j), Integer.valueOf(m) });
              k += m;
            }
            j += 1;
          }
          localObject2 = mPdf;
          ((objectweb.asm.d)localObject2).putNextEntry();
          mPdf = null;
          localObject2 = mEcgFile;
          ((EcgFile)localObject2).close();
          mEcgFile = null;
          localObject2 = mPdf;
          if (localObject2 == null) {
            return;
          }
          try
          {
            ((objectweb.asm.d)localObject2).putNextEntry();
            mPdf = null;
            return;
          }
          catch (Exception localException2)
          {
            l.a.a.c(localException2, "swallowed exception attempting to close files", new Object[0]);
            return;
          }
        }
      }
      throw new Exception("Can't create PDF");
    }
    catch (Throwable localThrowable) {}catch (Exception localException3)
    {
      l.a.a.c(localException3, "Exception generating PDF", new Object[0]);
      throw localException3;
    }
    Object localObject3 = mEcgFile;
    if (localObject3 != null) {}
    try
    {
      ((EcgFile)localObject3).close();
      mEcgFile = null;
      localObject3 = mPdf;
      if (localObject3 != null)
      {
        ((objectweb.asm.d)localObject3).putNextEntry();
        mPdf = null;
      }
    }
    catch (Exception localException4)
    {
      l.a.a.c(localException4, "swallowed exception attempting to close files", new Object[0]);
    }
    throw localException3;
  }
  
  public String getPatientString(Resources paramResources)
  {
    if (pdfData.patientData == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    String str = pdfData.patientData.firstName;
    if (str != null) {
      localStringBuilder.append(str);
    }
    if (pdfData.patientData.lastName != null)
    {
      if (localStringBuilder.length() > 0) {
        localStringBuilder.append(" ");
      }
      localStringBuilder.append(pdfData.patientData.lastName);
    }
    str = getPatientDOBString();
    if (str != null)
    {
      if (localStringBuilder.length() > 0) {
        localStringBuilder.append(", ");
      }
      localStringBuilder.append(str);
      paramResources = getPatientAgeString(paramResources);
      if (paramResources != null)
      {
        localStringBuilder.append(" (");
        localStringBuilder.append(paramResources);
        localStringBuilder.append(")");
      }
    }
    return localStringBuilder.toString();
  }
  
  void prepareECGData()
  {
    int i = mEcgFile.getTotalLead1Samples();
    mTotalEcgSamples = i;
    l.a.a.g("prepareECGData: mTotalEcgSamples is %d", new Object[] { Integer.valueOf(i) });
    Object localObject1 = mEcgFile;
    i = mAliveFormat.flags;
    i = ((EcgFile)localObject1).getAnnotationCount();
    localObject1 = mAnnArray;
    if ((localObject1 != null) && (localObject1.length != i)) {
      mAnnArray = null;
    }
    if (i > 0)
    {
      if (mAnnArray == null) {
        mAnnArray = new int[i];
      }
      System.arraycopy(mEcgFile.getAnnotations(), 0, mAnnArray, 0, i);
      Arrays.sort(mAnnArray);
      i = 0;
      for (;;)
      {
        localObject1 = mAnnArray;
        if ((i >= localObject1.length) || (localObject1[i] >= 0)) {
          break;
        }
        i += 1;
      }
    }
    localObject1 = mEcgFile;
    Object localObject6 = EcgFile.Lead.LEAD_1;
    try
    {
      long l = ((EcgFile)localObject1).samplesForLead((EcgFile.Lead)localObject6);
      l.a.a.g("Lead I samples %d", new Object[] { Long.valueOf(l) });
      localObject1 = mEcgFile;
      Object localObject5 = EcgFile.Lead.LEAD_2;
      l = ((EcgFile)localObject1).samplesForLead((EcgFile.Lead)localObject5);
      l.a.a.g("Lead II samples %d", new Object[] { Long.valueOf(l) });
      localObject1 = mEcgFile;
      Object localObject4 = EcgFile.Lead.LEAD_3;
      l = ((EcgFile)localObject1).samplesForLead((EcgFile.Lead)localObject4);
      l.a.a.g("Lead III samples %d", new Object[] { Long.valueOf(l) });
      localObject1 = mEcgFile;
      Object localObject3 = EcgFile.Lead.LEAD_4;
      l = ((EcgFile)localObject1).samplesForLead((EcgFile.Lead)localObject3);
      l.a.a.g("Lead 4 samples %d", new Object[] { Long.valueOf(l) });
      localObject1 = mEcgFile;
      Object localObject2 = EcgFile.Lead.LEAD_5;
      l = ((EcgFile)localObject1).samplesForLead((EcgFile.Lead)localObject2);
      l.a.a.g("Lead 5 samples %d", new Object[] { Long.valueOf(l) });
      EcgFile localEcgFile = mEcgFile;
      localObject1 = EcgFile.Lead.LEAD_6;
      l = localEcgFile.samplesForLead((EcgFile.Lead)localObject1);
      l.a.a.g("Lead 6 samples %d", new Object[] { Long.valueOf(l) });
      localEcgFile = mEcgFile;
      localEcgFile.samplesForLead((EcgFile.Lead)localObject6);
      localEcgFile = mEcgFile;
      localObject6 = localEcgFile.readEcgSamples((EcgFile.Lead)localObject6);
      ecgBuf1 = ((short[])localObject6);
      localObject6 = mEcgFile;
      l = ((EcgFile)localObject6).samplesForLead((EcgFile.Lead)localObject5);
      if (l > 0L)
      {
        localObject6 = mEcgFile;
        localObject5 = ((EcgFile)localObject6).readEcgSamples((EcgFile.Lead)localObject5);
        ecgBuf2 = ((short[])localObject5);
      }
      localObject5 = mEcgFile;
      l = ((EcgFile)localObject5).samplesForLead((EcgFile.Lead)localObject4);
      if (l > 0L)
      {
        localObject5 = mEcgFile;
        localObject4 = ((EcgFile)localObject5).readEcgSamples((EcgFile.Lead)localObject4);
        ecgBuf3 = ((short[])localObject4);
      }
      localObject4 = mEcgFile;
      l = ((EcgFile)localObject4).samplesForLead((EcgFile.Lead)localObject3);
      if (l > 0L)
      {
        localObject4 = mEcgFile;
        localObject3 = ((EcgFile)localObject4).readEcgSamples((EcgFile.Lead)localObject3);
        ecgBuf4 = ((short[])localObject3);
      }
      localObject3 = mEcgFile;
      l = ((EcgFile)localObject3).samplesForLead((EcgFile.Lead)localObject2);
      if (l > 0L)
      {
        localObject3 = mEcgFile;
        localObject2 = ((EcgFile)localObject3).readEcgSamples((EcgFile.Lead)localObject2);
        ecgBuf5 = ((short[])localObject2);
      }
      localObject2 = mEcgFile;
      l = ((EcgFile)localObject2).samplesForLead((EcgFile.Lead)localObject1);
      if (l > 0L)
      {
        localObject2 = mEcgFile;
        localObject1 = ((EcgFile)localObject2).readEcgSamples((EcgFile.Lead)localObject1);
        ecgBuf6 = ((short[])localObject1);
      }
      if ((!pdfData.isEnhancedFilter) && (!isPreviewPDF))
      {
        localObject1 = MainsFilterFrequency.fromFrequency(mEcgFile.getMainsFreq());
        localObject2 = ecgBuf1;
        if (localObject2 != null) {
          ecgBuf1 = Database.getManga((short[])localObject2, languageIndex);
        }
        localObject2 = ecgBuf2;
        if (localObject2 != null) {
          ecgBuf2 = Database.getManga((short[])localObject2, languageIndex);
        }
        localObject2 = ecgBuf3;
        if (localObject2 != null) {
          ecgBuf3 = Database.getManga((short[])localObject2, languageIndex);
        }
        localObject2 = ecgBuf4;
        if (localObject2 != null) {
          ecgBuf4 = Database.getManga((short[])localObject2, languageIndex);
        }
        localObject2 = ecgBuf5;
        if (localObject2 != null) {
          ecgBuf5 = Database.getManga((short[])localObject2, languageIndex);
        }
        localObject2 = ecgBuf6;
        if (localObject2 != null)
        {
          ecgBuf6 = Database.getManga((short[])localObject2, languageIndex);
          return;
        }
      }
    }
    catch (IOException localIOException)
    {
      l.a.a.c(localIOException, "Error reading ECG samples", new Object[0]);
      throw new RuntimeException(localIOException);
    }
  }
  
  void printGrids(ClassWriter paramClassWriter)
    throws Exception
  {
    paramClassWriter.create(0.82D, 0.82D, 0.95D);
    int j = 0;
    paramClassWriter.c(0);
    paramClassWriter.f(0);
    paramClassWriter.b(0.3F);
    int i = 0;
    float f1;
    float f2;
    float f3;
    while (i < 240)
    {
      if (i % 5 != 0)
      {
        f1 = mPageLeftMargin;
        f2 = mEcgTopMargin;
        f3 = i * 2.8346457F;
        paramClassWriter.a(f1, f2 + f3);
        paramClassWriter.c(mPageLeftMargin + 566.92914F, mEcgTopMargin + f3);
      }
      i += 1;
    }
    paramClassWriter.c();
    i = 0;
    while (i < 200)
    {
      if (i % 5 != 0)
      {
        f1 = mPageLeftMargin;
        f2 = i * 2.8346457F;
        paramClassWriter.a(f1 + f2, mEcgTopMargin);
        paramClassWriter.c(mPageLeftMargin + f2, mEcgTopMargin + 680.315F);
      }
      i += 1;
    }
    paramClassWriter.c();
    paramClassWriter.create(0.55D, 0.55D, 0.55D);
    paramClassWriter.b(0.3F);
    i = 0;
    while (i <= 48)
    {
      if (i % 12 != 0)
      {
        f1 = mPageLeftMargin;
        f2 = mEcgTopMargin;
        f3 = i * 5 * 2.8346457F;
        paramClassWriter.a(f1, f2 + f3);
        paramClassWriter.c(mPageLeftMargin + 566.92914F, mEcgTopMargin + f3);
      }
      i += 1;
    }
    paramClassWriter.c();
    i = 0;
    while (i <= 40)
    {
      if (i % 5 != 0)
      {
        f1 = mPageLeftMargin;
        f2 = i * 5 * 2.8346457F;
        paramClassWriter.a(f1 + f2, mEcgTopMargin);
        paramClassWriter.c(mPageLeftMargin + f2, mEcgTopMargin + 680.315F);
      }
      i += 1;
    }
    paramClassWriter.c();
    if (isSingleLead)
    {
      paramClassWriter.create(0.2D, 0.2D, 0.2D);
      paramClassWriter.b(0.5F);
    }
    i = 0;
    while (i <= 4)
    {
      f1 = mPageLeftMargin;
      f2 = mEcgTopMargin;
      f3 = i * 60 * 2.8346457F;
      paramClassWriter.a(f1, f2 + f3);
      paramClassWriter.c(mPageLeftMargin + 566.92914F, mEcgTopMargin + f3);
      i += 1;
    }
    paramClassWriter.c();
    paramClassWriter.create(0.2D, 0.2D, 0.2D);
    paramClassWriter.b(0.5F);
    i = j;
    while (i <= 8)
    {
      f1 = mPageLeftMargin;
      f2 = i * 25 * 2.8346457F;
      paramClassWriter.a(f1 + f2, mEcgTopMargin);
      paramClassWriter.c(mPageLeftMargin + f2, mEcgTopMargin + 680.315F);
      i += 1;
    }
    paramClassWriter.c();
  }
  
  void printHeader(ClassWriter paramClassWriter)
    throws Exception
  {
    float f4 = mFontBold.c();
    Resources localResources = mContext.getResources();
    String[] arrayOfString1 = new String[5];
    String[] arrayOfString2 = new String[5];
    Object localObject1 = getPatientString(mContext.getResources());
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      arrayOfString1[0] = "";
      arrayOfString2[0] = "";
    }
    else
    {
      arrayOfString1[0] = localResources.getString(R.string.fieldlabel_patient);
      arrayOfString2[0] = localObject1;
    }
    if (TextUtils.isEmpty(pdfData.patientId))
    {
      arrayOfString1[1] = "";
      arrayOfString2[1] = "";
    }
    else
    {
      arrayOfString1[1] = localResources.getString(R.string.fieldlabel_patientid);
      localObject1 = pdfData.patientId;
      if (localObject1 == null) {
        localObject1 = "";
      }
      arrayOfString2[1] = localObject1;
    }
    arrayOfString1[2] = localResources.getString(R.string.fieldlabel_recorded);
    localObject1 = pdfData.recordingDate;
    arrayOfString2[2] = mDateTimeFormatter.a((k.a.a.b)localObject1);
    arrayOfString1[3] = localResources.getString(R.string.fieldlabel_hr);
    arrayOfString2[3] = getHeartRateString();
    if (arrayOfString2[3] != null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(arrayOfString2[3]);
      ((StringBuilder)localObject1).append(" ");
      ((StringBuilder)localObject1).append(localResources.getString(R.string.source));
      arrayOfString2[3] = ((StringBuilder)localObject1).toString();
    }
    else
    {
      arrayOfString2[3] = "---";
    }
    objectweb.asm.a localA1 = new objectweb.asm.a(mFontBold);
    localA1.a(mFallbackFont);
    Object localObject3 = new objectweb.asm.a(mFontNormal);
    ((objectweb.asm.a)localObject3).a(mFallbackFont);
    objectweb.asm.a localA2 = new objectweb.asm.a(mFontSmall);
    localA2.a(mFallbackFontSmall);
    int i = 0;
    float f1 = 0.0F;
    for (float f3 = 0.0F; i < 4; f3 = f2)
    {
      localA1.a(arrayOfString1[i]);
      f2 = f3;
      if (localA1.a() > f3) {
        f2 = localA1.a();
      }
      ((objectweb.asm.a)localObject3).a(arrayOfString2[i]);
      f3 = f1;
      if (((objectweb.asm.a)localObject3).a() > f1) {
        f3 = ((objectweb.asm.a)localObject3).a();
      }
      i += 1;
      f1 = f3;
    }
    float f2 = f1;
    if (f1 > 226.77167F) {
      f2 = 226.77167F;
    }
    f1 = f2;
    if (f2 < 127.55906F) {
      f1 = 127.55906F;
    }
    float f5 = mEcgTopMargin - localA1.b() * 5.0F;
    i = mEcgFile.getMainsFreq();
    boolean bool1 = mEcgFile.getIsNotchFilter();
    boolean bool2 = mEcgFile.getIsBaselineFilter();
    StringBuilder localStringBuilder = new StringBuilder();
    if (pdfData.isEnhancedFilter)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(mContext.getString(R.string.enhanced_filter));
      ((StringBuilder)localObject1).append(", ");
      localStringBuilder.append(((StringBuilder)localObject1).toString());
      if (isPreviewPDF) {
        localObject1 = String.format(localResources.getString(R.string.field_mainsfilter_off), new Object[] { localResources.getString(R.string.ecg_results_invert_off) });
      } else {
        localObject1 = String.format(localResources.getString(R.string.field_mainsfilter), new Object[] { Integer.valueOf(i) });
      }
      localStringBuilder.append((String)localObject1);
    }
    else
    {
      if ((mIsMuscleFilter) || (bool1)) {
        break label665;
      }
    }
    break label757;
    label665:
    if (isPreviewPDF) {
      localObject1 = String.format(localResources.getString(R.string.field_mainsfilter_off), new Object[] { localResources.getString(R.string.ecg_results_invert_off) });
    } else {
      localObject1 = String.format(localResources.getString(R.string.field_mainsfilter), new Object[] { Integer.valueOf(i) });
    }
    localStringBuilder.append((String)localObject1);
    if ((mIsMuscleFilter) && (bool1)) {
      localStringBuilder.append(" notch");
    }
    label757:
    String str1 = " ";
    if (mIsTestMode)
    {
      if (localStringBuilder.length() > 0) {
        localStringBuilder.append("  ");
      }
      localStringBuilder.append("BW: ");
      if (bool2) {
        localObject1 = "0.6";
      } else {
        localObject1 = "0.5";
      }
      localStringBuilder.append((String)localObject1);
      if (!mIsMuscleFilter) {
        localObject1 = " - 40Hz";
      } else if (i == 50) {
        localObject1 = " - 25Hz";
      } else {
        localObject1 = " - 30Hz";
      }
      localStringBuilder.append((String)localObject1);
    }
    String str2 = localResources.getString(R.string.field_scale);
    i = mSpeedPercent;
    if (i == 50) {
      localObject1 = "12.5";
    }
    for (;;)
    {
      break;
      if (i == 100) {
        localObject1 = "25";
      } else if (i == 200) {
        localObject1 = "50";
      } else {
        localObject1 = "";
      }
    }
    i = mGainPercent;
    if (i == 50) {
      localObject2 = "5";
    }
    for (;;)
    {
      break;
      if (i == 100) {
        localObject2 = "10";
      } else if (i == 200) {
        localObject2 = "20";
      } else {
        localObject2 = "";
      }
    }
    localObject1 = String.format(str2, new Object[] { localObject1, localObject2 });
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(localStringBuilder.toString());
    ((StringBuilder)localObject2).append("    ");
    ((StringBuilder)localObject2).append((String)localObject1);
    localA2.a(((StringBuilder)localObject2).toString());
    localA2.a(mPageLeftMargin + 566.92914F - localA2.a(), mEcgTopMargin - mFontSmall.i());
    localA2.a(paramClassWriter);
    i = 0;
    int j = 0;
    localObject1 = localObject3;
    while (i < 4)
    {
      if (arrayOfString2[i] != null)
      {
        localA1.a(arrayOfString1[i]);
        f2 = mPageLeftMargin;
        f6 = j * f4 + f5;
        localA1.a(f2, f6);
        localA1.a(paramClassWriter);
        ((objectweb.asm.a)localObject1).a(arrayOfString2[i]);
        truncateTextLine((objectweb.asm.a)localObject1, 226.77167F, true);
        ((objectweb.asm.a)localObject1).a(mPageLeftMargin + 14.173229F + f3, f6);
        ((objectweb.asm.a)localObject1).a(paramClassWriter);
        j += 1;
      }
      i += 1;
    }
    localA1.a(localResources.getString(R.string.fieldlabel_duration));
    ((objectweb.asm.a)localObject1).a(getDurationString(mContext.getResources()));
    f2 = f3 + 14.173229F + f1 - (localA1.a() + 5.6692915F + ((objectweb.asm.a)localObject1).a());
    float f6 = mPageLeftMargin;
    float f7 = (j - 1) * f4 + f5;
    localA1.a(f6 + f2, f7);
    localA1.a(paramClassWriter);
    ((objectweb.asm.a)localObject1).a(mPageLeftMargin + 5.6692915F + f2 + localA1.a(), f7);
    ((objectweb.asm.a)localObject1).a(paramClassWriter);
    localObject2 = mLogoImage;
    if (localObject2 != null)
    {
      ((m)localObject2).initialize(mPageLeftMargin + 566.92914F - ((m)localObject2).g(), f5 - f4);
      mLogoImage.a(paramClassWriter);
    }
    localObject2 = pdfData.tagString;
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      arrayOfString1[0] = localResources.getString(R.string.fieldlabel_tags);
      arrayOfString2[0] = localObject2;
      j = 1;
    }
    else
    {
      j = 0;
    }
    localObject2 = pdfData.noteString;
    i = j;
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      arrayOfString1[j] = localResources.getString(R.string.fieldlabel_comments);
      arrayOfString2[j] = localObject2;
      i = j + 1;
    }
    localObject2 = mContext.getString(Util.incompatibleGetEcgAnaysisTag(pdfData.finalDetermination));
    int k = i;
    if (localObject2 != null)
    {
      arrayOfString1[i] = localResources.getString(R.string.finding_by_alivecor);
      arrayOfString2[i] = localObject2;
      k = i + 1;
    }
    i = 0;
    for (f2 = 0.0F; i < k; f2 = f4)
    {
      localA1.a(arrayOfString1[i]);
      f4 = f2;
      if (localA1.a() > f2) {
        f4 = localA1.a();
      }
      i += 1;
    }
    f4 = mPageLeftMargin + 14.173229F + f3 + f1 + 22.677166F;
    f6 = f4 + f2 + 5.6692915F;
    if (mLogoImage != null) {
      f3 = paramClassWriter.put() - f6 - mLogoImage.g();
    } else {
      f3 = paramClassWriter.put() - f6;
    }
    int m = 0;
    j = 0;
    f1 = f5;
    localObject2 = str1;
    for (;;)
    {
      f2 = f1;
      if (m >= k) {
        break;
      }
      arrayOfString2[m] = arrayOfString2[m].replace(NEW_LINE, (CharSequence)localObject2);
      localObject3 = splitWithDelimiters(mFontNormal, arrayOfString2[m], Float.valueOf(f3 - 28.346458F));
      f2 = f1;
      i = j;
      if (k == 2)
      {
        f2 = f1;
        i = j;
        if (m == 1)
        {
          f2 = f1;
          i = j;
          if (((ArrayList)localObject3).size() + j < 4)
          {
            f2 = f1 + mFontBold.c();
            i = j + 1;
          }
        }
      }
      localA1.a(arrayOfString1[m]);
      localA1.a(f4, f2);
      localA1.a(paramClassWriter);
      j = 0;
      while (j < ((ArrayList)localObject3).size()) {
        if (i < 5)
        {
          str1 = (String)((ArrayList)localObject3).get(j);
          if ((k != 3) || (m != 1) || (j <= 0))
          {
            while (((k == 3) && (m == 0) && (j > 1)) || ((k == 2) && (j > 2))) {}
            if (str1.length() > 0)
            {
              ((objectweb.asm.a)localObject1).a(f6, j * mFontNormal.c() + f2);
              ((objectweb.asm.a)localObject1).a((String)((ArrayList)localObject3).get(j));
              ((objectweb.asm.a)localObject1).a(paramClassWriter);
            }
            i += 1;
            j += 1;
          }
        }
        else {}
      }
      if (i > 5)
      {
        l.a.a.h("No more room for lines!", new Object[0]);
        break;
      }
      f1 = f2 + j * mFontBold.c();
      m += 1;
      j = i;
    }
    if (mEcgFile.samplesForLead(EcgFile.Lead.LEAD_2) > 0L)
    {
      ((objectweb.asm.a)localObject1).a(f4, f2);
      ((objectweb.asm.a)localObject1).a(mContext.getString(R.string.pdf_analysis_disclaimer));
      ((objectweb.asm.a)localObject1).a(paramClassWriter);
    }
  }
  
  void truncateTextLine(objectweb.asm.a paramA, float paramFloat, boolean paramBoolean)
  {
    if (paramA.a() > paramFloat)
    {
      String str2 = paramA.read();
      int i = str2.length();
      int j;
      do
      {
        j = i - 1;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(str2.substring(0, j));
        String str1;
        if (paramBoolean) {
          str1 = "...";
        } else {
          str1 = "";
        }
        localStringBuilder.append(str1);
        paramA.a(localStringBuilder.toString());
        if (paramA.a() <= paramFloat) {
          break;
        }
        i = j;
      } while (j > 1);
    }
  }
}
