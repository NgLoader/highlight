import React from 'react'
import { IconProps } from './types'

type Props = IconProps & {
	color?: string
	size?: number | string
	width?: number | string
	height?: number | string
}

export const IconStackedBarChart: React.FC<Props> = ({
	size,
	color,
	width,
	height,
}) => {
	if (size) {
		width = size
		height = size
	}
	width = width ?? 20
	height = height ?? 20
	color = color ?? 'currentColor'
	return (
		<svg
			width={width}
			height={height}
			viewBox="0 0 24 24"
			fill="none"
			xmlns="http://www.w3.org/2000/svg"
		>
			<path
				fillRule="evenodd"
				clipRule="evenodd"
				d="M17 2C15.3431 2 14 3.34315 14 5V6.17071C13.6872 6.06015 13.3506 6 13 6H11C9.34315 6 8 7.34315 8 9V10.1707C7.68722 10.0602 7.35064 10 7 10H5C3.34315 10 2 11.3431 2 13V19C2 20.6569 3.34315 22 5 22H7C7.76836 22 8.46924 21.7111 9 21.2361C9.53075 21.7111 10.2316 22 11 22H13C13.7684 22 14.4692 21.7111 15 21.2361C15.5308 21.7111 16.2316 22 17 22H19C20.6569 22 22 20.6569 22 19V5C22 3.34315 20.6569 2 19 2H17ZM10 19V14H14V19C14 19.5523 13.5523 20 13 20H11C10.4477 20 10 19.5523 10 19ZM14 12H10V9C10 8.44772 10.4477 8 11 8H13C13.5523 8 14 8.44772 14 9V12ZM7 12C7.55228 12 8 12.4477 8 13V15H4V13C4 12.4477 4.44772 12 5 12H7ZM4 19V17H8V19C8 19.5523 7.55228 20 7 20H5C4.44772 20 4 19.5523 4 19ZM16 19C16 19.5523 16.4477 20 17 20H19C19.5523 20 20 19.5523 20 19V10H16V19ZM16 8V5C16 4.44772 16.4477 4 17 4H19C19.5523 4 20 4.44772 20 5V8H16Z"
				fill={color}
			/>
		</svg>
	)
}