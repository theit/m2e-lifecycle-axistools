/*
 * @(#)AxistoolsCodeGenProjectConfigurator.java
 * Copyright (C)2011 Thorsten Heit
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.m2e.axistools.internal;

import java.io.File;

import org.apache.maven.plugin.MojoExecution;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.m2e.core.lifecyclemapping.model.IPluginExecutionMetadata;
import org.eclipse.m2e.core.project.IMavenProjectFacade;
import org.eclipse.m2e.core.project.configurator.AbstractBuildParticipant;
import org.eclipse.m2e.core.project.configurator.ProjectConfigurationRequest;
import org.eclipse.m2e.jdt.AbstractJavaProjectConfigurator;

/**
 * Project configurator class for the Axistools code generator plugin.
 * 
 * @author <a href="mailto:theit@gmx.de">Thorsten Heit (theit@gmx.de)</a>
 * @since 28.06.2011 17:17:19
 * @version $Id$
 */
public class AxistoolsCodeGenProjectConfigurator extends
		AbstractJavaProjectConfigurator {
	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2e.core.project.configurator.AbstractProjectConfigurator#getBuildParticipant(org.eclipse.m2e.core.project.IMavenProjectFacade,
	 *      org.apache.maven.plugin.MojoExecution,
	 *      org.eclipse.m2e.core.lifecyclemapping.model.IPluginExecutionMetadata)
	 */
	@SuppressWarnings("unused")
	@Override
	public AbstractBuildParticipant getBuildParticipant(
			IMavenProjectFacade projectFacade, MojoExecution execution,
			IPluginExecutionMetadata executionMetadata) {
		return new AxistoolsCodeGenBuildParticipant(execution);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2e.jdt.AbstractJavaProjectConfigurator#getSourceFolders(org.eclipse.m2e.core.project.configurator.ProjectConfigurationRequest,
	 *      org.apache.maven.plugin.MojoExecution)
	 */
	@Override
	protected File[] getSourceFolders(ProjectConfigurationRequest request,
			MojoExecution mojoExecution) throws CoreException {
		return getParameterValue("outputDirectory", File[].class,
				request.getMavenSession(), mojoExecution);
	}
}
