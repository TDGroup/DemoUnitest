package own.tdgroup.assignment.ui.main.interactor

import own.tdgroup.assignment.data.entity.City
import own.tdgroup.assignment.data.local.DataBaseHelper

class MainInteractor constructor(private val databaseHelper : DataBaseHelper): IMainInteractor{


     override fun loadCities () : ArrayList<City>{
        return databaseHelper.getCities()
     }
}