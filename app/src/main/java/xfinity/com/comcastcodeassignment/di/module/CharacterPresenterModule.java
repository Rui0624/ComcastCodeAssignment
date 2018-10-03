package xfinity.com.comcastcodeassignment.di.module;

import dagger.Module;
import dagger.Provides;
import xfinity.com.comcastcodeassignment.source.CharacterRepository;
import xfinity.com.comcastcodeassignment.ui.list.CharacterContract;
import xfinity.com.comcastcodeassignment.ui.list.CharacterPresenter;

@Module
public class CharacterPresenterModule {

    private final CharacterRepository repository;
    private final CharacterContract.ICharacterView view;

    public CharacterPresenterModule(CharacterRepository repository, CharacterContract.ICharacterView view) {
        this.repository = repository;
        this.view = view;
    }

    @Provides
    public CharacterPresenter getCharacterPresenter() {
        return new CharacterPresenter( view, repository );
    }
}
