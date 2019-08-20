package com.sourcey.materiallogindemo;

import android.support.design.widget.TextInputEditText;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.IdlingPolicies;
import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.*;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;


@RunWith(AndroidJUnit4.class)
@LargeTest
public class MTest {
    @Rule
    public ActivityTestRule<MainActivity> activityRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void SignupMobile() throws InterruptedException {
        onView(withId(R.id.link_signup)).perform(click());
        closeSoftKeyboard();
        onView(withId(R.id.input_name)).perform(replaceText("morakot"));
        onView(withId(R.id.input_address)).perform(replaceText("53/952"));
        onView(withId(R.id.input_email)).perform(replaceText("morakot@gmail.com"));
        onView(withId(R.id.input_mobile)).perform(replaceText("0814069738"));
        onView(withId(R.id.input_password)).perform(replaceText("123456"));
        onView(withId(R.id.input_reEnterPassword)).perform(replaceText("123456"));
        onView(withId(R.id.btn_signup)).perform(click());
        onView(withText("Creating Account...")).check(matches(isDisplayed()));
        Thread.sleep(5000);
        onView(withText("Material Login Example")).check(matches(isDisplayed()));
        onView(withId(R.id.btn_logout)).perform(click());


    }
    @After
    public void LoginMobile() throws InterruptedException {
        onView(withId(R.id.input_email)).perform(replaceText("morakot@gmail.com"));
        onView(withId(R.id.input_password)).perform(replaceText("123456"));
        onView(withId(R.id.btn_login)).perform(click());
        Thread.sleep(5000);
        onView(withText("Material Login Example")).check(matches(isDisplayed()));
        onView(withId(R.id.btn_logout)).perform(click());

    }
}