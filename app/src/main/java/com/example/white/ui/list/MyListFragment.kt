package com.example.white.ui.list

import android.content.Intent
import android.widget.Toast
import com.example.white.R
import com.example.white.core.BaseFragment
import com.example.white.core.Failure
import com.example.white.core.ItemClickCallback
import com.example.white.data.entities.MyCharacter
import com.example.white.ui.adapters.MyCharactersAdapter
import com.example.white.ui.detail.DetailActivity
import kotlinx.android.synthetic.main.list_fragment.*
import org.koin.android.ext.android.inject

class MyListFragment : BaseFragment(), ItemClickCallback<MyCharacter> {
    private val viewModel: ListViewModel by inject()
    private lateinit var myCharactersAdapter: MyCharactersAdapter

    override fun layoutId(): Int {
        return R.layout.list_fragment
    }

    override fun initViews() {
        myCharactersAdapter = MyCharactersAdapter(this)
        rv.adapter = myCharactersAdapter
        swipe.setOnRefreshListener {
            viewModel.refresh()
            swipe.isRefreshing = false
        }
    }

    override fun observeViewModel() {
        viewModel.liveData.observe(viewLifecycleOwner) {
            myCharactersAdapter.addItems(it)
        }
        viewModel.failure.observe(viewLifecycleOwner) {
            if (it is Failure.UnknownError) {
                Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(requireContext(), getString(R.string.no_internet_connection), Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun OnItemClick(item: MyCharacter, position: Int) {
        startActivity(
            Intent(
                requireContext(),
                DetailActivity::class.java
            ).putExtra(DetailActivity.URL, item.img)
        )

    }

}