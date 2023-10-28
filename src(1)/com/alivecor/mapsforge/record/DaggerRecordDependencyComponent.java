package com.alivecor.mapsforge.record;

import com.alivecor.asm.Attribute;
import com.alivecor.asm.c;
import com.alivecor.asm.k;
import commons.math3.ode.nonstiff.b;
import dagger.internal.ClassWriter;
import dagger.internal.Type;

public final class DaggerRecordDependencyComponent
{
  private DaggerRecordDependencyComponent() {}
  
  public static Builder builder()
  {
    return new Builder(null);
  }
  
  public final class Builder
  {
    private k aiComponent;
    private commons.math3.ode.nonstiff.a contextModule;
    private RecordEkgLibraryModule recordEkgLibraryModule;
    
    private Builder() {}
    
    public Builder aiComponent(k paramK)
    {
      aiComponent = ((k)ClassWriter.create(paramK));
      return this;
    }
    
    public RecordDependencyComponent build()
    {
      ClassWriter.put(contextModule, b.a.a.a.a.class);
      if (recordEkgLibraryModule == null) {
        recordEkgLibraryModule = new RecordEkgLibraryModule();
      }
      ClassWriter.put(aiComponent, com.alivecor.ai.a.class);
      return new DaggerRecordDependencyComponent.RecordDependencyComponentImpl(contextModule, recordEkgLibraryModule, aiComponent, null);
    }
    
    public Builder contextModule(commons.math3.ode.nonstiff.a paramA)
    {
      contextModule = ((commons.math3.ode.nonstiff.a)ClassWriter.create(paramA));
      return this;
    }
    
    public Builder recordEkgLibraryModule(RecordEkgLibraryModule paramRecordEkgLibraryModule)
    {
      recordEkgLibraryModule = ((RecordEkgLibraryModule)ClassWriter.create(paramRecordEkgLibraryModule));
      return this;
    }
  }
  
  final class RecordDependencyComponentImpl
    implements RecordDependencyComponent
  {
    private final k aiComponent;
    private g.a.a<com.alivecor.ecg.record.AppPreferences> providesAppPreferencesProvider;
    private final RecordDependencyComponentImpl recordDependencyComponentImpl = this;
    
    private RecordDependencyComponentImpl(RecordEkgLibraryModule paramRecordEkgLibraryModule, k paramK)
    {
      aiComponent = paramK;
      initialize(DaggerRecordDependencyComponent.this, paramRecordEkgLibraryModule, paramK);
    }
    
    private void initialize(commons.math3.ode.nonstiff.a paramA, RecordEkgLibraryModule paramRecordEkgLibraryModule, k paramK)
    {
      providesAppPreferencesProvider = Type.a(RecordEkgLibraryModule_ProvidesAppPreferencesFactory.create(paramRecordEkgLibraryModule));
    }
    
    private AppPreferences injectAppPreferences(AppPreferences paramAppPreferences)
    {
      AppPreferences_MembersInjector.injectContext(paramAppPreferences, b.a(DaggerRecordDependencyComponent.this));
      return paramAppPreferences;
    }
    
    private EcgMonitorViewModel injectEcgMonitorViewModel(EcgMonitorViewModel paramEcgMonitorViewModel)
    {
      EcgMonitorViewModel_MembersInjector.injectApplicationContext(paramEcgMonitorViewModel, b.a(DaggerRecordDependencyComponent.this));
      EcgMonitorViewModel_MembersInjector.injectAppPreferences(paramEcgMonitorViewModel, providesAppPreferencesProvider.get());
      EcgMonitorViewModel_MembersInjector.injectEcgEvaluator(paramEcgMonitorViewModel, (Attribute)ClassWriter.get(aiComponent.a()));
      return paramEcgMonitorViewModel;
    }
    
    private FragEcgRealtime injectFragEcgRealtime(FragEcgRealtime paramFragEcgRealtime)
    {
      FragEcgRealtime_MembersInjector.injectAppPreferences(paramFragEcgRealtime, providesAppPreferencesProvider.get());
      return paramFragEcgRealtime;
    }
    
    private FragEcgResults injectFragEcgResults(FragEcgResults paramFragEcgResults)
    {
      FragEcgResults_MembersInjector.injectAppPreferences(paramFragEcgResults, providesAppPreferencesProvider.get());
      return paramFragEcgResults;
    }
    
    private MicPermissionErrorFragment injectMicPermissionErrorFragment(MicPermissionErrorFragment paramMicPermissionErrorFragment)
    {
      MicPermissionErrorFragment_MembersInjector.injectAppPreferences(paramMicPermissionErrorFragment, providesAppPreferencesProvider.get());
      return paramMicPermissionErrorFragment;
    }
    
    private TriangleBluetoothWrapperClass injectTriangleBluetoothWrapperClass(TriangleBluetoothWrapperClass paramTriangleBluetoothWrapperClass)
    {
      TriangleBluetoothWrapperClass_MembersInjector.injectApplicationContext(paramTriangleBluetoothWrapperClass, b.a(DaggerRecordDependencyComponent.this));
      return paramTriangleBluetoothWrapperClass;
    }
    
    private TriangleIntroFragment injectTriangleIntroFragment(TriangleIntroFragment paramTriangleIntroFragment)
    {
      TriangleIntroFragment_MembersInjector.injectAppPreferences(paramTriangleIntroFragment, providesAppPreferencesProvider.get());
      return paramTriangleIntroFragment;
    }
    
    private Util injectUtil(Util paramUtil)
    {
      Util_MembersInjector.injectAppPreferences(paramUtil, providesAppPreferencesProvider.get());
      return paramUtil;
    }
    
    public c classifyRunner()
    {
      return (c)ClassWriter.get(aiComponent.c());
    }
    
    public void inject(AppPreferences paramAppPreferences)
    {
      injectAppPreferences(paramAppPreferences);
    }
    
    public void inject(EcgMonitorViewModel paramEcgMonitorViewModel)
    {
      injectEcgMonitorViewModel(paramEcgMonitorViewModel);
    }
    
    public void inject(FragEcgRealtime paramFragEcgRealtime)
    {
      injectFragEcgRealtime(paramFragEcgRealtime);
    }
    
    public void inject(FragEcgResults paramFragEcgResults)
    {
      injectFragEcgResults(paramFragEcgResults);
    }
    
    public void inject(MicPermissionErrorFragment paramMicPermissionErrorFragment)
    {
      injectMicPermissionErrorFragment(paramMicPermissionErrorFragment);
    }
    
    public void inject(TriangleBluetoothWrapperClass paramTriangleBluetoothWrapperClass)
    {
      injectTriangleBluetoothWrapperClass(paramTriangleBluetoothWrapperClass);
    }
    
    public void inject(TriangleIntroFragment paramTriangleIntroFragment)
    {
      injectTriangleIntroFragment(paramTriangleIntroFragment);
    }
    
    public void inject(Util paramUtil)
    {
      injectUtil(paramUtil);
    }
  }
}
