package xfinity.com.comcastcodeassignment.source.remote;

import xfinity.com.comcastcodeassignment.source.CharacterDataSource;

/**
 * CharacterRemoteDataSource is used to return the instance of CharacterService
 */
public class CharacterRemoteDataSource implements CharacterDataSource.RemoteCharacterCallback{
    public CharacterService getCharacterService(){
        return CharacterClient.getRetrofit().create(CharacterService.class);
    }

}
