package com.google.android.gms.tasks;

import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public class NativeOnCompleteListener
  implements OnCompleteListener<Object>
{
  private final long crc;
  
  public NativeOnCompleteListener(long paramLong)
  {
    crc = paramLong;
  }
  
  public static void createAndAddCallback(Task paramTask, long paramLong)
  {
    paramTask.addOnCompleteListener(new NativeOnCompleteListener(paramLong));
  }
  
  public native void nativeOnComplete(long paramLong, Object paramObject, boolean paramBoolean1, boolean paramBoolean2, String paramString);
  
  public void onComplete(Task paramTask)
  {
    Object localObject;
    String str;
    if (paramTask.isSuccessful())
    {
      localObject = paramTask.getResult();
      str = null;
    }
    else
    {
      if (!paramTask.isCanceled())
      {
        localObject = paramTask.getException();
        if (localObject != null)
        {
          str = ((Exception)localObject).getMessage();
          localObject = null;
          break label47;
        }
      }
      localObject = null;
      str = null;
    }
    label47:
    nativeOnComplete(crc, localObject, paramTask.isSuccessful(), paramTask.isCanceled(), str);
  }
}
