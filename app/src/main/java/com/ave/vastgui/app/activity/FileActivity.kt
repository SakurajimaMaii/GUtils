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

package com.ave.vastgui.app.activity

import android.os.Bundle
import com.ave.vastgui.app.databinding.ActivityFileBinding
import com.ave.vastgui.tools.activity.VastVbActivity
import com.ave.vastgui.tools.activity.result.contract.GetMediaFileContract
import com.ave.vastgui.tools.manager.filemgr.FileMgr
import com.ave.vastgui.tools.manager.filemgr.FileMgr.appExternalCacheDir
import com.ave.vastgui.tools.manager.filemgr.FileMgr.appExternalFilesDir
import com.ave.vastgui.tools.manager.filemgr.FileMgr.appInternalCacheDir
import com.ave.vastgui.tools.manager.filemgr.FileMgr.appInternalFilesDir
import com.ave.vastgui.tools.manager.filemgr.FileMgr.saveFile
import com.ave.vastgui.tools.utils.LogUtils
import java.io.File


// Author: SakurajimaMai
// Email: guihy2019@gmail.com
// Date: 2022/5/31
// Description: 
// Documentation:

class FileActivity : VastVbActivity<ActivityFileBinding>() {

    private val openGalleryLauncher =
        registerForActivityResult(GetMediaFileContract()) {
            getBinding().video.apply {
                setVideoURI(it)
                start()
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        LogUtils.i(getDefaultTag(), appInternalFilesDir().path)
        LogUtils.i(getDefaultTag(), appInternalCacheDir().path)
        LogUtils.i(getDefaultTag(), appExternalFilesDir(null)?.path)
        LogUtils.i(getDefaultTag(), appExternalCacheDir()?.path)

        getBinding().openGallery.setOnClickListener {
            openGalleryLauncher.launch("image/*")
        }

        val res = FileMgr.deleteDir(File(appExternalFilesDir(null)?.path, "save.txt"))
        val res1 = saveFile(File(appExternalFilesDir(null)?.path,"save.txt"))

//        makeDir(File(appInternalFilesDir().path,"makeDir"))
//
//        makeDir(File(appInternalFilesDir().path,"makeDir2"))
//
//
//        val res1 = writeFile(File(appInternalFilesDir().path, "picture.jpg"),
//            object : FileMgr.WriteEventListener {
//                override fun writeEvent(fileWriter: FileWriter) {
//                    fileWriter.write("Hello")
//                }
//            })
//
//        LogUtils.i(getDefaultTag(), res1.toString())
//
//        val res2 = writeFile(File(appInternalFilesDir().path, "save.txt"),
//            object : FileMgr.WriteEventListener {
//                override fun writeEvent(fileWriter: FileWriter) {
//                    fileWriter.write("Hello")
//                }
//            })

//        LogUtils.i(getDefaultTag(), res2.toString())
    }
}