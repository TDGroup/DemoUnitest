package own.tdgroup.assignment.ui.main.view

import own.tdgroup.assignment.data.entity.City
import own.tdgroup.assignment.ui.base.BaseView

interface MainView : BaseView{
    fun showData(cities : ArrayList<City>)

}