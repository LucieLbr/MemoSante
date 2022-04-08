package fr.clalumo.memosante.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import fr.clalumo.memosante.MainActivity
import fr.clalumo.memosante.R
import fr.clalumo.memosante.ResourcesModel
import fr.clalumo.memosante.adapter.ResourcesAdapter

class ResourcesFragment(
    private val context: MainActivity) : Fragment(){

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val imglist= arrayListOf<ResourcesModel>()
        val linklist= arrayListOf<String>()
        val view = inflater?.inflate(R.layout.fragment_resources, container, false)

        imglist.add(ResourcesModel(
            "La COVID19",
            "https://cdn.pixabay.com/photo/2020/03/27/04/33/coronavirus-4972480_960_720.jpg",
            "https://www.santepubliquefrance.fr/dossiers/coronavirus-covid-19"
        ))

        imglist.add(ResourcesModel(
            "Vaccin",
            "https://cdn.pixabay.com/photo/2021/08/26/18/17/vaccination-6576827_960_720.jpg",
            "https://www.santepubliquefrance.fr/determinants-de-sante/vaccination/documents/article/calendrier-vaccinal"
        ))

        imglist.add(ResourcesModel(
            "Mammographie",
            "https://cdn.pixabay.com/photo/2021/10/11/19/28/breast-cancer-6701684_960_720.jpg",
            "https://www.santepubliquefrance.fr/maladies-et-traumatismes/cancers/cancer-du-sein"

        ))

        imglist.add(
            ResourcesModel(
            "Dentiste",
            "https://cdn.pixabay.com/photo/2017/07/23/10/44/dentist-2530990_960_720.jpg",
            "https://www.santepubliquefrance.fr/docs/sante-bucco-dentaire-des-adultes2"
        ))

        imglist.add(ResourcesModel(
            "Sida",
            "https://cdn.pixabay.com/photo/2013/11/26/07/54/hiv-218541_960_720.jpg",
            "https://www.santepubliquefrance.fr/l-info-accessible-a-tous/vih-sida"
        ))

        imglist.add(ResourcesModel(
            "Myopie",
            "https://cdn.pixabay.com/photo/2015/09/07/12/06/glasses-928465_960_720.jpg",
            "https://www.santepubliquefrance.fr/docs/sortir-de-la-myopie-preventive"
        ))

        linklist.add("https://www.santepubliquefrance.fr/dossiers/coronavirus-covid-19")
        linklist.add("https://www.santepubliquefrance.fr/determinants-de-sante/vaccination/documents/article/calendrier-vaccinal")
        linklist.add("https://www.santepubliquefrance.fr/maladies-et-traumatismes/cancers/cancer-du-sein")
        linklist.add("https://www.santepubliquefrance.fr/docs/sante-bucco-dentaire-des-adultes2")
        linklist.add("https://www.santepubliquefrance.fr/l-info-accessible-a-tous/vih-sida")
        linklist.add("https://www.santepubliquefrance.fr/docs/sortir-de-la-myopie-preventive")

        //recuper le recyclerview
        val verticalRecyclerView=view.findViewById<RecyclerView>(R.id.vertical_recycler_view)
        verticalRecyclerView.adapter=ResourcesAdapter(context,imglist,linklist, R.layout.item_vertical_resources_links)

        return view
    }
}