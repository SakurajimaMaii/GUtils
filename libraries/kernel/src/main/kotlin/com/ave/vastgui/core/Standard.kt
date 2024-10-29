/*
 * Copyright 2021-2024 VastGui
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ave.vastgui.core

import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.InvocationKind
import kotlin.contracts.contract

// Author: Vast Gui
// Email: guihy2019@gmail.com
// Date: 2024/10/28

/**
 * Calls the specified function [block] with not null receiver and returns
 * null.
 *
 * @since 0.1.2
 */
@OptIn(ExperimentalContracts::class)
inline fun <T> T?.letThenNull(crossinline block: (T) -> Unit): T? {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    this?.let { block(it) }
    return null
}