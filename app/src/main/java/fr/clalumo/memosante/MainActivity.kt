package fr.clalumo.memosante

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.Button
import androidx.appcompat.widget.ButtonBarLayout
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import fr.clalumo.memosante.fragments.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //charger notre infoRepository
        val repo=InfoRepository()
        repo.updateData{
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, HomeFragment(this))
            transaction.addToBackStack(null)
            transaction.commit()
        }

        //importer la bottomview navigation
        val navigationView= findViewById<BottomNavigationView>(R.id.navigation_view)
        navigationView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.home_page -> {
                    loadFragment(HomeFragment(this))
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.information_page -> {
                    loadFragment(AddPatientFragment(this))
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.remind_page -> {
                    loadFragment(RemindFragment(this))
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.resources_page -> {
                    loadFragment(ResourcesFragment(this))
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.storage_page -> {
                    loadFragment(StorageFragment(this))
                    return@setOnNavigationItemSelectedListener true
                }
                else -> false
            }
        }
    }
    private fun loadFragment(fragment: Fragment) {
        //injecter le fragment dans la boite
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }


}