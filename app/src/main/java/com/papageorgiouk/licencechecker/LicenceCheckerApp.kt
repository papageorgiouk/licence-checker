package com.papageorgiouk.licencechecker

import android.app.Application
import com.papageorgiouk.licencechecker.domain.Licence
import com.papageorgiouk.licencechecker.domain.LicenceType
import com.papageorgiouk.licencechecker.domain.LicencesManager

class LicenceCheckerApp : Application() {

    override fun onCreate() {
        super.onCreate()

        createDummyLicences()
    }

    fun createDummyLicences() {
        LicencesManager.storeLicence(Licence(1234, LicenceType.LIMITED))
        LicencesManager.storeLicence(Licence(9876, LicenceType.PRO))
    }
}