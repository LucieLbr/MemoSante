package fr.clalumo.naturecollection.adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.android.material.expandable.ExpandableTransformationWidget
import fr.clalumo.naturecollection.MainActivity
import fr.clalumo.naturecollection.PlantModel
import fr.clalumo.naturecollection.R
import kotlin.coroutines.coroutineContext

class PlantAdapter(
    private val context: MainActivity,
    private val plantList: List<PlantModel>,
    private val layoutId: Int
) : RecyclerView.Adapter<PlantAdapter.ViewHolder>() {

    //boite pour ranger tous les composants à contrôler
    class ViewHolder(view : View) : RecyclerView.ViewHolder(view){
        //image de la plante
        val plantImage = view.findViewById<ImageView>(R.id.image_item)
        val plantName: TextView? = view.findViewById<TextView>(R.id.name_item)
        val plantDescription: TextView? = view.findViewById<TextView>(R.id.descritpion_item)
        val starIcon = view.findViewById<ImageView>(R.id.star_icon)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(layoutId, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // recuperer les info de la plante
        val currentPlant = plantList[position]

        // utiliser glide pour recuperer l'image à partie de son lien -> composant
        Glide.with(context).load(Uri.parse(currentPlant.imageUrl)).into(holder.plantImage)

        // mettre à jour le nom de la plante
        holder.plantName?.text = currentPlant.name

        // mettre à jour la description de la plante
        holder.plantDescription?.text = currentPlant.description

        // vérifier si la plante à été likeé
        if(currentPlant.liked) {
            holder.starIcon.setImageResource(R.drawable.ic_star)
        }
        else {
            holder.starIcon.setImageResource(R.drawable.ic_unstar)
        }
    }

    // nombre d'image dans le derouleur
    override fun getItemCount(): Int = plantList.size

}