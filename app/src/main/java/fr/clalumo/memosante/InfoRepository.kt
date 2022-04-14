package fr.clalumo.memosante

import fr.clalumo.memosante.InfoRepository.Singleton
import android.net.Uri
import com.google.android.gms.tasks.Continuation
import com.google.android.gms.tasks.Task
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import com.google.firebase.storage.UploadTask
import fr.clalumo.memosante.InfoRepository.Singleton.dataBaseRef
import fr.clalumo.memosante.InfoRepository.Singleton.downloadUri
import fr.clalumo.memosante.InfoRepository.Singleton.patientlist
import java.util.*


class InfoRepository {

    //se connecter a la reference patient
    object Singleton {
        //se connecter a notre espace de stockage
        //private val BUCKET_URL: String = "gs://memosante-bf245.appspot.com"
        //var storageReference: StorageReference = FirebaseStorage.getInstance().getReference("gs://memosante-bf245.appspot.com")

        //val storageReference = FirebaseStorage.getInstance().getReference("gs://memosante-bf245.appspot.com")
        val dataBaseRef=FirebaseDatabase.getInstance().getReference("patients")
        val patientlist= arrayListOf<InfoModel>()
        var downloadUri:Uri?=null
    }

    fun updateData(callback: ()-> Unit){
        dataBaseRef.addValueEventListener(object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                patientlist.clear()
                //recolter la liste
                for (ds in snapshot.children){
                    //construire un objet patient
                    val patient = ds.getValue(InfoModel::class.java)

                    //verifier que la plante n'est pas null
                    if(patient!=null) {
                        patientlist.add(patient)
                    }
                }
                callback()
            }

            override fun onCancelled(error: DatabaseError) {}
        })
    }

  /*fun uploadImage(file: Uri, callback: () -> Unit){
        if(file!=null){
            val fileName = UUID.randomUUID().toString() + ".jpg"
            val ref= storageReference.child(fileName)
            val uploadTask = ref.putFile(file)

            //demarrer la tache d'envoi
            uploadTask.continueWithTask(Continuation<UploadTask.TaskSnapshot, Task<Uri>> { task->
                    if(!task.isSuccessful){
                        task.exception?.let{throw it}
                    }
                return@Continuation ref.downloadUrl

                }).addOnCompleteListener{ task ->
                if(task.isSuccessful){
                    downloadUri= task.result
                    callback()
                }
            }
        }

    }*/

    fun updatePatient(patient: InfoModel ) = dataBaseRef.child(patient.id).setValue(patient)
    fun insertPatient(patient: InfoModel)= dataBaseRef.child(patient.id).setValue(patient)
    fun deletePatient(patient:InfoModel)= dataBaseRef.child(patient.id).removeValue()




}