package com.google.android.gms.common.images;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.internal.base.Integer;

public abstract class Layer
{
  final Name name;
  protected int parent = 0;
  
  public Layer(Uri paramUri, int paramInt)
  {
    name = new Name(paramUri);
    parent = paramInt;
  }
  
  final void load(Context paramContext, Bitmap paramBitmap, boolean paramBoolean)
  {
    Asserts.checkNotNull(paramBitmap);
    update(new BitmapDrawable(paramContext.getResources(), paramBitmap), false, false, true);
  }
  
  final void update(Context paramContext, Integer paramInteger, boolean paramBoolean)
  {
    int i = parent;
    if (i != 0) {
      paramContext = paramContext.getResources().getDrawable(i);
    } else {
      paramContext = null;
    }
    update(paramContext, paramBoolean, false, false);
  }
  
  protected abstract void update(Drawable paramDrawable, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3);
}
