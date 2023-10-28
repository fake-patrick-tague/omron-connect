package androidx.fragment.package_11;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater.Factory2;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.package_11.strictmode.FragmentStrictMode;
import v7.app.R.styleable;

class FragmentManagerImpl
  implements LayoutInflater.Factory2
{
  final FragmentManager this$0;
  
  FragmentManagerImpl(FragmentManager paramFragmentManager)
  {
    this$0 = paramFragmentManager;
  }
  
  public View onCreateView(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    if (androidx.fragment.app.FragmentContainerView.class.getName().equals(paramString)) {
      return new FragmentContainerView(paramContext, paramAttributeSet, this$0);
    }
    boolean bool = "fragment".equals(paramString);
    paramString = null;
    if (!bool) {
      return null;
    }
    Object localObject1 = paramAttributeSet.getAttributeValue(null, "class");
    Object localObject2 = localObject1;
    Object localObject3 = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.a);
    if (localObject1 == null) {
      localObject2 = ((TypedArray)localObject3).getString(R.styleable.c);
    }
    int k = ((TypedArray)localObject3).getResourceId(R.styleable.PreferenceFragmentCompat_layout, -1);
    String str = ((TypedArray)localObject3).getString(R.styleable.numberpicker_defaultValue);
    ((TypedArray)localObject3).recycle();
    if (localObject2 != null)
    {
      if (!Loader.load(paramContext.getClassLoader(), (String)localObject2)) {
        return null;
      }
      int i;
      if (paramView != null) {
        i = paramView.getId();
      } else {
        i = 0;
      }
      if ((i == -1) && (k == -1) && (str == null))
      {
        paramView = new StringBuilder();
        paramView.append(paramAttributeSet.getPositionDescription());
        paramView.append(": Must specify unique android:id, android:tag, or have a parent with an id for ");
        paramView.append((String)localObject2);
        throw new IllegalArgumentException(paramView.toString());
      }
      if (k != -1) {
        paramString = this$0.findFragmentById(k);
      }
      localObject1 = paramString;
      if (paramString == null)
      {
        localObject1 = paramString;
        if (str != null) {
          localObject1 = this$0.getFragment(str);
        }
      }
      paramString = (String)localObject1;
      if (localObject1 == null)
      {
        paramString = (String)localObject1;
        if (i != -1) {
          paramString = this$0.findFragmentById(i);
        }
      }
      if (paramString == null)
      {
        localObject1 = this$0.getView().instantiate(paramContext.getClassLoader(), (String)localObject2);
        paramString = (String)localObject1;
        mFromLayout = true;
        int j;
        if (k != 0) {
          j = k;
        } else {
          j = i;
        }
        mFragmentId = j;
        mContainerId = i;
        mTag = str;
        mInLayout = true;
        paramContext = this$0;
        mFragmentManager = paramContext;
        mHost = paramContext.getContext();
        ((Fragment)localObject1).onInflate(this$0.getContext().getContext(), paramAttributeSet, mSavedFragmentState);
        localObject3 = this$0.addFragment((Fragment)localObject1);
        paramContext = paramString;
        paramAttributeSet = (AttributeSet)localObject3;
        if (FragmentManager.get(2))
        {
          paramContext = new StringBuilder();
          paramContext.append("Fragment ");
          paramContext.append(localObject1);
          paramContext.append(" has been inflated via the <fragment> tag: id=0x");
          paramContext.append(Integer.toHexString(k));
          android.util.Log.v("FragmentManager", paramContext.toString());
          paramContext = paramString;
          paramAttributeSet = (AttributeSet)localObject3;
        }
      }
      else
      {
        if (mInLayout) {
          break label735;
        }
        mInLayout = true;
        paramContext = this$0;
        mFragmentManager = paramContext;
        mHost = paramContext.getContext();
        paramString.onInflate(this$0.getContext().getContext(), paramAttributeSet, mSavedFragmentState);
        localObject1 = this$0.getInstance(paramString);
        paramContext = paramString;
        paramAttributeSet = (AttributeSet)localObject1;
        if (FragmentManager.get(2))
        {
          paramContext = new StringBuilder();
          paramContext.append("Retained Fragment ");
          paramContext.append(paramString);
          paramContext.append(" has been re-attached via the <fragment> tag: id=0x");
          paramContext.append(Integer.toHexString(k));
          android.util.Log.v("FragmentManager", paramContext.toString());
          paramAttributeSet = (AttributeSet)localObject1;
          paramContext = paramString;
        }
      }
      paramView = (ViewGroup)paramView;
      FragmentStrictMode.a(paramContext, paramView);
      mContainer = paramView;
      paramAttributeSet.run();
      paramAttributeSet.moveToState();
      paramView = mView;
      if (paramView != null)
      {
        if (k != 0) {
          paramView.setId(k);
        }
        if (mView.getTag() == null) {
          mView.setTag(str);
        }
        mView.addOnAttachStateChangeListener(new MainActivity.2(this, paramAttributeSet));
        return mView;
      }
      paramView = new StringBuilder();
      paramView.append("Fragment ");
      paramView.append((String)localObject2);
      paramView.append(" did not create a view.");
      throw new IllegalStateException(paramView.toString());
      label735:
      paramView = new StringBuilder();
      paramView.append(paramAttributeSet.getPositionDescription());
      paramView.append(": Duplicate id 0x");
      paramView.append(Integer.toHexString(k));
      paramView.append(", tag ");
      paramView.append(str);
      paramView.append(", or parent id 0x");
      paramView.append(Integer.toHexString(i));
      paramView.append(" with another fragment for ");
      paramView.append((String)localObject2);
      throw new IllegalArgumentException(paramView.toString());
    }
    return null;
  }
  
  public View onCreateView(String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    return onCreateView(null, paramString, paramContext, paramAttributeSet);
  }
}
