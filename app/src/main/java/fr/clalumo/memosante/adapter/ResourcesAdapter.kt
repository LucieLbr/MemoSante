package fr.clalumo.memosante.adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import fr.clalumo.memosante.MainActivity
import fr.clalumo.memosante.R
import fr.clalumo.memosante.ResourcesModel

class ResourcesAdapter(
    private val context: MainActivity,
    private val imglist: List<ResourcesModel>,
    private val linklist: List<String>,
    private val layoutId: Int
) : RecyclerView.Adapter<ResourcesAdapter.ViewHolder>(){



    //boite pour ranger tous les composants à controler
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val resourcesImg = view.findViewById<ImageView>(R.id.image_resources)
        val resourcesName:TextView? = view.findViewById(R.id.name_resources)
        val resourcesLink:TextView? = view.findViewById(R.id.link_resources)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_vertical_resources_links,parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentimg=imglist[position]
        val currentlink=linklist[position]

        //utiliser glide pour recuperer l'image à partir de son lien
        Glide.with(context).load(Uri.parse(currentimg.imgUrl)).into(holder.resourcesImg)

        // mettre à jour les info de l'article
        holder.resourcesName?.text = currentimg.name
        holder.resourcesLink?.text = currentlink
    }

    override fun getItemCount(): Int = imglist.size
}