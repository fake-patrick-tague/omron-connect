package com.android.volley.toolbox;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.android.volley.VolleyError;

public class NetworkImageView
  extends ImageView
{
  private Bitmap mDefaultImageBitmap;
  private Drawable mDefaultImageDrawable;
  private int mDefaultImageId;
  private Bitmap mErrorImageBitmap;
  private Drawable mErrorImageDrawable;
  private int mErrorImageId;
  private ImageLoader.ImageContainer mImageContainer;
  private ImageLoader mImageLoader;
  private String mUrl;
  
  public NetworkImageView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public NetworkImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public NetworkImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void setDefaultImageOrNull()
  {
    int i = mDefaultImageId;
    if (i != 0)
    {
      setImageResource(i);
      return;
    }
    Object localObject = mDefaultImageDrawable;
    if (localObject != null)
    {
      setImageDrawable((Drawable)localObject);
      return;
    }
    localObject = mDefaultImageBitmap;
    if (localObject != null)
    {
      setImageBitmap((Bitmap)localObject);
      return;
    }
    setImageBitmap(null);
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    invalidate();
  }
  
  void loadImageIfNecessary(final boolean paramBoolean)
  {
    int i1 = getWidth();
    int j = i1;
    int n = getHeight();
    Object localObject1 = getScaleType();
    Object localObject2 = getLayoutParams();
    int m = 1;
    int i;
    int k;
    if (localObject2 != null)
    {
      if (getLayoutParamswidth == -2) {
        i = 1;
      } else {
        i = 0;
      }
      int i2;
      if (getLayoutParamsheight == -2)
      {
        i2 = 1;
        k = i;
        i = i2;
      }
      else
      {
        i2 = 0;
        k = i;
        i = i2;
      }
    }
    else
    {
      k = 0;
      i = 0;
    }
    if ((k == 0) || (i == 0)) {
      m = 0;
    }
    if ((i1 == 0) && (n == 0) && (m == 0)) {
      return;
    }
    if (TextUtils.isEmpty(mUrl))
    {
      localObject1 = mImageContainer;
      if (localObject1 != null)
      {
        ((ImageLoader.ImageContainer)localObject1).cancelRequest();
        mImageContainer = null;
      }
      setDefaultImageOrNull();
      return;
    }
    localObject2 = mImageContainer;
    if ((localObject2 != null) && (((ImageLoader.ImageContainer)localObject2).getRequestUrl() != null))
    {
      if (mImageContainer.getRequestUrl().equals(mUrl)) {
        return;
      }
      mImageContainer.cancelRequest();
      setDefaultImageOrNull();
    }
    if (k != 0) {
      j = 0;
    }
    if (i != 0) {
      i = 0;
    } else {
      i = n;
    }
    mImageContainer = mImageLoader.get(mUrl, new ImageLoader.ImageListener()
    {
      public void onErrorResponse(VolleyError paramAnonymousVolleyError)
      {
        if (mErrorImageId != 0)
        {
          paramAnonymousVolleyError = NetworkImageView.this;
          paramAnonymousVolleyError.setImageResource(mErrorImageId);
          return;
        }
        if (mErrorImageDrawable != null)
        {
          paramAnonymousVolleyError = NetworkImageView.this;
          paramAnonymousVolleyError.setImageDrawable(mErrorImageDrawable);
          return;
        }
        if (mErrorImageBitmap != null)
        {
          paramAnonymousVolleyError = NetworkImageView.this;
          paramAnonymousVolleyError.setImageBitmap(mErrorImageBitmap);
        }
      }
      
      public void onResponse(final ImageLoader.ImageContainer paramAnonymousImageContainer, boolean paramAnonymousBoolean)
      {
        if ((paramAnonymousBoolean) && (paramBoolean))
        {
          post(new Runnable()
          {
            public void run()
            {
              onResponse(paramAnonymousImageContainer, false);
            }
          });
          return;
        }
        if (paramAnonymousImageContainer.getBitmap() != null)
        {
          setImageBitmap(paramAnonymousImageContainer.getBitmap());
          return;
        }
        if (mDefaultImageId != 0)
        {
          paramAnonymousImageContainer = NetworkImageView.this;
          paramAnonymousImageContainer.setImageResource(mDefaultImageId);
          return;
        }
        if (mDefaultImageDrawable != null)
        {
          paramAnonymousImageContainer = NetworkImageView.this;
          paramAnonymousImageContainer.setImageDrawable(mDefaultImageDrawable);
          return;
        }
        if (mDefaultImageBitmap != null)
        {
          paramAnonymousImageContainer = NetworkImageView.this;
          paramAnonymousImageContainer.setImageBitmap(mDefaultImageBitmap);
        }
      }
    }, j, i, (ImageView.ScaleType)localObject1);
  }
  
  protected void onDetachedFromWindow()
  {
    ImageLoader.ImageContainer localImageContainer = mImageContainer;
    if (localImageContainer != null)
    {
      localImageContainer.cancelRequest();
      setImageBitmap(null);
      mImageContainer = null;
    }
    super.onDetachedFromWindow();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    loadImageIfNecessary(true);
  }
  
  public void setDefaultImageBitmap(Bitmap paramBitmap)
  {
    mDefaultImageId = 0;
    mDefaultImageDrawable = null;
    mDefaultImageBitmap = paramBitmap;
  }
  
  public void setDefaultImageDrawable(Drawable paramDrawable)
  {
    mDefaultImageId = 0;
    mDefaultImageBitmap = null;
    mDefaultImageDrawable = paramDrawable;
  }
  
  public void setDefaultImageResId(int paramInt)
  {
    mDefaultImageBitmap = null;
    mDefaultImageDrawable = null;
    mDefaultImageId = paramInt;
  }
  
  public void setErrorImageBitmap(Bitmap paramBitmap)
  {
    mErrorImageId = 0;
    mErrorImageDrawable = null;
    mErrorImageBitmap = paramBitmap;
  }
  
  public void setErrorImageDrawable(Drawable paramDrawable)
  {
    mErrorImageId = 0;
    mErrorImageBitmap = null;
    mErrorImageDrawable = paramDrawable;
  }
  
  public void setErrorImageResId(int paramInt)
  {
    mErrorImageBitmap = null;
    mErrorImageDrawable = null;
    mErrorImageId = paramInt;
  }
  
  public void setImageUrl(String paramString, ImageLoader paramImageLoader)
  {
    Threads.throwIfNotOnMainThread();
    mUrl = paramString;
    mImageLoader = paramImageLoader;
    loadImageIfNecessary(false);
  }
}
