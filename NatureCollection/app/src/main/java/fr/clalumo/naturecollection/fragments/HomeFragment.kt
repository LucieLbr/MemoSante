package fr.clalumo.naturecollection.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import fr.clalumo.naturecollection.MainActivity
import fr.clalumo.naturecollection.PlantModel
import fr.clalumo.naturecollection.R
import fr.clalumo.naturecollection.adapter.PlantAdapter
import fr.clalumo.naturecollection.adapter.PlantItemDecoration

class HomeFragment(
    private val context: MainActivity
) : Fragment () {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater?.inflate(R.layout.fragment_home, container, false)

        // créer une liste qui va stocker ces plantes
        val plantList = arrayListOf<PlantModel>()

        // enregistrer une première plante dans notre liste
        plantList.add(PlantModel(
            "Pins",
            "pins et pas pain",
            "https://cdn.pixabay.com/photo/2016/12/05/16/46/pine-1884335_960_720.jpg",
            false
        ))
        plantList.add(PlantModel(
            "Chêne",
            "chêne et pas chaîne",
            "https://cdn.pixabay.com/photo/2018/09/22/03/14/acorn-3694485_960_720.jpg",
            false
        ))
        plantList.add(PlantModel(
            "Saule Pleureur",
            "saule pleureur et pas sal parleur",
            "https://cdn.pixabay.com/photo/2019/04/19/21/14/weeping-willow-4140499_960_720.jpg",
            false
        ))
        plantList.add(PlantModel(
            "Bambou",
            "bambou et pas bam boum",
            "https://cdn.pixabay.com/photo/2017/12/19/21/08/bamboo-3028709_960_720.jpg",
            false
        ))
        plantList.add(PlantModel(
            "Palmier",
            "palmier et pas pannier",
            "https://cdn.pixabay.com/photo/2013/10/26/04/12/palm-200965_960_720.jpg",
            true
        ))
        plantList.add(PlantModel(
            "Succulente",
            "succulente et pas succulent",
            "https://cdn.pixabay.com/photo/2017/06/10/03/31/plant-2388901_960_720.jpg",
            false
        ))
        plantList.add(PlantModel(
            "Cactus",
            "cactus et pas lapsus",
            "https://cdn.pixabay.com/photo/2016/06/13/07/32/cacti-1453793_960_720.jpg",
            false
        ))
        plantList.add(PlantModel(
            "Fougère",
            "fougère et pas gougère",
            "https://cdn.pixabay.com/photo/2019/05/06/19/13/green-4183977_960_720.jpg",
            false
        ))
        plantList.add(PlantModel(
            "Aloe Vera",
            "aloe vera et pas aller dora",
            "https://cdn.pixabay.com/photo/2014/03/02/05/27/aloe-vera-277948_960_720.jpg",
            false
        ))
        plantList.add(PlantModel(
            "Lotus",
            "lotus et pas motus",
            "https://cdn.pixabay.com/photo/2014/04/07/16/51/leaves-318743_960_720.jpg",
            false
        ))

        //recupere le recyclerView
        val horizontalRecyclerView = view.findViewById<RecyclerView>(R.id.horizontal_recycler_view)
        horizontalRecyclerView.adapter = PlantAdapter(context, plantList, R.layout.item_hortizontal_plant)

        // recuperer le second recyclerView
        val verticalRecyclerView = view.findViewById<RecyclerView>(R.id.vertical_recycler_view)
        verticalRecyclerView.adapter = PlantAdapter(context, plantList, R.layout.item_vertical_plant)
        verticalRecyclerView.addItemDecoration(PlantItemDecoration())

        return view
    }

}