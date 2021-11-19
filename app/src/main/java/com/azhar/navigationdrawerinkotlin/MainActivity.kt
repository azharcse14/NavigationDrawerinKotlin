package com.azhar.navigationdrawerinkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var mDrawerLayout: DrawerLayout


    private lateinit var plusButton: AppCompatButton
    private lateinit var minusButton: AppCompatButton
    lateinit var sendButton: AppCompatButton
    private lateinit var quantityTv: AppCompatTextView
    lateinit var priceTv: AppCompatTextView

    private var price= 10

    var quantity = 1
    private var totalPrice:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.drawer_layout)

        plusButton= findViewById(R.id.plus_btn_id)
        minusButton= findViewById(R.id.minus_btn_id)
        quantityTv= findViewById(R.id.quantity_tv_id)
        priceTv= findViewById(R.id.price_tv_id)
        sendButton= findViewById(R.id.send_Btn_id)


        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        val actionbar: ActionBar? = supportActionBar
        actionbar?.apply {
            setDisplayHomeAsUpEnabled(true)
            setHomeAsUpIndicator(R.drawable.ic_menu)
        }

        mDrawerLayout = findViewById(R.id.drawer_layout)

        val navigationView: NavigationView = findViewById(R.id.navigationView)
        navigationView.setNavigationItemSelectedListener { menuItem ->
            // set item as selected to persist highlight
            menuItem.isChecked = true
            // close drawer when item is tapped
            mDrawerLayout.closeDrawers()

            // Handle navigation view item clicks here.
            when (menuItem.itemId) {

                R.id.nav_home -> {
                    startActivity(Intent(this, TestActivity::class.java))
                }
                R.id.nav_send -> {
                    Toast.makeText(this, "Wallet", Toast.LENGTH_LONG).show()
                }
                R.id.nav_share -> {
                    Toast.makeText(this, "Offer", Toast.LENGTH_LONG).show()
                }
                R.id.nav_gallery -> {
                    Toast.makeText(this, "Setting", Toast.LENGTH_LONG).show()
                }
            }
            // Add code here to update the UI based on the item selected
            // For example, swap UI fragments here

            true
        }


        quantityTv.text = quantity.toString()
        plusButton.setOnClickListener {

            quantity += 1

            quantityTv.text = quantity.toString()


            totalPrice= price*quantity
            priceTv.text = totalPrice.toString()

        }




        minusButton.setOnClickListener {

            quantity -= 1
            quantityTv.text = quantity.toString()
            totalPrice -= price
            priceTv.text = totalPrice.toString()

        }

        sendButton.setOnClickListener {
            val intent = Intent(this@MainActivity,TestActivity::class.java);
            intent.putExtra("totalPrice", totalPrice.toString())
            startActivity(intent);
        }

    }

    //appbar - toolbar button click
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                mDrawerLayout.openDrawer(GravityCompat.START)
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }


}