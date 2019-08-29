package own.tdgroup.assignment

import android.app.Application
import own.tdgroup.assignment.data.DataManager

class AssignmentApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object {
        lateinit var instance: AssignmentApplication
            private set
    }
}