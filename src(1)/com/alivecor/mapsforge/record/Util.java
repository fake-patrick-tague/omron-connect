package com.alivecor.mapsforge.record;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.location.LocationManager;
import android.net.Uri;
import android.nfc.NfcAdapter;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import com.alivecor.alivecorkitlite.R.color;
import com.alivecor.alivecorkitlite.R.plurals;
import com.alivecor.alivecorkitlite.R.string;
import com.alivecor.alivecorkitlite.R.style;
import com.alivecor.asm.Priority;
import com.alivecor.mapsforge.core.model.c;
import com.google.gson.ClassWriter;
import com.google.gson.Gson;
import com.google.gson.d;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import l.a.a;

public class Util
{
  public static final float IN_TO_CM = 2.54F;
  private static final String TAG = "Util";
  private static ThreadLocal<d> threadLocalGson = new ThreadLocal();
  private static final Handler uiHandler = new Handler(Looper.getMainLooper());
  AppPreferences appPreferences;
  
  public Util()
  {
    RecordEkgConfig.getDB().getRecordDependencyComponent().inject(this);
  }
  
  public static int calcAge(long paramLong1, long paramLong2)
  {
    if (paramLong2 == Long.MIN_VALUE) {
      return -1;
    }
    Calendar localCalendar = getUTCCalendar();
    localCalendar.setTimeInMillis(paramLong1);
    int i = localCalendar.get(1);
    int k = localCalendar.get(2);
    int m = localCalendar.get(5);
    localCalendar.setTimeInMillis(paramLong2);
    int j = localCalendar.get(1);
    int n = localCalendar.get(2);
    int i1 = localCalendar.get(5);
    j = i - j;
    if (k >= n)
    {
      i = j;
      if (n == k)
      {
        i = j;
        if (m >= i1) {}
      }
    }
    else
    {
      i = j - 1;
    }
    if (i < 0) {
      return -1;
    }
    return i;
  }
  
  public static int calcAgeInLocale(long paramLong1, long paramLong2)
  {
    if (paramLong2 == Long.MIN_VALUE) {
      return -1;
    }
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(paramLong1);
    int i = localCalendar.get(1);
    int k = localCalendar.get(2);
    int m = localCalendar.get(5);
    localCalendar.setTimeInMillis(paramLong2);
    int j = localCalendar.get(1);
    int n = localCalendar.get(2);
    int i1 = localCalendar.get(5);
    j = i - j;
    if (k >= n)
    {
      i = j;
      if (n == k)
      {
        i = j;
        if (m >= i1) {}
      }
    }
    else
    {
      i = j - 1;
    }
    if (i < 0) {
      return -1;
    }
    return i;
  }
  
  public static Object castRequiredFragmentHost(Context paramContext, Class paramClass)
  {
    Context localContext = paramContext;
    if (paramClass.isInstance(paramContext)) {
      return paramClass.cast(paramContext);
    }
    while ((!paramClass.isInstance(localContext)) && (ContextWrapper.class.isInstance(localContext))) {
      localContext = ((ContextWrapper)ContextWrapper.class.cast(localContext)).getBaseContext();
    }
    if (paramClass.isInstance(localContext)) {
      return paramClass.cast(localContext);
    }
    paramContext = new StringBuilder();
    paramContext.append("Context [");
    paramContext.append(localContext);
    paramContext.append("] must implement ");
    paramContext.append(paramClass);
    throw new IllegalArgumentException(paramContext.toString());
  }
  
  public static boolean contains(Object[] paramArrayOfObject, Object paramObject)
  {
    if (paramArrayOfObject != null)
    {
      if (paramArrayOfObject.length == 0) {
        return false;
      }
      int i = 0;
      while (i < paramArrayOfObject.length)
      {
        if (paramArrayOfObject[i] == paramObject) {
          return true;
        }
        if ((paramObject != null) && (paramObject.equals(paramArrayOfObject[i]))) {
          return true;
        }
        i += 1;
      }
    }
    return false;
  }
  
  public static String copyFileFromAssets(String paramString, File paramFile, Context paramContext)
    throws IOException
  {
    if (paramFile.exists()) {
      return paramFile.getAbsolutePath();
    }
    paramFile.getParentFile().mkdirs();
    streamCopyAndClose(paramContext.getAssets().open(paramString), new FileOutputStream(paramFile));
    return paramFile.getAbsolutePath();
  }
  
  public static String copyFileFromAssetsToData(String paramString1, String paramString2, Context paramContext)
    throws IOException
  {
    return copyFileFromAssets(paramString1, new File(paramContext.getFilesDir(), paramString2), paramContext);
  }
  
  public static int countMatches(String paramString1, String paramString2)
  {
    a.g("countMatches: %s, FOR %s", new Object[] { paramString1, paramString2 });
    if (TextUtils.isEmpty(paramString1)) {
      return 0;
    }
    int i = 0;
    int k;
    for (int j = 0; i < paramString1.length() - paramString2.length() + 1; j = k)
    {
      a.g("countMatches: comparing %s, %s", new Object[] { paramString1.substring(i, paramString2.length()), paramString2 });
      k = j;
      if (paramString1.substring(i, paramString2.length()).equals(paramString2)) {
        k = j + 1;
      }
      i += 1;
    }
    return j;
  }
  
  public static Gson createConfigufredGson()
  {
    return new ClassWriter().a();
  }
  
  public static Map createMap(Object... paramVarArgs)
  {
    HashMap localHashMap = new HashMap();
    int i = 0;
    while (i < paramVarArgs.length)
    {
      localHashMap.put(paramVarArgs[i], paramVarArgs[(i + 1)]);
      i += 2;
    }
    return localHashMap;
  }
  
  public static float[] doublesToFloats(double[] paramArrayOfDouble)
  {
    float[] arrayOfFloat = new float[paramArrayOfDouble.length];
    int i = 0;
    while (i < paramArrayOfDouble.length)
    {
      arrayOfFloat[i] = ((float)paramArrayOfDouble[i]);
      i += 1;
    }
    return arrayOfFloat;
  }
  
  public static short[] doublesToShorts(double[] paramArrayOfDouble)
  {
    int j = paramArrayOfDouble.length;
    short[] arrayOfShort = new short[j];
    int i = 0;
    while (i < j)
    {
      double d2 = paramArrayOfDouble[i];
      double d1;
      if (d2 > 32767.0D)
      {
        d1 = 32767.0D;
      }
      else
      {
        d1 = d2;
        if (d2 < -32768.0D) {
          d1 = -32768.0D;
        }
      }
      arrayOfShort[i] = ((short)(int)d1);
      i += 1;
    }
    return arrayOfShort;
  }
  
  public static float dp2px(float paramFloat, Context paramContext)
  {
    return dp2px(paramFloat, paramContext.getResources().getDisplayMetrics());
  }
  
  public static float dp2px(float paramFloat, DisplayMetrics paramDisplayMetrics)
  {
    return TypedValue.applyDimension(1, paramFloat, paramDisplayMetrics);
  }
  
  public static String formatDurationString(Resources paramResources, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = (int)(paramLong / 3600000L);
    paramLong -= i * 60 * 60 * 1000;
    int j = (int)paramLong / 60000;
    int k = (int)((paramLong - j * 60 * 1000) / 1000L + 0.5D);
    if (i > 0)
    {
      localStringBuilder.append(i);
      localStringBuilder.append(paramResources.getString(R.string.duration_hours));
    }
    if (j > 0)
    {
      if (localStringBuilder.length() > 0) {
        localStringBuilder.append(" ");
      }
      localStringBuilder.append(j);
      localStringBuilder.append(paramResources.getString(R.string.duration_minutes));
    }
    if (k > 0)
    {
      if (localStringBuilder.length() > 0) {
        localStringBuilder.append(" ");
      }
      localStringBuilder.append(k);
      localStringBuilder.append(paramResources.getString(R.string.duration_seconds));
    }
    return localStringBuilder.toString();
  }
  
  public static String formatHeartRateString(float paramFloat)
  {
    if ((!Float.isNaN(paramFloat)) && (paramFloat != Float.NEGATIVE_INFINITY) && (paramFloat != Float.POSITIVE_INFINITY) && (paramFloat > 0.0F)) {
      return String.format(Locale.US, "%.0f", new Object[] { Float.valueOf(paramFloat) });
    }
    return "---";
  }
  
  public static String getDOBString(long paramLong)
  {
    if (paramLong == Long.MIN_VALUE) {
      return null;
    }
    DateFormat localDateFormat = DateFormat.getDateInstance(3, Locale.getDefault());
    localDateFormat.setCalendar(getUTCCalendar());
    return localDateFormat.format(new Date(paramLong));
  }
  
  public static int getEcgAnalysisColor(Priority paramPriority)
  {
    switch (1.$SwitchMap$com$alivecor$ai$Determination[paramPriority.ordinal()])
    {
    default: 
      return R.color.analysis_unsupported;
    case 6: 
    case 7: 
    case 8: 
    case 9: 
      return R.color.analysis_none;
    case 3: 
    case 4: 
    case 5: 
      return R.color.analysis_warning;
    case 2: 
      return R.color.analysis_severe;
    }
    return R.color.analysis_normal;
  }
  
  public static int getEcgAnalysisTag(Priority paramPriority)
  {
    switch (1.$SwitchMap$com$alivecor$ai$Determination[paramPriority.ordinal()])
    {
    default: 
      return R.string.unsupported_result;
    case 9: 
      return R.string.no_analysis;
    case 8: 
      return R.string.long_result;
    case 7: 
      return R.string.short_result;
    case 6: 
      return R.string.noise_detected;
    case 5: 
      return R.string.tachycardia_result;
    case 4: 
      return R.string.bradycardia_result;
    case 3: 
      return R.string.undetermined_result;
    case 2: 
      return R.string.possible_atrial_fibrillation;
    }
    return R.string.nsr_detected_result;
  }
  
  public static Calendar getUTCCalendar()
  {
    GregorianCalendar localGregorianCalendar = new GregorianCalendar(Locale.US);
    localGregorianCalendar.setTimeZone(TimeZone.getTimeZone("UTC"));
    return localGregorianCalendar;
  }
  
  public static int incompatibleGetEcgAnaysisTag(Priority paramPriority)
  {
    switch (1.$SwitchMap$com$alivecor$ai$Determination[paramPriority.ordinal()])
    {
    default: 
      a.h("getEcgAnalysisTag: Unsupported Finding %s", new Object[] { paramPriority });
      return R.string.unsupported_result;
    case 9: 
      return R.string.no_analysis;
    case 8: 
      return R.string.long_result;
    case 7: 
      return R.string.short_result;
    case 6: 
      return R.string.noise_detected;
    case 5: 
      return R.string.tachycardia_result;
    case 4: 
      return R.string.bradycardia_result;
    case 3: 
      return R.string.undetermined_result;
    case 2: 
      return R.string.possible_atrial_fibrillation;
    }
    return R.string.nsr_detected_result;
  }
  
  public static boolean isNFCEnabled(Context paramContext)
  {
    paramContext = NfcAdapter.getDefaultAdapter(paramContext);
    return (paramContext != null) && (paramContext.isEnabled());
  }
  
  public static boolean isNetworkLocationEnabled(LocationManager paramLocationManager)
  {
    return paramLocationManager.isProviderEnabled("network");
  }
  
  public static boolean oneOf(Object paramObject, Object... paramVarArgs)
  {
    return contains(paramVarArgs, paramObject);
  }
  
  public static void openInBrowser(Context paramContext, String paramString)
  {
    String str = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("openInBrowser() url: ");
    localStringBuilder.append(paramString);
    Log.w(str, localStringBuilder.toString());
    if (!TextUtils.isEmpty(paramString))
    {
      paramContext.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(paramString)));
      return;
    }
    paramContext = new StringBuilder();
    paramContext.append("Url must be specified, url: ");
    paramContext.append(paramString);
    throw new IllegalArgumentException(paramContext.toString());
  }
  
  public static String patientAgeString(Resources paramResources, long paramLong1, long paramLong2)
  {
    int i = calcAge(paramLong1, paramLong2);
    if ((i >= 0) && (i < 150)) {
      return paramResources.getQuantityString(R.plurals.profile_years, i, new Object[] { Integer.valueOf(i) });
    }
    return null;
  }
  
  public static float progressOf(double paramDouble1, double paramDouble2, double paramDouble3)
  {
    if (paramDouble2 > paramDouble3)
    {
      if (paramDouble1 > paramDouble2) {
        return 0.0F;
      }
      if (paramDouble1 < paramDouble3) {
        return 1.0F;
      }
    }
    for (paramDouble1 = (paramDouble2 - paramDouble1) / (paramDouble2 - paramDouble3);; paramDouble1 = (paramDouble1 - paramDouble2) / (paramDouble3 - paramDouble2))
    {
      return (float)paramDouble1;
      if (paramDouble1 < paramDouble2) {
        return 0.0F;
      }
      if (paramDouble1 > paramDouble3) {
        return 1.0F;
      }
    }
  }
  
  public static double progressed(float paramFloat, double paramDouble1, double paramDouble2)
  {
    double d = paramFloat;
    if (d < 0.0D) {
      return paramDouble1;
    }
    if (d > 1.0D) {
      return paramDouble2;
    }
    return paramDouble1 + (paramDouble2 - paramDouble1) * d;
  }
  
  /* Error */
  public static void setStatusBarColor(android.view.Window paramWindow, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 512	java/lang/Object:getClass	()Ljava/lang/Class;
    //   4: astore_2
    //   5: getstatic 516	java/lang/Integer:TYPE	Ljava/lang/Class;
    //   8: astore_3
    //   9: aload_2
    //   10: ldc_w 517
    //   13: iconst_1
    //   14: anewarray 94	java/lang/Class
    //   17: dup
    //   18: iconst_0
    //   19: aload_3
    //   20: aastore
    //   21: invokevirtual 521	java/lang/Class:getMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   24: astore_2
    //   25: aload_2
    //   26: ifnull +38 -> 64
    //   29: aload_2
    //   30: aload_0
    //   31: iconst_1
    //   32: anewarray 4	java/lang/Object
    //   35: dup
    //   36: iconst_0
    //   37: iload_1
    //   38: invokestatic 496	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   41: aastore
    //   42: invokevirtual 527	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   45: pop
    //   46: aload_0
    //   47: ldc_w 528
    //   50: invokevirtual 534	android/view/Window:addFlags	(I)V
    //   53: aload_0
    //   54: ldc_w 535
    //   57: invokevirtual 538	android/view/Window:clearFlags	(I)V
    //   60: return
    //   61: astore_0
    //   62: return
    //   63: astore_0
    //   64: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	65	0	paramWindow	android.view.Window
    //   0	65	1	paramInt	int
    //   4	26	2	localObject	Object
    //   8	12	3	localClass	Class
    // Exception table:
    //   from	to	target	type
    //   0	5	61	java/lang/Exception
    //   9	25	63	java/lang/Exception
    //   29	60	63	java/lang/Exception
  }
  
  public static double[] shortsToDoubles(short[] paramArrayOfShort)
  {
    int j = paramArrayOfShort.length;
    double[] arrayOfDouble = new double[j];
    int i = 0;
    while (i < j)
    {
      arrayOfDouble[i] = paramArrayOfShort[i];
      i += 1;
    }
    return arrayOfDouble;
  }
  
  public static ProgressDialog showProgress(Context paramContext)
  {
    return showProgress(paramContext, R.string.loading);
  }
  
  public static ProgressDialog showProgress(Context paramContext, int paramInt)
  {
    return showProgress(paramContext, paramContext.getString(paramInt), false);
  }
  
  public static ProgressDialog showProgress(Context paramContext, int paramInt, boolean paramBoolean)
  {
    return showProgress(paramContext, paramContext.getString(paramInt), paramBoolean);
  }
  
  public static ProgressDialog showProgress(Context paramContext, String paramString, boolean paramBoolean)
  {
    paramContext = new ProgressDialog(paramContext, R.style.LegacyDialogTeal);
    paramContext.setMessage(paramString);
    paramContext.setCancelable(paramBoolean);
    paramContext.setIndeterminate(true);
    paramContext.show();
    return paramContext;
  }
  
  public static void startMyAppSettings(Activity paramActivity)
    throws ActivityNotFoundException
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("package:");
    ((StringBuilder)localObject).append(paramActivity.getPackageName());
    localObject = Uri.parse(((StringBuilder)localObject).toString());
    try
    {
      Intent localIntent1 = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
      localIntent1.addCategory("android.intent.category.DEFAULT");
      localIntent1.setData((Uri)localObject);
      paramActivity.startActivity(localIntent1);
      return;
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
      a.i(localActivityNotFoundException, "Could not start application details settings.  Trying MANAGE_APPLICATION", new Object[0]);
      Intent localIntent2 = new Intent("android.settings.MANAGE_APPLICATIONS_SETTINGS");
      localIntent2.addCategory("android.intent.category.DEFAULT");
      localIntent2.setData((Uri)localObject);
      paramActivity.startActivity(localIntent2);
    }
  }
  
  public static int streamCopy(InputStream paramInputStream, OutputStream paramOutputStream)
    throws IOException
  {
    return streamCopy(paramInputStream, paramOutputStream, new byte[65536], null);
  }
  
  public static int streamCopy(InputStream paramInputStream, OutputStream paramOutputStream, byte[] paramArrayOfByte, boolean[] paramArrayOfBoolean)
    throws IOException
  {
    int i = 0;
    for (;;)
    {
      int j = paramInputStream.read(paramArrayOfByte);
      if (j == -1) {
        break;
      }
      if ((paramArrayOfBoolean != null) && (paramArrayOfBoolean[0] != 0)) {
        return -1;
      }
      paramOutputStream.write(paramArrayOfByte, 0, j);
      i += j;
    }
    return i;
  }
  
  public static int streamCopy(InputStream paramInputStream, OutputStream paramOutputStream, boolean[] paramArrayOfBoolean)
    throws IOException
  {
    return streamCopy(paramInputStream, paramOutputStream, new byte[65536], paramArrayOfBoolean);
  }
  
  public static int streamCopyAndClose(InputStream paramInputStream, OutputStream paramOutputStream)
    throws IOException
  {
    return streamCopyAndClose(paramInputStream, paramOutputStream, null);
  }
  
  public static int streamCopyAndClose(InputStream paramInputStream, OutputStream paramOutputStream, boolean[] paramArrayOfBoolean)
    throws IOException
  {
    int i = streamCopy(paramInputStream, paramOutputStream);
    paramInputStream.close();
    paramOutputStream.close();
    return i;
  }
  
  public static Gson threadLocalGson()
  {
    if (threadLocalGson.get() == null)
    {
      a.g("threadLocalGson: created on thread %d", new Object[] { Long.valueOf(Thread.currentThread().getId()) });
      threadLocalGson.set(createConfigufredGson());
    }
    return (Gson)threadLocalGson.get();
  }
  
  public static int unboxOr(Integer paramInteger, int paramInt)
  {
    if (paramInteger == null) {
      return paramInt;
    }
    return paramInteger.intValue();
  }
  
  public boolean isCurrentDeviceOmron()
  {
    return appPreferences.getSelectedEkgDeviceDebug() == c.J;
  }
  
  public class ProgressDrawableCircle
    extends Drawable
  {
    private float progress;
    private Runnable progressAnimation;
    private float width;
    private Paint workPaint;
    
    public ProgressDrawableCircle(float paramFloat)
    {
      Paint localPaint = new Paint();
      workPaint = localPaint;
      width = paramFloat;
      localPaint.setColor(this$1);
      workPaint.setAntiAlias(true);
      workPaint.setDither(true);
    }
    
    private void setProgressInternal(float paramFloat1, float paramFloat2)
    {
      progress = paramFloat1;
      width = paramFloat2;
      invalidateSelf();
    }
    
    public ProgressDrawableCircle animate(float paramFloat, long paramLong)
    {
      progressAnimation = new Util.ProgressDrawableCircle.1(this, paramLong, paramFloat);
      Util.uiHandler.post(progressAnimation);
      return this;
    }
    
    public void draw(Canvas paramCanvas)
    {
      paramCanvas.drawArc(new RectF(getBounds()), -90.0F, progress * 360.0F / width, true, workPaint);
    }
    
    public int getOpacity()
    {
      return -3;
    }
    
    public float getProgressRatio()
    {
      return progress / width;
    }
    
    public void setAlpha(int paramInt) {}
    
    public ProgressDrawableCircle setColor(int paramInt)
    {
      workPaint.setColor(paramInt);
      invalidateSelf();
      return this;
    }
    
    public void setColorFilter(ColorFilter paramColorFilter) {}
    
    public ProgressDrawableCircle setProgress(float paramFloat)
    {
      return setProgress(paramFloat, width);
    }
    
    public ProgressDrawableCircle setProgress(float paramFloat1, float paramFloat2)
    {
      setProgressInternal(paramFloat1, paramFloat2);
      progressAnimation = null;
      return this;
    }
  }
  
  public class assets
  {
    public static final String PAGE_KEY = "ecgs/nsr.atc";
    public static final String afib1min = "ecgs/afib1min.atc";
    public static final String afib_and_nsr = "ecgs/afib_and_nsr.atc";
    public static final String afib_test = "ecgs/afib_test.atc";
    public static final String afibecg2 = "ecgs/afibecg2.atc";
    public static final String model_identity = "models/identity.tensorflow";
    public static final String model_inversion = "models/inversion.tensorflow";
    public static final String model_noise = "models/noise_det.RF";
    public static final String model_nsr = "models/nsr_model.RF";
    public static final String noise = "ecgs/noise.atc";
    public static final String test = "ecgs/test.atc";
    
    public assets() {}
  }
  
  public class files
  {
    public static final String bpCsvFmt = "BloodPressure_%s.csv";
    public static final String dir_ecgs = "ecgs";
    public static final String dir_exported = "exported";
    public static final String identityModel = "identity.tensorflow";
    public static final String reportPdf = "report.pdf";
    
    public files() {}
  }
}
