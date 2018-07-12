package com.papageorgiouk.licencechecker.domain

data class Licence(val number: Long, val type: LicenceType) {
}

enum class LicenceType {
    LIMITED, PRO
}