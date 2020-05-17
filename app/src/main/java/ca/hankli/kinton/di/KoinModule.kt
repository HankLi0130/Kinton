package ca.hankli.kinton.di

import ca.hankli.kinton.repository.JsonParseRepo
import ca.hankli.kinton.repository.PointTransactionRepo
import ca.hankli.kinton.ui.main.MainViewModel
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

private val repositoryModule = module {
    single { JsonParseRepo(get()) }
    single { PointTransactionRepo() }
}

private val viewModelModule = module {
    viewModel { MainViewModel() }
    viewModel { MenuViewModel(get()) }
    viewModel { RewardViewModel(get(), get()) }
}

val appComponent = listOf(globalModule, repositoryModule, viewModelModule)