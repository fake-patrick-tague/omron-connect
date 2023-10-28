package com.android.volley.toolbox;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class ImageLoader
{
  private int mBatchResponseDelayMs = 100;
  private final HashMap<String, BatchedImageRequest> mBatchedResponses = new HashMap();
  private final ImageCache mCache;
  private final Handler mHandler = new Handler(Looper.getMainLooper());
  private final HashMap<String, BatchedImageRequest> mInFlightRequests = new HashMap();
  private final RequestQueue mRequestQueue;
  private Runnable mRunnable;
  
  public ImageLoader(RequestQueue paramRequestQueue, ImageCache paramImageCache)
  {
    mRequestQueue = paramRequestQueue;
    mCache = paramImageCache;
  }
  
  private void batchResponse(String paramString, BatchedImageRequest paramBatchedImageRequest)
  {
    mBatchedResponses.put(paramString, paramBatchedImageRequest);
    if (mRunnable == null)
    {
      paramString = new Runnable()
      {
        public void run()
        {
          Iterator localIterator1 = mBatchedResponses.values().iterator();
          while (localIterator1.hasNext())
          {
            ImageLoader.BatchedImageRequest localBatchedImageRequest = (ImageLoader.BatchedImageRequest)localIterator1.next();
            Iterator localIterator2 = ImageLoader.BatchedImageRequest.access$300(localBatchedImageRequest).iterator();
            while (localIterator2.hasNext())
            {
              ImageLoader.ImageContainer localImageContainer = (ImageLoader.ImageContainer)localIterator2.next();
              if (ImageLoader.ImageContainer.access$400(localImageContainer) != null) {
                if (localBatchedImageRequest.getError() == null)
                {
                  ImageLoader.ImageContainer.access$502(localImageContainer, ImageLoader.BatchedImageRequest.access$000(localBatchedImageRequest));
                  ImageLoader.ImageContainer.access$400(localImageContainer).onResponse(localImageContainer, false);
                }
                else
                {
                  ImageLoader.ImageContainer.access$400(localImageContainer).onErrorResponse(localBatchedImageRequest.getError());
                }
              }
            }
          }
          mBatchedResponses.clear();
          ImageLoader.access$602(ImageLoader.this, null);
        }
      };
      mRunnable = paramString;
      mHandler.postDelayed(paramString, mBatchResponseDelayMs);
    }
  }
  
  private static String getCacheKey(String paramString, int paramInt1, int paramInt2, ImageView.ScaleType paramScaleType)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramString.length() + 12);
    localStringBuilder.append("#W");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append("#H");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append("#S");
    localStringBuilder.append(paramScaleType.ordinal());
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public static ImageListener getImageListener(final ImageView paramImageView, final int paramInt1, int paramInt2)
  {
    new ImageListener()
    {
      public void onErrorResponse(VolleyError paramAnonymousVolleyError)
      {
        int i = val$errorImageResId;
        if (i != 0) {
          paramImageView.setImageResource(i);
        }
      }
      
      public void onResponse(ImageLoader.ImageContainer paramAnonymousImageContainer, boolean paramAnonymousBoolean)
      {
        if (paramAnonymousImageContainer.getBitmap() != null)
        {
          paramImageView.setImageBitmap(paramAnonymousImageContainer.getBitmap());
          return;
        }
        int i = paramInt1;
        if (i != 0) {
          paramImageView.setImageResource(i);
        }
      }
    };
  }
  
  public ImageContainer get(String paramString, ImageListener paramImageListener)
  {
    return get(paramString, paramImageListener, 0, 0);
  }
  
  public ImageContainer get(String paramString, ImageListener paramImageListener, int paramInt1, int paramInt2)
  {
    return get(paramString, paramImageListener, paramInt1, paramInt2, ImageView.ScaleType.CENTER_INSIDE);
  }
  
  public ImageContainer get(String paramString, ImageListener paramImageListener, int paramInt1, int paramInt2, ImageView.ScaleType paramScaleType)
  {
    Threads.throwIfNotOnMainThread();
    String str = getCacheKey(paramString, paramInt1, paramInt2, paramScaleType);
    Object localObject = mCache.getBitmap(str);
    if (localObject != null)
    {
      paramString = new ImageContainer((Bitmap)localObject, paramString, null, null);
      paramImageListener.onResponse(paramString, true);
      return paramString;
    }
    ImageContainer localImageContainer = new ImageContainer(null, paramString, str, paramImageListener);
    paramImageListener.onResponse(localImageContainer, true);
    localObject = (BatchedImageRequest)mInFlightRequests.get(str);
    paramImageListener = (ImageListener)localObject;
    if (localObject == null) {
      paramImageListener = (BatchedImageRequest)mBatchedResponses.get(str);
    }
    if (paramImageListener != null)
    {
      paramImageListener.addContainer(localImageContainer);
      return localImageContainer;
    }
    paramString = makeImageRequest(paramString, paramInt1, paramInt2, paramScaleType, str);
    mRequestQueue.add(paramString);
    mInFlightRequests.put(str, new BatchedImageRequest(paramString, localImageContainer));
    return localImageContainer;
  }
  
  public boolean isCached(String paramString, int paramInt1, int paramInt2)
  {
    return isCached(paramString, paramInt1, paramInt2, ImageView.ScaleType.CENTER_INSIDE);
  }
  
  public boolean isCached(String paramString, int paramInt1, int paramInt2, ImageView.ScaleType paramScaleType)
  {
    Threads.throwIfNotOnMainThread();
    paramString = getCacheKey(paramString, paramInt1, paramInt2, paramScaleType);
    return mCache.getBitmap(paramString) != null;
  }
  
  protected Request makeImageRequest(String paramString1, int paramInt1, int paramInt2, ImageView.ScaleType paramScaleType, final String paramString2)
  {
    new ImageRequest(paramString1, new Response.Listener()
    {
      public void onResponse(Bitmap paramAnonymousBitmap)
      {
        onGetImageSuccess(paramString2, paramAnonymousBitmap);
      }
    }, paramInt1, paramInt2, paramScaleType, Bitmap.Config.RGB_565, new Response.ErrorListener()
    {
      public void onErrorResponse(VolleyError paramAnonymousVolleyError)
      {
        onGetImageError(paramString2, paramAnonymousVolleyError);
      }
    });
  }
  
  protected void onGetImageError(String paramString, VolleyError paramVolleyError)
  {
    BatchedImageRequest localBatchedImageRequest = (BatchedImageRequest)mInFlightRequests.remove(paramString);
    if (localBatchedImageRequest != null)
    {
      localBatchedImageRequest.setError(paramVolleyError);
      batchResponse(paramString, localBatchedImageRequest);
    }
  }
  
  protected void onGetImageSuccess(String paramString, Bitmap paramBitmap)
  {
    mCache.putBitmap(paramString, paramBitmap);
    BatchedImageRequest localBatchedImageRequest = (BatchedImageRequest)mInFlightRequests.remove(paramString);
    if (localBatchedImageRequest != null)
    {
      BatchedImageRequest.access$002(localBatchedImageRequest, paramBitmap);
      batchResponse(paramString, localBatchedImageRequest);
    }
  }
  
  public void setBatchedResponseDelay(int paramInt)
  {
    mBatchResponseDelayMs = paramInt;
  }
  
  private static class BatchedImageRequest
  {
    private final List<ImageLoader.ImageContainer> mContainers;
    private VolleyError mError;
    private final Request<?> mRequest;
    private Bitmap mResponseBitmap;
    
    public BatchedImageRequest(Request paramRequest, ImageLoader.ImageContainer paramImageContainer)
    {
      ArrayList localArrayList = new ArrayList();
      mContainers = localArrayList;
      mRequest = paramRequest;
      localArrayList.add(paramImageContainer);
    }
    
    public void addContainer(ImageLoader.ImageContainer paramImageContainer)
    {
      mContainers.add(paramImageContainer);
    }
    
    public VolleyError getError()
    {
      return mError;
    }
    
    public boolean removeContainerAndCancelIfNecessary(ImageLoader.ImageContainer paramImageContainer)
    {
      mContainers.remove(paramImageContainer);
      if (mContainers.size() == 0)
      {
        mRequest.cancel();
        return true;
      }
      return false;
    }
    
    public void setError(VolleyError paramVolleyError)
    {
      mError = paramVolleyError;
    }
  }
  
  public static abstract interface ImageCache
  {
    public abstract Bitmap getBitmap(String paramString);
    
    public abstract void putBitmap(String paramString, Bitmap paramBitmap);
  }
  
  public class ImageContainer
  {
    private Bitmap mBitmap;
    private final String mCacheKey;
    private final ImageLoader.ImageListener mListener;
    private final String mRequestUrl;
    
    public ImageContainer(Bitmap paramBitmap, String paramString1, String paramString2, ImageLoader.ImageListener paramImageListener)
    {
      mBitmap = paramBitmap;
      mRequestUrl = paramString1;
      mCacheKey = paramString2;
      mListener = paramImageListener;
    }
    
    public void cancelRequest()
    {
      
      if (mListener == null) {
        return;
      }
      ImageLoader.BatchedImageRequest localBatchedImageRequest = (ImageLoader.BatchedImageRequest)mInFlightRequests.get(mCacheKey);
      if (localBatchedImageRequest != null)
      {
        if (localBatchedImageRequest.removeContainerAndCancelIfNecessary(this)) {
          mInFlightRequests.remove(mCacheKey);
        }
      }
      else
      {
        localBatchedImageRequest = (ImageLoader.BatchedImageRequest)mBatchedResponses.get(mCacheKey);
        if (localBatchedImageRequest != null)
        {
          localBatchedImageRequest.removeContainerAndCancelIfNecessary(this);
          if (mContainers.size() == 0) {
            mBatchedResponses.remove(mCacheKey);
          }
        }
      }
    }
    
    public Bitmap getBitmap()
    {
      return mBitmap;
    }
    
    public String getRequestUrl()
    {
      return mRequestUrl;
    }
  }
  
  public static abstract interface ImageListener
    extends Response.ErrorListener
  {
    public abstract void onResponse(ImageLoader.ImageContainer paramImageContainer, boolean paramBoolean);
  }
}
