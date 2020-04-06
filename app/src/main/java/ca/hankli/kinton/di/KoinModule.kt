package ca.hankli.kinton.di

import ca.hankli.kinton.ui.main.menu.MenuViewModel
import ca.hankli.kinton.ui.main.reward.RewardViewModel
import ca.hankli.kinton.util.json.adapter.IconResourceAdapter
import ca.hankli.kinton.util.json.adapter.PriceAdapter
import com.squareup.moshi.Moshi
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

private val globalModule = module {
    factory<Moshi> {
        Moshi.Builder()
            .add(IconResourceAdapter(androidContext()))
            .add(PriceAdapter())
            .build()
    }
}

private val viewModelModule = module {
    viewModel { MenuViewModel(get()) }
    viewModel { RewardViewModel(get()) }
}

val appComponent = listOf(globalModule, viewModelModule)