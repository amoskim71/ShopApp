package com.trantordev.shopapp.feature.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hannesdorfmann.mosby3.mvi.MviFragment
import com.trantordev.shopapp.network.model.Products
import io.reactivex.Observable
import org.koin.android.ext.android.get
import org.koin.android.ext.android.inject
import timber.log.Timber



class HomeFragment : MviFragment<HomeView, HomePresenter>(), HomeView {



    // TODO: Customize parameters
    private var columnCount = 1
    private var currentPage = 1;

    val homePresenter: HomePresenter by inject()

//    private var listener: OnListFragmentInteractionListener? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            columnCount = it.getInt(ARG_COLUMN_COUNT)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(com.trantordev.shopapp.R.layout.fragment_home, container, false)

        return view
    }

    override fun createPresenter() = HomePresenter(get())

    override fun initList(): Observable<Int> {
        return Observable.just(currentPage)
    }


    override fun render(viewState: HomeViewState) {
        Timber.d("render %s", viewState)
        if (viewState is HomeViewState.InitialState) {
            Timber.d("VIEWSTATEREDER: INITIAL ")
            renderInitial()
        }  else {
            throw IllegalArgumentException("Don't know how to render viewState $viewState")
        }
    }

    private fun renderResult(result: List<Products>) {
//        recyclerView.setVisibility(View.VISIBLE)
//        loadingView.setVisibility(View.GONE)
//        emptyView.setVisibility(View.GONE)
//        errorView.setVisibility(View.GONE)
//        adapter.setProducts(result)
//        adapter.notifyDataSetChanged()
    }

    private fun renderInitial() {
//        recyclerView.setVisibility(View.GONE)
//        loadingView.setVisibility(View.GONE)
//        errorView.setVisibility(View.GONE)
//        emptyView.setVisibility(View.GONE)
    }

    private fun renderLoading() {
//        recyclerView.setVisibility(View.GONE)
//        loadingView.setVisibility(View.VISIBLE)
//        errorView.setVisibility(View.GONE)
//        emptyView.setVisibility(View.GONE)
    }

    private fun renderError() {
//        recyclerView.setVisibility(View.GONE)
//        loadingView.setVisibility(View.GONE)
//        errorView.setVisibility(View.VISIBLE)
//        emptyView.setVisibility(View.GONE)
    }

    private fun renderEmptyResult() {
//        recyclerView.setVisibility(View.GONE)
//        loadingView.setVisibility(View.GONE)
//        errorView.setVisibility(View.GONE)
//        emptyView.setVisibility(View.VISIBLE)
    }




    override fun onAttach(context: Context) {
        super.onAttach(context)
//        if (context is OnListFragmentInteractionListener) {
//            listener = context
//        } else {
//            throw RuntimeException(context.toString() + " must implement OnListFragmentInteractionListener")
//        }
    }

    override fun onDetach() {
        super.onDetach()
    }


//    interface OnListFragmentInteractionListener {
//        // TODO: Update argument type and name
//        fun onListFragmentInteraction(item: DummyContent.DummyItem?)
//    }

    companion object {

        // TODO: Customize parameter argument names
        const val ARG_COLUMN_COUNT = "column-count"

        // TODO: Customize parameter initialization
        @JvmStatic
        fun newInstance(columnCount: Int) =
                HomeFragment().apply {
                    arguments = Bundle().apply {
                        putInt(ARG_COLUMN_COUNT, columnCount)
                    }
                }
    }

    // view adapter test rxjava test

}
