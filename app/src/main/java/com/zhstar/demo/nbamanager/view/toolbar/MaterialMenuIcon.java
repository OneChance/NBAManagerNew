/*
 * Copyright (C) 2014 Balys Valentukevicius
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

package com.zhstar.demo.nbamanager.view.toolbar;

import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.Activity;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;

import com.zhstar.demo.nbamanager.view.toolbar.MaterialMenuDrawable.Stroke;

public class MaterialMenuIcon extends MaterialMenuBase {

    public MaterialMenuIcon(Activity activity, int color, Stroke stroke) {
        super(activity, color, stroke);
    }

    public MaterialMenuIcon(Activity activity, int color, Stroke stroke, int transformDuration) {
        super(activity, color, stroke, transformDuration);
    }

    @Override
    protected View getActionBarHomeView(Activity activity) {
        Resources resources = activity.getResources();
        return activity.getWindow().getDecorView().findViewById(
            resources.getIdentifier("android:id/home", null, null)
        );
    }

    @Override
    protected View getActionBarUpView(Activity activity) {
        Resources resources = activity.getResources();
        ViewGroup actionBarView = (ViewGroup) activity.getWindow().getDecorView().findViewById(
            resources.getIdentifier("android:id/action_bar", null, null)
        );
        View homeView = actionBarView.getChildAt(
            actionBarView.getChildCount() > 1 ? 1 : 0
        );
        return homeView.findViewById(
            resources.getIdentifier("android:id/up", null, null)
        );
    }

    @Override
    protected boolean providesActionBar() {
        return true;
    }

    @Override
    @TargetApi(14)
    protected void setActionBarSettings(Activity activity) {
        ActionBar actionBar = activity.getActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(false);
        actionBar.setIcon(getDrawable());
    }
}