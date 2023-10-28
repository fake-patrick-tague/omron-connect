package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.BaseBundle;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Iterator;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzey
{
  private final Bundle a;
  private final String c;
  private Bundle data;
  
  public zzey(zzfd paramZzfd, String paramString, Bundle paramBundle)
  {
    Preconditions.checkNotEmpty("default_event_parameters");
    c = "default_event_parameters";
    a = new Bundle();
  }
  
  public final Bundle doInBackground()
  {
    Object localObject1;
    if (data == null)
    {
      localObject1 = preferences.get().getString(c, null);
      if (localObject1 == null) {}
    }
    for (;;)
    {
      try
      {
        localBundle = new Bundle();
        localObject1 = new JSONArray((String)localObject1);
        j = 0;
        i = ((JSONArray)localObject1).length();
        if (j >= i) {}
      }
      catch (JSONException localJSONException1)
      {
        Bundle localBundle;
        int j;
        int i;
        Object localObject3;
        String str;
        Object localObject2;
        continue;
      }
      try
      {
        localObject3 = ((JSONArray)localObject1).getJSONObject(j);
        str = ((JSONObject)localObject3).getString("n");
        localObject2 = ((JSONObject)localObject3).getString("t");
        i = ((String)localObject2).hashCode();
        if (i != 100)
        {
          if (i != 108)
          {
            if ((i == 115) && (((String)localObject2).equals("s")))
            {
              i = 0;
              continue;
            }
          }
          else if (((String)localObject2).equals("l"))
          {
            i = 2;
            continue;
          }
        }
        else if (((String)localObject2).equals("d"))
        {
          i = 1;
          continue;
        }
        i = -1;
        if (i != 0) {
          if (i != 1) {
            if (i != 2) {
              localObject3 = preferences.this$0;
            }
          }
        }
      }
      catch (JSONException localJSONException3)
      {
        continue;
      }
      catch (NumberFormatException localNumberFormatException1)
      {
        continue;
      }
      try
      {
        ((zzfy)localObject3).zzay().iterator().append("Unrecognized persisted bundle type. Type", localObject2);
      }
      catch (JSONException localJSONException4)
      {
        continue;
      }
      catch (NumberFormatException localNumberFormatException2)
      {
        continue;
      }
      localBundle.putLong(str, Long.parseLong(((JSONObject)localObject3).getString("v")));
      continue;
      localBundle.putDouble(str, Double.parseDouble(((JSONObject)localObject3).getString("v")));
      continue;
      localBundle.putString(str, ((JSONObject)localObject3).getString("v"));
      continue;
      localObject2 = preferences.this$0;
      try
      {
        ((zzfy)localObject2).zzay().iterator().append("Error reading value from SharedPreferences. Value dropped");
        j += 1;
      }
      catch (JSONException localJSONException2) {}
    }
    data = localBundle;
    break label316;
    preferences.this$0.zzay().iterator().append("Error loading bundle from SharedPreferences. Values will be lost");
    label316:
    if (data == null) {
      data = a;
    }
    return data;
  }
  
  public final void doInBackground(Bundle paramBundle)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    paramBundle = preferences.get().edit();
    if (localBundle.size() == 0)
    {
      paramBundle.remove(c);
    }
    else
    {
      String str = c;
      JSONArray localJSONArray = new JSONArray();
      Iterator localIterator = localBundle.keySet().iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = (String)localIterator.next();
        Object localObject1 = localBundle.get((String)localObject2);
        if (localObject1 != null) {
          try
          {
            JSONObject localJSONObject = new JSONObject();
            localJSONObject.put("n", localObject2);
            localJSONObject.put("v", localObject1.toString());
            if ((localObject1 instanceof String))
            {
              localJSONObject.put("t", "s");
            }
            else if ((localObject1 instanceof Long))
            {
              localJSONObject.put("t", "l");
            }
            else
            {
              if (!(localObject1 instanceof Double)) {
                break label211;
              }
              localJSONObject.put("t", "d");
            }
            localJSONArray.put(localJSONObject);
            continue;
            label211:
            localObject2 = preferences.this$0;
            ((zzfy)localObject2).zzay().iterator().append("Cannot serialize bundle value to SharedPreferences. Type", localObject1.getClass());
          }
          catch (JSONException localJSONException)
          {
            preferences.this$0.zzay().iterator().append("Cannot serialize bundle value to SharedPreferences", localJSONException);
          }
        }
      }
      paramBundle.putString(str, localJSONArray.toString());
    }
    paramBundle.apply();
    data = localBundle;
  }
}
