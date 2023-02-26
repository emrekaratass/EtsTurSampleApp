package com.example.etstursampleapp.ui.detail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.etstursampleapp.R
import com.example.etstursampleapp.databinding.FragmentDetailBinding
import com.example.etstursampleapp.util.Constants
import com.example.etstursampleapp.util.delegate.viewBinding
import com.example.etstursampleapp.util.extension.ignoreNull
import com.example.etstursampleapp.util.extension.loadImage
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment(R.layout.fragment_detail) {
    private val binding by viewBinding(FragmentDetailBinding::bind)
    private val movieArgs: DetailFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {

            imageButtonBack.setOnClickListener {
                findNavController().popBackStack()
            }

            imageView.loadImage("${Constants.imageUrl}${movieArgs.movieViewItem.posterPath}")
            imageViewFull.loadImage("${Constants.imageUrl}${movieArgs.movieViewItem.backDropPath}")

            textViewTitle.text = movieArgs.movieViewItem.name
            textViewVote.text = movieArgs.movieViewItem.voteAverage.toString()
            textViewCountry.text = movieArgs.movieViewItem.country
            textViewReleaseDate.text = movieArgs.movieViewItem.date
            textViewLongDescription.text = movieArgs.movieViewItem.description.ignoreNull()
        }
    }
}