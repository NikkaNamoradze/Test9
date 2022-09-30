package com.example.test9.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.test9.databinding.DeleteItemBinding
import com.example.test9.databinding.FingerprintItemBinding
import com.example.test9.databinding.NumberItemsBinding
import com.example.test9.model.LockScreenItems
import com.example.test9.model.listOfItems
import com.example.test9.utils.DiffUtils

class LockScreenAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var itemClicked: ((LockScreenItems) -> Unit)? = null
    var itemDeleteClicked: ((LockScreenItems) -> Unit)? = null

    companion object {
        const val NUMBER_ITEM = 1
        const val DELETE_ITEM = 2
        const val FINGERPRINT_ITEM = 3
    }

    inner class NumberViewHolder(private val binding: NumberItemsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind() {
            val model = listOfItems[adapterPosition]
            binding.buttonNumber.text = model.number.toString()
            binding.buttonNumber.setOnClickListener {
                itemClicked?.invoke(model)
            }
        }
    }

    inner class DeleteViewHolder(private val binding: DeleteItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind() {
            val model = listOfItems[adapterPosition]
            binding.buttonDelete.setOnClickListener {
                itemDeleteClicked?.invoke(model)
            }
        }
    }

    inner class FingerprintViewHolder(private val binding: FingerprintItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind() {
            val model = listOfItems[adapterPosition]
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            NUMBER_ITEM -> {
                NumberViewHolder(
                    NumberItemsBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
            DELETE_ITEM -> {
                DeleteViewHolder(
                    DeleteItemBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
            else -> {
                FingerprintViewHolder(
                    FingerprintItemBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is NumberViewHolder -> {
                holder.onBind()
            }
            is DeleteViewHolder -> {
                holder.onBind()
            }
            is FingerprintViewHolder -> {
                holder.onBind()
            }

        }
    }


    override fun getItemViewType(position: Int) = when {
        listOfItems[position].isDeleteButton == true -> {
            DELETE_ITEM
        }
        listOfItems[position].isFingerprint == true -> {
            FINGERPRINT_ITEM
        }
        else -> {
            NUMBER_ITEM
        }
    }

    override fun getItemCount() = listOfItems.size

    fun setData(list: List<LockScreenItems>) {
        val diffUtils = DiffUtils(listOfItems, list)
        val diffResult = DiffUtil.calculateDiff(diffUtils)
        listOfItems = list
        diffResult.dispatchUpdatesTo(this)
    }


}