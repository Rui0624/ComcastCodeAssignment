package xfinity.com.comcastcodeassignment.ui_mvp;

import java.util.List;

import xfinity.com.comcastcodeassignment.model.CharacterModel;

public interface CharacterContract {
    interface ICharacterView{
        void display(List<CharacterModel> list);
    }

    interface ICharacterPresenter{
        void getCharacter();
    }
}
