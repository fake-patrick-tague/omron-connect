package com.alivecor.mapsforge.core.asm;

import java.io.File;
import java.io.FileFilter;

class ClassReader
  implements FileFilter
{
  ClassReader(long paramLong) {}
  
  public boolean accept(File paramFile)
  {
    return paramFile.lastModified() < d;
  }
}
