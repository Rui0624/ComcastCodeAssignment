package xfinity.com.comcastcodeassignment.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * CharacterList is POJO class for parsing network call
 */
public class CharacterList {

    @SerializedName("RelatedTopics")
    @Expose
    private List<CharacterModel> characterModelList;

    public CharacterList(List<CharacterModel> characterModelList){
        this.characterModelList = characterModelList;
    }

    public List<CharacterModel> getCharacterModelList(){
        return characterModelList;
    }
}
