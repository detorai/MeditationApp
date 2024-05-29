package com.example.meditationapp.fragments



import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import com.example.meditationapp.R
import com.example.meditationapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navController = navHostFragment.navController

        binding.bottomNavView.setOnItemSelectedListener {

            when(it.itemId){
                R.id.mainFragment -> {
                    Toast.makeText(baseContext, "Sample", Toast.LENGTH_SHORT).show()
                    navController.navigate(R.id.mainFragment)
                    true
                }

                R.id.listenFragment -> {
                    Toast.makeText(baseContext, "listen", Toast.LENGTH_SHORT).show()
                    navController.navigate(R.id.listenFragment)
                    true

                } R.id.profileFragment -> {
                    Toast.makeText(baseContext, "listen", Toast.LENGTH_SHORT).show()
                    navController.navigate(R.id.profileFragment)
                    true
                }
                else -> false
            }
        }
        setContentView(binding.root)
    }
}







