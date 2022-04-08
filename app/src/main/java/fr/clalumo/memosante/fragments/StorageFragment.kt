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
import fr.clalumo.memosante.adapter.DocsAdapter
import fr.clalumo.memosante.adapter.ResourcesAdapter

class StorageFragment(private val context: MainActivity) : Fragment(){

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val docslist= arrayListOf<DocsModel>()
        val view = inflater?.inflate(R.layout.fragment_storage, container, false)

        docslist.add(
            DocsModel(
            "Ordonnance pilule",
            "doc1"
        ))
        docslist.add(
            DocsModel(
            "Préscription Kiné",
            "doc2"
        ))
        docslist.add(DocsModel(
            "Radio épaule",
            "doc3"
        ))
        docslist.add(DocsModel(
            "Certificat sport",
            "doc4"
        ))

        val pickupDocsButton=view.findViewById<Button>(R.id.upload_docs_button)
        pickupDocsButton.setOnClickListener{
            pickupDocs()
        }

        //recuper le recyclerview
        val verticalRecyclerView=view.findViewById<RecyclerView>(R.id.vertical_recycler_view)
        verticalRecyclerView.adapter= DocsAdapter(context,docslist, R.layout.item_vertical_storage_docs)

        return view
    }
    private fun pickupDocs() {
        val intent= Intent()
        intent.type="image/"
        intent.action= Intent.ACTION_GET_CONTENT
        startActivityForResult(Intent.createChooser(intent,"Select Picture"),47)
    }
}