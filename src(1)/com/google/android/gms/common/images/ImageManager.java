package com.google.android.gms.common.images;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.ResultReceiver;
import android.widget.ImageView;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.internal.base.Integer;
import com.google.android.gms.internal.base.Logger;
import com.google.android.gms.internal.base.Optional;
import com.google.android.gms.internal.base.Target;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.ExecutorService;

public final class ImageManager
{
  private static ImageManager dialog;
  private static final Object result = new Object();
  private static HashSet<Uri> set = new HashSet();
  private final Context context;
  private final Map<Uri, Long> env;
  private final Map<Uri, ImageReceiver> hostnames;
  private final Handler mServiceHandler;
  private final ExecutorService mThreadExecutor;
  private final Map<zag, ImageReceiver> map;
  private final Integer value;
  
  private ImageManager(Context paramContext, boolean paramBoolean)
  {
    context = paramContext.getApplicationContext();
    mServiceHandler = new Logger(Looper.getMainLooper());
    mThreadExecutor = Target.getPriority().toString(4, 2);
    value = new Integer();
    map = new HashMap();
    hostnames = new HashMap();
    env = new HashMap();
  }
  
  public static ImageManager create(Context paramContext)
  {
    if (dialog == null) {
      dialog = new ImageManager(paramContext, false);
    }
    return dialog;
  }
  
  public final void flush(Layer paramLayer)
  {
    Asserts.checkMainThread("ImageManager.loadImage() must be called in the main thread");
    new EventInfoFragment.1(this, paramLayer).run();
  }
  
  public void loadImage(ImageView paramImageView, int paramInt)
  {
    flush(new Game(paramImageView, paramInt));
  }
  
  public void loadImage(ImageView paramImageView, Uri paramUri)
  {
    flush(new Game(paramImageView, paramUri));
  }
  
  public void loadImage(ImageView paramImageView, Uri paramUri, int paramInt)
  {
    paramImageView = new Game(paramImageView, paramUri);
    parent = paramInt;
    flush(paramImageView);
  }
  
  public void loadImage(OnImageLoadedListener paramOnImageLoadedListener, Uri paramUri)
  {
    flush(new Bookmark(paramOnImageLoadedListener, paramUri));
  }
  
  public void loadImage(OnImageLoadedListener paramOnImageLoadedListener, Uri paramUri, int paramInt)
  {
    paramOnImageLoadedListener = new Bookmark(paramOnImageLoadedListener, paramUri);
    parent = paramInt;
    flush(paramOnImageLoadedListener);
  }
  
  @KeepName
  private final class ImageReceiver
    extends ResultReceiver
  {
    private final ArrayList<zag> m;
    private final Uri mState;
    
    ImageReceiver(Uri paramUri)
    {
      super();
      mState = paramUri;
      m = new ArrayList();
    }
    
    public final void add(Layer paramLayer)
    {
      Asserts.checkMainThread("ImageReceiver.addImageRequest() must be called in the main thread");
      m.add(paramLayer);
    }
    
    public final void connect()
    {
      Intent localIntent = new Intent("com.google.android.gms.common.images.LOAD_IMAGE");
      localIntent.setPackage("com.google.android.gms");
      localIntent.putExtra("com.google.android.gms.extras.uri", mState);
      localIntent.putExtra("com.google.android.gms.extras.resultReceiver", this);
      localIntent.putExtra("com.google.android.gms.extras.priority", 3);
      ImageManager.access$getContext(ImageManager.this).sendBroadcast(localIntent);
    }
    
    public final void onReceiveResult(int paramInt, Bundle paramBundle)
    {
      paramBundle = (ParcelFileDescriptor)paramBundle.getParcelable("com.google.android.gms.extra.fileDescriptor");
      ImageManager localImageManager = ImageManager.this;
      ImageManager.access$getMThreadExecutor(localImageManager).execute(new SettingsActivity.7(localImageManager, mState, paramBundle));
    }
    
    public final void remove(Layer paramLayer)
    {
      Asserts.checkMainThread("ImageReceiver.removeImageRequest() must be called in the main thread");
      m.remove(paramLayer);
    }
  }
  
  public static abstract interface OnImageLoadedListener
  {
    public abstract void onImageLoaded(Uri paramUri, Drawable paramDrawable, boolean paramBoolean);
  }
}
