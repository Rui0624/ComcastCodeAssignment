package xfinity.com.comcastcodeassignment.ui.list;


import xfinity.com.comcastcodeassignment.model.CharacterList;

/**
 * CharacterContract is the interface for View and Presenter
 */
public interface CharacterContract {
    interface ICharacterView{
        void display(CharacterList list);
    }

    interface ICharacterPresenter{
        void getCharacter();
    }
}
