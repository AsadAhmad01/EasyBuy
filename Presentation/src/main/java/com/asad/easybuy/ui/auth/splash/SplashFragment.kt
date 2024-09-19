package com.asad.easybuy.ui.auth.splash

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.asad.easybuy.databinding.FragmentSplashBinding
import com.asad.easybuy.ui.base.BaseFragment


class SplashFragment : BaseFragment<FragmentSplashBinding>() {
    override fun inflateLayout(layoutInflater: LayoutInflater): FragmentSplashBinding {
        return FragmentSplashBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        return binding.root
    }
}