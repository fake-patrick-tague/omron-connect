package com.google.android.gms.common.package_12.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.package_12.Attribute;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

public abstract interface zaca
{
  public abstract void connect();
  
  public abstract ConnectionResult doInBackground();
  
  public abstract BaseImplementation.ApiMethodImpl enqueue(BaseImplementation.ApiMethodImpl paramApiMethodImpl);
  
  public abstract ConnectionResult execute(long paramLong, TimeUnit paramTimeUnit);
  
  public abstract boolean isEmpty();
  
  public abstract void next();
  
  public abstract ConnectionResult put(Attribute paramAttribute);
  
  public abstract BaseImplementation.ApiMethodImpl read(BaseImplementation.ApiMethodImpl paramApiMethodImpl);
  
  public abstract boolean remove();
  
  public abstract boolean remove(SignInConnectionListener paramSignInConnectionListener);
  
  public abstract void reset();
  
  public abstract void set();
  
  public abstract void write(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString);
}
