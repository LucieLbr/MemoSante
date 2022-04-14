package fr.clalumo.memosante

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import fr.clalumo.memosante.RemindRepository.Singleton.dataBaseRef
import fr.clalumo.memosante.RemindRepository.Singleton.remindlist

class RemindRepository {

    //se connecter a la reference remind
    object Singleton {
        val dataBaseRef= FirebaseDatabase.getInstance().getReference("remind")
        val remindlist= arrayListOf<RemindModel>()
    }

    fun updateData(callback: ()-> Unit){
        dataBaseRef.addValueEventListener(object: ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                remindlist.clear()
                //recolter la liste
                for (ds in snapshot.children){
                    //construire un objet remind
                    val remind = ds.getValue(RemindModel::class.java)

                    //verifier que la remind n'est pas null
                    if(remind!=null) {
                        remindlist.add(remind)
                    }
                }
                callback()
            }

            override fun onCancelled(error: DatabaseError) {}
        })
    }

    fun updatePatient(remind: RemindModel ) = RemindRepository.Singleton.dataBaseRef.child(remind.id).setValue(remind)
    fun insertRemind(remind: RemindModel)= dataBaseRef.child(remind.id).setValue(remind)
    fun deleteRemind(remind:RemindModel)= dataBaseRef.child(remind.id).removeValue()

}