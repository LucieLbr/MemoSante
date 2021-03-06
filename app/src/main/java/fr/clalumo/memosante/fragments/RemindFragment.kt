package fr.clalumo.memosante.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import fr.clalumo.memosante.*
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
                "09",
                "30",
                "Guignen",
            ))
        remindlist.add(
            RemindModel(
                "rappel2",
                "Mamographie",
                "07/05/2022",
                "15",
                "15",
                "Rennes",
            ))
        remindlist.add(
            RemindModel(
                "rappel3",
                "Radio",
                "15/07/2022",
                "16",
                "45",
                "St Grégoire",
            ))
        remindlist.add(
            RemindModel(
                "rappel4",
                "Vaccin tétanos",
                "28/04/2022",
                "08",
                "00",
                "Tinténiac",
            ))
        remindlist.add(
            RemindModel(
                "rappel5",
                "Kiné",
                "05/06/2022",
                "17",
                "30",
                "Beaulieu",
            ))
        remindlist.add(
            RemindModel(
                "rappel6",
                "Prise de sang",
                "26/05/2022",
                "12",
                "00",
                "Guichen",
            ))
        remindlist.add(
            RemindModel(
                "rappel7",
                "Gynécologue",
                "22/10/2022",
                "10",
                "15",
                "Cesson Sévigné",
            ))
        remindlist.add(
            RemindModel(
                "rappel8",
                "Electrocardiogramme",
                "08/08/2022",
                "18",
                "00",
                "Gourin",
            ))
        remindlist.add(
            RemindModel(
                "rappel9",
                "Vaccin papillomavirus",
                "11/06/2022",
                "11",
                "15",
                "Bruz",
            ))

        // recuperer l'adresse du button
        val pickupUploadRemindButton=view.findViewById<Button>(R.id.upload_remind_button)
        // interastion lors d'un click sur le button
        pickupUploadRemindButton.setOnClickListener{
            // afficher la popup
            NewRemindPopup(RemindAdapter(context,remindlist, R.layout.item_vertical_remind)).show()
        }

        //recuper le recyclerview
        val verticalRecyclerView=view.findViewById<RecyclerView>(R.id.vertical_recycler_view)
        verticalRecyclerView.adapter= RemindAdapter(context,remindlist, R.layout.item_vertical_remind)

        return view
    }
}