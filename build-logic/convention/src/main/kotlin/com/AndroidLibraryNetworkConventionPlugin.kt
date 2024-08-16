package com
import com.android.build.api.dsl.LibraryExtension
import com.zalo.configureNetworking
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByType

class AndroidLibraryNetworkConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.library")
                apply("com.google.devtools.ksp")
            }
            val extension = extensions.getByType<LibraryExtension>()
            configureNetworking(extension)
        }
    }
}