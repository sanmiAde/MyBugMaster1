package com.sanmidev.mybugmaster1.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.sanmidev.mybugmaster1.R
import com.sanmidev.mybugmaster1.utils.JsonUtils
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = [Insect::class], exportSchema = false, version = 1)
abstract class MyBugMasterDatabase : RoomDatabase() {

    abstract val insectDao: InsectDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: MyBugMasterDatabase? = null

        fun getDatabase(context: Context, scope: CoroutineScope): MyBugMasterDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MyBugMasterDatabase::class.java,
                    "my_bug_master_database"
                ).addCallback(SeedDatabseCallback(context, scope))
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }

    class SeedDatabseCallback(val context: Context, val scope: CoroutineScope) :
        RoomDatabase.Callback() {

        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)

            INSTANCE?.let { databse ->
                scope.launch {
                    val insectDao = databse.insectDao
                    val insectJson = JsonUtils.readFileFromRawDirectory(context, R.raw.insects)
                    insectDao.insertInsects(JsonUtils.convertJsonToInsects(insectJson))
                }
            }
        }
    }
}