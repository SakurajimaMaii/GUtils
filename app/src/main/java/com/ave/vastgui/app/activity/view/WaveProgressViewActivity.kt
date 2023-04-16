/*
 * Copyright 2022 VastGui guihy2019@gmail.com
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

package com.ave.vastgui.app.activity.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ave.vastgui.app.databinding.ActivityWaveProgressViewBinding
import com.ave.vastgui.tools.viewbinding.reflexViewBinding

class WaveProgressViewActivity : AppCompatActivity() {

    private val mBindings by reflexViewBinding(ActivityWaveProgressViewBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBindings.bottomSeekbar.addOnChangeListener{ _, value, _ ->
            mBindings.waveProgressView.setCurrentProgress(value)
        }
        mBindings.setStrokeRatio.addOnChangeListener{ _, value, _ ->
//            mBindings.waveProgressView.setStrokeRatio(value)
        }
        mBindings.setSpaceRatio.addOnChangeListener{ _, value, _ ->
//            mBindings.waveProgressView.setSpaceRatio(value)
        }
    }

}