package own.tdgroup.assignment.data.local

import android.content.Context
import android.database.sqlite.SQLiteDatabase

import android.util.Log
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import android.database.sqlite.SQLiteException
import android.database.sqlite.SQLiteOpenHelper
import own.tdgroup.assignment.data.entity.City
import java.sql.SQLException




class DataBaseHelper(private val myContext: Context) :
    SQLiteOpenHelper(myContext, DATABASE_NAME, null, DATABASE_VERSION) {
    private var myDataBase: SQLiteDatabase? = null


    //Create a empty database on the system
    @Throws(IOException::class)
    fun createDatabase() {

        val dbExist = checkDataBase()

        if (dbExist) {
            Log.v("DB Exists", "db exists")
            // By calling this method here onUpgrade will be called on a
            // writeable database, but only if the version number has been
            // bumped
            //onUpgrade(myDataBase, DATABASE_VERSION_old, DATABASE_VERSION);
        }

        val dbExist1 = checkDataBase()
        if (!dbExist1) {
            this.readableDatabase
            try {
                this.close()
                copyDataBase()
            } catch (e: IOException) {
                throw Error("Error copying database")
            }

        }

    }

    //Check database already exist or not
    private fun checkDataBase(): Boolean {
        var checkDB = false
        try {
            val myPath = DATABASE_PATH + DATABASE_NAME
            val dbfile = File(myPath)
            checkDB = dbfile.exists()
        } catch (e: SQLiteException) {
        }

        return checkDB
    }

    //Copies your database from your local assets-folder to the just created empty database in the system folder
    @Throws(IOException::class)
    private fun copyDataBase() {

        val mInput = myContext.assets.open(DATABASE_NAME)
        val outFileName = DATABASE_PATH + DATABASE_NAME
        val mOutput = FileOutputStream(outFileName)
        val mBuffer = ByteArray(2024)
        var length: Int = mInput.read(mBuffer)
        while (length > 0) {
            mOutput.write(mBuffer, 0, length)
            length = mInput.read(mBuffer)
        }
        mOutput.flush()
        mOutput.close()
        mInput.close()
    }

    //delete database
    fun db_delete() {
        val file = File(DATABASE_PATH + DATABASE_NAME)
        if (file.exists()) {
            file.delete()
            println("delete database file.")
        }
    }

    //Open database
    @Throws(SQLException::class)
    fun openDatabase() {
        val myPath = DATABASE_PATH + DATABASE_NAME
        myDataBase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READWRITE)
    }

    @Synchronized
    @Throws(SQLException::class)
    fun closeDataBase() {
        if (myDataBase != null)
            myDataBase!!.close()
        super.close()
    }

    override fun onCreate(db: SQLiteDatabase) {
        // TODO Auto-generated method stub

    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        if (newVersion > oldVersion) {
            Log.v("Database Upgrade", "Database version higher than old.")
            db_delete()
        }

    }

    fun getCities() : ArrayList<City>{
        createDatabase()

        val cities : ArrayList<City> = arrayListOf()
        val selectQuery = "SELECT  * FROM cities"


        val   cur = writableDatabase?.rawQuery(selectQuery, null)
        cur?.let {
            if (cur.moveToFirst()) {
                do {
                    val id = cur.getColumnIndex("id")
                    val country = cur.getColumnIndex("country")
                    val city = cur.getColumnIndex("city")
                    val population= cur.getColumnIndex("population")

                    cities.add(
                        City(
                            cur.getString(id),
                            cur.getString(country),
                            cur.getString(city),
                            cur.getInt(population)
                        )
                    )

                } while (cur.moveToNext());
            }
        }



        return cities

    }

    companion object {
        private val DATABASE_NAME = "utopia_cities.db"
        val DATABASE_PATH = "/data/data/own.tdgroup.assignment/databases/"
        val DATABASE_VERSION = 1
    }

}