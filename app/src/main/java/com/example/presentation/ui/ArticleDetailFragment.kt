package com.example.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.presentation.R
import com.example.presentation.databinding.ArticleListFragmentBinding
import kotlinx.android.synthetic.main.fragment_article_detail.view.*


class ArticleDetailFragment : Fragment() {

    val args: ArticleDetailFragmentArgs by navArgs()
    var mView: View? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_article_detail, container, false)
        return mView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.txtTitle.text = args.articleResult.title
        view.textBody.text = args.articleResult.abstactt
    }
}