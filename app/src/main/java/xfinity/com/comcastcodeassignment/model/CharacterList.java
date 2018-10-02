package xfinity.com.comcastcodeassignment.model;

import java.util.List;

public class CharacterList {

    private List<CharacterModel> characterModelList = null;

    public CharacterList(List<CharacterModel> characterModelList){
        this.characterModelList = characterModelList;
    }

    public List<CharacterModel> getCharacterModelList(){
        return characterModelList;
    }
}
