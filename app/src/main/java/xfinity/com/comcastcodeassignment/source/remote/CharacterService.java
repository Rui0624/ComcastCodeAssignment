package xfinity.com.comcastcodeassignment.source.remote;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;
import xfinity.com.comcastcodeassignment.model.CharacterList;


/**
 * CharacterService provides methods to request CharacterList from the server
 */
public interface CharacterService {


    @GET("/")
    Observable<CharacterList> getCharacterList(@Query(value = "q", encoded = true) String q, @Query("format") String format);


}
