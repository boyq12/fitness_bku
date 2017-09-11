package bku.fitnessbku;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.mikepenz.itemanimators.AlphaCrossFadeAnimator;

public class MainActivity extends AppCompatActivity {


    private Drawer result = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Handle Toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        result = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(toolbar)
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
                                    intent = new Intent(MainActivity.this, GymActivity.class);
                                    break;
                                case 2:
                                    intent = new Intent(MainActivity.this, TargetActivity.class);
                                    break;
                                case 3:
                                    intent = new Intent(MainActivity.this, FoodActivity.class);
                                    break;
                                case 4:
                                    intent = new Intent(MainActivity.this, HistoryActivity.class);
                                    break;
                                case 5:
                                    intent = new Intent(MainActivity.this, BodyInfoActivity.class);
                                    break;
                                case 6:
                                    intent = new Intent(MainActivity.this, GymRoomActivity.class);
                                    break;
                                default:
                                    intent = new Intent(MainActivity.this, GymActivity.class);
                                    break;
                            }
                            if (intent != null) {
                                MainActivity.this.startActivity(intent);
                                MainActivity.this.finish();
                            }
                        }
                        return false;
                    }
                })
                .withSavedInstance(savedInstanceState).withShowDrawerOnFirstLaunch(true)
                .build();
        result.setSelection(1);
    }


    @Override
    public void onBackPressed() {
        //handle the back press :D close the drawer first and if the drawer is closed close the activity
        if (result != null && result.isDrawerOpen()) {
            result.closeDrawer();
        } else {
            super.onBackPressed();
        }
    }
}
