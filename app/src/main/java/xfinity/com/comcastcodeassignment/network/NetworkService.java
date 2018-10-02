package xfinity.com.comcastcodeassignment.network;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Url;
import xfinity.com.comcastcodeassignment.model.CharacterList;
import xfinity.com.comcastcodeassignment.model.simpson.SimpsonResponse;
import xfinity.com.comcastcodeassignment.model.wiremodel.WireResponse;

public interface NetworkService {

    //@GET
    //Observable<SimpsonsResponse> getSimpson(@Url String empty);

    @GET
    Observable<WireResponse> getWire(@Url String empty);

    @GET
    Observable<CharacterList> getCharacterList(@Url String empty);

    @GET
    Observable<SimpsonResponse> getSimpson(@Url String empty);
}
