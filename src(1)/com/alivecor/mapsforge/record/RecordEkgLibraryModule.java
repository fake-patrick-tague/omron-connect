package com.alivecor.mapsforge.record;

class RecordEkgLibraryModule
{
  RecordEkgLibraryModule() {}
  
  AppPreferences providesAppPreferences()
  {
    return new AppPreferences();
  }
  
  Util providesUtil()
  {
    return new Util();
  }
}
