package edu.unikom.parsingapipubliksuperheroquiz2.presentation.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import edu.unikom.parsingapipubliksuperheroquiz2.presentation.ui.adapter.UserAdapter
import edu.unikom.parsingapipubliksuperheroquiz2.databinding.ActivityMainBinding
import edu.unikom.parsingapipubliksuperheroquiz2.presentation.ui.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    /*
    Nama  : Rexa Apriliandy Octaselena Rustam
    NIM   : 10122915
    Kelas : IF-13
    Waktu : 1 Agustus 2025
    QUIZ 2
     */

    private lateinit var binding: ActivityMainBinding
    private val viewModel by viewModels<MainViewModel>()
    private lateinit var adapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = UserAdapter()
        binding.rvUsers.layoutManager = LinearLayoutManager(this)
        binding.rvUsers.adapter = adapter

        viewModel.loadHeroes()

        viewModel.heroes.observe(this) { list ->
            adapter.setData(list)
        }

        viewModel.error.observe(this) { message ->
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        }
    }
}