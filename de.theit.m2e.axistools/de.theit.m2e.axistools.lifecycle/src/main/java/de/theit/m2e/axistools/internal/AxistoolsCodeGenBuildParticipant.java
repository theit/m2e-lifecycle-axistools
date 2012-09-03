/*
 * @(#)AxistoolsCodeGenBuildParticipant.java
 * Copyright (C)2011-2012 Thorsten Heit
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

import java.io.File;
import java.util.Set;

import org.apache.maven.plugin.MojoExecution;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.m2e.core.MavenPlugin;
import org.eclipse.m2e.core.embedder.IMaven;
import org.eclipse.m2e.core.project.configurator.MojoExecutionBuildParticipant;
import org.sonatype.plexus.build.incremental.BuildContext;

/**
 * Project configurator class for the Axistools code generator plugin.
 * 
 * @author <a href="mailto:theit@gmx.de">Thorsten Heit (theit@gmx.de)</a>
 * @since 28.06.2011 17:17:19
 * @version $Id$
 */
public class AxistoolsCodeGenBuildParticipant extends
		MojoExecutionBuildParticipant {
	/**
	 * Creates a new instance of this class.
	 * 
	 * @param execution
	 *            Mojo execution.
	 */
	public AxistoolsCodeGenBuildParticipant(MojoExecution execution) {
		super(execution, true);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.m2e.core.project.configurator.MojoExecutionBuildParticipant#build(int,
	 *      org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public Set<IProject> build(int kind, IProgressMonitor monitor)
			throws Exception {
		IMaven maven = MavenPlugin.getMaven();
		BuildContext buildContext = getBuildContext();

		// execute mojo
		Set<IProject> result = super.build(kind, monitor);

		// tell m2e builder to refresh generated files
		File generated = maven.getMojoParameterValue(getSession(),
				getMojoExecution(), "outputDirectory", File.class);
		if (null != generated) {
			buildContext.refresh(generated);
		}

		return result;
	}
}
