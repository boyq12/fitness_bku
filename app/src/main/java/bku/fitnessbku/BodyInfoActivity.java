package bku.fitnessbku;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.jaredrummler.materialspinner.MaterialSpinner;
import com.mikepenz.itemanimators.AlphaCrossFadeAnimator;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;


/**
 * Created by 51202 on 9/10/2017.
 */

public class BodyInfoActivity extends AppCompatActivity{
    private Drawer result = null;
    private AccountHeader headerResult = null;

    private IProfile profile;
    private Toolbar toolbar;
    private EditText editTextHeight, editTextWeight, editTextBust, editTextWaist, editTextHips;
    private MaterialSpinner spinner;
    @Override
    public void onCreate(Bundle savedBundle){
        super.onCreate(savedBundle);
        setContentView(R.layout.activity_body_info);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        profile = new ProfileDrawerItem().withName("Guest").withIcon(getResources().getDrawable(R.drawable.profile2));

        buildHeader(false, savedBundle);
        getSupportActionBar().setTitle("Body");

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
                                    intent = new Intent(BodyInfoActivity.this, GymActivity.class);
                                    break;
                                case 2:
                                    intent = new Intent(BodyInfoActivity.this, TargetActivity.class);
                                    break;
                                case 3:
                                    intent = new Intent(BodyInfoActivity.this, FoodActivity.class);
                                    break;
                                case 4:
                                    intent = new Intent(BodyInfoActivity.this, HistoryActivity.class);
                                    break;
                                case 6:
                                    intent = new Intent(BodyInfoActivity.this, GymRoomActivity.class);
                                    break;
                                default:
                                    break;
                            }
                            if (intent != null) {
                                BodyInfoActivity.this.startActivity(intent);
                                BodyInfoActivity.this.finish();
                            }
                        }
                        return false;
                    }
                })
                .withSavedInstance(savedBundle)
                .withShowDrawerOnFirstLaunch(true).build();
        result.setSelection(5);

        editTextHeight = findViewById(R.id.editTextHeight);
        editTextWeight = findViewById(R.id.editTextWeight);
        editTextBust = findViewById(R.id.editTextBust);
        editTextWaist = findViewById(R.id.editTextWaist);
        editTextHips = findViewById(R.id.editTextHips);
        spinner = (MaterialSpinner) findViewById(R.id.gender_spinner);
        spinner.setItems("Male", "Female");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_edit, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_edit:
                editTextHeight.setFocusable(true);
                editTextHeight.setFocusableInTouchMode(true);
                editTextHeight.setClickable(true);
                editTextWeight.setFocusable(true);
                editTextWeight.setFocusableInTouchMode(true);
                editTextWeight.setClickable(true);
                editTextBust.setFocusable(true);
                editTextBust.setFocusableInTouchMode(true);
                editTextBust.setClickable(true);
                editTextWaist.setFocusable(true);
                editTextWaist.setFocusableInTouchMode(true);
                editTextWaist.setClickable(true);
                editTextHips.setFocusable(true);
                editTextHips.setFocusableInTouchMode(true);
                editTextHips.setClickable(true);
                spinner.setSelected(true);
                spinner.setFocusable(true);
                item.setVisible(false);
                toolbar.getMenu().findItem(R.id.menu_save).setVisible(true);
                return true;
            case R.id.menu_save:
                editTextHeight.setFocusable(false);
                editTextHeight.setClickable(false);
                editTextWeight.setFocusable(false);
                editTextWeight.setClickable(false);
                editTextBust.setFocusable(false);
                editTextBust.setClickable(false);
                editTextWaist.setFocusable(false);
                editTextWaist.setClickable(false);
                editTextHips.setFocusable(false);
                editTextHips.setClickable(false);
                spinner.setSelected(false);
                spinner.setFocusable(false);
                item.setVisible(false);
                toolbar.getMenu().findItem(R.id.menu_edit).setVisible(true);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

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
