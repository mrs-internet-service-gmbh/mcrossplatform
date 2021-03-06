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

package org.mcrossplatform.core.transport.json;

import static org.junit.Assert.assertEquals;

public class StackTraceElementImplTest extends AbstractJsonSerializableTest<StackTraceElementImpl> {

  @Override
  protected Class<StackTraceElementImpl> getType() {
    return StackTraceElementImpl.class;
  }

  @Override
  protected StackTraceElementImpl createTestee() {
    return new StackTraceElementImpl("MyClass", "MyMethod", null, 42);
  }

  @Override
  protected void assertDeserializationResult(StackTraceElementImpl obj) {
    assertEquals("MyClass", obj.getDeclaringClass());
    assertEquals("MyMethod", obj.getMethodName());
    assertEquals(42, obj.getLineNumber());
  }
}
