package com.github.frankiesardo.gaagbt.util;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public abstract class ActivityTest {

    protected Activity activity;
    protected Instrumentation instrumentation;

    protected void setUp(Class classOfActivity) {
        activity = startActivity(classOfActivity);
    }

    private Activity startActivity(Class classOfActivity) {
        instrumentation = InstrumentationRegistry.getInstrumentation();
        String targetPackage = instrumentation.getTargetContext().getPackageName();

        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.setClassName(targetPackage, classOfActivity.getName());
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        Activity activity = instrumentation.startActivitySync(intent);
        instrumentation.waitForIdleSync();
        return activity;
    }

}
