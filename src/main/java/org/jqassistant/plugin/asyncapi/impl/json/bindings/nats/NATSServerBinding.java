// SPDX-License-Identifier: Apache-2.0
package org.jqassistant.plugin.asyncapi.impl.json.bindings.nats;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.jqassistant.plugin.asyncapi.impl.json.bindings.ServerBinding;

/**
 * This object contains information about the server representation in NATS.
 *
 * @see <a href="https://github.com/asyncapi/bindings/blob/master/nats/README.md#server-binding-object">NATS Message</a>
 */
@Data
@Builder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class NATSServerBinding extends ServerBinding {}
