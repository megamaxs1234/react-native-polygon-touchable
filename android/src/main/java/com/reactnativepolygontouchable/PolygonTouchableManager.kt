package com.reactnativepolygontouchable

import com.facebook.react.uimanager.SimpleViewManager
import com.facebook.react.uimanager.ThemedReactContext
import com.facebook.react.uimanager.annotations.ReactProp
import com.facebook.react.uimanager.events.RCTEventEmitter

class PolygonTouchableManager : SimpleViewManager<PolygonTouchableView>() {
    override fun getName() = "PolygonTouchable"

    override fun createViewInstance(reactContext: ThemedReactContext): PolygonTouchableView {
        return PolygonTouchableView(reactContext).apply {
            setOnTouchInsideListener {
                reactContext.getJSModule(RCTEventEmitter::class.java)
                    .receiveEvent(id, "onPress", null)
            }
        }
    }

    @ReactProp(name = "shapePoints")
    fun setShape(view: PolygonTouchableView, points: String) {
        view.setShape(points)
    }

    @ReactProp(name = "fillColor")
    fun setFillColor(view: PolygonTouchableView, color: String) {
        view.setFillColor(color)
    }

    @ReactProp(name = "strokeColor")
    fun setStrokeColor(view: PolygonTouchableView, color: String) {
        view.setStrokeColor(color)
    }

    @ReactProp(name = "strokeWidth", defaultFloat = 2f)
    fun setStrokeWidth(view: PolygonTouchableView, width: Float) {
        view.setStrokeWidth(width)
    }
}