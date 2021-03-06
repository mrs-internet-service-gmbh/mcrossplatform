/*
 * #%L
 * service
 * %%
 * Copyright (C) 2017 MRS Internet Service GmbH
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

package org.mcrossplatform.core.resource;

import java.io.File;
import java.io.FileInputStream;
import java.util.logging.LogManager;

public class LogConfigurationReader {
  private static final String LOGGING_PROPERTIES = "logging.properties";

  public static void readLogProperties() {
    readLogProperties(LOGGING_PROPERTIES);
  }

  /**
   * Read the given logging properties file for java.logging.
   * @param loggingProperties file name 
   */
  public static void readLogProperties(final String loggingProperties) {
    final File logProperties = FileResourceLocator.findFile(loggingProperties, true);
    if (logProperties != null) {
      try {
        LogManager.getLogManager().readConfiguration(new FileInputStream(logProperties));
      } catch (final Exception e) {
        throw new ResourceException(e);
      }
    } else {
      System.out.println(String.format("WARNING: Log properteis %s not found", loggingProperties));
    }
  }

  private LogConfigurationReader() {
    // private ctor
  }

}
