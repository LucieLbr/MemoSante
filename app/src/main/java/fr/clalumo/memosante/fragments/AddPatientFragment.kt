package fr.clalumo.memosante.fragments

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Spinner
import androidx.fragment.app.Fragment
import fr.clalumo.memosante.InfoModel
import fr.clalumo.memosante.InfoRepository
import fr.clalumo.memosante.InfoRepository.Singleton.downloadUri
import fr.clalumo.memosante.MainActivity
import fr.clalumo.memosante.R
import java.util.*

class AddPatientFragment(private val context: MainActivity): Fragment(){
    private var file: Uri? = null

    private var uploadedImage:ImageView?=null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater?.inflate(R.layout.fragment_add_patient, container, false)

        uploadedImage=view.findViewById(R.id.preview_image)
        val pickupImageButton=view.findViewById<Button>(R.id.upload_button)

        //
        pickupImageButton.setOnClickListener{
            pickupImage()
        }

        val confirmButton = view.findViewById<Button>(R.id.confirm_button)
        confirmButton.setOnClickListener{sendForm(view)}

        return view
    }

    private fun sendForm(view: View) {
        val repo=InfoRepository()
        //repo.uploadImage(file!!){
            val patientFirstName=view.findViewById<EditText>(R.id.firstname_input).text.toString()
            val patientName=view.findViewById<EditText>(R.id.name_input).text.toString()
            val sex=view.findViewById<Spinner>(R.id.sex_spinner).selectedItem.toString()
            val age=view.findViewById<EditText>(R.id.age_input).text.toString()
            val blood=view.findViewById<Spinner>(R.id.blood_spinner).selectedItem.toString()
            val downloadImageUri = downloadUri

            // creer un nouveau patient model
            val patient= InfoModel(
                UUID.randomUUID().toString(),
                patientFirstName,
                age,
                patientName,
                blood,
                sex, downloadImageUri.toString()
            )

            repo.insertPatient(patient)
        //}
    }

    private fun pickupImage(){
        val intent= Intent()
        intent.type="image/"
        intent.action=Intent.ACTION_GET_CONTENT
        startActivityForResult(Intent.createChooser(intent,"Select Picture"),47)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode==47 && resultCode== Activity.RESULT_OK){
            if(data==null || data.data==null) return

            file=data.data

            //mettre a jour l'apercu de l'image
            uploadedImage?.setImageURI(file)
        }
    }
}