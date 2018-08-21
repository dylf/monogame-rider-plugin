package com.dylanfontaine.rider.monogameplugin

import com.intellij.openapi.components.PersistentStateComponent
import com.intellij.openapi.components.State
import com.intellij.openapi.components.Storage
import com.intellij.openapi.components.ServiceManager
import com.intellij.util.xmlb.XmlSerializerUtil

@State( name = "MonoGame Storage", storages = [Storage("monogame.xml")])
class MonoGameSettings : PersistentStateComponent<MonoGameSettings>{

    override fun getState(): MonoGameSettings = this

    override fun loadState(state: MonoGameSettings) {
        XmlSerializerUtil.copyBean(state, this)
    }

    companion object {
        fun getInstance(): MonoGameSettings = ServiceManager.getService(MonoGameSettings::class.java)
    }
}