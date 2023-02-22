plugins {
    id "thunderbird.library.android"
    alias(libs.plugins.kotlin.parcelize)
}

dependencies {
    api project(":app:ui:base")
    debugImplementation project(":app:ui:setup")
    implementation project(":app:core")
    implementation project(":app:autodiscovery:api")
    implementation project(":app:autodiscovery:providersxml")
    implementation project(":mail:common")
    implementation project(":ui-utils:ToolbarBottomSheet")

    //TODO: Remove AccountSetupIncoming's dependency on these
    compileOnly project(":mail:protocols:imap")
    compileOnly project(":mail:protocols:webdav")

    implementation project(':plugins:openpgp-api-lib:openpgp-api')

    implementation libs.androidx.appcompat
    implementation libs.androidx.preference
    implementation libs.preferencex
    implementation libs.preferencex.datetimepicker
    implementation libs.preferencex.colorpicker
    implementation libs.androidx.recyclerview
    implementation project(':ui-utils:LinearLayoutManager')
    implementation project(':ui-utils:ItemTouchHelper')
    implementation libs.androidx.lifecycle.runtime.ktx
    implementation libs.androidx.lifecycle.viewmodel.ktx
    implementation libs.androidx.lifecycle.livedata.ktx
    implementation libs.androidx.constraintlayout
    implementation libs.androidx.localbroadcastmanager
    implementation libs.androidx.swiperefreshlayout
    implementation libs.ckchangelog.core
    implementation libs.tokenautocomplete
    implementation libs.safeContentResolver
    implementation libs.materialdrawer
    implementation libs.searchPreference
    implementation libs.fastadapter
    implementation libs.fastadapter.extensions.drag
    implementation libs.fastadapter.extensions.utils
    implementation libs.circleimageview
    api libs.appauth

    implementation libs.commons.io
    implementation libs.androidx.core.ktx
    implementation libs.jcip.annotations
    implementation libs.timber
    implementation libs.mime4j.core
    implementation libs.kotlinx.coroutines.core
    implementation libs.kotlinx.coroutines.android

    implementation libs.glide
    annotationProcessor libs.glide.compiler

    testImplementation project(':mail:testing')
    testImplementation project(':app:storage')
    testImplementation project(':app:testing')
    testImplementation libs.robolectric
    testImplementation libs.androidx.test.core
    testImplementation libs.kotlin.test
    testImplementation libs.kotlinx.coroutines.test
    testImplementation libs.turbine
}

android {
    namespace 'com.fsck.k9.ui'

    buildFeatures {
        buildConfig = true
    }

    buildTypes {
        debug {
            def useNewSetupUi = project.hasProperty('k9mail.useNewSetupUi') ? project.property('k9mail.useNewSetupUi') : "false"
            buildConfigField "boolean", "USE_NEW_SETUP_UI_FOR_ONBOARDING", useNewSetupUi

            manifestPlaceholders = ['appAuthRedirectScheme': 'FIXME: override this in your app project']
        }
        release {
            buildConfigField "boolean", "USE_NEW_SETUP_UI_FOR_ONBOARDING", "false"

            manifestPlaceholders = ['appAuthRedirectScheme': 'FIXME: override this in your app project']
        }
    }
}
