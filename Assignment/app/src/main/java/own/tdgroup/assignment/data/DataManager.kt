package own.tdgroup.assignment.data

import android.content.Context
import own.tdgroup.assignment.data.entity.City
import own.tdgroup.assignment.data.local.DataBaseHelper



class DataManager {
    fun loadData(context: Context) : ArrayList<City>{
        val dbHelper = DataBaseHelper(context)
       return dbHelper.getCities()
    }
}