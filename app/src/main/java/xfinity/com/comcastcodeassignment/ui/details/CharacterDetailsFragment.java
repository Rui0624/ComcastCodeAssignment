package xfinity.com.comcastcodeassignment.ui.details;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import xfinity.com.comcastcodeassignment.R;

/**
 * CharacterDetailsFragment is the fragment is used to display the character details
 */
public class CharacterDetailsFragment extends Fragment {
    private static final String TITLE = "title";
    private static final String DESCRIPTION = "description";
    private static final String URL = "url";
    private String title, description, url;
    private ImageView iv_imageIcon;
    private TextView tv_itemTitle, tv_itemDescription;

    /**
     *
     * @param title
     * @param description
     * @param url
     * @return return the object of CharacterDetailsFragment
     */
    public static CharacterDetailsFragment newInstance(String title, String description, String url){
        CharacterDetailsFragment detailsFragment = new CharacterDetailsFragment();
        Bundle bundle = new Bundle();
        bundle.putString(TITLE, title);
        bundle.putString(DESCRIPTION, description);
        bundle.putString(URL, url);
        detailsFragment.setArguments(bundle);
        return detailsFragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        if(getArguments() != null){
            title = getArguments().getString(TITLE);
            description = getArguments().getString(DESCRIPTION);
            url = getArguments().getString(URL);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate( R.layout.fragment_details, container, false);
        tv_itemTitle = view.findViewById(R.id.tv_itemTitle);
        tv_itemDescription = view.findViewById(R.id.tv_itemDescription);
        iv_imageIcon = view.findViewById(R.id.iv_imageIcon);

        tv_itemTitle.setText(title);
        tv_itemDescription.setText(description);
        if(url != null && !url.isEmpty()){
            Picasso.with(getContext()).load(url).placeholder(R.drawable.image_not_available).into(iv_imageIcon);
        }

        return view;
    }
}
