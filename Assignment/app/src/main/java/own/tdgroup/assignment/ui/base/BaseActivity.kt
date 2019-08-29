package own.tdgroup.assignment.ui.base

import android.support.v7.app.AppCompatActivity

abstract class  BaseActivity : AppCompatActivity(),BaseView {
    override fun showLoading() {
    }

    override fun hideLoading() {
    }
}