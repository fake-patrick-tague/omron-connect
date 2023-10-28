package com.google.android.gms.common.package_12.internal;

import androidx.fragment.package_11.FragmentActivity;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.package_12.Attribute;
import com.google.android.gms.common.package_12.GoogleApiClient;
import com.google.android.gms.common.package_12.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.package_12.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.package_12.PendingResult;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

public class zaag
  extends GoogleApiClient
{
  private final String endpoint = "Method is not supported by connectionless client. APIs supporting connectionless client must not call this method.";
  
  public zaag(String paramString) {}
  
  public final ConnectionResult blockingConnect()
  {
    throw new UnsupportedOperationException(endpoint);
  }
  
  public final ConnectionResult blockingConnect(long paramLong, TimeUnit paramTimeUnit)
  {
    throw new UnsupportedOperationException(endpoint);
  }
  
  public final PendingResult clearDefaultAccountAndReconnect()
  {
    throw new UnsupportedOperationException(endpoint);
  }
  
  public final void connect()
  {
    throw new UnsupportedOperationException(endpoint);
  }
  
  public final void disconnect()
  {
    throw new UnsupportedOperationException(endpoint);
  }
  
  public final void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    throw new UnsupportedOperationException(endpoint);
  }
  
  public final ConnectionResult getConnectionResult(Attribute paramAttribute)
  {
    throw new UnsupportedOperationException(endpoint);
  }
  
  public final boolean hasConnectedApi(Attribute paramAttribute)
  {
    throw new UnsupportedOperationException(endpoint);
  }
  
  public final boolean isConnected()
  {
    throw new UnsupportedOperationException(endpoint);
  }
  
  public final boolean isConnecting()
  {
    throw new UnsupportedOperationException(endpoint);
  }
  
  public final boolean isConnectionCallbacksRegistered(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    throw new UnsupportedOperationException(endpoint);
  }
  
  public final boolean isConnectionFailedListenerRegistered(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    throw new UnsupportedOperationException(endpoint);
  }
  
  public final void reconnect()
  {
    throw new UnsupportedOperationException(endpoint);
  }
  
  public final void registerConnectionCallbacks(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    throw new UnsupportedOperationException(endpoint);
  }
  
  public final void registerConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    throw new UnsupportedOperationException(endpoint);
  }
  
  public final void stopAutoManage(FragmentActivity paramFragmentActivity)
  {
    throw new UnsupportedOperationException(endpoint);
  }
  
  public final void unregisterConnectionCallbacks(GoogleApiClient.ConnectionCallbacks paramConnectionCallbacks)
  {
    throw new UnsupportedOperationException(endpoint);
  }
  
  public final void unregisterConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener paramOnConnectionFailedListener)
  {
    throw new UnsupportedOperationException(endpoint);
  }
}
