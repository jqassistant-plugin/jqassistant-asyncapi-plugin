// SPDX-License-Identifier: Apache-2.0
package org.jqassistant.plugin.asyncapi.impl.json.bindings.sns;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.jqassistant.plugin.asyncapi.impl.json.bindings.ServerBinding;

/**
 * This class MUST NOT contain any properties. Its name is reserved for future use.
 * <p>
 * Describes SNS server binding.
 *
 * @see <a href="https://github.com/asyncapi/bindings/blob/master/sns/README.md#server-binding-object">SNS Server binding</a>
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SNSServerBinding extends ServerBinding {}
