package com.tab.marvelapp.ui.activities.comicsList;

import com.tab.marvelapp.model.Result;
import com.tab.marvelapp.ui.base.IPresenterView;


public interface ComicsListPresenterView extends IPresenterView {

     void onComicsSuccess(Result[] results);

     void onComicsFail();


}
