package com.github.frankiesardo.gaagbt.util;

import android.app.Application;
import android.content.Context;
import android.support.test.runner.AndroidJUnitRunner;
import android.test.InstrumentationTestRunner;
import com.github.frankiesardo.gaagbt.framework.injection.ApiLevel;
import com.github.frankiesardo.gaagbt.framework.injection.InjectingApplication;

public class InjectingApplicationTestRunner extends AndroidJUnitRunner {
    @Override
    public Application newApplication(ClassLoader cl, String className, Context context) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        return new InjectingApplication() {
            @Override
            protected ApiLevel getApiLevel() {
                return ApiLevel.MOCK;
            }
        };
    }
}
