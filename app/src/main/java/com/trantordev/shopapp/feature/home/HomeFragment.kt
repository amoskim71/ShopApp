package com.trantordev.shopapp.feature.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hannesdorfmann.mosby3.mvi.MviFragment
import com.jakewharton.rxbinding2.view.clicks
import io.reactivex.Observable
import kotlinx.android.synthetic.main.fragment_home.*
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

    override fun showMessage(): Observable<String> {
        return Observable.just(editTextInput.toString())
    }

    override fun onButtonClick(): Observable<Unit> {
        return buttonEnviar.clicks()
    }




    override fun render(viewState: HomeViewState) {

        Timber.d("VIEWSTATEREDER: ENTROU 1 VEZ ")

        if (viewState is HomeViewState.MessageNotTypedYetState) {
            Timber.d("VIEWSTATEREDER: MESSAGE NOT TYPED YET ")
            renderMessageNotTypedYet()
        }  else if(viewState is HomeViewState.MessageContentState) {
            Timber.d("VIEWSTATEREDER: SHOW MESSAGE ")
            renderMessageOnScreen(viewState.content)
        }else if(viewState is HomeViewState.ButtonClickedState) {
            Timber.d("VIEWSTATEREDER: BUTTONCLICKED ")
            Observable.just(editTextInput.toString())
        }else {
            throw IllegalArgumentException("Don't know how to render viewState $viewState")
        }
    }

    private fun renderMessageOnScreen(message: String) {
        textViewTexto1.visibility = View.VISIBLE
        textViewTexto1.text = message
    }

    private fun renderMessageNotTypedYet() {
        textViewTexto1.visibility = View.GONE
        textViewTexto2.visibility = View.GONE
        textViewTexto3.visibility = View.GONE
        textViewTexto4.visibility = View.GONE
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
