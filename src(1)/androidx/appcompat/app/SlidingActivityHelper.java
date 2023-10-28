package androidx.appcompat.app;

import android.os.Bundle;
import androidx.savedstate.MenuItem;

class SlidingActivityHelper
  implements MenuItem
{
  SlidingActivityHelper(AppCompatActivity paramAppCompatActivity) {}
  
  public Bundle onSaveInstanceState()
  {
    Bundle localBundle = new Bundle();
    mActivity.getDelegate().a(localBundle);
    return localBundle;
  }
}
