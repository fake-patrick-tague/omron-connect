package com.braze.images;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.TrafficStats;
import android.net.Uri;
import android.os.Bundle;
import android.util.LruCache;
import android.view.View;
import android.widget.ImageView;
import com.braze.R.string;
import com.braze.coroutine.BrazeCoroutineScope;
import com.braze.enums.BrazeViewBounds;
import com.braze.models.cards.Card;
import com.braze.models.inappmessage.IInAppMessage;
import com.braze.support.BrazeFileUtils;
import com.braze.support.BrazeImageUtils;
import com.braze.support.BrazeLogger;
import com.braze.support.BrazeLogger.Priority;
import java.io.File;
import java.util.Objects;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.n;
import kotlin.t;
import kotlin.text.g;
import kotlin.w.d;
import kotlin.w.i.a.f;
import kotlin.w.i.a.l;
import kotlin.x.c.p;
import kotlin.x.d.i;
import kotlin.x.d.j;
import kotlinx.coroutines.b1;
import kotlinx.coroutines.h;
import kotlinx.coroutines.m0;
import protect.package_9.ImageCache;

public final class DefaultBrazeImageLoader
  implements IBrazeImageLoader
{
  public static final b Companion = new b(null);
  private static final String TAG = BrazeLogger.getBrazeLogTag(DefaultBrazeImageLoader.class);
  private final ReentrantLock diskCacheLock = new ReentrantLock();
  private ImageCache diskLruCache;
  private boolean isDiskCacheStarting = true;
  private boolean isOffline;
  private final LruCache<String, Bitmap> memoryCache = new a(BrazeImageUtils.getImageLoaderCacheSize());
  
  public DefaultBrazeImageLoader(Context paramContext)
  {
    initDiskCacheTask(paramContext);
  }
  
  private final void initDiskCacheTask(Context paramContext)
  {
    h.d(BrazeCoroutineScope.INSTANCE, null, null, new k(paramContext, this, null), 3, null);
  }
  
  private final Bitmap putBitmapIntoMemCache(String paramString, Bitmap paramBitmap)
  {
    return (Bitmap)memoryCache.put(paramString, paramBitmap);
  }
  
  private final void renderUrlIntoView(Context paramContext, String paramString, ImageView paramImageView, BrazeViewBounds paramBrazeViewBounds)
  {
    if (g.o(paramString))
    {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, null, null, o.PLAYING, 3, null);
      return;
    }
    try
    {
      renderUrlIntoViewTask(paramContext, paramImageView, paramBrazeViewBounds, paramString);
      return;
    }
    catch (Throwable paramContext)
    {
      BrazeLogger.INSTANCE.brazelog(this, BrazeLogger.Priority.this$0, paramContext, new p(paramString));
    }
  }
  
  private final void renderUrlIntoViewTask(final Context paramContext, final ImageView paramImageView, final BrazeViewBounds paramBrazeViewBounds, final String paramString)
  {
    paramImageView.setTag(R.string.com_braze_image_lru_cache_image_url_key, paramString);
    h.d(BrazeCoroutineScope.INSTANCE, null, null, new q(this, paramContext, paramString, paramBrazeViewBounds, paramImageView, null), 3, null);
  }
  
  public final Bitmap downloadBitmapFromUrl(Context paramContext, Uri paramUri, BrazeViewBounds paramBrazeViewBounds)
  {
    i.e(paramContext, "context");
    i.e(paramUri, "imageUri");
    BrazeViewBounds localBrazeViewBounds = paramBrazeViewBounds;
    if (paramBrazeViewBounds == null) {
      localBrazeViewBounds = BrazeViewBounds.NO_BOUNDS;
    }
    return BrazeImageUtils.getBitmap(paramContext, paramUri, localBrazeViewBounds);
  }
  
  public final Bitmap getBitmapFromCache(String paramString)
  {
    i.e(paramString, "key");
    Bitmap localBitmap = (Bitmap)memoryCache.get(paramString);
    if (localBitmap != null)
    {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, BrazeLogger.Priority.$EnumSwitchMapping$0, null, new c(paramString, this), 2, null);
      return localBitmap;
    }
    localBitmap = getBitmapFromDiskCache(paramString);
    if (localBitmap != null)
    {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, BrazeLogger.Priority.$EnumSwitchMapping$0, null, new d(paramString), 2, null);
      putBitmapIntoMemCache(paramString, localBitmap);
      return localBitmap;
    }
    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, null, null, new e(paramString), 3, null);
    return null;
  }
  
  public final Bitmap getBitmapFromDiskCache(String paramString)
  {
    i.e(paramString, "key");
    ReentrantLock localReentrantLock = diskCacheLock;
    localReentrantLock.lock();
    try
    {
      boolean bool = isDiskCacheStarting;
      Object localObject2 = null;
      if (bool)
      {
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, BrazeLogger.Priority.$EnumSwitchMapping$0, null, new f(paramString), 2, null);
      }
      else
      {
        ImageCache localImageCache = diskLruCache;
        Object localObject1 = localImageCache;
        if (localImageCache == null)
        {
          i.o("diskLruCache");
          localObject1 = null;
        }
        bool = ((ImageCache)localObject1).close(paramString);
        if (bool)
        {
          BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, BrazeLogger.Priority.$EnumSwitchMapping$0, null, new g(paramString), 2, null);
          localObject1 = diskLruCache;
          if (localObject1 == null)
          {
            i.o("diskLruCache");
            localObject1 = localObject2;
          }
          paramString = ((ImageCache)localObject1).get(paramString);
          localReentrantLock.unlock();
          return paramString;
        }
      }
      paramString = t.a;
      localReentrantLock.unlock();
      return null;
    }
    catch (Throwable paramString)
    {
      localReentrantLock.unlock();
      throw paramString;
    }
  }
  
  public final Bitmap getBitmapFromMemCache(String paramString)
  {
    i.e(paramString, "key");
    return (Bitmap)memoryCache.get(paramString);
  }
  
  public final Bitmap getBitmapFromUrl(Context paramContext, String paramString, BrazeViewBounds paramBrazeViewBounds)
  {
    i.e(paramContext, "context");
    i.e(paramString, "imageUrl");
    if (g.o(paramString))
    {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, null, null, h.PLAYING, 3, null);
      return null;
    }
    try
    {
      Object localObject = getBitmapFromCache(paramString);
      if (localObject != null) {
        return localObject;
      }
      boolean bool = isOffline;
      if (bool)
      {
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, null, null, i.PLAYING, 3, null);
        return null;
      }
      localObject = Uri.parse(paramString);
      i.d(localObject, "imageUri");
      paramContext = downloadBitmapFromUrl(paramContext, (Uri)localObject, paramBrazeViewBounds);
      if (paramContext != null)
      {
        putBitmapIntoCache(paramString, paramContext, BrazeFileUtils.isLocalUri((Uri)localObject));
        return paramContext;
      }
    }
    catch (Throwable paramContext)
    {
      BrazeLogger.INSTANCE.brazelog(this, BrazeLogger.Priority.this$0, paramContext, new j(paramString));
    }
    return null;
  }
  
  public Bitmap getInAppMessageBitmapFromUrl(Context paramContext, IInAppMessage paramIInAppMessage, String paramString, BrazeViewBounds paramBrazeViewBounds)
  {
    i.e(paramContext, "context");
    i.e(paramIInAppMessage, "inAppMessage");
    i.e(paramString, "imageUrl");
    return getBitmapFromUrl(paramContext, paramString, paramBrazeViewBounds);
  }
  
  public final LruCache getMemoryCache()
  {
    return memoryCache;
  }
  
  public Bitmap getPushBitmapFromUrl(Context paramContext, Bundle paramBundle, String paramString, BrazeViewBounds paramBrazeViewBounds)
  {
    i.e(paramContext, "context");
    i.e(paramString, "imageUrl");
    return getBitmapFromUrl(paramContext, paramString, paramBrazeViewBounds);
  }
  
  public final void putBitmapIntoCache(String paramString, Bitmap paramBitmap, boolean paramBoolean)
  {
    i.e(paramString, "key");
    i.e(paramBitmap, "bitmap");
    if (getBitmapFromMemCache(paramString) == null)
    {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, null, null, new l(paramString), 3, null);
      memoryCache.put(paramString, paramBitmap);
    }
    if (paramBoolean)
    {
      BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, null, null, new m(paramString), 3, null);
      return;
    }
    ReentrantLock localReentrantLock = diskCacheLock;
    localReentrantLock.lock();
    try
    {
      paramBoolean = isDiskCacheStarting;
      if (!paramBoolean)
      {
        ImageCache localImageCache = diskLruCache;
        Object localObject2 = null;
        Object localObject1 = localImageCache;
        if (localImageCache == null)
        {
          i.o("diskLruCache");
          localObject1 = null;
        }
        paramBoolean = ((ImageCache)localObject1).close(paramString);
        if (!paramBoolean)
        {
          BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, null, null, new n(paramString), 3, null);
          localObject1 = diskLruCache;
          if (localObject1 == null)
          {
            i.o("diskLruCache");
            localObject1 = localObject2;
          }
          ((ImageCache)localObject1).run(paramString, paramBitmap);
        }
      }
      paramString = t.a;
      localReentrantLock.unlock();
      return;
    }
    catch (Throwable paramString)
    {
      localReentrantLock.unlock();
      throw paramString;
    }
  }
  
  public void renderUrlIntoCardView(Context paramContext, Card paramCard, String paramString, ImageView paramImageView, BrazeViewBounds paramBrazeViewBounds)
  {
    i.e(paramContext, "context");
    i.e(paramCard, "card");
    i.e(paramString, "imageUrl");
    i.e(paramImageView, "imageView");
    renderUrlIntoView(paramContext, paramString, paramImageView, paramBrazeViewBounds);
  }
  
  public void renderUrlIntoInAppMessageView(Context paramContext, IInAppMessage paramIInAppMessage, String paramString, ImageView paramImageView, BrazeViewBounds paramBrazeViewBounds)
  {
    i.e(paramContext, "context");
    i.e(paramIInAppMessage, "inAppMessage");
    i.e(paramString, "imageUrl");
    i.e(paramImageView, "imageView");
    renderUrlIntoView(paramContext, paramString, paramImageView, paramBrazeViewBounds);
  }
  
  public void setOffline(boolean paramBoolean)
  {
    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, this, BrazeLogger.Priority.g, null, new r(paramBoolean), 2, null);
    isOffline = paramBoolean;
  }
  
  public static final class a
    extends LruCache<String, Bitmap>
  {
    a(int paramInt)
    {
      super();
    }
    
    protected int sizeOf(String paramString, Bitmap paramBitmap)
    {
      i.e(paramString, "key");
      i.e(paramBitmap, "image");
      return paramBitmap.getByteCount();
    }
  }
  
  public static final class b
  {
    private b() {}
    
    public final void handleResult(Context paramContext)
    {
      i.e(paramContext, "context");
      try
      {
        paramContext = paramContext.getCacheDir();
        paramContext = new File(paramContext, "appboy.imageloader.lru.cache");
        BrazeLogger localBrazeLogger = BrazeLogger.INSTANCE;
        BrazeLogger.Priority localPriority = BrazeLogger.Priority.$EnumSwitchMapping$0;
        BrazeLogger.brazelog$default(localBrazeLogger, this, localPriority, null, new a(paramContext), 2, null);
        BrazeFileUtils.deleteFileOrDirectory(paramContext);
        return;
      }
      catch (Exception paramContext)
      {
        BrazeLogger.INSTANCE.brazelog(this, BrazeLogger.Priority.this$0, paramContext, b.FINISHED);
      }
    }
    
    public final File parse(Context paramContext, String paramString)
    {
      i.e(paramContext, "context");
      i.e(paramString, "uniqueName");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramContext.getCacheDir().getPath());
      localStringBuilder.append(File.separator);
      localStringBuilder.append(paramString);
      return new File(localStringBuilder.toString());
    }
    
    static final class a
      extends j
      implements kotlin.x.c.a<String>
    {
      a(File paramFile)
      {
        super();
      }
      
      public final String extract()
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Deleting lru image cache directory at: ");
        localStringBuilder.append(dest.getAbsolutePath());
        return localStringBuilder.toString();
      }
    }
    
    static final class b
      extends j
      implements kotlin.x.c.a<String>
    {
      public static final b FINISHED = new b();
      
      b()
      {
        super();
      }
      
      public final String getText()
      {
        return "Failed to delete stored data in image loader";
      }
    }
  }
  
  static final class c
    extends j
    implements kotlin.x.c.a<String>
  {
    c(String paramString, DefaultBrazeImageLoader paramDefaultBrazeImageLoader)
    {
      super();
    }
    
    public final String request()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Got bitmap from mem cache for key ");
      localStringBuilder.append(mUrlString);
      localStringBuilder.append("\nMemory cache stats: ");
      localStringBuilder.append(jdField_this.getMemoryCache());
      return localStringBuilder.toString();
    }
  }
  
  static final class d
    extends j
    implements kotlin.x.c.a<String>
  {
    d(String paramString)
    {
      super();
    }
    
    public final String substring()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Got bitmap from disk cache for key ");
      localStringBuilder.append(src);
      return localStringBuilder.toString();
    }
  }
  
  static final class e
    extends j
    implements kotlin.x.c.a<String>
  {
    e(String paramString)
    {
      super();
    }
    
    public final String substring()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("No cache hit for bitmap: ");
      localStringBuilder.append(src);
      return localStringBuilder.toString();
    }
  }
  
  static final class f
    extends j
    implements kotlin.x.c.a<String>
  {
    f(String paramString)
    {
      super();
    }
    
    public final String substring()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Disk cache still starting. Cannot retrieve key from disk cache: ");
      localStringBuilder.append(src);
      return localStringBuilder.toString();
    }
  }
  
  static final class g
    extends j
    implements kotlin.x.c.a<String>
  {
    g(String paramString)
    {
      super();
    }
    
    public final String substring()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Getting bitmap from disk cache for key: ");
      localStringBuilder.append(src);
      return localStringBuilder.toString();
    }
  }
  
  static final class h
    extends j
    implements kotlin.x.c.a<String>
  {
    public static final h PLAYING = new h();
    
    h()
    {
      super();
    }
    
    public final String getText()
    {
      return "Cannot retrieve bitmap with blank image url";
    }
  }
  
  static final class i
    extends j
    implements kotlin.x.c.a<String>
  {
    public static final i PLAYING = new i();
    
    i()
    {
      super();
    }
    
    public final String getText()
    {
      return "Cache is currently in offline mode. Not downloading bitmap.";
    }
  }
  
  static final class j
    extends j
    implements kotlin.x.c.a<String>
  {
    j(String paramString)
    {
      super();
    }
    
    public final String substring()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Failed to get bitmap from url. Url: ");
      localStringBuilder.append(src);
      return localStringBuilder.toString();
    }
  }
  
  @f(c="com.braze.images.DefaultBrazeImageLoader$initDiskCacheTask$1", f="DefaultBrazeImageLoader.kt", l={}, m="invokeSuspend")
  static final class k
    extends l
    implements p<m0, d<? super t>, Object>
  {
    int PLAYING;
    
    k(Context paramContext, DefaultBrazeImageLoader paramDefaultBrazeImageLoader, d paramD)
    {
      super(paramD);
    }
    
    public final Object b(m0 paramM0, d paramD)
    {
      return ((k)create(paramM0, paramD)).invokeSuspend(t.a);
    }
    
    public final d create(Object paramObject, d paramD)
    {
      return (d)new k(context, jdField_this, paramD);
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      kotlin.coroutines.intrinsics.a.c();
      if (PLAYING == 0)
      {
        n.b(paramObject);
        Object localObject1 = DefaultBrazeImageLoader.Companion.parse(context, "appboy.imageloader.lru.cache");
        paramObject = DefaultBrazeImageLoader.access$getDiskCacheLock$p(jdField_this);
        DefaultBrazeImageLoader localDefaultBrazeImageLoader = jdField_this;
        paramObject.lock();
        try
        {
          BrazeLogger localBrazeLogger = BrazeLogger.INSTANCE;
          Object localObject2;
          a localA;
          paramObject.unlock();
        }
        catch (Throwable localThrowable)
        {
          try
          {
            localObject2 = DefaultBrazeImageLoader.access$getTAG$cp();
            localA = a.PREPARING;
            BrazeLogger.brazelog$default(localBrazeLogger, (String)localObject2, null, null, localA, 6, null);
            DefaultBrazeImageLoader.access$setDiskLruCache$p(localDefaultBrazeImageLoader, new ImageCache((File)localObject1, 1, 1, 52428800L));
            localObject1 = DefaultBrazeImageLoader.access$getTAG$cp();
            localObject2 = b.PREPARED;
            BrazeLogger.brazelog$default(localBrazeLogger, (String)localObject1, null, null, (kotlin.x.c.a)localObject2, 6, null);
            DefaultBrazeImageLoader.access$setDiskCacheStarting$p(localDefaultBrazeImageLoader, false);
          }
          catch (Exception localException)
          {
            BrazeLogger.INSTANCE.brazelog(DefaultBrazeImageLoader.access$getTAG$cp(), BrazeLogger.Priority.this$0, localException, c.MULTIPLY);
            localT = t.a;
            paramObject.unlock();
            return localT;
          }
          localThrowable = localThrowable;
        }
        t localT;
        throw localT;
      }
      throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
    
    static final class a
      extends j
      implements kotlin.x.c.a<String>
    {
      public static final a PREPARING = new a();
      
      a()
      {
        super();
      }
      
      public final String getText()
      {
        return "Initializing disk cache";
      }
    }
    
    static final class b
      extends j
      implements kotlin.x.c.a<String>
    {
      public static final b PREPARED = new b();
      
      b()
      {
        super();
      }
      
      public final String getText()
      {
        return "Disk cache initialized";
      }
    }
    
    static final class c
      extends j
      implements kotlin.x.c.a<String>
    {
      public static final c MULTIPLY = new c();
      
      c()
      {
        super();
      }
      
      public final String getText()
      {
        return "Caught exception creating new disk cache. Unable to create new disk cache";
      }
    }
  }
  
  static final class l
    extends j
    implements kotlin.x.c.a<String>
  {
    l(String paramString)
    {
      super();
    }
    
    public final String substring()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Adding bitmap to mem cache for key ");
      localStringBuilder.append(src);
      return localStringBuilder.toString();
    }
  }
  
  static final class m
    extends j
    implements kotlin.x.c.a<String>
  {
    m(String paramString)
    {
      super();
    }
    
    public final String substring()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Skipping disk cache for key: ");
      localStringBuilder.append(src);
      return localStringBuilder.toString();
    }
  }
  
  static final class n
    extends j
    implements kotlin.x.c.a<String>
  {
    n(String paramString)
    {
      super();
    }
    
    public final String substring()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Adding bitmap to disk cache for key ");
      localStringBuilder.append(src);
      return localStringBuilder.toString();
    }
  }
  
  static final class o
    extends j
    implements kotlin.x.c.a<String>
  {
    public static final o PLAYING = new o();
    
    o()
    {
      super();
    }
    
    public final String getText()
    {
      return "Cannot retrieve bitmap with a blank image url";
    }
  }
  
  static final class p
    extends j
    implements kotlin.x.c.a<String>
  {
    p(String paramString)
    {
      super();
    }
    
    public final String substring()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Failed to render url into view. Url: ");
      localStringBuilder.append(src);
      return localStringBuilder.toString();
    }
  }
  
  @f(c="com.braze.images.DefaultBrazeImageLoader$renderUrlIntoViewTask$1", f="DefaultBrazeImageLoader.kt", l={249}, m="invokeSuspend")
  static final class q
    extends l
    implements p<m0, d<? super t>, Object>
  {
    int m_count;
    
    q(DefaultBrazeImageLoader paramDefaultBrazeImageLoader, Context paramContext, String paramString, BrazeViewBounds paramBrazeViewBounds, ImageView paramImageView, d paramD)
    {
      super(paramD);
    }
    
    public final Object b(m0 paramM0, d paramD)
    {
      return ((q)create(paramM0, paramD)).invokeSuspend(t.a);
    }
    
    public final d create(Object paramObject, d paramD)
    {
      return (d)new q(lowerBound, paramContext, paramString, paramBrazeViewBounds, paramImageView, paramD);
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      Object localObject1 = kotlin.coroutines.intrinsics.a.c();
      int i = m_count;
      if (i != 0)
      {
        if (i == 1) {
          n.b(paramObject);
        } else {
          throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
      }
      else
      {
        n.b(paramObject);
        TrafficStats.setThreadStatsTag(1337);
        Object localObject2 = lowerBound.getBitmapFromUrl(paramContext, paramString, paramBrazeViewBounds);
        if (localObject2 == null)
        {
          BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, DefaultBrazeImageLoader.access$getTAG$cp(), null, null, new a(paramString), 6, null);
        }
        else
        {
          paramObject = b1.c();
          localObject2 = new b(paramString, paramImageView, (Bitmap)localObject2, paramBrazeViewBounds, null);
          m_count = 1;
          if (h.g(paramObject, (p)localObject2, (d)this) == localObject1) {
            return localObject1;
          }
        }
      }
      return t.a;
    }
    
    static final class a
      extends j
      implements kotlin.x.c.a<String>
    {
      a(String paramString)
      {
        super();
      }
      
      public final String substring()
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Failed to retrieve bitmap from url: ");
        localStringBuilder.append(src);
        return localStringBuilder.toString();
      }
    }
    
    @f(c="com.braze.images.DefaultBrazeImageLoader$renderUrlIntoViewTask$1$2", f="DefaultBrazeImageLoader.kt", l={}, m="invokeSuspend")
    static final class b
      extends l
      implements p<m0, d<? super t>, Object>
    {
      int mMaxDim;
      
      b(String paramString, ImageView paramImageView, Bitmap paramBitmap, BrazeViewBounds paramBrazeViewBounds, d paramD)
      {
        super(paramD);
      }
      
      public final Object b(m0 paramM0, d paramD)
      {
        return ((b)create(paramM0, paramD)).invokeSuspend(t.a);
      }
      
      public final d create(Object paramObject, d paramD)
      {
        return (d)new b(mContext, mFace, mTextPaint, mMetrics, paramD);
      }
      
      public final Object invokeSuspend(Object paramObject)
      {
        kotlin.coroutines.intrinsics.a.c();
        if (mMaxDim == 0)
        {
          n.b(paramObject);
          paramObject = mContext;
          Object localObject = mFace.getTag(R.string.com_braze_image_lru_cache_image_url_key);
          Objects.requireNonNull(localObject, "null cannot be cast to non-null type kotlin.String");
          if (i.a(paramObject, (String)localObject))
          {
            mFace.setImageBitmap(mTextPaint);
            if (mMetrics == BrazeViewBounds.BASE_CARD_VIEW) {
              BrazeImageUtils.resizeImageViewToBitmapDimensions(mTextPaint, mFace);
            }
          }
          return t.a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      }
    }
  }
  
  static final class r
    extends j
    implements kotlin.x.c.a<String>
  {
    r(boolean paramBoolean)
    {
      super();
    }
    
    public final String get()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("DefaultBrazeImageLoader outbound network requests are now ");
      String str;
      if (internal) {
        str = "disabled";
      } else {
        str = "enabled";
      }
      localStringBuilder.append(str);
      return localStringBuilder.toString();
    }
  }
}
