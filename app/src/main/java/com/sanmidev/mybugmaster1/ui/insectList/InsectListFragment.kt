package com.sanmidev.mybugmaster1.ui.insectList

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager

import com.sanmidev.mybugmaster1.data.Insect
import com.sanmidev.mybugmaster1.databinding.InsectListFragmentBinding

class InsectListFragment : Fragment() {


    private var _insectListFragmentBinding: InsectListFragmentBinding?  = null

    private val insectListFragmentBinding :  InsectListFragmentBinding get() = _insectListFragmentBinding!!

    private val insectOnClick :(insect : Insect) -> Unit = { insect  : Insect->
        findNavController().navigate(InsectListFragmentDirections.actionInsectListFragmentToInsectDetailFragment(insect))
    }

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

        initRecyclerview()
    }

    private fun initRecyclerview() {
        val adapter = InsectAdapter(requireContext(), insectOnClick)
        insectListFragmentBinding.insectListRecyclerview.adapter = adapter
        insectListFragmentBinding.insectListRecyclerview.layoutManager =
            LinearLayoutManager(requireContext())
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
