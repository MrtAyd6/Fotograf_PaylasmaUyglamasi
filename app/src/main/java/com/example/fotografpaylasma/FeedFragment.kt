package com.example.fotografpaylasma

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import androidx.navigation.Navigation
import com.example.fotografpaylasma.databinding.FragmentFeedBinding


class FeedFragment : Fragment(), PopupMenu.OnMenuItemClickListener {
    private var _binding: FragmentFeedBinding? = null
    private val binding get() = _binding!!
    private lateinit var popup : PopupMenu

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFeedBinding.inflate(inflater,container,false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.floatingActionButton.setOnClickListener { floatingButtonTiklandi(it) }

        popup = PopupMenu(requireContext(),binding.floatingActionButton)
        val inflater = popup.menuInflater
        inflater.inflate(R.menu.my_popup_menu,popup.menu)
        popup.setOnMenuItemClickListener(this)
    }

    fun floatingButtonTiklandi(view: View){
        popup.show()
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onMenuItemClick(p0: MenuItem?): Boolean {
        if(p0?.itemId == R.id.yuklemeItem){
            val action = FeedFragmentDirections.actionFeedFragmentToYuklemeFragment()
            Navigation.findNavController(requireView()).navigate(action)
        }else if(p0?.itemId == R.id.cikisItem){
            val action = FeedFragmentDirections.actionFeedFragmentToKullaniciFragment()
            Navigation.findNavController(requireView()).navigate(action)
        }
        return true
    }
}