import { LinkButton } from '@components/LinkButton'
import {
	Box,
	Callout,
	IconSolidSparkles,
	Stack,
	Text,
	vars,
} from '@highlight-run/ui'
import { useProjectId } from '@hooks/useProjectId'
import React from 'react'
const { DEMO_ERROR_URL } = import.meta.env

export const CompleteSetup = () => {
	const { projectId } = useProjectId()

	return (
		<Box margin="auto" style={{ maxWidth: 300 }}>
			<Callout
				title="Finish installing Highlight"
				icon={() => (
					<Box
						alignItems="center"
						borderRadius="5"
						display="flex"
						flexShrink={0}
						justifyContent="center"
						style={{
							backgroundColor:
								vars.theme.static.surface.sentiment.informative,
							height: 22,
							width: 22,
						}}
					>
						<IconSolidSparkles
							color={
								vars.theme.static.content.sentiment.informative
							}
						/>
					</Box>
				)}
			>
				<Box display="flex" flexDirection="column" gap="16">
					<Text color="moderate">
						View your app's errors by completing the setup process.
					</Text>
					<Stack gap="6" direction="row">
						<LinkButton
							to={`/${projectId}/setup`}
							trackingId="finish-setup-errors"
						>
							Finish setup
						</LinkButton>
						<LinkButton
							to={DEMO_ERROR_URL}
							trackingId="view-demo-error"
							kind="secondary"
							emphasis="low"
						>
							View demo error
						</LinkButton>
					</Stack>
				</Box>
			</Callout>
		</Box>
	)
}
