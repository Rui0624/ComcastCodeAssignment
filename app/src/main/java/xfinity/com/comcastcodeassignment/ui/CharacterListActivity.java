package xfinity.com.comcastcodeassignment.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.ToggleButton;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import xfinity.com.comcastcodeassignment.BuildConfig;
import xfinity.com.comcastcodeassignment.R;
import xfinity.com.comcastcodeassignment.model.CharacterModel;
import xfinity.com.comcastcodeassignment.ui.list.CharacterListFragment;
import xfinity.com.comcastcodeassignment.ui.details.CharacterDetailsActivity;
import xfinity.com.comcastcodeassignment.ui.details.CharacterDetailsFragment;
import xfinity.com.comcastcodeassignment.utils.CharacterSpliter;

/**
 * CharacterListActivity is the Activity as the main screen, contains the fragment for display the list
 * user decide the list as grid or list view in this screen
 */
public class CharacterListActivity extends AppCompatActivity implements CharacterListFragment.OnListClicked{

    private static final String TOGGLE_STATE = "toggle";
    private ToggleButton tb_gridSwitch;
    private TextView tv_toolbarTitle;
    private Toolbar toolbar;
    private boolean isGrid = false;
    private boolean isTablet = false;
    public static final String TITLE = "title";
    public static final String DESCRIPTION = "description";
    public static final String URL = "url";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_list );

        initView();
        checkTablet();
    }

    private void initView(){
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        tv_toolbarTitle = findViewById(R.id.tv_toolbarTitle);

        tv_toolbarTitle.setText( BuildConfig.APP_NAME);
    }

    /**
     * The cheachTablet is used to check the application is run on the tablet or phone
     * By checking the FrameLayout which used in the tablet but not phone,
     * Check whether this framelayout exist to determine whether user is on tablet or phone
     */
    private void checkTablet(){
        FrameLayout fl_tabletDetailsContainer = findViewById(R.id.fl_tabletDetailsContainer);
        if(fl_tabletDetailsContainer != null){
            isTablet = true;
        }else {
            tb_gridSwitch = findViewById(R.id.tb_gridSwitch);
            tb_gridSwitch.setOnCheckedChangeListener( new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(isChecked){
                        isGrid = true;
                        EventBus.getDefault().post(isGrid);
                    }else {
                        isGrid = false;
                        EventBus.getDefault().post(isGrid);
                    }
                }
            } );

        }
        CharacterListFragment listFragment = new CharacterListFragment();
        Bundle bundle = new Bundle();
        bundle.putBoolean(TOGGLE_STATE, isGrid);
        listFragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fl_container, listFragment).commit();
    }

    @Override
    protected void onSaveInstanceState(Bundle state) {
        super.onSaveInstanceState( state );
        state.putBoolean(TOGGLE_STATE, isGrid);
    }

    /**
     * The onItemSelected method from interface from the onItemSelected in the CharacterListFragment
     * @param view
     * @param item the item passed from the recyclerview
     */
    @Override
    public void onItemSelected(View view, CharacterModel item) {
        List<String> detailsInfo = CharacterSpliter.splitTitleDes(item.getText());
        String title = detailsInfo.get(0);
        String description = detailsInfo.get(1);
        String url = item.getIcon().getUrl();

        if(isTablet){
            CharacterDetailsFragment detailsFragment = CharacterDetailsFragment.newInstance(title, description, url);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fl_tabletDetailsContainer, detailsFragment)
                    .commit();
        } else {
            Intent intent = new Intent(CharacterListActivity.this, CharacterDetailsActivity.class);
            intent.putExtra(TITLE, title);
            intent.putExtra(DESCRIPTION, description);
            intent.putExtra(URL, url);
            startActivity(intent);
        }
    }
}
