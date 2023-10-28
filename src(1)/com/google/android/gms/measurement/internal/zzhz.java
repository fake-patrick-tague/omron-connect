package com.google.android.gms.measurement.internal;

final class zzhz
  implements Runnable
{
  zzhz(zzid paramZzid, boolean paramBoolean) {}
  
  public final void run()
  {
    boolean bool1 = this$1.this$0.size();
    boolean bool2 = this$1.this$0.save();
    this$1.this$0.goTo(id);
    if (bool2 == id) {
      this$1.this$0.zzay().next().append("Default data collection state already set to", Boolean.valueOf(id));
    }
    if ((this$1.this$0.size() == bool1) || (this$1.this$0.size() != this$1.this$0.save())) {
      this$1.this$0.zzay().isEmpty().append("Default data collection is different than actual status", Boolean.valueOf(id), Boolean.valueOf(bool1));
    }
    zzid.access$getDisplay(this$1);
  }
}
