/*
 * @(#)AxistoolsCodeGenProjectConfigurator.java
 * Copyright (C)2011-2014 Thorsten Heit
 *
 * This file is licensed to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package de.theit.m2e.axistools.internal;

import org.apache.maven.plugin.MojoExecution;
import org.eclipse.m2e.core.lifecyclemapping.model.IPluginExecutionMetadata;
import org.eclipse.m2e.core.project.IMavenProjectFacade;
import org.eclipse.m2e.core.project.configurator.AbstractBuildParticipant;
import org.eclipse.m2e.jdt.AbstractSourcesGenerationProjectConfigurator;

/**
 * Project configurator class for the Axistools code generator plugin.
 * 
 * @author <a href="mailto:theit@gmx.de">Thorsten Heit (theit@gmx.de)</a>
 * @since 28.06.2011 17:17:19
 */
public class AxistoolsCodeGenProjectConfigurator extends
		AbstractSourcesGenerationProjectConfigurator {
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2e.core.project.configurator.AbstractProjectConfigurator#getBuildParticipant(org.eclipse.m2e.core.project.IMavenProjectFacade,
	 *      org.apache.maven.plugin.MojoExecution,
	 *      org.eclipse.m2e.core.lifecyclemapping.model.IPluginExecutionMetadata)
	 */
	@Override
	public AbstractBuildParticipant getBuildParticipant(
			IMavenProjectFacade projectFacade, MojoExecution execution,
			IPluginExecutionMetadata executionMetadata) {
		return new AxistoolsCodeGenBuildParticipant(execution);
	}
}
