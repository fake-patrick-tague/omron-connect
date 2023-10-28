package com.google.android.material.datepicker;

import android.os.BaseBundle;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.package_11.Fragment;

public final class e<S>
  extends k<S>
{
  private int a;
  private CalendarConstraints b;
  private DateSelector<S> c;
  
  public e() {}
  
  static e a(DateSelector paramDateSelector, int paramInt, CalendarConstraints paramCalendarConstraints)
  {
    e localE = new e();
    Bundle localBundle = new Bundle();
    localBundle.putInt("THEME_RES_ID_KEY", paramInt);
    localBundle.putParcelable("DATE_SELECTOR_KEY", paramDateSelector);
    localBundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", paramCalendarConstraints);
    localE.setArguments(localBundle);
    return localE;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = getArguments();
    }
    a = localBundle.getInt("THEME_RES_ID_KEY");
    c = ((DateSelector)localBundle.getParcelable("DATE_SELECTOR_KEY"));
    b = ((CalendarConstraints)localBundle.getParcelable("CALENDAR_CONSTRAINTS_KEY"));
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = paramLayoutInflater.cloneInContext(new ContextThemeWrapper(getContext(), a));
    return c.a(paramLayoutInflater, paramViewGroup, paramBundle, b, new c(this));
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putInt("THEME_RES_ID_KEY", a);
    paramBundle.putParcelable("DATE_SELECTOR_KEY", c);
    paramBundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", b);
  }
}
