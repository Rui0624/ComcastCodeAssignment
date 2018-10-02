package xfinity.com.comcastcodeassignment.ui_mvp;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.List;

import xfinity.com.comcastcodeassignment.R;
import xfinity.com.comcastcodeassignment.adapter.CharacterAdapter;
import xfinity.com.comcastcodeassignment.model.CharacterModel;
import xfinity.com.comcastcodeassignment.network.NetworkClient;
import xfinity.com.comcastcodeassignment.network.NetworkService;

public class CharacterListFragment extends Fragment implements CharacterContract.ICharacterView, CharacterAdapter.OnItemClicked {
    private RecyclerView rv_list;
    private boolean isGrid = false;
    private static final String TOGGLE_STATE = "toggle";
    private CharacterPresenter presenter;
    private CharacterAdapter adapter;
    private static final String TAG = "CharacterListFragment";
    private OnListClicked mOnListClicked;

    public interface OnListClicked{
        void onItemSelected(View view, CharacterModel item);
    }


    @Override
    public void display(List<CharacterModel> list) {
        for(CharacterModel characterModel : list){
            characterModel.setUseGrid(isGrid);
        }

        Log.i( TAG, "display: " + list.get(0).isUseGrid() );

        adapter = new CharacterAdapter(getContext(), list);
        rv_list.setAdapter(adapter);
        adapter.setOnItemClickedListener(this);
    }

    @Subscribe
    public void onEvent(Boolean isGrid) {

        this.isGrid = isGrid;
        Log.i( TAG, "onEvent: " + this.isGrid );
        if(isGrid){
            rv_list.setLayoutManager(new GridLayoutManager(getContext(), 3));
            presenter.getCharacter();
        } else {
            rv_list.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL, false));
            presenter.getCharacter();
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate( R.layout.fragment_list, container, false);
        EventBus.getDefault().register(this);
        rv_list = (RecyclerView) view.findViewById(R.id.rv_list);
        presenter = new CharacterPresenter(this, NetworkClient.getRetrofit().create( NetworkService.class));

        if(getArguments() != null){
            isGrid = getArguments().getBoolean(TOGGLE_STATE);
            if(isGrid){
                rv_list.setLayoutManager(new GridLayoutManager(getContext(), 3));
            } else {
                rv_list.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL, false));
            }
        }

        presenter.getCharacter();


        return view;
    }


    @Override
    public void onItemClicked(View view, CharacterModel item) {
        mOnListClicked.onItemSelected(view, item);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach( context );
        try {
            mOnListClicked = (OnListClicked) getActivity();
        }catch (ClassCastException e){
            throw new ClassCastException("must implement OnListener");
        }

    }
}
