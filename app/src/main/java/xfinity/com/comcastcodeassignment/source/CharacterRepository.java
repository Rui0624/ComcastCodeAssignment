package xfinity.com.comcastcodeassignment.source;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import xfinity.com.comcastcodeassignment.BuildConfig;
import xfinity.com.comcastcodeassignment.model.CharacterList;
import xfinity.com.comcastcodeassignment.source.remote.CharacterRemoteDataSource;

/**
 * CharacterRepository manages the remote data source and communicate with presenters
 */
public class CharacterRepository {

    private final Observable<CharacterList> observable;

    /**
     * build the constructor
     *
     * @param remoteDataSource set remoteDataSource to the repository
     */
    public CharacterRepository(CharacterRemoteDataSource remoteDataSource) {
        CharacterRemoteDataSource remoteDataSource1 = remoteDataSource;
        observable = remoteDataSource1.getCharacterService().getCharacterList( BuildConfig.URL, "json" );
    }

    /**
     * return the data in Repository as Observable
     *
     * @return observable subscribed by observer
     */
    public Observable<CharacterList> getObservable() {
        return observable
                .subscribeOn( Schedulers.io() )
                .observeOn( AndroidSchedulers.mainThread() );
    }


}
