package com.example.aqui_estoy

class ConstantsRestApi {
    companion object {
        const val idUser="632333ceca137c2c4b95168c"
        const val idPet="635716a5a2059dbd379482bb"
        const val idPublication="6388d999441e804fc380f4f5"
        const val URL_BASE = "https://aquiestoymongodb.azurewebsites.net/api/"
        const val URL_PET ="users/{idUser}/pets/{idPet}"
        const val URL_PUBLICATION ="users/{idUser}/lostPetsPosts/{idPublication}"
        const val URL_USER ="users/{idUser}"
    }
}
