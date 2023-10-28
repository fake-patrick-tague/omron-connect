package com.google.android.gms.common.images;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.internal.base.DrawableWrapperDonut;
import com.google.android.gms.internal.base.FloatingActionButton;
import java.lang.ref.WeakReference;

public final class Game
  extends Layer
{
  private final WeakReference<ImageView> context;
  
  public Game(ImageView paramImageView, int paramInt)
  {
    super(Uri.EMPTY, paramInt);
    Asserts.checkNotNull(paramImageView);
    context = new WeakReference(paramImageView);
  }
  
  public Game(ImageView paramImageView, Uri paramUri)
  {
    super(paramUri, 0);
    Asserts.checkNotNull(paramImageView);
    context = new WeakReference(paramImageView);
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof Game)) {
      return false;
    }
    Object localObject = (Game)paramObject;
    paramObject = (ImageView)context.get();
    localObject = (ImageView)context.get();
    return (localObject != null) && (paramObject != null) && (Objects.equal(localObject, paramObject));
  }
  
  public final int hashCode()
  {
    return 0;
  }
  
  protected final void update(Drawable paramDrawable, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    ImageView localImageView = (ImageView)context.get();
    if (localImageView != null)
    {
      if ((!paramBoolean2) && (!paramBoolean3) && ((localImageView instanceof FloatingActionButton)))
      {
        paramDrawable = (FloatingActionButton)localImageView;
        throw new NullPointerException("Null throw statement replaced by Soot");
      }
      int j = 0;
      int i = j;
      if (!paramBoolean2) {
        if (paramBoolean1) {
          i = j;
        } else {
          i = 1;
        }
      }
      Object localObject = paramDrawable;
      if (i != 0)
      {
        Drawable localDrawable = localImageView.getDrawable();
        localObject = localDrawable;
        if (localDrawable != null)
        {
          if ((localDrawable instanceof DrawableWrapperDonut)) {
            localObject = ((DrawableWrapperDonut)localDrawable).getWrappedDrawable();
          }
        }
        else {
          localObject = null;
        }
        localObject = new DrawableWrapperDonut((Drawable)localObject, paramDrawable);
      }
      localImageView.setImageDrawable((Drawable)localObject);
      if (!(localImageView instanceof FloatingActionButton))
      {
        if ((localObject != null) && (i != 0)) {
          ((DrawableWrapperDonut)localObject).startTransition(250);
        }
      }
      else
      {
        paramDrawable = (FloatingActionButton)localImageView;
        throw new NullPointerException("Null throw statement replaced by Soot");
      }
    }
  }
}
