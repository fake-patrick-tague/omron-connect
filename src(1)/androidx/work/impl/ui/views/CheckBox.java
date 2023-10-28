package androidx.work.impl.ui.views;

import android.net.ConnectivityManager.NetworkCallback;
import android.net.Network;
import android.net.NetworkCapabilities;
import androidx.work.Log;

class CheckBox
  extends ConnectivityManager.NetworkCallback
{
  CheckBox(Label paramLabel) {}
  
  public void onCapabilitiesChanged(Network paramNetwork, NetworkCapabilities paramNetworkCapabilities)
  {
    Log.get().append(Label.p, String.format("Network capabilities changed: %s", new Object[] { paramNetworkCapabilities }), new Throwable[0]);
    paramNetwork = this$0;
    paramNetwork.add(paramNetwork.search());
  }
  
  public void onLost(Network paramNetwork)
  {
    Log.get().append(Label.p, "Network connection lost", new Throwable[0]);
    paramNetwork = this$0;
    paramNetwork.add(paramNetwork.search());
  }
}
