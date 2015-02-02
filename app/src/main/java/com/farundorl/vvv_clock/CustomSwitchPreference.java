package com.farundorl.vvv_clock;

import android.content.Context;
import android.preference.SwitchPreference;
import android.util.AttributeSet;

/**
 * Created by gya on 2015/02/02.
 */
public class CustomSwitchPreference extends SwitchPreference {
    public CustomSwitchPreference(Context context) {
        this(context, null);
    }

    public CustomSwitchPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, android.R.attr.switchPreferenceStyle);
    }

    public CustomSwitchPreference(Context context, AttributeSet attributeSet, int defStyle) {
        super(context, attributeSet, defStyle);
    }

}
