package com.codingwithset.chamsaccesschallenge.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.Navigation
import com.codingwithset.chamsaccesschallenge.R
import com.codingwithset.chamsaccesschallenge.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.submitButton.setOnClickListener {
            if (binding.edtName.text.isEmpty()) {
                binding.edtName.error = getString(R.string.empty_string)
            } else if (binding.edtName.text.toString().length <= 3) {
                binding.edtName.error = getString(R.string.character_length)
            } else {
                val name = binding.edtName.text.toString()
                val bundle = bundleOf(getString(R.string.name_data_bundle) to name)
                Navigation.findNavController(it)
                    .navigate(R.id.action_mainActivity2_to_detailsFragment, bundle)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}
