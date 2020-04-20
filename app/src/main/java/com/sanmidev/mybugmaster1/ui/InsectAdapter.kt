package com.sanmidev.mybugmaster1.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sanmidev.mybugmaster1.data.Insect
import com.sanmidev.mybugmaster1.databinding.InsectListItemBinding

class InsectAdapter(val context : Context) : RecyclerView.Adapter<InsectAdapter.InsectViewHolder>() {

    private val insectList = mutableListOf<Insect>()


    inner class InsectViewHolder(val binding: InsectListItemBinding)  : RecyclerView.ViewHolder(binding.root){
        fun bind(insect : Insect){
            binding.insect = insect
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InsectViewHolder {
        val layoutInflater =LayoutInflater.from(context)

        val binding =   InsectListItemBinding.inflate(layoutInflater)

        return  InsectViewHolder(binding)

    }

    override fun getItemCount(): Int {
     return  insectList.size
    }

    fun setInsectList(data : List<Insect>){
        insectList.clear()
        insectList.addAll(data.toMutableList())
    }

    override fun onBindViewHolder(holder: InsectViewHolder, position: Int) {
            holder.bind(insectList[position])
    }
}