package com.trantordev.shopapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.trantordev.shopapp.feature.product.ProductFragment
import com.trantordev.shopapp.feature.product.dummy.DummyContent
import com.trantordev.shopapp.feature.sample.SampleActivity
import com.trantordev.shopapp.network.api.ProductApi
import org.koin.android.ext.android.get
import org.koin.android.ext.android.inject
import org.koin.core.qualifier.named
import retrofit2.Retrofit
import timber.log.Timber

class MainActivity : AppCompatActivity(), ProductFragment.OnListFragmentInteractionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.container,  ProductFragment.newInstance(0))
                    .commitNow()
        }

        val myService: ProductApi by inject(named("retrofit_product_api"))

        Timber.d("INJECTION:"+myService.getProducts(1))

    }

    override fun onListFragmentInteraction(item: DummyContent.DummyItem?) {

        // TODO provisorio para chamar tela tirar depois
        val intent = Intent(
                this,
                SampleActivity::class.java
        )
        startActivity(intent)
    }
}