/*
 * Copyright 2015, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.drweb.urlfiltr._Old;

import android.support.test.filters.SdkSuppress;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Basic sample for unbundled UiAutomator.
 */
@RunWith(AndroidJUnit4.class)
@SdkSuppress(minSdkVersion = 18)
public class InstallAllBrowsers2 {

    /*    private static final String BROWSER_PKG_01 = "com.opera.browser";
        private static final String BROWSER_PKG_02 = "com.opera.browser.beta";
            private static final String BROWSER_PKG_03 = "com.opera.mini.native";
            private static final String BROWSER_PKG_04 = "com.opera.mini.native.beta";
            private static final String BROWSER_PKG_05 = "org.mozilla.firefox";
            private static final String BROWSER_PKG_06 = "org.mozilla.firefox_beta";
            private static final String BROWSER_PKG_07 = "mobi.mgeek.TunnyBrowser";
            private static final String BROWSER_PKG_08 = "com.android.chrome";
            private static final String BROWSER_PKG_09 = "com.yandex.browser";
            private static final String BROWSER_PKG_10 = "com.yandex.browser.beta";
            private static final String BROWSER_PKG_11 = "com.jiubang.browser";
            private static final String BROWSER_PKG_12 = "com.boatbrowser.free";
            private static final String BROWSER_PKG_13 = "com.boatgo.browser";
            */
    @Before
    public void install01() throws Exception {

        Utils2.installByGooglePlay("com.opera.browser");
        Utils2.installByGooglePlay("com.opera.browser.beta");
        Utils2.installByGooglePlay("com.opera.mini.native");
        Utils2.installByGooglePlay("com.opera.mini.native.beta");
        Utils2.installByGooglePlay("org.mozilla.firefox");
        Utils2.installByGooglePlay("org.mozilla.firefox_beta");
        Utils2.installByGooglePlay("mobi.mgeek.TunnyBrowser");
        Utils2.installByGooglePlay("com.android.chrome");
        Utils2.installByGooglePlay("com.yandex.browser");
        Utils2.installByGooglePlay("com.yandex.browser.beta");
        Utils2.installByGooglePlay("com.jiubang.browser");
        Utils2.installByGooglePlay("com.boatbrowser.free");
        Utils2.installByGooglePlay("com.boatgo.browser");

    }


    @Test
    public void runTest() throws Exception {


    }

}
