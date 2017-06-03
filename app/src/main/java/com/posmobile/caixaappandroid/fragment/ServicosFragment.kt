package com.posmobile.caixaappandroid.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.posmobile.caixaappandroid.R


/**
 * A simple [Fragment] subclass.
 */
class ServicosFragment : Fragment()
{
    companion object
    {
        fun newInstance() : ServicosFragment
        {
            return ServicosFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var view = inflater!!.inflate(R.layout.fragment_servicos, container, false)
        return view
    }

}