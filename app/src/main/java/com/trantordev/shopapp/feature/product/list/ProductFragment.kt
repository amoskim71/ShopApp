package com.trantordev.shopapp.feature.product.list

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hannesdorfmann.mosby3.mvi.MviFragment
import com.trantordev.shopapp.R

import com.trantordev.shopapp.feature.product.dummy.DummyContent
import com.trantordev.shopapp.feature.product.dummy.DummyContent.DummyItem
import com.trantordev.shopapp.network.model.Products
import io.reactivex.Observable
import org.koin.android.ext.android.get
import org.koin.android.ext.android.inject
import timber.log.Timber

/**
 * A fragment representing a list of Items.
 * Activities containing this fragment MUST implement the
 * [ProductFragment.OnListFragmentInteractionListener] interface.
 */
class ProductFragment : MviFragment<ProductView, ProductPresenter>(), ProductView {



    // TODO: Customize parameters
    private var columnCount = 1
    private var currentPage = 1;

    val productPresenter: ProductPresenter by inject()

    private var listener: OnListFragmentInteractionListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            columnCount = it.getInt(ARG_COLUMN_COUNT)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_product_list, container, false)

        // Set the adapter
        if (view is RecyclerView) {
            with(view) {
                layoutManager = when {
                    columnCount <= 1 -> LinearLayoutManager(context)
                    else -> GridLayoutManager(context, columnCount)
                }
                adapter = ProductAdapter(DummyContent.ITEMS, listener)
            }
        }
        return view
    }

    override fun createPresenter() = ProductPresenter(get())

    override fun searchIntent(): Observable<Int> {
        return Observable.just(currentPage)
    }


    override fun render(viewState: ProductViewState) {
        Timber.d("render %s", viewState)
        if (viewState is ProductViewState.InitialState) {
            Timber.d("VIEWSTATEREDER: INITIAL ")
            renderInitial()
            searchIntent()
        } else if (viewState is ProductViewState.LoadingState) {
            Timber.d("VIEWSTATEREDER: LOADING ")
            renderLoading()
        } else if (viewState is ProductViewState.SearchResultState) {
            Timber.d("VIEWSTATEREDER: SEARCHRESULT ")
            renderResult((viewState as ProductViewState.SearchResultState).result)
        } else if (viewState is ProductViewState.EmptyResultState) {
            Timber.d("VIEWSTATEREDER: EMPITYRESULT ")
            renderEmptyResult()
        } else if (viewState is ProductViewState.ErrorState) {
            Timber.d("VIEWSTATEREDER: ERROR ")
            Timber.e((viewState as ProductViewState.ErrorState).error)
            renderError()
        } else {
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
        if (context is OnListFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnListFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson
     * [Communicating with Other Fragments](http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */
    interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onListFragmentInteraction(item: DummyItem?)
    }

    companion object {

        // TODO: Customize parameter argument names
        const val ARG_COLUMN_COUNT = "column-count"

        // TODO: Customize parameter initialization
        @JvmStatic
        fun newInstance(columnCount: Int) =
                ProductFragment().apply {
                    arguments = Bundle().apply {
                        putInt(ARG_COLUMN_COUNT, columnCount)
                    }
                }
    }
}
