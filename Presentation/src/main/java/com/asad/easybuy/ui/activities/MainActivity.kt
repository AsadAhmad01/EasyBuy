package com.asad.easybuy.ui.activities

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.activity.viewModels
import com.asad.easybuy.VMSettings
import com.asad.easybuy.databinding.ActivityMainBinding
import com.asad.easybuy.ui.base.BaseActivity
import com.google.gson.Gson
import com.google.gson.JsonParser
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun inflateViewBinding(inflater: LayoutInflater): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }


    private val viewModel: VMSettings by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val model = SettingsMD()
//        model.buildNo = BuildConfig.VERSION_NAME

        viewModel.callSettings((JsonParser.parseString(Gson().toJson(model)).asJsonObject))

        observers()
    }


    class SettingsMD {
        var buildNo = ""
        var isAndroid = "true"
    }

    private fun observers() {
        viewModel.isLoading.observe(this) {

        }

        viewModel.errorMsg.observe(this) {
            //
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
        }

        viewModel.settingsData.observe(this) {
            Toast.makeText(this, it.data.toString(), Toast.LENGTH_SHORT).show()
        }
    }
}