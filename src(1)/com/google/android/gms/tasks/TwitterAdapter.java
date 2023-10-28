package com.google.android.gms.tasks;

final class TwitterAdapter
  implements OnTokenCanceledListener
{
  TwitterAdapter(TaskCompletionSource paramTaskCompletionSource) {}
  
  public final void onCanceled()
  {
    TaskCompletionSource.getTask(messages).close();
  }
}
