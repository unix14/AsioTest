package com.eyalya.test.asiotech.ui

import android.os.Bundle
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.eyalya.test.asiotech.adapters.BagsAdapter
import com.eyalya.test.asiotech.databinding.FragmentBagsListBinding
import com.eyalya.test.asiotech.models.AlgResult
import com.eyalya.test.asiotech.models.ButtonState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BagsListFragment : Fragment() {
    //todo make mail

    private lateinit var adapter: BagsAdapter
    private lateinit var binding: FragmentBagsListBinding
    private val viewModel by viewModels<BagsListViewModel>()

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

    private fun initObservers() = with(viewModel) {
        bagsListData.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
        buttonState.observe(viewLifecycleOwner) {
            handleButton(it)
        }
        algResultData.observe(viewLifecycleOwner) {
            handleAlgResult(it)
        }
    }

    private fun handleAlgResult(result: AlgResult?) = with(binding){
        algorithmResult.text = result?.let {
            result.toString()
        } ?: run {
            ""
        }
    }

    private fun handleButton(state: ButtonState?) = with(binding) {
        when(state) {
            ButtonState.GONE -> {
                algCalculateBtn.visibility = View.GONE
            }
            ButtonState.INACTIVE -> {
                algCalculateBtn.visibility = View.VISIBLE
                bagsRecycler.visibility = View.VISIBLE
                algCalculateBtn.isActivated = false
            }
            ButtonState.ACTIVE -> {
                algCalculateBtn.visibility = View.VISIBLE
                bagsRecycler.visibility = View.VISIBLE
                algCalculateBtn.isActivated = true
            }
            else -> {}
        }
    }

    private fun initUi() = with(binding) {
        bagsRecycler.apply {
            layoutManager = LinearLayoutManager(requireContext())
            this@BagsListFragment.adapter = BagsAdapter()
            adapter = this@BagsListFragment.adapter
        }
        bagsCountInput.setOnEditorActionListener { v, actionId, event ->
            if (actionId == KeyEvent.KEYCODE_BACK) {
                refreshTable()
            }
            false
        }
        algCalculateBtn.setOnClickListener {
            calculateTrips()
        }
    }

    private fun refreshTable() = with(binding) {
        val amountOfBags = bagsCountInput.text.toString().toIntOrNull() ?: 0
        viewModel.refreshTable(amountOfBags)
    }

    private fun calculateTrips() = with(viewModel) {
        val bags = adapter.getBags()
        calculateTrips(bags)
    }
}