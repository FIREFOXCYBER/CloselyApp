package ru.ifsoft.chat;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import ru.ifsoft.chat.common.ActivityBase;
import ru.ifsoft.chat.dialogs.CoverChooseDialog;
import ru.ifsoft.chat.dialogs.PhotoChooseDialog;
import ru.ifsoft.chat.dialogs.ProfileBlockDialog;
import ru.ifsoft.chat.dialogs.ProfileReportDialog;


public class ProfileActivity extends ActivityBase implements PhotoChooseDialog.AlertPositiveListener, CoverChooseDialog.AlertPositiveListener, ProfileReportDialog.AlertPositiveListener, ProfileBlockDialog.AlertPositiveListener {

    Toolbar mToolbar;

    Fragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        if (savedInstanceState != null) {

            fragment = getSupportFragmentManager().getFragment(savedInstanceState, "currentFragment");

        } else {

            fragment = new ProfileFragment();
        }

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.container_body, fragment).commit();
    }

    @Override
    protected void onSaveInstanceState (Bundle outState) {

        super.onSaveInstanceState(outState);

        getSupportFragmentManager().putFragment(outState, "currentFragment", fragment);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        fragment.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onPhotoFromGallery() {

        ProfileFragment p = (ProfileFragment) fragment;
        p.photoFromGallery();
    }

    @Override
    public void onPhotoFromCamera() {

        ProfileFragment p = (ProfileFragment) fragment;
        p.photoFromCamera();
    }

    @Override
    public void onCoverFromGallery() {

        ProfileFragment p = (ProfileFragment) fragment;
        p.coverFromGallery();
    }

    @Override
    public void onCoverFromCamera() {

        ProfileFragment p = (ProfileFragment) fragment;
        p.coverFromCamera();
    }

    @Override
    public void onProfileReport(int position) {

        ProfileFragment p = (ProfileFragment) fragment;
        p.onProfileReport(position);
    }

    @Override
    public void onProfileBlock() {

        ProfileFragment p = (ProfileFragment) fragment;
        p.onProfileBlock();
    }

    @Override
    public void onBackPressed(){

        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        switch (item.getItemId()) {

            case android.R.id.home: {

                finish();
                return true;
            }

            default: {

                return super.onOptionsItemSelected(item);
            }
        }
    }
}
