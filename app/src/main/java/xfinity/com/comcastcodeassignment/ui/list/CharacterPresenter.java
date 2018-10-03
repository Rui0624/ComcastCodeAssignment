package xfinity.com.comcastcodeassignment.ui.list;

import android.util.Log;

import io.reactivex.observers.DisposableObserver;
import xfinity.com.comcastcodeassignment.model.CharacterList;
import xfinity.com.comcastcodeassignment.source.CharacterRepository;

import static android.content.ContentValues.TAG;

/**
 * CharacterPresenter is used to communicate the CharacterListFragment and CharacterRespository
 */
public class CharacterPresenter implements CharacterContract.ICharacterPresenter {

    private final CharacterContract.ICharacterView view;
    private final CharacterRepository characterRepository;


    /**
     * Build constructor for the Presenter
     *
     * @param view set the view to presenter
     * @param characterRepository set the model to presenter
     */
    public CharacterPresenter(CharacterContract.ICharacterView view, CharacterRepository characterRepository) {
        this.view = view;
        this.characterRepository = characterRepository;
    }


    @Override
    public void getCharacter() {
        characterRepository.getObservable().subscribeWith( getObserver() );
    }


    /**
     * Build the Observer
     *
     * @return return observer
     */
    private DisposableObserver<CharacterList> getObserver() {
        return new DisposableObserver<CharacterList>() {
            @Override
            public void onNext(CharacterList characterList) {
                Log.i( TAG, "onNext: " + characterList.getCharacterModelList().size() );
                view.display( characterList );
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };
    }


}
