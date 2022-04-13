package fr.clalumo.memosante.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import fr.clalumo.memosante.DocsModel
import fr.clalumo.memosante.MainActivity
import fr.clalumo.memosante.R
import fr.clalumo.memosante.RemindModel
import fr.clalumo.memosante.adapter.DocsAdapter
import fr.clalumo.memosante.adapter.RemindAdapter

class RemindFragment(private val context: MainActivity) : Fragment(){

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val remindlist= arrayListOf<RemindModel>()
        val view = inflater?.inflate(R.layout.fragment_remind, container, false)

        remindlist.add(
            RemindModel(
                "rappel1",
                "Dentiste",
                "08/05/2022",
            ))
        remindlist.add(
            RemindModel(
                "rappel2",
                "Mamographie",
                "07/05/2022",
            ))
        remindlist.add(
            RemindModel(
                "rappel3",
                "Radio",
                "15/07/2022",
            ))
        remindlist.add(
            RemindModel(
                "rappel4",
                "Vaccin tétanos",
                "28/04/2022",
            ))
        remindlist.add(
            RemindModel(
                "rappel5",
                "Kiné",
                "05/06/2022",
            ))
        remindlist.add(
            RemindModel(
                "rappel6",
                "Prise de sang",
                "26/05/2022",
            ))
        remindlist.add(
            RemindModel(
                "rappel7",
                "Gynécologue",
                "22/10/2022",
            ))
        remindlist.add(
            RemindModel(
                "rappel8",
                "Electrocardiogramme",
                "08/08/2022",
            ))
        remindlist.add(
            RemindModel(
                "rappel9",
                "Vaccin papillomavirus",
                "11/06/2022",
            ))

        //recuper le recyclerview
        val verticalRecyclerView=view.findViewById<RecyclerView>(R.id.vertical_recycler_view)
        verticalRecyclerView.adapter= RemindAdapter(context,remindlist, R.layout.item_vertical_remind)

        return view
    }
}