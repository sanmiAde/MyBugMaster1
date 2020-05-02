package com.sanmidev.mybugmaster1.ui.insectList

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager

import com.sanmidev.mybugmaster1.R
import com.sanmidev.mybugmaster1.databinding.InsectListFragmentBinding
import com.sanmidev.mybugmaster1.databinding.InsectListItemBinding

class InsectListFragment : Fragment() {


    private var _insectListFragmentBinding: InsectListFragmentBinding?  = null

    private val insectListFragmentBinding :  InsectListFragmentBinding get() = _insectListFragmentBinding!!

    private val viewModel: InsectListViewModel by lazy {
        ViewModelProvider(this).get(InsectListViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val inflater = LayoutInflater.from(requireContext())
        _insectListFragmentBinding = InsectListFragmentBinding.inflate(inflater)

        return insectListFragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

         val adapter = InsectAdapter(requireContext())
         insectListFragmentBinding.insectListRecyclerview.adapter = adapter
         insectListFragmentBinding.insectListRecyclerview.layoutManager = LinearLayoutManager(requireContext())
        viewModel.allInsects.observe(viewLifecycleOwner, Observer {
            adapter.setInsectList(it)
        })
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


    }

    override fun onDestroyView() {
        _insectListFragmentBinding = null
        super.onDestroyView()
    }
}
