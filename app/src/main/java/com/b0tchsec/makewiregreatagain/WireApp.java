/**
 * Make Wire Great Again
 *
 * Copyright (C) 2016 Aaron Gallagher <aaron.b.gallagher@gmail.com>
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.b0tchsec.makewiregreatagain;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodReplacement;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.callbacks.XC_LoadPackage.LoadPackageParam;

import static de.robv.android.xposed.XposedHelpers.findAndHookMethod;

public class WireApp implements IXposedHookLoadPackage {

    static private String APP_NAME = "com.wire";
    static private String CLASS_CALL_CTRL = "com.waz.zclient.controllers.calling.CallingController";
    static private String METHOD_START_CALL = "startCall";
    static private String CLASS_BASE_CONV = "com.waz.api.impl.conversation.BaseConversation";
    static private String METHOD_KNOCK = "knock";

    // Replace startCall() method
    private XC_MethodReplacement startcall_hook = new XC_MethodReplacement() {
        @Override
        protected Object replaceHookedMethod(MethodHookParam param) throws Throwable {
            XposedBridge.log("You tried to call someone, I prevented that for you...");
            return null;
        }
    };

    // Replace knock() method
    private XC_MethodReplacement knock_hook = new XC_MethodReplacement() {
        @Override
        protected Object replaceHookedMethod(MethodHookParam param) throws Throwable {
            XposedBridge.log("You tried to ping someone, I prevented that for you...");
            return null;
        }
    };

    public void handleLoadPackage(final LoadPackageParam lpparam) throws Throwable {
        if (!lpparam.packageName.equals(APP_NAME))
            return;

        // Hook the method, void startCall(boolean withVideo)
        findAndHookMethod(CLASS_CALL_CTRL, lpparam.classLoader,
                METHOD_START_CALL, boolean.class,
                startcall_hook);

        // Hook the method, void knock()
        findAndHookMethod(CLASS_BASE_CONV, lpparam.classLoader,
                METHOD_KNOCK, knock_hook);

        XposedBridge.log("We are hooked into WireApp, time to make it great again!");
    }
}
