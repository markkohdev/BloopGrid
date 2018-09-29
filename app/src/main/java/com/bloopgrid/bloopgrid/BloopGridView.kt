package com.bloopgrid.bloopgrid

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.Log
import android.view.View
import android.view.ViewGroup

class BloopGridView(context: Context?, attrs: AttributeSet?) : ViewGroup(context, attrs) {

    val TAG = "BloopCellGridView"

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)

    private val cellDarkColor = R.color.bloopCellInactive
    private val cellLightColor = R.color.bloopCellActive

    private val numColumns = 10
    private val numRows = 10
    private var cellSize: Int = 50

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)

        Log.d(TAG, "Width: $widthMeasureSpec, height: $heightMeasureSpec")
        cellSize = Math.min(widthMeasureSpec/numColumns, heightMeasureSpec/numRows)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        if (canvas != null) {
            drawGrid(canvas)
        }
    }

    private fun drawGrid(canvas: Canvas) {
        paint.color = resources.getColor(R.color.bloopCellInactive, null)
        paint.style = Paint.Style.FILL

        for (row in 0..numRows) {
            val yStart = row * cellSize
            val yEnd = yStart + cellSize
            for (column in 0..numColumns) {
                val xStart = column * cellSize
                val xEnd = xStart + cellSize
                val rect = Rect(xStart, yStart, xEnd, yEnd)
                canvas.drawRect(rect, paint)
            }

        }
    }

}