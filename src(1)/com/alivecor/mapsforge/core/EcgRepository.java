package com.alivecor.mapsforge.core;

import com.alivecor.ecg.core.model.a;
import com.alivecor.mapsforge.core.model.h;
import io.reactivex.e;
import io.reactivex.r;

public abstract interface EcgRepository<Ecg extends a>
{
  public abstract e syncEcgs();
  
  public abstract r writeEcgRecord(h paramH);
}
