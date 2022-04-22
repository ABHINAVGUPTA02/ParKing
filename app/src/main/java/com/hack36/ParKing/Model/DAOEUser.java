package com.hack36.ParKing.Model;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class DAOEUser {
    private DatabaseReference databaseReference;
    public DAOEUser(){
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        databaseReference = db.getReference(user.class.getSimpleName());
    }
    public Task<Void> add(user user){
        return databaseReference.push().setValue(user);
    }
}
