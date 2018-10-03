package xfinity.com.comcastcodeassignment.ui.list;

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

import javax.inject.Inject;

import xfinity.com.comcastcodeassignment.R;
import xfinity.com.comcastcodeassignment.adapter.CharacterAdapter;
import xfinity.com.comcastcodeassignment.di.CharacterComponent;
import xfinity.com.comcastcodeassignment.di.DaggerCharacterComponent;
import xfinity.com.comcastcodeassignment.di.module.CharacterPresenterModule;
import xfinity.com.comcastcodeassignment.model.CharacterList;
import xfinity.com.comcastcodeassignment.model.CharacterModel;
import xfinity.com.comcastcodeassignment.source.CharacterRepository;
import xfinity.com.comcastcodeassignment.source.remote.CharacterRemoteDataSource;

/**
 * CharacterListFragment is used to define the list screen with the recyclerview to display
 */
public class CharacterListFragment extends Fragment implements CharacterContract.ICharacterView, CharacterAdapter.OnItemClicked {
    private RecyclerView rv_list;
    private boolean isGrid = false;
    private static final String TOGGLE_STATE = "toggle";

    private CharacterAdapter adapter;
    private static final String TAG = "CharacterListFragment";
    private OnListClicked mOnListClicked;
    CharacterComponent characterComponent;

    @Inject
    CharacterPresenter presenter;

    /**
     * OnListClicked interface is used to communicate between fragment and activity
     */
    public interface OnListClicked{
        void onItemSelected(View view, CharacterModel item);
    }


    /**
     * Set the list to the adapter
     * @param list
     */
    @Override
    public void display(CharacterList list) {
        for(CharacterModel characterModel : list.getCharacterModelList()){
            characterModel.setUseGrid(isGrid);
        }

        Log.i( TAG, "display: " + list.getCharacterModelList().get(0).isUseGrid() );

        adapter = new CharacterAdapter(getContext(), list.getCharacterModelList());
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
        rv_list = view.findViewById(R.id.rv_list);


        // presenter = new CharacterPresenter(this, new CharacterRepository(new CharacterRemoteDataSource()));
        //presenter = new CharacterPresenter( this );


        characterComponent = DaggerCharacterComponent.builder()
                .characterPresenterModule(new CharacterPresenterModule(new CharacterRepository(new CharacterRemoteDataSource()), this)).build();

        characterComponent.injectPresenterComponent(this);

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
