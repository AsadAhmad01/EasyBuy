package com.asad.easybuy.ui.activities

import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import com.asad.easybuy.R
import com.asad.easybuy.VMSettings
import com.asad.easybuy.databinding.ActivityMainBinding
import com.asad.easybuy.ui.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {

    private lateinit var navController: NavController
    private val viewModel: VMSettings by viewModels()

    override fun inflateViewBinding(inflater: LayoutInflater): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setupNavigationGraph()

//        val model = SettingsMD()
//        model.buildNo = BuildConfig.VERSION_NAME

//        viewModel.callSettings((JsonParser.parseString(Gson().toJson(model)).asJsonObject))
//
//        observers()
    }

    private fun setupNavigationGraph() {
        // Obtain reference to the NavHostFragment
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
        // Get the NavController
        navController = navHostFragment.navController
        // Set up the ActionBar with the Navigation UI
//        setupActionBarWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }


//    class SettingsMD {
//        var buildNo = ""
//        var isAndroid = "true"
//    }
//
//    private fun observers() {
//        viewModel.isLoading.observe(this) {
//
//        }
//
//        viewModel.errorMsg.observe(this) {
//            //
//            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
//        }
//
//        viewModel.settingsData.observe(this) {
//            Toast.makeText(this, it.data.toString(), Toast.LENGTH_SHORT).show()
//        }
//    }
}