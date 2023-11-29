package com.eyalya.test.asiotech.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.eyalya.test.asiotech.databinding.FragmentBagsListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BagsListFragment: Fragment() {

    private lateinit var binding: FragmentBagsListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBagsListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initObservers()
        initUi()
    }

    private fun initObservers() /*= with(viewModel) */{

    }

    private fun initUi() =with(binding) {

    }

}