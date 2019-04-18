package com.trantordev.shopapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.trantordev.shopapp.feature.product.ProductFragment
import com.trantordev.shopapp.feature.product.dummy.DummyContent

class MainActivity : AppCompatActivity(), ProductFragment.OnListFragmentInteractionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container,  ProductFragment.newInstance(0))
                    .commitNow()
        }
    }

    override fun onListFragmentInteraction(item: DummyContent.DummyItem?) {
        // implementation
    }
}
