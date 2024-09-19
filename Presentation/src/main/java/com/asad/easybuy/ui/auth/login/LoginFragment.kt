package com.asad.easybuy.ui.auth.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.asad.easybuy.databinding.FragmentLoginBinding
import com.asad.easybuy.ui.base.BaseFragment

class LoginFragment : BaseFragment<FragmentLoginBinding>() {
    override fun inflateLayout(layoutInflater: LayoutInflater): FragmentLoginBinding {
        return FragmentLoginBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        return binding.root
    }
}