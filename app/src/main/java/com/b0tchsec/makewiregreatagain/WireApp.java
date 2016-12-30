package com.b0tchsec.makewiregreatagain;

/**
 * Created by aagallag on 12/30/16.
 */

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam;

public class WireApp implements IXposedHookLoadPackage {
    public void handleLoadPackage(final LoadPackageParam lpparam) throws Throwable {
        if (!lpparam.packageName.equals("com.wire"))
            return;

        XposedBridge.log("We are hooked into WireApp, time to make it great again!");
    }
}
