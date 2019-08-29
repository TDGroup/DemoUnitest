package own.tdgroup.assignment.ui.main.interactor

import own.tdgroup.assignment.data.entity.City

interface IMainInteractor {
    fun loadCities () : ArrayList<City>
}