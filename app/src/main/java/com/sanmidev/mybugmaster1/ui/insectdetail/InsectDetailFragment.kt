package com.sanmidev.mybugmaster1.ui.insectdetail

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavArgs
import androidx.navigation.fragment.navArgs

import com.sanmidev.mybugmaster1.R
import com.sanmidev.mybugmaster1.databinding.InsectDetailFragmentBinding
import com.sanmidev.mybugmaster1.databinding.InsectDetailFragmentBindingImpl
import com.sanmidev.mybugmaster1.ui.initToolbarButton


class InsectDetailFragment : Fragment() {
    private var _insectDetailFragmentBinding: InsectDetailFragmentBinding? = null
    private val insectDetailFragmentBinding: InsectDetailFragmentBinding get() = _insectDetailFragmentBinding!!
    private lateinit var viewModel: InsectDetailViewModel

    private val args by navArgs<InsectDetailFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _insectDetailFragmentBinding = InsectDetailFragmentBindingImpl.inflate(inflater)
        initToolbarButton(
            "Insect Detail",
            insectDetailFragmentBinding.detailInsectToolbar,
            setBackButton = true,
            activity =
            requireActivity()
        )
        insectDetailFragmentBinding.insect = args.insect
        return insectDetailFragmentBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(InsectDetailViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
