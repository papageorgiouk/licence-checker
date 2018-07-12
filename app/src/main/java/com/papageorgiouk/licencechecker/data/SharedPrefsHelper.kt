package com.papageorgiouk.licencechecker.data

import android.content.Context
import android.preference.PreferenceManager
import com.papageorgiouk.licencechecker.domain.Licence

class SharedPrefsHelper(val context: Context) {

    public fun saveLicence(licence: Licence) {
        PreferenceManager.getDefaultSharedPreferences(context.applicationContext)
                .edit()
                .putString(licence.number.toString(), licence.type.toString())
                .apply()
    }
}