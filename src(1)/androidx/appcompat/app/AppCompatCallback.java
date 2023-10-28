package androidx.appcompat.app;

import v7.internal.view.ActionMode;
import v7.internal.view.ActionMode.Callback;

public abstract interface AppCompatCallback
{
  public abstract void onSupportActionModeFinished(ActionMode paramActionMode);
  
  public abstract void onSupportActionModeStarted(ActionMode paramActionMode);
  
  public abstract ActionMode onWindowStartingSupportActionMode(ActionMode.Callback paramCallback);
}
