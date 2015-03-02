package com.github.frankiesardo.gaagbt.presentation.android.ui;

import com.github.frankiesardo.gaagbt.R;
import com.github.frankiesardo.gaagbt.entity.Repository;
import com.github.frankiesardo.gaagbt.util.ActivityTest;
import com.robotium.solo.Solo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static com.github.frankiesardo.gaagbt.boundary.mock.MockSearchRepositories.ANDROID_KEYWORD;
import static com.github.frankiesardo.gaagbt.boundary.mock.MockSearchRepositories.ANDROID_REPOSITORIES;
import static junit.framework.Assert.assertTrue;

public class SearchRepositoriesActivityTest extends ActivityTest {

    Solo solo;

    @Before
    public void setUp() throws Exception {
        super.setUp(SearchRepositoriesActivity.class);
        solo = new Solo(instrumentation, activity);
    }

    @Test
    public void testDisplayRepositoriesDescription() throws Exception {
        solo.clickOnActionBarItem(R.id.menu_search);
        solo.enterText(0, ANDROID_KEYWORD);
        solo.sendKey(Solo.ENTER);
        for (Repository repository : ANDROID_REPOSITORIES) {
            assertTrue(solo.waitForText(repository.getDescription()));
        }
    }

    @After
    public void tearDown() throws Exception {
        solo.finishOpenedActivities();
    }

}

