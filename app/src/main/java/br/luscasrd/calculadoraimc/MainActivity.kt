package br.luscasrd.calculadoraimc

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListeners()
    }

    private fun setListeners(){
        alturaEDT?.doAfterTextChanged { text ->
            //Toast.makeText(this, text.toString(), Toast.LENGTH_SHORT).show()
        }


        calcPeso?.doOnTextChanged() { text, _, _, _ ->
            //titleImc.text = text
        }

        btnCalc?.setOnClickListener() {
            calcularIMC(calcPeso.text.toString(), alturaEDT.text.toString())
        }

    }

    private fun calcularIMC(peso: String, altura: String) {
        val peso = peso.toFloatOrNull()
        val altura = altura.toFloatOrNull()
        if (peso != null && altura !=null) {
            val imc = peso / (altura * altura)
            titleImc.text = "Seu IMC é de: \n$peso". format(imc)
        }
    }

}
