package com.miguel.turotakehome

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.miguel.data.Business
import com.miguel.turotakehome.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val vm: MainViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        vm.beerState.observe(this, beerObserver)
        vm.pizzaState.observe(this, pizzaObserver)

        binding.beerRv.setup()
        binding.pizzaRv.setup()
    }

    private fun RecyclerView.setup() {
        setHasFixedSize(true)
        layoutManager = LinearLayoutManager(this@MainActivity)
        adapter = BusinessAdapter(layoutInflater)
    }

    private val pizzaObserver = Observer<LoadableResource<List<Business>>> {
        when (it) {
            is LoadableResource.Success -> {
                (binding.pizzaRv.adapter as BusinessAdapter).replace(it.result)
                togglePizzaVisibility(binding.pizzaRv)
            }
            LoadableResource.Loading -> {
                togglePizzaVisibility(binding.pizzaLoading)
            }
            is LoadableResource.Error -> {
                togglePizzaVisibility(binding.pizzaLoadingError)
                binding.pizzaLoadingError.text = it.message
            }
        }
    }
    private val beerObserver = Observer<LoadableResource<List<Business>>> {
        when (it) {
            is LoadableResource.Success -> {
                (binding.beerRv.adapter as BusinessAdapter).replace(it.result)
                toggleBeerVisibility(binding.beerRv)
            }
            LoadableResource.Loading -> {
                toggleBeerVisibility(binding.beerLoading)
            }
            is LoadableResource.Error -> {
                toggleBeerVisibility(binding.beerLoadingError)
                binding.beerLoadingError.text = it.message
            }
        }
    }

    private fun toggleBeerVisibility(element: View) {
        val visibility = booleanArrayOf(false, false, false)
        when (element) {
            binding.beerLoading -> visibility[0] = true
            binding.beerLoadingError -> visibility[1] = true
            binding.beerRv -> visibility[2] = true
        }
        binding.beerLoading.show(visibility[0])
        binding.beerLoadingError.show(visibility[1])
        binding.beerRv.show(visibility[2])
    }

    private fun togglePizzaVisibility(element: View) {
        val visibility = booleanArrayOf(false, false, false)
        when (element) {
            binding.pizzaLoading -> visibility[0] = true
            binding.pizzaLoadingError -> visibility[1] = true
            binding.pizzaRv -> visibility[2] = true
        }
        binding.pizzaLoading.show(visibility[0])
        binding.pizzaLoadingError.show(visibility[1])
        binding.pizzaRv.show(visibility[2])
    }
}

private fun View.show(show: Boolean) {
    visibility = if (show) View.VISIBLE else View.GONE
}
