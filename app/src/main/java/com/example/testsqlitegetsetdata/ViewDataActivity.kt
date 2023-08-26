package com.example.testsqlitegetsetdata

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class ViewDataActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "Range", "SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_data)

        val nameView=findViewById<TextView>(R.id.NameView)
        val emailView=findViewById<TextView>(R.id.emailView)
        val userId=findViewById<TextView>(R.id.userIdView)
        val password=findViewById<TextView>(R.id.passwordView)
        val contact=findViewById<TextView>(R.id.contactView)
        val view=findViewById<Button>(R.id.view)


            view.setOnClickListener{

                // creating a DBHelper class
                // and passing context to it
                val db = DataBaseHelper(this, null)

                // below is the variable for cursor
                // we have called method to get
                // all names from our database
                // and add to name text view
                val cursor = db.getName()

                // moving the cursor to first position and
                // appending value in the text view
                cursor!!.moveToFirst()
                nameView.append(cursor.getString(cursor.getColumnIndex(DataBaseHelper.NAME_COl)) + "\n")
                emailView.append(cursor.getString(cursor.getColumnIndex(DataBaseHelper.EMAIL_COL)) + "\n")
                userId.append(cursor.getString(cursor.getColumnIndex(DataBaseHelper.USER_COL)) + "\n")
                password.append(cursor.getString(cursor.getColumnIndex(DataBaseHelper.PASS_COL)) + "\n")
                contact.append(cursor.getString(cursor.getColumnIndex(DataBaseHelper.CONTACT_COL)) + "\n")

                // moving our cursor to next
                // position and appending values
                while(cursor.moveToNext()){
                    nameView.append(cursor.getString(cursor.getColumnIndex(DataBaseHelper.NAME_COl)) + "\n")
                    emailView.append(cursor.getString(cursor.getColumnIndex(DataBaseHelper.EMAIL_COL)) + "\n")
                    userId.append(cursor.getString(cursor.getColumnIndex(DataBaseHelper.USER_COL)) + "\n")
                    password.append(cursor.getString(cursor.getColumnIndex(DataBaseHelper.PASS_COL)) + "\n")
                    contact.append(cursor.getString(cursor.getColumnIndex(DataBaseHelper.CONTACT_COL)) + "\n")

                }

                // at last we close our cursor
                cursor.close()
            }
    }
}