package own.tdgroup.assignment.ui.main.presenter

import own.tdgroup.assignment.ui.base.BasePresenter
import own.tdgroup.assignment.ui.main.interactor.IMainInteractor
import own.tdgroup.assignment.ui.main.view.MainView

class MainPresenter constructor(private val mainView: MainView, var interactor : IMainInteractor) : BasePresenter(mainView),IMainPresenter {


    override fun loadCities() {
        Thread(Runnable {
            mainView.showData(interactor.loadCities())
        }).start()
    }

    override fun detachView() {
    }


}