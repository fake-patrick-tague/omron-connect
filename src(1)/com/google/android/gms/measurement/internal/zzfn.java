package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.Element;
import java.util.List;

final class zzfn
  implements Element
{
  zzfn(zzfp paramZzfp) {}
  
  public final void add(int paramInt, String paramString, List paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    paramInt -= 1;
    zzem localZzem;
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4) {
            localZzem = val$mPath.this$0.zzay().add();
          } else if (paramBoolean1) {
            localZzem = val$mPath.this$0.zzay().getHtml();
          } else if (!paramBoolean2) {
            localZzem = val$mPath.this$0.zzay().isEmpty();
          } else {
            localZzem = val$mPath.this$0.zzay().hasNext();
          }
        }
        else {
          localZzem = val$mPath.this$0.zzay().next();
        }
      }
      else if (paramBoolean1) {
        localZzem = val$mPath.this$0.zzay().getText();
      } else if (!paramBoolean2) {
        localZzem = val$mPath.this$0.zzay().equals();
      } else {
        localZzem = val$mPath.this$0.zzay().iterator();
      }
    }
    else {
      localZzem = val$mPath.this$0.zzay().e();
    }
    paramInt = paramList.size();
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          localZzem.append(paramString);
          return;
        }
        localZzem.append(paramString, paramList.get(0), paramList.get(1), paramList.get(2));
        return;
      }
      localZzem.append(paramString, paramList.get(0), paramList.get(1));
      return;
    }
    localZzem.append(paramString, paramList.get(0));
  }
}
