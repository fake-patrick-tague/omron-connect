package com.android.volley.toolbox;

import android.os.SystemClock;
import com.android.volley.Cache;
import com.android.volley.Cache.Entry;
import com.android.volley.Header;
import com.android.volley.VolleyLog;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class DiskBasedCache
  implements Cache
{
  private static final int CACHE_MAGIC = 538247942;
  private static final int DEFAULT_DISK_USAGE_BYTES = 5242880;
  static final float HYSTERESIS_FACTOR = 0.9F;
  private final Map<String, CacheHeader> mEntries = new LinkedHashMap(16, 0.75F, true);
  private final int mMaxCacheSizeInBytes;
  private final FileSupplier mRootDirectorySupplier;
  private long mTotalSize = 0L;
  
  public DiskBasedCache(FileSupplier paramFileSupplier)
  {
    this(paramFileSupplier, 5242880);
  }
  
  public DiskBasedCache(FileSupplier paramFileSupplier, int paramInt)
  {
    mRootDirectorySupplier = paramFileSupplier;
    mMaxCacheSizeInBytes = paramInt;
  }
  
  public DiskBasedCache(File paramFile)
  {
    this(paramFile, 5242880);
  }
  
  public DiskBasedCache(final File paramFile, int paramInt)
  {
    mRootDirectorySupplier = new FileSupplier()
    {
      public File getCacheDir()
      {
        return paramFile;
      }
    };
    mMaxCacheSizeInBytes = paramInt;
  }
  
  private String getFilenameForKey(String paramString)
  {
    int i = paramString.length() / 2;
    int j = paramString.substring(0, i).hashCode();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(String.valueOf(j));
    localStringBuilder.append(String.valueOf(paramString.substring(i).hashCode()));
    return localStringBuilder.toString();
  }
  
  private void initializeIfRootDirectoryDeleted()
  {
    if (!mRootDirectorySupplier.getCacheDir().exists())
    {
      VolleyLog.d("Re-initializing cache after external clearing.", new Object[0]);
      mEntries.clear();
      mTotalSize = 0L;
      initialize();
    }
  }
  
  private void pruneIfNeeded()
  {
    if (mTotalSize < mMaxCacheSizeInBytes) {
      return;
    }
    if (VolleyLog.DEBUG) {
      VolleyLog.v("Pruning old cache entries.", new Object[0]);
    }
    long l1 = mTotalSize;
    long l2 = SystemClock.elapsedRealtime();
    Iterator localIterator = mEntries.entrySet().iterator();
    int i = 0;
    int j;
    do
    {
      j = i;
      if (!localIterator.hasNext()) {
        break;
      }
      Object localObject = (CacheHeader)((Map.Entry)localIterator.next()).getValue();
      if (getFileForKey(key).delete())
      {
        mTotalSize -= size;
      }
      else
      {
        localObject = key;
        VolleyLog.d("Could not delete cache entry for key=%s, filename=%s", new Object[] { localObject, getFilenameForKey((String)localObject) });
      }
      localIterator.remove();
      j = i + 1;
      i = j;
    } while ((float)mTotalSize >= mMaxCacheSizeInBytes * 0.9F);
    if (VolleyLog.DEBUG) {
      VolleyLog.v("pruned %d files, %d bytes, %d ms", new Object[] { Integer.valueOf(j), Long.valueOf(mTotalSize - l1), Long.valueOf(SystemClock.elapsedRealtime() - l2) });
    }
  }
  
  private void putEntry(String paramString, CacheHeader paramCacheHeader)
  {
    if (!mEntries.containsKey(paramString))
    {
      mTotalSize += size;
    }
    else
    {
      CacheHeader localCacheHeader = (CacheHeader)mEntries.get(paramString);
      mTotalSize += size - size;
    }
    mEntries.put(paramString, paramCacheHeader);
  }
  
  private static int read(InputStream paramInputStream)
    throws IOException
  {
    int i = paramInputStream.read();
    if (i != -1) {
      return i;
    }
    throw new EOFException();
  }
  
  static List readHeaderList(CountingInputStream paramCountingInputStream)
    throws IOException
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: fail exe a4 = a3\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:92)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:1)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.dfs(Cfg.java:255)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze0(BaseAnalyze.java:75)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze(BaseAnalyze.java:69)\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer.transform(UnSSATransformer.java:274)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:163)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\nCaused by: java.lang.NullPointerException\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer$LiveA.onUseLocal(UnSSATransformer.java:552)\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer$LiveA.onUseLocal(UnSSATransformer.java:1)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.onUse(BaseAnalyze.java:166)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.onUse(BaseAnalyze.java:1)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.travel(Cfg.java:331)\n\tat com.googlecode.dex2jar.ir.ts.Cfg.travel(Cfg.java:387)\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:90)\n\t... 17 more\n");
  }
  
  static int readInt(InputStream paramInputStream)
    throws IOException
  {
    int i = read(paramInputStream);
    int j = read(paramInputStream);
    int k = read(paramInputStream);
    return read(paramInputStream) << 24 | i << 0 | 0x0 | j << 8 | k << 16;
  }
  
  static long readLong(InputStream paramInputStream)
    throws IOException
  {
    return (read(paramInputStream) & 0xFF) << 0 | 0L | (read(paramInputStream) & 0xFF) << 8 | (read(paramInputStream) & 0xFF) << 16 | (read(paramInputStream) & 0xFF) << 24 | (read(paramInputStream) & 0xFF) << 32 | (read(paramInputStream) & 0xFF) << 40 | (read(paramInputStream) & 0xFF) << 48 | (0xFF & read(paramInputStream)) << 56;
  }
  
  static String readString(CountingInputStream paramCountingInputStream)
    throws IOException
  {
    return new String(streamToBytes(paramCountingInputStream, readLong(paramCountingInputStream)), "UTF-8");
  }
  
  private void removeEntry(String paramString)
  {
    paramString = (CacheHeader)mEntries.remove(paramString);
    if (paramString != null) {
      mTotalSize -= size;
    }
  }
  
  static byte[] streamToBytes(CountingInputStream paramCountingInputStream, long paramLong)
    throws IOException
  {
    long l = paramCountingInputStream.bytesRemaining();
    if ((paramLong >= 0L) && (paramLong <= l))
    {
      int i = (int)paramLong;
      if (i == paramLong)
      {
        byte[] arrayOfByte = new byte[i];
        new DataInputStream(paramCountingInputStream).readFully(arrayOfByte);
        return arrayOfByte;
      }
    }
    paramCountingInputStream = new StringBuilder();
    paramCountingInputStream.append("streamToBytes length=");
    paramCountingInputStream.append(paramLong);
    paramCountingInputStream.append(", maxLength=");
    paramCountingInputStream.append(l);
    throw new IOException(paramCountingInputStream.toString());
  }
  
  static void writeHeaderList(List paramList, OutputStream paramOutputStream)
    throws IOException
  {
    if (paramList != null)
    {
      writeInt(paramOutputStream, paramList.size());
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Header localHeader = (Header)paramList.next();
        writeString(paramOutputStream, localHeader.getName());
        writeString(paramOutputStream, localHeader.getValue());
      }
    }
    writeInt(paramOutputStream, 0);
  }
  
  static void writeInt(OutputStream paramOutputStream, int paramInt)
    throws IOException
  {
    paramOutputStream.write(paramInt >> 0 & 0xFF);
    paramOutputStream.write(paramInt >> 8 & 0xFF);
    paramOutputStream.write(paramInt >> 16 & 0xFF);
    paramOutputStream.write(paramInt >> 24 & 0xFF);
  }
  
  static void writeLong(OutputStream paramOutputStream, long paramLong)
    throws IOException
  {
    paramOutputStream.write((byte)(int)(paramLong >>> 0));
    paramOutputStream.write((byte)(int)(paramLong >>> 8));
    paramOutputStream.write((byte)(int)(paramLong >>> 16));
    paramOutputStream.write((byte)(int)(paramLong >>> 24));
    paramOutputStream.write((byte)(int)(paramLong >>> 32));
    paramOutputStream.write((byte)(int)(paramLong >>> 40));
    paramOutputStream.write((byte)(int)(paramLong >>> 48));
    paramOutputStream.write((byte)(int)(paramLong >>> 56));
  }
  
  static void writeString(OutputStream paramOutputStream, String paramString)
    throws IOException
  {
    paramString = paramString.getBytes("UTF-8");
    writeLong(paramOutputStream, paramString.length);
    paramOutputStream.write(paramString, 0, paramString.length);
  }
  
  public void clear()
  {
    try
    {
      File[] arrayOfFile = mRootDirectorySupplier.getCacheDir().listFiles();
      if (arrayOfFile != null)
      {
        int j = arrayOfFile.length;
        int i = 0;
        while (i < j)
        {
          arrayOfFile[i].delete();
          i += 1;
        }
      }
      mEntries.clear();
      mTotalSize = 0L;
      VolleyLog.d("Cache cleared.", new Object[0]);
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
  
  InputStream createInputStream(File paramFile)
    throws FileNotFoundException
  {
    return new FileInputStream(paramFile);
  }
  
  OutputStream createOutputStream(File paramFile)
    throws FileNotFoundException
  {
    return new FileOutputStream(paramFile);
  }
  
  /* Error */
  public Cache.Entry get(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 50	com/android/volley/toolbox/DiskBasedCache:mEntries	Ljava/util/Map;
    //   6: aload_1
    //   7: invokeinterface 205 2 0
    //   12: checkcast 10	com/android/volley/toolbox/DiskBasedCache$CacheHeader
    //   15: astore 4
    //   17: aload 4
    //   19: ifnonnull +7 -> 26
    //   22: aload_0
    //   23: monitorexit
    //   24: aconst_null
    //   25: areturn
    //   26: aload_0
    //   27: aload_1
    //   28: invokevirtual 170	com/android/volley/toolbox/DiskBasedCache:getFileForKey	(Ljava/lang/String;)Ljava/io/File;
    //   31: astore_2
    //   32: new 13	com/android/volley/toolbox/DiskBasedCache$CountingInputStream
    //   35: dup
    //   36: new 338	java/io/BufferedInputStream
    //   39: dup
    //   40: aload_0
    //   41: aload_2
    //   42: invokevirtual 340	com/android/volley/toolbox/DiskBasedCache:createInputStream	(Ljava/io/File;)Ljava/io/InputStream;
    //   45: invokespecial 341	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   48: aload_2
    //   49: invokevirtual 343	java/io/File:length	()J
    //   52: invokespecial 346	com/android/volley/toolbox/DiskBasedCache$CountingInputStream:<init>	(Ljava/io/InputStream;J)V
    //   55: astore_3
    //   56: aload_3
    //   57: invokestatic 350	com/android/volley/toolbox/DiskBasedCache$CacheHeader:readHeader	(Lcom/android/volley/toolbox/DiskBasedCache$CountingInputStream;)Lcom/android/volley/toolbox/DiskBasedCache$CacheHeader;
    //   60: astore 5
    //   62: aload_1
    //   63: aload 5
    //   65: getfield 166	com/android/volley/toolbox/DiskBasedCache$CacheHeader:key	Ljava/lang/String;
    //   68: invokestatic 356	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   71: ifne +45 -> 116
    //   74: ldc_w 358
    //   77: iconst_3
    //   78: anewarray 4	java/lang/Object
    //   81: dup
    //   82: iconst_0
    //   83: aload_2
    //   84: invokevirtual 361	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   87: aastore
    //   88: dup
    //   89: iconst_1
    //   90: aload_1
    //   91: aastore
    //   92: dup
    //   93: iconst_2
    //   94: aload 5
    //   96: getfield 166	com/android/volley/toolbox/DiskBasedCache$CacheHeader:key	Ljava/lang/String;
    //   99: aastore
    //   100: invokestatic 114	com/android/volley/VolleyLog:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   103: aload_0
    //   104: aload_1
    //   105: invokespecial 363	com/android/volley/toolbox/DiskBasedCache:removeEntry	(Ljava/lang/String;)V
    //   108: aload_3
    //   109: invokevirtual 368	java/io/FilterInputStream:close	()V
    //   112: aload_0
    //   113: monitorexit
    //   114: aconst_null
    //   115: areturn
    //   116: aload 4
    //   118: aload_3
    //   119: aload_3
    //   120: invokevirtual 258	com/android/volley/toolbox/DiskBasedCache$CountingInputStream:bytesRemaining	()J
    //   123: invokestatic 247	com/android/volley/toolbox/DiskBasedCache:streamToBytes	(Lcom/android/volley/toolbox/DiskBasedCache$CountingInputStream;J)[B
    //   126: invokevirtual 372	com/android/volley/toolbox/DiskBasedCache$CacheHeader:toCacheEntry	([B)Lcom/android/volley/Cache$Entry;
    //   129: astore 4
    //   131: aload_3
    //   132: invokevirtual 368	java/io/FilterInputStream:close	()V
    //   135: aload_0
    //   136: monitorexit
    //   137: aload 4
    //   139: areturn
    //   140: astore 4
    //   142: aload_3
    //   143: invokevirtual 368	java/io/FilterInputStream:close	()V
    //   146: aload 4
    //   148: athrow
    //   149: astore_3
    //   150: ldc_w 374
    //   153: iconst_2
    //   154: anewarray 4	java/lang/Object
    //   157: dup
    //   158: iconst_0
    //   159: aload_2
    //   160: invokevirtual 361	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   163: aastore
    //   164: dup
    //   165: iconst_1
    //   166: aload_3
    //   167: checkcast 213	java/io/IOException
    //   170: invokevirtual 375	java/io/IOException:toString	()Ljava/lang/String;
    //   173: aastore
    //   174: invokestatic 114	com/android/volley/VolleyLog:d	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   177: aload_0
    //   178: aload_1
    //   179: invokevirtual 377	com/android/volley/toolbox/DiskBasedCache:remove	(Ljava/lang/String;)V
    //   182: aload_0
    //   183: monitorexit
    //   184: aconst_null
    //   185: areturn
    //   186: astore_1
    //   187: aload_0
    //   188: monitorexit
    //   189: aload_1
    //   190: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	191	0	this	DiskBasedCache
    //   0	191	1	paramString	String
    //   31	129	2	localFile	File
    //   55	88	3	localCountingInputStream	CountingInputStream
    //   149	18	3	localIOException	IOException
    //   15	123	4	localObject	Object
    //   140	7	4	localThrowable	Throwable
    //   60	35	5	localCacheHeader	CacheHeader
    // Exception table:
    //   from	to	target	type
    //   56	108	140	java/lang/Throwable
    //   116	131	140	java/lang/Throwable
    //   32	56	149	java/io/IOException
    //   108	112	149	java/io/IOException
    //   131	135	149	java/io/IOException
    //   142	149	149	java/io/IOException
    //   2	17	186	java/lang/Throwable
    //   26	32	186	java/lang/Throwable
    //   32	56	186	java/lang/Throwable
    //   108	112	186	java/lang/Throwable
    //   131	135	186	java/lang/Throwable
    //   142	149	186	java/lang/Throwable
    //   150	182	186	java/lang/Throwable
  }
  
  public File getFileForKey(String paramString)
  {
    return new File(mRootDirectorySupplier.getCacheDir(), getFilenameForKey(paramString));
  }
  
  public void initialize()
  {
    for (;;)
    {
      try
      {
        Object localObject = mRootDirectorySupplier.getCacheDir();
        boolean bool = ((File)localObject).exists();
        i = 0;
        if (!bool)
        {
          if (!((File)localObject).mkdirs()) {
            VolleyLog.e("Unable to create cache dir %s", new Object[] { ((File)localObject).getAbsolutePath() });
          }
          return;
        }
        localObject = ((File)localObject).listFiles();
        if (localObject == null) {
          return;
        }
        int j = localObject.length;
        if (i < j) {
          localFile = localObject[i];
        }
      }
      catch (Throwable localThrowable1)
      {
        int i;
        File localFile;
        long l;
        CountingInputStream localCountingInputStream;
        throw localThrowable1;
      }
      try
      {
        l = localFile.length();
        localCountingInputStream = new CountingInputStream(new BufferedInputStream(createInputStream(localFile)), l);
        try
        {
          CacheHeader localCacheHeader = CacheHeader.readHeader(localCountingInputStream);
          size = l;
          putEntry(key, localCacheHeader);
          localFile.delete();
        }
        catch (Throwable localThrowable2)
        {
          try
          {
            localCountingInputStream.close();
          }
          catch (IOException localIOException2)
          {
            continue;
          }
          localThrowable2 = localThrowable2;
          localCountingInputStream.close();
          throw localThrowable2;
        }
      }
      catch (IOException localIOException1)
      {
        continue;
      }
      i += 1;
    }
  }
  
  public void invalidate(String paramString, boolean paramBoolean)
  {
    try
    {
      Cache.Entry localEntry = get(paramString);
      if (localEntry != null)
      {
        softTtl = 0L;
        if (paramBoolean) {
          ttl = 0L;
        }
        put(paramString, localEntry);
      }
      return;
    }
    catch (Throwable paramString)
    {
      throw paramString;
    }
  }
  
  public void put(String paramString, Cache.Entry paramEntry)
  {
    for (;;)
    {
      try
      {
        l1 = mTotalSize;
        localObject = data;
        long l2 = localObject.length;
        int i = mMaxCacheSizeInBytes;
        if (l1 + l2 > i)
        {
          int j = localObject.length;
          if (j > i * 0.9F) {
            return;
          }
        }
        localObject = getFileForKey(paramString);
      }
      catch (Throwable paramString)
      {
        long l1;
        Object localObject;
        BufferedOutputStream localBufferedOutputStream;
        CacheHeader localCacheHeader;
        boolean bool;
        throw paramString;
      }
      try
      {
        localBufferedOutputStream = new BufferedOutputStream(createOutputStream((File)localObject));
        localCacheHeader = new CacheHeader(paramString, paramEntry);
        bool = localCacheHeader.writeHeader(localBufferedOutputStream);
        if (bool)
        {
          paramEntry = data;
          localBufferedOutputStream.write(paramEntry);
          localBufferedOutputStream.close();
          l1 = ((File)localObject).length();
          size = l1;
          putEntry(paramString, localCacheHeader);
          pruneIfNeeded();
          continue;
        }
        localBufferedOutputStream.close();
        paramString = ((File)localObject).getAbsolutePath();
        VolleyLog.d("Failed to write header for %s", new Object[] { paramString });
        throw new IOException();
      }
      catch (IOException paramString) {}
    }
    if (!((File)localObject).delete()) {
      VolleyLog.d("Could not clean up file %s", new Object[] { ((File)localObject).getAbsolutePath() });
    }
    initializeIfRootDirectoryDeleted();
  }
  
  public void remove(String paramString)
  {
    try
    {
      boolean bool = getFileForKey(paramString).delete();
      removeEntry(paramString);
      if (!bool) {
        VolleyLog.d("Could not delete cache entry for key=%s, filename=%s", new Object[] { paramString, getFilenameForKey(paramString) });
      }
      return;
    }
    catch (Throwable paramString)
    {
      throw paramString;
    }
  }
  
  static class CacheHeader
  {
    final List<Header> allResponseHeaders;
    final String etag;
    final String key;
    final long lastModified;
    final long serverDate;
    long size;
    final long softTtl;
    final long ttl;
    
    CacheHeader(String paramString, Cache.Entry paramEntry)
    {
      this(paramString, etag, serverDate, lastModified, ttl, softTtl, getAllResponseHeaders(paramEntry));
    }
    
    private CacheHeader(String paramString1, String paramString2, long paramLong1, long paramLong2, long paramLong3, long paramLong4, List paramList)
    {
      key = paramString1;
      paramString1 = paramString2;
      if ("".equals(paramString2)) {
        paramString1 = null;
      }
      etag = paramString1;
      serverDate = paramLong1;
      lastModified = paramLong2;
      ttl = paramLong3;
      softTtl = paramLong4;
      allResponseHeaders = paramList;
    }
    
    private static List getAllResponseHeaders(Cache.Entry paramEntry)
    {
      List localList = allResponseHeaders;
      if (localList != null) {
        return localList;
      }
      return HttpHeaderParser.toAllHeaderList(responseHeaders);
    }
    
    static CacheHeader readHeader(DiskBasedCache.CountingInputStream paramCountingInputStream)
      throws IOException
    {
      if (DiskBasedCache.readInt(paramCountingInputStream) == 538247942) {
        return new CacheHeader(DiskBasedCache.readString(paramCountingInputStream), DiskBasedCache.readString(paramCountingInputStream), DiskBasedCache.readLong(paramCountingInputStream), DiskBasedCache.readLong(paramCountingInputStream), DiskBasedCache.readLong(paramCountingInputStream), DiskBasedCache.readLong(paramCountingInputStream), DiskBasedCache.readHeaderList(paramCountingInputStream));
      }
      throw new IOException();
    }
    
    Cache.Entry toCacheEntry(byte[] paramArrayOfByte)
    {
      Cache.Entry localEntry = new Cache.Entry();
      data = paramArrayOfByte;
      etag = etag;
      serverDate = serverDate;
      lastModified = lastModified;
      ttl = ttl;
      softTtl = softTtl;
      responseHeaders = HttpHeaderParser.toHeaderMap(allResponseHeaders);
      allResponseHeaders = Collections.unmodifiableList(allResponseHeaders);
      return localEntry;
    }
    
    boolean writeHeader(OutputStream paramOutputStream)
    {
      try
      {
        DiskBasedCache.writeInt(paramOutputStream, 538247942);
        Object localObject = key;
        DiskBasedCache.writeString(paramOutputStream, (String)localObject);
        String str = etag;
        localObject = str;
        if (str == null) {
          localObject = "";
        }
        DiskBasedCache.writeString(paramOutputStream, (String)localObject);
        long l = serverDate;
        DiskBasedCache.writeLong(paramOutputStream, l);
        l = lastModified;
        DiskBasedCache.writeLong(paramOutputStream, l);
        l = ttl;
        DiskBasedCache.writeLong(paramOutputStream, l);
        l = softTtl;
        DiskBasedCache.writeLong(paramOutputStream, l);
        localObject = allResponseHeaders;
        DiskBasedCache.writeHeaderList((List)localObject, paramOutputStream);
        paramOutputStream.flush();
        return true;
      }
      catch (IOException paramOutputStream)
      {
        VolleyLog.d("%s", new Object[] { paramOutputStream.toString() });
      }
      return false;
    }
  }
  
  static class CountingInputStream
    extends FilterInputStream
  {
    private long bytesRead;
    private final long length;
    
    CountingInputStream(InputStream paramInputStream, long paramLong)
    {
      super();
      length = paramLong;
    }
    
    long bytesRead()
    {
      return bytesRead;
    }
    
    long bytesRemaining()
    {
      return length - bytesRead;
    }
    
    public int read()
      throws IOException
    {
      int i = super.read();
      if (i != -1) {
        bytesRead += 1L;
      }
      return i;
    }
    
    public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
      throws IOException
    {
      paramInt1 = super.read(paramArrayOfByte, paramInt1, paramInt2);
      if (paramInt1 != -1) {
        bytesRead += paramInt1;
      }
      return paramInt1;
    }
  }
  
  public static abstract interface FileSupplier
  {
    public abstract File getCacheDir();
  }
}
