## react-native-polygon-touchable

A React Native native module for Android and iOS that renders complex shape (polygon) buttons with accurate touch filtering.

---

### 📦 Installation

```sh
npm install react-native-polygon-touchable
```

If using CocoaPods (iOS):
```sh
cd ios && pod install && cd ..
```

Then:
```sh
npx react-native run-android
npx react-native run-ios
```

---

### ✅ Autolinking Support

No manual native configuration is needed for React Native 0.60+.

---

### ✨ Props

| Prop         | Type     | Default   | Description                          |
|--------------|----------|-----------|--------------------------------------|
| `shapePoints`| `string` | required  | Format: "x1,y1 x2,y2 ..."            |
| `fillColor`  | `string` | `#FFD700` | Fill color of the polygon            |
| `strokeColor`| `string` | `#000000` | Stroke (border) color                |
| `strokeWidth`| `number` | `2`       | Border width                         |
| `width`      | `number` | `100`     | Width of the touchable view          |
| `height`     | `number` | `100`     | Height of the touchable view         |
| `onPress`    | `function`|          | Called when shape is pressed         |
| `onPressIn`  | `function`|          | Called when press starts             |
| `onPressOut` | `function`|          | Called when press ends               |

---

### 🧠 Usage

```tsx
import PolygonTouchable from 'react-native-polygon-touchable';

<PolygonTouchable
  shapePoints="50,5 61,39 98,39 68,61 79,95 50,75 21,95 32,61 2,39 39,39"
  fillColor="#FFD700"
  strokeColor="#FF8C00"
  strokeWidth={3}
  width={120}
  height={120}
  onPress={() => console.log('Star tapped!')}
  style={{ marginTop: 20 }}
/>
```

---

### 📄 License

MIT