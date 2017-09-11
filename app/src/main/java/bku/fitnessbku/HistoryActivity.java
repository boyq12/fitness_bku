package bku.fitnessbku;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.mikepenz.itemanimators.AlphaCrossFadeAnimator;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;

import bku.fitnessbku.gym.GymFragmentStatePagerAdapter;
import bku.fitnessbku.history.HistoryFragmentStatePagerAdapter;

/**
 * Created by 51202 on 9/10/2017.
 */

public class HistoryActivity extends AppCompatActivity {
    private Drawer result = null;
    private AccountHeader headerResult = null;

    private IProfile profile;
    @Override
    public void onCreate(Bundle savedBundle){
        super.onCreate(savedBundle);
        setContentView(R.layout.activity_viewpager_basic);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("History");
        HistoryFragmentStatePagerAdapter pagerAdapter = new HistoryFragmentStatePagerAdapter(getSupportFragmentManager());
        ViewPager gymPager = findViewById(R.id.pager);
        gymPager.setAdapter(pagerAdapter);
        profile = new ProfileDrawerItem().withName("Guest").withIcon(getResources().getDrawable(R.drawable.profile2));

        buildHeader(false, savedBundle);
        result = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(toolbar)
                .withAccountHeader(headerResult)
                .withHasStableIds(true)
                .withItemAnimator(new AlphaCrossFadeAnimator())
                .addDrawerItems(new PrimaryDrawerItem().withName(R.string.menu_gym).withDescription(R.string.menu_gym).withIcon(R.drawable.gym_icon).withIdentifier(1).withSelectable(true),
                        new PrimaryDrawerItem().withName("Target").withDescription("Your target").withIcon(R.drawable.gym_icon).withIdentifier(2).withSelectable(true),
                        new PrimaryDrawerItem().withName("Food Schedule").withDescription("Food schedule and setting").withIcon(R.drawable.gym_icon).withIdentifier(3).withSelectable(true),
                        new PrimaryDrawerItem().withName("Gym History").withDescription("Gym history").withIcon(R.drawable.gym_icon).withIdentifier(4).withSelectable(true),
                        new PrimaryDrawerItem().withName("Body Information").withDescription("Body information").withIcon(R.drawable.gym_icon).withIdentifier(5).withSelectable(true),
                        new PrimaryDrawerItem().withName("Gym Room").withDescription("Nearby gym room").withIcon(R.drawable.gym_icon).withIdentifier(6).withSelectable(true))
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        if (drawerItem != null) {
                            Intent intent = null;
                            switch ((int)drawerItem.getIdentifier()){
                                case 1:
                                    intent = new Intent(HistoryActivity.this, GymActivity.class);
                                    break;
                                case 2:
                                    intent = new Intent(HistoryActivity.this, TargetActivity.class);
                                    break;
                                case 3:
                                    intent = new Intent(HistoryActivity.this, FoodActivity.class);
                                    break;
                                case 5:
                                    intent = new Intent(HistoryActivity.this, BodyInfoActivity.class);
                                    break;
                                case 6:
                                    intent = new Intent(HistoryActivity.this, GymRoomActivity.class);
                                    break;
                                default:
                                    break;
                            }
                            if (intent != null) {
                                HistoryActivity.this.startActivity(intent);
                                HistoryActivity.this.finish();
                            }
                        }
                        return false;
                    }
                })
                .withSavedInstance(savedBundle)
                .withShowDrawerOnFirstLaunch(true).build();
        result.setSelection(4);
    }
    private void buildHeader(boolean compact, Bundle savedInstanceState) {
        // Create the AccountHeader
        headerResult = new AccountHeaderBuilder()
                .withActivity(this)
                .withHeaderBackground(R.drawable.header)
                .withCompactStyle(compact)
                .addProfiles(
                        profile
                )
                .withOnAccountHeaderListener(new AccountHeader.OnAccountHeaderListener() {
                    @Override
                    public boolean onProfileChanged(View view, IProfile profile, boolean current) {
                        return false;
                    }
                })
                .withSavedInstance(savedInstanceState)
                .build();
    }

    @Override
    public void onBackPressed() {
        //handle the back press :D close the drawer first and if the drawer is closed close the activity
        if (result != null && result.isDrawerOpen()) {
            result.closeDrawer();
        } else {
            this.finish();
            super.onBackPressed();
        }
    }
}
