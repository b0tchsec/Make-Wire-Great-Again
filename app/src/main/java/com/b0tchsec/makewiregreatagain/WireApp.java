package com.b0tchsec.makewiregreatagain;

/**
 * Created by aagallag on 12/30/16.
 */

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodReplacement;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam;

import static de.robv.android.xposed.XposedHelpers.findAndHookMethod;

public class WireApp implements IXposedHookLoadPackage {

    // Replace method startCall() method
    private XC_MethodReplacement startcall_hook = new XC_MethodReplacement() {
        @Override
        protected Object replaceHookedMethod(MethodHookParam param) throws Throwable {
            XposedBridge.log("You tried to call someone, I prevented that for you...");
            return null;
        }
    };

    public void handleLoadPackage(final LoadPackageParam lpparam) throws Throwable {
        if (!lpparam.packageName.equals("com.wire"))
            return;

        // Hook the method, void startCall(boolean withVideo)
        findAndHookMethod("com.waz.zclient.controllers.calling.CallingController", lpparam.classLoader,
                "startCall", boolean.class,
                startcall_hook);

        XposedBridge.log("We are hooked into WireApp, time to make it great again!");
    }
}
