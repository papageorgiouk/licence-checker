package com.papageorgiouk.licencechecker.ui.main

import com.papageorgiouk.licencechecker.domain.LicenceType
import com.papageorgiouk.licencechecker.ui.base.MvpView

interface MainView : MvpView {

    fun displaySuccess(licenceType: LicenceType)

    fun displayFail()

    fun displayNotValidInputError()
}