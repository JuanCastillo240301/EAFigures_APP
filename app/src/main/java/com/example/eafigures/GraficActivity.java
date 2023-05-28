package com.example.eafigures;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.List;

public class GraficActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grafic);

        // Obtén la referencia del BarChart desde tu archivo de diseño
        BarChart chart = findViewById(R.id.chart);

// Crea una lista de enteros para representar el número de pedidos
        List<Integer> pedidos = new ArrayList<>();
        List<Integer> direcciones = new ArrayList<>();
        pedidos.add(3);
        pedidos.add(2);
        pedidos.add(3);
        pedidos.add(1);
        pedidos.add(4);
        pedidos.add(5);
        pedidos.add(2);
        pedidos.add(3);
        pedidos.add(1);
        pedidos.add(5);
        pedidos.add(2);
        pedidos.add(2);

        // Número de pedidos para un momento específico
         // Número de pedidos para otro momento específico
// Agrega más valores según sea necesario


        ArrayList<BarEntry> entries = new ArrayList<>();
        for (int i = 0; i < pedidos.size(); i++) {
            entries.add(new BarEntry(i, pedidos.get(i)));
        }


        BarDataSet dataSet = new BarDataSet(entries, "Número de Pedidos/Mes");
        BarData data = new BarData(dataSet);

// Configura colores adicionales para las barras si lo deseas
        dataSet.setColors(ColorTemplate.MATERIAL_COLORS);

// Establece el ancho de las barras si lo deseas
        data.setBarWidth(0.9f);

// Configura la animación de la gráfica
        chart.animateY(1000);

// Establece los datos en la gráfica
        chart.setData(data);

    }
}