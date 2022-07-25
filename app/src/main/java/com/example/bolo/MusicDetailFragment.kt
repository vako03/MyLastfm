package com.example.bolo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.example.bolo.api.RetrofitBuilder
import com.example.bolo.databinding.FragmentMusicDetailsBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MusicDetailFragment:Fragment() {
    private  var _binding:FragmentMusicDetailsBinding? = null
    private  val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentMusicDetailsBinding.inflate(inflater,container,false)
        return binding.root


        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val id = requireArguments().getInt(KEY_TAG_PARA)
        CoroutineScope(IO).launch {
            val musicDetails = RetrofitBuilder.genreApi.getMusicDetails(id,MusicDetailFragment.KEY_TAG_PARA)
            withContext(Main){
                binding.ivAboutMovie.text = musicDetails.tag

            }
        }
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }
    companion object {
        const val KEY_TAG_PARA ="KEY_TAG_PARAM"
        fun  newInstence(tag: String):MusicDetailFragment{
            return  MusicDetailFragment().apply {
                arguments= bundleOf(KEY_TAG_PARA to  tag)
            }
        }
    }
}

