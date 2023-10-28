package com.google.android.gms.common;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.internal.common.zzag;
import com.google.errorprone.annotations.RestrictedInheritance;
import java.util.HashMap;

@RestrictedInheritance(allowedOnPath=".*javatests/com/google/android/gmscore/integ/client/common/robolectric/.*", explanation="Sub classing of GMS Core's APIs are restricted to testing fakes.", link="go/gmscore-restrictedinheritance")
@KeepForSdk
@ShowFirstParty
public class GmsSignatureVerifier
{
  private static final zzab DSB;
  private static final zzab SE;
  private static final HashMap keyMap = new HashMap();
  
  static
  {
    Vec2 localVec2 = new Vec2();
    localVec2.add("com.google.android.gms");
    localVec2.add(204200000L);
    Value localValue1 = Database.BOOLEAN;
    localVec2.set(zzag.of(localValue1.getValue(), Database.TIME.getValue()));
    Value localValue2 = Database.DATE;
    localVec2.add(zzag.of(localValue2.getValue(), Database.DATE_TIME.getValue()));
    DSB = localVec2.add();
    localVec2 = new Vec2();
    localVec2.add("com.android.vending");
    localVec2.add(82240000L);
    localVec2.set(zzag.create(localValue1.getValue()));
    localVec2.add(zzag.create(localValue2.getValue()));
    SE = localVec2.add();
  }
}
