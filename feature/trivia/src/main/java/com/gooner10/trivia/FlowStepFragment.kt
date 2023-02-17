package com.gooner10.trivia

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

/**
 * A simple [Fragment] subclass.
 *
 */
class FlowStepFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
//        val safeArgs: FlowStepFragmentArgs by navArgs()

        // Inflate the layout for this fragment
//        return when (safeArgs.flowStepNumber) {
//            2 ->
                return inflater.inflate(R.layout.fragment_flow_step_two, container, false)
//            else ->
//                inflater.inflate(R.layout.fragment_flow_step_one, container, false)
//        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        view.findViewById<View>(R.id.next_button).setOnClickListener(
//                Navigation.createNavigateOnClickListener(R.id.next_action)
//        )
    }


}