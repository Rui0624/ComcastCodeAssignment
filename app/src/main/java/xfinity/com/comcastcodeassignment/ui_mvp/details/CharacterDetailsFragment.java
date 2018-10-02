package xfinity.com.comcastcodeassignment.ui_mvp.details;

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

public class CharacterDetailsFragment extends Fragment {
    private static final String TITLE = "title";
    private static final String DESCRIPTION = "description";
    private static final String URL = "url";
    private String title, description, url;
    private ImageView iv_imageIcon;
    private TextView tv_itemTitle, tv_itemDescription;


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
        tv_itemTitle = (TextView) view.findViewById(R.id.tv_itemTitle);
        tv_itemDescription = (TextView)view.findViewById(R.id.tv_itemDescription);
        iv_imageIcon = (ImageView) view.findViewById(R.id.iv_imageIcon);

        tv_itemTitle.setText(title);
        tv_itemDescription.setText(description);
        if(!url.isEmpty()){
            Picasso.with(getContext()).load(url).placeholder(R.drawable.image_not_available).fit().into(iv_imageIcon);
        }

        return view;
    }
}
