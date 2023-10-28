package com.google.android.gms.common.data;

import android.os.Bundle;
import com.google.android.gms.common.api.Releasable;
import java.io.Closeable;
import java.util.Iterator;

public abstract interface DataBuffer<T>
  extends Iterable<T>, Releasable, Closeable
{
  public abstract void close();
  
  public abstract Object get(int paramInt);
  
  public abstract int getCount();
  
  public abstract Bundle getMetadata();
  
  public abstract boolean isClosed();
  
  public abstract Iterator iterator();
  
  public abstract void release();
  
  public abstract Iterator singleRefIterator();
}
