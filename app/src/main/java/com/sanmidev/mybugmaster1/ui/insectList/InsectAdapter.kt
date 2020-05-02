package com.sanmidev.mybugmaster1.ui.insectList

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sanmidev.mybugmaster1.data.Insect
import com.sanmidev.mybugmaster1.databinding.InsectListItemBinding

class InsectAdapter(
    val context: Context,
    val insectOnClick: (insect: Insect) -> Unit
) : RecyclerView.Adapter<InsectAdapter.InsectViewHolder>() {

    private val insectList = mutableListOf<Insect>()


    inner class InsectViewHolder(val binding: InsectListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(insect: Insect, insectOnClick: (insect: Insect) -> Unit) {
            binding.insect = insect

            binding.root.setOnClickListener {
                insectOnClick.invoke(insect)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InsectViewHolder {
        val layoutInflater = LayoutInflater.from(context)

        val binding = InsectListItemBinding.inflate(layoutInflater)

        return InsectViewHolder(binding)

    }

    override fun getItemCount(): Int = insectList.size


    fun setInsectList(data: List<Insect>) {
        insectList.clear()
        insectList.addAll(data.toMutableList())
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: InsectViewHolder, position: Int) {
        holder.bind(insectList[position], insectOnClick)
    }
}