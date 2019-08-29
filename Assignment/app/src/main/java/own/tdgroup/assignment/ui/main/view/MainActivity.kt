package own.tdgroup.assignment.ui.main.view

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import own.tdgroup.assignment.R
import own.tdgroup.assignment.data.entity.City
import own.tdgroup.assignment.data.local.DataBaseHelper
import own.tdgroup.assignment.ui.base.BaseActivity
import own.tdgroup.assignment.ui.main.presenter.MainPresenter
import own.tdgroup.assignment.ui.main.interactor.MainInteractor

class MainActivity : BaseActivity(), MainView {

    lateinit var presenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter = MainPresenter(this, MainInteractor(DataBaseHelper(this)))
        presenter.loadCities()

    }

    override fun showData(cities: ArrayList<City>) {
        runOnUiThread {
            val adapter = MainAdapter()
            recyclerView.layoutManager = LinearLayoutManager(this)
            recyclerView.adapter = adapter
            adapter.setData(cities)
        }

    }

}
