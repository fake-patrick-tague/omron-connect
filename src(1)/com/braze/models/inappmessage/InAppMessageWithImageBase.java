package com.braze.models.inappmessage;

import android.graphics.Bitmap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import kotlin.text.g;
import kotlin.x.d.i;
import org.json.JSONException;
import org.json.JSONObject;
import protect.package_9.c;

public abstract class InAppMessageWithImageBase
  extends InAppMessageBase
  implements IInAppMessageWithImage
{
  public static final a Companion = new a(null);
  private Bitmap bitmap;
  private boolean imageDownloadSuccessful;
  private String localImageUrl;
  private String remoteImageUrl;
  
  protected InAppMessageWithImageBase() {}
  
  public InAppMessageWithImageBase(JSONObject paramJSONObject, c paramC)
  {
    super(paramJSONObject, paramC, false, false, 12, null);
    setRemoteImageUrl(paramJSONObject.optString("image_url"));
  }
  
  public JSONObject forJsonPut()
  {
    JSONObject localJSONObject = getJsonObject();
    if (localJSONObject != null) {
      return localJSONObject;
    }
    localJSONObject = super.forJsonPut();
    try
    {
      localJSONObject.putOpt("image_url", getRemoteImageUrl());
      return localJSONObject;
    }
    catch (JSONException localJSONException) {}
    return localJSONObject;
  }
  
  public Bitmap getBitmap()
  {
    return bitmap;
  }
  
  public boolean getImageDownloadSuccessful()
  {
    return imageDownloadSuccessful;
  }
  
  public String getLocalImageUrl()
  {
    return localImageUrl;
  }
  
  public List getRemoteAssetPathsForPrefetch()
  {
    ArrayList localArrayList = new ArrayList();
    String str = getRemoteImageUrl();
    if ((str != null) && ((g.o(str) ^ true))) {
      localArrayList.add(str);
    }
    return localArrayList;
  }
  
  public String getRemoteImageUrl()
  {
    return remoteImageUrl;
  }
  
  public void setBitmap(Bitmap paramBitmap)
  {
    bitmap = paramBitmap;
  }
  
  public void setImageDownloadSuccessful(boolean paramBoolean)
  {
    imageDownloadSuccessful = paramBoolean;
  }
  
  public void setLocalImageUrl(String paramString)
  {
    localImageUrl = paramString;
  }
  
  public void setLocalPrefetchedAssetPaths(Map paramMap)
  {
    i.e(paramMap, "remotePathToLocalAssetMap");
    if ((paramMap.isEmpty() ^ true))
    {
      paramMap = paramMap.values().toArray(new String[0]);
      Objects.requireNonNull(paramMap, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
      setLocalImageUrl(((String[])paramMap)[0]);
    }
  }
  
  public void setRemoteImageUrl(String paramString)
  {
    remoteImageUrl = paramString;
  }
  
  public static final class a
  {
    private a() {}
  }
}
