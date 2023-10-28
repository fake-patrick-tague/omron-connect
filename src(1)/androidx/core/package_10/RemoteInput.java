package androidx.core.package_10;

import android.os.Bundle;
import java.util.Set;

public final class RemoteInput
{
  private final Set<String> keys;
  private final boolean mAllowFreeFormInput;
  private final CharSequence[] mChoices;
  private final Bundle mExtras;
  private final CharSequence mLabel;
  private final String mResultKey;
  private final int mValue;
  
  static android.app.RemoteInput build(RemoteInput paramRemoteInput)
  {
    return RemoteInputCompatJellybean.build(paramRemoteInput);
  }
  
  static android.app.RemoteInput[] build(RemoteInput[] paramArrayOfRemoteInput)
  {
    if (paramArrayOfRemoteInput == null) {
      return null;
    }
    android.app.RemoteInput[] arrayOfRemoteInput = new android.app.RemoteInput[paramArrayOfRemoteInput.length];
    int i = 0;
    while (i < paramArrayOfRemoteInput.length)
    {
      arrayOfRemoteInput[i] = build(paramArrayOfRemoteInput[i]);
      i += 1;
    }
    return arrayOfRemoteInput;
  }
  
  public boolean b()
  {
    return (!getAllowFreeFormInput()) && ((getChoices() == null) || (getChoices().length == 0)) && (getKey() != null) && (!getKey().isEmpty());
  }
  
  public boolean getAllowFreeFormInput()
  {
    return mAllowFreeFormInput;
  }
  
  public CharSequence[] getChoices()
  {
    return mChoices;
  }
  
  public Bundle getExtras()
  {
    return mExtras;
  }
  
  public int getInt()
  {
    return mValue;
  }
  
  public Set getKey()
  {
    return keys;
  }
  
  public CharSequence getLabel()
  {
    return mLabel;
  }
  
  public String getResultKey()
  {
    return mResultKey;
  }
}
