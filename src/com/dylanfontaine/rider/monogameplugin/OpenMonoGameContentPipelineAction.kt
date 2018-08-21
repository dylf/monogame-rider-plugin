package com.dylanfontaine.rider.monogameplugin

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.CommonDataKeys


class OpenMonoGameContentPipelineAction : AnAction() {
    override fun actionPerformed(e: AnActionEvent?) {
       System.out.println("works")
        val filePath = e!!.getData(CommonDataKeys.VIRTUAL_FILE)!!.path
        Runtime.getRuntime().exec(getPipelineCommand() + filePath)
    }

    override fun update(e: AnActionEvent?) {
        val file = e!!.getData(CommonDataKeys.VIRTUAL_FILE)
        val visible = file != null && file.extension == "mgcb"
        e.presentation.setEnabledAndVisible(visible)
    }

    fun getPipelineCommand() : String {
        return "C:\\Program Files (x86)\\MSBuild\\MonoGame\\v3.0\\Tools\\Pipeline.exe"
    }
}