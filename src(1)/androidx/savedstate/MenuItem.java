package androidx.savedstate;

import android.os.Bundle;

public abstract interface MenuItem
{
  public abstract Bundle onSaveInstanceState();
}
