package own.tdgroup.assignment.ui.base

abstract class BasePresenter constructor(val view: BaseView){
    abstract fun detachView()
}