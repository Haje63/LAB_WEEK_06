package com.example.lab_week_06

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab_week_06.CatAdapter
import com.example.lab_week_06.GlideImageLoader
import com.example.lab_week_06.R
import com.example.lab_week_06.model.CatBreed
import com.example.lab_week_06.model.CatModel
import com.example.lab_week_06.model.Gender

class MainActivity : AppCompatActivity() {
    private val recyclerView: RecyclerView by lazy {
        findViewById(R.id.recycler_view)
    }
    private val catAdapter by lazy {
//Glide is used here to load the images
//Here we are passing the onClickListener function to the Adapter
        CatAdapter(layoutInflater, GlideImageLoader(this), object:
            CatAdapter.OnClickListener {
            //When this is triggered, the pop up dialog will be shown
            override fun onItemClick(cat: CatModel) = showSelectionDialog(cat)
        })
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//Setup the adapter for the recycler view
        recyclerView.adapter = catAdapter
//Setup the layout manager for the recycler view
//A layout manager is used to set the structure of the item views
//For this tutorial, we're using the vertical linear structure
        recyclerView.layoutManager = LinearLayoutManager(this,
            LinearLayoutManager.VERTICAL, false)

//Instantiate ItemTouchHelper for the swipe to delete callback and
//attach it to the recycler view
        val itemTouchHelper = ItemTouchHelper(catAdapter.swipeToDeleteCallback)
        itemTouchHelper.attachToRecyclerView(recyclerView)
//Add data to the model list in the adapter
        catAdapter.setData(
            listOf(
                CatModel(
                    Gender.Male,
                    CatBreed.BalineseJavanese,
                    "Fred",
                    "Silent and deadly",
                    "https://cdn2.thecatapi.com/images/7dj.jpg"
                ),
                CatModel(
                    Gender.Female,
                    CatBreed.ExoticShorthair,
                    "Wilma",
                    "Cuddly assassin",
                    "https://cdn2.thecatapi.com/images/egv.jpg"
                ),
                CatModel(
                    Gender.Unknown,
                    CatBreed.AmericanCurl,
                    "Curious George",
                    "Award winning investigator",
                    "https://cdn2.thecatapi.com/images/bar.jpg"
                ),
                CatModel(
                    Gender.Female,
                    CatBreed.BalineseJavanese,
                    "Daphne",
                    "Loves to nap in sunbeams",
                    "https://cdn2.thecatapi.com/images/d3p.jpg"
                ),
                CatModel(
                    Gender.Male,
                    CatBreed.AmericanCurl,
                    "Shadow",
                    "Master of stealth and purrs",
                    "https://cdn2.thecatapi.com/images/e62.jpg"
                ),
                CatModel(
                    Gender.Male,
                    CatBreed.ExoticShorthair,
                    "Marmalade",
                    "Sweet, fluffy, and clumsy",
                    "https://cdn2.thecatapi.com/images/154.jpg"
                ),
                CatModel(
                    Gender.Female,
                    CatBreed.BalineseJavanese,
                    "Cleo",
                    "A queen of the sofa",
                    "https://cdn2.thecatapi.com/images/15a.jpg"
                ),
                CatModel(
                    Gender.Unknown,
                    CatBreed.ExoticShorthair,
                    "Whisker",
                    "Always looking for trouble",
                    "https://cdn2.thecatapi.com/images/8r0.jpg"
                ),
                CatModel(
                    Gender.Male,
                    CatBreed.AmericanCurl,
                    "Zeus",
                    "A big cat with a big heart",
                    "https://cdn2.thecatapi.com/images/990.jpg"
                ),
                CatModel(
                    Gender.Female,
                    CatBreed.BalineseJavanese,
                    "Luna",
                    "Nighttime explorer",
                    "https://cdn2.thecatapi.com/images/15e.jpg"
                )
            )
        )
    }
//This will create a pop up dialog when one of the items from the recycler view is clicked.
    private fun showSelectionDialog(cat: CatModel) {
        AlertDialog.Builder(this)
//Set the title for the dialog
            .setTitle("Cat Selected")
//Set the message for the dialog
            .setMessage("You have selected cat ${cat.name}")
//Set if the OK button should be enabled
            .setPositiveButton("OK") { _, _ -> }.show()
    }
}
