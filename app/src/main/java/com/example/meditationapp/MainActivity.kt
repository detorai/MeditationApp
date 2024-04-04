package com.example.meditationapp



import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.meditationapp.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var bottomNav: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        loadFragment(MainFragment.newInstance())

        binding.bottomNavView.setOnClickListener {
            item -> val fragment: Fragment
            when (item.id) {
                R.id.main -> {
                    fragment = MainFragment()
                    loadFragment(fragment)
                    true
                }
                R.id.listening -> {
                    fragment = ListenFragment()
                    loadFragment(fragment)
                    true
                }
                else -> false
            }
        }
    }
    private fun loadFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}







