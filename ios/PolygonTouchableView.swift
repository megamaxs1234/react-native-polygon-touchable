import UIKit

@objc(PolygonTouchableView)
class PolygonTouchableView: UIView {
    var shapePoints: [CGPoint] = []
    var fillColor: UIColor = .yellow
    var strokeColor: UIColor = .black
    var strokeWidth: CGFloat = 2

    override func draw(_ rect: CGRect) {
        guard shapePoints.count > 1 else { return }

        let path = UIBezierPath()
        path.move(to: shapePoints[0])
        for point in shapePoints.dropFirst() {
            path.addLine(to: point)
        }
        path.close()

        fillColor.setFill()
        path.fill()

        strokeColor.setStroke()
        path.lineWidth = strokeWidth
        path.stroke()
    }

    override func point(inside point: CGPoint, with event: UIEvent?) -> Bool {
        let path = UIBezierPath()
        guard shapePoints.count > 1 else { return false }
        path.move(to: shapePoints[0])
        for p in shapePoints.dropFirst() {
            path.addLine(to: p)
        }
        path.close()
        return path.contains(point)
    }

    @objc func setShapePoints(_ pointsString: NSString) {
        let pairs = pointsString.components(separatedBy: " ")
        shapePoints = pairs.compactMap { pair in
            let nums = pair.split(separator: ",").compactMap { CGFloat(Double($0) ?? 0) }
            return nums.count == 2 ? CGPoint(x: nums[0], y: nums[1]) : nil
        }
        setNeedsDisplay()
    }

    @objc func setFillColor(_ hex: NSString) {
        fillColor = UIColor(hex: hex as String)
        setNeedsDisplay()
    }

    @objc func setStrokeColor(_ hex: NSString) {
        strokeColor = UIColor(hex: hex as String)
        setNeedsDisplay()
    }

    @objc func setStrokeWidth(_ width: NSNumber) {
        strokeWidth = CGFloat(truncating: width)
        setNeedsDisplay()
    }
}