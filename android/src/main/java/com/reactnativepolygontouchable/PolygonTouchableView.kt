package com.reactnativepolygontouchable

import android.content.Context
import android.graphics.*
import android.view.MotionEvent
import android.view.View

class PolygonTouchableView(context: Context) : View(context) {
    private var path = Path()
    private var onTouchInside: (() -> Unit)? = null
    private val paint = Paint().apply {
        color = Color.YELLOW
        style = Paint.Style.FILL
        isAntiAlias = true
    }

    private var strokeColor = Color.BLACK
    private var strokeWidth = 2f

    fun setShape(points: String) {
        val pointList = points.trim().split(" ").mapNotNull {
            val (x, y) = it.split(",").mapNotNull(String::toFloatOrNull)
            PointF(x, y)
        }
        path.reset()
        if (pointList.isNotEmpty()) {
            path.moveTo(pointList[0].x, pointList[0].y)
            pointList.drop(1).forEach {
                path.lineTo(it.x, it.y)
            }
            path.close()
        }
        invalidate()
    }

    fun setFillColor(hexColor: String) {
        paint.color = Color.parseColor(hexColor)
        invalidate()
    }

    fun setStrokeColor(hexColor: String) {
        strokeColor = Color.parseColor(hexColor)
        invalidate()
    }

    fun setStrokeWidth(width: Float) {
        strokeWidth = width
        invalidate()
    }

    fun setOnTouchInsideListener(callback: () -> Unit) {
        onTouchInside = callback
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        paint.style = Paint.Style.FILL
        canvas.drawPath(path, paint)

        val strokePaint = Paint().apply {
            color = strokeColor
            style = Paint.Style.STROKE
            strokeWidth = this@PolygonTouchableView.strokeWidth
            isAntiAlias = true
        }
        canvas.drawPath(path, strokePaint)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        val region = Region()
        val bounds = RectF()
        path.computeBounds(bounds, true)
        region.setPath(path, Region(bounds.left.toInt(), bounds.top.toInt(), bounds.right.toInt(), bounds.bottom.toInt()))

        if (event.action == MotionEvent.ACTION_DOWN) {
            if (region.contains(event.x.toInt(), event.y.toInt())) {
                onTouchInside?.invoke()
                return true
            }
        }
        return false
    }
}