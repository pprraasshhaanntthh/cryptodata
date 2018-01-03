package com.antonicastejon.cryptodata.presentation.main

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.antonicastejon.cryptodata.R
import com.antonicastejon.cryptodata.presentation.main.crypto_list.CRYPTO_LIST_FRAGMENT_TAG
import com.antonicastejon.cryptodata.presentation.main.crypto_list.newCryptoListFragment
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject



class MainActivity : AppCompatActivity(), HasSupportFragmentInjector {
    @Inject
    lateinit var fragmentInjector: DispatchingAndroidInjector<Fragment>

    override fun supportFragmentInjector(): AndroidInjector<android.support.v4.app.Fragment> {
        return fragmentInjector
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
                .add(R.id.container, newCryptoListFragment(), CRYPTO_LIST_FRAGMENT_TAG)
                .commit()
    }
}