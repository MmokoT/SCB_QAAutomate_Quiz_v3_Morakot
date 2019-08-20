package com.sourcey.materiallogindemo;

import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;


import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.closeSoftKeyboard;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;

import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.hasErrorText;

import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;


@RunWith(AndroidJUnit4.class)
@LargeTest
public class ErrorCase {
    @Rule
    public ActivityTestRule<MainActivity> activityRule =
            new ActivityTestRule<>(MainActivity.class);

    @Test
    public void NameInvalid() throws InterruptedException {
        onView(withId(R.id.link_signup)).perform(click());
        closeSoftKeyboard();
        onView(withId(R.id.input_name)).perform(replaceText("mo"));
        onView(withId(R.id.input_address)).perform(replaceText("53/952"));
        onView(withId(R.id.input_email)).perform(replaceText("morakot@hotmail.com"));
        onView(withId(R.id.input_mobile)).perform(replaceText("0814069738"));
        onView(withId(R.id.input_password)).perform(replaceText("123456"));
        onView(withId(R.id.input_reEnterPassword)).perform(replaceText("123456"));
        onView(withId(R.id.btn_signup)).perform(click());
        Thread.sleep(1500);
        onView(withId(R.id.input_name)).perform(click());
        onView(withId(R.id.input_name)).check(matches(hasErrorText("at least 3 characters")));

    }
    @Test
    public void AddressInvalid() throws InterruptedException {
        onView(withId(R.id.link_signup)).perform(click());
        closeSoftKeyboard();
        onView(withId(R.id.input_name)).perform(replaceText("morakot"));
        onView(withId(R.id.input_address)).perform(replaceText(""));
        onView(withId(R.id.input_email)).perform(replaceText("morakot@hotmail.com"));
        onView(withId(R.id.input_mobile)).perform(replaceText("0814069738"));
        onView(withId(R.id.input_password)).perform(replaceText("123456"));
        onView(withId(R.id.input_reEnterPassword)).perform(replaceText("123456"));
        onView(withId(R.id.btn_signup)).perform(click());
        Thread.sleep(1500);
        onView(withId(R.id.input_address)).perform(click());
        onView(withId(R.id.input_address)).check(matches(hasErrorText("Enter Valid Address")));
    }
    @Test
    public void EmailInvalid1() throws InterruptedException {
        onView(withId(R.id.link_signup)).perform(click());
        closeSoftKeyboard();
        onView(withId(R.id.input_name)).perform(replaceText("morakot"));
        onView(withId(R.id.input_address)).perform(replaceText("53/952"));
        onView(withId(R.id.input_email)).perform(replaceText(""));
        onView(withId(R.id.input_mobile)).perform(replaceText("0814069738"));
        onView(withId(R.id.input_password)).perform(replaceText("123456"));
        onView(withId(R.id.input_reEnterPassword)).perform(replaceText("123456"));
        onView(withId(R.id.btn_signup)).perform(click());
        Thread.sleep(1500);
        onView(withId(R.id.input_email)).perform(click());
        onView(withId(R.id.input_email)).check(matches(hasErrorText("enter a valid email address")));
    }
    @Test
    public void EmailInvalid2() throws InterruptedException {
        onView(withId(R.id.link_signup)).perform(click());
        closeSoftKeyboard();
        onView(withId(R.id.input_name)).perform(replaceText("morakot"));
        onView(withId(R.id.input_address)).perform(replaceText("53/952"));
        onView(withId(R.id.input_email)).perform(replaceText("Morakot@.com"));
        onView(withId(R.id.input_mobile)).perform(replaceText("0814069738"));
        onView(withId(R.id.input_password)).perform(replaceText("123456"));
        onView(withId(R.id.input_reEnterPassword)).perform(replaceText("123456"));
        onView(withId(R.id.btn_signup)).perform(click());
        Thread.sleep(1500);
        onView(withId(R.id.input_email)).perform(click());
        onView(withId(R.id.input_email)).check(matches(hasErrorText("enter a valid email address")));
    }
    @Test
    public void MobileInvalid1() throws InterruptedException {
        onView(withId(R.id.link_signup)).perform(click());
        closeSoftKeyboard();
        onView(withId(R.id.input_name)).perform(replaceText("morakot"));
        onView(withId(R.id.input_address)).perform(replaceText("53/952"));
        onView(withId(R.id.input_email)).perform(replaceText("Morakot@gmail.com"));
        onView(withId(R.id.input_mobile)).perform(replaceText(""));
        onView(withId(R.id.input_password)).perform(replaceText("123456"));
        onView(withId(R.id.input_reEnterPassword)).perform(replaceText("123456"));
        onView(withId(R.id.btn_signup)).perform(click());
        Thread.sleep(1500);
        onView(withId(R.id.input_mobile)).perform(click());
        onView(withId(R.id.input_mobile)).check(matches(hasErrorText("Enter Valid Mobile Number")));
    }
    @Test
    public void MobileInvalid2() throws InterruptedException {
        onView(withId(R.id.link_signup)).perform(click());
        closeSoftKeyboard();
        onView(withId(R.id.input_name)).perform(replaceText("morakot"));
        onView(withId(R.id.input_address)).perform(replaceText("53/952"));
        onView(withId(R.id.input_email)).perform(replaceText("Morakot@gmail.com"));
        onView(withId(R.id.input_mobile)).perform(replaceText("081"));
        onView(withId(R.id.input_password)).perform(replaceText("123456"));
        onView(withId(R.id.input_reEnterPassword)).perform(replaceText("123456"));
        onView(withId(R.id.btn_signup)).perform(click());
        Thread.sleep(1500);
        onView(withId(R.id.input_mobile)).perform(click());
        onView(withId(R.id.input_mobile)).check(matches(hasErrorText("Enter Valid Mobile Number")));
    }
    @Test
    public void MobileInvalid3() throws InterruptedException {
        onView(withId(R.id.link_signup)).perform(click());
        closeSoftKeyboard();
        onView(withId(R.id.input_name)).perform(replaceText("morakot"));
        onView(withId(R.id.input_address)).perform(replaceText("53/952"));
        onView(withId(R.id.input_email)).perform(replaceText("Morakot@gmail.com"));
        onView(withId(R.id.input_mobile)).perform(replaceText("081406973821"));
        onView(withId(R.id.input_password)).perform(replaceText("123456"));
        onView(withId(R.id.input_reEnterPassword)).perform(replaceText("123456"));
        onView(withId(R.id.btn_signup)).perform(click());
        Thread.sleep(1500);
        onView(withId(R.id.input_mobile)).perform(click());
        onView(withId(R.id.input_mobile)).check(matches(hasErrorText("Enter Valid Mobile Number")));
    }
    @Test
    public void passwordInvalid1() throws InterruptedException {
        onView(withId(R.id.link_signup)).perform(click());
        closeSoftKeyboard();
        onView(withId(R.id.input_name)).perform(replaceText("morakot"));
        onView(withId(R.id.input_address)).perform(replaceText("53/952"));
        onView(withId(R.id.input_email)).perform(replaceText("Morakot@gmail.com"));
        onView(withId(R.id.input_mobile)).perform(replaceText("0814069738"));
        onView(withId(R.id.input_password)).perform(replaceText(""));
        onView(withId(R.id.input_reEnterPassword)).perform(replaceText("123456"));
        onView(withId(R.id.btn_signup)).perform(click());
        Thread.sleep(1500);
        onView(withId(R.id.input_password)).perform(click());
        onView(withId(R.id.input_password)).check(matches(hasErrorText("between 4 and 10 alphanumeric characters")));
    }
    @Test
    public void passwordInvalid2() throws InterruptedException {
        onView(withId(R.id.link_signup)).perform(click());
        closeSoftKeyboard();
        onView(withId(R.id.input_name)).perform(replaceText("morakot"));
        onView(withId(R.id.input_address)).perform(replaceText("53/952"));
        onView(withId(R.id.input_email)).perform(replaceText("Morakot@gmail.com"));
        onView(withId(R.id.input_mobile)).perform(replaceText("0814069738"));
        onView(withId(R.id.input_password)).perform(replaceText("123"));
        onView(withId(R.id.input_reEnterPassword)).perform(replaceText("123456"));
        onView(withId(R.id.btn_signup)).perform(click());
        Thread.sleep(1500);
        onView(withId(R.id.input_password)).perform(click());
        onView(withId(R.id.input_password)).check(matches(hasErrorText("between 4 and 10 alphanumeric characters")));
    }
    @Test
    public void passwordInvalid3() throws InterruptedException {
        onView(withId(R.id.link_signup)).perform(click());
        closeSoftKeyboard();
        onView(withId(R.id.input_name)).perform(replaceText("morakot"));
        onView(withId(R.id.input_address)).perform(replaceText("53/952"));
        onView(withId(R.id.input_email)).perform(replaceText("Morakot@gmail.com"));
        onView(withId(R.id.input_mobile)).perform(replaceText("0814069738"));
        onView(withId(R.id.input_password)).perform(replaceText("1234567891011"));
        onView(withId(R.id.input_reEnterPassword)).perform(replaceText("123456"));
        onView(withId(R.id.btn_signup)).perform(click());
        Thread.sleep(1500);
        onView(withId(R.id.input_password)).perform(click());
        onView(withId(R.id.input_password)).check(matches(hasErrorText("between 4 and 10 alphanumeric characters")));
    }
    @Test
    public void RepasswordInvalid() throws InterruptedException {
        onView(withId(R.id.link_signup)).perform(click());
        closeSoftKeyboard();
        onView(withId(R.id.input_name)).perform(replaceText("morakot"));
        onView(withId(R.id.input_address)).perform(replaceText("53/952"));
        onView(withId(R.id.input_email)).perform(replaceText("Morakot@gmail.com"));
        onView(withId(R.id.input_mobile)).perform(replaceText("0814069738"));
        onView(withId(R.id.input_password)).perform(replaceText("123456789"));
        onView(withId(R.id.input_reEnterPassword)).perform(replaceText("123456"));
        onView(withId(R.id.btn_signup)).perform(click());
        Thread.sleep(1500);
        onView(withId(R.id.input_reEnterPassword)).perform(click());
        onView(withId(R.id.input_reEnterPassword)).check(matches(hasErrorText("Password Do not match")));
    }
    @Test
    public void LoginUserInvalid() throws InterruptedException {
        closeSoftKeyboard();
        onView(withId(R.id.input_email)).perform(replaceText(""));
        onView(withId(R.id.input_password)).perform(replaceText("123456"));
        onView(withId(R.id.btn_login)).perform(click());
        Thread.sleep(1500);
        onView(withId(R.id.input_email)).perform(click());
        onView(withId(R.id.input_email)).check(matches(hasErrorText("enter a valid email address")));
    }
    @Test
    public void LoginPasswordInvalid() throws InterruptedException {
        closeSoftKeyboard();
        onView(withId(R.id.input_email)).perform(replaceText("morakot@gmail.com"));
        onView(withId(R.id.input_password)).perform(replaceText("123"));
        onView(withId(R.id.btn_login)).perform(click());
        Thread.sleep(1500);
        onView(withId(R.id.input_password)).perform(click());
        onView(withId(R.id.input_password)).check(matches(hasErrorText("between 4 and 10 alphanumeric characters")));
    }
    @Test
    public void LoginUserPasswordInvalid() throws InterruptedException {
        closeSoftKeyboard();
        onView(withId(R.id.input_email)).perform(replaceText("morakot@hotmail.com"));
        onView(withId(R.id.input_password)).perform(replaceText("123456"));
        onView(withId(R.id.btn_login)).perform(click());
        Thread.sleep(1500);
        onView(withId(R.id.input_password)).perform(click());
        onView(withId(R.id.input_password)).check(matches(hasErrorText("enter a valid email address or password")));
    }
}