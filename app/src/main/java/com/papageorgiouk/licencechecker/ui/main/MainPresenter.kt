package com.papageorgiouk.licencechecker.ui.main

import com.papageorgiouk.licencechecker.data.SharedPrefsHelper
import com.papageorgiouk.licencechecker.domain.Licence
import com.papageorgiouk.licencechecker.domain.LicenceListener
import com.papageorgiouk.licencechecker.domain.LicencesManager
import com.papageorgiouk.licencechecker.ui.base.BasePresenter

class MainPresenter : BasePresenter<MainActivity>() {

    fun onVerifyClicked(input: Long?) {
        if (input != null) {
            Thread(Runnable { checkLicence(input) }).start()  //  spawn a new thread to check the licence
        } else {
            view?.displayNotValidInputError()
        }
    }

    private fun checkLicence(input: Long) {
        LicencesManager.checkLicence(input, object : LicenceListener {
            override fun onLicenceResult(licence: Licence?) {
                if (licence == null) {  //  no licence found
                    view?.displayFail()
                } else {  // found licence, display success message and licence type
                    view?.let {
                        it.displaySuccess(licence.type)
                        SharedPrefsHelper(it.applicationContext).saveLicence(licence)  //  save to shared preferences
                    }

                }
            }
        })
    }
}