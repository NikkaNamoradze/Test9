package com.example.test9.utils

import androidx.recyclerview.widget.DiffUtil
import com.example.test9.model.LockScreenItems

class DiffUtils(
    private val newList: List<LockScreenItems>,
    private val oldList: List<LockScreenItems>
): DiffUtil.Callback() {
    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        oldList[oldItemPosition].number == newList[newItemPosition].number

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        oldList[oldItemPosition] == newList[newItemPosition]
}