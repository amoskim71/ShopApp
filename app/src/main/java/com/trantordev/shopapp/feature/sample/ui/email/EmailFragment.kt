package com.trantordev.shopapp.feature.sample.ui.email

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.trantordev.shopapp.R


class EmailFragment : Fragment() {

    private lateinit var emailViewModel: EmailViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        emailViewModel =
                ViewModelProviders.of(this).get(EmailViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_camera, container, false)
        val textView: TextView = root.findViewById(R.id.text_notifications)
        emailViewModel.text.observe(this, Observer {
            textView.text = it
        })
        return root
    }
}