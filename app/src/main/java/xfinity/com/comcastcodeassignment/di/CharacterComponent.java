package xfinity.com.comcastcodeassignment.di;

import javax.inject.Singleton;

import dagger.Component;
import xfinity.com.comcastcodeassignment.di.module.CharacterPresenterModule;
import xfinity.com.comcastcodeassignment.ui.list.CharacterListFragment;

@Singleton
@Component (modules = {CharacterPresenterModule.class})
public interface CharacterComponent {
    void injectPresenterComponent(CharacterListFragment characterListFragment);

}
