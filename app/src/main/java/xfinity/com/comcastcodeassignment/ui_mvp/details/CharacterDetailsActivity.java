package xfinity.com.comcastcodeassignment.ui_mvp.details;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import xfinity.com.comcastcodeassignment.MainActivity;
import xfinity.com.comcastcodeassignment.R;

public class CharacterDetailsActivity extends AppCompatActivity {
    private Toolbar tb_details;
    private TextView tv_toolbarDetails;
    private CharacterDetailsFragment detailsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_character_details );

        tb_details = (Toolbar) findViewById(R.id.tb_details);
        setSupportActionBar(tb_details);
        tv_toolbarDetails = (TextView) findViewById(R.id.tv_toolbarDetails);
        String title = getIntent().getStringExtra(MainActivity.TITLE);
        String description = getIntent().getStringExtra(MainActivity.DESCRIPTION);
        String url = getIntent().getStringExtra(MainActivity.URL);

        tv_toolbarDetails.setText(title);

        if(savedInstanceState == null){
            detailsFragment = CharacterDetailsFragment.newInstance(title, description, url);
            getSupportFragmentManager().beginTransaction()
                    .replace( R.id.fl_detailContainer, detailsFragment)
                    .commit();
        }
    }
}
