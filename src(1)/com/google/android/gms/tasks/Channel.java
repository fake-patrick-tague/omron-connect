package com.google.android.gms.tasks;

final class Channel
  implements Runnable
{
  Channel(Comment paramComment) {}
  
  public final void run()
  {
    Object localObject = Comment.getValue(tags);
    try
    {
      Comment localComment = tags;
      if (Comment.isEmpty(localComment) != null) {
        Comment.isEmpty(localComment).onCanceled();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      throw localThrowable;
    }
  }
}
