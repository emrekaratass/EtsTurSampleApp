package com.example.etstursampleapp.ui.main

import android.os.Bundle
import android.view.View
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.etstursampleapp.R
import com.example.etstursampleapp.databinding.FragmentMainBinding
import com.example.etstursampleapp.ui.main.MainFragmentDirections.actionMainFragmentToDetailFragment
import com.example.etstursampleapp.ui.main.adapter.MovieAdapter
import com.example.etstursampleapp.util.delegate.viewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment(R.layout.fragment_main) {
    private val binding by viewBinding(FragmentMainBinding::bind)
    private val viewModel: MainViewModel by viewModels()

    private val adapter: MovieAdapter by lazy {
        MovieAdapter {
            val directions = actionMainFragmentToDetailFragment(
                it
            )
            findNavController().navigate(directions)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUp()
        observeViewModel()
    }

    private fun setUp() {
        binding.recyclerView.adapter = adapter

        binding.editText.doAfterTextChanged {
            adapter.filter.filter(it)
        }
    }

    private fun observeViewModel() {
        viewModel.fetchMovie()

        viewModel.liveData.observe(viewLifecycleOwner) { state ->
            when (state) {
                is State.Success -> {
                    adapter.setList(state.data.results)
                }
                is State.Error -> {

                }
                else -> {
                    return@observe
                }
            }
        }
    }
}