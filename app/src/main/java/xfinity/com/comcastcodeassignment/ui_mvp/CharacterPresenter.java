package xfinity.com.comcastcodeassignment.ui_mvp;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import xfinity.com.comcastcodeassignment.BuildConfig;
import xfinity.com.comcastcodeassignment.model.CharacterModel;
import xfinity.com.comcastcodeassignment.model.Icon;
import xfinity.com.comcastcodeassignment.model.simpson.SimpsonResponse;
import xfinity.com.comcastcodeassignment.model.wiremodel.WireResponse;
import xfinity.com.comcastcodeassignment.network.NetworkService;

import static android.content.ContentValues.TAG;

public class CharacterPresenter implements CharacterContract.ICharacterPresenter {
    
    CharacterContract.ICharacterView view;
    NetworkService networkService;

    public CharacterPresenter(CharacterContract.ICharacterView view, NetworkService networkService) {
        this.view = view;
        this.networkService = networkService;
    }

    @Override
    public void getCharacter() {
        if(BuildConfig.IS_SIMPSON){
            getObservableFromSimpson().subscribeWith(getObserver());
        }else {
            getObservableFromWire().subscribeWith(getObserver());
        }
        
    }
    
    public Observable<List<CharacterModel>> getObservableFromSimpson(){
        Observable<SimpsonResponse> observable = networkService.getSimpson( "" );
        
        return observable.map( new Function<SimpsonResponse, List<CharacterModel>>() {
            @Override
            public List<CharacterModel> apply(SimpsonResponse simpsonResponse) throws Exception {
                List<CharacterModel> characterModelList = new ArrayList<>();
                for(int i = 0; i < simpsonResponse.getRelatedTopics().size(); i++){
                    Icon icon = new Icon(simpsonResponse.getRelatedTopics().get(i).getIcon().getURL());
                    CharacterModel characterModel = new CharacterModel(simpsonResponse.getRelatedTopics().get(i).getText(), icon);
                    characterModelList.add(characterModel);
                }
                return characterModelList;
            }
        } ).flatMap( new Function<List<CharacterModel>, ObservableSource<List<CharacterModel>>>() {
            @Override
            public ObservableSource<List<CharacterModel>> apply(List<CharacterModel> characterModels) throws Exception {
                return Observable.fromArray( characterModels );
            }
        } ).subscribeOn( Schedulers.io()).observeOn( AndroidSchedulers.mainThread());
    }


    public Observable<List<CharacterModel>> getObservableFromWire(){
        Observable<WireResponse> observable = networkService.getWire("");

        return observable.map( new Function<WireResponse, List<CharacterModel>>() {
            @Override
            public List<CharacterModel> apply(WireResponse wireResponse) throws Exception {
                List<CharacterModel> characterModelList = new ArrayList<>();

                for(int i = 0; i < wireResponse.getRelatedTopics().size(); i++){
                    Icon icon = new Icon(wireResponse.getRelatedTopics().get(i).getIcon().getURL());
                    CharacterModel characterModel = new CharacterModel(wireResponse.getRelatedTopics().get(i).getText(), icon);
                    characterModelList.add(characterModel);
                }
                return characterModelList;
            }
        } ).flatMap( new Function<List<CharacterModel>, ObservableSource<List<CharacterModel>>>() {
            @Override
            public ObservableSource<List<CharacterModel>> apply(List<CharacterModel> characterModels) throws Exception {
                return Observable.fromArray( characterModels );
            }
        } ).subscribeOn( Schedulers.io()).observeOn( AndroidSchedulers.mainThread());
    }


    public DisposableObserver<List<CharacterModel>> getObserver(){
        return new DisposableObserver<List<CharacterModel>>() {
            @Override
            public void onNext(List<CharacterModel> characterModels) {
                view.display(characterModels);
            }

            @Override
            public void onError(Throwable e) {
                Log.i( TAG, "onError: " + e.getMessage());
            }

            @Override
            public void onComplete() {
                Log.i( TAG, "onComplete: " );
            }
        };
    }
}
