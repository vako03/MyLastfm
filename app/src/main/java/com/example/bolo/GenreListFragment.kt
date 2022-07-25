package com.example.bolo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bolo.api.RetrofitBuilder
import com.example.bolo.databinding.LayoutGenreListFragmentBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

class GenreListFragment : Fragment() {
    private var _binding: LayoutGenreListFragmentBinding? = null
    private val binding get() = _binding!!
    private val genreAdapter = GenreAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = LayoutGenreListFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvMovies.adapter = genreAdapter
        binding.rvMovies.layoutManager =
            LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
        CoroutineScope(IO).launch {
            val genreResponse = RetrofitBuilder.genreApi.getGenreMusics(API_KEY)
            withContext(Main){
                binding.progressBar.isVisible = false
                genreAdapter.updateAll(genreResponse.genre.tag) //?

            }
        }
                genreAdapter.setOnItemClickListener {
                    parentFragmentManager.beginTransaction().apply {
                        replace(R.id.flContent,MusicDetailFragment.newInstence(it.name))
                        addToBackStack(MusicDetailFragment::class.java.name)
                        commit()
                    }
                }
            }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }

    companion object{
        const val API_KEY = "8a0e338471e81bb0dffeaa37600d414b"
    }
}