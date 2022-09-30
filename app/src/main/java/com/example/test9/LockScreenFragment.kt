package com.example.test9

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.example.test9.adapter.LockScreenAdapter
import com.example.test9.databinding.FragmentLockScreenBinding
import com.example.test9.model.listOfItems


class LockScreenFragment :
    BaseFragment<FragmentLockScreenBinding>(FragmentLockScreenBinding::inflate) {

    private val correctPassword = listOf(0, 9, 3, 4)
    private val inputPassword = mutableListOf<Int>()

    private val lockScreenAdapter: LockScreenAdapter by lazy {
        LockScreenAdapter()
    }

    override fun start() {
        setUpRecycler()
        listener()
        progressChanges()
    }

    private fun setUpRecycler() {
        binding.lockScreeRecycler.layoutManager = GridLayoutManager(requireContext(), 3)
        binding.lockScreeRecycler.adapter = lockScreenAdapter
        lockScreenAdapter.setData(listOfItems)
    }

    private fun listener() {
        lockScreenAdapter.itemClicked = {
            inputPassword.add(it.number!!)
            progressChanges()
        }

        try {
            lockScreenAdapter.itemDeleteClicked = {
                if(inputPassword.size > 0){
                    inputPassword.removeLast()
                    progressChanges()
                }else{
                    Toast.makeText(context, "password is empty", Toast.LENGTH_SHORT).show()
                }

            }

        } catch (e: NoSuchElementException) {
            Toast.makeText(context, "password is empty", Toast.LENGTH_SHORT).show()
        }


    }

    private fun checker() {
        if (isEqual(inputPassword, correctPassword)) {
            Toast.makeText(context, "correct", Toast.LENGTH_SHORT).show()
            inputPassword.clear()
            progressChanges()
        } else if (inputPassword.size == 4 && !isEqual(inputPassword, correctPassword)) {
            Toast.makeText(context, "wrong password", Toast.LENGTH_SHORT).show()
            binding.progressCount.setBackgroundResource(R.drawable.none)
            inputPassword.clear()
            progressChanges()
        }
    }

    private fun progressChanges() {
        when (inputPassword.size) {
            1 -> {
                binding.progressCount.setBackgroundResource(R.drawable.one_input)
            }
            2 -> {
                binding.progressCount.setBackgroundResource(R.drawable.two_input)
            }
            3 -> {
                binding.progressCount.setBackgroundResource(R.drawable.three_input)
            }
            4 -> {
                binding.progressCount.setBackgroundResource(R.drawable.all_input)
                checker()
                inputPassword.clear()
            }
        }
    }

    private fun isEqual(first: List<Int>, second: List<Int>): Boolean {

        if (first.size != second.size) {
            return false
        }

        return first.zip(second).all { (x, y) -> x == y }
    }


}