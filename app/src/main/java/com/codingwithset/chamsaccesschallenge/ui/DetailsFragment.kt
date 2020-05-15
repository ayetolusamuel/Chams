package com.codingwithset.chamsaccesschallenge.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.codingwithset.chamsaccesschallenge.R
import com.codingwithset.chamsaccesschallenge.databinding.ActivityDetailBinding
import java.text.SimpleDateFormat


/**
 * A simple [DetailsFragment] class to handle
 * activity in details layout
 */
class DetailsFragment : Fragment() {
    private var _binding: ActivityDetailBinding? = null
    private val binding get() = _binding!!
    private lateinit var thread: Thread

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = ActivityDetailBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {

        super.onActivityCreated(savedInstanceState)
        binding.userList.setOnClickListener { view ->
            Navigation.findNavController(view).navigate(R.id.action_detailsFragment_to_userFragment)
        }

        val name = arguments?.getString(getString(R.string.name_data_bundle))
        binding.helloName.text = getString(R.string.hello_name_string, name)

        timeCountDown()

    }


    override fun onDestroy() {
        super.onDestroy()
       _binding = null
    }

    private fun timeCountDown() {
        thread = object : Thread() {
            @SuppressLint("SimpleDateFormat")
            override fun run() {
                super.run()
                try {
                    while (!isInterrupted) {
                        sleep(1000)
                        activity?.runOnUiThread {
                            val date = System.currentTimeMillis()
                            val format = SimpleDateFormat(getString(R.string.date_format_value))
                            val dateString = format.format(date)
                            binding.currentDate.text =
                                getString(R.string.current_time_string, dateString)

                        }
                    }

                } catch (exception: InterruptedException) {

                }
            }
        }
        thread.start()

    }



    override fun onDestroyView() {
        super.onDestroyView()
        val localThread = thread
        localThread.interrupt()

    }


}
