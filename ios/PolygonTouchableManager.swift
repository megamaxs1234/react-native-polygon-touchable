import Foundation

@objc(PolygonTouchableManager)
class PolygonTouchableManager: RCTViewManager {
    override static func requiresMainQueueSetup() -> Bool {
        return true
    }

    override func view() -> UIView! {
        return PolygonTouchableView()
    }
}