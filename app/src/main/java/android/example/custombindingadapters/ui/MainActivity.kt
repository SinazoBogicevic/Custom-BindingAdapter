package android.example.custombindingadapters.ui

import android.example.custombindingadapters.R
import android.example.custombindingadapters.data.ViewModel
import android.example.custombindingadapters.databinding.ActivityMainBinding
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    private lateinit var viewmodel: ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /**
         * create a viewmodel in on create so its created the first
         * time onCreate is called. After that the activity will have reference
         * to that same viewmodel
         */

        viewmodel = ViewModelProvider(this).get(ViewModel::class.java)

        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.lifecycleOwner = this

        binding.viewmodel = viewmodel

    }
}