package xfinity.com.comcastcodeassignment.ui.details;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import xfinity.com.comcastcodeassignment.model.CharacterDetail;
import xfinity.com.comcastcodeassignment.ui.CharacterListActivity;
import xfinity.com.comcastcodeassignment.R;

/**
 * CharacterDetailsActivity is responsible for display the details of the chosen Character
 * the DetailsFragment is contained in this activity
 */
public class CharacterDetailsActivity extends AppCompatActivity {
    private CharacterDetail characterDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_character_details );

        Toolbar tb_details = findViewById( R.id.tb_details );
        setSupportActionBar( tb_details );

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            characterDetail = new CharacterDetail(
                    extras.getString( CharacterListActivity.TITLE ),
                    extras.getString( CharacterListActivity.DESCRIPTION ),
                    extras.getString( CharacterListActivity.URL ) );
        }


        TextView tv_toolbarDetails = findViewById( R.id.tv_toolbarDetails );
        tv_toolbarDetails.setText( characterDetail.getTitle() );

        if (savedInstanceState == null) {
            CharacterDetailsFragment detailsFragment = CharacterDetailsFragment.newInstance(
                    characterDetail.getTitle(), characterDetail.getDescription(), characterDetail.getIconUrl() );
            getSupportFragmentManager().beginTransaction()
                    .replace( R.id.fl_detailContainer, detailsFragment )
                    .commit();
        }
    }
}
