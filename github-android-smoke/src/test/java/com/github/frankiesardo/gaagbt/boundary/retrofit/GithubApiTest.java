package com.github.frankiesardo.gaagbt.boundary.retrofit;

import com.github.frankiesardo.gaagbt.boundary.GithubApi;
import com.github.frankiesardo.gaagbt.entity.Repositories;
import com.github.frankiesardo.gaagbt.entity.Repository;
import com.github.frankiesardo.gaagbt.framework.injection.ApiLevel;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import dagger.Module;
import dagger.ObjectGraph;

import static org.fest.assertions.Assertions.assertThat;

public class GithubApiTest {

    public static final String ANDROID_KEYWORD = "android";

    private static final Repository GITHUB = new Repository("GitHub Android App");
    private static final Repository COURSERA = new Repository("Source Code for Android Course Example Applications");
    private static final Repository ACTIVE_ANDROID = new Repository("Active record style SQLite persistence for Android");
    private static final Repositories ANDROID_REPOSITORIES = new Repositories(Arrays.asList(GITHUB, COURSERA, ACTIVE_ANDROID));

    @Inject
    GithubApi githubApi;

    @Module(entryPoints = GithubApiTest.class)
    static class TestModule {
    }

    @Before
    public void setUp() throws Exception {
        ObjectGraph.create(new TestModule(), ApiLevel.DEBUG.module()).inject(this);
    }

    @Test
    public void searchRepositories() throws Exception {
        Repositories repositories = githubApi.searchRepositories(ANDROID_KEYWORD);
        assertThat(repositories).contains(ANDROID_REPOSITORIES.toArray());
    }
}

