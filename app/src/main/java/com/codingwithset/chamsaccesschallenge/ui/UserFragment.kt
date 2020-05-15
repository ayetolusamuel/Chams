package com.codingwithset.chamsaccesschallenge.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.codingwithset.chamsaccesschallenge.data.DataSource
import com.codingwithset.chamsaccesschallenge.model.User
import com.codingwithset.chamsaccesschallenge.databinding.FragmentUserBinding

/**
 * A simple [UserFragment] that handle user list
 */
class UserFragment : Fragment() {
    private var _binding: FragmentUserBinding? = null
    private val binding get() = _binding!!
    private lateinit var data : List<User>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentUserBinding.inflate(layoutInflater)
        data = DataSource().userList
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.recyclerView.apply {
            adapter = UserAdapter(data)
            layoutManager = GridLayoutManager(context,2)

        }
    }
}
