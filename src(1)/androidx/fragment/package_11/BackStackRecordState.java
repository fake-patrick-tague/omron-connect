package androidx.fragment.package_11;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.Log;
import java.util.ArrayList;

final class BackStackRecordState
  implements Parcelable
{
  public static final Parcelable.Creator<androidx.fragment.app.BackStackRecordState> CREATOR = new a();
  final ArrayList<String> a;
  final int[] b;
  final ArrayList<String> c;
  final int d;
  final String e;
  final int[] f;
  final boolean h;
  final int[] i;
  final ArrayList<String> j;
  final int mBreadCrumbShortTitleRes;
  final CharSequence mBreadCrumbShortTitleText;
  final int mBreadCrumbTitleRes;
  final CharSequence mBreadCrumbTitleText;
  final int mIndex;
  
  BackStackRecordState(Parcel paramParcel)
  {
    b = paramParcel.createIntArray();
    a = paramParcel.createStringArrayList();
    f = paramParcel.createIntArray();
    i = paramParcel.createIntArray();
    d = paramParcel.readInt();
    e = paramParcel.readString();
    mIndex = paramParcel.readInt();
    mBreadCrumbTitleRes = paramParcel.readInt();
    mBreadCrumbTitleText = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
    mBreadCrumbShortTitleRes = paramParcel.readInt();
    mBreadCrumbShortTitleText = ((CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(paramParcel));
    j = paramParcel.createStringArrayList();
    c = paramParcel.createStringArrayList();
    boolean bool;
    if (paramParcel.readInt() != 0) {
      bool = true;
    } else {
      bool = false;
    }
    h = bool;
  }
  
  BackStackRecordState(BackStackRecord paramBackStackRecord) {}
  
  private void a(BackStackRecord paramBackStackRecord)
  {
    int m = 0;
    int k = 0;
    for (;;)
    {
      int n = b.length;
      boolean bool = true;
      if (m >= n) {
        break;
      }
      a0.a localA = new a0.a();
      Object localObject = b;
      n = m + 1;
      c = localObject[m];
      if (FragmentManager.get(2))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Instantiate ");
        ((StringBuilder)localObject).append(paramBackStackRecord);
        ((StringBuilder)localObject).append(" op #");
        ((StringBuilder)localObject).append(k);
        ((StringBuilder)localObject).append(" base fragment #");
        ((StringBuilder)localObject).append(b[n]);
        Log.v("FragmentManager", ((StringBuilder)localObject).toString());
      }
      h = androidx.lifecycle.Lifecycle.State.values()[f[k]];
      type = androidx.lifecycle.Lifecycle.State.values()[i[k]];
      localObject = b;
      m = n + 1;
      if (localObject[n] == 0) {
        bool = false;
      }
      p = bool;
      n = m + 1;
      m = localObject[m];
      i = m;
      int i2 = n + 1;
      int i1 = localObject[n];
      a = i1;
      n = i2 + 1;
      i2 = localObject[i2];
      d = i2;
      int i3 = localObject[n];
      b = i3;
      k = m;
      a = i1;
      d = i2;
      b = i3;
      paramBackStackRecord.a(localA);
      k += 1;
      m = n + 1;
    }
    i = d;
    x = e;
    p = true;
    mBreadCrumbTitleRes = mBreadCrumbTitleRes;
    mBreadCrumbTitleText = mBreadCrumbTitleText;
    mBreadCrumbShortTitleRes = mBreadCrumbShortTitleRes;
    mBreadCrumbShortTitleText = mBreadCrumbShortTitleText;
    j = j;
    c = c;
    h = h;
  }
  
  public BackStackRecord a(FragmentManager paramFragmentManager)
  {
    BackStackRecord localBackStackRecord = new BackStackRecord(paramFragmentManager);
    a(localBackStackRecord);
    mIndex = mIndex;
    int k = 0;
    while (k < a.size())
    {
      String str = (String)a.get(k);
      if (str != null) {
        m.get(k)).fragment = paramFragmentManager.get(str);
      }
      k += 1;
    }
    localBackStackRecord.bumpBackStackNesting(1);
    return localBackStackRecord;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\n");
  }
  
  class a
    implements Parcelable.Creator<androidx.fragment.app.BackStackRecordState>
  {
    a() {}
    
    public BackStackRecordState[] a(int paramInt)
    {
      return new BackStackRecordState[paramInt];
    }
    
    public BackStackRecordState readDate(Parcel paramParcel)
    {
      return new BackStackRecordState(paramParcel);
    }
  }
}
