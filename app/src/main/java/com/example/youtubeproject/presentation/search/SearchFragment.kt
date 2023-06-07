package com.example.youtubeproject.presentation.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.youtubeproject.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {

    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.searchButton.setOnClickListener {
            val keyWords = binding.searchEditText.text.toString().trim()
            if (keyWords.isEmpty()) {
                Toast.makeText(requireContext(), "No text provided!", Toast.LENGTH_SHORT).show()
            } else {
                findNavController().navigate(
                    SearchFragmentDirections.actionSearchFragmentToResultFragment(
                        keyWords
                    )
                )
            }
        }
    }

}