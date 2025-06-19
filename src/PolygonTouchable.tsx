import React from 'react';
import { requireNativeComponent, ViewStyle, StyleProp } from 'react-native';

type PolygonTouchableProps = {
  shapePoints: string;
  onPress?: () => void;
  onPressIn?: () => void;
  onPressOut?: () => void;
  fillColor?: string;
  strokeColor?: string;
  strokeWidth?: number;
  width?: number;
  height?: number;
  style?: StyleProp<ViewStyle>;
};

const PolygonTouchableNative = requireNativeComponent<PolygonTouchableProps>('PolygonTouchable');

export default function PolygonTouchable(props: PolygonTouchableProps) {
  return (
    <PolygonTouchableNative
      {...props}
      style={[{ width: props.width || 100, height: props.height || 100 }, props.style]}
    />
  );
}