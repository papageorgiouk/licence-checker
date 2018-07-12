package com.papageorgiouk.licencechecker.domain

object LicencesManager {

    val licences: MutableList<Licence> = mutableListOf()

    fun storeLicence(licence: Licence) {
        licences.add(licence)
    }

    fun checkLicence(input: Long, listener: LicenceListener) {
        var licence: Licence? = null
        licences.forEach {
            if (input == it.number) {
                licence = it
                return@forEach
            }
        }

        listener.onLicenceResult(licence)
    }
}

interface LicenceListener {

    /**
     * Return the licence, or null if not valid
     */
    fun onLicenceResult(licence: Licence?)
}