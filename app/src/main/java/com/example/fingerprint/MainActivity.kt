package com.example.fingerprint


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.biometric.BiometricPrompt
import androidx.core.content.ContextCompat

//API 23

//Poc - Proof of concept = utlizado para testar tecnologias


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

     if (BiometricHelper.isBiometricAvailable(this)){ //pedindo autenticação

        val executor = ContextCompat.getMainExecutor(this) // chamando o executor e aplicando a uma variável

         // usando as informações
         val bio = BiometricPrompt(this, executor, object : BiometricPrompt.AuthenticationCallback(){//callback vai ser executado quando algo tiver pronto, quando algo voltar pra mim

             //CASO A BIOMETRIA FUNCIONE ESSE CALLBACK NOS LEVARÁ PARA O PROXIMO PASSO
             override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
                 val s = "hello"
                 super.onAuthenticationSucceeded(result)
             }
         })


      val info = BiometricPrompt.PromptInfo.Builder() //PromptInfo são as informações que serão passadas para a biometria quando a autentificação for feita.
             .setTitle("Titulo")
             .setSubtitle("SubTitulo")
             .setDescription("descrição sobre algo")
             .setNegativeButtonText("Cancelar")
             .build()

         bio.authenticate(info)// autentificação feita para chamar as informações

     }

    }
}