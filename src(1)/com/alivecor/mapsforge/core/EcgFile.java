package com.alivecor.mapsforge.core;

import android.location.Location;
import com.alivecor.mapsforge.core.asm.ByteVector;
import com.alivecor.mapsforge.core.asm.b;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import l.a.a;

public class EcgFile
  implements AutoCloseable
{
  private static final long DEBUG;
  private static final long DEBUG_PROTOCOL_IMAP;
  private static final long EXTRA_GOTO_TIME = 2L;
  private static final byte[] IHDR;
  private static final byte[] M;
  private static final int MIN_PREVIEW_PIXELS = 153600;
  private static final long REMOVED_FROM_LIST = 3L;
  public static final int RESOLUTION_ATC_nV = 500;
  private static final byte[] S;
  private static final long SSL_TLS_REQUIRED;
  private static final String TAG = com.alivecor.ecg.core.EcgFile.class.getSimpleName();
  private static final int TYPE_EXPANDED = 1;
  private static final boolean VERSION_FIELD_NUMBER = true;
  private static final long X86_FILTER_ID = 4L;
  private static final byte[] a;
  private static final long hash;
  private static final byte[] header;
  private static final long height;
  private static final long last;
  private static final long library;
  private static final long next;
  private static final byte[] p;
  private static final long protocols;
  private static final byte[] q;
  private static final byte[] r;
  private static final byte[] s;
  private static final byte[] x = { 65, 76, 73, 86, 69, 0, 0, 0 };
  private int B = 50;
  private long bytes;
  private int c;
  private long d;
  private long e;
  private long f;
  public long fileVersion;
  private long g;
  private long h;
  private long id;
  private long l;
  public AliveFileFormat mAliveFormat = new AliveFileFormat();
  public AliveFileInfo mAliveInfo = new AliveFileInfo();
  public int[] mAnnotationArray;
  public int mAnnotationCount = 0;
  public File mFile;
  private Location mLocation;
  public int mStartOffsetSample = 0;
  private long n;
  private long nextId;
  private boolean open;
  private long pageSize;
  private long size;
  private int t = 0;
  private RandomAccessFile this$0;
  private ByteVector[] u = new ByteVector[2];
  private long v;
  private float y = 0.0F;
  
  static
  {
    byte[] arrayOfByte1 = new byte[4];
    arrayOfByte1[0] = 105;
    arrayOfByte1[1] = 110;
    arrayOfByte1[2] = 102;
    arrayOfByte1[3] = 111;
    arrayOfByte1;
    q = arrayOfByte1;
    byte[] arrayOfByte2 = new byte[4];
    byte[] tmp92_91 = arrayOfByte2;
    tmp92_91[0] = 102;
    byte[] tmp97_92 = tmp92_91;
    tmp97_92[1] = 109;
    byte[] tmp102_97 = tmp97_92;
    tmp102_97[2] = 116;
    byte[] tmp107_102 = tmp102_97;
    tmp107_102[3] = 32;
    tmp107_102;
    IHDR = arrayOfByte2;
    byte[] arrayOfByte3 = new byte[4];
    byte[] tmp122_121 = arrayOfByte3;
    tmp122_121[0] = 101;
    byte[] tmp127_122 = tmp122_121;
    tmp127_122[1] = 99;
    byte[] tmp132_127 = tmp127_122;
    tmp132_127[2] = 103;
    byte[] tmp137_132 = tmp132_127;
    tmp137_132[3] = 32;
    tmp137_132;
    header = arrayOfByte3;
    byte[] arrayOfByte4 = new byte[4];
    byte[] tmp152_151 = arrayOfByte4;
    tmp152_151[0] = 101;
    byte[] tmp157_152 = tmp152_151;
    tmp157_152[1] = 99;
    byte[] tmp162_157 = tmp157_152;
    tmp162_157[2] = 103;
    byte[] tmp167_162 = tmp162_157;
    tmp167_162[3] = 50;
    tmp167_162;
    a = arrayOfByte4;
    byte[] arrayOfByte5 = new byte[4];
    byte[] tmp184_182 = arrayOfByte5;
    tmp184_182[0] = 101;
    byte[] tmp189_184 = tmp184_182;
    tmp189_184[1] = 99;
    byte[] tmp194_189 = tmp189_184;
    tmp194_189[2] = 103;
    byte[] tmp199_194 = tmp194_189;
    tmp199_194[3] = 51;
    tmp199_194;
    p = arrayOfByte5;
    byte[] arrayOfByte6 = new byte[4];
    byte[] tmp217_215 = arrayOfByte6;
    tmp217_215[0] = 101;
    byte[] tmp222_217 = tmp217_215;
    tmp222_217[1] = 99;
    byte[] tmp227_222 = tmp222_217;
    tmp227_222[2] = 103;
    byte[] tmp232_227 = tmp227_222;
    tmp232_227[3] = 52;
    tmp232_227;
    r = arrayOfByte6;
    byte[] arrayOfByte7 = new byte[4];
    byte[] tmp250_248 = arrayOfByte7;
    tmp250_248[0] = 101;
    byte[] tmp255_250 = tmp250_248;
    tmp255_250[1] = 99;
    byte[] tmp260_255 = tmp255_250;
    tmp260_255[2] = 103;
    byte[] tmp265_260 = tmp260_255;
    tmp265_260[3] = 53;
    tmp265_260;
    s = arrayOfByte7;
    byte[] arrayOfByte8 = new byte[4];
    byte[] tmp283_281 = arrayOfByte8;
    tmp283_281[0] = 101;
    byte[] tmp288_283 = tmp283_281;
    tmp288_283[1] = 99;
    byte[] tmp293_288 = tmp288_283;
    tmp293_288[2] = 103;
    byte[] tmp298_293 = tmp293_288;
    tmp298_293[3] = 54;
    tmp298_293;
    S = arrayOfByte8;
    byte[] arrayOfByte9 = new byte[4];
    byte[] tmp316_314 = arrayOfByte9;
    tmp316_314[0] = 97;
    byte[] tmp321_316 = tmp316_314;
    tmp321_316[1] = 110;
    byte[] tmp326_321 = tmp321_316;
    tmp326_321[2] = 110;
    byte[] tmp331_326 = tmp326_321;
    tmp331_326[3] = 32;
    tmp331_326;
    M = arrayOfByte9;
    hash = ByteVector.getInt(arrayOfByte1);
    height = ByteVector.getInt(arrayOfByte2);
    next = ByteVector.getInt(arrayOfByte9);
    last = ByteVector.getInt(arrayOfByte3);
    DEBUG = ByteVector.getInt(arrayOfByte4);
    DEBUG_PROTOCOL_IMAP = ByteVector.getInt(arrayOfByte5);
    SSL_TLS_REQUIRED = ByteVector.getInt(arrayOfByte6);
    protocols = ByteVector.getInt(arrayOfByte7);
    library = ByteVector.getInt(arrayOfByte8);
  }
  
  public EcgFile() {}
  
  private float a(int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    int m = 0;
    int i = 0;
    while (i < paramInt1)
    {
      int i1 = paramArrayOfInt[i];
      int j = 0;
      while ((i1 < paramArrayOfInt[j]) && (j < i)) {
        j += 1;
      }
      int k = i - 1;
      while (k >= j)
      {
        paramArrayOfInt[(k + 1)] = paramArrayOfInt[k];
        k -= 1;
      }
      paramArrayOfInt[j] = i1;
      i += 1;
    }
    i = paramInt2 * paramInt1 / 100;
    paramInt2 = i;
    if (i > paramInt1) {
      paramInt2 = paramInt1;
    }
    float f1 = 0.0F;
    i = m;
    while (i < paramInt2)
    {
      f1 += paramArrayOfInt[((paramInt1 - paramInt2 >> 1) + i)];
      i += 1;
    }
    return f1 / paramInt2;
  }
  
  private static long add(ByteVector paramByteVector, int paramInt1, int paramInt2)
  {
    paramByteVector = paramByteVector.getValue();
    long l1 = 0L;
    int i = 0;
    while (i < paramInt2)
    {
      l1 += (paramByteVector[(paramInt1 + i)] & 0xFF);
      i += 1;
    }
    return l1;
  }
  
  private boolean areEqual(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt)
  {
    if ((paramArrayOfByte1 != null) && (paramArrayOfByte2 != null) && (paramArrayOfByte1.length >= paramInt))
    {
      if (paramArrayOfByte2.length < paramInt) {
        return false;
      }
      int i = 0;
      while (i < paramInt)
      {
        if (paramArrayOfByte1[i] != paramArrayOfByte2[i]) {
          return false;
        }
        i += 1;
      }
      return true;
    }
    return false;
  }
  
  private long b(Lead paramLead)
  {
    switch (1.$SwitchMap$com$alivecor$ecg$core$EcgFile$Lead[paramLead.ordinal()])
    {
    default: 
      throw new IllegalArgumentException("Invalid Lead choice.  Do you need to add support for more leads?");
    case 6: 
      return pageSize;
    case 5: 
      return size;
    case 4: 
      return h;
    case 3: 
      return d;
    case 2: 
      return l;
    }
    return e;
  }
  
  private String convertToString()
  {
    Object localObject1 = Locale.US;
    Object localObject2 = GregorianCalendar.getInstance((Locale)localObject1).getTime();
    localObject1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ", (Locale)localObject1).format((Date)localObject2);
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(((String)localObject1).substring(0, 26));
    ((StringBuilder)localObject2).append(":");
    ((StringBuilder)localObject2).append(((String)localObject1).substring(26));
    return ((StringBuilder)localObject2).toString();
  }
  
  private boolean equals(int paramInt1, int paramInt2)
  {
    return (paramInt1 & paramInt2) != 0;
  }
  
  public static short getSample(int paramInt, byte[] paramArrayOfByte)
  {
    paramInt *= 2;
    return toSample(paramArrayOfByte[paramInt], paramArrayOfByte[(paramInt + 1)]);
  }
  
  private static boolean open(long paramLong)
  {
    return (paramLong == last) || (paramLong == DEBUG) || (paramLong == DEBUG_PROTOCOL_IMAP) || (paramLong == SSL_TLS_REQUIRED) || (paramLong == protocols) || (paramLong == library);
  }
  
  private float sqrt()
  {
    int i = mAnnotationCount;
    if (i < 2) {
      return 0.0F;
    }
    int[] arrayOfInt1 = new int[i - 1];
    i = 1;
    int k;
    for (int j = 0; i < mAnnotationCount; j = k)
    {
      int[] arrayOfInt2 = mAnnotationArray;
      int m = arrayOfInt2[i] - arrayOfInt2[(i - 1)];
      k = j;
      if (m >= 60)
      {
        k = j;
        if (m <= 600)
        {
          arrayOfInt1[j] = m;
          k = j + 1;
        }
      }
      i += 1;
    }
    float f1;
    if (j == 1) {
      f1 = arrayOfInt1[0];
    }
    for (;;)
    {
      return 18000.0F / f1;
      if (j == 2)
      {
        f1 = (arrayOfInt1[0] + arrayOfInt1[1]) / 2;
      }
      else
      {
        if (j <= 0) {
          break;
        }
        f1 = a(arrayOfInt1, j, 40);
      }
    }
    return 0.0F;
  }
  
  public static short toSample(byte paramByte1, byte paramByte2)
  {
    return (short)(paramByte1 & 0xFF | paramByte2 << 8);
  }
  
  private static void write(RandomAccessFile paramRandomAccessFile, int[] paramArrayOfInt, int paramInt1, int paramInt2)
    throws IOException
  {
    int i = paramInt2 - paramInt1;
    if (i < 1) {
      return;
    }
    i *= 6;
    ByteVector localByteVector = ByteVector.get(i + 16 + 4);
    localByteVector.add(M);
    localByteVector.add(i + 4);
    localByteVector.add(300L);
    i = 0;
    while (i < paramInt2)
    {
      localByteVector.add(paramArrayOfInt[(paramInt1 + i)]);
      localByteVector.add(1);
      i += 1;
    }
    localByteVector.add(add(localByteVector, 0, localByteVector.a()) & 0xFFFFFFFFFFFFFFFF);
    paramRandomAccessFile.write(localByteVector.getValue(), 0, localByteVector.a());
  }
  
  public void close()
  {
    RandomAccessFile localRandomAccessFile = this$0;
    if (localRandomAccessFile != null)
    {
      try
      {
        localRandomAccessFile.close();
      }
      catch (Exception localException)
      {
        a.b("Exception closing file", new Object[] { localException });
      }
      this$0 = null;
    }
    if (mFile != null) {
      mFile = null;
    }
  }
  
  public void closeAndDelete()
  {
    RandomAccessFile localRandomAccessFile = this$0;
    if (localRandomAccessFile != null)
    {
      try
      {
        localRandomAccessFile.close();
      }
      catch (Exception localException)
      {
        a.b("Exception closing file", new Object[] { localException });
      }
      this$0 = null;
    }
    File localFile = mFile;
    if (localFile != null)
    {
      localFile.delete();
      mFile = null;
    }
  }
  
  public void endEcgWrite(int paramInt)
  {
    if (this$0 != null)
    {
      int i = t;
      int k = (i + 1) % 2;
      Object localObject = u[i];
      try
      {
        int m = ((ByteVector)localObject).a();
        localObject = u[k];
        int j = ((ByteVector)localObject).a();
        i = j;
        int i1 = c - m / 2;
        c = i1;
        c = (i1 - j / 2);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Before Adjustment: prevBufferBytes=");
        ((StringBuilder)localObject).append(j);
        ((StringBuilder)localObject).append(" currBufferBytes=");
        ((StringBuilder)localObject).append(m);
        ((StringBuilder)localObject).append("  totalsample=");
        i1 = c;
        ((StringBuilder)localObject).append(i1);
        localObject = ((StringBuilder)localObject).toString();
        a.d((String)localObject, new Object[0]);
        paramInt *= 2;
        if (m >= paramInt)
        {
          j = m - paramInt;
          paramInt = i;
          i = j;
        }
        else
        {
          paramInt -= m;
          if (j >= paramInt)
          {
            paramInt = j - paramInt;
            i = 0;
          }
          else
          {
            i = 0;
            paramInt = 0;
          }
        }
        RandomAccessFile localRandomAccessFile;
        if (paramInt > 0)
        {
          localObject = u[k];
          localObject = ((ByteVector)localObject).getValue();
          j = 0;
          while (j < paramInt)
          {
            g += (localObject[j] & 0xFF);
            j += 1;
          }
          localRandomAccessFile = this$0;
          localRandomAccessFile.write((byte[])localObject, 0, paramInt);
          c += paramInt / 2;
        }
        if (i > 0)
        {
          localObject = u[t];
          localObject = ((ByteVector)localObject).getValue();
          j = 0;
          while (j < i)
          {
            g += (localObject[j] & 0xFF);
            j += 1;
          }
          localRandomAccessFile = this$0;
          localRandomAccessFile.write((byte[])localObject, 0, i);
          c += i / 2;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("After Adjustment: prevBufferBytes=");
        ((StringBuilder)localObject).append(paramInt);
        ((StringBuilder)localObject).append(" currBufferBytes=");
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append("  totalsample=");
        paramInt = c;
        ((StringBuilder)localObject).append(paramInt);
        localObject = ((StringBuilder)localObject).toString();
        a.d((String)localObject, new Object[0]);
        return;
      }
      catch (Exception localException)
      {
        a.b("Exception updating file", new Object[] { localException });
      }
    }
  }
  
  public int getAnnotationCount()
  {
    return mAnnotationCount;
  }
  
  public int[] getAnnotations()
  {
    return mAnnotationArray;
  }
  
  public float getAverageHeartRate()
  {
    return y;
  }
  
  public boolean getIsBaselineFilter()
  {
    if (fileVersion == 3L) {
      return ((byte)mAliveFormat.flags & 0x20) != 0;
    }
    return true;
  }
  
  public boolean getIsNotchFilter()
  {
    return (fileVersion == 3L) && (((byte)mAliveFormat.flags & 0x10) != 0);
  }
  
  public int getMainsFreq()
  {
    if (((byte)mAliveFormat.flags & 0x2) != 0) {
      return 60;
    }
    return 50;
  }
  
  public String getName()
  {
    File localFile = mFile;
    if (localFile == null) {
      return null;
    }
    return localFile.getName();
  }
  
  public int getTotalLead1Samples()
  {
    return c;
  }
  
  public boolean open(File paramFile)
  {
    return open(paramFile, null);
  }
  
  /* Error */
  public boolean open(File paramFile, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 346	com/alivecor/mapsforge/core/EcgFile:mFile	Ljava/io/File;
    //   4: ifnull +22 -> 26
    //   7: aload_0
    //   8: getfield 335	com/alivecor/mapsforge/core/EcgFile:this$0	Ljava/io/RandomAccessFile;
    //   11: ifnull +15 -> 26
    //   14: getstatic 103	com/alivecor/mapsforge/core/EcgFile:TAG	Ljava/lang/String;
    //   17: ldc_w 399
    //   20: invokestatic 404	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   23: pop
    //   24: iconst_0
    //   25: ireturn
    //   26: aload_0
    //   27: aload_1
    //   28: putfield 346	com/alivecor/mapsforge/core/EcgFile:mFile	Ljava/io/File;
    //   31: aload_0
    //   32: iconst_0
    //   33: putfield 356	com/alivecor/mapsforge/core/EcgFile:c	I
    //   36: aload_0
    //   37: fconst_0
    //   38: putfield 175	com/alivecor/mapsforge/core/EcgFile:y	F
    //   41: aload_0
    //   42: iconst_0
    //   43: putfield 193	com/alivecor/mapsforge/core/EcgFile:mAnnotationCount	I
    //   46: aload_0
    //   47: aconst_null
    //   48: putfield 406	com/alivecor/mapsforge/core/EcgFile:mLocation	Landroid/location/Location;
    //   51: aload_0
    //   52: aconst_null
    //   53: putfield 296	com/alivecor/mapsforge/core/EcgFile:mAnnotationArray	[I
    //   56: sipush 512
    //   59: invokestatic 307	com/alivecor/mapsforge/core/asm/ByteVector:get	(I)Lcom/alivecor/mapsforge/core/asm/ByteVector;
    //   62: astore 22
    //   64: aload 22
    //   66: astore_1
    //   67: aload_0
    //   68: getfield 346	com/alivecor/mapsforge/core/EcgFile:mFile	Ljava/io/File;
    //   71: astore 23
    //   73: aload_2
    //   74: astore 21
    //   76: aload_2
    //   77: ifnonnull +11 -> 88
    //   80: ldc_w 407
    //   83: astore 21
    //   85: goto +3 -> 88
    //   88: new 326	java/io/RandomAccessFile
    //   91: dup
    //   92: aload 23
    //   94: aload 21
    //   96: invokespecial 410	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   99: astore 21
    //   101: aload_0
    //   102: aload 21
    //   104: putfield 335	com/alivecor/mapsforge/core/EcgFile:this$0	Ljava/io/RandomAccessFile;
    //   107: aload 22
    //   109: invokevirtual 200	com/alivecor/mapsforge/core/asm/ByteVector:getValue	()[B
    //   112: astore 23
    //   114: getstatic 111	com/alivecor/mapsforge/core/EcgFile:x	[B
    //   117: astore_2
    //   118: aload_2
    //   119: arraylength
    //   120: istore 4
    //   122: aload 21
    //   124: aload 23
    //   126: iconst_0
    //   127: iload 4
    //   129: invokevirtual 414	java/io/RandomAccessFile:read	([BII)I
    //   132: pop
    //   133: aload 22
    //   135: invokevirtual 200	com/alivecor/mapsforge/core/asm/ByteVector:getValue	()[B
    //   138: astore 21
    //   140: aload_2
    //   141: arraylength
    //   142: istore 4
    //   144: aload_0
    //   145: aload 21
    //   147: aload_2
    //   148: iload 4
    //   150: invokespecial 416	com/alivecor/mapsforge/core/EcgFile:areEqual	([B[BI)Z
    //   153: istore 10
    //   155: iload 10
    //   157: ifeq +1279 -> 1436
    //   160: aload 22
    //   162: invokevirtual 418	com/alivecor/mapsforge/core/asm/ByteVector:add	()V
    //   165: aload_0
    //   166: getfield 335	com/alivecor/mapsforge/core/EcgFile:this$0	Ljava/io/RandomAccessFile;
    //   169: astore_2
    //   170: aload_2
    //   171: aload 22
    //   173: invokevirtual 200	com/alivecor/mapsforge/core/asm/ByteVector:getValue	()[B
    //   176: iconst_0
    //   177: iconst_4
    //   178: invokevirtual 414	java/io/RandomAccessFile:read	([BII)I
    //   181: pop
    //   182: aload 22
    //   184: invokevirtual 421	com/alivecor/mapsforge/core/asm/ByteVector:read	()J
    //   187: lstore 11
    //   189: aload_0
    //   190: lload 11
    //   192: putfield 380	com/alivecor/mapsforge/core/EcgFile:fileVersion	J
    //   195: lload 11
    //   197: ldc2_w 19
    //   200: lcmp
    //   201: iflt +1192 -> 1393
    //   204: iconst_0
    //   205: istore 4
    //   207: iconst_0
    //   208: istore 5
    //   210: aload_0
    //   211: getfield 335	com/alivecor/mapsforge/core/EcgFile:this$0	Ljava/io/RandomAccessFile;
    //   214: astore_2
    //   215: aload_2
    //   216: invokevirtual 424	java/io/RandomAccessFile:getFilePointer	()J
    //   219: lstore 11
    //   221: aload_0
    //   222: getfield 335	com/alivecor/mapsforge/core/EcgFile:this$0	Ljava/io/RandomAccessFile;
    //   225: astore_2
    //   226: aload_2
    //   227: invokevirtual 427	java/io/RandomAccessFile:length	()J
    //   230: lstore 13
    //   232: lload 11
    //   234: lload 13
    //   236: lcmp
    //   237: iflt +15 -> 252
    //   240: iload 4
    //   242: ifeq +1339 -> 1581
    //   245: iload 5
    //   247: ifeq +1334 -> 1581
    //   250: iconst_1
    //   251: ireturn
    //   252: aload_1
    //   253: invokevirtual 418	com/alivecor/mapsforge/core/asm/ByteVector:add	()V
    //   256: aload_0
    //   257: getfield 335	com/alivecor/mapsforge/core/EcgFile:this$0	Ljava/io/RandomAccessFile;
    //   260: astore_2
    //   261: aload_2
    //   262: aload_1
    //   263: invokevirtual 200	com/alivecor/mapsforge/core/asm/ByteVector:getValue	()[B
    //   266: iconst_0
    //   267: bipush 8
    //   269: invokevirtual 414	java/io/RandomAccessFile:read	([BII)I
    //   272: pop
    //   273: aload_1
    //   274: iconst_0
    //   275: bipush 8
    //   277: invokestatic 322	com/alivecor/mapsforge/core/EcgFile:add	(Lcom/alivecor/mapsforge/core/asm/ByteVector;II)J
    //   280: lstore 11
    //   282: aload_1
    //   283: invokevirtual 421	com/alivecor/mapsforge/core/asm/ByteVector:read	()J
    //   286: lstore 19
    //   288: aload_1
    //   289: invokevirtual 421	com/alivecor/mapsforge/core/asm/ByteVector:read	()J
    //   292: lstore 17
    //   294: lload 19
    //   296: getstatic 153	com/alivecor/mapsforge/core/EcgFile:hash	J
    //   299: lcmp
    //   300: istore 6
    //   302: iload 6
    //   304: ifeq +442 -> 746
    //   307: lload 19
    //   309: getstatic 155	com/alivecor/mapsforge/core/EcgFile:height	J
    //   312: lcmp
    //   313: ifeq +433 -> 746
    //   316: lload 19
    //   318: getstatic 157	com/alivecor/mapsforge/core/EcgFile:next	J
    //   321: lcmp
    //   322: ifne +6 -> 328
    //   325: goto +421 -> 746
    //   328: lload 19
    //   330: invokestatic 429	com/alivecor/mapsforge/core/EcgFile:open	(J)Z
    //   333: istore 10
    //   335: iload 10
    //   337: ifeq +323 -> 660
    //   340: aload_0
    //   341: getfield 335	com/alivecor/mapsforge/core/EcgFile:this$0	Ljava/io/RandomAccessFile;
    //   344: astore_2
    //   345: aload_2
    //   346: invokevirtual 424	java/io/RandomAccessFile:getFilePointer	()J
    //   349: lstore 15
    //   351: lload 15
    //   353: lstore 11
    //   355: lload 19
    //   357: getstatic 159	com/alivecor/mapsforge/core/EcgFile:last	J
    //   360: lcmp
    //   361: ifne +65 -> 426
    //   364: aload_0
    //   365: lload 17
    //   367: ldc2_w 19
    //   370: ldiv
    //   371: l2i
    //   372: putfield 356	com/alivecor/mapsforge/core/EcgFile:c	I
    //   375: aload_0
    //   376: lload 15
    //   378: putfield 232	com/alivecor/mapsforge/core/EcgFile:e	J
    //   381: aload_0
    //   382: lload 17
    //   384: putfield 431	com/alivecor/mapsforge/core/EcgFile:n	J
    //   387: aload_0
    //   388: getfield 356	com/alivecor/mapsforge/core/EcgFile:c	I
    //   391: istore 6
    //   393: ldc_w 433
    //   396: iconst_2
    //   397: anewarray 4	java/lang/Object
    //   400: dup
    //   401: iconst_0
    //   402: lload 15
    //   404: invokestatic 439	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   407: aastore
    //   408: dup
    //   409: iconst_1
    //   410: iload 6
    //   412: invokestatic 444	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   415: aastore
    //   416: invokestatic 367	l/a/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   419: lload 11
    //   421: lstore 13
    //   423: goto +302 -> 725
    //   426: lload 19
    //   428: getstatic 161	com/alivecor/mapsforge/core/EcgFile:DEBUG	J
    //   431: lcmp
    //   432: ifne +40 -> 472
    //   435: aload_0
    //   436: lload 15
    //   438: putfield 230	com/alivecor/mapsforge/core/EcgFile:l	J
    //   441: aload_0
    //   442: lload 17
    //   444: putfield 446	com/alivecor/mapsforge/core/EcgFile:v	J
    //   447: ldc_w 448
    //   450: iconst_1
    //   451: anewarray 4	java/lang/Object
    //   454: dup
    //   455: iconst_0
    //   456: lload 15
    //   458: invokestatic 439	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   461: aastore
    //   462: invokestatic 367	l/a/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   465: lload 11
    //   467: lstore 13
    //   469: goto +256 -> 725
    //   472: lload 19
    //   474: getstatic 163	com/alivecor/mapsforge/core/EcgFile:DEBUG_PROTOCOL_IMAP	J
    //   477: lcmp
    //   478: ifne +40 -> 518
    //   481: aload_0
    //   482: lload 15
    //   484: putfield 228	com/alivecor/mapsforge/core/EcgFile:d	J
    //   487: aload_0
    //   488: lload 17
    //   490: putfield 450	com/alivecor/mapsforge/core/EcgFile:f	J
    //   493: ldc_w 452
    //   496: iconst_1
    //   497: anewarray 4	java/lang/Object
    //   500: dup
    //   501: iconst_0
    //   502: lload 15
    //   504: invokestatic 439	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   507: aastore
    //   508: invokestatic 367	l/a/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   511: lload 11
    //   513: lstore 13
    //   515: goto +210 -> 725
    //   518: lload 19
    //   520: getstatic 165	com/alivecor/mapsforge/core/EcgFile:SSL_TLS_REQUIRED	J
    //   523: lcmp
    //   524: ifne +40 -> 564
    //   527: aload_0
    //   528: lload 15
    //   530: putfield 226	com/alivecor/mapsforge/core/EcgFile:h	J
    //   533: aload_0
    //   534: lload 17
    //   536: putfield 454	com/alivecor/mapsforge/core/EcgFile:bytes	J
    //   539: ldc_w 456
    //   542: iconst_1
    //   543: anewarray 4	java/lang/Object
    //   546: dup
    //   547: iconst_0
    //   548: lload 15
    //   550: invokestatic 439	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   553: aastore
    //   554: invokestatic 367	l/a/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   557: lload 11
    //   559: lstore 13
    //   561: goto +164 -> 725
    //   564: lload 19
    //   566: getstatic 167	com/alivecor/mapsforge/core/EcgFile:protocols	J
    //   569: lcmp
    //   570: ifne +40 -> 610
    //   573: aload_0
    //   574: lload 15
    //   576: putfield 224	com/alivecor/mapsforge/core/EcgFile:size	J
    //   579: aload_0
    //   580: lload 17
    //   582: putfield 458	com/alivecor/mapsforge/core/EcgFile:id	J
    //   585: ldc_w 460
    //   588: iconst_1
    //   589: anewarray 4	java/lang/Object
    //   592: dup
    //   593: iconst_0
    //   594: lload 15
    //   596: invokestatic 439	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   599: aastore
    //   600: invokestatic 367	l/a/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   603: lload 11
    //   605: lstore 13
    //   607: goto +118 -> 725
    //   610: lload 11
    //   612: lstore 13
    //   614: lload 19
    //   616: getstatic 169	com/alivecor/mapsforge/core/EcgFile:library	J
    //   619: lcmp
    //   620: ifne +105 -> 725
    //   623: aload_0
    //   624: lload 15
    //   626: putfield 222	com/alivecor/mapsforge/core/EcgFile:pageSize	J
    //   629: aload_0
    //   630: lload 17
    //   632: putfield 462	com/alivecor/mapsforge/core/EcgFile:nextId	J
    //   635: ldc_w 464
    //   638: iconst_1
    //   639: anewarray 4	java/lang/Object
    //   642: dup
    //   643: iconst_0
    //   644: lload 15
    //   646: invokestatic 439	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   649: aastore
    //   650: invokestatic 367	l/a/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   653: lload 11
    //   655: lstore 13
    //   657: goto +68 -> 725
    //   660: new 264	java/lang/StringBuilder
    //   663: dup
    //   664: invokespecial 265	java/lang/StringBuilder:<init>	()V
    //   667: astore_2
    //   668: aload_2
    //   669: ldc_w 466
    //   672: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   675: pop
    //   676: aload_2
    //   677: lload 19
    //   679: invokevirtual 469	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   682: pop
    //   683: aload_2
    //   684: ldc_w 471
    //   687: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   690: pop
    //   691: aload_2
    //   692: lload 17
    //   694: invokestatic 474	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   697: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   700: pop
    //   701: aload_2
    //   702: invokevirtual 283	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   705: astore_2
    //   706: aload_2
    //   707: iconst_0
    //   708: anewarray 4	java/lang/Object
    //   711: invokestatic 367	l/a/a:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   714: aload_0
    //   715: getfield 335	com/alivecor/mapsforge/core/EcgFile:this$0	Ljava/io/RandomAccessFile;
    //   718: astore_2
    //   719: aload_2
    //   720: invokevirtual 424	java/io/RandomAccessFile:getFilePointer	()J
    //   723: lstore 13
    //   725: aload_0
    //   726: getfield 335	com/alivecor/mapsforge/core/EcgFile:this$0	Ljava/io/RandomAccessFile;
    //   729: astore_2
    //   730: aload_2
    //   731: lload 13
    //   733: lload 17
    //   735: ladd
    //   736: ldc2_w 41
    //   739: ladd
    //   740: invokevirtual 477	java/io/RandomAccessFile:seek	(J)V
    //   743: goto -533 -> 210
    //   746: lload 17
    //   748: ldc2_w 478
    //   751: lcmp
    //   752: ifgt +583 -> 1335
    //   755: lload 17
    //   757: lconst_0
    //   758: lcmp
    //   759: iflt +576 -> 1335
    //   762: lload 17
    //   764: ldc2_w 41
    //   767: ladd
    //   768: l2i
    //   769: istore 7
    //   771: aload_1
    //   772: invokevirtual 481	com/alivecor/mapsforge/core/asm/ByteVector:get	()I
    //   775: istore 8
    //   777: iload 8
    //   779: iload 7
    //   781: if_icmpge +9 -> 790
    //   784: iload 7
    //   786: invokestatic 307	com/alivecor/mapsforge/core/asm/ByteVector:get	(I)Lcom/alivecor/mapsforge/core/asm/ByteVector;
    //   789: astore_1
    //   790: aload_1
    //   791: invokevirtual 418	com/alivecor/mapsforge/core/asm/ByteVector:add	()V
    //   794: aload_0
    //   795: getfield 335	com/alivecor/mapsforge/core/EcgFile:this$0	Ljava/io/RandomAccessFile;
    //   798: astore_2
    //   799: aload_2
    //   800: aload_1
    //   801: invokevirtual 200	com/alivecor/mapsforge/core/asm/ByteVector:getValue	()[B
    //   804: iconst_0
    //   805: iload 7
    //   807: invokevirtual 414	java/io/RandomAccessFile:read	([BII)I
    //   810: pop
    //   811: lload 17
    //   813: l2i
    //   814: istore 7
    //   816: aload_1
    //   817: iconst_0
    //   818: iload 7
    //   820: invokestatic 322	com/alivecor/mapsforge/core/EcgFile:add	(Lcom/alivecor/mapsforge/core/asm/ByteVector;II)J
    //   823: lstore 13
    //   825: aload_1
    //   826: iload 7
    //   828: invokevirtual 484	com/alivecor/mapsforge/core/asm/ByteVector:read	(I)J
    //   831: lstore 15
    //   833: lload 11
    //   835: lload 13
    //   837: ladd
    //   838: lload 15
    //   840: lcmp
    //   841: ifne +481 -> 1322
    //   844: lload 19
    //   846: getstatic 157	com/alivecor/mapsforge/core/EcgFile:next	J
    //   849: lcmp
    //   850: ifne +125 -> 975
    //   853: lload 17
    //   855: ldc2_w 41
    //   858: lsub
    //   859: l2i
    //   860: istore 9
    //   862: iload 9
    //   864: bipush 6
    //   866: idiv
    //   867: istore 8
    //   869: iload 4
    //   871: istore 6
    //   873: iload 5
    //   875: istore 7
    //   877: iload 8
    //   879: ifle +85 -> 964
    //   882: aload_1
    //   883: invokevirtual 421	com/alivecor/mapsforge/core/asm/ByteVector:read	()J
    //   886: pop2
    //   887: aload_0
    //   888: iload 9
    //   890: bipush 6
    //   892: idiv
    //   893: newarray int
    //   895: putfield 296	com/alivecor/mapsforge/core/EcgFile:mAnnotationArray	[I
    //   898: iconst_0
    //   899: istore 6
    //   901: iload 6
    //   903: iload 8
    //   905: if_icmpge +35 -> 940
    //   908: aload_0
    //   909: getfield 296	com/alivecor/mapsforge/core/EcgFile:mAnnotationArray	[I
    //   912: astore_2
    //   913: aload_1
    //   914: invokevirtual 421	com/alivecor/mapsforge/core/asm/ByteVector:read	()J
    //   917: lstore 11
    //   919: aload_2
    //   920: iload 6
    //   922: lload 11
    //   924: l2i
    //   925: iastore
    //   926: aload_1
    //   927: invokevirtual 486	com/alivecor/mapsforge/core/asm/ByteVector:write	()I
    //   930: pop
    //   931: iload 6
    //   933: iconst_1
    //   934: iadd
    //   935: istore 6
    //   937: goto -36 -> 901
    //   940: aload_0
    //   941: iload 8
    //   943: putfield 193	com/alivecor/mapsforge/core/EcgFile:mAnnotationCount	I
    //   946: aload_0
    //   947: invokespecial 488	com/alivecor/mapsforge/core/EcgFile:sqrt	()F
    //   950: fstore_3
    //   951: aload_0
    //   952: fload_3
    //   953: putfield 175	com/alivecor/mapsforge/core/EcgFile:y	F
    //   956: iload 5
    //   958: istore 7
    //   960: iload 4
    //   962: istore 6
    //   964: iload 6
    //   966: istore 4
    //   968: iload 7
    //   970: istore 5
    //   972: goto -762 -> 210
    //   975: iload 6
    //   977: ifne +221 -> 1198
    //   980: aload_0
    //   981: getfield 188	com/alivecor/mapsforge/core/EcgFile:mAliveInfo	Lcom/alivecor/mapsforge/core/EcgFile$AliveFileInfo;
    //   984: astore_2
    //   985: aload_1
    //   986: bipush 32
    //   988: invokevirtual 490	com/alivecor/mapsforge/core/asm/ByteVector:write	(I)Ljava/lang/String;
    //   991: astore 21
    //   993: aload_2
    //   994: aload 21
    //   996: putfield 493	com/alivecor/mapsforge/core/EcgFile$AliveFileInfo:dateRecorded	Ljava/lang/String;
    //   999: aload_0
    //   1000: getfield 188	com/alivecor/mapsforge/core/EcgFile:mAliveInfo	Lcom/alivecor/mapsforge/core/EcgFile$AliveFileInfo;
    //   1003: astore_2
    //   1004: aload_1
    //   1005: bipush 40
    //   1007: invokevirtual 490	com/alivecor/mapsforge/core/asm/ByteVector:write	(I)Ljava/lang/String;
    //   1010: astore 21
    //   1012: aload_2
    //   1013: aload 21
    //   1015: putfield 496	com/alivecor/mapsforge/core/EcgFile$AliveFileInfo:recordingUUID	Ljava/lang/String;
    //   1018: aload_0
    //   1019: getfield 188	com/alivecor/mapsforge/core/EcgFile:mAliveInfo	Lcom/alivecor/mapsforge/core/EcgFile$AliveFileInfo;
    //   1022: astore_2
    //   1023: aload_1
    //   1024: bipush 44
    //   1026: invokevirtual 490	com/alivecor/mapsforge/core/asm/ByteVector:write	(I)Ljava/lang/String;
    //   1029: astore 21
    //   1031: aload_2
    //   1032: aload 21
    //   1034: putfield 499	com/alivecor/mapsforge/core/EcgFile$AliveFileInfo:phoneUDID	Ljava/lang/String;
    //   1037: aload_0
    //   1038: getfield 188	com/alivecor/mapsforge/core/EcgFile:mAliveInfo	Lcom/alivecor/mapsforge/core/EcgFile$AliveFileInfo;
    //   1041: astore_2
    //   1042: aload_1
    //   1043: bipush 32
    //   1045: invokevirtual 490	com/alivecor/mapsforge/core/asm/ByteVector:write	(I)Ljava/lang/String;
    //   1048: astore 21
    //   1050: aload_2
    //   1051: aload 21
    //   1053: putfield 502	com/alivecor/mapsforge/core/EcgFile$AliveFileInfo:phoneModel	Ljava/lang/String;
    //   1056: aload_0
    //   1057: getfield 188	com/alivecor/mapsforge/core/EcgFile:mAliveInfo	Lcom/alivecor/mapsforge/core/EcgFile$AliveFileInfo;
    //   1060: astore_2
    //   1061: aload_1
    //   1062: bipush 32
    //   1064: invokevirtual 490	com/alivecor/mapsforge/core/asm/ByteVector:write	(I)Ljava/lang/String;
    //   1067: astore 21
    //   1069: aload_2
    //   1070: aload 21
    //   1072: putfield 505	com/alivecor/mapsforge/core/EcgFile$AliveFileInfo:recorderSW	Ljava/lang/String;
    //   1075: aload_0
    //   1076: getfield 188	com/alivecor/mapsforge/core/EcgFile:mAliveInfo	Lcom/alivecor/mapsforge/core/EcgFile$AliveFileInfo;
    //   1079: astore_2
    //   1080: aload_1
    //   1081: bipush 32
    //   1083: invokevirtual 490	com/alivecor/mapsforge/core/asm/ByteVector:write	(I)Ljava/lang/String;
    //   1086: astore 21
    //   1088: aload_2
    //   1089: aload 21
    //   1091: putfield 508	com/alivecor/mapsforge/core/EcgFile$AliveFileInfo:recorderHW	Ljava/lang/String;
    //   1094: aload_0
    //   1095: getfield 188	com/alivecor/mapsforge/core/EcgFile:mAliveInfo	Lcom/alivecor/mapsforge/core/EcgFile$AliveFileInfo;
    //   1098: astore_2
    //   1099: aload_1
    //   1100: bipush 52
    //   1102: invokevirtual 490	com/alivecor/mapsforge/core/asm/ByteVector:write	(I)Ljava/lang/String;
    //   1105: astore 21
    //   1107: aload_2
    //   1108: aload 21
    //   1110: putfield 511	com/alivecor/mapsforge/core/EcgFile$AliveFileInfo:location	Ljava/lang/String;
    //   1113: getstatic 103	com/alivecor/mapsforge/core/EcgFile:TAG	Ljava/lang/String;
    //   1116: astore_2
    //   1117: new 264	java/lang/StringBuilder
    //   1120: dup
    //   1121: invokespecial 265	java/lang/StringBuilder:<init>	()V
    //   1124: astore 21
    //   1126: aload 21
    //   1128: ldc_w 513
    //   1131: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1134: pop
    //   1135: aload_0
    //   1136: getfield 346	com/alivecor/mapsforge/core/EcgFile:mFile	Ljava/io/File;
    //   1139: astore 22
    //   1141: aload 21
    //   1143: aload 22
    //   1145: invokevirtual 388	java/io/File:getName	()Ljava/lang/String;
    //   1148: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1151: pop
    //   1152: aload 21
    //   1154: ldc_w 515
    //   1157: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1160: pop
    //   1161: aload_0
    //   1162: getfield 188	com/alivecor/mapsforge/core/EcgFile:mAliveInfo	Lcom/alivecor/mapsforge/core/EcgFile$AliveFileInfo;
    //   1165: getfield 493	com/alivecor/mapsforge/core/EcgFile$AliveFileInfo:dateRecorded	Ljava/lang/String;
    //   1168: astore 22
    //   1170: aload 21
    //   1172: aload 22
    //   1174: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1177: pop
    //   1178: aload_2
    //   1179: aload 21
    //   1181: invokevirtual 283	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1184: invokestatic 518	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   1187: pop
    //   1188: iconst_1
    //   1189: istore 6
    //   1191: iload 5
    //   1193: istore 7
    //   1195: goto -231 -> 964
    //   1198: lload 19
    //   1200: getstatic 155	com/alivecor/mapsforge/core/EcgFile:height	J
    //   1203: lcmp
    //   1204: ifne +105 -> 1309
    //   1207: aload_0
    //   1208: getfield 191	com/alivecor/mapsforge/core/EcgFile:mAliveFormat	Lcom/alivecor/mapsforge/core/EcgFile$AliveFileFormat;
    //   1211: astore_2
    //   1212: aload_1
    //   1213: invokevirtual 520	com/alivecor/mapsforge/core/asm/ByteVector:d	()I
    //   1216: istore 5
    //   1218: aload_2
    //   1219: iload 5
    //   1221: putfield 522	com/alivecor/mapsforge/core/EcgFile$AliveFileFormat:format	I
    //   1224: aload_0
    //   1225: getfield 191	com/alivecor/mapsforge/core/EcgFile:mAliveFormat	Lcom/alivecor/mapsforge/core/EcgFile$AliveFileFormat;
    //   1228: astore_2
    //   1229: aload_1
    //   1230: invokevirtual 486	com/alivecor/mapsforge/core/asm/ByteVector:write	()I
    //   1233: istore 5
    //   1235: aload_2
    //   1236: iload 5
    //   1238: putfield 525	com/alivecor/mapsforge/core/EcgFile$AliveFileFormat:samplingRate	I
    //   1241: aload_0
    //   1242: getfield 191	com/alivecor/mapsforge/core/EcgFile:mAliveFormat	Lcom/alivecor/mapsforge/core/EcgFile$AliveFileFormat;
    //   1245: astore_2
    //   1246: aload_1
    //   1247: invokevirtual 486	com/alivecor/mapsforge/core/asm/ByteVector:write	()I
    //   1250: istore 5
    //   1252: aload_2
    //   1253: iload 5
    //   1255: putfield 528	com/alivecor/mapsforge/core/EcgFile$AliveFileFormat:resolution_nV	I
    //   1258: aload_0
    //   1259: getfield 191	com/alivecor/mapsforge/core/EcgFile:mAliveFormat	Lcom/alivecor/mapsforge/core/EcgFile$AliveFileFormat;
    //   1262: astore_2
    //   1263: aload_1
    //   1264: invokevirtual 520	com/alivecor/mapsforge/core/asm/ByteVector:d	()I
    //   1267: istore 5
    //   1269: aload_2
    //   1270: iload 5
    //   1272: putfield 383	com/alivecor/mapsforge/core/EcgFile$AliveFileFormat:flags	I
    //   1275: aload_0
    //   1276: getfield 191	com/alivecor/mapsforge/core/EcgFile:mAliveFormat	Lcom/alivecor/mapsforge/core/EcgFile$AliveFileFormat;
    //   1279: getfield 383	com/alivecor/mapsforge/core/EcgFile$AliveFileFormat:flags	I
    //   1282: istore 5
    //   1284: aload_0
    //   1285: iload 5
    //   1287: iconst_1
    //   1288: invokespecial 530	com/alivecor/mapsforge/core/EcgFile:equals	(II)Z
    //   1291: istore 10
    //   1293: aload_0
    //   1294: iload 10
    //   1296: putfield 532	com/alivecor/mapsforge/core/EcgFile:open	Z
    //   1299: iconst_1
    //   1300: istore 7
    //   1302: iload 4
    //   1304: istore 6
    //   1306: goto -342 -> 964
    //   1309: new 333	java/lang/Exception
    //   1312: dup
    //   1313: ldc_w 534
    //   1316: invokespecial 535	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   1319: astore_1
    //   1320: aload_1
    //   1321: athrow
    //   1322: new 333	java/lang/Exception
    //   1325: dup
    //   1326: ldc_w 537
    //   1329: invokespecial 535	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   1332: astore_1
    //   1333: aload_1
    //   1334: athrow
    //   1335: new 264	java/lang/StringBuilder
    //   1338: dup
    //   1339: invokespecial 265	java/lang/StringBuilder:<init>	()V
    //   1342: astore_1
    //   1343: aload_1
    //   1344: ldc_w 539
    //   1347: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1350: pop
    //   1351: aload_1
    //   1352: lload 19
    //   1354: invokestatic 474	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1357: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1360: pop
    //   1361: aload_1
    //   1362: ldc_w 471
    //   1365: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1368: pop
    //   1369: aload_1
    //   1370: lload 17
    //   1372: invokestatic 474	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1375: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1378: pop
    //   1379: new 333	java/lang/Exception
    //   1382: dup
    //   1383: aload_1
    //   1384: invokevirtual 283	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1387: invokespecial 535	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   1390: astore_1
    //   1391: aload_1
    //   1392: athrow
    //   1393: new 264	java/lang/StringBuilder
    //   1396: dup
    //   1397: invokespecial 265	java/lang/StringBuilder:<init>	()V
    //   1400: astore_1
    //   1401: aload_1
    //   1402: ldc_w 541
    //   1405: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1408: pop
    //   1409: aload_0
    //   1410: getfield 380	com/alivecor/mapsforge/core/EcgFile:fileVersion	J
    //   1413: lstore 11
    //   1415: aload_1
    //   1416: lload 11
    //   1418: invokevirtual 469	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1421: pop
    //   1422: new 333	java/lang/Exception
    //   1425: dup
    //   1426: aload_1
    //   1427: invokevirtual 283	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1430: invokespecial 535	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   1433: astore_1
    //   1434: aload_1
    //   1435: athrow
    //   1436: new 333	java/lang/Exception
    //   1439: dup
    //   1440: ldc_w 543
    //   1443: invokespecial 535	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   1446: astore_1
    //   1447: aload_1
    //   1448: athrow
    //   1449: astore_1
    //   1450: goto +19 -> 1469
    //   1453: astore_1
    //   1454: getstatic 103	com/alivecor/mapsforge/core/EcgFile:TAG	Ljava/lang/String;
    //   1457: ldc_w 545
    //   1460: aload_1
    //   1461: invokestatic 548	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   1464: pop
    //   1465: goto +15 -> 1480
    //   1468: astore_1
    //   1469: getstatic 103	com/alivecor/mapsforge/core/EcgFile:TAG	Ljava/lang/String;
    //   1472: ldc_w 543
    //   1475: aload_1
    //   1476: invokestatic 548	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    //   1479: pop
    //   1480: aload_0
    //   1481: aconst_null
    //   1482: putfield 335	com/alivecor/mapsforge/core/EcgFile:this$0	Ljava/io/RandomAccessFile;
    //   1485: aload_0
    //   1486: aconst_null
    //   1487: putfield 346	com/alivecor/mapsforge/core/EcgFile:mFile	Ljava/io/File;
    //   1490: iconst_0
    //   1491: ireturn
    //   1492: getstatic 103	com/alivecor/mapsforge/core/EcgFile:TAG	Ljava/lang/String;
    //   1495: astore_1
    //   1496: new 264	java/lang/StringBuilder
    //   1499: dup
    //   1500: invokespecial 265	java/lang/StringBuilder:<init>	()V
    //   1503: astore_2
    //   1504: aload_2
    //   1505: ldc_w 550
    //   1508: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1511: pop
    //   1512: aload_2
    //   1513: aload_0
    //   1514: getfield 346	com/alivecor/mapsforge/core/EcgFile:mFile	Ljava/io/File;
    //   1517: invokevirtual 553	java/io/File:getPath	()Ljava/lang/String;
    //   1520: invokevirtual 275	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1523: pop
    //   1524: aload_1
    //   1525: aload_2
    //   1526: invokevirtual 283	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1529: invokestatic 404	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   1532: pop
    //   1533: aload_0
    //   1534: aconst_null
    //   1535: putfield 335	com/alivecor/mapsforge/core/EcgFile:this$0	Ljava/io/RandomAccessFile;
    //   1538: aload_0
    //   1539: aconst_null
    //   1540: putfield 346	com/alivecor/mapsforge/core/EcgFile:mFile	Ljava/io/File;
    //   1543: iconst_0
    //   1544: ireturn
    //   1545: astore_1
    //   1546: goto -54 -> 1492
    //   1549: astore_1
    //   1550: goto -58 -> 1492
    //   1553: astore_1
    //   1554: goto -62 -> 1492
    //   1557: astore_1
    //   1558: goto -66 -> 1492
    //   1561: astore_1
    //   1562: goto -70 -> 1492
    //   1565: astore_1
    //   1566: goto -74 -> 1492
    //   1569: astore_1
    //   1570: goto -78 -> 1492
    //   1573: astore_1
    //   1574: goto -82 -> 1492
    //   1577: astore_1
    //   1578: goto -86 -> 1492
    //   1581: iconst_0
    //   1582: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1583	0	this	EcgFile
    //   0	1583	1	paramFile	File
    //   0	1583	2	paramString	String
    //   950	3	3	f1	float
    //   120	1183	4	i	int
    //   208	1078	5	j	int
    //   300	3	6	bool1	boolean
    //   391	914	6	k	int
    //   769	532	7	m	int
    //   775	167	8	i1	int
    //   860	33	9	i2	int
    //   153	1142	10	bool2	boolean
    //   187	1230	11	l1	long
    //   230	606	13	l2	long
    //   349	490	15	l3	long
    //   292	1079	17	l4	long
    //   286	1067	19	l5	long
    //   74	1106	21	localObject1	Object
    //   62	1111	22	localObject2	Object
    //   71	54	23	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   328	335	1449	java/lang/IndexOutOfBoundsException
    //   345	351	1449	java/lang/IndexOutOfBoundsException
    //   393	419	1449	java/lang/IndexOutOfBoundsException
    //   447	465	1449	java/lang/IndexOutOfBoundsException
    //   493	511	1449	java/lang/IndexOutOfBoundsException
    //   539	557	1449	java/lang/IndexOutOfBoundsException
    //   585	603	1449	java/lang/IndexOutOfBoundsException
    //   635	653	1449	java/lang/IndexOutOfBoundsException
    //   660	706	1449	java/lang/IndexOutOfBoundsException
    //   706	714	1449	java/lang/IndexOutOfBoundsException
    //   719	725	1449	java/lang/IndexOutOfBoundsException
    //   730	743	1449	java/lang/IndexOutOfBoundsException
    //   771	777	1449	java/lang/IndexOutOfBoundsException
    //   784	790	1449	java/lang/IndexOutOfBoundsException
    //   790	794	1449	java/lang/IndexOutOfBoundsException
    //   799	811	1449	java/lang/IndexOutOfBoundsException
    //   816	825	1449	java/lang/IndexOutOfBoundsException
    //   825	833	1449	java/lang/IndexOutOfBoundsException
    //   882	887	1449	java/lang/IndexOutOfBoundsException
    //   913	919	1449	java/lang/IndexOutOfBoundsException
    //   926	931	1449	java/lang/IndexOutOfBoundsException
    //   946	951	1449	java/lang/IndexOutOfBoundsException
    //   985	993	1449	java/lang/IndexOutOfBoundsException
    //   1004	1012	1449	java/lang/IndexOutOfBoundsException
    //   1023	1031	1449	java/lang/IndexOutOfBoundsException
    //   1042	1050	1449	java/lang/IndexOutOfBoundsException
    //   1061	1069	1449	java/lang/IndexOutOfBoundsException
    //   1080	1088	1449	java/lang/IndexOutOfBoundsException
    //   1099	1107	1449	java/lang/IndexOutOfBoundsException
    //   1117	1135	1449	java/lang/IndexOutOfBoundsException
    //   1141	1161	1449	java/lang/IndexOutOfBoundsException
    //   1170	1188	1449	java/lang/IndexOutOfBoundsException
    //   1212	1218	1449	java/lang/IndexOutOfBoundsException
    //   1229	1235	1449	java/lang/IndexOutOfBoundsException
    //   1246	1252	1449	java/lang/IndexOutOfBoundsException
    //   1263	1269	1449	java/lang/IndexOutOfBoundsException
    //   1284	1293	1449	java/lang/IndexOutOfBoundsException
    //   1309	1320	1449	java/lang/IndexOutOfBoundsException
    //   1320	1322	1449	java/lang/IndexOutOfBoundsException
    //   1322	1333	1449	java/lang/IndexOutOfBoundsException
    //   1333	1335	1449	java/lang/IndexOutOfBoundsException
    //   1335	1391	1449	java/lang/IndexOutOfBoundsException
    //   1391	1393	1449	java/lang/IndexOutOfBoundsException
    //   1393	1409	1449	java/lang/IndexOutOfBoundsException
    //   1415	1434	1449	java/lang/IndexOutOfBoundsException
    //   1434	1436	1449	java/lang/IndexOutOfBoundsException
    //   1436	1447	1449	java/lang/IndexOutOfBoundsException
    //   1447	1449	1449	java/lang/IndexOutOfBoundsException
    //   56	64	1453	java/lang/Exception
    //   88	101	1453	java/lang/Exception
    //   107	114	1453	java/lang/Exception
    //   122	140	1453	java/lang/Exception
    //   144	155	1453	java/lang/Exception
    //   160	165	1453	java/lang/Exception
    //   170	189	1453	java/lang/Exception
    //   215	221	1453	java/lang/Exception
    //   226	232	1453	java/lang/Exception
    //   252	256	1453	java/lang/Exception
    //   261	294	1453	java/lang/Exception
    //   328	335	1453	java/lang/Exception
    //   345	351	1453	java/lang/Exception
    //   393	419	1453	java/lang/Exception
    //   447	465	1453	java/lang/Exception
    //   493	511	1453	java/lang/Exception
    //   539	557	1453	java/lang/Exception
    //   585	603	1453	java/lang/Exception
    //   635	653	1453	java/lang/Exception
    //   660	706	1453	java/lang/Exception
    //   706	714	1453	java/lang/Exception
    //   719	725	1453	java/lang/Exception
    //   730	743	1453	java/lang/Exception
    //   771	777	1453	java/lang/Exception
    //   784	790	1453	java/lang/Exception
    //   790	794	1453	java/lang/Exception
    //   799	811	1453	java/lang/Exception
    //   816	825	1453	java/lang/Exception
    //   825	833	1453	java/lang/Exception
    //   882	887	1453	java/lang/Exception
    //   913	919	1453	java/lang/Exception
    //   926	931	1453	java/lang/Exception
    //   946	951	1453	java/lang/Exception
    //   985	993	1453	java/lang/Exception
    //   1004	1012	1453	java/lang/Exception
    //   1023	1031	1453	java/lang/Exception
    //   1042	1050	1453	java/lang/Exception
    //   1061	1069	1453	java/lang/Exception
    //   1080	1088	1453	java/lang/Exception
    //   1099	1107	1453	java/lang/Exception
    //   1117	1135	1453	java/lang/Exception
    //   1141	1161	1453	java/lang/Exception
    //   1170	1188	1453	java/lang/Exception
    //   1212	1218	1453	java/lang/Exception
    //   1229	1235	1453	java/lang/Exception
    //   1246	1252	1453	java/lang/Exception
    //   1263	1269	1453	java/lang/Exception
    //   1284	1293	1453	java/lang/Exception
    //   1309	1320	1453	java/lang/Exception
    //   1320	1322	1453	java/lang/Exception
    //   1322	1333	1453	java/lang/Exception
    //   1333	1335	1453	java/lang/Exception
    //   1335	1391	1453	java/lang/Exception
    //   1391	1393	1453	java/lang/Exception
    //   1393	1409	1453	java/lang/Exception
    //   1415	1434	1453	java/lang/Exception
    //   1434	1436	1453	java/lang/Exception
    //   1436	1447	1453	java/lang/Exception
    //   1447	1449	1453	java/lang/Exception
    //   56	64	1468	java/lang/IndexOutOfBoundsException
    //   88	101	1468	java/lang/IndexOutOfBoundsException
    //   107	114	1468	java/lang/IndexOutOfBoundsException
    //   122	140	1468	java/lang/IndexOutOfBoundsException
    //   144	155	1468	java/lang/IndexOutOfBoundsException
    //   160	165	1468	java/lang/IndexOutOfBoundsException
    //   170	189	1468	java/lang/IndexOutOfBoundsException
    //   215	221	1468	java/lang/IndexOutOfBoundsException
    //   226	232	1468	java/lang/IndexOutOfBoundsException
    //   252	256	1468	java/lang/IndexOutOfBoundsException
    //   261	294	1468	java/lang/IndexOutOfBoundsException
    //   56	64	1545	java/io/FileNotFoundException
    //   88	101	1549	java/io/FileNotFoundException
    //   107	114	1549	java/io/FileNotFoundException
    //   122	140	1549	java/io/FileNotFoundException
    //   144	155	1549	java/io/FileNotFoundException
    //   160	165	1549	java/io/FileNotFoundException
    //   170	189	1549	java/io/FileNotFoundException
    //   215	221	1549	java/io/FileNotFoundException
    //   226	232	1549	java/io/FileNotFoundException
    //   252	256	1549	java/io/FileNotFoundException
    //   261	294	1549	java/io/FileNotFoundException
    //   328	335	1553	java/io/FileNotFoundException
    //   345	351	1553	java/io/FileNotFoundException
    //   393	419	1557	java/io/FileNotFoundException
    //   447	465	1561	java/io/FileNotFoundException
    //   493	511	1565	java/io/FileNotFoundException
    //   539	557	1569	java/io/FileNotFoundException
    //   585	603	1573	java/io/FileNotFoundException
    //   635	653	1577	java/io/FileNotFoundException
    //   660	706	1577	java/io/FileNotFoundException
    //   706	714	1577	java/io/FileNotFoundException
    //   719	725	1577	java/io/FileNotFoundException
    //   730	743	1577	java/io/FileNotFoundException
    //   771	777	1577	java/io/FileNotFoundException
    //   784	790	1577	java/io/FileNotFoundException
    //   790	794	1577	java/io/FileNotFoundException
    //   799	811	1577	java/io/FileNotFoundException
    //   816	825	1577	java/io/FileNotFoundException
    //   825	833	1577	java/io/FileNotFoundException
    //   882	887	1577	java/io/FileNotFoundException
    //   913	919	1577	java/io/FileNotFoundException
    //   926	931	1577	java/io/FileNotFoundException
    //   946	951	1577	java/io/FileNotFoundException
    //   985	993	1577	java/io/FileNotFoundException
    //   1004	1012	1577	java/io/FileNotFoundException
    //   1023	1031	1577	java/io/FileNotFoundException
    //   1042	1050	1577	java/io/FileNotFoundException
    //   1061	1069	1577	java/io/FileNotFoundException
    //   1080	1088	1577	java/io/FileNotFoundException
    //   1099	1107	1577	java/io/FileNotFoundException
    //   1117	1135	1577	java/io/FileNotFoundException
    //   1141	1161	1577	java/io/FileNotFoundException
    //   1170	1188	1577	java/io/FileNotFoundException
    //   1212	1218	1577	java/io/FileNotFoundException
    //   1229	1235	1577	java/io/FileNotFoundException
    //   1246	1252	1577	java/io/FileNotFoundException
    //   1263	1269	1577	java/io/FileNotFoundException
    //   1284	1293	1577	java/io/FileNotFoundException
    //   1309	1320	1577	java/io/FileNotFoundException
    //   1322	1333	1577	java/io/FileNotFoundException
    //   1335	1391	1577	java/io/FileNotFoundException
    //   1393	1409	1577	java/io/FileNotFoundException
    //   1415	1434	1577	java/io/FileNotFoundException
    //   1436	1447	1577	java/io/FileNotFoundException
  }
  
  public boolean open(String paramString)
  {
    return open(paramString, null);
  }
  
  public boolean open(String paramString1, String paramString2)
  {
    return open(new File(b.write(), paramString1), paramString2);
  }
  
  public short[] readEcgSamples(Lead paramLead)
    throws IOException
  {
    int j = getTotalLead1Samples();
    byte[] arrayOfByte = new byte[j * 2];
    int i = 0;
    int k = readRawEcgBytes(paramLead, arrayOfByte, 0, j);
    if (k >= j)
    {
      paramLead = new short[j];
      while (i < j)
      {
        paramLead[i] = getSample(i, arrayOfByte);
        i += 1;
      }
      return paramLead;
    }
    paramLead = new StringBuilder();
    paramLead.append("Failed to read all samples. Read: ");
    paramLead.append(k);
    paramLead.append(". Total: ");
    paramLead.append(j);
    throw new IOException(paramLead.toString());
  }
  
  public int readLead1Bytes(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return readRawEcgBytes(Lead.LEAD_1, paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public short[] readLead1Samples()
    throws IOException
  {
    return readEcgSamples(Lead.LEAD_1);
  }
  
  public int readRawEcgBytes(Lead paramLead, byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    RandomAccessFile localRandomAccessFile = this$0;
    if (localRandomAccessFile == null) {
      return 0;
    }
    int j = c;
    if (paramInt1 >= j) {
      return 0;
    }
    int i = paramInt2;
    if (paramInt1 + paramInt2 > j) {
      i = j - paramInt1;
    }
    try
    {
      long l1 = b(paramLead);
      long l2 = paramInt1 * 2;
      localRandomAccessFile.seek(l1 + l2);
      paramLead = this$0;
      paramInt1 = paramLead.read(paramArrayOfByte, 0, i * 2);
      paramInt1 /= 2;
    }
    catch (IOException paramLead)
    {
      for (;;) {}
    }
    paramInt1 = 0;
    if (paramInt1 < 0) {
      return 0;
    }
    return paramInt1;
  }
  
  public void reset()
  {
    c = 0;
    mAnnotationCount = 0;
    Object localObject = u;
    if (localObject[0] != null) {
      localObject[0].add();
    }
    localObject = u;
    if (localObject[1] != null) {
      localObject[1].add();
    }
    localObject = this$0;
    if (localObject != null) {
      try
      {
        ((RandomAccessFile)localObject).setLength(0L);
        return;
      }
      catch (IOException localIOException)
      {
        a.b("Exception truncating file", new Object[] { localIOException });
      }
    }
  }
  
  public long samplesForLead(Lead paramLead)
  {
    switch (1.$SwitchMap$com$alivecor$ecg$core$EcgFile$Lead[paramLead.ordinal()])
    {
    default: 
      throw new IllegalArgumentException("unsupported lead");
    case 6: 
      return nextId;
    case 5: 
      return id;
    case 4: 
      return bytes;
    case 3: 
      return f;
    case 2: 
      return v;
    }
    return n;
  }
  
  public boolean save()
  {
    if (this$0 != null)
    {
      if (mLocation != null) {}
      try
      {
        Object localObject1 = new StringBuilder();
        localObject2 = Locale.US;
        Location localLocation = mLocation;
        double d1 = localLocation.getLatitude();
        localLocation = mLocation;
        double d2 = localLocation.getLongitude();
        ((StringBuilder)localObject1).append(String.format((Locale)localObject2, "geo:%.7f,%.7f", new Object[] { Double.valueOf(d1), Double.valueOf(d2) }));
        localLocation = mLocation;
        boolean bool = localLocation.hasAltitude();
        if (bool)
        {
          localLocation = mLocation;
          d1 = localLocation.getAltitude();
          ((StringBuilder)localObject1).append(String.format((Locale)localObject2, ",%.0f", new Object[] { Double.valueOf(d1) }));
        }
        localLocation = mLocation;
        bool = localLocation.hasAccuracy();
        if (bool)
        {
          localLocation = mLocation;
          f1 = localLocation.getAccuracy();
          ((StringBuilder)localObject1).append(String.format((Locale)localObject2, ";u=%.0f", new Object[] { Float.valueOf(f1) }));
        }
        localObject2 = mAliveInfo;
        localObject1 = ((StringBuilder)localObject1).toString();
        location = ((String)localObject1);
        break label229;
        mAliveInfo.location = "";
        label229:
        float f1 = sqrt();
        y = f1;
        writeHeader();
        localObject1 = this$0;
        long l1 = ((RandomAccessFile)localObject1).getFilePointer();
        long l2 = c * 2;
        ((RandomAccessFile)localObject1).seek(l1 + l2);
        localObject1 = ByteVector.get(4);
        l1 = g;
        ((ByteVector)localObject1).add(l1 & 0xFFFFFFFFFFFFFFFF);
        localObject2 = this$0;
        ((RandomAccessFile)localObject2).write(((ByteVector)localObject1).getValue());
        localObject1 = this$0;
        localObject2 = mAnnotationArray;
        int i = mAnnotationCount;
        write((RandomAccessFile)localObject1, (int[])localObject2, 0, i);
        localObject1 = this$0;
        l1 = ((RandomAccessFile)localObject1).getFilePointer();
        localObject1 = this$0;
        l2 = ((RandomAccessFile)localObject1).length();
        if (l1 != l2)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("Incorrect file size. Len:");
          localObject2 = this$0;
          ((StringBuilder)localObject1).append(((RandomAccessFile)localObject2).length());
          ((StringBuilder)localObject1).append(" Expected: ");
          localObject2 = this$0;
          ((StringBuilder)localObject1).append(((RandomAccessFile)localObject2).getFilePointer());
          localObject1 = ((StringBuilder)localObject1).toString();
          a.b((String)localObject1, new Object[0]);
          localObject1 = this$0;
          ((RandomAccessFile)localObject1).setLength(((RandomAccessFile)localObject1).getFilePointer());
        }
        localObject1 = this$0;
        ((RandomAccessFile)localObject1).close();
      }
      catch (Exception localException)
      {
        a.b("Exception updating and saving file", new Object[] { localException });
      }
      this$0 = null;
      File localFile = new File(b.write(), b.getId(mAliveInfo.recordingUUID));
      if (mFile.renameTo(localFile))
      {
        mFile = localFile;
        return true;
      }
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("Failed to create file ");
      ((StringBuilder)localObject2).append(localFile.toString());
      a.b(((StringBuilder)localObject2).toString(), new Object[0]);
    }
    return false;
  }
  
  public void setLocation(Location paramLocation)
  {
    mLocation = paramLocation;
  }
  
  public void setMainsFrequency(int paramInt)
  {
    B = paramInt;
  }
  
  public void setStartOffsetSample(int paramInt)
  {
    mStartOffsetSample = paramInt;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("EcgFile  [samples: ");
    localStringBuilder.append(c);
    localStringBuilder.append(", name: ");
    Object localObject = mFile;
    if (localObject != null) {
      localObject = ((File)localObject).getAbsolutePath();
    } else {
      localObject = "null";
    }
    localStringBuilder.append((String)localObject);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
  
  public void writeHeader()
    throws IOException
  {
    writeHeader(true);
  }
  
  public void writeHeader(boolean paramBoolean)
    throws IOException
  {
    ByteVector localByteVector = ByteVector.get(512);
    localByteVector.add(x);
    localByteVector.add(3L);
    int i = localByteVector.a();
    localByteVector.add(q);
    localByteVector.add(264L);
    localByteVector.write(mAliveInfo.dateRecorded, 32);
    localByteVector.write(mAliveInfo.recordingUUID, 40);
    localByteVector.write(mAliveInfo.phoneUDID, 44);
    localByteVector.write(mAliveInfo.phoneModel, 32);
    localByteVector.write(mAliveInfo.recorderSW, 32);
    localByteVector.write(mAliveInfo.recorderHW, 32);
    localByteVector.write(mAliveInfo.location, 52);
    localByteVector.add(add(localByteVector, i, localByteVector.a() - i) & 0xFFFFFFFFFFFFFFFF);
    i = localByteVector.a();
    localByteVector.add(IHDR);
    localByteVector.add(8L);
    localByteVector.putInt(mAliveFormat.format);
    localByteVector.add(mAliveFormat.samplingRate);
    localByteVector.add(mAliveFormat.resolution_nV);
    localByteVector.putInt(mAliveFormat.flags);
    localByteVector.add(mAliveFormat.reserved);
    localByteVector.add(add(localByteVector, i, localByteVector.a() - i) & 0xFFFFFFFFFFFFFFFF);
    if (paramBoolean)
    {
      i = localByteVector.a();
      localByteVector.add(header);
      localByteVector.add(c * 2);
      g += add(localByteVector, i, localByteVector.a() - i);
      this$0.seek(0L);
      this$0.write(localByteVector.getValue(), 0, localByteVector.a());
      e = this$0.getFilePointer();
    }
  }
  
  public class AliveFileFormat
  {
    public int flags;
    public int format;
    public int reserved;
    public int resolution_nV;
    public int samplingRate;
    
    public AliveFileFormat() {}
  }
  
  public class AliveFileInfo
  {
    public String dateRecorded;
    public String location;
    public String phoneModel;
    public String phoneUDID;
    public String recorderHW;
    public String recorderSW;
    public String recordingUUID;
    
    public AliveFileInfo() {}
  }
  
  public enum Lead
  {
    static
    {
      Lead localLead1 = new Lead("LEAD_1", 0);
      LEAD_1 = localLead1;
      Lead localLead2 = new Lead("LEAD_2", 1);
      LEAD_2 = localLead2;
      Lead localLead3 = new Lead("LEAD_3", 2);
      LEAD_3 = localLead3;
      Lead localLead4 = new Lead("LEAD_4", 3);
      LEAD_4 = localLead4;
      Lead localLead5 = new Lead("LEAD_5", 4);
      LEAD_5 = localLead5;
      Lead localLead6 = new Lead("LEAD_6", 5);
      LEAD_6 = localLead6;
      d = new Lead[] { localLead1, localLead2, localLead3, localLead4, localLead5, localLead6 };
    }
  }
}
