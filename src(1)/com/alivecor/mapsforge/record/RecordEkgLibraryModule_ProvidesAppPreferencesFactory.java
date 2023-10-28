package com.alivecor.mapsforge.record;

import dagger.internal.ClassWriter;

public final class RecordEkgLibraryModule_ProvidesAppPreferencesFactory
{
  private final RecordEkgLibraryModule module;
  
  public RecordEkgLibraryModule_ProvidesAppPreferencesFactory(RecordEkgLibraryModule paramRecordEkgLibraryModule)
  {
    module = paramRecordEkgLibraryModule;
  }
  
  public static RecordEkgLibraryModule_ProvidesAppPreferencesFactory create(RecordEkgLibraryModule paramRecordEkgLibraryModule)
  {
    return new RecordEkgLibraryModule_ProvidesAppPreferencesFactory(paramRecordEkgLibraryModule);
  }
  
  public static AppPreferences providesAppPreferences(RecordEkgLibraryModule paramRecordEkgLibraryModule)
  {
    return (AppPreferences)ClassWriter.a(paramRecordEkgLibraryModule.providesAppPreferences());
  }
  
  public AppPreferences get()
  {
    return providesAppPreferences(module);
  }
}
