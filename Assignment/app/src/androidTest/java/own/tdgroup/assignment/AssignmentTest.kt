package own.tdgroup.assignment

import android.support.test.InstrumentationRegistry
import org.junit.Before
import org.junit.Test
import own.tdgroup.assignment.data.entity.City
import own.tdgroup.assignment.data.local.DataBaseHelper
import own.tdgroup.assignment.ui.main.view.MainView
import own.tdgroup.assignment.ui.main.interactor.MainInteractor
import org.junit.Assert.*

class AssignmentTest : MainView {
    override fun showData(cities: ArrayList<City>) {
    }

    private lateinit var interactor : MainInteractor


    private lateinit var databaseHelper : DataBaseHelper



    @Before
    fun setUp() {

        databaseHelper = DataBaseHelper(InstrumentationRegistry.getTargetContext())
        interactor = MainInteractor(databaseHelper)

    }

    @Test
    fun loadData() {
          val   total = interactor.loadCities().size
          assertEquals(272128,total)

    }
}