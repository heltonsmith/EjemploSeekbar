package com.heltonbustos.nuevoscomponentes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import android.widget.Toast
import com.google.android.material.chip.Chip
import com.heltonbustos.nuevoscomponentes.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var bi: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bi = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bi.root)

        bi.grupoChip.setOnCheckedChangeListener { group, checkedId ->
            val chip = bi.grupoChip.findViewById<Chip>(checkedId)
            bi.grupoChip.removeView(chip)
        }

        bi.toogleButton.setOnClickListener {
            Toast.makeText(this, "Selección: ${bi.toogleButton.text}", Toast.LENGTH_SHORT).show()
        }

        bi.seekBar3.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {

            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                seekBar?.apply {
                    bi.tempLevel.text = when (progress) {
                        0 -> "Glacial"
                        1 -> "Páramo"
                        2 -> "Frío"
                        3 -> "Templado"
                        4 -> "Cálido"
                        else -> "Desconocido"
                    }
                }
            }


        })


    }


}