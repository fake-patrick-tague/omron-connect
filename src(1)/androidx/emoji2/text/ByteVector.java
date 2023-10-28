package androidx.emoji2.text;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.ComponentInfo;
import android.content.pm.PackageItemInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.os.Build.VERSION;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import v7.v7.asm.h;

public class ByteVector
{
  private final a b;
  
  public ByteVector(a paramA)
  {
    if (paramA == null) {
      paramA = a();
    }
    b = paramA;
  }
  
  private ProviderInfo a(PackageManager paramPackageManager)
  {
    paramPackageManager = b.getValue(paramPackageManager, new Intent("androidx.content.action.LOAD_EMOJI_FONT"), 0).iterator();
    while (paramPackageManager.hasNext())
    {
      Object localObject = (ResolveInfo)paramPackageManager.next();
      localObject = b.getValue((ResolveInfo)localObject);
      if (get((ProviderInfo)localObject)) {
        return localObject;
      }
    }
    return null;
  }
  
  private Item a(Context paramContext, h paramH)
  {
    if (paramH == null) {
      return null;
    }
    return new ExtensionData(paramContext, paramH);
  }
  
  private static a a()
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 28) {
      return new XPositionMetric();
    }
    if (i >= 19) {
      return new PositionMetric();
    }
    return new a();
  }
  
  private h a(ProviderInfo paramProviderInfo, PackageManager paramPackageManager)
    throws PackageManager.NameNotFoundException
  {
    String str = authority;
    paramProviderInfo = packageName;
    return new h(str, paramProviderInfo, "emojicompat-emoji-font", create(b.getIcon(paramPackageManager, paramProviderInfo)));
  }
  
  private List create(Signature[] paramArrayOfSignature)
  {
    ArrayList localArrayList = new ArrayList();
    int j = paramArrayOfSignature.length;
    int i = 0;
    while (i < j)
    {
      localArrayList.add(paramArrayOfSignature[i].toByteArray());
      i += 1;
    }
    return Collections.singletonList(localArrayList);
  }
  
  private boolean get(ProviderInfo paramProviderInfo)
  {
    if (paramProviderInfo != null)
    {
      paramProviderInfo = applicationInfo;
      if ((paramProviderInfo != null) && ((flags & 0x1) == 1)) {
        return true;
      }
    }
    return false;
  }
  
  h a(Context paramContext)
  {
    paramContext = paramContext.getPackageManager();
    v7.v7.util.Log.get(paramContext, "Package manager required to locate emoji font provider");
    ProviderInfo localProviderInfo = a(paramContext);
    if (localProviderInfo == null) {
      return null;
    }
    try
    {
      paramContext = a(localProviderInfo, paramContext);
      return paramContext;
    }
    catch (PackageManager.NameNotFoundException paramContext)
    {
      android.util.Log.wtf("emoji2.text.DefaultEmojiConfig", paramContext);
    }
    return null;
  }
  
  public Item b(Context paramContext)
  {
    return a(paramContext, a(paramContext));
  }
}
