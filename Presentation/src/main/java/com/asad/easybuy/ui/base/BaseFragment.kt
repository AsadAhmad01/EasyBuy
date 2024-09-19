package com.asad.easybuy.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<VB : ViewBinding> : Fragment() {

    protected abstract fun inflateLayout(layoutInflater: LayoutInflater): VB

    val binding: VB by lazy { inflateLayout(layoutInflater) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View = binding.root
}