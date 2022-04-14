package fr.clalumo.memosante

import android.app.Dialog
import android.net.Uri
import android.os.Bundle
import android.view.Window
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import fr.clalumo.memosante.adapter.DocsAdapter
import fr.clalumo.memosante.adapter.RemindAdapter

class DocsPopup (
    private val adapter : DocsAdapter,
    private val currentDoc: DocsModel,
) : Dialog(adapter.context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.popup_docs_details)
        setupComponents()
        setupCloseButton()
        setupDeleteButton()
    }

    private fun setupDeleteButton() {
        findViewById<ImageView>(R.id.docs_delete_button).setOnClickListener{
            // supprimer le rappel de la base de donné
        }
    }

    private fun setupCloseButton() {
        findViewById<ImageView>(R.id.docs_close_button).setOnClickListener {
            // fermer la fenetre
            dismiss()
        }
    }

    private fun setupComponents() {
        // actualiser l'image de l'ordonnance
        val docImage = findViewById<ImageView>(R.id.image_popup_doc)
        Glide.with(adapter.context).load(Uri.parse(currentDoc.image)).into(docImage)


        // actualiser le nom du document
        findViewById<TextView>(R.id.docs_popup_name).text = currentDoc.name
    }
}