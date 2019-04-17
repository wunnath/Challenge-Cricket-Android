package com.woona.challengecricket

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.login_layout.*
import kotlinx.android.synthetic.main.signup_layout.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

//    @BindView(R.id.username_edit_text) lateinit var usernameEditText: EditText
//    @BindView(R.id.password_edit_text) lateinit var passwordEditText: EditText
//    @BindView(R.id.signup_email_edit_text) lateinit var signupEmailEditText: EditText
//    @BindView(R.id.signup_password_edit_text) lateinit var signupPasswordEditText: EditText
//    @BindView(R.id.signup_name_edit_text) lateinit var signupNameEditText: EditText

//
//    @BindView(R.id.login_button) lateinit var loginButton : Button
//    @BindView(R.id.sign_up_button) lateinit var signUpButton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        val toggle = ActionBarDrawerToggle(
            this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()
        nav_view.setNavigationItemSelectedListener(this)

        create_account_text_view.setOnClickListener{View -> showSignupView() }
        login_text_view.setOnClickListener{View -> showLoginView() }
        login_button.setOnClickListener{View -> onLoginButtonClick() }
        sign_up_button.setOnClickListener{View -> onSignupButtonClick() }

    }

    private fun onSignupButtonClick() {

    }

    private fun onLoginButtonClick() {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent);
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_home -> {
                showHomeView()
            }
            R.id.nav_signup -> {
                showSignupView()
            }
            R.id.nav_login -> {
                showLoginView()
            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    fun showHomeView() {
        landing_card_view.visibility = View.VISIBLE
        login_card_view.visibility = View.GONE
        signup_card_view.visibility = View.GONE
    }

    fun showLoginView() {
        landing_card_view.visibility = View.GONE
        login_card_view.visibility = View.VISIBLE
        signup_card_view.visibility = View.GONE
    }

    fun showSignupView() {
        landing_card_view.visibility = View.GONE
        login_card_view.visibility = View.GONE
        signup_card_view.visibility = View.VISIBLE
    }
}
