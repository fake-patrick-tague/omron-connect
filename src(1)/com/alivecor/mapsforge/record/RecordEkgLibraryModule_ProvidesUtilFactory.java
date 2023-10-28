package com.alivecor.mapsforge.record;

import dagger.internal.ClassWriter;

public final class RecordEkgLibraryModule_ProvidesUtilFactory
{
  private final RecordEkgLibraryModule module;
  
  public RecordEkgLibraryModule_ProvidesUtilFactory(RecordEkgLibraryModule paramRecordEkgLibraryModule)
  {
    module = paramRecordEkgLibraryModule;
  }
  
  public static RecordEkgLibraryModule_ProvidesUtilFactory create(RecordEkgLibraryModule paramRecordEkgLibraryModule)
  {
    return new RecordEkgLibraryModule_ProvidesUtilFactory(paramRecordEkgLibraryModule);
  }
  
  public static Util providesUtil(RecordEkgLibraryModule paramRecordEkgLibraryModule)
  {
    return (Util)ClassWriter.a(paramRecordEkgLibraryModule.providesUtil());
  }
  
  public Util get()
  {
    return providesUtil(module);
  }
}
