package com.papageorgiouk.licencechecker.ui.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import com.papageorgiouk.licencechecker.R
import com.papageorgiouk.licencechecker.domain.LicenceType
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainView {

    private val presenter by lazy { MainPresenter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.attachView(this)

        btnVerify.setOnClickListener {
            //  get the input and cast to Long, or null if not applicable
            val input = inputLicence.editText?.text
                    .toString()
                    .toLongOrNull()

            presenter.onVerifyClicked(input)
        }
    }

    override fun displaySuccess(licenceType: LicenceType) {
        runOnUiThread{
            AlertDialog.Builder(this).apply {
                setTitle(getString(R.string.success))
                setMessage(getString(R.string.you_have_a_licence, licenceType.toString()))
                setPositiveButton(getString(R.string.ok), null)
                create()
                show()
            }
        }

    }

    override fun displayFail() {
        runOnUiThread{
            AlertDialog.Builder(this).apply {
                setTitle(getString(R.string.error))
                setMessage(getString(R.string.not_valid_licence))
                setPositiveButton(getString(R.string.ok), null)
                create()
                show()
            }
        }
    }

    override fun displayNotValidInputError() {
        AlertDialog.Builder(this).apply {
            setTitle(getString(R.string.error))
            setMessage(getString(R.string.not_valid_input))
            setPositiveButton(getString(R.string.ok), null)
            create()
            show()
        }
    }
}
