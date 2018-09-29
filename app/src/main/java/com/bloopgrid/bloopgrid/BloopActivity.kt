package com.bloopgrid.bloopgrid

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.view.ViewTreeObserver
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_bloop.*
import kotlinx.android.synthetic.main.view_bloop_cell.*
import android.content.Context.LAYOUT_INFLATER_SERVICE
import android.support.v4.content.ContextCompat.getSystemService
import android.view.LayoutInflater


class BloopActivity : AppCompatActivity() {

    val TAG = "BloopActivity"

    val cellSize = 100  // 100dp square

    val viewMatrix = mutableListOf<LinearLayout>()


    fun buildCell(inflater: LayoutInflater): View {
        val cellView = BloopCell(this)
        cellView.layoutParams = LinearLayout.LayoutParams(cellSize, cellSize)
        inflater.inflate(R.layout.view_bloop_cell, cellView, false)
        return cellView
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bloop)

//        initGrid(grid_container)
    }

    fun initGrid(containerWidth: Int, containerHeight: Int) {
        Log.i(TAG, "width: $containerWidth, height: $containerHeight")

        val numColumns = 10
        val numRows = 10

        var inflater = this.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        for (row in 0..numRows) {
            val rowLayout = LinearLayout(this)
            rowLayout.orientation = LinearLayout.HORIZONTAL

            rowLayout.weightSum = numColumns.toFloat()

            for (column in 0..numColumns) {
                val newCell = buildCell(inflater)
                rowLayout.addView(newCell)
                Log.i(TAG, "Creating row $row, column $column")
            }
            rowLayout.layoutParams = LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT)

        }
    }
}
