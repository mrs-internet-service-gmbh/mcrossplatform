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

import java.io.Closeable;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class ResourceCloser {
  private static final Logger LOGGER = Logger.getLogger(ResourceCloser.class.getName());

  private ResourceCloser() {
    // not instance
  }

  /**
   * Closes safely a Closeable.
   * @param c Closeable to close
   */
  public static void close(final Closeable c) {
    try {
      if (c != null) {
        c.close();
      }
    } catch (final IOException e) {
      LOGGER.log(Level.WARNING, String.format("Failed to close %s (may be already closed).", c), e);
    }
  }
}
