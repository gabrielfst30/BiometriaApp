package com.example.fingerprint

import android.content.Context
import android.os.Build
import androidx.biometric.BiometricManager
import androidx.biometric.BiometricManager.Authenticators.BIOMETRIC_STRONG

class BiometricHelper {
    companion object { // para não precisar ficar instanciando a classe sempre
        fun isBiometricAvailable(context: Context):Boolean{ //perguntar se a biometria esta disponivel

           if(Build.VERSION.SDK_INT < Build.VERSION_CODES.M){ //validação para ver se a biometria funciona na versão minima versão da API
               return false
           }
           val biometricManager = BiometricManager.from(context) //obtive o gerenciador da biometria e atribuí a uma variável

          when (biometricManager.canAuthenticate(BIOMETRIC_STRONG)) { //perguntando se pode autenticar a biometria e definindo o nivel de acerto da biometria para strong
                 BiometricManager.BIOMETRIC_SUCCESS -> return true // retorna true se der bom
                 BiometricManager.BIOMETRIC_ERROR_NO_HARDWARE -> return false // mesmo que tenha a API, essa verificação existe para que caso o celular não tenha essa funcionalidade(hardware) retorne false
                 BiometricManager.BIOMETRIC_ERROR_HW_UNAVAILABLE -> return false //caso o hardware esteja quebrado retorna false
                 BiometricManager.BIOMETRIC_ERROR_NONE_ENROLLED -> return false // tem soft e hard, porém o usuário não cadastrou a biometria no proprio celular
          }

            return false //não caiu em nenhum desses valores, return false
        }


    }

}