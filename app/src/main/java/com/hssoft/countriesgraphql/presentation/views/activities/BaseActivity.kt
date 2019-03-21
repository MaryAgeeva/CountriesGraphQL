package com.hssoft.countriesgraphql.presentation.views.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.WindowManager
import android.widget.Toast
import androidx.annotation.LayoutRes

abstract class BaseActivity : AppCompatActivity() {

    @LayoutRes abstract fun getLayoutResource(): Int

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON)
        setContentView(getLayoutResource())
    }

    protected fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
