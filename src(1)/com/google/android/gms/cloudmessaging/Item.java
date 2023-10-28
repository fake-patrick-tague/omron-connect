package com.google.android.gms.cloudmessaging;

import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.tasks.TaskCompletionSource;

abstract class Item<T>
{
  final Bundle data;
  final int key;
  final int size;
  final TaskCompletionSource<T> this$0 = new TaskCompletionSource();
  
  Item(int paramInt1, int paramInt2, Bundle paramBundle)
  {
    size = paramInt1;
    key = paramInt2;
    data = paramBundle;
  }
  
  abstract boolean getId();
  
  final void init(JSONObject paramJSONObject)
  {
    if (Log.isLoggable("MessengerIpcClient", 3))
    {
      String str1 = String.valueOf(this);
      String str2 = String.valueOf(paramJSONObject);
      StringBuilder localStringBuilder = new StringBuilder(str1.length() + 14 + str2.length());
      localStringBuilder.append("Failing ");
      localStringBuilder.append(str1);
      localStringBuilder.append(" with ");
      localStringBuilder.append(str2);
      Log.d("MessengerIpcClient", localStringBuilder.toString());
    }
    this$0.setException(paramJSONObject);
  }
  
  abstract void load(Bundle paramBundle);
  
  final void put(Object paramObject)
  {
    if (Log.isLoggable("MessengerIpcClient", 3))
    {
      String str1 = String.valueOf(this);
      String str2 = String.valueOf(paramObject);
      StringBuilder localStringBuilder = new StringBuilder(str1.length() + 16 + str2.length());
      localStringBuilder.append("Finishing ");
      localStringBuilder.append(str1);
      localStringBuilder.append(" with ");
      localStringBuilder.append(str2);
      Log.d("MessengerIpcClient", localStringBuilder.toString());
    }
    this$0.setResult(paramObject);
  }
  
  public final String toString()
  {
    int i = key;
    int j = size;
    StringBuilder localStringBuilder = new StringBuilder(55);
    localStringBuilder.append("Request { what=");
    localStringBuilder.append(i);
    localStringBuilder.append(" id=");
    localStringBuilder.append(j);
    localStringBuilder.append(" oneWay=");
    localStringBuilder.append(getId());
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}
